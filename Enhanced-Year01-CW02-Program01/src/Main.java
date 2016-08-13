import java.util.*;

public class Main 
{	
	//	--------	Main Call method		---------
	public static void main(String[] args)
	{
		//	Declaration of Variables
		
		//	Using the class Method to retrieve
		Retriever rtr = new Retriever(100);
		rtr.getProductInfo();
		
		System.out.println("Your catalog:");
		rtr.printProductInfo();
	}
}
