package graphs;
import java.io.FileReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.TreeMap;
import java.util.PriorityQueue;
import java.util.*;


public abstract class abstractGraph
{
	public abstract HashSet <Integer> neighbours(Integer v); 
	public abstract double weight(Integer v, Integer w); 
	public abstract Set <Integer> vertices(); 

	private	boolean done; 
	//set to true if we find what we looking for or nothing left to find

	private	HashSet <Integer> alreadyVisited; 
	// the vertices visited altogether

	private     HashSet <Integer> newAlreadyVisited; 
	// the vertices visited at this level

	private     HashSet <ArrayList <Integer>> shortestPaths;   
	private     double infinity=1000000.0;    
 
  	ArrayList <Integer> addToEnd (Integer i, ArrayList <Integer> path) 
  	// returns a new path with i at the end of path
    {
  		ArrayList <Integer> k;
  		k=(ArrayList<Integer>)path.clone();
  		k.add(i);
  		return k;
    } 
   
  	HashSet <ArrayList <Integer>> nexts(ArrayList <Integer> path, Integer end)                 
  	/* given a path, finds all the paths that are one longer 
   		can be made by adding a vertex 
  		that hasn't already been visited at earlier levels 
  	*/ 
   { 											 
  		Integer last=path.get(path.size()-1);
  		HashSet <ArrayList <Integer>> k= new HashSet <ArrayList <Integer>>();
  		Set <Integer> neighs=neighbours(last);
  		if (!neighs.contains(end))
  		{ 
              for (Integer i:neighs) 
            	  if (!alreadyVisited.contains(i))
            		  k.add(addToEnd(i,path));
              
              newAlreadyVisited.addAll(neighs);
  		} 
  		else
  		{  
              done=true; 
              shortestPaths.add(addToEnd(end,path));
  		}
  		return k;	
  }
   
   
 HashSet <ArrayList <Integer>> nexts(HashSet<ArrayList <Integer>> paths, Integer end) 
   /* applies nexts above to whole set of paths*/ 
   {                                                                                                       
     HashSet <ArrayList <Integer>>k=new HashSet <ArrayList <Integer>>();                              
     for (ArrayList <Integer> path:paths)  k.addAll(nexts(path,end));                    
     if (k.isEmpty()) done=true;
     return k;	
   }
   

public  HashSet <ArrayList <Integer>> shortestPaths(Integer start, Integer end)
 {		
                shortestPaths=new HashSet <ArrayList <Integer>> ();	

                alreadyVisited=new HashSet <Integer>();
		
                newAlreadyVisited=new HashSet <Integer>();
                
                done=false;
                
                ArrayList <Integer> begin = new ArrayList <Integer>(); 

                begin.add(start);
		
                HashSet <ArrayList <Integer>> pathsSoFar = new HashSet <ArrayList <Integer>>();
		
                pathsSoFar.add(begin);
                
                if (end==start) return pathsSoFar;
                 
                newAlreadyVisited.add(start);
		
                while(!done) 
                {
                	alreadyVisited.addAll(newAlreadyVisited);
                	pathsSoFar=nexts(pathsSoFar, end); 
			     }		
                
               return shortestPaths;
   }

	public int findMin(TreeMap <Integer,Double> t)
	{
		  int min = 0;
		  double value = infinity+1;
		  Set <Integer> set = t.keySet();
		  for(Integer i : set)
		  {
			  if(value > t.get(i))
			  {
				  min = i;
				  value = t.get(i);
			  }
		  }
		  return min;
	
	}
	
	//	Find the shortest weighted edges between two edges and return the coordinates of the stations
	public ArrayList <Integer> dijkstra(int start, int end)
    {
		HashSet <Integer> S = new HashSet <Integer> ();
		TreeMap <Integer,Double> Q = new TreeMap <Integer,Double>();
		TreeMap <Integer, ArrayList <Integer> > paths = new  TreeMap <Integer, ArrayList <Integer> >();
       
       for (Integer v:vertices()) 
       {
    	   Q.put(v,infinity); 
    	   paths.put(v,new ArrayList<Integer>());
       }
       
       Q.put(start,0.0);
       
       ArrayList<Integer> tempPath = new ArrayList<Integer>();
       tempPath.add(start); 
       paths.put(start, tempPath);
       
       while(!Q.isEmpty())
       {
          int v = findMin(Q);
          if (v == end) 
          {
        	  return paths.get(end);
          }

          double w = Q.get(v);
          S.add(v); 
          
          for(Integer u : neighbours(v))
          {
        	  if (!S.contains(u))
              {
                  double w1=weight(v,u) + w;
                  if (w1 < Q.get(u)) 
                  {
                	  Q.put(u,w1);
                	  ArrayList<Integer> a = (ArrayList<Integer>)paths.get(v).clone();
                	  a.add(u);
                	  paths.put(u,a);
                  }
               }   
          }
          Q.remove(v);
       }
       
       return (ArrayList<Integer>)paths.keySet();
     }  
	
	public double prim()
	  {     
	       TreeMap <Integer,Double> Q = new TreeMap <Integer,Double>();
	       HashSet <Integer> A = new HashSet <Integer> ();
	       TreeMap <Integer,Integer> pi = new TreeMap <Integer,Integer>();
	       
	       for (Integer v:vertices()) 
	       {
	    	   Q.put(v,infinity); 
	       }
	       
	       Q.put(1,0.0);
	       
	       while (!Q.isEmpty())
	       {
	    	   int u=findMin(Q);
	    	   Q.remove(u); 
	    	   A.add(u);
	    	   for(Integer v:neighbours(u))  
	    	   {
	    		   if (!A.contains(v) && Q.get(v) > weight(u,v)) 
	    		   {
	    			   Q.put(v,weight(u,v));
	    			   pi.put(v,u);
	                 
	              }
	         }
	       }	
	       
	       double total=0.0; 
	       for (Integer i : pi.keySet())
	       {
	    	   total+=weight(i,pi.get(i));
	       }
	       
	       return total;  
	}
}
