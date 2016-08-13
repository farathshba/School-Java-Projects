import java.io.*;
import java.util.*;

import graphs.*;

class Q6
{
	static int N = 308; 
    static double [][] edges = new double[N][N];
    static String []  stationNames = new String[N]; 
    static double [] stationLat = new double[N];
	static double [] stationLon = new double[N];
	
	static String[] names;
	static double[] values;

   static ArrayList<String> convert (ArrayList<Integer> m)
   {
   		ArrayList<String> z = new ArrayList<String>();
   		for (Integer i:m) 
		{
   			z.add(stationNames[i]);
		}
   		return z;
   }
    
   
   static HashSet<ArrayList<String>> convert (HashSet<ArrayList<Integer>> paths)
   {
         HashSet <ArrayList <String>> k = new HashSet <ArrayList <String>>();
         
         for (ArrayList <Integer> p:paths)
    	 {
    	 	k.add(convert(p));
    	 }
         
         return k;
   }
    
    
    public static void main(String[] args) throws Exception
    {
    	String [] results;
    	int zeroCount = 0;
    	
    	Scanner s = new Scanner(new FileReader("stations"));
    	String z = s.nextLine();
    	
    	while(s.hasNext())
    	{
    		z = s.nextLine();
    		results = z.split(",");	
	        stationNames[Integer.parseInt(results[0])] = results[3];
	        stationLat[Integer.parseInt(results[0])] = Double.parseDouble(results[1]);
	        stationLon[Integer.parseInt(results[0])] = Double.parseDouble(results[2]);
    	}
    	
    	for(int i=0; i<stationNames.length; i++)
    	{
    		if(stationNames[i] == null)
    		{
    			zeroCount++;
    		}
    	}
    	
    	names = new String[N-zeroCount];
    	values = new double[N-zeroCount];
    	int count = 0;
    	
    	for(int i=0; i<stationNames.length; i++)
    	{
    		if(stationNames[i] != null)
    		{
    			names[count] = stationNames[i];
    			values[count] = stationLat[i];
    			count++;
    		}
    	}
    	
    	sorter();
    	
    	System.out.println("Station T is " + names[(names.length/2)] + ", " + values[(values.length/2)]);
    	
    	int checkNorth = 0;
    	int checkSouth = 0;
    	
    	for(int i=0; i<values.length; i++)
    	{
    		if(values[i] < values[(values.length/2)])
    		{
    			checkSouth++;
    		}
    		else if(values[i] > values[(values.length/2)])
    		{
    			checkNorth++;
    		}
    	}
    }
    
    public static void sorter()
    {	
    	int a;
    	double b;
    	String z;
    	
    	for(int i=1; i<names.length; i++)
    	{
    		a = i;
    		b = values[i];
    		z = names[i];
    		
    		while(a>0 && b<values[a-1])
    		{
    			values[a] = values[a-1];
    			names[a] = names[a-1];
    			a--;
    		}
    		
    		values[a] = b;
    		names[a] = z;
    	}
    }
}
