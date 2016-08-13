import javax.swing.*;
import java.net.*;
import java.awt.*;
import java.io.*;

//	Bob JFrame
public class Bob extends JFrame implements Runnable 
{
	//	Components
	JLabel labelOne;
	JTextField random;
	JLabel labelTwo;
	JTextField xor;
	JLabel labelThree;
	JTextField xoxor;
	JLabel labelFour;	
	JTextField rexor;
	JLabel labelFive;
	JTextField message;
	
	FlowLayout layout;
	
	Socket socket = null;
	PrintWriter ot = null;
	
	ServerSocket serverSocket = null;
	Socket clientSocket = null;
	BufferedReader in = null;
	PrintWriter out = null;
	
	public Bob()
	{
		//	 Customizations to components
		this.setSize(350, 300);
		this.setLocation(450, 250);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Bob");
		this.setResizable(false);
		
		labelOne = new JLabel("Rand B : ");
		random = new JTextField(20);
		random.setEnabled(false);
		
		labelTwo = new JLabel("Xor : ");
		xor = new JTextField(20);
		xor.setEnabled(false);
		
		labelThree = new JLabel("Xo'Xor : ");
		xoxor = new JTextField(20);
		xoxor.setBackground(Color.black);
		xoxor.setEnabled(false);
		
		labelFour = new JLabel("Re'Xor : ");
		rexor = new JTextField(20);
		rexor.setEnabled(false);
		
		labelFive = new JLabel("Message : ");
		message = new JTextField(20);
		message.setBackground(Color.black);
		message.setEnabled(false);
		
		layout = new FlowLayout(FlowLayout.CENTER, 20, 20);
	}
	
	//	Initialization of the server socket for new connections
	public void initServer()
	{
		try
		{
			socket = new Socket("127.0.0.1", 8088);
			ot = new PrintWriter(socket.getOutputStream(), true);
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
	
	//	Initialization of the network socket from Alice
	public void initNetwork() throws IOException
	{		
		try
		{
			serverSocket = new ServerSocket(6061);
		}
		catch(Exception error)
		{
			System.err.println("Could not listen on port: 6061."); 
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
		out = new PrintWriter(clientSocket.getOutputStream(), true);	
		
		updateFrame(); 
	}
	
	//	Method to update the frame with accordance from values from Alice and send values to Charlie
	public void updateFrame() throws IOException
	{
		if(random.getText().isEmpty())
		{
			random.setText(" ");
		}
		else if(xor.getText().isEmpty())
		{
			xor.setText(in.readLine());
			random.setText(new Encrypt().sendRandomKey(xor.getText()));
			ot.println(xor.getText());
		}
		else if(xoxor.getText().isEmpty())
		{
			String xoxorStr = Integer.toBinaryString(Integer.parseInt(String.valueOf(Integer.parseInt(xor.getText(), 2) ^ Integer.parseInt(random.getText(), 2))));
			xoxor.setText(xoxorStr);
			out.println(xoxor.getText());
			ot.println(xoxor.getText());
		}
		else if(rexor.getText().isEmpty())
		{
			rexor.setText(in.readLine());	
			ot.println(rexor.getText());
		}
		else if(message.getText().isEmpty())
		{
			String rexorStr = Integer.toBinaryString(Integer.parseInt(String.valueOf(Integer.parseInt(rexor.getText(), 2) ^ Integer.parseInt(random.getText(), 2))));
			message.setText(rexorStr);
		}
		
		in.close();
		clientSocket.close();
		serverSocket.close();
	}
	
	//	Method to run the thread
	public void run()
	{
		this.setLayout(layout);
		this.add(labelOne);
		this.add(random);
		this.add(labelTwo);
		this.add(xor);
		this.add(labelThree);
		this.add(xoxor);
		this.add(labelFour);
		this.add(rexor);
		this.add(labelFive);
		this.add(message);
		this.setVisible(true);	
		initServer();
		
		try
		{
			for(;;)
			{
				initNetwork();
			}
		}
		catch(Exception e)
		{
			System.err.println("Error");
		}
	}
}
