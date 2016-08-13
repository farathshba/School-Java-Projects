
public class Product 
{
	//	Variables
	private String _productCode;
	private String _productDesc;
	private String _productPrice;
	private String _productPhrase;
	private String _productLine;
	
	//	Passing Variables / Internal Operators
	private String[] _product;
	
	//	Constructors
	public Product()
	{
		
	}
	
	//	Accessor Methods
	public Product(String productLine)
	{
		this._productLine = productLine;
		Stripper(productLine);
	}
	
	public String getProductDesc()
	{
		return this._productDesc;
	}
	
	//	Method to split the product line into four different product descriptions
	public void Stripper(String productLine)
	{
		this._product = productLine.split(", ");
		
		this._productCode = this._product[0];
		this._productDesc = this._product[1];
		this._productPrice = this._product[2];
		this._productPhrase = this._product[3];
	}
	
	//	Method to print the price without the "$" sign in double data type
	public double printStrippedPrice()
	{
		return Double.parseDouble(this._productPrice.replace("$", ""));
	}
	
	public String printStrippedProductLine()
	{
		return this._productCode;
	}
	
	public String getProductCode()
	{
		return this._productCode;
	}	
	
	public void setProductCode(String productCode)
	{
		this._productCode = productCode;
	}
	
	public String printProductLine()
	{
		return this._productLine;
	}
}
