package airlinemanagementsystem;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.sql.*;


public class cancel extends JFrame { //Sixth
    
    private JTextField textField,textField_1,textField_2,textField_3,textField_4;

    public static void main(String[] args) throws IOException {
        new cancel();
    }
    
    public cancel() throws IOException {
        initialize();
    }
    
    private void initialize() throws IOException {
        setTitle("CANCELLATION");
	getContentPane().setBackground(Color.BLACK);
	setBounds(100, 100, 801, 472);
	getContentPane().setLayout(null);
		
	JLabel Cancellation = new JLabel("CANCELLATION");
	Cancellation.setForeground(Color.ORANGE);
	Cancellation.setFont(new Font("Tahoma", Font.PLAIN, 31));
	Cancellation.setBounds(185, 24, 259, 38);
	getContentPane().add(Cancellation);
		
	
        ImageIcon i1 = new ImageIcon(ImageIO.read(new File("C:\\\\Users\\\\BHARGAV\\\\eclipse-workspace\\\\AirlineManagementSystem\\\\src\\\\airlinemanagementsystem\\\\icon\\\\cancel.jpg")));
        Image i2 = i1.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel NewLabel = new JLabel(i3);
	NewLabel.setBounds(470, 100, 250, 250);
	getContentPane().add(NewLabel);
		
	JLabel Passenger_ID = new JLabel("Passenger_ID");
	Passenger_ID.setForeground(Color.WHITE);
	Passenger_ID.setFont(new Font("Tahoma", Font.PLAIN, 17));
	Passenger_ID.setBounds(60, 100, 132, 26);
	getContentPane().add(Passenger_ID);
		
	JLabel Cancellation_No = new JLabel("Cancellation_No");
	Cancellation_No.setForeground(Color.WHITE);
	Cancellation_No.setFont(new Font("Tahoma", Font.PLAIN, 17));
	Cancellation_No.setBounds(60, 150, 150, 27);
	getContentPane().add(Cancellation_No);
		
	JLabel CancellationDate = new JLabel("Cancellation_ Date");
	CancellationDate.setForeground(Color.WHITE);
	CancellationDate.setFont(new Font("Tahoma", Font.PLAIN, 17));
	CancellationDate.setBounds(60, 200, 180, 27);
	getContentPane().add(CancellationDate);
		
	JLabel Ticket_Number = new JLabel("Ticket_Number");
	Ticket_Number.setForeground(Color.WHITE);
	Ticket_Number.setFont(new Font("Tahoma", Font.PLAIN, 17));
	Ticket_Number.setBounds(60, 250, 150, 27);
	getContentPane().add(Ticket_Number);
		
	JLabel Flight_Code = new JLabel("Flight_Code");
	Flight_Code.setForeground(Color.WHITE);
	Flight_Code.setBackground(Color.WHITE);
	Flight_Code.setFont(new Font("Tahoma", Font.PLAIN, 17));
	Flight_Code.setBounds(60, 300, 150, 27);
	getContentPane().add(Flight_Code);
		
	JButton Cancel = new JButton("CANCEL");
	Cancel.setFont(new Font("Tahoma", Font.PLAIN, 14));
        Cancel.setBackground(Color.BLACK);
        Cancel.setForeground(Color.WHITE);
	Cancel.setBounds(250, 350, 150, 30);
	getContentPane().add(Cancel);
		
	textField = new JTextField();
	textField.setBounds(250, 100, 150, 27);
	getContentPane().add(textField);
	
        textField_1 = new JTextField();
	textField_1.setBounds(250, 150, 150, 27);
	getContentPane().add(textField_1);
		
	textField_2 = new JTextField();
	textField_2.setBounds(250, 200, 150, 27);
	getContentPane().add(textField_2);
	
        textField_3 = new JTextField();
	textField_3.setBounds(250, 250, 150, 27);
	getContentPane().add(textField_3);
		
	textField_4 = new JTextField();
	textField_4.setBounds(250, 300, 150, 27);
	getContentPane().add(textField_4);
	
        Cancel.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
		
                String passenger_no = textField.getText();
		String cancellation_no = textField_1.getText();
		String cancellation_date = textField_2.getText();
		String ticket_id = textField_3.getText();
		String flight_code = textField_4.getText();
					
					
		try{	
                    conn c = new conn();
                    String str = "INSERT INTO cancellation values('"+passenger_no+"', '"+cancellation_no+"', '"+cancellation_date+"', '"+ticket_id+"', '"+flight_code+"')";
		
                    c.s.executeUpdate(str);
                    JOptionPane.showMessageDialog(null,"Ticket Canceled");
                    setVisible(false);
						
		}catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
			
	setSize(860,500);
	setVisible(true);
        setLocation(400,200);
    }
}
