/*
Jacob Myers
Depth First Search implementation


Output: an adjacency matrix of a DFS tree and each coordinate along diagonal
should contain the (discovery time/finish time) of each vertex once the algorithm completed
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class depthFirstSearch{
    private LinkedList<Integer> adjacencyList[]; 
    private static int L = 8;
    private int V;
    public long start;
    public long end;

    void dfs(int graph[][], int source) {
        Queue<Integer> q = new LinkedList<>();
        Boolean[] visited = new Boolean[L];
          
        // Create a queue for BFS 
        LinkedList<Integer> queue = new LinkedList<Integer>(); 
  
        // Mark the current node as visited and enqueue it 
        for(int i=0; i<graph.length; i++){
            for(int j=0; j<graph[i].length; j++){
                visited[source]=true; 
                q.add(graph[i][j]); 
                source++;
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

        System.out.println(count);
        
        depthfirstSearch input = new depthfirstSearch();
        input.dfs(graph, 0);
    }
}
