package view;

public class UpdateTheReservation extends javax.swing.JFrame {
	
	public UpdateTheReservation() {
        initComponents();
    }

	private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        roomL = new javax.swing.JLabel();
        userL = new javax.swing.JLabel();
        dateL = new javax.swing.JLabel();
        avalaibleL = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        roomsList = new javax.swing.JList<>();
        updateB = new javax.swing.JButton();
        saveB = new javax.swing.JButton();

        roomL.setFont(new java.awt.Font("Tahoma", 0, 18));
        userL.setFont(new java.awt.Font("Tahoma", 0, 18));
        dateL.setFont(new java.awt.Font("Tahoma", 0, 18));
        
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(720, 484));
        setMinimumSize(new java.awt.Dimension(720, 484));
        setPreferredSize(new java.awt.Dimension(720, 484));

        roomL.setText("roomHere");

        userL.setText("userHere");

        dateL.setText("dateHere");

        avalaibleL.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        avalaibleL.setText("Available Rooms:");
        

        saveB.setText("Save");
        saveB.setEnabled(false);
        saveB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	saveBActionPerformed(evt);
            }
        });

        roomsList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "room 1", "room 2", "room 3", "room 4", "room 5", "room 1", "room 2", "room 3", "room 4", "room 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        roomsList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                roomsListValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(roomsList);

        updateB.setText("Update");
        updateB.setEnabled(false);
        updateB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateBActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(150, 150, 150)
                .addComponent(roomL)
                .addGap(151, 151, 151)
                .addComponent(userL)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 175, Short.MAX_VALUE)
                .addComponent(dateL)
                .addGap(108, 108, 108))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(avalaibleL, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(302, 302, 302))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(updateB)
                            .addComponent(saveB)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(211, 211, 211))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(roomL)
                    .addComponent(userL)
                    .addComponent(dateL))
                .addGap(74, 74, 74)
                .addComponent(avalaibleL)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(updateB)
                .addGap(10, 10, 10)
                .addComponent(saveB)
                .addContainerGap(128, Short.MAX_VALUE))
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
    }

    private void roomsListValueChanged(javax.swing.event.ListSelectionEvent evt) {
        updateB.setEnabled(true);
                
    }

    private void updateBActionPerformed(java.awt.event.ActionEvent evt) {
        roomL.setText(roomsList.getSelectedValue());
        saveB.setEnabled(true);
    }
    
    private void saveBActionPerformed(java.awt.event.ActionEvent evt) {
        
    }

    private javax.swing.JLabel avalaibleL;
    private javax.swing.JLabel dateL;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel roomL;
    private javax.swing.JList<String> roomsList;
    private javax.swing.JButton updateB;
    private javax.swing.JButton saveB;
    private javax.swing.JLabel userL;
}
