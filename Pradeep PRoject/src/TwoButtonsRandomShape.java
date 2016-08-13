
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;


public class TwoButtonsRandomShape 
{
    JFrame window;
    DrawPanel panel;
    boolean buttonPressed = false;

    public static void main(String[] args) 
    {
        TwoButtonsRandomShape test = new TwoButtonsRandomShape();
        test.start();
    }

    public void start() 
    {

        window = new JFrame();
        panel = new DrawPanel();
        JButton buttonOne = new JButton("Click To Draw a Random Shape");
        JButton buttonTwo = new JButton("Click To Clear Screen");
        buttonOne.addActionListener(new NorthButton());
        buttonTwo.addActionListener(new SouthButton());
        window.setSize(500, 500);
        window.setResizable(false);
        window.getContentPane().add(BorderLayout.CENTER, panel);
        window.getContentPane().add(BorderLayout.NORTH, buttonOne);
        window.getContentPane().add(BorderLayout.SOUTH, buttonTwo);
        window.setVisible(true);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    private class NorthButton implements ActionListener 
    {

        @Override
        public void actionPerformed(ActionEvent actionEventa) 
        {
            if (!buttonPressed) {
                buttonPressed = true;
                window.repaint();
            }
        }
    }
    private class SouthButton implements ActionListener 
    {

        public void actionPerformed(ActionEvent actionEventb) {
            buttonPressed = false;
            window.repaint();
        }  
    }

    private class DrawPanel extends JPanel 
    {

        Random r = new Random();

        public void paintComponent(Graphics graphical) {
            super.paintComponent(graphical);
            Color clr = new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255));
            graphical.setColor(clr);

            // Minimum size is set to 20x20.
            int width = 20 + r.nextInt(this.getWidth() - 21);
            int height = 20 + r.nextInt(this.getHeight() - 21);

            int n = r.nextInt(360);
            int z = r.nextInt(740) - 360;

            int x = ((this.getWidth()) / 2) - (width / 2);
            int y = ((this.getHeight()) / 2) - (height / 2);

            int shapeSelector = r.nextInt(3);
            if (buttonPressed) {
                switch (shapeSelector) {

                    case 0:
                    	graphical.fillOval(x, y, width, height);
                        break;

                    case 1:
                    	graphical.fillRect(x, y, width, height);
                        break;

                    case 2:
                        graphical.fillArc(x, y, width, height, n, z);
                        break;

                }
            } 
            else 
            {
            	graphical.clearRect(0,0,this.getWidth(),this.getHeight());
            }
        }
    }
}
