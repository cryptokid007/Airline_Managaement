package airlinemanagementsystem;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import net.proteanit.sql.DbUtils;

public class journey_details extends JFrame{  //Forth

    JTable table;
    JLabel ReservationDetails,Source,Destination,label,label1;
    JButton Show;

    public static void main(String[] args){
        new journey_details();
    }
    
    public journey_details(){
        
        setTitle("JOURNEY_DETAILS");
	getContentPane().setBackground(Color.BLACK);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	getContentPane().setLayout(null);
		
	Source = new JLabel("SOURCE");
	Source.setForeground(Color.WHITE);
	Source.setFont(new Font("Tahoma", Font.PLAIN, 19));
	Source.setBounds(60, 100, 150, 27);
	getContentPane().add(Source);
	
        Destination = new JLabel("DESTINATION");
        Destination.setForeground(Color.WHITE);
	Destination.setFont(new Font("Tahoma", Font.PLAIN, 19));
	Destination.setBounds(350, 100, 150, 27);
	getContentPane().add(Destination);
		
	
		
	Show = new JButton("SHOW");
	Show.setBounds(680, 100, 100, 30);
	getContentPane().add(Show);

	setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		
	ReservationDetails = new JLabel("JOURNEY DETAILS");
	ReservationDetails.setForeground(Color.BLUE);
	ReservationDetails.setFont(new Font("Tahoma", Font.PLAIN, 31));
	ReservationDetails.setBounds(280, 27, 359, 31);
	getContentPane().add(ReservationDetails);
        
	String[] items1 =  {"HOU","GE","KA","SF","BOM","NYC"};
	JComboBox comboBox = new JComboBox(items1);
	
	comboBox.setBounds(150, 100, 150, 27);
	getContentPane().add(comboBox);
		
		
	String[] items2 =  {"HOU","GE","SF","DWT","DEL","FLR","BOM"};
	JComboBox comboBox_1 = new JComboBox(items2);
	comboBox_1.setBounds(500, 100, 150, 27);
	getContentPane().add(comboBox_1);
        
        table = new JTable();
	table.setBounds(38, 236, 770, 273);
	getContentPane().add(table);
	
		
		
	Show.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
		try{
                    String src  = (String) comboBox.getSelectedItem();
                    String dst  = (String) comboBox_1.getSelectedItem();
                    
                    conn c = new conn();
                    
                    String str = "select ticket_number,date_of_booking,date_of_travel,source,destination from ticket1 where source = '"+src+"' and destination = '"+dst+"'  ";
                    ResultSet rs=c.s.executeQuery(str);
                    
                    if(rs.next()){
                        table.setModel(DbUtils.resultSetToTableModel(rs));
                    }else{
                        JOptionPane.showMessageDialog(null,"No Flights between Source and Destination");
                        
                    }		
                    rs.close();
  
					
		}catch(Exception e){}
            }
	});
		
	setSize(860,600);
        setLocation(400,200);
	setVisible(true);
		
    }
}
