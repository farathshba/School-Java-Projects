package graphs;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;
import java.util.Map;

public class arrayGraph extends abstractGraph
{
	
        double [][] adj; 

        public arrayGraph (double [][] ad)
        {
           adj=ad;
        }
	
        

        public HashSet <Integer> neighbours(Integer v)
        {
        	HashSet k= new HashSet <Integer>();
        	for (int j=0;j<adj.length;j++) 
        		if (adj[v][j] > 0) 
        			k.add(j);
        	
            return k;
        }	
        
        public double weight(Integer v, Integer w)
        {
        	String[] results;
        	double[][] finalStationsCoordinates = null;
        	double d = 0.0;
        	int index4Array = 0;
        	
        	try
        	{
        		Scanner s = new Scanner(new FileReader("../src/stations"));
        		String z = s.nextLine();
        		double lat1 = 0.0, lat2 = 0.0, lon1 = 0.0, lon2 = 0.0;
        		
        		while(s.hasNextLine())
        		{
        			index4Array++;
        			z = s.nextLine();
        			//System.out.println(z);
        		}
        		
        		finalStationsCoordinates = new double[index4Array+1][2];
        		
        		s.close();
        		s = new Scanner(new FileReader("../src/stations"));
        		z = s.nextLine();
        		
        		//	Assignment of the Lant and Long coordinates onto Array
        		for(int a = 1; a <= (index4Array+1) && s.hasNextLine(); a++)
        		{
        			z = s.nextLine();
        			if(!z.isEmpty())
        			{
        				results = z.split(",");
        				
        				finalStationsCoordinates[Integer.parseInt(results[0]) - 1][0] = Double.parseDouble(results[1]);
        				finalStationsCoordinates[Integer.parseInt(results[0]) - 1][1] = Double.parseDouble(results[2]);
        			}
        		}
        	

        	
        		//	Get the info of the 'v' and 'w' stations
        		lat1 = finalStationsCoordinates[v-1][0];
        		lat2 = finalStationsCoordinates[w-1][0];
        		
        		lon1 = finalStationsCoordinates[v-1][1];
        		lon2 = finalStationsCoordinates[w-1][1];
        		
	        	int R = 6371; 	// km (change this constant to get miles)
	      	   	double dLat = (lat2 - lat1) * Math.PI / 180;
	      	   	double dLon = (lon2 - lon1) * Math.PI / 180;
	      	   	double a = Math.sin(dLat/2) * Math.sin(dLat/2) + Math.cos(lat1 * Math.PI / 180 ) * Math.cos(lat2 * Math.PI / 180 ) * Math.sin(dLon/2) * Math.sin(dLon/2);
	      	   	double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
	      	   	d = R * c;
        	}
        	catch(FileNotFoundException ex)
        	{
        		System.out.println("Error reading file");
        	}
        	
			return d;
        }
        
        public String[] farthestStations(int aCoor, int bCoor) 
        {
        	String[] stationNames = new String[308]; 	
        	String[] chosenStations = new String[2];
        	
        	try
        	{
        		//	Stores the Names of Stations with respect to the IDs'
        		Scanner s = new Scanner(new FileReader("../src/stations"));
        		String z = s.nextLine();
        		
        		while (s.hasNext())
                {
                	z =s.nextLine();
                	String[] results = z.split(",");	
                	stationNames[Integer.parseInt(results[0])]=results[3];	//	Assigning the indexes to the respective names
                }
        	}
        	catch(Exception ex)
        	{
        		System.err.println("Error reading the stations file.");
        	}
        	
        	chosenStations[0] = stationNames[aCoor];
        	chosenStations[1] = stationNames[bCoor];
        	
        	return chosenStations;
        }
        
        
        public String[] closestStations(int aCoor, int bCoor) 
        {
        	String[] stationNames = new String[308]; 	
        	String[] chosenStations = new String[2];
        	
        	try
        	{
        		//	Stores the Names of Stations with respect to the IDs'
        		Scanner s = new Scanner(new FileReader("../src/stations"));
        		String z = s.nextLine();
        		
        		while (s.hasNext())
                {
                	z =s.nextLine();
                	String[] results = z.split(",");	
                	stationNames[Integer.parseInt(results[0])]=results[3];	//	Assigning the indexes to the respective names
                }
        	}
        	catch(Exception ex)
        	{
        		System.err.println("Error reading the stations file.");
        	}
        	
        	chosenStations[0] = stationNames[aCoor];
        	chosenStations[1] = stationNames[bCoor];
        	
        	return chosenStations;
        }        
        
        //	Get the stations' IDs
        public Set <Integer> vertices() 
    	{
    		//	read in the stations file
        	Set<Integer> stations = new HashSet();
        	try
        	{
        		Scanner s = new Scanner(new FileReader("../src/stations"));
	            String z =s.nextLine();
	            	
	            while (s.hasNext())
	            {
	            	z =s.nextLine();
	            	String[] results = z.split(",");	
					stations.add(Integer.parseInt(results[0]));				
	            }
        	}
        	catch(Exception ex)
        	{
        		System.err.println("Unable to retrieve stations.");
        	}
            return stations;
    	}
}
