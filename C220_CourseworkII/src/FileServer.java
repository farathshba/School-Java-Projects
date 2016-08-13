import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;


public class FileServer 
{
	private int port = 1983;
	private ServerSocket serverSocket;
	private Socket clientSocket;
	private PrintWriter out;
	private BufferedReader in;
	private static final String EOM = "9f0b2ce4-a1f5-4797-af4c-3b5ad5ef0945"; //The magic string that signifies End Of Message. generated using UUID.randomUUID(). Probably overkill for our needs.
		
	//-------------------------------- Main method -------------------------------- //
	public static void main(String[] args)
	{
		FileServer server = new FileServer();
		server.go();
	}
	
	//------------------------------- Main Helper methods ------------------------- //
	public void go() 
	{
		init();
		respondToCommands();
		closeAll();
	}
	
	//	Method to connect to the server
	private void init()
	{
		try{
		serverSocket = new ServerSocket(port);
		clientSocket = serverSocket.accept();
		
		// Set up input and output streams for reading from and writing to the client
		in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
		out = new PrintWriter(clientSocket.getOutputStream(), true);
		}
		catch(Exception err)
		{
			System.err.println("Error connecting to Server Sockets");
		}
		//send a welcome message
		sendOutputToClient("Welcome to the FileServer. Have fun! :)"
							+'\n'
							+"Available commands are: \"show\", \"read <filename>\"");
	}
	
	//	Method used to respond to commands
	private void respondToCommands()
	{
		try{
		String inputLine = null;
		while ((inputLine = in.readLine()) != null) 
		{
			//respond appropriately to user input
			if (inputLine.toLowerCase().startsWith("read")) 
			{ 
				try{
				String filename = inputLine.substring(5); //get rid of "read ", the rest of the string should be a filename
				String output = getFileContents(filename);
				sendOutputToClient(output);
				}
				catch(Exception err)
				{
					sendOutputToClient("File name is empty");
				}
			}
			else if (inputLine.toLowerCase().equals("show")) 
			{
				sendOutputToClient(listFiles());
			}
			else
			{
				sendOutputToClient("Unable to recognise command");
			}
		}
		}
		catch(Exception err)
		{
			System.err.println("Error responding to commands");
		}
	}
	
	// Method used to close all streams
	private void closeAll()
	{
		try{
		//out of the loop. all done, close the connection
		in.close();
		out.close(); 
		clientSocket.close();
		}
		catch(Exception err)
		{
			System.err.println("Error closing the application");
		}
	}
		
	//------------------------------- Slave Helper methods ------------------------- //
	
	// Method to send text to the client (GUI)
	private void sendOutputToClient(String s) 
	{
		out.println(s);
		out.println(EOM);
	}
		
	// Method to return the contents of a file as a string, with a header and footer demarcating the beginning and end of the file
	private String getFileContents(String filename) throws Exception
	{
		BufferedReader reader;
		StringBuffer sb = new StringBuffer();
		try{
		reader = new BufferedReader(new InputStreamReader(new FileInputStream(filename), "UTF-8"));
		String line;
		sb.append("----------BEGIN "+filename+"----------");
		sb.append('\n');
		while ((line = reader.readLine()) != null) 
		{
			sb.append(line+'\n');
		}
		sb.append("-----------END "+filename+"-----------");
		reader.close();
		}
		catch(Exception err)
		{
			sendOutputToClient("File missing");
		}
		return sb.toString();
	}
	
	// Method to return the contents of the current directory
	private String listFiles() 
	{
		StringBuffer sb = new StringBuffer();
		File file = new File(".");
		String[] fileList = file.list();
		for (String f : fileList) 
		{
			if (f.equals(".") || f.equals("..")) 
			{
			//do nothing (do not display to the client "." [current directory] or ".." [parent directory])
			} 
			else 
			{
				sb.append(f+'\n');
			}
		}
		//remove trailing newline
		sb.deleteCharAt((sb.length()-1));
		return sb.toString(); 
	}
	
	//	Method to derive the End of Message code
	public static String getEOM() 
	{
		return EOM;
	}
	
	
	
	
	
	
	
	
}
