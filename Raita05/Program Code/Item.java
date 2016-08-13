public class Item {
    
    public String prodDesc;
    public String prodCode;
    public String prodUnitPrice;
    public String prodUnitPhrase;
    
    public Item(String prodDesc,String prodCode, String prodUnitPrice,String prodUnitPhrase)
    {
        this.prodDesc = prodDesc;
        this.prodCode = prodCode;
        this.prodUnitPrice = prodUnitPrice;
        this.prodUnitPhrase = prodUnitPhrase;
    }
    
    public void display()
    {
        Helper.println("prodDesc:"+prodDesc);
        Helper.println("prodCode:"+prodCode);
        Helper.println("prodUnitPrice:"+prodUnitPrice);
        Helper.println("prodUnitPhrase:"+prodUnitPhrase);
    }
}
