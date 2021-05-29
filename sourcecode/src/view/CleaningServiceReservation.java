package view;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;

import domain.Hotel;
import domain.User;

public class CleaningServiceReservation extends javax.swing.JFrame{
	 public CleaningServiceReservation() {
	        initComponents();   
	    }
	 
	 public Hotel hotel = new Hotel();
	 private void initComponents() {

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
						reserveBActionPerformed(evt);
					} catch (ParseException e) {
						e.printStackTrace();
					}
	            }
	        });

	        dateTF.setFont(new java.awt.Font("Tahoma", 0, 14));
	        dateTF.setHorizontalAlignment(javax.swing.JTextField.CENTER);
	        dateTF.setText("DD/MM/YYYY");

	        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
	        jPanel1.setLayout(jPanel1Layout);
	        jPanel1Layout.setHorizontalGroup(
	            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(jPanel1Layout.createSequentialGroup()
	                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
	                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                            .addComponent(headerL, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 504, javax.swing.GroupLayout.PREFERRED_SIZE)
	                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
	                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
	                                .addGap(22, 22, 22))))
	                    .addGroup(jPanel1Layout.createSequentialGroup()
	                        .addGap(160, 160, 160)
	                        .addComponent(dateL)
	                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 120, Short.MAX_VALUE)
	                        .addComponent(timeSlotL, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
	                        .addGap(56, 56, 56))
	                    .addGroup(jPanel1Layout.createSequentialGroup()
	                        .addGap(160, 160, 160)
	                        .addComponent(dateTF, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
	                        .addGap(0, 0, Short.MAX_VALUE)))
	                .addGap(91, 91, 91))
	            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
	                .addGap(0, 0, Short.MAX_VALUE)
	                .addComponent(reserveB, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
	                .addGap(234, 234, 234))
	        );
	        jPanel1Layout.setVerticalGroup(
	            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(jPanel1Layout.createSequentialGroup()
	                .addContainerGap()
	                .addComponent(headerL)
	                .addGap(71, 71, 71)
	                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                    .addComponent(dateL)
	                    .addComponent(timeSlotL))
	                .addGap(18, 18, 18)
	                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
	                    .addComponent(dateTF, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
	                .addGap(18, 18, 18)
	                .addComponent(reserveB, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
	                .addContainerGap(44, Short.MAX_VALUE))
	        );

	        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
	        getContentPane().setLayout(layout);
	        layout.setHorizontalGroup(
	            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	        );
	        layout.setVerticalGroup(
	            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	        );

	        pack();
	    }

	    private void reserveBActionPerformed(java.awt.event.ActionEvent evt) throws ParseException {//GEN-FIRST:event_reserveBActionPerformed
	        // TODO add your handling code here:
	    	
	    	Date chosenDate = new SimpleDateFormat("dd/MM/yyyy").parse(dateTF.getText());
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
	    	
	    	
	    	int input = JOptionPane.showOptionDialog(null, "You have successfully ordered cleaning service", "Reservation Complete!", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, "OK");

	        if(input == JOptionPane.OK_OPTION)
	        {
	        	this.setVisible(false);
	        }
	    }

	    private void timeSlotListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_timeSlotListValueChanged
	        
	        if(!dateTF.getText().equals("DD/MM/YYYY")){
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

}
