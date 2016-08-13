import java.io.*;
import java.util.*;

public class Helper {
    
    public static void println(String s)
    {
        System.out.println(s);
    }
    
    public static void print(String s)
    {
        System.out.print(s);
    }
    
    public static String readString(String s)
    {
        print(s);
       
        Scanner sc = new Scanner(System.in);
        String data = sc.nextLine();
        return data;
        
        //return new Scanner(System.in).nextLine(); 
    }
    //factory method
    public static Item[] getItems()
    {
        Item[] items = new Item[50];
       
        try{
            
            FileReader fr = new FileReader("Catalog");
            Scanner in = new Scanner(fr);
            int index=0;
            while(in.hasNextLine())
            {
		String data = in.nextLine();
                //read in string 1|a|1|1
                String[] result = data.split(", "); //{"1","a","1","1"}
     
                String prodDesc = result[0];
                String prodCode = result[1];
                String prodUnitPrice = result[2];
                String prodUnitPhrase = result[3];
                
                Item currentItem = new Item(prodDesc,prodCode,prodUnitPrice,prodUnitPhrase);
         
             
                items[index]=currentItem;
                index++;
            }
        }
        catch(FileNotFoundException ex)
        {
            Helper.println("File not found");
            
        }
        
        return items;
    }
    
    
    
    public static int getChoice(String menu[])
    {
        int choice=-1;
        printMenu(menu);
        
        print("Enter Choice:");
        Scanner s = new Scanner(System.in);
        choice = s.nextInt();
        
        while(choice<0 || choice>menu.length)
        {
            println("Invalid Choice");
            printMenu(menu);
            print("Enter Choice:");
            choice = s.nextInt();
        }
        
        return choice;
    }
    
    private static void printMenu(String[] menu)
    {
        for(int i=0;i<menu.length;i++)
        {
            println((i+1) + ":" + menu[i]);
        }
        
        println("0:Exit");
    }
    
    
    public static void saveItem(Item[] items)
    {
        FileOutputStream fos;
        PrintStream ps;
    
        try{
            fos = new FileOutputStream("Catalog");
            ps = new PrintStream(fos);
            
            for(int i=0;i<items.length;i++)
            {
                if(items[i]!=null)
                {
                    String prodDesc = items[i].prodDesc;
                    String prodCode = items[i].prodCode;
                    String prodUnitPrice = items[i].prodUnitPrice;
                    String prodUnitPhrase = items[i].prodUnitPhrase;
                
                    String data = prodDesc+", "+prodCode+", "+prodUnitPrice+", "+prodUnitPhrase;
                    ps.println(data);
                    
                }
            }
        
	
            ps.close();	
        
        }
        catch(FileNotFoundException ex)
        {
            Helper.println("File not found");
            
        }
    }
    
    public static void printItems(Item[] items)
    {
    	for(int i=0;i<items.length;i++)
        {
            if(items[i]!=null)
            {
                String prodDesc = items[i].prodDesc;
                String prodCode = items[i].prodCode;
                String prodUnitPrice = items[i].prodUnitPrice;
                String prodUnitPhrase = items[i].prodUnitPhrase;
            
                String data = prodDesc+", "+prodCode+", "+prodUnitPrice+", "+prodUnitPhrase;
                System.out.println(data);
                
            }
        }
    }
}