/*
Chapter 14 Sample Program: A simple subclass of JFrame
File: Ch14JFrameSubclass1.java
*/
import javax.swing.*;
import java.awt.TrayIcon.MessageType;
import java.awt.*;
import java.awt.event.*;

class Ch14JFrameSubclass1 extends JFrame implements ActionListener
{
	private static final int FRAME_WIDTH = 400;
	private static final int FRAME_HEIGHT = 100;
	
	//	Window Discrete Components
	private JButton customButton;
	private JTextField customTextField;
	private JLabel customLabel;
	
	public Ch14JFrameSubclass1() 
	{
		//	set the frame default properties
		setTitle("My First Subclass");
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
		
		//	This method would allow the window to be centralized to the center of the screen
		this.setLocationRelativeTo(null);
		//	register 'Exit upon closing' as a default close operation
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	//	Method used to assign the parameter's to the JButton and construct it
	public void addButton(String buttonText)
	{
		this.customButton = new JButton(buttonText);
		
		//	
		this.customButton.addActionListener(this);
		
		this.add(customButton);
	}
	
	//	Method used to assign the parameter's to the JTextField and construct it
	public void addText(int size)
	{
		this.customTextField = new JTextField(size);
		this.add(customTextField);
	}
	
	//	Method used to assign the parameter's to the JLabel and construct it
	public void addLabel(String labelText)
	{
		this.customLabel = new JLabel(labelText);
		this.add(customLabel);
	}
	
	//	Method to be activated upon the Button being depressed
	public void actionPerformed(ActionEvent e)
	{
		JOptionPane.showMessageDialog(null, "Hello, " + customTextField.getText(), "Hello World!", 1);
	}
}

