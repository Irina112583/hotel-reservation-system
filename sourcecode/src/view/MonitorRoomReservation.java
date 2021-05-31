package view;

import domain.Hotel;

public class MonitorRoomReservation extends javax.swing.JFrame {
	public MonitorRoomReservation(Hotel hotel, String selectedRoom, String selectedOccupiedDates, String selectedStatus) {
        initComponents(hotel, selectedRoom, selectedOccupiedDates, selectedStatus);
    }


	private void initComponents(Hotel hotel, String selectedRoom, String selectedOccupiedDates, String selectedStatus) {

        jPanel1 = new javax.swing.JPanel();
        roomL = new javax.swing.JLabel();
        occupiedDatesL = new javax.swing.JLabel();
        datesL = new javax.swing.JLabel();
        availabilityL = new javax.swing.JLabel();
        currentGuestL = new javax.swing.JLabel();
        guestL = new javax.swing.JLabel();
        okB = new javax.swing.JButton();
        currentAvL = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(720, 480));
        setMinimumSize(new java.awt.Dimension(720, 480));

        roomL.setFont(new java.awt.Font("Tahoma", 0, 18));
        roomL.setText("Room Number" + selectedRoom);

        occupiedDatesL.setFont(new java.awt.Font("Tahoma", 0, 18));
        occupiedDatesL.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        occupiedDatesL.setText("Occupied Dates:");

        datesL.setFont(new java.awt.Font("Tahoma", 0, 18)); 
        datesL.setText(selectedOccupiedDates);

        availabilityL.setFont(new java.awt.Font("Tahoma", 0, 18));
        availabilityL.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        availabilityL.setText(selectedStatus);

        currentGuestL.setFont(new java.awt.Font("Tahoma", 0, 18));
        currentGuestL.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        currentGuestL.setText("Current Guest:");

        guestL.setFont(new java.awt.Font("Tahoma", 0, 18)); 
        guestL.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        guestL.setText("No guest");

        okB.setFont(new java.awt.Font("Tahoma", 0, 18)); 
        okB.setText("OK");
        okB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	okBActionPerformed(evt);
            }
        });

        currentAvL.setFont(new java.awt.Font("Tahoma", 0, 18));
        currentAvL.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        currentAvL.setText("Current Availability Status:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(240, 240, 240)
                        .addComponent(occupiedDatesL)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(datesL, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(302, 302, 302)
                        .addComponent(roomL))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(136, 136, 136)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(currentGuestL, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(currentAvL, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(guestL, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(availabilityL, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(301, 301, 301)
                        .addComponent(okB, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(100, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(roomL)
                .addGap(66, 66, 66)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(occupiedDatesL)
                    .addComponent(datesL))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(availabilityL)
                    .addComponent(currentAvL))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(currentGuestL)
                    .addComponent(guestL))
                .addGap(62, 62, 62)
                .addComponent(okB)
                .addContainerGap(155, Short.MAX_VALUE))
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
        setLocationRelativeTo(null);
	}

	private void okBActionPerformed(java.awt.event.ActionEvent evt) {
	    this.setVisible(false);
	}
	 
    private javax.swing.JLabel availabilityL;
    private javax.swing.JLabel currentAvL;
    private javax.swing.JLabel currentGuestL;
    private javax.swing.JLabel datesL;
    private javax.swing.JLabel guestL;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel occupiedDatesL;
    private javax.swing.JButton okB;
    private javax.swing.JLabel roomL;
}
