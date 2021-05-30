package view;

public class UpdateOrderedCleaningServices extends javax.swing.JFrame {

	Object[][] tableData;

    public UpdateOrderedCleaningServices() {
        initTableMembers();
        initComponents();
    }
    
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        headerL = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        cleaningServicesT = new javax.swing.JTable();
        editB = new javax.swing.JButton();
        deleteB = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(720, 480));
        setMinimumSize(new java.awt.Dimension(720, 480));
        setPreferredSize(new java.awt.Dimension(720, 480));

        headerL.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        headerL.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        headerL.setText("Additional Cleaning Services Assigned To Your Room");

        cleaningServicesT.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        cleaningServicesT.setModel(new javax.swing.table.DefaultTableModel(
            tableData,
            new String [] {
                "Date", "Time Slot"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        cleaningServicesT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cleaningServicesTMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(cleaningServicesT);

        editB.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        editB.setText("Edit");
        editB.setEnabled(false);
        editB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editBActionPerformed(evt);
            }
        });

        deleteB.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        deleteB.setText("Delete");
        deleteB.setEnabled(false);
        deleteB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(40, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(headerL, javax.swing.GroupLayout.PREFERRED_SIZE, 648, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(133, 133, 133))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(deleteB, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44)
                        .addComponent(editB, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(174, 174, 174))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(headerL, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(deleteB, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(editB, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(137, Short.MAX_VALUE))
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

    private void cleaningServicesTMouseClicked(java.awt.event.MouseEvent evt) {
        editB.setEnabled(true);
        deleteB.setEnabled(true);
    }

    private void deleteBActionPerformed(java.awt.event.ActionEvent evt) {
       
    	
    	
    	
    	
    	
    }

    private void editBActionPerformed(java.awt.event.ActionEvent evt) {
    	EditCleaningServices edit = new EditCleaningServices();
    	edit.setVisible(true);
    }

        private void initTableMembers(){
        int column = 2;
        int row = 1;
        
        tableData = new Object[row][column];
        tableData[0][0] = "date1";
        tableData[0][1] = "timeslot1";

    }
    
    private void getDataFromTable(){
        int selectedRow = cleaningServicesT.getSelectedRow();
        String selectedDate, selectedTimeSlot;
        
        selectedDate = ""+tableData[selectedRow][0];
        selectedTimeSlot = ""+tableData[selectedRow][1];
        
        System.out.println(selectedDate + " " + selectedTimeSlot);      
    }

    private javax.swing.JTable cleaningServicesT;
    private javax.swing.JButton deleteB;
    private javax.swing.JButton editB;
    private javax.swing.JLabel headerL;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
}
