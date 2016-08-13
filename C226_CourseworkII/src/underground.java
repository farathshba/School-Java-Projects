import java.io.*;
import java.util.*;
import graphs.*;

class underground
{
    static int N= 308; 
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
    
    //	Main Program
    public static void main(String[] args) throws Exception
    {
    	//	Prompt for the two stations
    	int number01 = new Scanner(System.in).nextInt();
    	int number02 = new Scanner(System.in).nextInt();
    	
        for(int i=0;i<N;i++)
        	for(int j=0;j<N;j++) 
        		edges[i][j]=0.0;
        
    	//	Stores the adjacent stations' names as a PAIR
        Scanner s = new Scanner(new FileReader("edges"));
    	String z = s.nextLine();
    	
    	while (s.hasNext())
    	{
    		z =s.nextLine();
    		String[] results = z.split(",");	
	        edges[Integer.parseInt(results[0])][Integer.parseInt(results[1])]=1.0;
	        edges[Integer.parseInt(results[1])][Integer.parseInt(results[0])]=1.0;
    	}
        	
    	//	Stores the Names of Stations with respect to the IDs'
    	s = new Scanner(new FileReader("stations"));
        z =s.nextLine();
        	
        while (s.hasNext())
        {
        	z =s.nextLine();
        	String[] results = z.split(",");	
        	stationNames[Integer.parseInt(results[0])]=results[3];	//	Assigning the indexes to the respective names
        }
       
        arrayGraph G = new arrayGraph(edges);
        System.out.println(convert(G.shortestPaths(number01, number02)));
     	
    } 
 }
