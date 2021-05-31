package view;

import java.awt.Color;

import java.awt.Font;
import java.awt.Frame;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.DefaultTableModel;

import domain.Hotel;
import domain.User;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UserApprovals extends JFrame {


	/**
	 * 
	 */

	
	public UserApprovals(Hotel hotel) {

		
		setBackground(Color.WHITE);
		setResizable(false);
		setTitle("SM504 - HOTEL RESERVATION SYSTEM");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 585, 575);
		JPanel pnlUserApprovals = new JPanel();
		pnlUserApprovals.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		pnlUserApprovals.setBackground(Color.WHITE);
		setContentPane(pnlUserApprovals);
		pnlUserApprovals.setLayout(null);

		 
		 String column[]={"List Of Receptionist Requests"};         
		 DefaultTableModel tableModel = new DefaultTableModel(column, 0);
		 JTable jt=new JTable(tableModel);
		 
		 jt.setBorder(new LineBorder(new Color(0, 0, 0)));
		 jt.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		 jt.setBounds(462,95,295,300);          

		 JScrollPane sp=new JScrollPane(jt);
		 sp.setLocation(12, 13);
		 sp.setSize(556, 476);
		 sp.setVisible(true);
		 jt.setBounds(30,40,200,300);    
		 pnlUserApprovals.add(sp);
	 
		 try {
			 ArrayList<String> users = new ArrayList<String>();
			 
			Object[] rowData; 
			users = hotel.retrieveUsersWithRole("Receptionist");
			for(int i = 0; i< users.size();i++){
				rowData = new Object[1];
				rowData[0] = users.get(i);
				tableModel.addRow(rowData);
			}
			System.out.println("ok");
			
		
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		}
		 
		 JButton btnApprove = new JButton("Approve Request");
		 btnApprove.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		String s  = (String) jt.getValueAt(jt.getSelectedRow(),0);
		 		hotel.approveReceptionist(s);
		 		tableModel.removeRow(jt.getSelectedRow());
		 	}
		 });
		 btnApprove.setBounds(241, 502, 217, 25);
		 pnlUserApprovals.add(btnApprove);
		 
		 JButton btnDeleteRequest = new JButton("Delete Request");
		 btnDeleteRequest.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		hotel.deleteUser((String) jt.getValueAt(jt.getSelectedRow(),0));
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
