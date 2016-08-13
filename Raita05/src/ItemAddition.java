import java.io.*;
import java.util.*;

public class ItemAddition {

    public static void main(String[] args) throws IOException
    {
        ItemAddition app = new ItemAddition();
        app.run();
    }
    
    Item[] items;
    
    String[] menu = {""};
    
    public void run() throws FileNotFoundException
    {
        items = Helper.getItems();
        //printItems();
        int choice = Helper.getChoice(menu);
        while(choice!=0)
        {
            if(choice==1)
            {
                addNewItem();
                //printItems();//for testing purpose.
            }
            choice = Helper.getChoice(menu);
               // items[index]=currentItem;
        }
        
        Helper.saveItem(items);
        Helper.println("Your Catalog : ");
        Helper.printItems(items);
        
    }
  
    
    private void addNewItem()
    {
       // Helper.println("Enter product description");
        
        int index = -1;
        //get an empty slot index
        for(int i=0;i<items.length;i++)
        {
            if(items[i]==null)
            {
                index=i;
                break;
            }
        }
        
        if(index!=-1)
        {
            //add in new contact
            //You may enhance the application by making sure
            //that the user enter an unique ID, we leave it out here
            String i = Helper.readString("Enter product description:");
            String n = Helper.readString("Enter product code:");
            String m = Helper.readString("Enter product unit price:");
            String s = Helper.readString("Enter product unit phrase:");
            
            Item newC = new Item(i,n,m,s);
            items[index] = newC;   
        }
        else
        {
            Helper.println("Memory full cannot add item");
        }
    }
    
    private void displayContactContainsName(String item)
    {
        Helper.println("Display Item name with "+ item);
        
        for(int i=0;i<items.length;i++)
        {
            if(items[i]!=null)
            {
                if(items[i].prodCode.contains(item))
                {
                    Helper.println("Item no:"+(i+1));
                    items[i].display();
                }
            }
        }
    }
    
}
