public class Cart 
{
	//	Variables
	private int _buyingQuantity;
	private String _buyingProductDesc;
	private double _buyingProductPrice;
	
	//	Constructors
	public Cart()
	{
		
	}
	
	public Cart(String productDesc, int quan, double price)
	{
		this._buyingProductDesc = productDesc;
		this._buyingQuantity = quan;
		this._buyingProductPrice = price;
	}
	
	//	Accessor methods
	public String getProductCartPhrase()
	{
		return this._buyingProductDesc;
	}
	
	public double getProductCartPrice()
	{
		return this._buyingProductPrice;
	}
	
	public int getProductCartQuantity()
	{
		return this._buyingQuantity;
	}
	
	public void setQuantity(int quan)
	{
		this._buyingQuantity = quan;
	}
	
	public void setQuantity(String productDesc)
	{
		this._buyingProductDesc = productDesc;
	}
}
