
public class Display 
{
	public Display()
    {
        
    }
    public static void display()
    {
        System.out.println("");
        System.out.println("Your catalog: ");
        for(int i=0;i<Catalogue.getSize();i++)
        {
        	System.out.println(Catalogue.getCode(i) + ", " + Catalogue.getDescription(i) + ", " + Catalogue.getPrice(i) + ", " + Catalogue.getPhrase(i) + ".");
        }
    }
}
