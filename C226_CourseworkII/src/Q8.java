import java.io.*;
import java.util.*;

import graphs.*;

class Q8
{
    static int N= 308; 
    static double [][] edges = new double[N][N];
    static String []  stationNames = new String[N]; 	

    //	Containers for ArrayList
    static ArrayList<Integer> pathCoordinatesContainer = new ArrayList<>();

   static ArrayList<String> convert(ArrayList<Integer> m)
   {
   		ArrayList<String> z= new ArrayList<String>();
   		for (Integer i:m) 
   			z.add(stationNames[i]);
   		
   		return z;
   }
    
   
   static HashSet<ArrayList<String>> convert(HashSet<ArrayList<Integer>> paths)
   {
         HashSet <ArrayList <String>> k= new HashSet <ArrayList <String>>();
	
         for (ArrayList <Integer> p:paths) 
        	 k.add(convert(p));
	
         return k;
   }
    
    //	Main Program
    public static void main(String[] args) throws Exception
    {
    	double tempLength = 0.0;
    	
        for(int i=0;i<N;i++)
        	for(int j=0;j<N;j++) 
        		edges[i][j]=0.0;
        
    	//	Stores the Names of Stations with respect to the IDs'
    	Scanner s = new Scanner(new FileReader("stations"));
        String z =s.nextLine();
        	
        while (s.hasNext())
        {
        	z =s.nextLine();
        	String[] results = z.split(",");	
        	stationNames[Integer.parseInt(results[0])]=results[3];	//	Assigning the indexes to the respective names
        }
       
        //	Stores the adjacent stations' names as a PAIR
        arrayGraph G = new arrayGraph(edges);
        
        
        
        s.close();
        s = new Scanner(new FileReader("edges"));
    	z = s.nextLine();
    	
    	while (s.hasNext())
    	{
    		z =s.nextLine();
    		String[] results = z.split(",");	
    		
	        edges[Integer.parseInt(results[0])][Integer.parseInt(results[1])]= G.weight(Integer.parseInt(results[0]) , Integer.parseInt(results[1]));
	        edges[Integer.parseInt(results[1])][Integer.parseInt(results[0])]= G.weight(Integer.parseInt(results[1]) , Integer.parseInt(results[0]));
    	}
    	
    	pathCoordinatesContainer = G.dijkstra(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
    	    	
    	for(int count=0; count < pathCoordinatesContainer.size(); count++)
    	{
    		if((count+1) < pathCoordinatesContainer.size())
    		{
    			tempLength = tempLength + edges[pathCoordinatesContainer.get(count)][pathCoordinatesContainer.get(count+1)];
    		}
    	}
    	
    	System.out.println("Shortest route between " + stationNames[Integer.parseInt(args[0])] + " & " + stationNames[Integer.parseInt(args[1])] + " is " + convert(pathCoordinatesContainer));
    	System.out.println("The distance covered is " + tempLength);
    } 
 }
