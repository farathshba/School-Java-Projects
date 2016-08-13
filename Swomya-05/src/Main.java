import java.io.FileNotFoundException;
import java.util.*;
import java.util.Vector;
import java.io.*;
public class Main 
{
    public static void main(String [] args)throws FileNotFoundException
    {
         Main apps = new Main();
         apps.run();
    }
    
    Vector <Product> products = new Vector <Product> ();
    
    public void run() 
    {
        Vector <Product> a = getProduct();
        addNewProduct(a);
        Vector <Product> b =sorting(a);
        display(b);
        writeToFile(b);
    }
    public void addNewProduct(Vector <Product> a)
    {
        Helper.println("Add new products");
        boolean valid = true;
        while(valid)
        {
            String d = Helper.readString("Enter product description: ");
            if(d.equals("#"))
            {
                break;
            }
            String c = Helper.readString("Enter product code: ");
            String pr = Helper.readString("Enter product price: ");
            String ph = Helper.readString("Enter product phrase: ");

            Product newProduct = new Product(d,c,pr,ph);
            a.add(newProduct);
            valid=true;
        }
    }
    
    public Vector <Product> getProduct()
    {
        Vector<Product> products = new Vector <Product> ();
        try{
            FileReader fr = new FileReader("Catalog.txt");
            Scanner in = new Scanner(fr);
            
            while(in.hasNextLine())
            {
                String data = in.nextLine();
                
                System.out.println(data);
                String [] details = data.split(",");
                
                System.out.println("details[0] : " + details[0]);	//	TESTING PURPOSE
                String code = details[0];
                System.out.println("details[1] : " + details[1]);	//	TESTING PURPOSE
                String description = details[1];
                System.out.println("details[2] : " + details[2]);	//	TESTING PURPOSE
                String priceANDphrase = details[2].replaceFirst(" ", "");
                
                int getCount = 0;
                for(int i=0; priceANDphrase.charAt(i) != ' ';i++)
                {
                	getCount = i;
                }                
                String price = priceANDphrase.substring(0, getCount+1);
                System.out.println(price);		//	TESTING PURPOSE
                String phrase = priceANDphrase.replace(price, "").replace(".", "");
                System.out.println("Phrase after : " + phrase);		//	TESTING PURPOSE
                
/*              String code = details[0];
                String description = details[1];
                details = data.split("\\ ");
                String price = details[2];
                details = data.split("\\.");
                String prdetails = details[3];
*/              
                Product currentProduct = new Product(description,code,price,phrase);                
                products.add(currentProduct);

            }
        }
        catch(FileNotFoundException ex)
        {
            Helper.println("File not found!! ");
        }
        return products;
    }
    
    public Vector <Product> sorting(Vector <Product> a)
    {
        Vector <Product> b = new Vector <Product> ();
        for(int i=0;i<a.size();i++)
            b.addElement(a.elementAt(i));
        for(int i=0;i<b.size();i++) 
        {
            for(int j=i+1;j<b.size();j++) 
            {
                int result = b.get(i).getCode().compareTo(b.get(j).getCode());
                if(result>0)
                {
                    swap(b,i,j);
                }
            }
        }
        return b;
    }
    
    public void swap(Vector <Product> b, int i, int j)
    {
        Product temp = b.elementAt(i);
        b.setElementAt(b.elementAt(j), i);
        b.setElementAt(temp, j);
    }
    
    public void display(Vector <Product> b)
    {  
        for(int i=0;i<b.size();i++)
        {
            b.elementAt(i).display();
        }
    }
    
    public void writeToFile(Vector <Product> write) 
    {
       FileOutputStream fos;
        PrintStream ps;
        try{
            fos = new FileOutputStream("Catalog.txt");
            ps = new PrintStream(fos);
            for(int i=0;i<write.size();i++)
            {
                Product currentProduct = write.elementAt(i);
                String code = currentProduct.getCode();
                String description = currentProduct.getDescription();
                String price = currentProduct.getPrice();
                String details = currentProduct.getDetails();
                String data = code+", "+description+", "+price+" "+details+".";
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