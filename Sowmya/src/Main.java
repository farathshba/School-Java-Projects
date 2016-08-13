import java.io.*;
import java.util.*;
import java.util.*;
import java.io.*;

public class Main 
{
    public static void main(String [] args)throws FileNotFoundException
    {
         Main apps = new Main();
         apps.run();
    }
    
    // creates a infinite array of Product type.
    Vector <Product> products = new Vector <Product> ();
    
    public void run() 
    {
        getProduct();
        addNewProduct();
        sorting();
        display();
        writeToFile();   
    }
    
    public Vector <Product> getProduct()
    {
        try{
            // Open a file with the given name (Catalog.txt)
            FileReader fr = new FileReader("Catalog.txt");
            // To read the content in the file 
            Scanner in = new Scanner(fr);
            // get the data from the Catalog file 
            while(in.hasNextLine())
            {
                // Retreiving all the data from the file
                String data = in.nextLine();
                
                // Specifying the delimeter
                String [] details = data.split("\\|");
                // Extracting the specific detail from the data and storing into the variables
                String code = details[0];
                String description = details[1];
                // Converting the string to double 
                double price = Double.parseDouble(details[2]);
                String phrase = details[3];
                // Creating a new object called currentProduct       
                Product currentProduct = new Product(description,code,price,phrase);   
                // Adding the object to the products class
                products.add(currentProduct);
            }
        }
        catch(FileNotFoundException ex)
        {
            // Error message
            Helper.println("File not found!! ");
        }
        return products;
    }
    
    public void addNewProduct()
    {
        Helper.println("Add new products");
        Helper.println("");
        boolean valid = true;
        while(valid)
        {
            String d = Helper.readString("Enter product description: ");
            if(d.equals("#"))
            {
                break;
            }
            String c = Helper.readString("Enter product code: ");
            double pr = Helper.readDouble("Enter product price: $");
            String ph = Helper.readString("Enter product phrase: ");
            Helper.println("");    
            Product newProduct = new Product(d,c,pr,ph);
            products.add(newProduct);
            valid=true;
        }
        deleteCode();
    }
    
    
    
    public void deleteCode()
    {
        Helper.println("");
        Helper.println("Deleting codes");
        Helper.println("");
        int index = -1;
        boolean valid = true;
        while(valid)
        {
            String code = Helper.readString("Enter code to delete:");
            if(code.equals("#"))
            {
            	valid = false;
                break;
            }
            else
            {
            	index = getIndexByCode(code);
            	
            	if(index!=-1)
            	{
            		products.removeElementAt(index);
            	}
            	else
            	{
            		Helper.println("Code not found.");
            	}
                System.out.println("Boundary #01 index : " + index);
            }
        }
    }
    
    public int getIndexByCode(String c)
    {
        
        int index = -1;
        for(int i=0;i<products.size();i++)
        {
           if(products.elementAt(i).getCode().equalsIgnoreCase(c))
            {
                Helper.println("Code "+c+" deleted");
                index = i;
            }
        }       
        return index;
    }
    
    public Vector <Product> sorting()
    {
        for(int i=0;i<products.size();i++) 
        {
            for(int j=i+1;j<products.size();j++) 
            {
                int result = products.get(i).getCode().compareTo(products.get(j).getCode());
                if(result>0)
                {
                    swap(products,i,j);
                }
            }
        }
        return products;
    }
    
    public void swap(Vector <Product> b, int i, int j)
    {
        Product temp = b.elementAt(i);
        b.setElementAt(b.elementAt(j), i);
        b.setElementAt(temp, j);
    }
    
    public void display()
    {  
        for(int i=0;i<products.size();i++)
        {
            products.elementAt(i).display();
        }
    }
    public void writeToFile( ) 
    {
       FileOutputStream fos;
        PrintStream ps;
        try{
            fos = new FileOutputStream("Catalog.txt");
            ps = new PrintStream(fos);
            for(int i=0;i<products.size();i++)
            {
                Product currentProduct = products.elementAt(i);
                String code = currentProduct.getCode();
                String description = currentProduct.getDescription();
                double price = currentProduct.getPrice();
                String phrase = currentProduct.getPhrase();
                String data = code+"|"+description+"|"+price+"|"+phrase+"|";
                ps.println(data);
            }
            ps.close();
        }
        catch(FileNotFoundException ex)
        {
            Helper.println("File not found");
        }
    }
}
