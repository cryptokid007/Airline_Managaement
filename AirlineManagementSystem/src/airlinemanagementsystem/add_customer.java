package airlinemanagementsystem;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.sql.*;

import javax.imageio.ImageIO;
import javax.swing.*;

public class add_customer extends JFrame{     //Third Frame

    
	JTextField textField,textField_2,textField_3,textField_4,textField_5;
	private JTextField textField_1;

        public add_customer() throws IOException{
            getContentPane().setForeground(Color.BLUE);
            getContentPane().setBackground(Color.BLACK);
            setTitle("ADD CUSTOMER DETAILS");
		 
            setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
            setSize(778,486);
            getContentPane().setLayout(null);
			
            JLabel Passportno = new JLabel("PASSPORT NO");
            Passportno.setForeground(Color.WHITE);
            Passportno.setFont(new Font("Tahoma", Font.PLAIN, 17));
            Passportno.setBounds(60, 80, 150, 27);
            getContentPane().add(Passportno);
            
            textField = new JTextField();
            textField.setBounds(200, 83, 150, 27);
            getContentPane().add(textField);
			
            JButton Next = new JButton("SAVE");
            Next.setBounds(200, 409, 150, 30);
            Next.setBackground(Color.BLACK);
            Next.setForeground(Color.WHITE);
            getContentPane().add(Next);
            
            JLabel Address = new JLabel("ADDRESS");
            Address.setForeground(Color.WHITE);
            Address.setFont(new Font("Tahoma", Font.PLAIN, 17));
            Address.setBounds(60, 134, 150, 27);
            getContentPane().add(Address);
			
            textField_2 = new JTextField();
            textField_2.setBounds(200, 137, 150, 27);
            getContentPane().add(textField_2);
            		
            JLabel Nationality = new JLabel("AGE");
            Nationality.setForeground(Color.WHITE);
            Nationality.setFont(new Font("Tahoma", Font.PLAIN, 17));
            Nationality.setBounds(60, 182, 150, 27);
            getContentPane().add(Nationality);
			
            textField_3 = new JTextField();
            textField_3.setBounds(200, 185, 150, 27);
            getContentPane().add(textField_3);
	
            JLabel First_Name = new JLabel("FIRST_NAME");
            First_Name.setForeground(Color.WHITE);
            First_Name.setFont(new Font("Tahoma", Font.PLAIN, 17));
            First_Name.setBounds(60, 220, 150, 27);
            getContentPane().add(First_Name);
	
            textField_4 = new JTextField();
            textField_4.setBounds(200, 223, 150, 27);
            getContentPane().add(textField_4);
	
            JLabel Gender = new JLabel("GENDER");
            Gender.setForeground(Color.WHITE);
            Gender.setFont(new Font("Tahoma", Font.PLAIN, 17));
            Gender.setBounds(60, 307, 150, 27);
            getContentPane().add(Gender);
		
            JRadioButton NewRadioButton = new JRadioButton("MALE");
            NewRadioButton.setBackground(Color.WHITE);
            NewRadioButton.setBounds(200, 310, 70, 27);
            getContentPane().add(NewRadioButton);
	
            JRadioButton Female = new JRadioButton("FEMALE");
            Female.setBackground(Color.WHITE);
            Female.setBounds(272, 310, 70, 27);
            getContentPane().add(Female);
            
            JLabel Phno = new JLabel("PH NO");
            Phno.setForeground(Color.WHITE);
            Phno.setFont(new Font("Tahoma", Font.PLAIN, 17));
            Phno.setBounds(60, 345, 150, 27);
            getContentPane().add(Phno);
			
            textField_5 = new JTextField();
            textField_5.setBounds(200, 348, 150, 27);
            getContentPane().add(textField_5);
	
            setVisible(true);
	
            JLabel AddPassengers = new JLabel("ADD CUSTOMER DETAILS");
            AddPassengers.setForeground(Color.ORANGE);
            AddPassengers.setFont(new Font("Tahoma", Font.PLAIN, 31));
            AddPassengers.setBounds(420, 24, 442, 35);
            getContentPane().add(AddPassengers);
            
            
            ImageIcon i1 = new ImageIcon(ImageIO.read(new File("C:\\Users\\BHARGAV\\eclipse-workspace\\AirlineManagementSystem\\src\\airlinemanagementsystem\\icon\\customers.jpg")));
            JLabel image = new JLabel(i1);
            image.setBackground(Color.LIGHT_GRAY);
            image.setForeground(Color.WHITE);
            image.setBounds(496,80,280,312);
            getContentPane().add(image);
            
            JLabel Last_Name = new JLabel("LAST_NAME");
            Last_Name.setFont(new Font("Tahoma", Font.PLAIN, 17));
            Last_Name.setForeground(Color.WHITE);
            Last_Name.setBounds(60, 258, 150, 38);
            getContentPane().add(Last_Name);
            
            textField_1 = new JTextField();
            textField_1.setBounds(200, 261, 150, 29);
            getContentPane().add(textField_1);
            textField_1.setColumns(10);

            
            Next.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent ae){
                    String passport_No = textField.getText();
                    String address =  textField_2.getText();
                    String age = textField_3.getText();
                    String f_name = textField_4.getText();
                    String  l_name = textField_1.getText();
                    String gender = null;
                    String ph_no = textField_5.getText();
                    
                    if(NewRadioButton.isSelected()){
                        gender = "m";
                    
                    }else if(Female.isSelected()){
                        gender = "f";
                    }
                    
                    try {
                        conn c = new conn();
                        String str = "INSERT INTO passenger2 values('"+passport_No+"','"+f_name+"','"+l_name+"','"+address+"', '"+ph_no+"', '"+age+"','"+gender+"')";
                        
                        c.s.executeUpdate(str);
                        JOptionPane.showMessageDialog(null,"Customer Added");
                        setVisible(false);
                    
                    } catch (Exception e) {
                        e.printStackTrace();
        	    }
		}
            });
			
            setSize(900,600);
            setVisible(true);
            setLocation(400,200);
			
	}
        
    public static void main(String[] args) throws IOException{
        new add_customer();
    }   
}