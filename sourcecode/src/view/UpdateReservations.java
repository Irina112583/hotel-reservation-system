package view;

import domain.Hotel;

public class UpdateReservations extends javax.swing.JFrame{
	
	Object[][] tableData;
   
    public UpdateReservations() {
        
        initTableMembers();        
        initComponents();   
    }

	
	private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        reservationsL = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        reservationsT = new javax.swing.JTable();
		makeChangesB = new javax.swing.JButton();
      

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(720, 480));

        jPanel1.setMaximumSize(new java.awt.Dimension(720, 484));
        jPanel1.setMinimumSize(new java.awt.Dimension(720, 484));

        reservationsL.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        reservationsL.setText("RESERVATIONS");

        reservationsT.setModel(new javax.swing.table.DefaultTableModel(
            tableData,
            new String [] {
                "Room", "User", "Dates"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        reservationsT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                reservationsTMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(reservationsT);
        
        makeChangesB.setText("Make Changes");
        makeChangesB.setEnabled(false);
        makeChangesB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                makeChangesBActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(303, 303, 303)
                        .addComponent(reservationsL))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(126, 126, 126)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(309, 309, 309)
                        .addComponent(makeChangesB)))
                .addContainerGap(142, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(reservationsL)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 119, Short.MAX_VALUE)
                .addComponent(makeChangesB)
                .addGap(87, 87, 87))
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
    }// </editor-fold>//GEN-END:initComponents

    private void reservationsTMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_reservationsTMouseClicked
        makeChangesB.setEnabled(true);       
    }//GEN-LAST:event_reservationsTMouseClicked

    private void makeChangesBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_makeChangesBActionPerformed
        getDataFromTable();
        
        UpdateTheReservation updateTheReservation = new UpdateTheReservation();
        updateTheReservation.setVisible(true);
    }//GEN-LAST:event_makeChangesBActionPerformed
    
    private void initTableMembers(){
        int column = 3;
        int row = 2;
        
        tableData = new Object[row][column];
        tableData[0][0] = "room1";
        tableData[0][1] = "user1";
        tableData[0][2] = "date1";
        tableData[1][0] = "room2";
        tableData[1][1] = "user2";
        tableData[1][2] = "date2";  
        Hotel hotel = new Hotel();
        hotel.getUsers();
    }
    
    private void getDataFromTable(){
        int selectedRow = reservationsT.getSelectedRow();
        String selectedRoom, selectedUser, selectedDate;
        
        selectedRoom = ""+tableData[selectedRow][0];
        selectedUser = ""+tableData[selectedRow][1];
        selectedDate = ""+tableData[selectedRow][2];
        
        System.out.println(selectedRoom + " " + selectedUser + " " + selectedDate);      
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(UpdateReservations.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UpdateReservations.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UpdateReservations.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UpdateReservations.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UpdateReservations().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton makeChangesB;
    private javax.swing.JLabel reservationsL;
    private javax.swing.JTable reservationsT;
}
