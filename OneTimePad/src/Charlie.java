import javax.swing.*;

import java.net.*;
import java.awt.*;
import java.io.*;

//	Charlie JFrame
public class Charlie extends JFrame implements Runnable 
{
	//	Components
	JLabel labelOne;
	JTextField xor;
	JLabel labelTwo;
	JTextField xoxor;
	JLabel labelThree;
	JTextField ranB;
	JLabel labelFour;	
	JTextField rexor;
	JLabel labelFive;
	JTextField message;
	
	FlowLayout layout;
	
	ServerSocket serverSocket = null;
	Socket clientSocket = null;
	BufferedReader in = null;
	
	public Charlie()
	{
		//	 Customizations to components
		this.setSize(340, 300);
		this.setLocation(800, 250);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Charlie");
		this.setResizable(false);
		
		labelOne = new JLabel("Xor");
		xor = new JTextField(20);
		xor.setEnabled(false);
		
		labelTwo = new JLabel("Xo'Xor : ");
		xoxor = new JTextField(20);
		xoxor.setEnabled(false);
		
		labelThree = new JLabel("+: ");
		ranB = new JTextField(20);
		ranB.setEnabled(false);
		
		labelFour = new JLabel("Re'Xor : ");
		rexor = new JTextField(20);
		rexor.setEnabled(false);
		
		labelFive = new JLabel("Message : ");
		message = new JTextField(20);
		message.setEnabled(false);
		
		layout = new FlowLayout(FlowLayout.CENTER, 20, 20);
	}
	
	//	Initialization of the network socket from Bob 
	public void initClientNetwork() throws IOException
	{		
		try
		{
			serverSocket = new ServerSocket(8088);
		}
		catch(Exception error)
		{
			System.err.println("Could not listen on port: 8088 from Charlie"); 
	        System.exit(1); 
		}
		
		try 
		{ 
	         clientSocket = serverSocket.accept();
		} 
	    catch(IOException e) 
	    { 
	         System.err.println("Acception of socket failed."); 
	         System.exit(1); 
	    }
		 
		in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream())); 
		
		updateFrame();
	}
	
	//	Method to update the frame with accordance from values from Bob 
	public void updateFrame() throws IOException
	{
		xor.setText(in.readLine());
		xoxor.setText(in.readLine());
		String randB = Integer.toBinaryString(Integer.parseInt(String.valueOf(Integer.parseInt(xor.getText(), 2) ^ Integer.parseInt(xoxor.getText(), 2))));
		ranB.setText(randB);
		rexor.setText(in.readLine());
		String msg = Integer.toBinaryString(Integer.parseInt(String.valueOf(Integer.parseInt(rexor.getText(), 2) ^ Integer.parseInt(ranB.getText(), 2))));
		message.setText(msg);
		
		in.close();
		clientSocket.close();
		serverSocket.close();
	}
	
	//	Method to run the thread
	public void run()
	{
		this.setLayout(layout);
		this.add(labelOne);
		this.add(xor);
		this.add(labelTwo);
		this.add(xoxor);
		this.add(labelThree);
		this.add(ranB);
		this.add(labelFour);
		this.add(rexor);
		this.add(labelFive);
		this.add(message);
		this.setVisible(true);	
		
		try
		{
			for(;;)
			{
				initClientNetwork();
			}
		}
		catch(IOException e)
		{
			System.err.println("Error");
		}
	}
}
