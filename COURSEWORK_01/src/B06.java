import java.util.*;

public class B06 
{
	//	This method keeps track of the Quantity of the individual Products been sold and returns back into the array
	public static int getQuantity()
	{
		Scanner input = new Scanner(System.in);
		System.out.print("Enter Quantity : ");
		return input.nextInt();
	}
	
	public static void ShoppingCart1()
	{
		//		---------- START OF DECLARATION OF VARIABLES & CLASSES ------------	//
		
		Scanner input = new Scanner(System.in);
		String UserInputToExitLoop = "";
		int HowManyItemsBought = 0;
		double TotalAmount = 0;
		
		//	This array stores the Product Codes of the Store Items
		String[] StoreItems = {"0", "P3487", "K3876", "Z9983"};
		//	This array stores the Prices of the Store Items
		double[] StorePrices = {0, 2.50, 3.00, 12.75};
		
		//	This column of arrays' stack keep track of the Products' information being purchased 
		String[] BuyingItems = new String[4];
		String[] BuyingItemsName = new String[4];
		double[] BuyingPrices = new double[4];
		int[] BuyingQuantity = new int[4];
		
		//		---------- END OF DECLARATION OF VARIABLES ------------	//
		
		System.out.println("Our catalog [Product Codes in brackets]:");
		System.out.println("(1) Condensed Powdered water [P3487], $2.50 per packet.");
		System.out.println("(2) Distilled Moonbeams [K3876], $3.00 a dozen.");
		System.out.println("(3) Anti-Gravity Pills [Z9983], $12.75 for 60.");
		System.out.println("Buy something!");
		
		//	The maximum items that could be purchased is 4, therefore I am limiting the loop to 4
		//	considering the fact that a user could only purchase 4 items as the maximum
		for (int counter = 0; counter < 4; counter++)
		{
			System.out.print("Enter Order Number (0 to stop) : ");
			
			//	The User Input which is the PRODUCT CODE in stored in a String Variable
			UserInputToExitLoop = input.nextLine();
		
			//	The String Variable is compared against a set conditions which are the SET OF PRODUCT CODES
			//	Upon matching the PRODUCT CODE, a set of instructions would be executed. They are as follows,
			//	The Item's Product Codes, Product Prices, Product's Names and their Quantity are stored
			//	in four different arrays with respect to their address values
			switch (UserInputToExitLoop)
			{
				case "P3487":	BuyingItems[counter] = "P3487"; BuyingPrices[counter] = 2.5; BuyingItemsName[counter] = "Condensed Powdered water"; BuyingQuantity[counter] = getQuantity(); break;
				case "K3876":	BuyingItems[counter] = "K3876"; BuyingPrices[counter] = 3; BuyingItemsName[counter] = "Distilled Moonbeams"; BuyingQuantity[counter] = getQuantity(); break;
				case "Z9983":	BuyingItems[counter] = "Z9983"; BuyingPrices[counter] = 12.75; BuyingItemsName[counter] = "Anti-Gravity Pills"; BuyingQuantity[counter] = getQuantity(); break;
				
				//	If '0' is entered, the program breaks out of the loop by initialising  counter to 4
				case "0":	HowManyItemsBought = counter; counter = 4; break;	
			
				//	If any other User Input is entered, other than the above ones, then the counter would decrement itself
				//	and prompt for the Order Number as usual
				default: counter--; System.out.println("Sorry, I don't understand! Use Product Codes only.");
			}
		}
		
		//	This segment prints out the Order Summary of the Products been purchased
		System.out.print("Your order : ");
		
		//	The multiple arrays which store the Purchased Items' Information are being printed on the screen 
		//	with respect to their address values
		for (int counter = 0; counter < HowManyItemsBought; counter++)
		{
			System.out.println(BuyingQuantity[counter] + " " + BuyingItemsName[counter] + " @ " + BuyingPrices[counter] + " = " + BuyingPrices[counter]*BuyingQuantity[counter]);
			TotalAmount += BuyingPrices[counter] * BuyingQuantity[counter];
		}
		
		System.out.print("Subtotal:  $" + TotalAmount + "     ");
		System.out.printf("Tax @ 20%%: $ %7.2f", (0.2*TotalAmount));
		System.out.print("      Grand Total:  $" + (TotalAmount + (0.2*TotalAmount)));
	}
}
