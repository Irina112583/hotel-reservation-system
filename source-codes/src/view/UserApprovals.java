package view;

import java.awt.Color;

import java.awt.Font;
import java.awt.Frame;

import javax.sql.RowSetMetaData;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.DefaultTableModel;

import domain.Hotel;
import domain.User;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;

public class UserApprovals extends JFrame {


	/**
	 * 
	 */

	
	public UserApprovals(Hotel hotel) {
		
		setBackground(Color.WHITE);
		setResizable(false);
		setTitle("SM504 - HOTEL RESERVATION SYSTEM");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 611, 593);
		JPanel pnlUserApprovals = new JPanel();
		pnlUserApprovals.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		pnlUserApprovals.setBackground(Color.WHITE);
		setContentPane(pnlUserApprovals);
		pnlUserApprovals.setLayout(null);

		 
		 JLabel lblNewLabel = new JLabel("List of Receptionists Requests in Approval Status");
		 lblNewLabel.setForeground(SystemColor.textInactiveText);
		 lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		 lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		 lblNewLabel.setBounds(107, 13, 373, 16);
		 pnlUserApprovals.add(lblNewLabel);
		 
		 JLabel lblNoDataAvailable = new JLabel("No data available");
		 lblNoDataAvailable.setBounds(180, 87, 188, 34);
		 lblNoDataAvailable.setEnabled(false);
		 lblNoDataAvailable.setVisible(false);
		 lblNoDataAvailable.setHorizontalAlignment(SwingConstants.CENTER);
		 lblNoDataAvailable.setFont(new Font("Tahoma", Font.PLAIN, 15));
		 pnlUserApprovals.add(lblNoDataAvailable);
		 
		 String column[]={"ID","Fullname", "Username", "Email Address"};         
		 DefaultTableModel tableModel = new DefaultTableModel(column, 0);
		 JTable jt=new JTable(tableModel);
		 
		 jt.setBorder(new LineBorder(new Color(0, 0, 0)));
		 jt.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		 jt.setBounds(462,95,295,300);          

		 JScrollPane sp=new JScrollPane(jt);
		 sp.setLocation(12, 42);
		 sp.setSize(556, 447);
		 sp.setVisible(true);
		 jt.setBounds(30,40,200,300);    
		 pnlUserApprovals.add(sp);
	 
		 
		 Object[] rowData;
		 ArrayList<User> users = null;
		 try {
			 
			users = new ArrayList<User>();
			rowData = new Object[4];
			users = hotel.retrieveUsersWithRole("Receptionist");
			for(int i = 0; i< users.size();i++){
				if(users.get(i).getUserStatus() == 0){
					rowData[0] = users.get(i).getIDNumber();
					rowData[1] = users.get(i).getFullName();
					rowData[2] = users.get(i).getUsername();
					rowData[3] = users.get(i).getEmailAddress();
					tableModel.addRow(rowData);
				}
			}		
		
		}finally{
			if(tableModel.getRowCount() == 0){
				lblNoDataAvailable.setVisible(true);
			}
			users.clear();
		}
		
		 JButton btnApprove = new JButton("Approve Request");
		 btnApprove.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		int id = (int) jt.getValueAt(jt.getSelectedRow(),0);
		 		hotel.approveReceptionist(id);
		 		tableModel.removeRow(jt.getSelectedRow());
		 	}
		 });
		 btnApprove.setBounds(241, 502, 217, 25);
		 pnlUserApprovals.add(btnApprove);
		 
		 JButton btnDeleteRequest = new JButton("Delete Request");
		 btnDeleteRequest.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		hotel.deleteUser((int) jt.getValueAt(jt.getSelectedRow(),0));
		 		tableModel.removeRow(jt.getSelectedRow());
		 	}
		 });
		 btnDeleteRequest.setBounds(12, 502, 217, 25);
		 pnlUserApprovals.add(btnDeleteRequest);
		 
		 JButton btnBack = new JButton("Close");
		 btnBack.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent arg0) {
		 		dispose();
		 		
		 	}
		 });
		 btnBack.setBounds(470, 502, 98, 25);
		 pnlUserApprovals.add(btnBack);

	}
}
