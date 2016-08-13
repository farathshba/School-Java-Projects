import java.text.*;

public class OrderList {
    // instance variables 
    private String code;
    private String description;
    private int quantity;
    private double price;
    private double subTotal;
    
    // the constructor
    public OrderList(String code,String description, int quantity,double price )
    {
        this.code=code;
        this.description=description;
        this.quantity=quantity;
        this.price=price;
        // initializing the subtotal to be 0
        subTotal=0;
    }
    
    // Accessor methods for the variables
    public String getCode()
    {
        return code;
    }
    public String getDescription()
    {
        return description;
    }
    public int getquantity()
    {
        return quantity;
    }
    public double getPrice()
    {
        return price;
    }
    
    // Display of the orders by the customer
    public void display()
    {
    	DecimalFormat formatter = new DecimalFormat("0.00");
    	
        double total = (quantity*price);
        //System.out.println(String.format("%-30s %10s %15s %12s %6s %12f", description, quantity,"$", price,"$", total));\
        System.out.printf("%-30s %10s %10s %-5s %6s %-5s %n", description, quantity,"$", String.valueOf(String.valueOf(formatter.format(price))),"$", String.valueOf(String.valueOf(formatter.format(total))));
        //System.out.printf("%-30s %10s %10s %-3.2f %6s %-2.2f %n", description, quantity,"$", price,"$", total);
    }
}