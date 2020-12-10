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
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class view_customer_details extends JFrame {

	private JPanel contentPane;
	private JTextField f_name_txt;
	private JTextField l_name_txt;
	private JTextField phone_no_txt;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					view_customer_details frame = new view_customer_details();
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
	public view_customer_details() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 768, 608);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 255, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel detailsofcustomer = new JLabel("DETAILS OF CUSTOMER");
		detailsofcustomer.setForeground(new Color(153, 204, 102));
		detailsofcustomer.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		detailsofcustomer.setBounds(288, 35, 241, 43);
		contentPane.add(detailsofcustomer);
		
		JLabel f_name = new JLabel("f_name");
		f_name.setBounds(44, 115, 56, 16);
		contentPane.add(f_name);
		
		JLabel l_name = new JLabel("l_name");
		l_name.setBounds(44, 178, 56, 16);
		contentPane.add(l_name);
		
		JLabel phone_no = new JLabel("phone_no");
		phone_no.setBounds(44, 248, 56, 16);
		contentPane.add(phone_no);
		
		f_name_txt = new JTextField();
		f_name_txt.setBounds(150, 112, 116, 22);
		contentPane.add(f_name_txt);
		f_name_txt.setColumns(10);
		
		l_name_txt = new JTextField();
		l_name_txt.setBounds(150, 175, 116, 22);
		contentPane.add(l_name_txt);
		l_name_txt.setColumns(10);
		
		phone_no_txt = new JTextField();
		phone_no_txt.setBounds(150, 245, 116, 22);
		contentPane.add(phone_no_txt);
		phone_no_txt.setColumns(10);
		
		JButton searchbtn = new JButton("search");
		searchbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				try{
					String f_name=f_name_txt.getText();
					String l_name=l_name_txt.getText();
					String phone_no=phone_no_txt.getText();
                    
                    conn c = new conn();
                    String str = "select passport_no,f_name,l_name,phone_no from passenger2 natural inner join ticket1 where phone_no='"+phone_no+"' and f_name='"+f_name+"' and l_name='"+l_name+"'";
                    
                   ResultSet rs=c.s.executeQuery(str);
                 
                	   table.setModel(DbUtils.resultSetToTableModel(rs));
	                    
	               
                
  
					
		}catch(Exception e){}
            }
	}		     
             
		);
		searchbtn.setBounds(498, 263, 97, 25);
		contentPane.add(searchbtn);
		
		table = new JTable();
		table.setBackground(new Color(204, 255, 102));
		table.setBounds(12, 312, 726, 209);
		contentPane.add(table);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(12, 312, 726, 209);
		contentPane.add(scrollPane);
		
		setSize(1103,698);
        setVisible(true);
        setLocation(400,200);
	
	}

}
