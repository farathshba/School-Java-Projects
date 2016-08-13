import java.io.*;
import java.util.*;

import graphs.*;

class Q7
{
    static int N= 308; 
    static double [][] edges = new double[N][N];
    static String []  stationNames = new String[N]; 	

    //	Containers for ArrayList
    static HashSet <ArrayList <Integer>> tempHashSetContainer;
    static ArrayList<ArrayList<Integer>> pathCoordinatesContainer = new ArrayList<ArrayList<Integer>>();
    static ArrayList<Double> lengthOfStations = new ArrayList<Double>();

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
	        
	        edges[Integer.parseInt(args[2])][Integer.parseInt(args[3])] = 0.0;
	        edges[Integer.parseInt(args[3])][Integer.parseInt(args[2])] = 0.0;
    	}
    	
         tempHashSetContainer = G.shortestPaths(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
         
         Iterator<ArrayList<Integer>> itr = tempHashSetContainer.iterator();
         for(int count=0; count < tempHashSetContainer.size() && itr.hasNext(); count++)
         {
         	pathCoordinatesContainer.add(count, itr.next());
         }
         
    	
    	for(int innerCount = 0; innerCount < pathCoordinatesContainer.size(); innerCount++)
    	{
    		tempLength = 0.0;
    		for(int outerCount = 1; outerCount < pathCoordinatesContainer.get(innerCount).size(); outerCount++)
    		{
    			tempLength = tempLength + edges[pathCoordinatesContainer.get(innerCount).get(outerCount-1)][pathCoordinatesContainer.get(innerCount).get(outerCount)];
    		}
    		lengthOfStations.add(innerCount, tempLength);
    	}
    	
        System.out.println(convert(G.shortestPaths(Integer.parseInt(args[0]), Integer.parseInt(args[1]))));
        
        for(int count=0; count < lengthOfStations.size(); count++)
        {
        	System.out.println(lengthOfStations.get(count));
        }
     	
    } 
 }
