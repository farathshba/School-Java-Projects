
public class Cart 
{
	private int _buyingQuantity;
	private String _buyingProductDesc;
	private double _buyingProductPrice;
	
	public Cart()
	{
		
	}
	
	public Cart(String productDesc, int quan, double price)
	{
		this._buyingProductDesc = productDesc;
		this._buyingQuantity = quan;
		this._buyingProductPrice = price;
	}
	
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
