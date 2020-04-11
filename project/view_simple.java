///////////view_simple


package dbsproject;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.DropMode;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import javax.swing.JList;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

public class view_simple extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					view_simple frame = new view_simple();
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
	public view_simple() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblOptions = new JLabel("Options:");
		lblOptions.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblOptions.setBounds(10, 11, 103, 29);
		contentPane.add(lblOptions);

		JTextArea display = new JTextArea();
		//JScrollPane scroll = new JScrollPane(display,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		display.setLineWrap(true);
		display.setWrapStyleWord(true);
		display.setBackground(Color.LIGHT_GRAY);
		display.setBounds(184, 51, 672, 465);
		
		//display.setWrapStyleWord(true);
		contentPane.add(display);
		contentPane.revalidate();
		//contentPane.add(display);
		
		
		JButton btnListEmployees = new JButton("List Employees");
		btnListEmployees.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "vasto", "lorde");
				Statement stmt = con.createStatement();
				System.out.println("Connected.");
				ResultSet result = stmt.executeQuery("select * from employee");
				String str = "";
				display.setText("");
				display.setFont(new Font("TimesNewRoman",Font.BOLD,20));
				display.append("SSN\t"+"DOB\t\t"+"DESIGNATION"+"STORE ID\t"+"FNAME\t"+"LNAME\t"+"Salary"+"\n\n");
				display.setFont(new Font("TimesNewRoman",Font.PLAIN,14));
				while(result.next())
				{
					str = result.getString(1)+"\t"+result.getString(2)+"\t"+result.getString(3)+"\t"+result.getString(4)+"\t"+result.getString(5)+"\t"+result.getString(6)+"/t"+result.getString(7)+ "\n";
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
		btnListEmployees.setBounds(20, 51, 144, 23);
		contentPane.add(btnListEmployees);
		
		JButton btnListCustomers = new JButton("List customers");
		btnListCustomers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "vasto", "lorde");
					Statement stmt = con.createStatement();
					System.out.println("Connected.");
					ResultSet result = stmt.executeQuery("select * from customer");
					String str = "";
					display.setText("");
					display.setFont(new Font("TimesNewRoman",Font.BOLD,20));
					display.append("CustomerID\t"+"Fname\t"+"Lname\t"+"Phone\t"+"Flat\t"+"Building\t"+"City"+"\n\n");
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
		btnListCustomers.setBounds(20, 106, 144, 23);
		contentPane.add(btnListCustomers);
		
		JButton btnNewButton = new JButton("Product Info");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "vasto", "lorde");
					Statement stmt = con.createStatement();
					System.out.println("Connected.");
					ResultSet result = stmt.executeQuery("select * from product natural join instore");
					String str = "";
					display.setText("");
					display.setFont(new Font("TimesNewRoman",Font.BOLD,20));
					display.append("ProductID\t"+"Product Name\t"+"Selling Price\t"+"Cost Price\t"+"StoreID\t"+"Availabilty"+"\n\n");
					display.setFont(new Font("TimesNewRoman",Font.PLAIN,14));
					while(result.next())
					{
						str = result.getString(1)+"\t"+result.getString(2)+"\t\t"+result.getString(3)+"\t"+result.getString(4)+"\t"+result.getString(5)+"\t"+result.getString(6)+ "\n";
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
		btnNewButton.setBounds(20, 158, 144, 23);
		contentPane.add(btnNewButton);
		
		JButton btnStores = new JButton("Stores");
		btnStores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "vasto", "lorde");
					Statement stmt = con.createStatement();
					System.out.println("Connected.");
					ResultSet result = stmt.executeQuery("select * from store");
					String str = "";
					display.setText("");
					display.setFont(new Font("TimesNewRoman",Font.BOLD,20));
					display.append("StoreID\t"+"Phone No\t"+"Street\t"+"City\t"+"State\t"+"ZIP\t"+"ManagerID"+"\n\n");
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
		btnStores.setBounds(20, 264, 144, 23);
		contentPane.add(btnStores);
		
		JButton btnProfit = new JButton("Profit");
		btnProfit.setBounds(20, 321, 144, 23);
		contentPane.add(btnProfit);
		
		JButton btnStockIn = new JButton("Stock In");
		btnStockIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "vasto", "lorde");
					Statement stmt = con.createStatement();
					System.out.println("Connected.");
					ResultSet result = stmt.executeQuery("select supplier_id,product_id,product_name,stock,to_store,supplied_on from supplies natural join product");
					String str = "";
					display.setText("");
					display.setFont(new Font("TimesNewRoman",Font.BOLD,20));
					display.append("SupplierID\t"+"ProductID\t"+"ProductName\t"+"Stock\t"+"To Store\t"+"Date\t"+"\n\n");
					display.setFont(new Font("TimesNewRoman",Font.PLAIN,14));
					while(result.next())
					{
						str = result.getString(1)+"\t"+result.getString(2)+"\t"+result.getString(3)+"\t"+result.getString(4)+"\t"+result.getString(5)+"\t"+result.getString(6) +"\n";
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
		btnStockIn.setBounds(20, 375, 144, 23);
		contentPane.add(btnStockIn);
		
		JButton btnStockOut = new JButton("Stock Out");
		btnStockOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "vasto", "lorde");
					Statement stmt = con.createStatement();
					System.out.println("Connected.");
					ResultSet result = stmt.executeQuery(" select customer_id,product_id,product_name,quantity,from_store,purchased_on from purchases natural join product");
					String str = "";
					display.setText("");
					display.setFont(new Font("TimesNewRoman",Font.BOLD,20));
					display.append("CustomerID\t"+"ProductID\t"+"ProductName\t"+"Quantity\t"+"Store\t"+"Date\t"+"\n\n");
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
		btnStockOut.setBounds(20, 430, 144, 23);
		contentPane.add(btnStockOut);
		
		JButton btnBackToMain = new JButton("Back to Main Menu");
		btnBackToMain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Mainpage main = new Mainpage();
				main.setVisible(true);
			}
		});
		btnBackToMain.setBounds(705, 527, 169, 23);
		contentPane.add(btnBackToMain);
		
		JButton btnAdvancedSearch = new JButton("Advanced Search");
		btnAdvancedSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				midsearch mid = new midsearch();
				mid.setVisible(true);
				setVisible(false);
			}
		});
		btnAdvancedSearch.setBounds(20, 527, 144, 23);
		contentPane.add(btnAdvancedSearch);
		
		JButton btnNewButton_1 = new JButton("List Suppliers");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "vasto", "lorde");
					Statement stmt = con.createStatement();
					System.out.println("Connected.");
					ResultSet result = stmt.executeQuery("select * from supplier");
					String str = "";
					display.setText("");
					display.setFont(new Font("TimesNewRoman",Font.BOLD,20));
					display.append("SupplierID\t"+"First Name\t"+"Last Name\t"+"Shop No\t"+"Street\t"+"City\t"+"State"+"\n\n");
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
		btnNewButton_1.setBounds(20, 210, 144, 23);
		contentPane.add(btnNewButton_1);
		
	}
}
