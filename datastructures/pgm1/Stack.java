/*
    Stack Implementation
	Jacob Myers
*/
import java.util.*; 
import java.io.*;


public class Stack{

    int[] stackarray;
    int max;
    int current = 0;
  
    public Stack(int n){
      stackarray = new int[n];
      max = n;
    }
  
    public void push(int val){
        System.out.println("trying to push " + val);
      if(current == (max - 1)){
        System.out.println("stack overflow");
        System.exit(0);
      }
      else if(current == 0){
      stackarray[current] = val;
      current++;
      }
      else{
        stackarray[current] = val;
        current++;
      }
    }
  
    public void pop(){
      if(current > 0){
        stackarray[current] = 0;
        current--;
        
      }
      else{
        stackarray[current] = 0;
      }
    }
  
    public void display(){
        System.out.println("The stack: ");
      for(int i=0; i<current; i++){
        System.out.print(stackarray[i] + " ");
      }
      System.out.println();
    }

    
    public static void main(String args[]) 
    {  
        String inputOp = "";
        boolean quit = false;
        int c;
        String[] sepArray;  

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
            Stack stack = new Stack(size);


            System.out.println();

            for(int i=1; i < sepArray.length; i++){
                inputOp = sepArray[i];
                if(inputOp.contains("pop")){
                    stack.pop();                
                    stack.display();

                }else if(inputOp.contains(".push")){
                    convert = inputOp.replace(".push","");
                    num = Integer.parseInt(convert);
                    stack.push(num);
                    stack.display();

                } 
            }
        }catch (FileNotFoundException ex){System.out.println("file not found");}
        /*
        do {        
            System.out.println();
            Scanner in = new Scanner(System.in);
            System.out.println("Select desired operation: ");
            System.out.println("0. Quit");
            System.out.println("1. Display input operations");
            System.out.println("2. Display Stack");
            System.out.println();
            c = in.nextInt();

            switch (c) {
                case 1:
                System.out.println();
                for(int i=1; i < sepArray.length; i++){
                    System.out.println(sepArray[i]);
                }
                break;
            case 2:
                System.out.println();
                stack.display(stack);
                System.out.println();

                break;
            case 0:
                quit = true;
                return;
                default:
                    System.out.println("invalid selection.");
                }
        } while (!quit);
        System.out.println("exiting program");     
    }*/

    }
}
