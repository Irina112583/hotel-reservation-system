package view;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.AbstractListModel;
import javax.swing.JOptionPane;

import java.text.ParseException;
import java.text.SimpleDateFormat; 

import domain.Hotel;
import domain.Room;


public class Reservation extends javax.swing.JFrame {
	
	public Reservation() {
        initComponents();
    }
	
    @SuppressWarnings("unchecked")
    private void initComponents() {
    	
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
					reserveBActionPerformed(evt);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
        });

        checkoutFF.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("d/M/y"))));
        checkoutFF.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        checkoutFF.setText("5/5/2021");
        checkoutFF.setVisible(false);

        checkoutB.setText("Enter");
        checkoutB.setVisible(false);
        checkoutB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
					enterBActionPerformed(evt);
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

        checkinFF.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("d/M/y"))));
        checkinFF.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        checkinFF.setText("1/1/2001");

        checkinB.setText("Enter");
        checkinB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkinBActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(277, 277, 277)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(checkoutL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(checkinFF, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(checkinB))
                    .addComponent(checkinL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(checkoutFF, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(checkoutB)))
                .addGap(0, 257, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(reserveB)
                        .addGap(315, 315, 315))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(281, 281, 281))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(roomsL)
                        .addGap(313, 313, 313))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(roomsSP, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(294, 294, 294))))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(31, 31, 31)
                    .addComponent(jLabel1)
                    .addGap(33, 33, 33)
                    .addComponent(checkinL)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(checkinFF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(checkinB, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(25, 25, 25)
                    .addComponent(checkoutL)
                    .addGap(18, 18, 18)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(checkoutB, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(checkoutFF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                    .addComponent(roomsL)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(roomsSP, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(45, 45, 45)
                    .addComponent(reserveB)
                    .addGap(42, 42, 42))
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

    private void reserveBActionPerformed(java.awt.event.ActionEvent evt) throws ParseException {
        String roomName = roomsList.getSelectedValue();
        
        Hotel hotel = new Hotel();
        
        Date checkoutDate = new SimpleDateFormat("dd/MM/yyyy").parse(checkoutFF.getText());
        hotel.assignRoomToHotelGuest("username", roomName, checkoutDate);
        int input = JOptionPane.showOptionDialog(null, "Please, ask receptionst for you entry card", "Reservation Complete!", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, "OK");

        if(input == JOptionPane.OK_OPTION)
        {
        	this.setVisible(false);
        }
    }

    private void enterBActionPerformed(java.awt.event.ActionEvent evt) throws ParseException {
    	roomsL.setVisible(true);
        roomsSP.setVisible(true);
        
        Hotel hotel = new Hotel();
        ArrayList<Room> freeRooms = hotel.getFreeRooms(new SimpleDateFormat("dd/MM/yyyy").parse(checkoutFF.getText()));
        
        ArrayList<String> roomNames = new ArrayList<String>(); 
        
        roomNames.clear();
        
        for(int i=0; i < freeRooms.size(); i++) {
        	String newRoomName = freeRooms.get(i).roomName;
        		roomNames.add(newRoomName);	
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
            reserveB.setVisible(true);        }
    }

    private void checkinBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkinBActionPerformed
        checkoutL.setVisible(true);
        checkoutFF.setVisible(true);
        checkoutB.setVisible(true);
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
       
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Reservation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Reservation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Reservation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Reservation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Reservation().setVisible(true);
            }
        });
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
}
