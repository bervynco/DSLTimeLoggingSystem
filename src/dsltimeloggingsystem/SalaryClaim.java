package dsltimeloggingsystem;

import java.awt.Color;
import java.awt.Font;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;

public class SalaryClaim extends javax.swing.JFrame {

    /**
     * Creates new form SalaryClaim
     */
    private static int totalBonus = 0;
    private static int totalCashAdvance = 0;
    private static int totalLoan = 0;
    private static int totalRegularWorkingHours = 0; // 8 and above working hours
    private static User sessionUser = null;
    PayrollDetails payrollDetails = new PayrollDetails();
    private static int employeeID = 0;
    
    public void fillFields(int employeeID, String name) throws ClassNotFoundException, SQLException{
        System.out.println(employeeID);
        List<PayrollDetails> details = DB.getSalaryClaim(employeeID);
        if(details.size() == 0){
            System.out.println("SIZE == 0");
            lblName.setText(name);
            this.employeeID = employeeID;
            User user = DB.getUserDetails(employeeID);
            totalBonus = DB.getBonus(employeeID);
            totalCashAdvance = DB.getAllowance(employeeID);
            totalLoan = DB.getLoan(employeeID);
            totalRegularWorkingHours = DB.getLogs(employeeID);
            txtRate.setText(Float.toString(user.getRate()));
            txtSSSDeduction.setText(Float.toString(user.getSSSDeduction()));
            txtPagibigDeduction.setText(Float.toString(user.getPagibigDeduction()));
            txtPhilHealthDeduction.setText(Float.toString(user.getPhilHealthDeduction()));
            txtBonus.setText(Integer.toString(totalBonus));
            txtCashAdvance.setText(Integer.toString(totalCashAdvance));
            txtLoan.setText(Integer.toString(totalLoan));
            txtDays.setText(Integer.toString(totalRegularWorkingHours));
            lblDeductables.setText(Float.toString(user.getSSSDeduction() + user.getPagibigDeduction() + user.getPhilHealthDeduction()));
            lblGross.setText((Float.toString(user.getRate() * (float)totalRegularWorkingHours + totalBonus - totalCashAdvance)));
            float deductables = Float.parseFloat(lblDeductables.getText());
            float gross = Float.parseFloat(lblGross.getText());
            lblSalary.setText(Float.toString(gross - deductables));
            lblSalary.setFont(new Font("Serif", Font.PLAIN, 24));
            lblSalary.setForeground(new Color(1, 169, 130));
            Font font = lblSalary.getFont();
            // same font but bold
            Font boldFont = new Font(font.getFontName(), Font.BOLD, font.getSize());
            lblSalary.setFont(boldFont);

            float rate = Float.valueOf(txtRate.getText());
            float sssDeduction = Float.valueOf(txtSSSDeduction.getText());
            float pagibigDeduction = Float.valueOf(txtPagibigDeduction.getText());
            float philHealthDeduction = Float.valueOf(txtPhilHealthDeduction.getText());
            float bonus = Float.valueOf(txtBonus.getText());
            float cashAdvance = Float.valueOf(txtCashAdvance.getText());
            float loan = Float.valueOf(txtLoan.getText());
            int days = Integer.valueOf(txtDays.getText());
            float overTime;
            try{
                overTime = Float.valueOf(txtOvertime.getText());
            }
            catch(NumberFormatException e){
                overTime = 0;
            }
            txtOvertime.setText(Float.toString(overTime));
            float totalSalary = (rate * days) -(sssDeduction + pagibigDeduction + philHealthDeduction) + bonus - (cashAdvance + loan) + overTime;
            payrollDetails.setRate(rate);
            payrollDetails.setSssDeduction(sssDeduction);
            payrollDetails.setPagibigDeduction(pagibigDeduction);
            payrollDetails.setPhilHealthDeduction(philHealthDeduction);
            payrollDetails.setBonus(bonus);
            payrollDetails.setCashAdvance(cashAdvance);
            payrollDetails.setLoan(loan);
            payrollDetails.setDays(days);
            payrollDetails.setOverTime(overTime);
            payrollDetails.setTotalSalary(totalSalary);
        }
        else{
            System.out.println("SIZE > 0");
            for(int i = 0; i < details.size(); i++){
                txtRate.setText(Float.toString(details.get(i).getRate()));
                txtSSSDeduction.setText(Float.toString(details.get(i).getSssDeduction()));
                txtPagibigDeduction.setText(Float.toString(details.get(i).getPagibigDeduction()));
                txtPhilHealthDeduction.setText(Float.toString(details.get(i).getPhilHealthDeduction()));
                txtBonus.setText(Float.toString(details.get(i).getBonus()));
                txtCashAdvance.setText(Float.toString(details.get(i).getCashAdvance()));
                txtLoan.setText(Float.toString(details.get(i).getLoan()));
                txtDays.setText(Integer.toString(details.get(i).getDays()));
                lblSalary.setText(Float.toString(details.get(i).getTotalSalary()));
                lblSalary.setFont(new Font("Serif", Font.PLAIN, 24));
                lblSalary.setForeground(new Color(1, 169, 130));
                btnCompute.setVisible(false);
                btnSave.setVisible(false);
                lblStatus.setText("This is already saved and claimed");
            }
        }
    }
    
    public SalaryClaim(User user) throws ClassNotFoundException, SQLException, ParseException {
        initComponents();
        this.sessionUser = user;
        DB.setUserLogStatus(user.getEmployeeID(),"Page Visit", "Salary Claim");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        label1 = new java.awt.Label();
        label4 = new java.awt.Label();
        label5 = new java.awt.Label();
        label6 = new java.awt.Label();
        label8 = new java.awt.Label();
        label9 = new java.awt.Label();
        label10 = new java.awt.Label();
        label11 = new java.awt.Label();
        label12 = new java.awt.Label();
        label13 = new java.awt.Label();
        label14 = new java.awt.Label();
        label15 = new java.awt.Label();
        label16 = new java.awt.Label();
        txtRate = new javax.swing.JTextField();
        txtOvertime = new javax.swing.JTextField();
        txtDays = new javax.swing.JTextField();
        txtBonus = new javax.swing.JTextField();
        txtLoan = new javax.swing.JTextField();
        txtSSSDeduction = new javax.swing.JTextField();
        txtPagibigDeduction = new javax.swing.JTextField();
        txtPhilHealthDeduction = new javax.swing.JTextField();
        txtCashAdvance = new javax.swing.JTextField();
        lblGross = new javax.swing.JLabel();
        lblDeductables = new javax.swing.JLabel();
        lblSalary = new javax.swing.JLabel();
        btnCompute = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        lblName = new javax.swing.JLabel();
        lblStatus = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        label1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        label1.setText("Name:");

        label4.setText("Rate/Day:");

        label5.setText("No. Of Days:");

        label6.setText("Overtime:");

        label8.setText("Bonus/Allowance:");

        label9.setText("Loan:");

        label10.setText("Cash Advance:");

        label11.setText("SSS Deduction:");

        label12.setText("Pag-Ibig Deduction:");

        label13.setText("PhilHealth Deduction:");

        label14.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        label14.setText("Salary:");

        label15.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        label15.setText("Total Deductables:");

        label16.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        label16.setText("Gross Salary:");

        btnCompute.setText("Compute");
        btnCompute.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnComputeActionPerformed(evt);
            }
        });

        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        lblName.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        lblStatus.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblName, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(lblStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 458, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(label5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(label4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(label6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(label8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(20, 20, 20)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtCashAdvance, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                                    .addComponent(txtDays)
                                    .addComponent(txtBonus)
                                    .addComponent(txtOvertime)
                                    .addComponent(txtRate))
                                .addGap(146, 146, 146)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(label9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(45, 45, 45)
                                            .addComponent(txtLoan, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(label11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(txtSSSDeduction)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(label13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(label12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtPagibigDeduction, javax.swing.GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)
                                            .addComponent(txtPhilHealthDeduction))
                                        .addGap(117, 117, 117))))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(label16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(label10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lblGross, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(104, 104, 104)
                                        .addComponent(btnBack)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(label15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(37, 37, 37)
                                        .addComponent(lblDeductables, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(28, 28, 28)
                                        .addComponent(label14, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lblSalary, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(100, 100, 100)
                                        .addComponent(btnCompute)
                                        .addGap(176, 176, 176)
                                        .addComponent(btnSave)))
                                .addGap(87, 87, 87)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(91, 91, 91)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(label11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSSSDeduction, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                        .addComponent(txtPagibigDeduction, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(label1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblStatus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(12, 12, 12)
                                    .addComponent(label4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(label9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtRate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(txtLoan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(2, 2, 2)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(75, 75, 75)
                                .addComponent(label12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtDays, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(label5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(label6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtOvertime, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(13, 13, 13)))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(label13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPhilHealthDeduction, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(9, 9, 9))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(label8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtBonus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCashAdvance, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblSalary, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblDeductables, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(label15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(label14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(label16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblGross, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBack)
                    .addComponent(btnCompute)
                    .addComponent(btnSave))
                .addGap(23, 23, 23))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        try {
            float rate = payrollDetails.getRate();
            float sssDeduction = payrollDetails.getSssDeduction();
            float pagibigDeduction = payrollDetails.getPagibigDeduction();
            float philHealthDeduction = payrollDetails.getPhilHealthDeduction();
            float bonus = payrollDetails.getBonus();
            float cashAdvance = payrollDetails.getCashAdvance();
            float loan = payrollDetails.getLoan();
            int days = payrollDetails.getDays();
            float overTime = payrollDetails.getOverTime();
            float totalSalary = (rate * days) -(sssDeduction + pagibigDeduction + philHealthDeduction) + bonus - (cashAdvance + loan) + overTime;
            String status = DB.setSalaryClaim(employeeID, rate, sssDeduction, pagibigDeduction, philHealthDeduction, bonus, cashAdvance, loan, days, overTime, totalSalary);
            
            if(status.equals("Successful")){
                lblStatus.setText("Successful. Please press the back button to claim other salary");
                lblStatus.setHorizontalAlignment(JLabel.CENTER);
                lblStatus.setForeground(new Color(0,100,0));
            }
            else{
                lblStatus.setText("Error. Please Contact System Administrator");
                lblStatus.setHorizontalAlignment(JLabel.CENTER);
                lblStatus.setForeground(Color.red);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SalaryClaim.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(SalaryClaim.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        EmployeeList list;
        try {
            this.setVisible(false);
            list = new EmployeeList(this.sessionUser);
            list.setTitle("DSL Time Logging | List of Emoloyees");
            list.pack();
            list.setLocationRelativeTo(null);
            list.setDefaultCloseOperation(0);
            list.setVisible(true);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SalaryClaim.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(SalaryClaim.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(SalaryClaim.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnComputeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnComputeActionPerformed
        // TODO add your handling code here:
        float rate = Float.valueOf(txtRate.getText());
        float sssDeduction = Float.valueOf(txtSSSDeduction.getText());
        float pagibigDeduction = Float.valueOf(txtPagibigDeduction.getText());
        float philHealthDeduction = Float.valueOf(txtPhilHealthDeduction.getText());
        float bonus = Float.valueOf(txtBonus.getText());
        float cashAdvance = Float.valueOf(txtCashAdvance.getText());
        float loan = Float.valueOf(txtLoan.getText());
        int days = Integer.valueOf(txtDays.getText());
        float overTime = Float.valueOf(txtOvertime.getText());
        float totalSalary = (rate * days) -(sssDeduction + pagibigDeduction + philHealthDeduction) + bonus - (cashAdvance + loan) + overTime;
        lblSalary.setText(Float.toString(totalSalary));
        lblSalary.setFont(new Font("Serif", Font.PLAIN, 24));
        lblSalary.setForeground(new Color(1, 169, 130));
        Font font = lblSalary.getFont();
        // same font but bold
        Font boldFont = new Font(font.getFontName(), Font.BOLD, font.getSize());
        lblSalary.setFont(boldFont);
        
        payrollDetails.setRate(rate);
        payrollDetails.setSssDeduction(sssDeduction);
        payrollDetails.setPagibigDeduction(pagibigDeduction);
        payrollDetails.setPhilHealthDeduction(philHealthDeduction);
        payrollDetails.setBonus(bonus);
        payrollDetails.setCashAdvance(cashAdvance);
        payrollDetails.setLoan(loan);
        payrollDetails.setDays(days);
        payrollDetails.setOverTime(overTime);
        payrollDetails.setTotalSalary(totalSalary);
        
    }//GEN-LAST:event_btnComputeActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnCompute;
    private javax.swing.JButton btnSave;
    private java.awt.Label label1;
    private java.awt.Label label10;
    private java.awt.Label label11;
    private java.awt.Label label12;
    private java.awt.Label label13;
    private java.awt.Label label14;
    private java.awt.Label label15;
    private java.awt.Label label16;
    private java.awt.Label label4;
    private java.awt.Label label5;
    private java.awt.Label label6;
    private java.awt.Label label8;
    private java.awt.Label label9;
    private javax.swing.JLabel lblDeductables;
    private javax.swing.JLabel lblGross;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblSalary;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JTextField txtBonus;
    private javax.swing.JTextField txtCashAdvance;
    private javax.swing.JTextField txtDays;
    private javax.swing.JTextField txtLoan;
    private javax.swing.JTextField txtOvertime;
    private javax.swing.JTextField txtPagibigDeduction;
    private javax.swing.JTextField txtPhilHealthDeduction;
    private javax.swing.JTextField txtRate;
    private javax.swing.JTextField txtSSSDeduction;
    // End of variables declaration//GEN-END:variables
}
