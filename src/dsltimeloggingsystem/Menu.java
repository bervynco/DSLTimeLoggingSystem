package dsltimeloggingsystem;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;

public class Menu extends javax.swing.JFrame {
    
    private static User sessionUser = null;
    private static ArrayList<String> employeePages = new ArrayList<>();
    public void filterView(int employeeID, User user) throws ClassNotFoundException, SQLException{
        btnEmployee.setVisible(true);
        btnClaimSalary.setVisible(false);
        btnReports.setVisible(false);
        btnPayroll.setVisible(false);
        btnSalaryCondition.setVisible(false);
        btnSystemLogs.setVisible(false);
        btnNotes.setVisible(false);

        if(user.getRole().equals("Administrator")){
            btnSystemLogs.setVisible(true);
            btnEmployee.setVisible(true);
            btnClaimSalary.setVisible(true);
            btnReports.setVisible(true);
            btnPayroll.setVisible(true);
            btnSalaryCondition.setVisible(true);
            btnNotes.setVisible(true);
        }
        else if(user.getRole().equals("Payroll")){
            btnPayroll.setVisible(true);
        }
        else if(user.getRole().equals("Co-Administrator")){
            String[] pages = user.getPages().replaceFirst("^\\[", "").replaceFirst("\\]$", "").split(", ");
            for(int i = 0; i < pages.length; i++){
                if(pages[i].equals("Claim Salary") || pages[i].equals("Add Employee") || pages[i].equals("Edit Employee") || pages[i].equals("Delete Employee")){
                    
                    pages[i] = pages[i].replaceAll("\\s+","");
                    if(pages[i].equals("AddEmployee") ||pages[i].equals("EditEmployee") || pages[i].equals("DeleteEmployee")){
                        employeePages.add(pages[i]);
                    }
                }
                if(Pattern.compile(Pattern.quote(pages[i]), Pattern.CASE_INSENSITIVE).matcher("btnEmployee").find()){
                    //btnUpload.setVisible(true);
                }
                else if(Pattern.compile(Pattern.quote(pages[i]), Pattern.CASE_INSENSITIVE).matcher("btnClaimSalary").find()){
                    System.out.println("Claim Salary");
                    btnClaimSalary.setVisible(true);
                }
                else if(Pattern.compile(Pattern.quote(pages[i]), Pattern.CASE_INSENSITIVE).matcher("btnReports").find()){
                    System.out.println("Reports");
                    btnReports.setVisible(true);
                }
                else if(Pattern.compile(Pattern.quote(pages[i]), Pattern.CASE_INSENSITIVE).matcher("btnPayroll").find()){
                    System.out.println("Payroll");
                    btnPayroll.setVisible(true);
                }
                else if(Pattern.compile(Pattern.quote(pages[i]), Pattern.CASE_INSENSITIVE).matcher("btnNotes").find()){
                    System.out.println("Notes");
                    btnNotes.setVisible(true);
                }
                else if(Pattern.compile(Pattern.quote(pages[i]), Pattern.CASE_INSENSITIVE).matcher("btnUpload").find()){
                    System.out.println("Upload");
                    btnUpload.setVisible(true);
                }
                else;

            }
        }
        else;
    }
    public Menu(User user) throws ClassNotFoundException, SQLException, ParseException{
        initComponents();
        this.sessionUser = user;
        this.employeePages = employeePages;
        //System.out.println("Menu " + employeeID);
        this.filterView(user.getEmployeeID(), sessionUser);
        DB.setUserLogStatus(user.getEmployeeID(),"Page Visit", "Menu");
    }
    public Menu(User user, ArrayList<String> employeePages) throws ClassNotFoundException, SQLException, ParseException{
        initComponents();
        this.sessionUser = user;
        this.employeePages = employeePages;
        //System.out.println("Menu " + employeeID);
        this.filterView(user.getEmployeeID(), sessionUser);
        DB.setUserLogStatus(user.getEmployeeID(),"Page Visit", "Menu");
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnEmployee = new javax.swing.JButton();
        btnPayroll = new javax.swing.JButton();
        btnClaimSalary = new javax.swing.JButton();
        btnReports = new javax.swing.JButton();
        btnLogout = new javax.swing.JButton();
        btnSalaryCondition = new javax.swing.JToggleButton();
        btnHome = new javax.swing.JToggleButton();
        btnSystemLogs = new javax.swing.JButton();
        btnNotes = new javax.swing.JButton();
        btnUpload = new javax.swing.JButton();

        jButton2.setText("jButton2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel1.setText("MENU");

        btnEmployee.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        btnEmployee.setText("Employee");
        btnEmployee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEmployeeActionPerformed(evt);
            }
        });

        btnPayroll.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        btnPayroll.setText("Payroll Overview");
        btnPayroll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPayrollActionPerformed(evt);
            }
        });

        btnClaimSalary.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        btnClaimSalary.setText("Claim Salary");
        btnClaimSalary.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClaimSalaryActionPerformed(evt);
            }
        });

        btnReports.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        btnReports.setText("Reports");
        btnReports.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReportsActionPerformed(evt);
            }
        });

        btnLogout.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        btnLogout.setText("Log Out");
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });

        btnSalaryCondition.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        btnSalaryCondition.setText("Add Salary Condition");
        btnSalaryCondition.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalaryConditionActionPerformed(evt);
            }
        });

        btnHome.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        btnHome.setText("Home");
        btnHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHomeActionPerformed(evt);
            }
        });

        btnSystemLogs.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        btnSystemLogs.setText("System Logs");
        btnSystemLogs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSystemLogsActionPerformed(evt);
            }
        });

        btnNotes.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        btnNotes.setText("Notes");
        btnNotes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNotesActionPerformed(evt);
            }
        });

        btnUpload.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        btnUpload.setText("Upload Document");
        btnUpload.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUploadActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(243, 243, 243)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(82, 82, 82)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnPayroll, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSalaryCondition, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnHome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSystemLogs, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnUpload, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btnEmployee, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnClaimSalary, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnReports, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnNotes, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(82, 82, 82))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnHome)
                    .addComponent(btnEmployee))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPayroll)
                    .addComponent(btnClaimSalary))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalaryCondition)
                    .addComponent(btnReports))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNotes, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(btnSystemLogs))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnUpload)
                    .addComponent(btnLogout))
                .addGap(30, 30, 30))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEmployeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEmployeeActionPerformed
        try {
            // TODO add your handling code here:
            this.setVisible(false);
            EmployeesUI eUI = new EmployeesUI(this.sessionUser, employeePages);
            eUI.setTitle("DSL Time Logging | Employees");
            eUI.pack();
            eUI.setLocationRelativeTo(null);
            eUI.setDefaultCloseOperation(0);
            eUI.setVisible(true);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_btnEmployeeActionPerformed

    private void btnPayrollActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPayrollActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        Payroll payroll;
        try {
            payroll = new Payroll(this.sessionUser, employeePages);
            payroll.setTitle("DSL Time Logging | Payroll");
            payroll.pack();
            payroll.setLocationRelativeTo(null);
            payroll.setDefaultCloseOperation(0);
            payroll.setVisible(true);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_btnPayrollActionPerformed

    private void btnHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHomeActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        Home home;
        try {
            home = new Home(this.sessionUser, employeePages);
            home.setTitle("DSL Time Logging | Home");
            home.pack();
            home.setLocationRelativeTo(null);
            home.setDefaultCloseOperation(0);
            home.setVisible(true);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_btnHomeActionPerformed

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        try {
            // TODO add your handling code here:
            this.setVisible(false);
            DB.setUserLogStatus(sessionUser.getEmployeeID(),"Page Visit", "Logout");
            Main timeLoggingSystem = new Main();
            timeLoggingSystem.setTitle("DSL Time Logging | Login");
            timeLoggingSystem.pack();
            timeLoggingSystem.setLocationRelativeTo(null);
            timeLoggingSystem.setVisible(true);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnLogoutActionPerformed

    private void btnClaimSalaryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClaimSalaryActionPerformed
        this.setVisible(false);
        try {
            // TODO add your handling code here:
            EmployeeList list = new EmployeeList(this.sessionUser, employeePages);
            list.setTitle("DSL Time Logging | List of Employees");
            list.pack();
            list.setLocationRelativeTo(null);
            list.setDefaultCloseOperation(0);
            list.setVisible(true);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnClaimSalaryActionPerformed

    private void btnSalaryConditionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalaryConditionActionPerformed
        try {
            // TODO add your handling code here:
            this.setVisible(false);
            SalaryCondition condition = new SalaryCondition(this.sessionUser, employeePages);
            condition.setTitle("DSL Time Logging | Salary Condition");
            condition.pack();
            condition.setLocationRelativeTo(null);
            condition.setDefaultCloseOperation(0);
            condition.setVisible(true);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnSalaryConditionActionPerformed

    private void btnReportsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReportsActionPerformed
        // TODO add your handling code here:
        Reports report;
        this.setVisible(false);
        try {
            report = new Reports(this.sessionUser, employeePages);
            report.setTitle("DSL Time Logging | Generate Report");
            report.pack();
            report.setLocationRelativeTo(null);
            report.setDefaultCloseOperation(0);
            report.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }//GEN-LAST:event_btnReportsActionPerformed

    private void btnSystemLogsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSystemLogsActionPerformed
        try {
            // TODO add your handling code here:
            SystemLogs systemLogs;
            this.setVisible(false);
            systemLogs = new SystemLogs(this.sessionUser, employeePages);
            systemLogs.setVisible(true);
            systemLogs.setTitle("DSL Time Logging | System Logs");
            systemLogs.pack();
            systemLogs.setLocationRelativeTo(null);
            systemLogs.setDefaultCloseOperation(0);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnSystemLogsActionPerformed

    private void btnUploadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUploadActionPerformed
        try {
            // TODO add your handling code here:
            this.setVisible(false);
            UploadDocuments upload = new UploadDocuments(this.sessionUser, "Main Menu", this.employeePages);
            upload.setVisible(true);
            upload.setTitle("DSL Time Logging | System Logs");
            upload.pack();
            upload.setLocationRelativeTo(null);
            upload.setDefaultCloseOperation(0);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnUploadActionPerformed

    private void btnNotesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNotesActionPerformed
        this.setVisible(false);
        try {
            // TODO add your handling code here:
            AddNote notes = new AddNote(this.sessionUser, "Main Menu", this.employeePages);
            notes.setVisible(true);
            notes.setTitle("DSL Time Logging | Add Notes");
            notes.pack();
            notes.setLocationRelativeTo(null);
            notes.setDefaultCloseOperation(0);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnNotesActionPerformed

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClaimSalary;
    private javax.swing.JButton btnEmployee;
    private javax.swing.JToggleButton btnHome;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnNotes;
    private javax.swing.JButton btnPayroll;
    private javax.swing.JButton btnReports;
    private javax.swing.JToggleButton btnSalaryCondition;
    private javax.swing.JButton btnSystemLogs;
    private javax.swing.JButton btnUpload;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
