
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
		this.productName = productName;
		this.productCode = productCode;
		this.productPrice = productPrice;
		this.productQuantity = productQuantity;
	}
	
	public Catalog(String productLine)
	{
		this.productLine = productLine;
	}
	
	public void setProductLine(String productLine)
	{
		this.productLine = productLine;
	}
	
	//	Methods
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
	
	public String printProductLine()
	{
		return this.productLine;
	}
}
