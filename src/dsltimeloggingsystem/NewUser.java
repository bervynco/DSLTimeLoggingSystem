/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dsltimeloggingsystem;
import com.digitalpersona.uareu.Reader;
import com.digitalpersona.uareu.ReaderCollection;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.InvocationTargetException;
import java.text.SimpleDateFormat;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
/**
 *
 * @author L R E
 */
public class NewUser extends JPanel implements ActionListener{
    private static final long serialVersionUID=1;

    private static final String ACT_SELECTION = "selection";
    private static final String ACT_CAPTURE = "capture";
    private static final String ACT_VERIFICATION = "verification";
    private static final String ACT_EXIT = "exit";
    
    private SimpleDateFormat dateFormat = new SimpleDateFormat("dd:MM:yyyy HH:mm:ss");
    private JLabel clock;
    
    private JDialog   m_dlgParent;
    private JTextArea m_textReader;

    private ReaderCollection m_collection;
    private Reader m_reader;
    
    private NewUser(){
        final int vgap = 5;
        final int width = 800;
        //final int height = 600;
        BoxLayout layout = new BoxLayout(this, BoxLayout.PAGE_AXIS);
        setLayout(layout);

        add(Box.createVerticalStrut(vgap));
        JLabel lblReader = new JLabel("Selected reader:");
        add(lblReader);
        add(Box.createVerticalStrut(vgap));
        Dimension dm = lblReader.getPreferredSize();
        dm.width = width;
        //dm.height = height;
        lblReader.setPreferredSize(dm);


        m_textReader = new JTextArea(3, 1);
        m_textReader.setEditable(false);
        JScrollPane paneReader = new JScrollPane(m_textReader);
        add(paneReader);
        add(Box.createVerticalStrut(vgap));

        JButton btnSelect = new JButton("Select new reader");
        btnSelect.setActionCommand(ACT_SELECTION);
        btnSelect.addActionListener(this);
        add(btnSelect);
        add(Box.createVerticalStrut(vgap));

        JButton btnCapture = new JButton("Run capture");
        btnCapture.setActionCommand(ACT_CAPTURE);
        btnCapture.addActionListener(this);
        add(btnCapture);
        add(Box.createVerticalStrut(vgap));

        JButton btnVerification = new JButton("Run verification");
        btnVerification.setActionCommand(ACT_VERIFICATION);
        btnVerification.addActionListener(this);
        add(btnVerification);
        add(Box.createVerticalStrut(vgap));

        add(Box.createVerticalStrut(vgap));
        JButton btnExit = new JButton("Exit");
        btnExit.setActionCommand(ACT_EXIT);
        btnExit.addActionListener(this);
        add(btnExit);
        add(Box.createVerticalStrut(vgap));
        
//        clock = new JLabel();
//        clock.setActionCommand("my action command");
//        clock.addActionListener(this);
//        add(clock);
//        updateClock();
//        new Timer(1000, this).start();
        
        setOpaque(true);
    }

    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
