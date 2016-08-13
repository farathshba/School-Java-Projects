//	This class provides the function of a database
//	by facilitating the storing of the Product Data in itself

public class Catalog 
{
	//	-----------		Variables		-----------	//
	private String productName;
	private String productCode;
	private String productPrice;
	private String productQuantity;
	
	//	-----------		Constructors		-----------	//
	//	Constructor to get the product information
	public Catalog(String productName, String productCode, String productPrice, String productQuantity)
	{
		this.productName = productName;
		this.productCode = productCode;
		this.productPrice = productPrice;
		this.productQuantity = productQuantity;
	}
	
	//	-----------		Methods		-----------	//
	//	Method to return the Product Name
	public String printProductName()
	{
		return productName;
	}

	//	Method to return the Product Code
	public String printProductCode()
	{
		return productCode;
	}
	
	//	Method to return the Product Price
	public String printProductPrice()
	{
		return productPrice;
	}
	
	//	Method to return the Product Quantity
	public String printQuantity()
	{
		return productQuantity;
	}
}
