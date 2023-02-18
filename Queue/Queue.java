   /*
       Queue Implementation
       Jacob Myers
       
       This is a basic implementation of a queue data structure in Java that uses an array to store and manage elements. 
       It supports the enqueue operation to add elements at the back of the queue, dequeue operation to remove elements from the front of the queue, and display operation to print the contents of the queue. 
       The size of the queue is set at initialization and the implementation includes error handling for overflow cases

   */
  

import java.util.*;
import java.io.*;

public class Queue{

    private int[] queuearray;
    private int max;
    private int current = 0; //starts at zero
  
    public Queue(int n){
      queuearray = new int[n];
      max = n;
    }
  
    public void enqueue(int keyValue){
      if(current == max){
        System.out.println("Overflow");
        System.exit(0);
      }
      else {
        queuearray[current] = keyValue;
        current++;
      }
    }
  
    public void dequeue(){
      for(int i=1; i<=current; i++){
        queuearray[i-1] = queuearray[i];
      }
      current--;
    }
  
    public void display(){
        System.out.println("The queue: ");
          for(int i=0; i<current; i++){
        System.out.print(queuearray[i] + " ");
      }
      System.out.println();
    }
  

    public static void main(String[] args) {
            String inputOp = "";
            boolean quit = false;
            int c;
            String sepArray[];
        try{
            //reads in file name
            System.out.println();

            Scanner scan = new Scanner(System.in);
            System.out.println("Enter the name of the input file: ");
            System.out.flush();
            String fileName = scan.nextLine();

            //reads in file contents
            Scanner readIn = new Scanner(new File(fileName));
            String inVal ="";

            // reads in the input as a string
            while (readIn.hasNext()){
                inVal += readIn.nextLine();
            }
            readIn.close();

            //array with split inputs, space is the delimiter
            sepArray = inVal.split("\\s+");
        
            String convert;
            int num = 0;
            // iterate through input array

            convert = sepArray[0];
            int size = Integer.parseInt(convert);
            Queue queue = new Queue(size);


            System.out.println();

            for(int i=1; i < sepArray.length; i++){
                inputOp = sepArray[i];
                if(inputOp.contains(".in")){
                    convert = inputOp.replace(".in","");
                    num = Integer.parseInt(convert);
                    System.out.println("adding " + num + " to the queue.");
                    queue.enqueue(num);
                }else if(inputOp.contains("del")){
                    queue.dequeue();
                } 
            }

            System.out.println("The inputs were: ");
            for(int i=1; i < sepArray.length; i++){
            System.out.println(sepArray[i]);
            }

            queue.display();

        }catch (FileNotFoundException ex){System.out.println("file not found");}
    }
}
