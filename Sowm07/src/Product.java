                                                                     
                                                                     
                                                                     
                                             
public class Product {
    // Instance variables
    private String description;
    private String code;
    private double price;
    private String phrase;
    
    // Constructor for the product class
    public Product(String description, String code, double price, String phrase)
    {
        this.description=description;
        this.code=code;
        this.price=price;
        this.phrase=phrase;
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
    
    public double getPrice()
    {
        return price;
    }
    
    public String getPhrase()
    {
        return phrase;
    }
    // Display method to display the details on the screen
    public void display()
    {
        System.out.println(code+", "+description+", $"+price+" "+phrase+".");
    }
    
}

