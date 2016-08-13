                                                                     
                                                                     
                                                                     
                                             
import java.io.*;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.Vector;
import java.util.Date;

public class Main {
    
    // main method
    public static void main(String [] args)throws FileNotFoundException
    {
        System.out.println("Question 7");
        // Creating an object of the type 'main'
         Main apps = new Main();
         apps.run();
    }
    
    // creates a infinite array of Product type.
    Vector <Product> products = new Vector <Product> ();
    Vector <OrderList> order = new Vector <OrderList> ();
    
    public void run() 
    {
         getProduct();
         sorting();
         display();
         order();
    }
    
    public Vector <Product> getProduct()
    {
        try{
            // Open a file with the given name (Catalog.txt)
            FileReader fr = new FileReader("Products.txt");
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
                // Creating a new object with the parameters(variables) passed to the constructor       
                Product currentProduct = new Product(description,code,price,phrase);   
                //Adding the object instances to the vector of Product type
                products.add(currentProduct);
            }
        }
        catch(FileNotFoundException ex)
        {
            // Error message if the file is not found
            Helper.println("File not found!! ");
        }
        return products;
    }
    
    public Vector <Product> sorting()
    {
        for(int i=0;i<products.size();i++) 
        {
            for(int j=i+1;j<products.size();j++) 
            {
                // Returns a value by comparing the two data
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
        // Gets the object from the vector 
        Product temp = b.elementAt(i);
        // Stores the objects at the respective locations
        b.setElementAt(b.elementAt(j), i);
        b.setElementAt(temp, j);
    }
    
    public void display()
    {  
        Helper.println("");
        Helper.println("Your catalog: ");
        for(int i=0;i<products.size();i++)
        {
            // calls the method display to display the details to the screen 
            products.elementAt(i).display();
        }
    }
    
    public void order()
    {
        boolean valid = true;
        Helper.println("Order Items");
        
        int index=-1;
        while(valid)
        {
            String id = Helper.readString("Enter code to order (0 to stop): ");
            index=getIndexByCode(id);
            if(id.equals("0"))
            {
                valid=false;
                orderDisplay();
                break;
            }
            else
            {
                if(index!=-1)
                {
                    int quan = Helper.readInt("Enter quantity: ");
                    String desc = products.get(index).getDescription();
                    double price = products.get(index).getPrice();
                    
                    OrderList newOrder = new OrderList(id,desc,quan,price);
                    order.add(newOrder);
                }
                else
                {
                    Helper.println("Invalid code!");
                }
            }
        }        
    }
    
    public void orderDisplay()
    {
        System.out.println("");
        DateFormat dateFormat = new SimpleDateFormat("dd  MMMM  yyyy");//format the output of the date
	Date date = new Date();//get current date time with Date()
        
        System.out.printf("YOUR ORDER " + "%58s%n", dateFormat.format(date));
        for(int i=0;i<order.size();i++)
        {
            order.elementAt(i).display();
        }
        System.out.println("");
        double subTotal = 0;
      
        for(int i=0;i<order.size();i++)
        {
            subTotal += (order.elementAt(i).getPrice())*(order.elementAt(i).getquantity());
        }
        double tax = 0.2*subTotal;
        double grandTotal = subTotal+tax;
        
        DecimalFormat formatter = new DecimalFormat("0.00");
        
        System.out.printf("%54s %10s %5s%n", "Subtotal: ", "$ ", subTotal);
        System.out.printf("%54s %10s %5s%n", "Tax @ 20%: ", "$ ", formatter.format(tax));
        System.out.printf("%54s %10s %5s%n", "Grand Total: ", "$ ", formatter.format(grandTotal));
        
        
    }
    
    public int getIndexByCode(String c)
    {        
        int index = -1;
        for(int i=0;i<products.size();i++)
        {
            // if the code entered matches with the code in the txt file, send the respective index
            if(products.elementAt(i).getCode().equalsIgnoreCase(c))
            {
                index = i;
            }
        }       
        return index;
    }
}

