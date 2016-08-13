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
        String data = in.nextLine();
        return data;
    }
    
}