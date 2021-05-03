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
        dateL = new javax.swing.JLabel();
        roomsSP = new javax.swing.JScrollPane();
        roomsList = new javax.swing.JList<>();
        reserveB = new javax.swing.JButton();
        dateFF = new javax.swing.JFormattedTextField();
        enterB = new javax.swing.JButton();
        roomsL = new javax.swing.JLabel();
        roomsL.setVisible(false);
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(720, 480));
        setMinimumSize(new java.awt.Dimension(720, 480));

        dateL.setText("Please, enter checkout date:");

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

        dateFF.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("d/M/y"))));
        dateFF.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        dateFF.setText("5/5/2021");

        enterB.setText("Enter");
        enterB.addActionListener(new java.awt.event.ActionListener() {
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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(277, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(dateFF, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(enterB)
                        .addGap(257, 257, 257))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(roomsL)
                        .addGap(310, 310, 310))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(roomsSP, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(296, 296, 296))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(reserveB)
                        .addGap(318, 318, 318))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(dateL))
                        .addGap(266, 266, 266))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel1)
                .addGap(63, 63, 63)
                .addComponent(dateL)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dateFF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(enterB, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addComponent(roomsL)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(roomsSP, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(reserveB)
                .addContainerGap(102, Short.MAX_VALUE))
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
        
        Date checkoutDate = new SimpleDateFormat("dd/MM/yyyy").parse(dateFF.getText());
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
        
        ArrayList<Room> freeRooms = hotel.getFreeRooms(new SimpleDateFormat("dd/MM/yyyy").parse(dateFF.getText()));
        
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
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Reservation().setVisible(true);
            }
        });
    }
    private javax.swing.JFormattedTextField dateFF;
    private javax.swing.JLabel dateL;
    private javax.swing.JButton enterB;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton reserveB;
    private javax.swing.JLabel roomsL;
    private javax.swing.JList<String> roomsList;
    private javax.swing.JScrollPane roomsSP;
}
