package view;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.AbstractListModel;
import javax.swing.JOptionPane;

import java.text.ParseException;
import java.text.SimpleDateFormat; 

import domain.Hotel;
import domain.Room;
import javax.swing.JButton;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class Reservation extends javax.swing.JFrame {
	
	public Reservation(Hotel hotel) {
        initComponents(hotel);
    }
	
    private void initComponents(Hotel hotel) {
    	
    	jPanel1 = new javax.swing.JPanel();
        checkoutL = new javax.swing.JLabel();
        roomsSP = new javax.swing.JScrollPane();
        roomsList = new javax.swing.JList<>();
        reserveB = new javax.swing.JButton();
        checkoutFF = new javax.swing.JFormattedTextField();
        checkoutB = new javax.swing.JButton();
        roomsL = new javax.swing.JLabel();
        roomsL.setVisible(false);
        jLabel1 = new javax.swing.JLabel();
        checkinL = new javax.swing.JLabel();
        checkinFF = new javax.swing.JFormattedTextField();
        checkinB = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(720, 480));
        setMinimumSize(new java.awt.Dimension(720, 480));
        

        checkoutL.setText("Please, enter checkout date:");
        checkoutL.setVisible(false);

        roomsSP.setVisible(false);

        
        roomsList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        roomsList.setFixedCellHeight(20);
        roomsList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                roomsListValueChanged(evt);
            }
        });
        roomsSP.setViewportView(roomsList);

        reserveB.setText("Reserve");
        reserveB.setVisible(false);
        reserveB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
					reserveBActionPerformed(evt, hotel);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
        });

        checkoutFF.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("yyyy/MM/dd"))));
        checkoutFF.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        checkoutFF.setText("YYYY/MM/DD");
        checkoutFF.setVisible(false);

        checkoutB.setText("Enter");
        checkoutB.setVisible(false);
        checkoutB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
					enterBActionPerformed(evt, hotel);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
        });

        roomsL.setText("Avaliable rooms:");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("ROOM RESERVATION");
        
        checkinL.setText("Please, enter check-in date:");

        checkinFF.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("yyyy/MM/dd"))));
        checkinFF.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        checkinFF.setText("YYYY/MM/DD");
        

        checkinB.setText("Enter");
        checkinB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkinBActionPerformed(evt);
            }
        });
        
        lblCloseReservationPage = new JLabel();
        lblCloseReservationPage.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent arg0) {
        		dispose();
        	}
        });
        lblCloseReservationPage.setText("Close Reservation Page");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1Layout.setHorizontalGroup(
        	jPanel1Layout.createParallelGroup(Alignment.TRAILING)
        		.addGroup(jPanel1Layout.createSequentialGroup()
        			.addGap(277)
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING, false)
        				.addComponent(checkoutL, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        				.addGroup(jPanel1Layout.createSequentialGroup()
        					.addComponent(checkinFF, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE)
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(checkinB))
        				.addComponent(checkinL, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        				.addGroup(jPanel1Layout.createSequentialGroup()
        					.addComponent(checkoutFF, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE)
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(checkoutB)))
        			.addGap(0, 257, Short.MAX_VALUE))
        		.addGroup(jPanel1Layout.createSequentialGroup()
        			.addContainerGap(291, Short.MAX_VALUE)
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.TRAILING)
        				.addGroup(jPanel1Layout.createSequentialGroup()
        					.addComponent(reserveB)
        					.addGap(315))
        				.addGroup(jPanel1Layout.createSequentialGroup()
        					.addComponent(jLabel1)
        					.addGap(281))
        				.addGroup(jPanel1Layout.createSequentialGroup()
        					.addComponent(roomsL)
        					.addGap(313))
        				.addGroup(jPanel1Layout.createSequentialGroup()
        					.addComponent(roomsSP, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE)
        					.addGap(294))))
        		.addGroup(jPanel1Layout.createSequentialGroup()
        			.addContainerGap(569, Short.MAX_VALUE)
        			.addComponent(lblCloseReservationPage, GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
        	jPanel1Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel1Layout.createSequentialGroup()
        			.addGap(31)
        			.addComponent(jLabel1)
        			.addGap(33)
        			.addComponent(checkinL)
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(checkinFF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(checkinB, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
        			.addGap(25)
        			.addComponent(checkoutL)
        			.addGap(18)
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
        				.addComponent(checkoutB, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
        				.addComponent(checkoutFF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addPreferredGap(ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
        			.addComponent(roomsL)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(roomsSP, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE)
        			.addGap(45)
        			.addComponent(reserveB)
        			.addGap(18)
        			.addComponent(lblCloseReservationPage)
        			.addGap(8))
        );
        jPanel1.setLayout(jPanel1Layout);
        

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }

    private void reserveBActionPerformed(java.awt.event.ActionEvent evt, Hotel hotel) throws ParseException {
        
    	String chechoutDateFromTextField= checkoutFF.getText();
    	String cleanCheckoutDate = chechoutDateFromTextField.replaceAll("/", "");
    	int parsedCheckoutDate = Integer.parseInt(cleanCheckoutDate);
    	
    	String checkinDateFromTextField= checkinFF.getText();
    	String cleanCheckinDate = checkinDateFromTextField.replaceAll("/", "");
    	int parsedCheckinDate = Integer.parseInt(cleanCheckinDate);
    	
        ArrayList<Integer> requestedDates = new ArrayList<Integer>();
        
        requestedDates.add(parsedCheckinDate);
        for(int i = parsedCheckinDate+1; i < parsedCheckoutDate; i++) {
        	requestedDates.add(i);
        }
        requestedDates.add(parsedCheckoutDate);

    	boolean result = hotel.makeRoomReservation(Integer.parseInt(roomsList.getSelectedValue()), requestedDates);
    	
    	if(result) {
    		int input = JOptionPane.showOptionDialog(null, "Please, ask receptionst for you entry card", "Reservation Complete!", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, "OK");

            if(input == JOptionPane.OK_OPTION)
            {
            	this.setVisible(false);
            }
    	} else {
    		int input = JOptionPane.showOptionDialog(null, "Reservation did not successfully comlete", "Error!", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, "OK");

            if(input == JOptionPane.OK_OPTION)
            {
            	this.setVisible(false);
            }
    	}
        
    }

    private void enterBActionPerformed(java.awt.event.ActionEvent evt, Hotel hotel) throws ParseException {
    	roomsL.setVisible(true);
        roomsSP.setVisible(true);
        
        String chechoutDateFromTextField= checkoutFF.getText();
    	String cleanCheckoutDate = chechoutDateFromTextField.replaceAll("/", "");
    	int parsedChecoutDate = Integer.parseInt(cleanCheckoutDate);
    	
    	String checkinDateFromTextField= checkinFF.getText();
    	String cleanCheckinDate = checkinDateFromTextField.replaceAll("/", "");
    	int parsedCheckinDate = Integer.parseInt(cleanCheckinDate);
    	
        ArrayList<Integer> requestedDates = new ArrayList<Integer>();
        
        requestedDates.add(parsedCheckinDate);
        requestedDates.add(parsedChecoutDate);
        
        ArrayList<Integer> freeRooms = hotel.getFreeRooms(requestedDates); 
        ArrayList<String> roomNames = new ArrayList<String>(); 

        roomNames.clear();
        
        for(int i = 0; i < freeRooms.size(); i++) {
        	roomNames.add(freeRooms.get(i).toString());
        }
        
        
        if (roomNames.size() != 0 ) {
        	roomsList.setModel(new javax.swing.AbstractListModel<String>() {
                public int getSize() { return roomNames.size(); }
                public String getElementAt(int i) { return roomNames.get(i); }
            });
        } else {
        	roomsList.setModel(new javax.swing.AbstractListModel<String>() {
                public int getSize() { return roomNames.size(); }
                public String getElementAt(int i) { return roomNames.get(i); }
            });
        	int input = JOptionPane.showOptionDialog(null, "There are no available rooms for specified dates. Please, choose another date range", "No rooms", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, "OK");
        };
    }

    private void roomsListValueChanged(javax.swing.event.ListSelectionEvent evt) {
        // TODO add your handling code here:
        if(!reserveB.isVisible()){
            reserveB.setVisible(true);        
            }
    }

    private void checkinBActionPerformed(java.awt.event.ActionEvent evt) {
        checkoutL.setVisible(true);
        checkoutFF.setVisible(true);
        checkoutB.setVisible(true);
    }

    private javax.swing.JButton checkinB;
    private javax.swing.JFormattedTextField checkinFF;
    private javax.swing.JLabel checkinL;
    private javax.swing.JButton checkoutB;
    private javax.swing.JFormattedTextField checkoutFF;
    private javax.swing.JLabel checkoutL;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton reserveB;
    private javax.swing.JLabel roomsL;
    private javax.swing.JList<String> roomsList;
    private javax.swing.JScrollPane roomsSP;
    private JLabel lblCloseReservationPage;
}
