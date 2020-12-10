package airlinemanagementsystem;

import java.awt.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;


public class menu extends JFrame{

    public static void main(String[] args) throws IOException {
        new menu().setVisible(true);
    }
    
    public menu() throws IOException {
        super("AIRLINE RESERVATION MANAGEMENT SYSTEM");///title  of the panel 
        initialize();
    }

    
    private void initialize() throws IOException {
	
        setForeground(Color.CYAN);
        getContentPane().setLayout(null);
        
        JLabel lblNewLabel = new JLabel("Welcome to X Airways");
        lblNewLabel.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		setForeground(Color.orange);
        	}
        });
        lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
        lblNewLabel.setBounds(539, 11, 239, 74);
        getContentPane().add(lblNewLabel);

        JCheckBox NewLabel = new JCheckBox("");
        NewLabel.setBounds(-1036, -94, 2557, 990);
	NewLabel.setIcon(new ImageIcon(ImageIO.read(new File("C:\\Users\\BHARGAV\\eclipse-workspace\\AirlineManagementSystem\\src\\airlinemanagementsystem\\icon\\main.jpg"))));
	getContentPane().add(NewLabel);
        
      		
        JMenuBar menuBar = new JMenuBar(); ///making a menu bar
        menuBar.setBackground(Color.WHITE);
	setJMenuBar(menuBar);
		
        JMenu AirlineSystem = new JMenu("AIRLINE SYSTEM");
        AirlineSystem.setForeground(Color.BLACK);
	menuBar.add(AirlineSystem);
		
        JMenuItem FlightDetails = new JMenuItem("FLIGHT_INFO");///adding into menu items
	AirlineSystem.add(FlightDetails);
		
	JMenuItem ReservationDetails = new JMenuItem("ADD_CUSTOMER_DETAILS");
	AirlineSystem.add(ReservationDetails);
		
	JMenuItem PassengerDetails = new JMenuItem("JOURNEY_DETAILS");
	AirlineSystem.add(PassengerDetails);
	
	JMenuItem Cancellation = new JMenuItem("CANCELLATION");
	AirlineSystem.add(Cancellation);
		
	JMenu Ticket = new JMenu("TICKET"); ///rest of the menu options
        Ticket.setForeground(Color.BLACK);
	menuBar.add(Ticket);
	
	JMenuItem ticket_details = new JMenuItem("Ticket Info");
	Ticket.add(ticket_details);
	ticket_details.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent ae) {
			new ticket_details();
		}
	});
	
	JMenuItem update_ticket= new JMenuItem("Update_Ticket");
	Ticket.add(update_ticket);
	
	update_ticket.addActionListener(new java.awt.event.ActionListener(){
	     public void actionPerformed(ActionEvent e){  
	    	 new update_ticket();
	        }    
	 });
		
        JMenu List = new JMenu("LIST");
        List.setForeground(Color.BLACK);
	menuBar.add(List);
		
	JMenu Misc = new JMenu("MISC");
        Misc.setForeground(Color.BLACK);
	menuBar.add(Misc);
        
		
	FlightDetails.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                new flight_info();
            }
	});
        
	ReservationDetails.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                try {
                    new add_customer();
		} catch (Exception e) {
                    e.printStackTrace();
		} 
            }
	});
		
        PassengerDetails.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                try {
                    new journey_details();
                } catch (Exception e) {
                    e.printStackTrace();
		}
            }
	});
        Cancellation.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                try {
					new cancel();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
	});
		
        setSize(1950,1090);
	setVisible(true);
    }
}

