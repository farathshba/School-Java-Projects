
public class Catalog 
{
	private int productDescQuan;
	private String productLine;
	
	public Catalog()
	{
		
	}
	
	public Catalog(String productLine)
	{
		this.productLine = productLine;
	}
	
	//	Methods
	public String printProductLine()
	{
		return this.productLine;
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
