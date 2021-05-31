package view;

import domain.Hotel;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class UpdateReservations extends javax.swing.JFrame{
	
	Object[][] tableData;
   
    public UpdateReservations(Hotel hotel) {
        
        initTableMembers(hotel);        
        initComponents(hotel);   
    }

	
	private void initComponents(Hotel hotel) {

        jPanel1 = new javax.swing.JPanel();
        reservationsL = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        reservationsT = new javax.swing.JTable();
		makeChangesB = new javax.swing.JButton();
      

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(720, 480));

        jPanel1.setMaximumSize(new java.awt.Dimension(720, 484));
        jPanel1.setMinimumSize(new java.awt.Dimension(720, 484));

        reservationsL.setFont(new java.awt.Font("Tahoma", 1, 14)); 
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
                makeChangesBActionPerformed(evt, hotel);
            }
        });
        
        lblCloseReservationPage = new JLabel();
        lblCloseReservationPage.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		dispose();
        	}
        });
        lblCloseReservationPage.setText("Close Reservation Page");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1Layout.setHorizontalGroup(
        	jPanel1Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel1Layout.createSequentialGroup()
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(jPanel1Layout.createSequentialGroup()
        					.addGap(303)
        					.addComponent(reservationsL))
        				.addGroup(jPanel1Layout.createSequentialGroup()
        					.addGap(126)
        					.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        				.addGroup(jPanel1Layout.createSequentialGroup()
        					.addGap(309)
        					.addComponent(makeChangesB)))
        			.addContainerGap(142, Short.MAX_VALUE))
        		.addGroup(Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
        			.addContainerGap(544, Short.MAX_VALUE)
        			.addComponent(lblCloseReservationPage, GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
        	jPanel1Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel1Layout.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(reservationsL)
        			.addGap(18)
        			.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 209, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED, 63, Short.MAX_VALUE)
        			.addComponent(makeChangesB)
        			.addGap(58)
        			.addComponent(lblCloseReservationPage)
        			.addContainerGap())
        );
        jPanel1.setLayout(jPanel1Layout);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, 700, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, 432, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        getContentPane().setLayout(layout);

        pack();
    }

    private void reservationsTMouseClicked(java.awt.event.MouseEvent evt) {
        makeChangesB.setEnabled(true);       
    }

    private void makeChangesBActionPerformed(java.awt.event.ActionEvent evt, Hotel hotel) {
    	int selectedRow = reservationsT.getSelectedRow();
        String selectedRoom, selectedUser, selectedDate;
        
        selectedRoom = ""+tableData[selectedRow][0];
        selectedUser = ""+tableData[selectedRow][1];
        selectedDate = ""+tableData[selectedRow][2];
        
        UpdateTheReservation updateTheReservation = new UpdateTheReservation(hotel, selectedRoom, selectedUser, selectedDate);
        updateTheReservation.setVisible(true);
    }
    
    private void initTableMembers(Hotel hotel){
        int column = 3;
        int row = 0;
        
        row = hotel.allRooms.size()+1;
        
        tableData = new Object[row][column];

        for (int i = 1; i <= hotel.allRooms.size(); i++) {
        	tableData[i][0] = i;
        	tableData[i][1] = "Guset "+ i;
        	tableData[i][2] = 20210603+i;
        }
    }
    
    private void getDataFromTable(){
        int selectedRow = reservationsT.getSelectedRow();
        String selectedRoom, selectedUser, selectedDate;
        
        selectedRoom = ""+tableData[selectedRow][0];
        selectedUser = ""+tableData[selectedRow][1];
        selectedDate = ""+tableData[selectedRow][2];
        
        System.out.println(selectedRoom + " " + selectedUser + " " + selectedDate);      
    }

    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton makeChangesB;
    private javax.swing.JLabel reservationsL;
    private javax.swing.JTable reservationsT;
    private JLabel lblCloseReservationPage;
}
