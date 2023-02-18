/*
Jacob Myers
Breadth First Search Implementation

Output: an adjacency matrix of a shortest path tree and 
each coordinate along diagonal should contain the distance 
from the source to each vertex once the algorithm completed


*/

import java.util.*;
import java.lang.*;
import java.io.*;

class breadthfirstSearch{
    private LinkedList<Integer> adjacencyList[]; 
    private int V;
    public long start;
    public long end;

    Graph(int v) 
    { 
        V = v; 
        adjacencyList = new LinkedList[v]; 
        for (int i=0; i<v; ++i) 
            adjacencyList[i] = new LinkedList(); 
    } 


    void bfs(int graph[][], int source) {
        Queue<Integer> q = new LinkedList<>();
        Boolean[] visited = new Boolean[64];
          

        // Create a queue for BFS 
  
        // Mark the current node as visited and enqueue it 
        for(int i=0; i<graph.length; i++){
            for(int j=0; j<graph[i].length; j++){
                visited[source]=true; 
                q.add(graph[i][j]);
                if(j%8 == 0){System.out.println();}
                System.out.print(graph[i][j] + " ");
                source++;
            }
        }
        System.out.println();
        System.out.println();
        System.out.println();

  
        while (q.size() != 0) 
        { 
            // queue.poll == dequeue/ then print value 
            source = q.poll(); 
            System.out.print(source + " "); 
  
            Iterator<Integer> i = adjacencyList[source].listIterator(); 
            while (i.hasNext()) 
            { 
                int n = i.next(); 
                if (!visited[n]) 
                { 
                    visited[n] = true; 
                    q.add(n); 
                } 
            } 
        } 
    } 

    public static void main (String[] args )throws IOException 
    {
        int graph[][] = new int[8][8];
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter a File Name: ");
        System.out.flush();
        String filename = scan.nextLine();
        scan.close();

        Scanner nscan = new Scanner(new File(filename));
        String inLine ="";

        while (nscan.hasNext()){
            inLine += nscan.nextLine() + " ";
        }
        nscan.close();

        String[] sepArray = inLine.split("\\s+");
        int count =0;

        for(int i=0; i<graph.length; i++){
            for(int j=0; j<graph[i].length; j++){
                if(count < sepArray.length){
                    if(sepArray[count].trim().equals("inf")){
                        graph[i][j] = 0;
                        count++;
                    }
                    else if(sepArray[count]!="inf"){
                        graph[i][j] = Integer.parseInt(sepArray[count]);
                        count++;
                    }
                }
                
            }
        }

        
        
        breadthfirstSearch input = new breadthfirstSearch();
        input.bfs(graph, 0);
    }
}
