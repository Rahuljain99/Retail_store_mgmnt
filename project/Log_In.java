/////LOGIN

package dbsproject;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.sql.*;
import javax.swing.JButton;
import javax.swing.JInternalFrame;

public class Log_In extends JFrame {

	private JPanel contentPane;
	private JTextField uid;
	private JPasswordField pswd;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Log_In frame = new Log_In();
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
	public Log_In() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JFrame jframe = new JFrame("Mainpage.java");
		JLabel lblLogIn = new JLabel("Log In");
		lblLogIn.setFont(new Font("Times New Roman", Font.PLAIN, 23));
		lblLogIn.setBounds(148, 87, 86, 35);
		contentPane.add(lblLogIn);
		
		JLabel lblUserId = new JLabel("User ID:");
		lblUserId.setBounds(39, 148, 46, 14);
		contentPane.add(lblUserId);
	
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(39, 173, 65, 23);
		contentPane.add(lblPassword);
		
		uid = new JTextField();
		uid.setBounds(105, 145, 159, 20);
		contentPane.add(uid);
		uid.setColumns(10);
		
		JLabel lblStoreManagementDatabase = new JLabel("Store Management\r\n Database System");
		lblStoreManagementDatabase.setFont(new Font("Franklin Gothic Medium", Font.BOLD, 20));
		lblStoreManagementDatabase.setBounds(27, 23, 371, 65);
		contentPane.add(lblStoreManagementDatabase);
		
		pswd = new JPasswordField();
		pswd.setBounds(105, 174, 159, 20);
		contentPane.add(pswd);
		
		JButton btnLogIn = new JButton("Log In");
		btnLogIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
				String user=uid.getText();
				System.out.println(user);
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "vasto", "lorde");
				Statement stmt = con.createStatement();
				System.out.println("Connected.");
				ResultSet result = stmt.executeQuery("select * from employee where designation='Manager'");
				String str = "";
				if(result==null)
				{
					System.out.println("Null");
				}
				else
				{
					System.out.println("NOt Nuull");
					while (result.next()) {
					    str = result.getString(1);
					    	if(user.equals(str)){
					    		System.out.println("SUCCESS");
					    		Mainpage main = new Mainpage();
					    		main.setVisible(true);
					    		setVisible(false);}
					    	else
					    	{
					    	}
					  }
				}
			/*	result.next();
				System.out.println(result.getString(1));
				
				while (true)
		        {	
					System.out.println("Inside");
		        	System.out.println(result.getString(1));
		        	break;
		        }*/
				con.close();
				System.out.println("Connection Closed");
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
		btnLogIn.setBounds(175, 205, 89, 23);
		contentPane.add(btnLogIn);
		
	}
}
