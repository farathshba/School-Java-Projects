import graphs.arrayGraph;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;


public class Q10
{
	static int N = 308; 
    static   double [][] edges = new double[N][N];	//	N-D Array
    static String []  stationNames = new String[N]; 	

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
   
	public static void main(String[] args) throws Exception
	{
		arrayGraph G = new arrayGraph(edges);
		String[] results = null;
    	    	
        for(int i=0;i<N;i++)
        	for(int j=0;j<N;j++) 
        		edges[i][j]=0.0;
        
    	//	Stores the adjacent stations' names as a PAIR with the distance measured
        Scanner s = new Scanner(new FileReader("edges"));
    	String z = s.nextLine();
    	
    	while (s.hasNext())
    	{
    		z =s.nextLine();
    		results = z.split(",");
    		
	        edges[Integer.parseInt(results[0])][Integer.parseInt(results[1])]= G.weight(Integer.parseInt(results[0]) , Integer.parseInt(results[1]));
	        edges[Integer.parseInt(results[1])][Integer.parseInt(results[0])]= G.weight(Integer.parseInt(results[1]) , Integer.parseInt(results[0]));
    	}
    	
    	double temp = 0.0;
    	for(int x = 0; x < edges.length; x++)
    	{
    		for(int y=0; y < edges.length; y++)
    		{
    			temp = temp + edges[x][y];
    		}
    	}
    	
    	System.out.println(temp / 2);
	}
}
