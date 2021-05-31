package view;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import javax.swing.JOptionPane;

import domain.Hotel;
import domain.HotelGuest;
import domain.Room;
import domain.User;
import javax.swing.JLabel;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ReservationWithReceptionist extends javax.swing.JFrame {

	public ReservationWithReceptionist(Hotel hotel) {
        initComponents(hotel);
    }
	
	private void initComponents(Hotel hotel) {

        jPanel1 = new javax.swing.JPanel();
        checkoutL = new javax.swing.JLabel();
        guestsSP = new javax.swing.JScrollPane();
        guestsList = new javax.swing.JList<>();
        reserveB = new javax.swing.JButton();
        checkoutFF = new javax.swing.JFormattedTextField();
        checkoutB = new javax.swing.JButton();
        roomsL = new javax.swing.JLabel();
        roomsL.setVisible(false);
        jLabel1 = new javax.swing.JLabel();
        checkinL = new javax.swing.JLabel();
        checkinFF = new javax.swing.JFormattedTextField();
        checkinB = new javax.swing.JButton();
        guestsL = new javax.swing.JLabel();
        guestsL.setVisible(false);
        roomsSP = new javax.swing.JScrollPane();
        roomsList = new javax.swing.JList<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(720, 480));
        setMinimumSize(new java.awt.Dimension(720, 480));

        checkoutL.setText("Please, enter checkout date:");
        checkoutL.setVisible(false);

        guestsSP.setVisible(false);

        guestsList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "guest 1", "guest 2", "guest 3", "guest 4", "guest 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        guestsList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        guestsList.setFixedCellHeight(20);
        guestsList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                try {
					guestsListValueChanged(evt, hotel);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
        });
        guestsSP.setViewportView(guestsList);

        reserveB.setText("Reserve");
        reserveB.setVisible(false);
        reserveB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reserveBActionPerformed(evt, hotel);
            }
        });

        checkinFF.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("yyyy/MM/dd"))));
        checkoutFF.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        checkoutFF.setText("YYYY/MM/DD");
        checkoutFF.setVisible(false);

        checkoutB.setText("Enter");
        checkoutB.setVisible(false);
        checkoutB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkoutBActionPerformed(evt, hotel);
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

        guestsL.setText("Choose a guest:");

        roomsSP.setVisible(false);

        roomsList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "room 1", "room 2", "room 3", "room 4", "room 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        roomsList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        roomsList.setFixedCellHeight(20);
        roomsList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                roomsListValueChanged(evt);
            }
        });
        roomsSP.setViewportView(roomsList);
        
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
        	jPanel1Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel1Layout.createSequentialGroup()
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(jPanel1Layout.createSequentialGroup()
        					.addGap(188)
        					.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING, false)
        						.addComponent(guestsL, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        						.addComponent(guestsSP, GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE))
        					.addGap(127)
        					.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING, false)
        						.addComponent(roomsSP, GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)
        						.addComponent(roomsL, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        				.addGroup(jPanel1Layout.createSequentialGroup()
        					.addGap(277)
        					.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
        						.addGroup(jPanel1Layout.createSequentialGroup()
        							.addComponent(checkoutFF, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE)
        							.addPreferredGap(ComponentPlacement.RELATED)
        							.addComponent(checkoutB))
        						.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING, false)
        							.addComponent(checkoutL, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        							.addComponent(checkinL, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        							.addGroup(jPanel1Layout.createSequentialGroup()
        								.addGap(48)
        								.addComponent(reserveB))
        							.addGroup(jPanel1Layout.createSequentialGroup()
        								.addComponent(checkinFF, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE)
        								.addPreferredGap(ComponentPlacement.RELATED)
        								.addComponent(checkinB)))))
        				.addGroup(jPanel1Layout.createSequentialGroup()
        					.addGap(290)
        					.addComponent(jLabel1)))
        			.addContainerGap(194, Short.MAX_VALUE))
        		.addGroup(Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
        			.addContainerGap(579, Short.MAX_VALUE)
        			.addComponent(lblCloseReservationPage, GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
        	jPanel1Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel1Layout.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(jLabel1)
        			.addGap(39)
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.TRAILING)
        				.addGroup(jPanel1Layout.createSequentialGroup()
        					.addComponent(checkinL)
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
        						.addComponent(checkinFF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        						.addComponent(checkinB, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
        					.addPreferredGap(ComponentPlacement.UNRELATED)
        					.addComponent(checkoutL)
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
        						.addComponent(checkoutFF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        						.addComponent(checkoutB, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
        					.addGap(30)
        					.addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
        						.addComponent(guestsL, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
        						.addComponent(roomsL))
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(guestsSP, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE))
        				.addComponent(roomsSP, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE))
        			.addPreferredGap(ComponentPlacement.RELATED, 79, Short.MAX_VALUE)
        			.addComponent(reserveB)
        			.addGap(18)
        			.addComponent(lblCloseReservationPage)
        			.addGap(9))
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

    private void reserveBActionPerformed(java.awt.event.ActionEvent evt, Hotel hotel) {
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
         
        boolean result = hotel.makeRoomReservation(1, Integer.parseInt(roomsList.getSelectedValue()), requestedDates);
        
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

    private void checkoutBActionPerformed(java.awt.event.ActionEvent evt, Hotel hotel) {    	
    	HashMap<Integer,HotelGuest> hotelGuests = hotel.hotelGuests;
    	
    	ArrayList<String> hotelGuestsNames = new ArrayList<String>();
    	
    	for (int i = 1; i< hotelGuests.size()+1; i++) {
    		hotelGuestsNames.add(hotelGuests.get(i).getUserName());
    	}
    	
    	if (hotelGuestsNames.size() != 0 ) {
    		guestsList.setModel(new javax.swing.AbstractListModel<String>() {
                public int getSize() { return hotelGuestsNames.size(); }
                public String getElementAt(int i) { return hotelGuestsNames.get(i); }
            });
        } else {
        	guestsList.setModel(new javax.swing.AbstractListModel<String>() {
                public int getSize() { return hotelGuestsNames.size(); }
                public String getElementAt(int i) { return hotelGuestsNames.get(i); }
            });
        	int input = JOptionPane.showOptionDialog(null, "There are no registered users int the system", "No users", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, "OK");
        };
        
    	guestsL.setVisible(true);
        guestsSP.setVisible(true);
        
        
    }

    private void guestsListValueChanged(javax.swing.event.ListSelectionEvent evt, Hotel hotel) throws ParseException {
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
         
    	roomsL.setVisible(true);
        roomsSP.setVisible(true);
    }

    private void checkinBActionPerformed(java.awt.event.ActionEvent evt) {
        checkoutL.setVisible(true);
        checkoutFF.setVisible(true);
        checkoutB.setVisible(true);
    }

    private void roomsListValueChanged(javax.swing.event.ListSelectionEvent evt) {
        reserveB.setVisible(true);
    }

    private javax.swing.JButton checkinB;
    private javax.swing.JFormattedTextField checkinFF;
    private javax.swing.JLabel checkinL;
    private javax.swing.JButton checkoutB;
    private javax.swing.JFormattedTextField checkoutFF;
    private javax.swing.JLabel checkoutL;
    private javax.swing.JLabel guestsL;
    private javax.swing.JList<String> guestsList;
    private javax.swing.JScrollPane guestsSP;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton reserveB;
    private javax.swing.JLabel roomsL;
    private javax.swing.JList<String> roomsList;
    private javax.swing.JScrollPane roomsSP;
    private JLabel lblCloseReservationPage;
}
