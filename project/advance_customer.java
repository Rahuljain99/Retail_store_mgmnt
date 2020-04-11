////////////advance_customer


package dbsproject;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextArea;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JComboBox;

public class advance_customer extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_2;
	private JTextField text1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					advance_customer frame = new advance_customer();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public advance_customer() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("Advanced Search:");
		label.setBounds(10, 11, 226, 36);
		label.setFont(new Font("Times New Roman", Font.BOLD, 25));
		contentPane.add(label);
		
		JTextArea display = new JTextArea();
		display.setBounds(261, 70, 678, 546);
		display.setBackground(Color.LIGHT_GRAY);
		contentPane.add(display);
		
		JLabel label_1 = new JLabel("Search Customers on:");
		label_1.setBounds(27, 71, 126, 22);
		contentPane.add(label_1);
		
		text1 = new JTextField();
		text1.setBounds(425, 24, 86, 20);
		text1.setColumns(10);
		
		
		JButton button = new JButton("Back");
		button.setBounds(885, 627, 89, 23);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				midsearch md = new midsearch();
				md.setVisible(true);
				setVisible(false);
			}
		});
		contentPane.add(button);
		
		JLabel lblProducts = new JLabel("Products:");
		lblProducts.setBounds(37, 104, 104, 14);
		contentPane.add(lblProducts);
		
		textField = new JTextField();
		textField.setBounds(47, 129, 106, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblStore = new JLabel("Store");
		lblStore.setBounds(37, 228, 46, 14);
		contentPane.add(lblStore);
		
		String[] ex_store = new String[5];
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "vasto", "lorde");
			Statement stmt = con.createStatement();
			System.out.println("Connected.");
			ResultSet result = stmt.executeQuery("select store_id from store");
			int i =0;
			while(result.next())
			{
				ex_store[i]= "'"+result.getString(1)+"'";
				i++;
			}
			for(;i<5;i++)
			{
				ex_store[i]= " ";
			}
			}
			catch(SQLException ex)
			{
				 System.out.println(ex);
			}
			catch (ClassNotFoundException ex) {
				
		        System.out.println(ex);			
		    }
		
		JComboBox comboBox_1 = new JComboBox(ex_store);
		comboBox_1.setBounds(47, 253, 106, 20);
		comboBox_1.setSelectedIndex(3);
		contentPane.add(comboBox_1);
		
		JLabel lblBill = new JLabel("Bill:");
		lblBill.setBounds(37, 382, 46, 14);
		contentPane.add(lblBill);
		
		String[] sala = {"Less than","Greater than","Equal to"," "};
		JComboBox comboBox = new JComboBox(sala);
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = comboBox.getSelectedIndex();
				switch(i)
				{
				case 0 : text1.setText("< "); break;
				case 1 : text1.setText("> "); break;
				case 2 : text1.setText("= "); break;
				}
			}
		});

		comboBox.setBounds(47, 411, 106, 20);
		comboBox.setSelectedIndex(3);
		contentPane.add(comboBox);
		
		textField_2 = new JTextField();
		textField_2.setBounds(46, 442, 107, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnEnter = new JButton("Enter");
		btnEnter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "vasto", "lorde");
					Statement stmt = con.createStatement();
					System.out.println("Connected.");
					String str1 = "";
					String and = " and ";
					if(textField.getText().equals("") ||textField.getText().equals(null));
					else
					{
						str1 = "product_id = "+textField.getText();
					}
					String str2 = (String)comboBox_1.getSelectedItem();
					if(str2.equals(" ") || str2.equals(null));
					else
					{
						if(str1.equals(""))
							str1 =  "from_store = "+str2;
						else
							str1 = str1 + and + "from_store = "+str2;
					}
					
					System.out.println(str1);
					ResultSet result = stmt.executeQuery("select customer_id,first_name,product_id,product_name,quantity,from_store,sprice from customer natural join purchases natural join product where "+str1);
					String str = "";
					display.setText("");
					display.setFont(new Font("TimesNewRoman",Font.BOLD,20));
					display.append("CustomerId\t"+"FirstName\t"+"ProductID\t"+"ProductName\t"+"Quantity\t"+"FromStore\t"+"SellP\t"+"\n\n");
					display.setFont(new Font("TimesNewRoman",Font.PLAIN,14));
					while(result.next())
					{
						str = result.getString(1)+"\t"+result.getString(2)+"\t"+result.getString(3)+"\t"+result.getString(4)+"\t"+result.getString(5)+"\t"+result.getString(6)+"\t"+result.getShort(7)+ "\n";
						display.append(str);
					}
					}
					catch(SQLException ex)
					{
						 System.out.println(ex);
					}
					catch (ClassNotFoundException ex) {
						
				        System.out.println(ex);			
				    }
			}
		});
		btnEnter.setBounds(162, 563, 89, 23);
		contentPane.add(btnEnter);
		
		
		
	}
}
