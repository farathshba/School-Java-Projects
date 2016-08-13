import java.util.*;

public class Catalogue 
{
	public static ArrayList<String> description = new ArrayList<String>();
    private static ArrayList code = new ArrayList();
    private static ArrayList price = new ArrayList();
    private static ArrayList phrase = new ArrayList();
    
    public Catalogue(String d, String c, String pr, String ph)
    {
        description.add(d);
        code.add(c);
        price.add(pr);
        phrase.add(ph);
    }
    
    public static String getDescription(int count)
    {
        return description.get(count).toString();
    }
    
    public static int getSize()
    {
    	return description.size();
    }
    
    public static String getCode(int count)
    {
        return code.get(count).toString();
    }
    
    public static String getPrice(int count)
    {
        return price.get(count).toString();
    }
    
    public static String getPhrase(int count)
    {
        return phrase.get(count).toString();
    }
}
