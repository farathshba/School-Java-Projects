import java.util.*;

public class product 
{
	//	Global Variables
	private static String[] ProductInfoName;
	private static String[] ProductInfoCode;
	private static double[] ProductInfoPrice;
	private static String[] QuantityOfProduce;
	
	private static String[] PurchasedProductName = new String[3];
	private static String[] PurchasedProductCode = new String[3];
	private static double[] PurchasedProductPrice = new double[3];
	private static int[] PurchasedProductQuantity = new int[3];
	private static int UniqueProductCount = 0;
	private static double SubTotal = 0.0;
	private static double Tax = 0.0;
	private static double GrandTotal = 0.0;
	
	//	Constructor
	public product(String[] productName, String[] productCode, double[] price, String[] quantity)
	{
		ProductInfoName = productName;
		ProductInfoCode = productCode;
		ProductInfoPrice = price;
		QuantityOfProduce = quantity;
	}
	
	//	Method to read in the String
	public static String getString()
	{
		Scanner input = new Scanner(System.in);
		return input.next();
	}
	
	//	Method to read in the Integer
	public static int getInt()
	{
		Scanner input = new Scanner(System.in);
		return input.nextInt();
	}
	
	//	Method to Print the First Product Lines on the console
	public static void PrintProductLine()
	{
		System.out.println("Our catalog [Product Codes in brackets] : ");
		for(int index = 0; index < ProductInfoName.length; index++)
		{
			System.out.print("(" + (index+1) + ") " + ProductInfoName[index] + " [" + ProductInfoCode[index] + "], $");
			System.out.printf("%4.2f", ProductInfoPrice[index]);
			System.out.println(" " + QuantityOfProduce[index]);
		}
	}
	
	//	Method to read in Product Code
	public static void ReadOrder()
	{
		System.out.println("Buy something!");
		
		for(int index = 0; index < 3; index++)
		{
			System.out.print("Enter Order Number (0 to stop) : ");
			PurchasedProductCode[index] = getString();
			
			switch(PurchasedProductCode[index])
			{
				case "P3487":	QuantityReader(index, 0); break;
				case "K3876":	QuantityReader(index, 1); break;
				case "Z9983":	QuantityReader(index, 2); break;
				case "0":	    UniqueProductCount = index; Cart(); index = 4; break;
				default:		System.out.println("Sorry, I don't understand! Use Product Codes only."); index--;
			}
			if(index == 2)
			{
				UniqueProductCount = index+1;
				Cart();
			}
		}
	}
	
	//	Method to read in Product Quantity
	public static void QuantityReader(int index, int locator)
	{
		System.out.print("Enter Quantity: ");
		PurchasedProductQuantity[index] = getInt();
		PurchasedProductCode[index] = ProductInfoCode[locator];
		PurchasedProductPrice[index] = ProductInfoPrice[locator];
		PurchasedProductName[index] = ProductInfoName[locator];
	}
	
	//	Method to print the Checkout Details
	public static void Cart()
	{
		System.out.println("Your order:");
		for(int index = 0; index < UniqueProductCount; index++)
		{
			System.out.print(PurchasedProductQuantity[index] + " " + PurchasedProductName[index] + " @  $");
			System.out.printf("%4.2f", PurchasedProductPrice[index]);
			System.out.print(" =  $");
			System.out.printf("%4.2f", (PurchasedProductPrice[index]*PurchasedProductQuantity[index]));
			System.out.println();
			
			SubTotal = SubTotal + (PurchasedProductPrice[index]*PurchasedProductQuantity[index]);
		}
		
		Tax = SubTotal * 0.2;
		GrandTotal = Tax + SubTotal;
		System.out.printf("Subtotal: $%5.2f    Tax @ 20%%: $%5.2f    Grand Total: $%5.2f", SubTotal, Tax, GrandTotal);
	}
}
