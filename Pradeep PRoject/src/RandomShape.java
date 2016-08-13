/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;


public class RandomShape 
{
    JFrame frame;

    public static void main(String[] args) 
    {
        RandomShape test = new RandomShape();
        test.start();
    }

    public void start() 
    {
        DrawPanel panel = new DrawPanel();
        frame = new JFrame();
        frame.setSize(500, 500);
        frame.add(panel);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        


    }

    private class DrawPanel extends JPanel 
    {

        Random r = new Random();

        public void paintComponent(Graphics g) 
        {
            super.paintComponent(g);
            Color clr = new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255));
            g.setColor(clr);
            
            // Minimum size is set to 20x20.
            int width = 20 + r.nextInt(frame.getContentPane().getWidth()-(20 + 1));
            int height = 20 + r.nextInt(frame.getContentPane().getHeight()-(20 + 1));
            
            int n = r.nextInt(360);
            int z = r.nextInt(740) - 360;
            
            int x = ((frame.getContentPane().getWidth())/2)-(width/2);
            int y = ((frame.getContentPane().getHeight())/2)-(height/2);
            
            int shapeSelector = r.nextInt(3);
     
            switch (shapeSelector) {
                
                case 0: g.fillOval(x, y, width, height);
                        break;
                    
                case 1: g.fillRect(x, y, width, height);
                        break;
                    
                case 2: g.fillArc(x,y,width,height,n,z);
                        break;
                    
            }   
        }
    }
}
