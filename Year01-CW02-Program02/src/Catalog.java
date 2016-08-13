
public class Catalog 
{
	private String productName;
	private String productCode;
	private String productPrice;
	private String productQuantity;
	private int productDescQuan;
	private String productLine;
	
	public Catalog()
	{
		
	}
	
	public Catalog(String productName, String productCode, String productPrice, String productQuantity)
	{
		this.productLine = productCode + ", " + productName + ", " + productPrice + ", " + productQuantity + ".";
	}
	
	//	Methods
	public String printProductLine()
	{
		return this.productLine;
	}
	
	public String printProductName()
	{
		return productName;
	}
	
	public String printProductCode()
	{
		return productCode;
	}
	
	public String printProductPrice()
	{
		return productPrice;
	}
	
	public String printQuantity()
	{
		return productQuantity;
	}
	
	public void insertProductDescQuantity(int desc)
	{
		this.productDescQuan = desc;
	}
	
	public int printProductDescQuantity()
	{
		return productDescQuan;
	}
}
