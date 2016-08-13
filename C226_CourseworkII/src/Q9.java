import graphs.arrayGraph;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;


public class Q9
{
	static int N = 308; 
    static   double [][] edges = new double[N][N];	//	N-D Array
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
   
	public static void main(String[] args) throws Exception
	{
		arrayGraph G = new arrayGraph(edges);
		String[] results = null;
		int numberOfLinesInEdges = 0;
		double tempLength = 0.0;
    	    	
        for(int i=0;i<N;i++)
        	for(int j=0;j<N;j++) 
        		edges[i][j]=0.0;
        
    	//	Stores the adjacent stations' names as a PAIR with the distance measured
        Scanner s = new Scanner(new FileReader("/src/edges"));
    	String z = s.nextLine();
    	
    	while (s.hasNext())
    	{
    		z =s.nextLine();
    		results = z.split(",");
    		
	        edges[Integer.parseInt(results[0])][Integer.parseInt(results[1])]= G.weight(Integer.parseInt(results[0]) , Integer.parseInt(results[1]));
	        edges[Integer.parseInt(results[1])][Integer.parseInt(results[0])]= G.weight(Integer.parseInt(results[1]) , Integer.parseInt(results[0]));
	        
	        numberOfLinesInEdges++;
    	}
		
		s.close();
		//	Stores the Names of Stations with respect to the IDs'
    	s = new Scanner(new FileReader("src/stations"));
        z =s.nextLine();
        	
        while (s.hasNext())
        {
        	z =s.nextLine();
        	results = z.split(",");	
        	stationNames[Integer.parseInt(results[0])]=results[3];	
        }
    	
    	double temp = 0.0;
    	int aCoordinate = 0, bCoordinate = 0;
    	
    	//	Get the IDs for the two farthest stations
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
    	
    	edges[aCoordinate][bCoordinate] = 0.0;
    	edges[bCoordinate][aCoordinate] = 0.0;
    	
    	pathCoordinatesContainer = G.dijkstra(aCoordinate, bCoordinate);
    	System.out.println("The shortest route is " + convert(pathCoordinatesContainer));
		
    	for(int count=0; count < pathCoordinatesContainer.size(); count++)
    	{
    		if((count+1) < pathCoordinatesContainer.size())
    		{
    			tempLength = tempLength + edges[pathCoordinatesContainer.get(count)][pathCoordinatesContainer.get(count+1)];
    		}
    	}
    	
    	System.out.println("The distance covered is " + tempLength);
	}
}
