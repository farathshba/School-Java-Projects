import java.util.*;


public class Catalog 
{
	//	A list of ArrayList is used to keep track of the Product Information
	public static ArrayList<String> ProductDescription = new ArrayList();
	public static ArrayList<String> ProductCode = new ArrayList();
	public static ArrayList<String> ProductPrice = new ArrayList();
	public static ArrayList<String> ProductUnit = new ArrayList();
	
	//	This constructor pushes the product information back to the ArrayList
	public Catalog(String productDes, String productCode, String productPrice, String productUnit)
	{
		ProductDescription.add(productDes);
		ProductCode.add(productCode);
		ProductPrice.add(productPrice);
		ProductUnit.add(productUnit);
	}
	
	//	This method is used to retrieve the Total Size of the ArrayList
	public static int totalSizeofArrayList()
	{
		return ProductDescription.size();
	}
}
