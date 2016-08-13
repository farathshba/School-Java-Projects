import java.io.*;
import java.util.*;

import graphs.*;

class Q5
{
	static int N = 308; 
    static double [][] edges = new double[N][N];
    static String []  stationNames = new String[N]; 
    static double [] stationLat = new double[N];
	static double [] stationLon = new double[N];
	
	static String[] names;
	static double[] values1;

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
    	values1 = new double[N-zeroCount];
    	int count = 0;
    	
    	for(int i=0; i<stationNames.length; i++)
    	{
    		if(stationNames[i] != null)
    		{
    			names[count] = stationNames[i];
    			values1[count] = stationLon[i];
    			count++;
    		}
    	}
    	
    	sorter();
    	System.out.println("Station S is " + names[(names.length/2)-1] + ", " + values1[(values1.length/2)-1]);
		
    	int westSideChecker = 0;
    	int eastSideChecker = 0;
    	
    	for(int i=0; i<values1.length; i++)
    	{
    		if(values1[i] < values1[(values1.length/2)-1])
    		{
    			westSideChecker++;
    		}
    		else if(values1[i] > values1[(values1.length/2)-1])
    		{
    			eastSideChecker++;
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
    		b = values1[i];
    		z = names[i];
    		
    		while(a>0 && b<values1[a-1])
    		{
    			values1[a] = values1[a-1];
    			names[a] = names[a-1];
    			a--;
    		}
    		
    		values1[a] = b;
    		names[a] = z;
    	}
    }
}
