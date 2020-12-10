package airlinemanagementsystem;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class add_flight extends JFrame {

	private JPanel contentPane;
	private JTextField flight_code_txt;
	private JTextField source_txt;
	private JTextField destination_txt;
	private JTextField flight_type_txt;
	private JTextField seating_capacity_txt;
	private JTextField arrival_txt;
	private JTextField departure_txt;
	private JTextField airline_id_txt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					add_flight frame = new add_flight();
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
	public add_flight() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 786, 501);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 153, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel flight_code_lbl = new JLabel("flight_code");
		flight_code_lbl.setBounds(34, 87, 81, 16);
		contentPane.add(flight_code_lbl);
		
		JLabel source_lbl = new JLabel("source");
		source_lbl.setBounds(34, 168, 56, 16);
		contentPane.add(source_lbl);
		
		JLabel destination_lbl = new JLabel("destination");
		destination_lbl.setBounds(34, 242, 81, 16);
		contentPane.add(destination_lbl);
		
		JLabel arrival_lbl = new JLabel("arrival");
		arrival_lbl.setBounds(474, 87, 56, 16);
		contentPane.add(arrival_lbl);
		
		JLabel departure_lbl = new JLabel("departure");
		departure_lbl.setBounds(474, 168, 56, 16);
		contentPane.add(departure_lbl);
		
		JLabel flight_type_lbl = new JLabel("flight_type");
		flight_type_lbl.setBounds(34, 330, 93, 16);
		contentPane.add(flight_type_lbl);
		
		JLabel seating_capacity_lbl = new JLabel("seating capacity");
		seating_capacity_lbl.setBounds(474, 330, 93, 16);
		contentPane.add(seating_capacity_lbl);
		
		JLabel airline_id_lbl = new JLabel("airline id");
		airline_id_lbl.setBounds(474, 242, 56, 16);
		contentPane.add(airline_id_lbl);
		
		JButton submit_btn = new JButton("submit");
		submit_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				String flight_code=flight_code_txt.getText();
				String source=source_txt.getText();
				String destination=destination_txt.getText();
				String arrival=arrival_txt.getText();
				String departure=departure_txt.getText();
				String	flighttype=flight_type_txt.getText();
				String seating_capacity=seating_capacity_txt.getText();
				String airline_id=airline_id_txt.getText();
				
				  try {
                      conn c = new conn();
                      String str = "INSERT INTO flight values('"+flight_code+"','"+source+"','"+destination+"','"+arrival+"', '"+departure+"', '"+flighttype+"','"+seating_capacity+"','"+airline_id+"') ";
                      c.s.executeUpdate(str);
                    
                      JOptionPane.showMessageDialog(null,"flight  added");
                      setVisible(false);
                  
                  } catch (Exception e) {
                      e.printStackTrace();
      	    }
				
			}
		});
		submit_btn.setBounds(333, 416, 97, 25);
		contentPane.add(submit_btn);
		
		flight_code_txt = new JTextField();
		flight_code_txt.setBounds(139, 84, 116, 22);
		contentPane.add(flight_code_txt);
		flight_code_txt.setColumns(10);
		
		source_txt = new JTextField();
		source_txt.setBounds(139, 165, 116, 22);
		contentPane.add(source_txt);
		source_txt.setColumns(10);
		
		destination_txt = new JTextField();
		destination_txt.setBounds(139, 239, 116, 22);
		contentPane.add(destination_txt);
		destination_txt.setColumns(10);
		
		flight_type_txt = new JTextField();
		flight_type_txt.setBounds(139, 327, 116, 22);
		contentPane.add(flight_type_txt);
		flight_type_txt.setColumns(10);
		
		seating_capacity_txt = new JTextField();
		seating_capacity_txt.setBounds(579, 327, 116, 22);
		contentPane.add(seating_capacity_txt);
		seating_capacity_txt.setColumns(10);
		
		arrival_txt = new JTextField();
		arrival_txt.setBounds(579, 84, 116, 22);
		contentPane.add(arrival_txt);
		arrival_txt.setColumns(10);
		
		departure_txt = new JTextField();
		departure_txt.setBounds(579, 165, 116, 22);
		contentPane.add(departure_txt);
		departure_txt.setColumns(10);
		
		airline_id_txt = new JTextField();
		airline_id_txt.setBounds(579, 239, 116, 22);
		contentPane.add(airline_id_txt);
		airline_id_txt.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("ADD FLIGHTS");
		lblNewLabel_8.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_8.setForeground(new Color(51, 51, 102));
		lblNewLabel_8.setBounds(307, 25, 134, 30);
		contentPane.add(lblNewLabel_8);
		
		setVisible(true);
	}

}
