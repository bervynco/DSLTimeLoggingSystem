/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dsltimeloggingsystem;

import com.digitalpersona.uareu.Engine;
import com.digitalpersona.uareu.Fmd;
import com.digitalpersona.uareu.UareUException;
import com.digitalpersona.uareu.UareUGlobal;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Constants;
import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.nio.charset.Charset;
import java.sql.Blob;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author L R E
 */
public class DB {
    private static String user = "root";
    private static String pass = "password";
    private static String host = "localhost";
    private static String port = "3306";
    private static String url = "jdbc:mysql://" + host + ":" + port + "/dsl";
    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
    
    public static Connection connect() throws ClassNotFoundException, SQLException {

       Connection conn = null;

       Class.forName("com.mysql.jdbc.Driver");

       conn = (Connection) DriverManager.getConnection(url, user, pass);
       
       return conn;
    }
    
    public static PayrollClass getPayrollList(){
        PayrollClass list = new PayrollClass();
        //SELECT a.employeeID, firstName, lastName, (Select SUM(amount) from bonus where employeeID = 21231 and month(appliedDate) = 1) as 'BonusAmount', sssDeduction, philHealthDeduction, pagibigDeduction, (select count(case when TIMESTAMPDIFF(HOUR, b.timeIn, b.timeOut) > 8 then 1 else null end)) as 'NormalWorkingDay' FROM users a, logs b WHERE a.employeeID = 21231 and b.employeeID = a.employeeID;
        return list;
    }
    public static Timestamp getCurrentTimeStamp(){
        Timestamp timeStamp = new Timestamp(System.currentTimeMillis());
        
        return timeStamp;
    }
    
    public static List<Attendance> getAttendance() throws ClassNotFoundException, SQLException{
        List<Attendance> attendanceList = new ArrayList<Attendance>();
        Connection c = connect();
        PreparedStatement ps = c.prepareStatement("Select a.employeeID, b.firstName, b.lastName, a.logDate, a.timeIn, a.timeOut, TIMESTAMPDIFF(HOUR, a.timeIn, a.timeOut) as Duration from logs a, users b where day(a.logDate) = 12 and a.employeeID = b.employeeID;");
        ResultSet rs = ps.executeQuery();
        
        while(rs.next()){
            Attendance attendance = new Attendance();
            
            attendance.setEmployeeID(rs.getInt(1));
            attendance.setFirstName(rs.getString(2));
            attendance.setLastName(rs.getString(3));
            attendance.setLogDate(rs.getTimestamp(4));
            attendance.setTimeIn(rs.getTimestamp(5));
            attendance.setTimeOut(rs.getTimestamp(6));
            attendance.setDuration(rs.getInt(7));
            
            attendanceList.add(attendance);
        }
        c.close();
        return attendanceList;
        
    }
    public static int getCashAdvance(int employeeID) throws ClassNotFoundException, SQLException{
        int totalCashAdvance = 0;
        
        Timestamp today = DB.getCurrentTimeStamp();
        int month = today.getMonth();
        if(month == 0){
            month = 12;
        }
        Connection c = connect();
        PreparedStatement ps = c.prepareStatement("Select employeeID, amount from cash_advance where month(appliedDate) = ? and employeeID = ?");
        ps.setInt(1, month);
        ps.setInt(2, employeeID);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            totalCashAdvance =  totalCashAdvance + rs.getInt(2);
        }
        c.close();
        return totalCashAdvance;
    }
    public static int getLoan(int employeeID) throws ClassNotFoundException, SQLException{
        int totalLoan = 0;
        Connection c = connect();
        Timestamp today = DB.getCurrentTimeStamp();
        int month = today.getMonth();
        if(month == 0){
            month = 12;
        }
        PreparedStatement ps = c.prepareStatement("Select employeeID, amount loan from loan where month(appliedDate) = ? and employeeID = ?");
        ps.setInt(1, month);
        ps.setInt(2, employeeID);
        
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            totalLoan =  totalLoan + rs.getInt(2);
        }
        c.close();
        return  totalLoan;
        
    }
    public static int getBonus(int employeeID) throws ClassNotFoundException, SQLException{
        int totalBonus = 0;
        
        Timestamp today = DB.getCurrentTimeStamp();
        int month = today.getMonth();
        if(month == 0){
            month = 12;
        }
        Connection c = connect();
        PreparedStatement ps = c.prepareStatement("Select employeeID, amount from bonus where month(appliedDate) = ? and employeeID = ?");
        ps.setInt(1, month);
        ps.setInt(2, employeeID);
        ResultSet rs = ps.executeQuery();
        
        
        while(rs.next()){
            totalBonus = totalBonus + rs.getInt(2);
        }
        c.close();
        return totalBonus;
    }
    
    public static int getLogs(int employeeID) throws ClassNotFoundException, SQLException{
        Connection c = connect();
        Timestamp today = DB.getCurrentTimeStamp();
        int month = today.getMonth();
        if(month == 0){
            month = 12;
        }
        
        int total = 0;
        //PreparedStatement ps = c.prepareStatement("SELECT employeeID, timeIn, timeOut, TIMESTAMPDIFF(HOUR, timeIn, timeOut) as 'Duration' FROM dsl.logs where employeeID = ? and month(logDate) = ?");
        PreparedStatement ps = c.prepareStatement("SELECT employeeID, timeIn, timeOut, logDate, TIMESTAMPDIFF(HOUR, timeIn, timeOut) AS 'Duration',(select count(case when TIMESTAMPDIFF(HOUR, timeIn, timeOut) > 8 then 1 else null end)) as 'NormalWorkingDay' FROM logs WHERE employeeID = ? and month(logDate) = ?");
        
        ps.setInt(1, employeeID);
        ps.setInt(2, month);
        ResultSet rs = ps.executeQuery();
        
        while(rs.next()){
            total = rs.getInt(6);
        }
        
        c.close();
        return total;
    }
    public static String determineUserRole(byte[] fingerPrintImage) throws ClassNotFoundException, SQLException, UareUException{
        String role = "";
        Connection c = connect();
        PreparedStatement ps = c.prepareStatement("Select employeeID as 'EmployeeID', firstName as 'FirstName', lastName as 'LastName', fingerPrint, role from users");
        
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            byte[] fingerPrint  = rs.getBytes(4);
            Engine engine = UareUGlobal.GetEngine();
        
            Fmd fmd1 = UareUGlobal.GetImporter().ImportFmd(fingerPrint, Fmd.Format.ANSI_378_2004, Fmd.Format.ANSI_378_2004);
            Fmd fmd2 = UareUGlobal.GetImporter().ImportFmd(fingerPrintImage, Fmd.Format.ANSI_378_2004, Fmd.Format.ANSI_378_2004);
            
            int falsematch_rate = engine.Compare(fmd1, 0, fmd2, 0);
            int target_falsematch_rate = Engine.PROBABILITY_ONE / 100000; //target rate is 0.00001
            
            if(falsematch_rate < target_falsematch_rate){
                role = rs.getString(5);
            }
        }
        c.close();
        return role;
    }
    public static String deleteUser(int employeeID) throws ClassNotFoundException, SQLException{
        Connection c = connect();
        PreparedStatement ps = c.prepareStatement("Delete from users where employeeID = ?");
        ps.setInt(1, employeeID);
        int affectedRows = ps.executeUpdate();
        c.close();
        if(affectedRows != 0){
            return "Successful";
        }
        else{
            return "System Error";
        }
    }
    
    public static String updateUser(String firstName, String lastName, int employeeID, String address, String telephoneNumber, String mobileNumber, float rate, String timeIn, String timeOut, byte[] fingerPrint, String SSSNumber, String philHealthNumber, String tinNumber, String pagibigNumber, float SSSDeduction, float pagibigDeduction, float philHealthDeduction) throws SQLException, ClassNotFoundException{
        Connection c = connect();
        PreparedStatement ps = c.prepareStatement("UPDATE users SET firstName = ?, lastName = ?, address =?, telephoneNumber =?, mobileNumber = ?, rate = ?, timeIn = ?, timeOut = ?, fingerPrint = ?, modified =?, " +""
                + " SSSNumber = ?, philHealthNumber =?, tinNumber = ?, pagibigNumber = ?, SSSDeduction = ?, pagibigDeduction = ?, philHealthDeduction = ? WHERE employeeID = ?");
        
        ps.setString(1, firstName);
        ps.setString(2, lastName);
        ps.setString(3, address);
        ps.setString(4, telephoneNumber);
        ps.setString(5, mobileNumber);
        ps.setFloat(6, rate);
        ps.setString(7, timeIn);
        ps.setString(8, timeOut);
        ps.setBytes(9, fingerPrint);
        ps.setTimestamp(10, (Timestamp) getCurrentTimeStamp());
        ps.setString(11, SSSNumber);
        ps.setString(12, philHealthNumber);
        ps.setString(13, tinNumber);
        ps.setString(14, pagibigNumber);
        ps.setFloat(15, SSSDeduction);
        ps.setFloat(16, pagibigDeduction);
        ps.setFloat(17, philHealthDeduction);
        ps.setInt(18, employeeID);
        int affectedRow = ps.executeUpdate();
        c.close();
        if(affectedRow > 0){
            return "Successful";
        }
        else{
            return "Error";
        }
        
    }
    public static User getUserDetails(int employeeID) throws ClassNotFoundException, SQLException{
        Connection c = connect();
        PreparedStatement ps = c.prepareStatement("Select employeeID, firstName, lastName, address, telephoneNumber, mobileNumber, rate, timeIn, timeOut, role, fingerPrint," +  
                "SSSNumber, philHealthNumber, tinNumber, pagibigNumber, SSSDeduction" + 
                ", philHealthDeduction, pagibigDeduction from users where employeeID = ?");
        ps.setInt(1, employeeID);
        ResultSet rs = ps.executeQuery();
        User user = new User();
        while(rs.next()){
            user.setEmployeeID(rs.getInt(1));
            user.setFirstName(rs.getString(2));
            user.setLastName(rs.getString(3));
            user.setAddress(rs.getString(4));
            user.setMobileNumber(rs.getString(5));
            user.setTelephoneNumber(rs.getString(6));
            user.setRate(rs.getFloat(7));
            user.setTimeIn(rs.getString(8));
            user.setTimeOut(rs.getString(9));
            user.setRole(rs.getString(10));
            user.setSSSNumber(rs.getString(12));
            user.setPhilHealthNumber(rs.getString(13));
            user.setTinNumber(rs.getString(14));
            user.setPagibigNumber(rs.getString(15));
            user.setSSSDeduction(rs.getFloat(16));
            user.setPhilHealthDeduction(rs.getFloat(17));
            user.setPagibigDeduction(rs.getFloat(18));
            user.setFingerPrintImage(rs.getBytes(11));
        }
        c.close();
        return user;
    }
    public static List<User> getUsers() throws SQLException, ClassNotFoundException{
        List<User> employees = new ArrayList<User>();
        Connection c = connect();
        
        PreparedStatement ps = c.prepareStatement("Select employeeID, firstName, lastName, address, telephoneNumber, mobileNumber, rate, timeIn," + 
                " timeOut, role, fingerPrint, SSSNumber, philHealthNumber, pagibigNumber, SSSDeduction, philHealthDeduction, pagibigDeduction, tinNumber from users");
        ResultSet rs = ps.executeQuery();
        
        while (rs.next()) {
                User user = new User();
                user.setEmployeeID(rs.getInt("employeeID"));
                user.setFirstName(rs.getString("firstName"));
                user.setLastName(rs.getString("lastName"));
                user.setAddress(rs.getString("address"));
                user.setTelephoneNumber(rs.getString("telephoneNumber"));
                user.setMobileNumber(rs.getString("mobileNumber"));
                user.setRate(rs.getFloat("rate"));
                user.setTimeIn(rs.getString("timeIn"));
                user.setTimeOut(rs.getString("timeOut"));
                user.setRole(rs.getString("role"));
                user.setSSSNumber(rs.getString("SSSNumber"));
                user.setPhilHealthNumber(rs.getString("philHealthNumber"));
                user.setPagibigNumber(rs.getString("pagibigNumber"));
                user.setSSSDeduction(rs.getFloat("SSSDeduction"));
                user.setPhilHealthDeduction(rs.getFloat("philHealthDeduction"));
                user.setPagibigDeduction(rs.getFloat("pagibigDeduction"));
                user.setTinNumber(rs.getString("tinNumber"));

                employees.add(user);
        }
        c.close();
        return employees;
    }
    
    public static String signUp(String firstName, String lastName, int employeeID, String address, String telephoneNumber, String mobileNumber, float rate, String timeIn, String timeOut, byte[] fingerPrint, String SSSNumber, String philHealthNumber, String tinNumber, String pagibigNumber, float SSSDeduction, float pagibigDeduction, float philHealthDeduction) throws ClassNotFoundException, SQLException, FileNotFoundException{
        String role = "";
        Connection c = connect();
        
//        String fingerPrint = fmd.toString();
        PreparedStatement ps = c.prepareStatement("INSERT INTO users (firstName, lastName, employeeID, address, telephoneNumber," + 
                " mobileNumber, rate, timeIn, timeOut, fingerPrint, modified, SSSNumber, philHealthNumber, tinNumber, pagibigNumber," + 
                "SSSDeduction, pagibigDeduction, philHealthDeduction, role) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
        ps.setString(1, firstName);
        ps.setString(2, lastName);
        ps.setInt(3, employeeID);
        ps.setString(4, address);
        ps.setString(5, telephoneNumber);
        ps.setString(6, mobileNumber);
        ps.setFloat(7, rate);
        ps.setString(8, timeIn);
        ps.setString(9, timeOut);
        ps.setBytes(10, fingerPrint);
        ps.setTimestamp(11, (Timestamp) getCurrentTimeStamp());
        ps.setString(12, SSSNumber);
        ps.setString(13, philHealthNumber);
        ps.setString(14, tinNumber);
        ps.setString(15, pagibigNumber);
        ps.setFloat(16, SSSDeduction);
        ps.setFloat(17, pagibigDeduction);
        ps.setFloat(18, philHealthDeduction);
        ps.setString(19, role);
        

        // execute insert SQL stetement
        int rows = ps.executeUpdate();
        c.close();
       
        if(rows > 0){
            return "Successful";
        }
        else{
            return "Failed";
        }
    }
    
    public static User loginFingerPrint(byte[] fingerPrintImage) throws ClassNotFoundException, SQLException, UareUException, ParseException{
        String role = "";
        User user = new User();
        Connection c = connect();
        PreparedStatement ps = c.prepareStatement("Select employeeID as 'EmployeeID', firstName as 'FirstName', lastName as 'LastName'," + 
                " address as 'Address', telephoneNumber as 'TelephoneNumber', mobileNumber as 'MobileNumber', rate, timeIn, timeOut, role, fingerPrint from users");
        
        ResultSet rs = ps.executeQuery();
        //Fmd.SerializeXml(fmd); 
        while (rs.next()) {
            byte[] fingerPrint  = rs.getBytes(11);
            Engine engine = UareUGlobal.GetEngine();
        
            Fmd fmd1 = UareUGlobal.GetImporter().ImportFmd(fingerPrint, Fmd.Format.ANSI_378_2004, Fmd.Format.ANSI_378_2004);
            Fmd fmd2 = UareUGlobal.GetImporter().ImportFmd(fingerPrintImage, Fmd.Format.ANSI_378_2004, Fmd.Format.ANSI_378_2004);
            
            int falsematch_rate = engine.Compare(fmd1, 0, fmd2, 0);

            System.out.println(falsematch_rate);

            int target_falsematch_rate = Engine.PROBABILITY_ONE / 100000; //target rate is 0.00001
            
            if(falsematch_rate < target_falsematch_rate){
                System.out.println("Fingerprints matched");
                user.setEmployeeID(rs.getInt(1));
                user.setFirstName(rs.getString(2));
                user.setLastName(rs.getString(3));
                user.setAddress(rs.getString(4));
                user.setTelephoneNumber(rs.getString(5));
                user.setMobileNumber(rs.getString(6));
                user.setRate(rs.getFloat(7));
                user.setTimeIn(rs.getString(8));
                user.setTimeOut(rs.getString(9));
                role = rs.getString(10);
                user.setRole(role);
            }
        }
        c.close();
        return user;
        
        
    }
}
