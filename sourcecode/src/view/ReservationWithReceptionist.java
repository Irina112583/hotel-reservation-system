package view;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;

import domain.Hotel;
import domain.Room;

public class ReservationWithReceptionist extends javax.swing.JFrame {

	public ReservationWithReceptionist() {
        initComponents();
    }
	
	private void initComponents() {

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
					guestsListValueChanged(evt);
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
                reserveBActionPerformed(evt);
            }
        });

        checkoutFF.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("d/M/y"))));
        checkoutFF.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        checkoutFF.setText("1/1/2001");
        checkoutFF.setVisible(false);

        checkoutB.setText("Enter");
        checkoutB.setVisible(false);
        checkoutB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkoutBActionPerformed(evt);
            }
        });

        roomsL.setText("Avaliable rooms:");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("ROOM RESERVATION");

        checkinL.setText("Please, enter check-in date:");

        checkinFF.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("d/M/y"))));
        checkinFF.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        checkinFF.setText("1/1/2001");

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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(188, 188, 188)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(guestsL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(guestsSP, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE))
                        .addGap(127, 127, 127)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(roomsSP, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)
                            .addComponent(roomsL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(277, 277, 277)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(checkoutFF, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(checkoutB))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(checkoutL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(checkinL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(48, 48, 48)
                                    .addComponent(reserveB))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(checkinFF, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(checkinB))))))
                .addGap(0, 194, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(290, 290, 290)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(39, 39, 39)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(checkinL)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(checkinFF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(checkinB, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(checkoutL)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(checkoutFF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(checkoutB, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(guestsL, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(roomsL))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(guestsSP, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(roomsSP, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 79, Short.MAX_VALUE)
                .addComponent(reserveB)
                .addGap(43, 43, 43))
        );

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

    private void reserveBActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        
    }

    private void checkoutBActionPerformed(java.awt.event.ActionEvent evt) {
    	Hotel hotel = new Hotel();
//    	ArrayList<String> userNames = hotel.getUsernames();
    	
    	ArrayList<String> userNames = new ArrayList<String>();
    	userNames.add("User 1");
    	userNames.add("User 2");
    	userNames.add("User 3");
    	userNames.add("User 4");
    	userNames.add("User 5");
    	userNames.add("User 6");
    	userNames.add("User 7");
    	userNames.add("User 8");
    	userNames.add("User 9");
    	userNames.add("User 10");
    	
    	if (userNames.size() != 0 ) {
    		guestsList.setModel(new javax.swing.AbstractListModel<String>() {
                public int getSize() { return userNames.size(); }
                public String getElementAt(int i) { return userNames.get(i); }
            });
        } else {
        	guestsList.setModel(new javax.swing.AbstractListModel<String>() {
                public int getSize() { return userNames.size(); }
                public String getElementAt(int i) { return userNames.get(i); }
            });
        	int input = JOptionPane.showOptionDialog(null, "There are no registered users int the system", "No users", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, "OK");
        };
        
    	guestsL.setVisible(true);
        guestsSP.setVisible(true);
        
        
    }

    private void guestsListValueChanged(javax.swing.event.ListSelectionEvent evt) throws ParseException {
    	 Hotel hotel = new Hotel();
//         ArrayList<Room> freeRooms = hotel.getFreeRooms(new SimpleDateFormat("dd/MM/yyyy").parse(checkoutFF.getText()));
         
         ArrayList<String> roomNames = new ArrayList<String>(); 
         
         roomNames.clear();
         
         roomNames.add("Room 1");
         roomNames.add("Room 2");
         roomNames.add("Room 3");
         roomNames.add("Room 4");
         roomNames.add("Room 5");
         roomNames.add("Room 6");
         roomNames.add("Room 7");
         roomNames.add("Room 8");
         roomNames.add("Room 9");
         roomNames.add("Room 10");
         
         
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
}
