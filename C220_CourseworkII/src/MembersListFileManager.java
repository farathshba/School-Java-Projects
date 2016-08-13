import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class MembersListFileManager 
{
	
	private final static String filename = "members.s";
	
	
	private MembersListFileManager() 
	{
		//no public constructor, all methods must be called statically
	}
	
	public static void writeMembersToDisk(ArrayList<Member> membersList) 
	{
		ObjectOutputStream out = null;
		try 
		{
			out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(filename)));

			for(Member cmd : membersList) 
			{
				out.writeObject(cmd);
			}
		} 
		catch (Exception e) 
		{
			System.err.println("Something went wrong: " + e.toString());
		} 
		finally 
		{
			try 
			{
				out.close();
			}
			catch (IOException e) 
			{
				System.err.println("Error closing the file writing stream: " + e.toString());
			}
		}
	}
	
	public static ArrayList<Member> readMembersFromDisk()
	{
		//	Creation of ArrayList and File Stream variables
		ArrayList<Member> tempArrayList = new ArrayList<Member>();
		ObjectInputStream ois = null;
		FileInputStream fis;
		
		try
		{
			//	Initialization of FileStream variables
			fis = new FileInputStream(filename);
			ois = new ObjectInputStream(fis);
		
			//	Read object by object and add into the ArrayList
			while(fis.available() > 0)
			{
				tempArrayList.add((Member)ois.readObject());
			}
			
			fis.close();
			ois.close();
		}
		catch(Exception error)
		{
			System.err.println("File not found.");
		}
		return tempArrayList;
	}

}
