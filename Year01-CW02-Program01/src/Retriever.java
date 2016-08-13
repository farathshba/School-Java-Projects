import java.util.*;

public class Retriever 
{
	//	Declaration of local variables
	static String productDes, productCode, productPrice, productUnit;
	//	Counter initialized to '0' which would be used for keeping track of less than 100 products
	static int counter = 0;
	
	//	Declaration of the Catalog Object
	private static Catalog catalog = null;
	
	//	----	Methods		-----
	//	Method to return the String
	public static String getString()
	{
		Scanner input = new Scanner(System.in);
		return input.nextLine();
	}
	
	//	Method to prompt for the user input
	public static void prompter()
	{
		//		Do-While loop to keep track of products to be less than 100.
		do
		{	
			System.out.print("Enter product description: ");
			productDes = getString();
		
			//	If the user enters '#', the program should break itself out from the For-Loop
			if(productDes.matches("#"))
			{
				break;
			}
			
			// Program to keep prompting for the Product Information	
			System.out.print("Enter product code: ");
			productCode = getString();
			System.out.print("Enter product unit price: ");
			productPrice = getString();
			System.out.print("Enter product unit phrase: ");
			productUnit = getString();
			counter = counter + 1;
			
			System.out.println();
			//	The retrieved product information to be stored it in ArrayList in the Class
			catalog = new Catalog(productDes, productCode, productPrice, productUnit);
			
		}while(counter <= 100);
	}
	
	//	Method to print the Catalog in the order as they were entered
	public static void printCatalog()
	{
		System.out.println("Your catalog:");
		for(int count = 0; count <= catalog.totalSizeofArrayList()-1; count++)
		{			
			try
			{
				System.out.println(catalog.ProductDescription.get(count) + ", " + catalog.ProductCode.get(count) + ", " + catalog.ProductPrice.get(count) + ", " + catalog.ProductUnit.get(count) + ".");
			}
			catch(Exception ex)
			{
				System.out.println("Catch overthrown!");
			}
		}
	}
}
