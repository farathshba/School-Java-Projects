public class Product {
    private String description;
    private String code;
    private String price;
    private String details;
    
    public Product(String description, String code, String price, String details)
    {
        this.description=description;
        this.code=code;
        this.price=price;
        this.details=details;
    }

    public String getCode()
    {
        return code;
    }
    
    public String getDescription()
    {
        return description;
    }
    
    public String getPrice()
    {
        return price;
    }
    
    public String getDetails()
    {
        return details;
    }
    
    public void display()
    {
        System.out.println(code+","+description+","+price+" "+details);
    }
    
}