package dsltimeloggingsystem;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JMenuBar;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author bendrhick
 */
public class MainMenu extends javax.swing.JFrame {
    
    private static User sessionUser = null;
    private static DefaultTableModel FillTable() throws ClassNotFoundException, SQLException {
        DefaultTableModel model = new DefaultTableModel();
        
        List<User> employees = new ArrayList<User>();
        employees = DB.getUsers();
        
        model.addColumn("Employee ID");
        model.addColumn("First Name");
        model.addColumn("Last Name");
        model.addColumn("Mobile Number");
        model.addColumn("Telephone Number");
        model.addColumn("Address");
        model.addColumn("Rate");
        model.addColumn("Time In");
        model.addColumn("Time Out");
        model.addColumn("Role");
        model.addColumn("SSS Number");
        model.addColumn("PhilHealth Number");
        model.addColumn("Pagibig Number");
        model.addColumn("Tin Number");
        model.addColumn("SSS Deduction");
        model.addColumn("Pag-ibig Deduction");
        model.addColumn("PhilHealth Deduction");
        
        for(int i = 0; i < employees.size(); i++){
            Object [] rowData = {employees.get(i).getEmployeeID(), employees.get(i).getFirstName(), employees.get(i).getLastName(), employees.get(i).getMobileNumber(), 
                employees.get(i).getTelephoneNumber(), employees.get(i).getAddress(), employees.get(i).getRate(), employees.get(i).getTimeIn(), 
                employees.get(i).getTimeOut(), employees.get(i).getRole(), employees.get(i).getSSSNumber(), employees.get(i).getPhilHealthNumber(), 
                employees.get(i).getPagibigNumber(), employees.get(i).getTinNumber(), employees.get(i).getSSSDeduction(), employees.get(i).getPagibigDeduction(),
                employees.get(i).getPhilHealthDeduction()};
            model.addRow(rowData);
        }
        
        return model;
//        new jTable1.setModel(model);
    }

    /**
     * Creates new form Home
     */
    public MainMenu(User user) throws ClassNotFoundException, SQLException {
        
        
        DefaultTableModel model = MainMenu.FillTable();
        initComponents();
        ;
        //jTable1.addColumn(aColumn);
        jTable1.setModel(model);
        this.sessionUser = user;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jToggleButton1 = new javax.swing.JToggleButton();
        jToggleButton2 = new javax.swing.JToggleButton();
        textField1 = new java.awt.TextField();
        jToggleButton4 = new javax.swing.JToggleButton();
        jLabel1 = new javax.swing.JLabel();
        textField2 = new java.awt.TextField();
        jToggleButton3 = new javax.swing.JToggleButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jMenu5 = new javax.swing.JMenu();
        jMenu6 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        jMenu8 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Date", "Name", "ID", "Clock In", "Clock Out", "Plus Time", "Late", "OT Time", "Actual wDay", "Absent(JS/AB)", "Reason For Absent"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true, false, false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setHeaderValue("Date");
            jTable1.getColumnModel().getColumn(1).setHeaderValue("Name");
            jTable1.getColumnModel().getColumn(2).setHeaderValue("ID");
            jTable1.getColumnModel().getColumn(3).setHeaderValue("Clock In");
            jTable1.getColumnModel().getColumn(4).setHeaderValue("Clock Out");
            jTable1.getColumnModel().getColumn(5).setHeaderValue("Plus Time");
            jTable1.getColumnModel().getColumn(6).setHeaderValue("Late");
            jTable1.getColumnModel().getColumn(7).setHeaderValue("OT Time");
            jTable1.getColumnModel().getColumn(8).setHeaderValue("Actual wDay");
            jTable1.getColumnModel().getColumn(9).setHeaderValue("Absent(JS/AB)");
            jTable1.getColumnModel().getColumn(10).setHeaderValue("Reason For Absent");
        }

        jToggleButton1.setText("View Day");

        jToggleButton2.setText("View Attendance");

        textField1.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        textField1.setText("Search");
        textField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textField1ActionPerformed(evt);
            }
        });

        jToggleButton4.setText("Employees");
        jToggleButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton4ActionPerformed(evt);
            }
        });

        jLabel1.setText("Date:");

        textField2.setText("textField2");

        jToggleButton3.setText("Payroll");

        jMenu1.setText("Employees");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Data");
        jMenuBar1.add(jMenu2);

        jMenu4.setText("AC Log");
        jMenuBar1.add(jMenu4);

        jMenu5.setText("Adjust Data");
        jMenuBar1.add(jMenu5);

        jMenu6.setText("Device");
        jMenuBar1.add(jMenu6);

        jMenu3.setText("Reports");
        jMenuBar1.add(jMenu3);

        jMenu8.setText("Log Out");
        jMenuBar1.add(jMenu8);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jToggleButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jToggleButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jToggleButton4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jToggleButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 733, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(29, 29, 29)
                .addComponent(textField2, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textField1, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textField2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jToggleButton1)
                        .addComponent(jToggleButton2)
                        .addComponent(jToggleButton4)
                        .addComponent(jToggleButton3)
                        .addComponent(jLabel1))
                    .addComponent(textField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 718, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void textField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textField1ActionPerformed
       
    private void jToggleButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton4ActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        
        EmployeesUI ui;
        try {
            ui = new EmployeesUI(this.sessionUser);
            ui.setTitle("DSL Time Logging | View All Employees");
            ui.setDefaultCloseOperation(0);
            ui.setVisible(true);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MainMenu.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(MainMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
       
    }//GEN-LAST:event_jToggleButton4ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        int row = jTable1.rowAtPoint(evt.getPoint());
        
        System.out.println(row);
    }//GEN-LAST:event_jTable1MouseClicked
    
    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new MainMenu().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu8;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JToggleButton jToggleButton2;
    private javax.swing.JToggleButton jToggleButton3;
    private javax.swing.JToggleButton jToggleButton4;
    private java.awt.TextField textField1;
    private java.awt.TextField textField2;
    // End of variables declaration//GEN-END:variables

    private static class jMenuBar1 extends JMenuBar {

        public jMenuBar1() {
        }
    }
}
