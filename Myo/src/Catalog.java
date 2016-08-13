public class Catalog {

// Declare variables
public String product_code;
public String product_desc;

// constructor method
public Catalog (String product_code, String product_desc)
{
this.product_code = product_code;
this.product_desc = product_code + product_desc;

}

// this method return the value of product_code


// this method return the value of product_desc
public String displayPD()
{
return this.product_desc;
}

public String returnPC()
{
return this.product_code;
}
}

