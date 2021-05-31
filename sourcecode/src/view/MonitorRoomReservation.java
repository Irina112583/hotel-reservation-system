package view;

public class MonitorRoomReservation extends javax.swing.JFrame {
	public MonitorRoomReservation() {
        initComponents();
    }


    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        roomL = new javax.swing.JLabel();
        occupiedDatesL = new javax.swing.JLabel();
        datesL = new javax.swing.JLabel();
        availabilityL = new javax.swing.JLabel();
        currentDebtL = new javax.swing.JLabel();
        debtL = new javax.swing.JLabel();
        currentGuestL = new javax.swing.JLabel();
        guestL = new javax.swing.JLabel();
        okB = new javax.swing.JButton();
        currentAvL = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(720, 480));
        setMinimumSize(new java.awt.Dimension(720, 480));

        roomL.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        roomL.setText("Room Number");

        occupiedDatesL.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        occupiedDatesL.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        occupiedDatesL.setText("Occupied Dates:");

        datesL.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        datesL.setText("01/01/2001");

        availabilityL.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        availabilityL.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        availabilityL.setText("testAVAILABLE");

        currentDebtL.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        currentDebtL.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        currentDebtL.setText("Current Debt:");

        debtL.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        debtL.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        debtL.setText("99");

        currentGuestL.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        currentGuestL.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        currentGuestL.setText("Current Guest:");

        guestL.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        guestL.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        guestL.setText("guest1");

        okB.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        okB.setText("OK");
        okB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	okBActionPerformed(evt);
            }
        });

        currentAvL.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        currentAvL.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        currentAvL.setText("Current Availability Status:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(okB, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(298, 298, 298))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(240, 240, 240)
                        .addComponent(occupiedDatesL)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(datesL, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGap(240, 240, 240)
                                .addComponent(currentGuestL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGap(252, 252, 252)
                                .addComponent(currentDebtL, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(currentAvL, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(debtL, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(guestL, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(availabilityL, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(302, 302, 302)
                        .addComponent(roomL)))
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
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(debtL)
                    .addComponent(currentDebtL))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(currentGuestL)
                    .addComponent(guestL))
                .addGap(41, 41, 41)
                .addComponent(okB)
                .addContainerGap(143, Short.MAX_VALUE))
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
    private javax.swing.JLabel currentDebtL;
    private javax.swing.JLabel currentGuestL;
    private javax.swing.JLabel datesL;
    private javax.swing.JLabel debtL;
    private javax.swing.JLabel guestL;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel occupiedDatesL;
    private javax.swing.JButton okB;
    private javax.swing.JLabel roomL;
}
