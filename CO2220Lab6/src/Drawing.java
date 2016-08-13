import javax.swing.*;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.*;

public class Drawing extends JFrame
{
	private GPanel panel;
	
	public class GPanel extends JPanel
	{
		public void paintComponent(Graphics g)
		{
			g.setColor(Color.BLUE);
			
			for(int i=0; i < 300; i++)
			{
				g.fillOval(i, i, 20, 20);
				g.drawOval(i, i, 20, 20);
			}
			
		}
	}
	
	public Drawing()
	{
		this.setSize(300,300);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panel = new GPanel();
		this.getContentPane().add(panel);
	}
	
	public static void main(String[] args)
	{
		new Drawing();
	}
}
