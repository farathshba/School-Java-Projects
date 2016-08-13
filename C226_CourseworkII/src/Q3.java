import graphs.arrayGraph;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;


public class Q3
{
	static int N = 308; 
    static   double [][] edges = new double[N][N];	
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
		int numberOfLinesInEdges = 0;
    	    	
        for(int i=0;i<N;i++)
        	for(int j=0;j<N;j++) 
        		edges[i][j]=0.0;
        
        Scanner s = new Scanner(new FileReader("src/edges"));
    	String z = s.nextLine();
    	
    	while (s.hasNext())
    	{
    		z =s.nextLine();
    		results = z.split(",");
    		
	        edges[Integer.parseInt(results[0])][Integer.parseInt(results[1])]= G.weight(Integer.parseInt(results[0]) , Integer.parseInt(results[1]));
	        edges[Integer.parseInt(results[1])][Integer.parseInt(results[0])]= G.weight(Integer.parseInt(results[1]) , Integer.parseInt(results[0]));
	        
	        numberOfLinesInEdges++;
    	}
    	
    	double temp = 0.0;
    	int aCoordinate = 0, bCoordinate = 0;
    	
    	for(int innerCount=0; innerCount < N; innerCount++)
    	{
    		for(int outerCount=0; outerCount < N; outerCount++)
    		{
    			if(edges[innerCount][outerCount] != 0.0)
    			{
    				if(edges[innerCount][outerCount] > temp)
    				{
    					temp = edges[innerCount][outerCount];
    					
    					aCoordinate = innerCount;
    					bCoordinate = outerCount;
    				}
    			}
    		}
    	}    	
    	
    	String[] stationNames = G.farthestStations(aCoordinate, bCoordinate);
    	System.out.println("The two farthest stations are : " + stationNames[0] + " and " + stationNames[1] + " and the distance covered is " + temp);
	}
}
