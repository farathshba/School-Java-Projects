import java.util.Scanner;


public class B07 
{
	//	This method keeps track of the Quantity of the individual Products been sold and returns back into the array
	public static int getQuantity()
	{
		
		Scanner input = new Scanner(System.in);
		int getQuantityInput;
		
		for(;;)
		{
			System.out.print("Enter Quantity (1 to 100): ");
			getQuantityInput = input.nextInt();
		
			//	if Quantity is more than 1 and less than or equals to 100, then the program accepts the Quantity Value
		
			if (getQuantityInput >= 1 && getQuantityInput <= 100)
			{
				return getQuantityInput;
			}
			else
			{
				System.out.println("The Quantity is out of bounds, please try again... ");
				//getQuantity();
			}
		}
	}
	
	public static void ShoppingCart2()
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
		for (int counter = 0; counter < 3; counter++)
		{
			System.out.print("Enter Order Number (0 to stop) : ");
			
			//	The User Input which is the PRODUCT CODE in stored in a String Variable
			UserInputToExitLoop = input.next();
		
			//	This Try Function would help catch any errors for the program to run effectively even if the User enters 
			//	characters less than '5' characters wide
			try
			{
				//	The String's First Character is verified whether it's a Alphabet
				if(Character.isLetter(UserInputToExitLoop.charAt(0)))
				{
					//	The String's Second, Third, and Fourth characters are verified whether it's a numeral
					if(Character.isDigit(UserInputToExitLoop.charAt(1)) || Character.isDigit(UserInputToExitLoop.charAt(2)) || Character.isDigit(UserInputToExitLoop.charAt(3)) || Character.isDigit(UserInputToExitLoop.charAt(4)))
					{
						//	The String variable is compared against a set of conditions which are the SET of PRODUCT CODES
						//	Upon matching the PRODUCT CODE, a set of instructions would be executed. They are as follows,
						//	The Item's Product COdes, Product Prices, Product's Names and their Quantity are stored 
						//	in four different arrays with respect to their address values
						if(UserInputToExitLoop.equals("P3487"))
						{
							BuyingItems[counter] = "P3487"; BuyingPrices[counter] = 2.5; BuyingItemsName[counter] = "Condensed Powdered water"; BuyingQuantity[counter] = getQuantity();
						}
						else if(UserInputToExitLoop.equals("K3876"))
						{
							BuyingItems[counter] = "K3876"; BuyingPrices[counter] = 3; BuyingItemsName[counter] = "Distilled Moonbeams"; BuyingQuantity[counter] = getQuantity();
						}
						else if(UserInputToExitLoop.equals("Z9983"))
						{
							BuyingItems[counter] = "Z9983"; BuyingPrices[counter] = 12.75; BuyingItemsName[counter] = "Anti-Gravity Pills"; BuyingQuantity[counter] = getQuantity();
						}
						else
						{
							System.out.println("I don't recognize that Product Code"); counter--;
						}
					}
					else
					{
						System.out.println("Sorry, I don't understand! Use Product Codes only."); counter--;
					}
				}
				
				//	Else if the String's First Character is a numeral, it should be either a '0' or
				//	any other number, so it's compared for any other numbers and zero
				else if(Character.isDigit(UserInputToExitLoop.charAt(0)))
				{
					if(UserInputToExitLoop.charAt(0) == '0')
					{
						HowManyItemsBought = counter; counter = 4;
					}
					else
					{
						System.out.println("Sorry, I don't understand! Use Product Codes only."); counter--;
					}
				}
			}
			catch(Exception ex)
			{
				System.out.println("Error Occured! Please try again with your input"); counter--;
			}
			
		
		}
		
		//	This segment prints out the Order Summary of the Products been purchased
		System.out.println("Your order : ");
		
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
