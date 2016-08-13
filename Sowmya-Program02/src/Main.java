import java.util.*;

public class Main 
{
	public static void main(String[] main)
	{
		String desc1, code1,price1,phrase1;
        int count=0;
        boolean status = true;
        while((status)&&(count<100))
        {
            Catalogue cat = null;
            status = false;
            Scanner in = new Scanner(System.in);
            System.out.print("Enter product description: ");
            desc1 = in.nextLine();
            if(desc1.equals("#"))
            {
                Display.display();
                break;
            }
            System.out.print("Enter product code: ");
            code1 = in.nextLine();
            System.out.print("Enter product price: ");
            price1 = in.nextLine();
            System.out.print("Enter product phrase: ");
            phrase1 = in.nextLine();
            System.out.println();
            cat = new Catalogue(desc1,code1,price1,phrase1);
            status = true;
            count++;
        }
	}
}
