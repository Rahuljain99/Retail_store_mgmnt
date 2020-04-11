/////////////advance for advance search on  employees


package dbsproject;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JList;
import javax.swing.JSpinner;
import javax.swing.JCheckBox;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class advance extends JFrame {

	private JPanel contentPane;
	private JTextField text1;
	private JTextField textField_1;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					advance frame = new advance();
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
	public advance() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAdvancedSearch = new JLabel("Advanced Search:");
		lblAdvancedSearch.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblAdvancedSearch.setBounds(10, 11, 226, 36);
		contentPane.add(lblAdvancedSearch);
		
		JLabel lblSearchEmployeesOn = new JLabel("Search Employees on:");
		lblSearchEmployeesOn.setBounds(27, 71, 126, 22);
		contentPane.add(lblSearchEmployeesOn);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				midsearch md = new midsearch();
				md.setVisible(true);
				setVisible(false);
			}
		});
		btnBack.setBounds(885, 627, 89, 23);
		contentPane.add(btnBack);
		
		
		JLabel lblSalary = new JLabel("Salary:");
		lblSalary.setBounds(37, 102, 46, 14);
		contentPane.add(lblSalary);
		

		JTextField text1 = new JTextField();
		text1.setBounds(47, 169, 126, 20);
		//contentPane.add(text1);
		text1.setColumns(10);
		
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
		comboBox.setBounds(47, 127, 106, 20);
		comboBox.setSelectedIndex(3);
		contentPane.add(comboBox);
		
		
		JLabel lblDesignation = new JLabel("Designation:");
		lblDesignation.setBounds(37, 284, 76, 14);
		contentPane.add(lblDesignation);
		
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
		comboBox_1.setBounds(47, 241, 106, 20);
		comboBox_1.setSelectedIndex(3);
		contentPane.add(comboBox_1);
		
		JLabel lblStore = new JLabel("Store:");
		lblStore.setBounds(37, 216, 46, 14);
		contentPane.add(lblStore);
		
		String[] samp = {"'Cashier'","'Salesman'","'Manager'"," "};
		
		JComboBox comboBox_2 = new JComboBox(samp);
		comboBox_2.setBounds(47, 310, 106, 20);
		comboBox_2.setSelectedIndex(3);
		contentPane.add(comboBox_2);
		
		JLabel lblAge = new JLabel("Age:");
		lblAge.setBounds(37, 353, 46, 14);
		contentPane.add(lblAge);
		
		JComboBox comboBox_3 = new JComboBox(sala);
		comboBox_3.setBounds(47, 378, 106, 20);
		comboBox_3.setSelectedIndex(3);
		contentPane.add(comboBox_3);
		
		textField_1 = new JTextField();
		textField_1.setBounds(47, 170, 126, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		
		
		textField = new JTextField();
		textField.setBounds(47, 422, 126, 22);
		contentPane.add(textField);
		textField.setColumns(10);
		

		JTextArea display = new JTextArea();
		display.setBackground(Color.LIGHT_GRAY);
		display.setBounds(261, 70, 685, 546);
		contentPane.add(display);

		JButton btnSearch = new JButton("Enter");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "vasto", "lorde");
					Statement stmt = con.createStatement();
					System.out.println("Connected.");
					String str1 = "";
					String and = " and ";
					if(textField_1.getText().equals(""));
					else {
					str1 = " salary " + text1.getText() + textField_1.getText();
					}
					String str2 = (String)comboBox_1.getSelectedItem();
					if(str2.equals(" ") || str2.equals(null));
					else {
						if(str1.equals("")|| str1.equals(null))
							str1 = str1+  "store_id = "+ str2;
						else
							str1 = str1 + and + "store_id = "+ str2;
					}
					String str3 = (String)comboBox_2.getSelectedItem();
					if(str3.equals(" ") || str3.equals(null));
					else {
						if(str1.equals("")|| str1.equals(null))
							str1 = str1+  "DESIGNATION = "+ str3;
						else
							str1 = str1 + and + "designation = "+ str3;
					}
					
					System.out.println(str1);
					ResultSet result = stmt.executeQuery("select * from employee where "+str1);
					String str = "";
					display.setText("");
					display.setFont(new Font("TimesNewRoman",Font.BOLD,20));
					display.append("SSN\t"+"DOB\t\t"+"DESIGNATION"+"STORE ID\t"+"FNAME\t"+"LNAME\t"+"Salary"+"\n\n");
					display.setFont(new Font("TimesNewRoman",Font.PLAIN,14));
					while(result.next())
					{
						str = result.getString(1)+"\t"+result.getString(2)+"\t"+result.getString(3)+"\t"+result.getString(4)+"\t"+result.getString(5)+"\t"+result.getString(6)+"\t"+result.getString(7)+ "\n";
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
		btnSearch.setBounds(162, 493, 89, 23);
		contentPane.add(btnSearch);
		
		
	}
}
