///////////Mainpage

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

public class Mainpage extends JFrame {

	private JPanel contentPane;
	

	/**
	 * Launch the application.
	 */
	public  void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Mainpage frame = new Mainpage();
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
	public Mainpage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblChooseAnOption = new JLabel("Choose an option:");
		lblChooseAnOption.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblChooseAnOption.setBounds(43, 28, 177, 31);
		contentPane.add(lblChooseAnOption);
		
		JButton btnViewRecords = new JButton("View records");
		btnViewRecords.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				view_simple view = new view_simple();
				view.setVisible(true);
			}
		});
		btnViewRecords.setBounds(82, 95, 138, 23);
		contentPane.add(btnViewRecords);
		
		JButton btnUpdateRecords = new JButton("Update records");
		btnUpdateRecords.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnUpdateRecords.setBounds(82, 179, 138, 23);
		contentPane.add(btnUpdateRecords);
		
		JButton btnDeleteRecords = new JButton("Delete records");
		btnDeleteRecords.setBounds(82, 260, 138, 23);
		contentPane.add(btnDeleteRecords);
		
		JButton btnLogOut = new JButton("Log Out");
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Log_In in = new Log_In();
				in.setVisible(true);				
			}
		});
		btnLogOut.setBounds(431, 307, 89, 23);
		contentPane.add(btnLogOut);
	}
}
