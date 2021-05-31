package view;

import domain.Hotel;

public class MonitorReservations extends javax.swing.JFrame {
	Object[][] roomsData;
    Object[][] servicesData;

    public MonitorReservations(Hotel hotel) {
        initRoomsTMembers(hotel);
        initServicesTMembers();
        initComponents(hotel);
    }

    private void initComponents(Hotel hotel) {

        jPanel1 = new javax.swing.JPanel();
        headerL = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        servicesTable = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        roomsTable = new javax.swing.JTable();
        servicesB = new javax.swing.JButton();
        roomsB = new javax.swing.JButton();
        backB = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1080, 480));
        setMinimumSize(new java.awt.Dimension(1080, 480));
        setPreferredSize(new java.awt.Dimension(1080, 480));

        headerL.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        headerL.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        headerL.setText("LIST OF ROOMS AND SERVICES");

        servicesTable.setModel(new javax.swing.table.DefaultTableModel(
            servicesData,
            new String [] {
                "Service Name", "Occupied Time Slots", "Availability Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        servicesTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                servicesTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(servicesTable);

        roomsTable.setModel(new javax.swing.table.DefaultTableModel(
            roomsData,
            new String [] {
                "Room Number", "Occupied Dates", "Availability Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        roomsTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                roomsTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(roomsTable);

        servicesB.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        servicesB.setText("Get Detailed Information");
        servicesB.setEnabled(false);
        servicesB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                servicesBActionPerformed(evt);
            }
        });

        roomsB.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        roomsB.setText("Get Detailed Information");
        roomsB.setEnabled(false);
        roomsB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                roomsBActionPerformed(evt, hotel);
            }
        });

        backB.setText("Go Back");
        backB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(171, 171, 171)
                .addComponent(roomsB, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(servicesB, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(162, 162, 162))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(backB)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(headerL)
                        .addGap(346, 346, 346))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 428, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 87, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 434, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(59, 59, 59))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(headerL)
                    .addComponent(backB))
                .addGap(47, 47, 47)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(roomsB, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(servicesB, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(78, Short.MAX_VALUE))
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

    private void roomsTableMouseClicked(java.awt.event.MouseEvent evt) {
        roomsB.setEnabled(true);
    }

    private void servicesTableMouseClicked(java.awt.event.MouseEvent evt) {
        servicesB.setEnabled(true);
    }

    private void roomsBActionPerformed(java.awt.event.ActionEvent evt, Hotel hotel) {
        
        int selectedRow = roomsTable.getSelectedRow();
        String selectedRoom, selectedOccupiedDates, selectedStatus;
        selectedRoom = ""+roomsData[selectedRow][0];
        selectedOccupiedDates = ""+roomsData[selectedRow][1];
        selectedStatus = ""+roomsData[selectedRow][2];
        MonitorRoomReservation monitorRoom = new MonitorRoomReservation(hotel, selectedRoom, selectedOccupiedDates, selectedStatus);
        monitorRoom.setVisible(true);
    }

    private void servicesBActionPerformed(java.awt.event.ActionEvent evt) {
        int selectedRow = servicesTable.getSelectedRow();
        String selectedService, selectedOccupiedTS, selectedStatus;
        selectedService = ""+servicesData[selectedRow][0];
        selectedOccupiedTS = ""+servicesData[selectedRow][1];
        selectedStatus = ""+servicesData[selectedRow][2];
        MonitorServiceReservation monitorService = new MonitorServiceReservation(selectedService, selectedOccupiedTS, selectedStatus);
        monitorService.setVisible(true);
    }

    private void backBActionPerformed(java.awt.event.ActionEvent evt) {
        this.setVisible(false);
    }

    
    private void initRoomsTMembers(Hotel hotel){
        int column = 3;
        int row = 0;
        
        row = hotel.allRooms.size()+1;
        System.out.println(row);
        roomsData = new Object[row][column];
        
        
        for (int i = 1; i <= hotel.allRooms.size(); i++) {
        	roomsData[i][0] = ""+hotel.allRooms.get(i).roomNumber;
        	roomsData[i][1] = ""+hotel.allRooms.get(i).getOccupiedDays();
        	boolean availability = hotel.allRooms.get(i).getAvailability();
        	String availabilityStatus;
        	if(availability == true) {
        		availabilityStatus = "Available";
        	} else {
        		availabilityStatus = "Not available: maintanence";
        	}
        	
        	roomsData[i][2] = availabilityStatus;
        }    
    }
    
    private void initServicesTMembers(){
        int column = 3;
        int row = 2;
        
        servicesData = new Object[row][column];
        servicesData[0][0] = "Tennis Court";
        servicesData[0][1] = "2021/06/03 9:00-10:00";
        servicesData[0][2] = "available";
        servicesData[1][0] = "Tennis Court";
        servicesData[1][1] = "2021/06/03 9:00-11:00";
        servicesData[1][2] = "available";    
    }
    
    private void getDataFromRoomsT(){
        int selectedRow = roomsTable.getSelectedRow();
        String selectedRoom, selectedOccupiedDates, selectedStatus;
        
        selectedRoom = ""+roomsData[selectedRow][0];
        selectedOccupiedDates = ""+roomsData[selectedRow][1];
        selectedStatus = ""+roomsData[selectedRow][2];
        
        System.out.println(selectedRoom + " " + selectedOccupiedDates + " " + selectedStatus);      
    }
    
    private void getDataFromServicesT(){
        int selectedRow = servicesTable.getSelectedRow();
        String selectedService, selectedOccupiedTimeSlots, selectedStatus;
        
        selectedService = ""+servicesData[selectedRow][0];
        selectedOccupiedTimeSlots = ""+servicesData[selectedRow][1];
        selectedStatus = ""+servicesData[selectedRow][2];
        
        System.out.println(selectedService + " " + selectedOccupiedTimeSlots + " " + selectedStatus);      
    }

    private javax.swing.JButton backB;
    private javax.swing.JLabel headerL;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton roomsB;
    private javax.swing.JTable roomsTable;
    private javax.swing.JButton servicesB;
    private javax.swing.JTable servicesTable;
}
