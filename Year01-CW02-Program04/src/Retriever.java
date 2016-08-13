import java.io.*;
import java.util.*;

public class Retriever 
{
	//	----------		Variables		----------	//
	
	//	Array is used to store the objects
	private static ArrayList<Catalog> list = new ArrayList<Catalog>();
	//private static Catalog[] list = new Catalog[100];
		
	//	The class
	private static Catalog catalog01 = new Catalog();
		
	//	Variables used for Sorting Method
	private static boolean loop = true;
	private static Catalog temp;
	
	
	//	----------		Methods		----------	//
	//	This following method would return the String
	public static String getString()
	{
		Scanner input = new Scanner(System.in);
		return input.nextLine();
	}
	
	//	This following method would return empty Lines with respect to the arguments
	public static void printLine(int Lines)
	{
		for(int count = 0; count < Lines; count++)
		{
			System.out.println();
		}
	}
	
	//	This method would sort the products in the Array
	public static void ProductSorter()
	{
		//		Sorting to be done
		while(loop)
		{
			loop = false;
			Catalog cata01;
			Catalog cata02;
			for(int count = 0; count < catalog01.printProductDescQuantity(); count++)
			{
				//	Creation of the Forks
				cata01 = list.get(count);
				cata02 = list.get((count+1));
					
				if(cata01.printProductLine().charAt(0) > cata02.printProductLine().charAt(0))
				{
					temp = list.get(count);
					list.add(count, list.get((count+1)));
					list.add((count + 1), temp);
						
					loop = true;
				}
				else
				{
					loop = false;
				}
			}
		}
	}
	
	//	This method would read in the contents of the File
	public static void FileReader(String fileName)
	{
		//	The contents of the Catalog object is being read into the array
		try
		{
			Scanner fileRdr = new Scanner(new File(fileName));
			
			for(int count = 0; count <= catalog01.printProductDescQuantity(); count++)
			{
				while(fileRdr.hasNext())
				{
					list.add(new Catalog(fileRdr.nextLine()));
				}
			}
			fileRdr.close();
		}
		catch(FileNotFoundException ex)
		{
			System.out.println("File not found!");
		}
	}
	
	public static void fileOutputter()
	{
		for(int count = 0; count <= list.size()-1; count++)
		{
			System.out.println(list.get(count).printProductLine());
		}
	}
}
