//Jacob Myers
//merge sort implementation

import java.util.*;
import java.io.*;
import java.io.IOException;

public class MergeSort {

  ArrayList <Integer> array = new ArrayList <Integer>();
  int arraySize;

 public MergeSort(ArrayList <Integer> size) {
    arraySize = size.size();
    array = size;
  }

  public void merge(int left, int mid, int right) {
    int tArray[] = new int[right - left + 1];
    int i = left;
    int j = mid + 1;
    int k = 0;
      while (i <= mid && j <= right) {
        if (array.get(i) <= array.get(j)) {
          tArray[k] = array.get(i);
          k++;
          i++;
        } else {
          tArray[k] = array.get(j);
          k++;
          j++;
        }
      }
    while (j <= right)
      tArray[k++] = array.get(j++);
    while (i <= mid)
      tArray[k++] = array.get(i++);
    for (k = 0; k < tArray.length; k++)
      array.set(left + k, tArray[k]);
  }

 public void mergeSort(int left, int right) {
  if (left < right) {
   int mid = (left + right) / 2;
   mergeSort(left, mid);
   mergeSort(mid + 1, right);
   merge(left, mid, right);
  }

 }




 public void MergeSort()
 {
  mergeSort(0, array.size() - 1);
 }
  public void range(){
    for(int i =0; i<array.size(); i++){
      System.out.print(array.get(i) + ", ");
    }
    System.out.println();
    System.out.println();
  }
  public void range(int start, int end){
    
    for(int i =start; i<=end; i++){
      System.out.print(array.get(i) +", ");
    }
    System.out.println();
    System.out.println();
  }

  public static void fileOutput(String s){
     try{
        
        File file = new File("mergeOutput.txt");
        PrintWriter out = null;
        out = new PrintWriter(new FileWriter(file, true));
        out.append(s + "\n");
        out.close();
    }
      catch (IOException e) {
         e.printStackTrace();
      }
  }

 public static void main(String args[]) throws IOException  {
    ArrayList <Integer> value = new ArrayList <Integer>();
    Scanner scan = new Scanner(System.in);
     System.out.println("file name: ");
     System.out.flush();
     String filename = scan.nextLine();

     Scanner scan2 = new Scanner(new File(filename));
     String inLine ="";
    
    while (scan2.hasNext()){
      inLine = scan2.nextLine();
      String[] sepArray = inLine.split(",");
      for (int i=0; i < sepArray.length; i++){
        value.add(Integer.parseInt(sepArray[i])) ;      
      }
    }
    scan2.close();
    MergeSort list = new MergeSort(value); 
    list.mergeSort(0,(value.size()-1));
    int count = 1000;
		long start;
    long end;
    long elapsed;
			while(count <= value.size()){
          
        list = new MergeSort(value);
        start = System.nanoTime();
        list.mergeSort(0,(count-1));
        end = System.nanoTime();
        elapsed = end - start;
        String elapsedstring = Long.toString(elapsed);
        fileOutput(elapsedstring);
        System.out.println(count + " was " + (end - start)+ " nano seconds");
        //System.out.println(end-start)
        //list.range();
        count+=1000;
		  }
		
    String printrange="";
    System.out.println("Enter range to print: e.g 1,3");
    System.out.println("To Exit program, type exit");
    while(scan.hasNext()){
      printrange = scan.nextLine();
      if(printrange.equalsIgnoreCase("exit")) System.exit(0);
      int i = printrange.indexOf(',');
      int startVal = Integer.parseInt(printrange.substring(0,i));
      int endVal = Integer.parseInt(printrange.substring(i+1));
      list.range(startVal,endVal);
      System.out.println("Enter range to print: e.g 1,3");
      System.out.println("To exit, enter exit");             
    }

 }

}
