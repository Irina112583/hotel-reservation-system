package view;

import javax.swing.JOptionPane;

import domain.EntryCard;
import domain.Hotel;
import javax.swing.JLabel;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CashPayment extends javax.swing.JFrame {

	public CashPayment(Hotel hotel) {
        initComponents(hotel);
    }

    private void initComponents(Hotel hotel) {

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
        entryCardL.setText("Please, enter the Username:");

        jTextField1.setFont(new java.awt.Font("Tahoma", 0, 18));
        jTextField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        EnterButton.setFont(new java.awt.Font("Tahoma", 0, 18));
        EnterButton.setText("Enter");
        EnterButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	EnterButtonActionPerformed(evt, hotel);
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
        
        lblClosePaymentPage = new JLabel();
        lblClosePaymentPage.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		dispose();
        	}
        });
        lblClosePaymentPage.setText("Close Payment Page");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1Layout.setHorizontalGroup(
        	jPanel1Layout.createParallelGroup(Alignment.TRAILING)
        		.addGroup(jPanel1Layout.createSequentialGroup()
        			.addGap(250)
        			.addComponent(debtL)
        			.addGap(0, 237, Short.MAX_VALUE))
        		.addGroup(jPanel1Layout.createSequentialGroup()
        			.addGap(0, 235, Short.MAX_VALUE)
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.TRAILING)
        				.addGroup(jPanel1Layout.createSequentialGroup()
        					.addComponent(headerL)
        					.addGap(237))
        				.addGroup(jPanel1Layout.createSequentialGroup()
        					.addComponent(entryCardL)
        					.addGap(201))))
        		.addGroup(jPanel1Layout.createSequentialGroup()
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(jPanel1Layout.createSequentialGroup()
        					.addGap(235)
        					.addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, 159, GroupLayout.PREFERRED_SIZE)
        					.addPreferredGap(ComponentPlacement.UNRELATED)
        					.addComponent(EnterButton, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE))
        				.addGroup(jPanel1Layout.createSequentialGroup()
        					.addGap(307)
        					.addComponent(payB, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE))
        				.addGroup(jPanel1Layout.createSequentialGroup()
        					.addGap(281)
        					.addComponent(numberL, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(currencyL, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)))
        			.addContainerGap(212, Short.MAX_VALUE))
        		.addGroup(jPanel1Layout.createSequentialGroup()
        			.addContainerGap(546, Short.MAX_VALUE)
        			.addComponent(lblClosePaymentPage, GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
        	jPanel1Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel1Layout.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(headerL)
        			.addGap(49)
        			.addComponent(entryCardL)
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(EnterButton, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
        			.addGap(56)
        			.addComponent(debtL)
        			.addGap(18)
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(numberL, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
        				.addComponent(currencyL, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
        			.addGap(62)
        			.addComponent(payB, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED, 73, Short.MAX_VALUE)
        			.addComponent(lblClosePaymentPage)
        			.addContainerGap())
        );
        jPanel1.setLayout(jPanel1Layout);

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

    private void EnterButtonActionPerformed(java.awt.event.ActionEvent evt, Hotel hotel) {
    	
    	for(int i=1; i<hotel.hotelGuests.size()+1; i++) {
    		if(hotel.hotelGuests.get(i).getUserName().equals(jTextField1.getText())) {
    			for(int j = 1; j < hotel.allRooms.size()+1; j++) {
    	    		if(hotel.allRooms.get(j).roomNumber == hotel.hotelGuests.get(i).getEntryCard().getRoomNumber()) {
    	    			numberL.setText(""+(hotel.allRooms.get(j).getReservationCharge(hotel.hotelGuests.get(i).getEntryCard().getRoomNumber())));
    	    		}
    	    	}
    		}
    	}
    	numberL.setText("200");
        debtL.setEnabled(true);
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
    private JLabel lblClosePaymentPage;
    
}
