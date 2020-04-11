//////advance_supplier

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
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class advanced_supplier extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					advanced_supplier frame = new advanced_supplier();
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
	public advanced_supplier() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("Advanced Search:");
		label.setFont(new Font("Times New Roman", Font.BOLD, 25));
		label.setBounds(20, 11, 226, 36);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("Search Suppliers on:");
		label_1.setBounds(37, 71, 126, 22);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("Products:");
		label_2.setBounds(47, 104, 104, 14);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("Store");
		label_3.setBounds(47, 228, 46, 14);
		contentPane.add(label_3);
		
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
		
		JComboBox comboBox = new JComboBox(ex_store);
		comboBox.setBounds(57, 253, 106, 20);
		comboBox.setSelectedIndex(3);
		contentPane.add(comboBox);
		
		JTextArea display = new JTextArea();
		display.setBackground(Color.LIGHT_GRAY);
		display.setBounds(271, 70, 678, 546);
		contentPane.add(display);
		
		JButton button = new JButton("Enter");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
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
					String str2 = (String)comboBox.getSelectedItem();
					if(str2.equals(" ") || str2.equals(null));
					else
					{
						if(str1.equals(""))
							str1 =  "to_store = "+str2;
						else
							str1 = str1 + and + "to_store = "+str2;
					}
					
					System.out.println(str1);
					ResultSet result = stmt.executeQuery("select supplier_id,sup_fname,city,product_id,stock,to_store from supplier natural join supplies where "+str1);
					String str = "";
					display.setText("");
					display.setFont(new Font("TimesNewRoman",Font.BOLD,20));
					display.append("SupplierID\t"+"FirstName\t"+"City\t"+"ProductID\t"+"Quantity\t"+"ToStore\t"+"\n\n");
					display.setFont(new Font("TimesNewRoman",Font.PLAIN,14));
					while(result.next())
					{
						str = result.getString(1)+"\t"+result.getString(2)+"\t"+result.getString(3)+"\t"+result.getString(4)+"\t"+result.getString(5)+"\t"+result.getString(6)+"\n";
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
		button.setBounds(172, 563, 89, 23);
		contentPane.add(button);
		
		JButton button_1 = new JButton("Back");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				midsearch mds = new midsearch();
				mds.setVisible(true);
				setVisible(false);
			}
		});
		button_1.setBounds(895, 627, 89, 23);
		contentPane.add(button_1);
		
		textField = new JTextField();
		textField.setBounds(57, 129, 106, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		
	}

}
