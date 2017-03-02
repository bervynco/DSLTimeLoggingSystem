package simplepaint;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ESignaturePanel extends JApplet {

   public static void main(String[] args) {
      JFrame window = new JFrame("E-Sign");
      SimplePaintPanel content = new SimplePaintPanel();
      window.setContentPane(content);
      window.setSize(600,480);
      window.setLocation(100,100);
      window.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
      window.setVisible(true);

   }

   public void init() {
      setContentPane( new SimplePaintPanel() );
   }

   public static class SimplePaintPanel extends JPanel
               implements MouseListener, MouseMotionListener {

      private final static int BLACK = 0;
      
      private int currentColor = BLACK;
      private int prevX, prevY;
      private boolean dragging;
      private Graphics graphicsForDrawing;  
      
      SimplePaintPanel() {
         setBackground(Color.WHITE);
         addMouseListener(this);
         addMouseMotionListener(this);
      }

      public void paintComponent(Graphics g) {
         
         super.paintComponent(g);  // Fill with background color (white).

         g.setColor(Color.WHITE);
         
      } // end paintComponent()

      private void setUpDrawingGraphics() {
         graphicsForDrawing = getGraphics();
         switch (currentColor) {
         case BLACK:
            graphicsForDrawing.setColor(Color.BLACK);
            break;
         }
      }

      public void mousePressed(MouseEvent evt) {
         
         int x = evt.getX();
         int y = evt.getY(); 
         
         int width = getWidth(); 
         int height = getHeight(); 
         
         if (dragging == true) 
            return;     
         
         else if (x > 3 && x < width - 56 && y > 3 && y < height - 3) {
            prevX = x;
            prevY = y;
            dragging = true;
            setUpDrawingGraphics();
         }
         
      } // end mousePressed()

      public void mouseReleased(MouseEvent evt) {
         if (dragging == false)
            return;  // Nothing to do because the user isn't drawing.
         dragging = false;
         graphicsForDrawing.dispose();
         graphicsForDrawing = null;
      }

      public void mouseDragged(MouseEvent evt) {
         
         if (dragging == false)
            return;  // Nothing to do because the user isn't drawing.
         
         int x = evt.getX(); 
         int y = evt.getY();  
         
         if (x < 3)                        
            x = 3;                         
         if (x > getWidth() - 57)      
            x = getWidth() - 57;
         
         if (y < 3)                          
            y = 3;                          
         if (y > getHeight() - 4)       
            y = getHeight() - 4;
         
         graphicsForDrawing.drawLine(prevX, prevY, x, y);  // Draw the line.
         
         prevX = x;  
         prevY = y;
         
      } // end mouseDragged()
      
      
      public void mouseEntered(MouseEvent evt) { }
      public void mouseExited(MouseEvent evt) { }  
      public void mouseClicked(MouseEvent evt) { }  
      public void mouseMoved(MouseEvent evt) { }  
      
      
   } 

} 