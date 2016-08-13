
public class main 
{
	public static void main(String[] args)
	{
		String[] productName = {"Condensed Powdered Water", "Distilled Moonbeams", "Anti-Gravity Pills"};
		String[] productCode = {"P3487", "K3876", "Z9983"};
		double[] productPrice = {2.50, 3.00, 12.75};
		String[] productQuantity = {"per packet", "a dozen", "for 60"};
		
		//	Pass the locally initialized product information to the class
		product Produce = new product(productName, productCode, productPrice, productQuantity);
		
		Produce.PrintProductLine();
		Produce.ReadOrder();
	}
}
