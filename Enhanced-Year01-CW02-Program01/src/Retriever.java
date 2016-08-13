import java.util.ArrayList;
import java.util.Scanner;

//	This class shall serve the purpose of doing all the computations for the program
public class Retriever 
{
	//	-----------		Variables		-----------	//
	private static String productDesp, productCode, productUnitPrice, productUnitQuanPhase;
	private static int noOfProducts;
	
	//	ArrayList being created with objects of Catalog Data-type to be stored
	private static ArrayList<Catalog> list = new ArrayList<Catalog>();
	
	//	-----------		Constructors		-----------	//
	Retriever(int noOfProducts)
	{
		this.noOfProducts = noOfProducts;
	}
	
	//	-----------		Methods		-----------	//
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
	
	//	This following method would get the product information and store it into the respective objects' variables
	public static void getProductInfo()
	{
		//		Prompt for 100 entries of the product information
		for(int count = 0; count <= noOfProducts; count++)
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
			list.add(new Catalog(productDesp, productCode, productUnitPrice, productUnitQuanPhase));
		}
	}
	
	public static void printProductInfo()
	{
		//		The contents of the Catalog object is being printed out
			for(int count = 0; count < list.size(); count++)
			{
				Catalog catalog = list.get(count);
				System.out.print(catalog.printProductCode() + ", " + catalog.printProductName() + ", " + catalog.printProductPrice() + ", " + catalog.printQuantity() + ".\n");
			}
	}
}
