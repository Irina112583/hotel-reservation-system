package view;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;

import domain.Hotel;
import domain.User;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CleaningServiceReservation extends javax.swing.JFrame{
	 public CleaningServiceReservation(Hotel hotel) {
	        initComponents(hotel);   
	    }
	 
	 private void initComponents(Hotel hotel) {

	        jPanel1 = new javax.swing.JPanel();
	        headerL = new javax.swing.JLabel();
	        dateL = new javax.swing.JLabel();
	        jScrollPane1 = new javax.swing.JScrollPane();
	        timeSlotList = new javax.swing.JList<>();
	        timeSlotL = new javax.swing.JLabel();
	        reserveB = new javax.swing.JButton();
	        dateTF = new javax.swing.JTextField();

	        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
	        setMaximumSize(new java.awt.Dimension(720, 480));
	        setMinimumSize(new java.awt.Dimension(720, 480));
	        setPreferredSize(new java.awt.Dimension(720, 480));

	        headerL.setFont(new java.awt.Font("Tahoma", 1, 24));
	        headerL.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
	        headerL.setText("Reserve Additional Cleaning Service");

	        dateL.setFont(new java.awt.Font("Tahoma", 0, 18));
	        dateL.setText("Choose a Date:");

	        timeSlotList.setFont(new java.awt.Font("Tahoma", 0, 14));
	        timeSlotList.setModel(new javax.swing.AbstractListModel<String>() {
	            String[] strings = { "8:00 - 9:00", "9:00 - 10:00", "10:00 - 11:00", "11:00 - 12:00", "12:00 - 13:00", "13:00 - 14:00", "14:00 - 15:00", "15:00 - 16:00", "16:00 - 17:00", "17:00 - 18:00" };
	            public int getSize() { return strings.length; }
	            public String getElementAt(int i) { return strings[i]; }
	        });
	        timeSlotList.setVisibleRowCount(10);
	        timeSlotList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
	            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
	                timeSlotListValueChanged(evt);
	            }
	        });
	        jScrollPane1.setViewportView(timeSlotList);

	        timeSlotL.setFont(new java.awt.Font("Tahoma", 0, 18));
	        timeSlotL.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
	        timeSlotL.setText("Choose a Time Slot:");

	        reserveB.setFont(new java.awt.Font("Tahoma", 0, 14));
	        reserveB.setText("Reserve");
	        reserveB.setEnabled(false);
	        reserveB.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	                try {
						reserveBActionPerformed(evt, hotel);
					} catch (ParseException e) {
						e.printStackTrace();
					}
	            }
	        });

	        dateTF.setFont(new java.awt.Font("Tahoma", 0, 14));
	        dateTF.setHorizontalAlignment(javax.swing.JTextField.CENTER);
	        dateTF.setText("YYYY/MM/DD");
	        
	        lblCloseReservationPage = new JLabel();
	        lblCloseReservationPage.addMouseListener(new MouseAdapter() {
	        	@Override
	        	public void mouseClicked(MouseEvent e) {
	        		dispose();
	        	}
	        });
	        lblCloseReservationPage.setText("Close Reservation Page");

	        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
	        jPanel1Layout.setHorizontalGroup(
	        	jPanel1Layout.createParallelGroup(Alignment.TRAILING)
	        		.addGroup(jPanel1Layout.createSequentialGroup()
	        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.TRAILING)
	        				.addGroup(jPanel1Layout.createSequentialGroup()
	        					.addContainerGap(107, Short.MAX_VALUE)
	        					.addGroup(jPanel1Layout.createParallelGroup(Alignment.TRAILING)
	        						.addComponent(headerL, GroupLayout.PREFERRED_SIZE, 504, GroupLayout.PREFERRED_SIZE)
	        						.addGroup(jPanel1Layout.createSequentialGroup()
	        							.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 224, GroupLayout.PREFERRED_SIZE)
	        							.addGap(22))))
	        				.addGroup(Alignment.LEADING, jPanel1Layout.createSequentialGroup()
	        					.addGap(160)
	        					.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
	        						.addGroup(jPanel1Layout.createSequentialGroup()
	        							.addComponent(dateL)
	        							.addPreferredGap(ComponentPlacement.RELATED, 100, Short.MAX_VALUE)
	        							.addComponent(timeSlotL, GroupLayout.PREFERRED_SIZE, 172, GroupLayout.PREFERRED_SIZE)
	        							.addGap(58))
	        						.addGroup(jPanel1Layout.createSequentialGroup()
	        							.addComponent(dateTF, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE)
	        							.addPreferredGap(ComponentPlacement.RELATED, 334, Short.MAX_VALUE)))))
	        			.addGap(91))
	        		.addGroup(jPanel1Layout.createSequentialGroup()
	        			.addGap(0, 224, Short.MAX_VALUE)
	        			.addComponent(reserveB, GroupLayout.PREFERRED_SIZE, 244, GroupLayout.PREFERRED_SIZE)
	        			.addGap(78)
	        			.addComponent(lblCloseReservationPage, GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE)
	        			.addContainerGap())
	        );
	        jPanel1Layout.setVerticalGroup(
	        	jPanel1Layout.createParallelGroup(Alignment.LEADING)
	        		.addGroup(jPanel1Layout.createSequentialGroup()
	        			.addContainerGap()
	        			.addComponent(headerL)
	        			.addGap(44)
	        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
	        				.addComponent(dateL)
	        				.addComponent(timeSlotL))
	        			.addPreferredGap(ComponentPlacement.UNRELATED)
	        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
	        				.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 220, GroupLayout.PREFERRED_SIZE)
	        				.addComponent(dateTF, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
	        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.TRAILING)
	        				.addGroup(jPanel1Layout.createSequentialGroup()
	        					.addGap(18)
	        					.addComponent(reserveB, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
	        					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
	        				.addGroup(jPanel1Layout.createSequentialGroup()
	        					.addPreferredGap(ComponentPlacement.RELATED)
	        					.addComponent(lblCloseReservationPage)
	        					.addContainerGap())))
	        );
	        jPanel1.setLayout(jPanel1Layout);

	        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
	        layout.setHorizontalGroup(
	        	layout.createParallelGroup(Alignment.LEADING)
	        		.addComponent(jPanel1, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 702, Short.MAX_VALUE)
	        );
	        layout.setVerticalGroup(
	        	layout.createParallelGroup(Alignment.LEADING)
	        		.addGroup(layout.createSequentialGroup()
	        			.addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, 428, GroupLayout.PREFERRED_SIZE)
	        			.addContainerGap(23, Short.MAX_VALUE))
	        );
	        getContentPane().setLayout(layout);

	        pack();
	    }

	    private void reserveBActionPerformed(java.awt.event.ActionEvent evt,  Hotel hotel) throws ParseException {//GEN-FIRST:event_reserveBActionPerformed
	        // TODO add your handling code here:
	    	
	    	String dateFromTextField= dateTF.getText();
	    	String cleanDate = dateFromTextField.replaceAll("/", "");
	    	int chosenDate = Integer.parseInt(cleanDate);
	    	
	    	int choosenTimeSlote = 0;
	    	
	    	switch(timeSlotList.getSelectedValue()) {
	    	  case "8:00 - 9:00":
	    		choosenTimeSlote = 1;
	    	    break;
	    	  case "9:00 - 10:00":
	    		  choosenTimeSlote = 2;
		    	  break;
	    	  case "10:00 - 11:00":
	    		  choosenTimeSlote = 3;
		    	  break;
	    	  case "11:00 - 12:00":
	    		  choosenTimeSlote = 4;
		    	  break;
	    	  case "12:00 - 13:00":
	    		  choosenTimeSlote = 5;
		    	  break;
	    	  case "13:00 - 14:00":
	    		  choosenTimeSlote = 6;
		    	  break;
	    	  case "14:00 - 15:00":
	    		  choosenTimeSlote = 7;
		    	  break;
	    	  case "15:00 - 16:00":
	    		  choosenTimeSlote = 8;
		    	  break;
	    	  case "16:00 - 17:00":
	    		  choosenTimeSlote = 9;
		    	  break;
	    	  case "17:00 - 18:00":
	    		  choosenTimeSlote = 10;
		    	  break;
	    	  default:
	    		  choosenTimeSlote = 0;
		    	  break;
	    	}
	    	
	    	System.out.println(chosenDate);
	    	System.out.println(choosenTimeSlote);
	    	

	    	boolean result = hotel.makeCleaningReservation(chosenDate, choosenTimeSlote);
	    	
	    	int input;
	    	if(result == true ) {
	    		input = JOptionPane.showOptionDialog(null, "You have successfully ordered cleaning service", "Reservation Complete!", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, "OK");
	    		if(input == JOptionPane.OK_OPTION)
		        {
		        	this.setVisible(false);
		        }
	    	} else {
	    		input = JOptionPane.showOptionDialog(null, "Your order was not complete! Please, repeat later", "Error!", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, "OK");
	    		if(input == JOptionPane.OK_OPTION)
		        {
		        	this.setVisible(false);
		        }
	    	}  
	    }

	    private void timeSlotListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_timeSlotListValueChanged
	        
	        if(!dateTF.getText().equals("YYYY/MM/DD")){
	        reserveB.setEnabled(true);        
	        }                          
	    }
	    

	    private javax.swing.JLabel dateL;
	    private javax.swing.JTextField dateTF;
	    private javax.swing.JLabel headerL;
	    private javax.swing.JPanel jPanel1;
	    private javax.swing.JScrollPane jScrollPane1;
	    private javax.swing.JButton reserveB;
	    private javax.swing.JLabel timeSlotL;
	    private javax.swing.JList<String> timeSlotList;
	    private JLabel lblCloseReservationPage;

}
