package view;

public class MonitorServiceReservation extends javax.swing.JFrame {

	public MonitorServiceReservation() {
        initComponents();
    }

    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        serviceNameL = new javax.swing.JLabel();
        occTimeSlotL = new javax.swing.JLabel();
        timeL = new javax.swing.JLabel();
        currentAvL = new javax.swing.JLabel();
        availabilityL = new javax.swing.JLabel();
        currentGuestL = new javax.swing.JLabel();
        guestL = new javax.swing.JLabel();
        okB = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(720, 480));
        setMinimumSize(new java.awt.Dimension(720, 480));

        serviceNameL.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        serviceNameL.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        serviceNameL.setText("Service Name");

        occTimeSlotL.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        occTimeSlotL.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        occTimeSlotL.setText("Occupied Time Slots:");

        timeL.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        timeL.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        timeL.setText("01/01/2001");

        currentAvL.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        currentAvL.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        currentAvL.setText("Current Availability Status:");

        availabilityL.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        availabilityL.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        availabilityL.setText("testAvailibility");

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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(135, 135, 135)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(currentAvL, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(occTimeSlotL)
                    .addComponent(currentGuestL, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(timeL, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(availabilityL, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(guestL, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(95, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(serviceNameL, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(278, 278, 278))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(okB, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(300, 300, 300))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addComponent(serviceNameL)
                .addGap(50, 50, 50)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(occTimeSlotL)
                    .addComponent(timeL))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(currentAvL)
                    .addComponent(availabilityL))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(currentGuestL)
                    .addComponent(guestL))
                .addGap(47, 47, 47)
                .addComponent(okB)
                .addContainerGap(186, Short.MAX_VALUE))
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
    private javax.swing.JLabel guestL;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel occTimeSlotL;
    private javax.swing.JButton okB;
    private javax.swing.JLabel serviceNameL;
    private javax.swing.JLabel timeL;
}
