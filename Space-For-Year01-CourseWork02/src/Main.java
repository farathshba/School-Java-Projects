import java.util.*;
import java.io.*;
import java.text.*;

public class Main 
{
	//	Method to return the product descriptions as a whole line
	public static Product getProductInfo(String productLine)
	{		
		return new Product(productLine);
	}
	
	//	Method used to sort the Product Objects based on the Product Codes (Bubble Sort method used)
	public static ArrayList<Product> Bubble_Sort(ArrayList<Product> products, int getCount)
	{
		for (int i = 0; i < getCount; i++) 
		{
			for (int j = i + 1; j < getCount; j++) 
			{
				int result = products.get(i).getProductCode().compareTo(products.get(j).getProductCode());
				if (result > 0) 
				{
					Product temp = products.get(i);
					products.set(i, products.get(j));
					products.set(j, temp);
				}
			}
		}
		return products;
	}

	
	//	Method to print the product line accordingly
	public static void printf(String f, String c, int q, double p, String dollarSign, double t)
	{
		DecimalFormat decfor = new DecimalFormat("0.00");
		System.out.printf(f,c,q,"$" + decfor.format(p), dollarSign, decfor.format(t));
	}
	
	//	Overrided method used to print the formatted "Your order and current date"
	public static void printf(String f, String o, String d)
	{
		System.out.printf(f, o, d);
	}
	
	//	Overrided method used to print the formatted "Amount been spent" output
	public static void printf(String f, String s, String dollarSign, double v)
	{
		DecimalFormat decfor = new DecimalFormat("0.00");
		System.out.printf(f, s, dollarSign, decfor.format(v));
	}
	
	public static void main(String[] args)
	{
		//	To keep track of the objects been stored in the ArrayList
		int getCount = 0;
		
		//	An Dynamic Array of type Products would store the products' objects inside this array
		ArrayList<Product> products = new ArrayList<Product>();
		
		//	An Dynamic Array of type Products would store the purchased products' objects inside this array
		ArrayList<Cart> cart = new ArrayList<Cart>();
		
		//	Read in from the File
		try
		{
			Scanner fileRdr = new Scanner(new File("Products"));
		
			while(fileRdr.hasNext())
			{						
				getCount = getCount + 1;
				String productLine = fileRdr.nextLine();;
			
				products.add(getProductInfo(productLine));
				
			}
			fileRdr.close();
		}
		catch(IOException ex)
		{
			System.out.println("IO Exception occured!");
		}
		
		//	Sorting method
		products = Bubble_Sort(products, getCount);
		
		//	Printing of Catalog Data
		System.out.println("Your Catalog : \n");
		for(int i=0; i<getCount; i++)
		{	
			System.out.println("\t" + products.get(i).printProductLine());
		}
		
		
		//	Prompt for products to be purchased and keeping track of them
		boolean loop = true;
		boolean errorCase;
		System.out.println("\nEnter the products to be purchased: ('#' to exit)\n");
		System.out.print("\tEnter a product code >> ");
		String productCode = new Scanner(System.in).next();
				
		while(!productCode.equalsIgnoreCase("#") && loop)
		{
			errorCase = false;
			for(int j=0; j < getCount; j++)
			{
				if(products.get(j).getProductCode().compareTo(productCode) == 0)
				{
					System.out.print("\tEnter Quantity >> ");
					int productQuantity = new Scanner(System.in).nextInt();
						
					cart.add(new Cart(products.get(j).getProductDesc(), productQuantity, products.get(j).printStrippedPrice()));
					loop = true;
					errorCase = true;
				}
			}
			if(errorCase == false)
			{
				System.out.println("Product Code not found! Please try again.");
			}
			System.out.print("\tEnter a product code >> ");
			productCode = new Scanner(System.in).next();
		}
		
		//	Printing out of the Shopping Cart from the Cart Class
		System.out.println("\nOrder Summary: \n");
		Calendar currentDate = Calendar.getInstance();
		SimpleDateFormat formatter= new SimpleDateFormat("dd MMMM yyyy");
		String dateNow = formatter.format(currentDate.getTime());
		printf("%-45s %32s %n%n","YOUR ORDER",dateNow);
		
		double totalAmount = 0.00;
		for(int k=0; k < cart.size(); k++)
		{
			totalAmount = (cart.get(k).getProductCartPrice()*cart.get(k).getProductCartQuantity()) + totalAmount;
			printf("%-30s %10s %15s %12s %6s%n", cart.get(k).getProductCartPhrase(),  cart.get(k).getProductCartQuantity(), cart.get(k).getProductCartPrice(),"$", (cart.get(k).getProductCartPrice()*cart.get(k).getProductCartQuantity()));
		}
		printf("%60s %10s %5s%n", "Subtotal: ", "$ ", totalAmount);
		printf("%60s %10s %5s%n", "Tax @ 20%: ", "$ ", (totalAmount*0.2));
		printf("%60s %10s %5s%n", "Grand Total: ", "$ ", (totalAmount + (totalAmount*0.2)));
	}
}
