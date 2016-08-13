import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;


public class FileServer {
	private int port = 1983;
	private ServerSocket serverSocket;
	private Socket clientSocket;
	private PrintWriter out;
	private BufferedReader in;
	private static final String EOM = "9f0b2ce4-a1f5-4797-af4c-3b5ad5ef0945"; //The magic string that signifies End Of Message. generated using UUID.randomUUID(). Probably overkill for our needs.
	
	public static String getEOM() {
		return EOM;
	}
	
	public void go() throws Exception {
		init();
		
		respondToCommands();
		
		closeAll();
	}
	
	private void init() throws Exception {
		serverSocket = new ServerSocket(port);
		clientSocket = serverSocket.accept();
		
		//set up input and output streams for reading from and writing to the client
		in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
		out = new PrintWriter(clientSocket.getOutputStream(), true);

		//send a welcome message
		sendOutputToClient("Welcome to the FileServer. Have fun! :)"
							+'\n'
							+"Available commands are: \"show\", \"read <filename>\"");
	}
	
	private void respondToCommands() throws Exception {
		String inputLine = null;
		while ((inputLine = in.readLine()) != null) {
			//respond appropriately to user input
			if (inputLine.toLowerCase().startsWith("read")) { 
				String filename = inputLine.substring(5); //get rid of "read ", the rest of the string should be a filename
				String output = getFileContents(filename);
				
				sendOutputToClient(output);
			} else if (inputLine.toLowerCase().equals("show")) {
				sendOutputToClient(listFiles());
			}
		}
	}
	
	//our shutdown method. close all open streams
	private void closeAll() throws Exception {
		//out of the loop. all done, close the connection
		in.close();
		out.close(); 
		clientSocket.close();
	}
	
	//return the contents of the current directory
	private String listFiles() {
		StringBuffer sb = new StringBuffer();
		File file = new File(".");
		String[] fileList = file.list();
		for (String f : fileList) {
			if (f.equals(".") || f.equals("..")) {
				//do nothing (do not display to the client "." [current directory] or ".." [parent directory])
			} else {
				sb.append(f+'\n');
			}
		}
		//remove trailing newline
		sb.deleteCharAt((sb.length()-1));
		return sb.toString(); 
	}
	
	//return the contents of a file as a string, with a header and footer demarcating the beginning and end of the file
	private String getFileContents(String filename) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(filename), "UTF-8"));
		String line;
		StringBuffer sb = new StringBuffer();
		sb.append("----------BEGIN "+filename+"----------");
		sb.append('\n');
		while ((line = reader.readLine()) != null) {
			sb.append(line+'\n');
		}
		sb.append("-----------END "+filename+"-----------");
		reader.close();
		
		return sb.toString();
	}
	
	//send text to the client
	private void sendOutputToClient(String s) {
		out.println(s);
		out.println(EOM);
	}
	
	public static void main(String[] args) throws Exception {
		FileServer server = new FileServer();
		server.go();
	}
}
