import javax.swing.*;
import java.net.*;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.io.*;
import java.awt.event.*;

//	Alice JFrame 
public class Alice extends JFrame implements Runnable 
{
	//	Components 
	JLabel labelOne;
	JTextField input;
	JLabel labelTwo;
	JTextField random;
	JLabel labelThree;
	JTextField xor;
	JLabel labelFour;
	JTextField xoxor;
	JLabel labelFive;
	JTextField rexor;
	JButton stepButton;
	
	FlowLayout layout;
	
	Socket socket = null;
	PrintWriter out = null;
	BufferedReader in = null;
	Listener listener;
	Encrypt encrypt;
	int count = 0;
	static String rand = "";
	
	public Alice()
	{
		//	 Customizations to components
		this.setSize(350, 300);
		this.setLocation(100, 250);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Alice");
		this.setResizable(false);
		
		labelOne = new JLabel("Input : ");
		input = new JTextField(20);
		
		labelTwo = new JLabel("Rand A : ");
		random = new JTextField(20);
		random.setEnabled(false);
		
		labelThree = new JLabel("Xor : ");
		xor = new JTextField(20);
		xor.setBackground(Color.black);
		xor.setEnabled(false);
		
		labelFour = new JLabel("Xo'Xor : ");
		xoxor = new JTextField(20);
		xoxor.setEnabled(false);
		
		labelFive = new JLabel("Re'Xor : ");
		rexor = new JTextField(20);
		rexor.setBackground(Color.black);
		rexor.setEnabled(false);
		
		stepButton = new JButton("Step into");
		
		listener = new Listener();
		stepButton.addActionListener(listener);
		layout = new FlowLayout(FlowLayout.CENTER, 20, 20);
	}
	
	//	Initialization of the server socket
	public void initServer()
	{
		try
		{
			socket = new Socket("127.0.0.1", 6061);
			out = new PrintWriter(socket.getOutputStream(), true);
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

		}
		catch(UnknownHostException error)
		{
			System.err.println("Hostname validation failed.");
			System.exit(1);
		}
		catch(IOException error)
		{
			 System.err.println("Couldn't get I/O for the connection to: " + error.getMessage());
			 System.exit(1);
		}
	}
	
	//	Method to run the thread
	public void run()
	{
		this.setLayout(layout);
		this.add(labelOne);
		this.add(input);
		this.add(labelTwo);
		this.add(random);
		this.add(labelThree);
		this.add(xor);
		this.add(labelFour);
		this.add(xoxor);
		this.add(labelFive);
		this.add(rexor);
		this.add(stepButton);
		this.setVisible(true);
	}
	
	//	Listener class containing the methods to do after pressing button
	private class Listener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			//	If button is pressed - the presses are monitored and acted accordingly
			if(e.getSource() == stepButton)
			{
				count++;
				initServer();
				if(count == 1)
				{
					//	Generate the random numerals
					encrypt = new Encrypt();
					rand = encrypt.sendRandomKey(input.getText());
					random.setText(rand);
				}
				else if(count == 2)
				{
					//	XOR the random key with message
					String cipertext = Integer.toBinaryString(Integer.parseInt(String.valueOf(Integer.parseInt(input.getText(), 2) ^ Integer.parseInt(rand, 2))));
					xor.setText(cipertext);
					out.println(cipertext);
				}
				else if(count == 3)
				{
					try
					{
						xoxor.setText(in.readLine());
					}
					catch(IOException err)
					{
						System.err.println(err.getMessage());
					}
				}
				else if(count == 4)
				{
					String rexorStr = Integer.toBinaryString(Integer.parseInt(String.valueOf(Integer.parseInt(xoxor.getText(), 2) ^ Integer.parseInt(rand, 2))));
					rexor.setText(rexorStr);
					try{
					Thread.sleep(100);
					}
					catch(Exception err)
					{
						
					}
					out.println(rexor.getText());
				}
				else if(count ==5)
				{
					stepButton.setEnabled(false);
				}
			}
		}
	}
}
