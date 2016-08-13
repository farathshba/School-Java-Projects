import java.io.*;
import java.util.*;


public class Retriever 
{
	//	----------		Variables		----------	//
	private static String productDesp, productCode, productUnitPrice, productUnitQuanPhase;
	
	//	Array is used to store the objects
	private static Catalog[] list = new Catalog[100];
	
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
	
	//	This method reads in the product information
	public static void prompter(int quantity)
	{
		//	Prompt for 100 entries of the product information
		for(int count = 0; count <= quantity; count++)
		{
			System.out.print("Enter product description: ");
			productDesp = getString();
			
			//	if '#' is entered, then program breaks itself from the 'for loop'
			if(productDesp.equals("#"))
				break;
				
			System.out.print("Enter product code: ");
			productCode = getString();
				
			System.out.print("Enter product unit price: ");
			productUnitPrice = getString();
				
			System.out.print("Enter product unit phrase: ");
			productUnitQuanPhase = getString();
				
			printLine(1);
			//	Instance of the object being created with the arguments
			//list.add(new Catalog(productDesp, productCode, productUnitPrice, productUnitQuanPhase));
			list[count] = new Catalog(productDesp, productCode, productUnitPrice, productUnitQuanPhase);
			catalog01.insertProductDescQuantity(count);
		}
	}
	
	//	This method is meant to sort the elements in the array
	public static void sorter()
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
				cata01 = list[count];
				cata02 = list[(count + 1)];
					
				if(cata01.printProductCode().charAt(0) > cata02.printProductCode().charAt(0))
				{
					temp = list[count];
					list[count] = list[(count + 1)];
					list[(count + 1)] = temp;
						
					loop = true;
				}
				else
				{
					loop = false;
				}
			}
		}
	}
	
	//	This method would print the contents of the product information to the Text File
	public static void print2TextFile(String strFile)
	{
		//	Printing to an external file, named 'Catalog'
		try
		{
			PrintWriter file = new PrintWriter(strFile);
			for(int count = 0; count <= catalog01.printProductDescQuantity(); count++)
			{
				Catalog catalog02 = list[count];
				file.print(catalog02.printProductCode() + ", " + catalog02.printProductName() + ", " + catalog02.printProductPrice() + ", " + catalog02.printQuantity() + ".");
				file.println();
			}
			file.close();
		}
		catch(FileNotFoundException ex)
		{
			System.out.println("File is not found.");
		}
			
	}
	
	//	This method would print out the contents of the Array to the screen
	public static void CatalogReader()
	{
		//		The contents of the Catalog object is being printed out
		System.out.println("Your catalog:");
		for(int count = 0; count <= catalog01.printProductDescQuantity(); count++)
		{
			Catalog catalog02 = list[count];
			System.out.print(catalog02.printProductCode() + ", " + catalog02.printProductName() + ", " + catalog02.printProductPrice() + ", " + catalog02.printQuantity() + ".\n");
		}
	}
}
