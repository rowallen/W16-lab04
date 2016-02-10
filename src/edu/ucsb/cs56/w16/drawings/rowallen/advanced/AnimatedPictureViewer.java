package edu.ucsb.cs56.w16.drawings.rowallen.advanced;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import edu.ucsb.cs56.w16.drawings.utilities.ShapeTransforms;

/**
 * A main class to view an animation
 *
 * @author Ryan Allen
 * @version for CS56, W16
 */


public class AnimatedPictureViewer {

    private DrawPanel panel = new DrawPanel();
    
    //    private Ipod ipod = new Ipod(100, 100, 100);
    private FlagPole fp = new FlagPole(150,100,100,50);
    
    Thread anim;   
    
    private int x = 250;
    private int y = 100;    
    private double theta = 0.0;
    private double dTheta = Math.PI/36;

    
    public static void main (String[] args) {
      new AnimatedPictureViewer().go();
    }

    public void go() {
      JFrame frame = new JFrame();
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      frame.getContentPane().add(panel);
      frame.setSize(640,480);
      frame.setVisible(true);
      
      frame.getContentPane().addMouseListener(new MouseAdapter() {
        public void mouseEntered(MouseEvent e){
        System.out.println("mouse entered");
          anim = new Animation();
          anim.start();
        }

        public void mouseExited(MouseEvent e){        
          System.out.println("Mouse exited");
          // Kill the animation thread
          anim.interrupt();
          while (anim.isAlive()){}
          anim = null;         
          panel.repaint();        
        }
      });
      
    } // go()

    class DrawPanel extends JPanel {
       public void paintComponent(Graphics g) {

        Graphics2D g2 = (Graphics2D) g;

         // Clear the panel first
          g2.setColor(Color.white);
          g2.fillRect(0,0,this.getWidth(), this.getHeight());

          // Draw the Ipod
          g2.setColor(Color.BLUE);
	  //Ipod test = new Ipod(x, y, 100);
	  FlagPole initial = new FlagPole(x, y, 100, 50);
	  Shape rotated = ShapeTransforms.rotatedCopyOf(initial, theta);
	  g2.draw(rotated);
       }
    }
    
    class Animation extends Thread {
      public void run() {
        try {
          while (true) {
	      // Bounce off the walls
	      /*
            if (x >= 400) { dx = -5; }
            if (x <= 50) { dx = 5; }
            
            x += dx;                
	      */
	      // Spin
	      theta += dTheta;
	      if (theta >= (2*(Math.PI)))
		  theta = 0;
	      
	      panel.repaint();
	      Thread.sleep(50);
          }
        } catch(Exception ex) {
          if (ex instanceof InterruptedException) {
            // Do nothing - expected on mouseExited
          } else {
            ex.printStackTrace();
            System.exit(1);
          }
        }
      }
    }
    
}
