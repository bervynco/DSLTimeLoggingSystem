package dsltimeloggingsystem;

import dsltimeloggingsystem.DB;
import dsltimeloggingsystem.EmployeesUI;
import dsltimeloggingsystem.User;
import java.awt.Font;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

public class EmployeeList extends javax.swing.JFrame {
    private User sessionUser = null;
    private ArrayList<String> employeePages = new ArrayList<>();
    private String dateStart = null;
    private String dateEnd = null;
    private final JPanel panel = new JPanel();
    private static DefaultTableModel FillTable() throws ClassNotFoundException, SQLException {
        DefaultTableModel model = new DefaultTableModel();
        
        List<User> employees = new ArrayList<User>();
        employees = DB.getUsers();
        
        model.addColumn("Employee ID");
        model.addColumn("Name");
        model.addColumn("Role");
        
        for(int i = 0; i < employees.size(); i++){
            Object [] rowData = {employees.get(i).getEmployeeID(), employees.get(i).getFirstName() +" " + employees.get(i).getLastName(), employees.get(i).getRole()};
            model.addRow(rowData);
        }
       
        return model;
//        new jTable1.setModel(model);
    }
    public EmployeeList(User user, ArrayList<String> employeePages) throws ClassNotFoundException, SQLException, ParseException {
        DefaultTableModel model = EmployeeList.FillTable();
        initComponents();
        jTable2.setModel(model);
        this.sessionUser = user;
        this.employeePages = employeePages;
        lblNotice.setFont(new Font(lblNotice.getFont().getName(),Font.ITALIC,lblNotice.getFont().getSize()));
        lblNotice.setHorizontalAlignment(JLabel.CENTER);
        DB.setUserLogStatus(sessionUser.getEmployeeID(),"Page Visit", "Employee List");
    }
    public EmployeeList(User user, ArrayList<String> employeePages, String dateStart, String dateEnd) throws ClassNotFoundException, SQLException, ParseException {
        System.out.println("EMPLOYEE LIST");
        System.out.println(dateStart);
        System.out.println(dateEnd);
        DefaultTableModel model = EmployeeList.FillTable();
        initComponents();
        jTable2.setModel(model);
        sessionUser = user;
        startDate.setText(dateStart);
        endDate.setText(dateEnd);
        lblNotice.setFont(new Font(lblNotice.getFont().getName(),Font.ITALIC,lblNotice.getFont().getSize()));
        lblNotice.setHorizontalAlignment(JLabel.CENTER);
        DB.setUserLogStatus(sessionUser.getEmployeeID(),"Page Visit", "Employee List");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        label1 = new java.awt.Label();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        btnMainMenu = new javax.swing.JButton();
        lblNotice = new javax.swing.JLabel();
        btnUpload = new javax.swing.JButton();
        startDate = new com.github.lgooddatepicker.components.DatePicker();
        endDate = new com.github.lgooddatepicker.components.DatePicker();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        label1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        label1.setText("List Of Employees");

        jTable2.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);

        btnMainMenu.setText("Main Menu");
        btnMainMenu.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnMainMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMainMenuActionPerformed(evt);
            }
        });

        lblNotice.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNotice.setText("Click on the cell to compute for salary.");
        lblNotice.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        btnUpload.setText("Upload Attendance File");
        btnUpload.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnUpload.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUploadActionPerformed(evt);
            }
        });

        jLabel1.setText("Compute Salary Dates:");
        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel2.setText("to");
        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 644, Short.MAX_VALUE)
                            .addComponent(lblNotice, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnMainMenu)
                                        .addGap(29, 29, 29)
                                        .addComponent(btnUpload)))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jLabel1)
                        .addGap(42, 42, 42)
                        .addComponent(startDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(jLabel2)
                        .addGap(53, 53, 53)
                        .addComponent(endDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnMainMenu)
                    .addComponent(btnUpload, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(startDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(endDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addComponent(lblNotice)
                .addGap(27, 27, 27)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        try {                                     
            // TODO add your handling code here:
            int row = jTable2.rowAtPoint(evt.getPoint());
            int employeeID = (int) jTable2.getValueAt(row, 0);
            String name = (String) jTable2.getValueAt(row, 1);
            String dateStart = startDate.getText();
            String dateEnd = endDate.getText();
            
            if(dateStart.equals("") || dateEnd.equals("")){
                JOptionPane.showMessageDialog(panel, "Input salary claim start date and end date", "Error", JOptionPane.ERROR_MESSAGE);
            }
            else{
                this.setVisible(false);
                SalaryClaim salary = new SalaryClaim(this.sessionUser, this.employeePages, dateStart, dateEnd);
                salary.fillFields(employeeID, name);
                salary.setTitle("DSL Time Logging | Salary Claim");
                salary.pack();
                salary.setLocationRelativeTo(null);
                salary.setDefaultCloseOperation(0);
                salary.setVisible(true);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EmployeeList.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeList.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(EmployeeList.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jTable2MouseClicked

    private void btnMainMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMainMenuActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        try {
            Menu menu = new Menu(this.sessionUser, this.employeePages);
            menu.setTitle("DSL Time Logging | Menu");
            menu.pack();
            menu.setLocationRelativeTo(null);
            menu.setDefaultCloseOperation(0);
            menu.setVisible(true);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EmployeeList.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeList.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(EmployeeList.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_btnMainMenuActionPerformed

    private void btnUploadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUploadActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        File selectedFile = null;
        int returnValue = fileChooser.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            try {
                selectedFile = fileChooser.getSelectedFile();
                ExcelParser parser = new ExcelParser(this.sessionUser, this.employeePages);
                parser.parseExcel(selectedFile);
            } catch (IOException ex) {
                Logger.getLogger(EmployeeList.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ParseException ex) {
                Logger.getLogger(EmployeeList.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(EmployeeList.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(EmployeeList.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
       
        
        
    }//GEN-LAST:event_btnUploadActionPerformed

    /**
     * @param args the command line arguments
     */
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnMainMenu;
    private javax.swing.JButton btnUpload;
    private com.github.lgooddatepicker.components.DatePicker endDate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private java.awt.Label label1;
    private javax.swing.JLabel lblNotice;
    private com.github.lgooddatepicker.components.DatePicker startDate;
    // End of variables declaration//GEN-END:variables
}
