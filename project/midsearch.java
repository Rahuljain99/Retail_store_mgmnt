////////////////midsearch


package dbsproject;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class midsearch extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					midsearch frame = new midsearch();
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
	public midsearch() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 591, 190);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSearch = new JLabel("Search:");
		lblSearch.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblSearch.setBounds(10, 21, 118, 36);
		contentPane.add(lblSearch);
		
		JButton btnEmployees = new JButton("Employees");
		btnEmployees.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				advance ad = new advance();
				ad.setVisible(true);
				setVisible(false);
			}
		});
		btnEmployees.setBounds(10, 83, 118, 23);
		contentPane.add(btnEmployees);
		
		JButton btnCustomers = new JButton("Customers");
		btnCustomers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				advance_customer ad1 = new advance_customer();
				ad1.setVisible(true);
				setVisible(false);
			}
		});
		btnCustomers.setBounds(208, 83, 118, 23);
		contentPane.add(btnCustomers);
		
		JButton btnSuppliers = new JButton("Suppliers");
		btnSuppliers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				advanced_supplier advs = new advanced_supplier();
				advs.setVisible(true);
				setVisible(false);
			}
		});
		btnSuppliers.setBounds(403, 83, 118, 23);
		contentPane.add(btnSuppliers);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				view_simple vs = new view_simple();
				vs.setVisible(true);
				setVisible(false);
			}
		});
		btnBack.setBounds(476, 117, 89, 23);
		contentPane.add(btnBack);
	}

}
