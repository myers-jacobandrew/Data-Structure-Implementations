/*
Jacob Myers
pgm7 - Dijkstra's Shortest Path
CS 3353
*/

import java.util.*;
import java.lang.*;
import java.io.*;
 
class dijkstra
{
    static final int LENGTH=5;
    int shortest(int x[], Boolean tf[])
    {        
        int min = Integer.MAX_VALUE, ind = -1;
 
        for (int l = 0; l < LENGTH; l++)
            if (tf[l] == false && x[l] <= min)
            {
                min = x[l];
                ind = l;
            }
 
        return ind;
    }
 
    void fix(int x[], int n)
    {
        int [][] data = new int[5][5];

        for(int i=0; i<data.length; i++){
        	for(int j=0; j<data[i].length; j++){
        		if(i==j){
        			data[i][j] = x[i];
        		}
        		else{
        			data[i][j] = 0;
        		}
        	}
        }

         for(int i=0; i<data.length; i++){
        	for(int j=0; j<data[i].length; j++){
        		System.out.print(data[i][j] + " ");
        	}
        	System.out.println();
        }

    }
 
    void dijkstra(int graph[][], int source)
    {
        int x[] = new int[LENGTH]; 
        Boolean tf[] = new Boolean[LENGTH];
        for (int i = 0; i < LENGTH; i++)
        {
            x[i] = Integer.MAX_VALUE;
            tf[i] = false;
        }
 
        x[source] = 0;
 
        for (int count = 0; count < LENGTH-1; count++)
        {
            int u = shortest(x, tf);
 
            tf[u] = true;

            for (int l = 0; l < LENGTH; l++)

                if (!tf[l] && graph[u][l]!=0 &&
                        x[u] != Integer.MAX_VALUE &&
                        x[u]+graph[u][l] < x[l])
                    x[l] = x[u] + graph[u][l];
        }
 

         fix(x, LENGTH);


    }

    public static void main (String[] args )throws IOException 
    {
        int graph[][] = new int[5][5];
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

        
	    dijkstra table = new dijkstra();
        table.dijkstra(graph, 0);
    }
}