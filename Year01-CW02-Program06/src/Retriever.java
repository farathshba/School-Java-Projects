import java.io.*;
import java.util.*;

public class Retriever 
{
	//	----------		Variables		----------	//
	private static String productDesp, productCode, productUnitPrice, productUnitQuanPhase;
	private static String productString;
	private static int getCount;
	
	//	Array is used to store the objects
	//private static Catalog[] list;
	private static ArrayList<Catalog> list = new ArrayList<Catalog>();
		
	//	The class
	private static Catalog catalog01 = new Catalog();
		
	//	Variables used for Sorting Method
	private static boolean loop = true;
	private static String temp;
	
	//	Variables used for Deleting Product Info
	private static String deleteProductCode;
	
	
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
	
	//	This method would read in the product descriptions and store them in arrays as 'Objects'
	public static void readInProducts(int quantity)
	{
		//		Prompt for 100 entries of the product information
		for(int count = getCount+1; count <= (quantity+getCount); count++)
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
			
			productString = productCode + ", " + productDesp + ", " + productUnitPrice + ", " + productUnitQuanPhase + ".";
			
			//	Instance of the object being created with the arguments
			list.add(count, new Catalog(productString));
			catalog01.insertProductDescQuantity(count);
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
				cata02 = list.get(count+1);
				
				if(cata01.printProductLine().charAt(0) > cata02.printProductLine().charAt(0))
				{
					temp = list.get(count).printProductLine();
					list.get(count).setProductLine(list.get((count+1)).printProductLine());
					list.get((count+1)).setProductLine(temp);
					
					loop = true;
				}
				else
				{
					loop = false;
				}
			}
		}
	}
	
	//	This method would write the array objects' into the File as given in the arguments
	public static void CatalogWriter(String fileName)
	{
		//		Printing to an external file, named 'Catalog'
		try
		{
			PrintWriter file = new PrintWriter(fileName);
			for(int count = 0; count <= catalog01.printProductDescQuantity(); count++)
			{
				Catalog catalog02 = list.get(count);
				file.print(catalog02.printProductLine());
				file.println();
			}
			file.close();
		}
		catch(FileNotFoundException ex)
		{
			System.out.println("File is not found.");
		}
	}
	
	//	This method would read in the contents of the File
	public static void FileReader(String fileName)
	{
		//		The contents of the Catalog object is being printed out from the File 'Catalog'
		System.out.println("Your catalog:");
		try
		{
			Scanner fileRdr = new Scanner(new File(fileName));
			
			for(int count = 0; count <= catalog01.printProductDescQuantity(); count++)
			{
				while(fileRdr.hasNext())
				{
					Catalog catalog02 = list.get(count);
					System.out.print(fileRdr.nextLine());
					System.out.println();
				}
			}
			fileRdr.close();
		}
		catch(FileNotFoundException ex)
		{
			System.out.println("File not found!");
		}
	}
	
	//	This method would read in the contents of the File before getting any user input
	public static void preFileRead(String fileName)
	{
		try
		{
			Scanner fileRdr = new Scanner(new File(fileName));
			for(int count = 0; fileRdr.hasNextLine(); count++)
			{
				productString = fileRdr.nextLine();
				list.add(count, new Catalog(productString));
				getCount = count;
			}
			fileRdr.close();
		}
		catch(FileNotFoundException ex)
		{
			System.out.println("File isn't being found.");
		}
	}
	
	//	This method would delete the entries from the respective columns
	public static void deleteProductEntry()
	{
		while(true)
		{
			System.out.print("Enter product codes to be deleted : ");
			deleteProductCode = getString();
			
			if(deleteProductCode.equalsIgnoreCase("#"))
				break;
			
			for(int count = 0; count < list.size(); count++)
			{
				System.out.println("Entered #01");
				System.out.println("Count : " + count);
				System.out.println("Size of the list : " + list.size());
				
				if(list.get(count).printProductLine().charAt(0) == deleteProductCode.charAt(0) && list.get(count).printProductLine().charAt(1) == deleteProductCode.charAt(1) && list.get(count).printProductLine().charAt(2) == deleteProductCode.charAt(2) && list.get(count).printProductLine().charAt(3) == deleteProductCode.charAt(3) && list.get(count).printProductLine().charAt(4) == deleteProductCode.charAt(4))	//	Replaced on ()
				{
					list.remove(count);
					System.out.println("Entered #02");
				/*	for(int countA = 0; countA <= list.size()-count; countA++)
					{
						System.out.println("Entered #03");
						while(list.size() <= count+1)
						{
							//list.add(count, list.get((count+1)));
							//list.remove((count+1));
						}
					}*/
				}
			}
		}
	}
}
