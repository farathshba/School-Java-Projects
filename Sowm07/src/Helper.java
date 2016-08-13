                                                                     
                                                                     
                                                                     
                                             
import java.util.Scanner;
public class Helper {
    
    public static void print(String s)
    {
        System.out.print(s);
    }
    
    public static void println(String s)
    {
        System.out.println(s);
    }
    
    public static String readString (String s)
    {
        print(s);
        Scanner in = new Scanner(System.in);
        // read in the content 
        String data = in.nextLine();
        return data;
    }
    // Stays in a loop until the user enters an integer
    public static double readDouble(String s)
    {
        print(s);
        boolean valid = true;
        double data = 0;
        while(valid)
        {
            valid = false;
            try
            {
                Scanner in = new Scanner(System.in);
                // read in the content 
                String d = in.nextLine();
                // Converts the string to double
                data = Double.parseDouble(d);
            }
            catch(NumberFormatException ex)
            {
                System.out.print("Enter product price: $");
                valid = true;
            }
        }
        return data;
    }
    // Stays in a loop until the user enters an integer
    public static int readInt(String s)
    {
        print(s);
        boolean valid = true;
        int data = 0;
        while(valid)
        {
            valid = false;
            try
            {
                Scanner in = new Scanner(System.in);
                // read in the content 
                String d = in.nextLine();
                // Converts the string to double
                data = Integer.parseInt(d);
            }
            catch(NumberFormatException ex)
            {
                System.out.print("Enter product price: $");
                valid = true;
            }
        }
        return data;
    }
}

