package view;

import javax.swing.JOptionPane;

public class CashPayment extends javax.swing.JFrame {

	public CashPayment() {
        initComponents();
    }

    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        headerL = new javax.swing.JLabel();
        entryCardL = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        EnterButton = new javax.swing.JButton();
        debtL = new javax.swing.JLabel();
        payB = new javax.swing.JButton();
        numberL = new javax.swing.JLabel();
        currencyL = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(720, 480));
        setMinimumSize(new java.awt.Dimension(720, 480));

        headerL.setFont(new java.awt.Font("Tahoma", 1, 24)); 
        headerL.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        headerL.setText("LEAVING REQUEST");

        entryCardL.setFont(new java.awt.Font("Tahoma", 0, 18));
        entryCardL.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        entryCardL.setText("Please, enter the number of entry card:");

        jTextField1.setFont(new java.awt.Font("Tahoma", 0, 18));
        jTextField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        EnterButton.setFont(new java.awt.Font("Tahoma", 0, 18));
        EnterButton.setText("Enter");
        EnterButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	EnterButtonActionPerformed(evt);
            }
        });
        
        payB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	payBActionPerformed(evt);
            }
        });

        debtL.setFont(new java.awt.Font("Tahoma", 0, 18));
        debtL.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        debtL.setText("Debt on chosen entry card:");
        debtL.setEnabled(false);

        payB.setFont(new java.awt.Font("Tahoma", 0, 18));
        payB.setText("Pay");
        payB.setEnabled(false);

        numberL.setFont(new java.awt.Font("Tahoma", 1, 18));
        numberL.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        numberL.setText("-");
        numberL.setEnabled(false);

        currencyL.setFont(new java.awt.Font("Tahoma", 1, 18)); 
        currencyL.setText("TL");
        currencyL.setEnabled(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(250, 250, 250)
                .addComponent(debtL)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 209, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(headerL)
                        .addGap(237, 237, 237))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(entryCardL)
                        .addGap(201, 201, 201))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(235, 235, 235)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(EnterButton, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(307, 307, 307)
                        .addComponent(payB, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(281, 281, 281)
                        .addComponent(numberL, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(currencyL, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(headerL)
                .addGap(49, 49, 49)
                .addComponent(entryCardL)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(EnterButton, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(56, 56, 56)
                .addComponent(debtL)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(numberL, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(currencyL, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(62, 62, 62)
                .addComponent(payB, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(102, Short.MAX_VALUE))
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

    private void EnterButtonActionPerformed(java.awt.event.ActionEvent evt) {
    	
        debtL.setEnabled(true);
        numberL.setText("999");
        numberL.setEnabled(true);
        currencyL.setEnabled(true);
        payB.setEnabled(true);
    }
    
    private void payBActionPerformed(java.awt.event.ActionEvent evt) {
    	
    	int input = JOptionPane.showOptionDialog(null, "Debd of the entry card is annuled", "Payment is closed!", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, "OK");

        if(input == JOptionPane.OK_OPTION)
        {
        	this.setVisible(false);
        }
    }

   
    private javax.swing.JLabel currencyL;
    private javax.swing.JLabel debtL;
    private javax.swing.JLabel entryCardL;
    private javax.swing.JLabel headerL;
    private javax.swing.JButton EnterButton;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel numberL;
    private javax.swing.JButton payB;
    
}
