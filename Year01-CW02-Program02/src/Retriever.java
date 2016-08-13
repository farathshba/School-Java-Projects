import java.util.Scanner;


public class Retriever 
{
	//	----------		Variables		-----------	//
	private static String productDesp;
	private static String productCode;
	private static String productUnitPrice;
	private static String productUnitQuanPhase;
	
	//	Array is used to store the objects
	private static Catalog[] list = new Catalog[100];
	
	//	The class
	private static Catalog catalog01 = new Catalog();
	
	//	Variables used for Sorting Method
	private static boolean loop = true;
	private static Catalog temp;
	
	
	//	----------		Methods		-----------	//
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
	
	//	This following method to Prompt for 100 entries of the product information
	public static void prompter(int quantity)
	{
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
			list[count] = new Catalog(productDesp, productCode, productUnitPrice, productUnitQuanPhase);
			catalog01.insertProductDescQuantity(count);
		}
	}
	
	//	This following method to Sort the objects accordingly to the Product Code
	public static void sorter()
	{
		//		Sorting to be done
		while(loop)
		{
			loop = false;
			Catalog cata01;
			Catalog cata02;
			System.out.println("The total size of ArrayList : " + catalog01.printProductDescQuantity());
			for(int count = 0; count < catalog01.printProductDescQuantity(); count++)
			{
				//	Creation of the Forks
				System.out.println("#" + count);
				cata01 = list[count];
				cata02 = list[(count + 1)];
				
				if(cata01.printProductLine().charAt(0) > cata02.printProductLine().charAt(0))
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
	
	public static void bubble_sort()
	{
		for(int i = 0; i < catalog01.printProductDescQuantity(); i++)
		{
			for(int j = 1; j < catalog01.printProductDescQuantity(); j++)
			{				
				// add the following code, use the string.compareTo() method to compare strings
				int result = list[j].printProductLine().compareTo(list[j-1].printProductLine());
				
				if(result < 0)
				{
					temp = list[j];
					list[j] = list[(j - 1)];
					list[(j - 1)] = temp;
				}
			}
		}
	}
	
	//	Method to print the contents of the Objects been stored in the Arrays
	public static void CatalogPrinter()
	{
		//	The contents of the Catalog object is being printed out
		for(int count = 0; count <= catalog01.printProductDescQuantity(); count++)
		{
			Catalog catalog02 = list[count];
			System.out.print(catalog02.printProductLine() + "\n");
		}
	}
}
