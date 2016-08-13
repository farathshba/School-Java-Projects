public class Product {
    private String description;
    private String code;
    private double price;
    private String phrase;
    
    public Product(String description, String code, double price, String phrase)
    {
        this.description=description;
        this.code=code;
        this.price=price;
        this.phrase=phrase;
    }

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
    
    public void display()
    {
        System.out.println(code+", "+description+", $"+price+" "+phrase+".");
    }
    
}