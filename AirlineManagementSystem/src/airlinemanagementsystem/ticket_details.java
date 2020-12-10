package airlinemanagementsystem;
import java.awt.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import net.proteanit.sql.DbUtils;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException; class ticket_details extends JFrame{
	private JTable table;
	private JTextField textField;
	 public static void main(String[] args){		 
			new ticket_details().setVisible(true);    
		    }
	public ticket_details() {
		getContentPane().setBackground(Color.BLACK);
		getContentPane().setForeground(Color.BLACK);
		getContentPane().setLayout(null);
		
		JLabel Ticket_Number = new JLabel("Ticket_Number");
		Ticket_Number.setForeground(Color.WHITE);
		Ticket_Number.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Ticket_Number.setBounds(53, 105, 143, 26);
		getContentPane().add(Ticket_Number);
		
		JLabel lblNewLabel = new JLabel("Ticket_Details");
		lblNewLabel.setForeground(Color.ORANGE);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(125, 11, 425, 80);
		getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Go");
		btnNewButton.setBounds(442, 150, 89, 23);
		getContentPane().add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent ae) {
		
	                String code = textField.getText();
	                
	                try {
	                    conn c = new conn();
	                    String str = "select source,destination,date_of_booking,date_of_travel,seatno,class,p_id,time_of_journey,ticketstatus from ticket1 where ticket_number = '"+code+"'";
	      
	                    ResultSet rs = c.s.executeQuery(str);
	                    table.setModel(DbUtils.resultSetToTableModel(rs));	///to convert into table
	                    rs.close();

	                }                
	                catch(SQLException e){
	                    e.printStackTrace();
	                }
	            }
	        });

		btnNewButton.setBounds(220, 150, 120, 30);
		getContentPane().add(btnNewButton);
			
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

