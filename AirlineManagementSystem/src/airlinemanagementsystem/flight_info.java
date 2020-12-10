package airlinemanagementsystem;

import java.awt.*;
import javax.imageio.ImageIO;
import javax.swing.*;

import net.proteanit.sql.DbUtils;

import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;


public class flight_info extends JFrame {
	private JTable table;
    private JTextField textField;
    
    public static void main(String[] args){		 
	new flight_info().setVisible(true);    
    }
    
    public flight_info(){
        
        getContentPane().setBackground(Color.BLACK);
        getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 13));
		
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setSize(860,523);
	getContentPane().setLayout(null);
	setVisible(true);
		
	JLabel Fcode = new JLabel("FLIGHT CODE");
	Fcode.setForeground(Color.YELLOW);
	Fcode.setBackground(Color.YELLOW);
	Fcode.setFont(new Font("Tahoma", Font.PLAIN, 17));
        Fcode.setBounds(50, 100, 200, 30);
	getContentPane().add(Fcode);
	
		
	JLabel FlightDetails = new JLabel("FLIGHT INFORMATION");
	FlightDetails.setFont(new Font("Tahoma", Font.PLAIN, 31));
	FlightDetails.setForeground(Color.WHITE);
	FlightDetails.setBounds(267, 20, 329, 35);
	getContentPane().add(FlightDetails);
		
	JButton btnShow = new JButton("SHOW");
	btnShow.setFont(new Font("Tahoma", Font.PLAIN, 20));
	
        btnShow.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
	
                String code = textField.getText();
                
                try {
                    conn c = new conn();
                    String str = "select flight_code,flighttype,airline_id,arrival,departure,seating_capacity from flight where flight_code = '"+code+"'";
      
                    ResultSet rs = c.s.executeQuery(str);
                    	table.setModel(DbUtils.resultSetToTableModel(rs));	///to convert into table
                    rs.close();

                }                
                catch(SQLException e){
                    e.printStackTrace();
                }
            }
        });

        btnShow.setBounds(220, 150, 120, 30);
	getContentPane().add(btnShow);
		
        table = new JTable();
        table.setBackground(Color.WHITE);
	table.setBounds(23, 250, 800, 300);
        
        JScrollPane pane = new JScrollPane(table);
	pane.setBounds(23, 250, 800, 300);
        pane.setBackground(Color.WHITE);
        getContentPane().add(pane);
		
	textField = new JTextField();
        textField.setBounds(220, 100, 200, 30);
	getContentPane().add(textField);
		
	
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	setSize(900,650);
        setVisible(true);
        setLocation(400,200);
		
    }

}
