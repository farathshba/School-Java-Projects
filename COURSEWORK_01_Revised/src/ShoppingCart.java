import java.util.*;

public class ShoppingCart 
{
	//	Global Variables to hold the Product Information
	//	This would hold the GIVEN Shop's Products in Arrays
	private static String[] NAME_OF_PRODUCTS;
	private static double[] INDIVIDUAL_PRICES;
	private static String[] PRODUCT_CODE;
	private static String[] PRODUCT_ANALYZER = {" per packet", " a dozen", " for 60"};
	
	//	This column of arrays' stack keep track of the Products' information being purchased 
	private static String[] BuyingItems;
	private static String[] BuyingItemsName;
	private static double[] BuyingPrices;
	private static int[] BuyingQuantity;
	
	//	This would hold the Shopping Cart's Information which would be outputted
	private static int[] QUANTITY = new int[3];
	
	//	Class
	ShoppingCart()
	{
		System.out.println("Our catalouge [Product Codes in brackets] : ");
		
		for(int counter = 0; counter < NAME_OF_PRODUCTS.length; counter++)
		{
			System.out.println("(" + counter + ") " + NAME_OF_PRODUCTS[counter] + " [" + PRODUCT_CODE[counter] + "], " + INDIVIDUAL_PRICES[counter] + PRODUCT_ANALYZER[counter]);
		}
		
		System.out.println("Buy something!");
		
		while(!getOrderNo().matches("0"))
		{
			for(int counter = 0; counter < 4; counter++)
			{
				BuyingItems[counter] = getOrderNo();
				
			}
		}
	}
	
	//	Methods
	private static String getString()
	{
		Scanner input = new Scanner(System.in);
		return input.nextLine();
	}
	
	private static int getInteger()
	{
		Scanner input = new Scanner(System.in);
		return input.nextInt();
	}
	
	private static String getOrderNo()
	{
		System.out.print("Enter Order Number (0 to Stop) : ");
		return getString();
	}
	
	public static void ShoppingCartI()
	{
		String[] localNAME_OF_PRODUCTS = {"Condensed Powdered water", "Distilled Moonbeams", "Anti-Gravity Pills"};
		NAME_OF_PRODUCTS = localNAME_OF_PRODUCTS;
		
		double[] localINDIVIDUAL_PRICES = {2.5, 3, 12.75};
		INDIVIDUAL_PRICES = localINDIVIDUAL_PRICES;
		
		String[] localPRODUCT_CODE = {"P3487", "K3876", "Z9983"};
		PRODUCT_CODE = localPRODUCT_CODE;
		
		
		ShoppingCart shopper = new ShoppingCart();
	}
	
}
