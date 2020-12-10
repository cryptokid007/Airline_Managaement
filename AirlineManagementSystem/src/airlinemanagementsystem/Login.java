package airlinemanagementsystem;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class Login extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 828, 610);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel hlolbl = new JLabel("WELCOME TO OUR AIRWAYS");
		hlolbl.setFont(new Font("Times New Roman", Font.PLAIN, 21));
		hlolbl.setForeground(new Color(255, 102, 204));
		hlolbl.setBounds(228, 59, 374, 25);
		contentPane.add(hlolbl);
		
		JButton adminbtn = new JButton("ADMIN");
		adminbtn.setBounds(336, 203, 145, 43);
		contentPane.add(adminbtn);
		adminbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				new loginadmin();
			}
		});
		
		JButton customerbtn = new JButton("USER");
		customerbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				 
	                    try {
							new menu();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
			
			}});
		customerbtn.setBounds(336, 304, 156, 43);
		contentPane.add(customerbtn);
	}

}