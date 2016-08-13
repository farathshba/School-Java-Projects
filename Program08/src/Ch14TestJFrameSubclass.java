import java.awt.*;
import java.awt.TrayIcon.MessageType;
import javax.swing.JOptionPane;
import java.awt.event.*;

/*
Chapter 14 Sample Program: Displays a default Ch14JFrameSubclass window
File: Ch14TestJFrameSubclass.java
*/
class Ch14TestJFrameSubclass 
{
	public static void main(String[] args)
	{
		Ch14JFrameSubclass1 myFrame = new Ch14JFrameSubclass1();
		
		//	A String "Name : " is passed to the method of the Ch14JFrameSubclass1 for the construction of the Label with 
		//	the text in the parameters.
		myFrame.addLabel("Name : ");
		
		//	A Size of '25' is passed to the method of the Ch14JFrameSubclass1 for the construction of the TextField with 
		//	the size in proportion to the parameters.
		myFrame.addText(25);
		
		//	A String "Ok" is passed to the method of the Ch14JFrameSubclass1 for the construction of the button with 
		//	the text in the parameters.
		myFrame.addButton("Ok");
		
		//	Sets the Layout of the Frame to FlowLayout with all of the components pushed to the 'LEFT'
		myFrame.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		//listener.setMessage("Your name is " + myFrame.getTextFromField(), "Name", JOptionPane.INFORMATION_MESSAGE);
		//myFrame.setButtonEvent(listener);
		
		myFrame.setVisible(true);
	}
}