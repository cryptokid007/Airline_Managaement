package airlinemanagementsystem;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class adminmenu extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					adminmenu frame = new adminmenu();
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
	public adminmenu() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 813, 584);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 255, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 255, 255));
		panel.setBounds(12, 27, 771, 72);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel welcome = new JLabel("WELCOME BACK");
		welcome.setForeground(new Color(51, 0, 255));
		welcome.setFont(new Font("Sitka Subheading", Font.PLAIN, 20));
		welcome.setBounds(294, 23, 200, 26);
		panel.add(welcome);
		
		JLabel lblNewLabel = new JLabel("add flight");
		lblNewLabel.setBounds(41, 154, 56, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("view crew members");
		lblNewLabel_1.setBounds(41, 206, 124, 16);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("check flights");
		lblNewLabel_2.setBounds(41, 255, 84, 16);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("passenger details");
		lblNewLabel_3.setBounds(41, 307, 117, 16);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("view flight_info");
		lblNewLabel_4.setBounds(41, 361, 103, 16);
		contentPane.add(lblNewLabel_4);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(153, 255, 102));
		panel_1.setBounds(19, 126, 358, 354);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_5 = new JLabel("update flight ");
		lblNewLabel_5.setBounds(24, 286, 104, 16);
		panel_1.add(lblNewLabel_5);
		
		JButton add_flight_btn = new JButton("add flight");
		add_flight_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				 try {
	                    new add_flight();
	                } catch (Exception e) {
	                    e.printStackTrace();
			}
			}
		});
		add_flight_btn.setBounds(199, 25, 134, 25);
		panel_1.add(add_flight_btn);
		
		JButton view_crew_btn = new JButton("view crew");
		view_crew_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {

                try {
                    new crew_members();
		} catch (Exception e) {
                    e.printStackTrace();
		} 
			}
		});
		view_crew_btn.setBounds(199, 74, 134, 25);
		panel_1.add(view_crew_btn);
		
		JButton check_flight_btn = new JButton("check flights");
		check_flight_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {

                try {
                    new flight_src_destination();
		} catch (Exception e) {
                    e.printStackTrace();
		} 
			}
		});
		check_flight_btn.setBounds(199, 122, 134, 25);
		panel_1.add(check_flight_btn);
		
		JButton passenger_details_btn = new JButton("passenger details");
		passenger_details_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
                    new view_customer_details();
		} catch (Exception e) {
                    e.printStackTrace();
		} 
			}
		});
		passenger_details_btn.setBounds(199, 176, 134, 25);
		panel_1.add(passenger_details_btn);
		
		JButton view_flight_info_btn = new JButton("view flight info");
		view_flight_info_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				try {
                    new flight_info();
                } catch (Exception e) {
                    e.printStackTrace();
		}
			}
		});
		view_flight_info_btn.setBounds(199, 228, 134, 25);
		panel_1.add(view_flight_info_btn);
		
		JButton update_flight_btn = new JButton("update flight");
		update_flight_btn.setBounds(199, 282, 134, 25);
		panel_1.add(update_flight_btn);
		
		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setIcon(new ImageIcon("C:\\Users\\kosgi\\Desktop\\i3.png"));
		lblNewLabel_6.setBounds(411, 126, 372, 354);
		contentPane.add(lblNewLabel_6);
		setVisible(true);
	}
}
