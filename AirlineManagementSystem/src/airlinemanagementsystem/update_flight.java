package airlinemanagementsystem;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class update_flight extends JFrame {

	private JPanel contentPane;
	private JTextField flight_code_txt;
	private JTextField arrival_time_txt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					update_flight frame = new update_flight();
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
	public update_flight() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 818, 431);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel update_flight = new JLabel("UPDATE FLIGHT");
		update_flight.setForeground(new Color(255, 51, 102));
		update_flight.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		update_flight.setBounds(295, 43, 186, 23);
		contentPane.add(update_flight);
		
		JLabel flight_code = new JLabel("flight code");
		flight_code.setBounds(258, 139, 77, 16);
		contentPane.add(flight_code);
		
		JLabel changing_arrival = new JLabel("changing arrival time to");
		changing_arrival.setBounds(190, 219, 145, 16);
		contentPane.add(changing_arrival);
		
		flight_code_txt = new JTextField();
		flight_code_txt.setBounds(392, 136, 116, 22);
		contentPane.add(flight_code_txt);
		flight_code_txt.setColumns(10);
		
		arrival_time_txt = new JTextField();
		arrival_time_txt.setBounds(392, 216, 116, 22);
		contentPane.add(arrival_time_txt);
		arrival_time_txt.setColumns(10);
		
		JButton update_btn = new JButton("update");
		update_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
			String flight_code=flight_code_txt.getText();
			String arrival_time=arrival_time_txt.getText();
		    try {
                conn c = new conn();
                String str = "update flight set arrival='"+arrival_time+"' where flight_code='"+flight_code+"'";
                
                c.s.executeUpdate(str);
                JOptionPane.showMessageDialog(null,"flight_info updated");
                setVisible(false);
            
            } catch (Exception e) {
                e.printStackTrace();
	    }
			}
		});
		update_btn.setBounds(320, 293, 97, 25);
		contentPane.add(update_btn);
		setVisible(true);
	}
}
