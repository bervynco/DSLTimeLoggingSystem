/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dsltimeloggingsystem;

/**
 *
 * @author L R E
 */
public class PayrollDetails {
    private int employeeID;
    private String employeeName;
    private float rate;
    private float sssDeduction;
    private float pagibigDeduction;
    private float philHealthDeduction;
    private float bonus;
    private float cashAdvance;
    private float loan;
    private int days;
    private float overTime;
    private float totalSalary;

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }
    
    public float getRate() {
        return rate;
    }

    public void setRate(float rate) {
        this.rate = rate;
    }

    public float getSssDeduction() {
        return sssDeduction;
    }

    public void setSssDeduction(float sssDeduction) {
        this.sssDeduction = sssDeduction;
    }

    public float getPagibigDeduction() {
        return pagibigDeduction;
    }

    public void setPagibigDeduction(float pagibigDeduction) {
        this.pagibigDeduction = pagibigDeduction;
    }

    public float getPhilHealthDeduction() {
        return philHealthDeduction;
    }

    public void setPhilHealthDeduction(float philHealthDeduction) {
        this.philHealthDeduction = philHealthDeduction;
    }

    public float getBonus() {
        return bonus;
    }

    public void setBonus(float bonus) {
        this.bonus = bonus;
    }

    public float getCashAdvance() {
        return cashAdvance;
    }

    public void setCashAdvance(float cashAdvance) {
        this.cashAdvance = cashAdvance;
    }

    public float getLoan() {
        return loan;
    }

    public void setLoan(float loan) {
        this.loan = loan;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public float getOverTime() {
        return overTime;
    }

    public void setOverTime(float overTime) {
        this.overTime = overTime;
    }

    public float getTotalSalary() {
        return totalSalary;
    }

    public void setTotalSalary(float totalSalary) {
        this.totalSalary = totalSalary;
    }
    
    
}
