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
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class crew_members extends JFrame {

	private JPanel contentPane;
	private JTextField emp_id_txt;
	private JTextField f_name_txt;
	private JTextField l_name_txt;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					crew_members frame = new crew_members();
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
	public crew_members() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 873, 591);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(153, 204, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel details_lbl = new JLabel("DETAILS OF CREW MEMBERS");
		details_lbl.setForeground(new Color(102, 102, 204));
		details_lbl.setFont(new Font("Times New Roman", Font.PLAIN, 21));
		details_lbl.setBounds(286, 37, 302, 25);
		contentPane.add(details_lbl);
		
		JLabel emp_id_lbl = new JLabel("emp_id");
		emp_id_lbl.setBounds(25, 104, 56, 16);
		contentPane.add(emp_id_lbl);
		
		JLabel f_name_lbl = new JLabel("f_name");
		f_name_lbl.setBounds(25, 179, 56, 16);
		contentPane.add(f_name_lbl);
		
		JLabel l_name_lbl = new JLabel("l_name");
		l_name_lbl.setBounds(301, 179, 56, 16);
		contentPane.add(l_name_lbl);
		
		emp_id_txt = new JTextField();
		emp_id_txt.setBounds(104, 101, 116, 22);
		contentPane.add(emp_id_txt);
		emp_id_txt.setColumns(10);
		
		f_name_txt = new JTextField();
		f_name_txt.setBounds(104, 176, 116, 22);
		contentPane.add(f_name_txt);
		f_name_txt.setColumns(10);
		
		l_name_txt = new JTextField();
		l_name_txt.setBounds(369, 176, 116, 22);
		contentPane.add(l_name_txt);
		l_name_txt.setColumns(10);
		
		table = new JTable();
		table.setBackground(new Color(0, 102, 204));
		table.setForeground(new Color(0, 0, 0));
		table.setBounds(25, 252, 631, 168);
		contentPane.add(table);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(25, 283, 803, 206);
		contentPane.add(scrollPane);
		
		JButton search_btn = new JButton("search");
		search_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
			String emp_id=emp_id_txt.getText();
			String f_name=f_name_txt.getText();
			String l_name=l_name_txt.getText();
			try {
                conn c = new conn();
                String str = "select * from crewmembers1 where emp_id='"+emp_id+"' and f_name='"+f_name+"' and l_name='"+l_name+"'";
                
                ResultSet rs=c.s.executeQuery(str);
                
           	 	table.setModel(DbUtils.resultSetToTableModel(rs));
               
            
            } catch (Exception e) {
                e.printStackTrace();
	    }
			}
		});
		search_btn.setBounds(596, 234, 97, 25);
		contentPane.add(search_btn);
		setVisible(true);
	}

}
