package airlinemanagementsystem;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class flight_src_destination extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					flight_src_destination frame = new flight_src_destination();
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
	public flight_src_destination() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 726, 522);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 102, 51));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel src_destination = new JLabel("SRC DESTINATION");
		src_destination.setForeground(new Color(255, 204, 0));
		src_destination.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		src_destination.setBounds(218, 25, 199, 34);
		contentPane.add(src_destination);
		
		JLabel sourcelbl = new JLabel("source");
		sourcelbl.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		sourcelbl.setBounds(23, 113, 56, 16);
		contentPane.add(sourcelbl);
		
		final JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"bom", "jfk", "iah", "ixc", "sfo", "fra", "dfw"}));
		comboBox.setBounds(74, 105, 171, 34);
		contentPane.add(comboBox);
		
		JLabel destinationlbl = new JLabel("destination");
		destinationlbl.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		destinationlbl.setBounds(336, 113, 81, 16);
		contentPane.add(destinationlbl);
		
		final JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"bom", "jfk", "iah", "ixc", "sfo", "fra", "dfw"}));
		comboBox_1.setBounds(417, 105, 184, 34);
		contentPane.add(comboBox_1);
		
		JButton searchbtn = new JButton("search");
		searchbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
                    String src  = (String) comboBox.getSelectedItem();
                    String dst  = (String) comboBox_1.getSelectedItem();
                    
                    conn c = new conn();
                    
                    String str = "select source,destination,flight_code,flighttype,seating_capacity,airline_id from  flight where source = '"+src+"' and destination = '"+dst+"' " ;
                    ResultSet rs=c.s.executeQuery(str);
                    
                   
                        table.setModel(DbUtils.resultSetToTableModel(rs));
                    
  
					
		}catch(Exception e){}
			}
		});
		searchbtn.setBounds(653, 204, 81, 25);
		contentPane.add(searchbtn);
		
		table = new JTable();
		table.setBackground(new Color(102, 204, 51));
		table.setBounds(12, 257, 684, 189);
		contentPane.add(table);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(12, 273, 776, 189);
		contentPane.add(scrollPane);
	
		setSize(860,600);
        setLocation(400,200);
	setVisible(true);
	}
}
