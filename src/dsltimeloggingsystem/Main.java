package dsltimeloggingsystem;

import com.digitalpersona.uareu.Fmd;
import com.digitalpersona.uareu.Reader;
import com.digitalpersona.uareu.ReaderCollection;
import com.digitalpersona.uareu.UareUException;
import com.digitalpersona.uareu.UareUGlobal;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author bendrhick
 */
public class Main extends javax.swing.JFrame {

    /**
     * Creates new form Login
     */
    private final JPanel panel = new JPanel();
    public Main() {
        
        initComponents();
        lblStatus.setFont(new Font("Serif", Font.PLAIN, 26));
        lblStatus.setHorizontalAlignment(JLabel.CENTER);
        //lblOr.setHorizontalAlignment(JLabel.CENTER);
        
    }
    
    private ReaderCollection m_collection;
    private Reader m_reader;
    private Fmd fmd;
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        label2 = new java.awt.Label();
        btn_ScanReader = new javax.swing.JButton();
        btn_capture = new javax.swing.JButton();
        lblStatus = new javax.swing.JLabel();
        btnAlternativeLogin = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Log In");

        label2.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        label2.setText("Please place your finger on the scanner!");

        btn_ScanReader.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btn_ScanReader.setText("Scan for FingerPrint Reader");
        btn_ScanReader.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ScanReaderActionPerformed(evt);
            }
        });

        btn_capture.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btn_capture.setText("Start Capturing Fingerprint");
        btn_capture.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_captureActionPerformed(evt);
            }
        });

        btnAlternativeLogin.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnAlternativeLogin.setText("Alternative Login");
        btnAlternativeLogin.setMaximumSize(new java.awt.Dimension(241, 31));
        btnAlternativeLogin.setMinimumSize(new java.awt.Dimension(241, 31));
        btnAlternativeLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlternativeLoginActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("or");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblStatus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(53, Short.MAX_VALUE)
                .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47))
            .addGroup(layout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btn_capture, javax.swing.GroupLayout.DEFAULT_SIZE, 277, Short.MAX_VALUE)
                    .addComponent(btn_ScanReader, javax.swing.GroupLayout.DEFAULT_SIZE, 277, Short.MAX_VALUE)
                    .addComponent(btnAlternativeLogin, javax.swing.GroupLayout.DEFAULT_SIZE, 277, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(29, 29, 29)
                .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(btn_ScanReader, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_capture, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnAlternativeLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void btn_ScanReaderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ScanReaderActionPerformed
        try {
            // TODO add your handling code here:
            m_collection = UareUGlobal.GetReaderCollection();
        } catch (UareUException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }

        m_reader = Selection.Select(m_collection);
        SelectedReader sr = new SelectedReader();
        sr.setM_reader(m_reader);
        //Reader m_reader = SelectedReader
    }//GEN-LAST:event_btn_ScanReaderActionPerformed

    private void btn_captureActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_captureActionPerformed
        // TODO add your handling code here:
        Capture.Run(m_reader, false);
        FingerPrint fingerPrint = new FingerPrint();
        byte[] fingerPrintImage = fingerPrint.getFingerPrintImage();
        try {
            User user = DB.loginFingerPrint(fingerPrintImage);
            if(user.getEmployeeID() != 0){
                if(user.getRole().equals("Administrator") || user.getRole().equals("Assistant Administrator") || user.getRole().equals("Payroll")){
                    JOptionPane.showMessageDialog(null, "Login Successful");
                    this.setVisible(false);
                    //ArrayList = user.getPages().replaceFirst("^\\[", "").replaceFirst("\\]$", "").split(", ");
                    Menu menu = new Menu(user);
                    menu.setTitle("DSL Time Logging | Menu");
                    menu.pack();
                    menu.setLocationRelativeTo(null);
                    menu.setVisible(true);
                    
                    fingerPrint.setFingerPrintImage(null);
                }
                else{
                    JOptionPane.showMessageDialog(panel, "Unauthorized", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
            else{
                JOptionPane.showMessageDialog(panel, "Unauthorized", "Error", JOptionPane.ERROR_MESSAGE);
            }

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UareUException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btn_captureActionPerformed

    private void btnAlternativeLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlternativeLoginActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        AlternativeLogIn al = new AlternativeLogIn();
        al.setTitle("DSL Time Logging | Alternative Login");
        al.pack();
        al.setLocationRelativeTo(null);
        al.setVisible(true);
    }//GEN-LAST:event_btnAlternativeLoginActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Main login = new Main();
                login.setTitle("DSL Time Logging | Login");
                login.pack();
                login.setLocationRelativeTo(null);
                login.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlternativeLogin;
    private javax.swing.JButton btn_ScanReader;
    private javax.swing.JButton btn_capture;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private java.awt.Label label2;
    private javax.swing.JLabel lblStatus;
    // End of variables declaration//GEN-END:variables
}
