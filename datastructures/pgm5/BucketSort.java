import java.util.*;
import java.io.*;
public class BucketSort{
    //public static int values [] = new int []; //values are read in to this array 
    public static int[] bucketSort(int[] beginningArray, int max){
        
    int[][] buckets = new int[(beginningArray.length/10)+1][beginningArray.length+1]; //buckets[array of buckets][what is held in each bucket]
    for (int i = 0; i < buckets.length; i++){
      for (int j = 0; j < buckets[i].length; j++){
          buckets[i][j] = -1;
      }
    }


    int[] bucketCounts = new int[(beginningArray.length/10)+1]; //keep track of the number of item in 
    for(int i=0; i < ((beginningArray.length/10)+1); i++){         //each bucket so that you know where to add the next number into.
      bucketCounts[i] = 0;
    }

    int divider = max/(beginningArray.length/10); //which bucket each number should go into

    for(int i=0; i < beginningArray.length; i++){
      int number = beginningArray[i]; //get number
      int whichBucket = number/divider; //divide that number by divider
      buckets[whichBucket][bucketCounts[whichBucket]] = beginningArray[i];
      bucketCounts[whichBucket] = bucketCounts[whichBucket] + 1;
    }

    //insertionSort on each bucket
    for(int i=0; i<buckets.length; i++){
      int x=i;
      while(x > 0 && buckets[i][x-1] > buckets[i][x]){
        int temp = buckets[i][x-1];
        buckets[i][x-1] = buckets[i][x];
        buckets[i][1] = temp;
        x--;
      }
    }

    //then add each bucket one at a time in order to the final array and return it.
    int[] finishedBucketSort = new int[beginningArray.length];
    //System.out.println(finishedBucketSort.length);
    int tracker = 0;
    for (int i = 0; i < buckets.length; i++){
      for (int j = 0; j < buckets[i].length; j++){
        if (buckets[i][j] > 0){
          finishedBucketSort[tracker] = buckets[i][j];
          //System.out.println(tracker + " : " + finishedBucketSort[tracker]);
          tracker++;
        }
      }
    }

      //System.out.println();

    return finishedBucketSort;
  }

/*
  static int[] bucketSort(int[] inArray, int max){
    int[] bucket = new int[max + 1];
    int[] sorted = new int[inArray.length];

    for (int i = 0; i < inArray.length; i++)
        bucket[inArray[i]]++;

    int out = 0;
    for (int i = 0; i < bucket.length; i++)
        for (int j = 0; j < bucket[i]; j++)
            sorted[out++] = i;
    return sorted;
  }
*/  
  public static void range(int[] sorted, int start, int end){
    for(int i =start; i<=end; i++){
      System.out.print(sorted[i] +", ");
    }
    System.out.println();
  }

  public static void fileOutput(String s){
    try{
      File file = new File("bucketOutput.txt");
      PrintWriter out = null;
      out = new PrintWriter(new FileWriter(file, true));
      out.append(s + "\n");
      out.close();  
    }catch (IOException e) {e.printStackTrace();}
  }


   public static void main(String[] args) throws IOException {
      ArrayList <Integer> values = new ArrayList <Integer>();
      Scanner scan = new Scanner(System.in); //filename
      System.out.println("file name: ");
      System.out.flush();
      String filename = scan.nextLine();
 
      Scanner scan2 = new Scanner(new File(filename)); //file contents
      String inLine ="";
     
     while (scan2.hasNext()){
       inLine = scan2.nextLine();
       String[] sepArray = inLine.split(",");
       for (int i=0; i < sepArray.length; i++){
         values.add(Integer.parseInt(sepArray[i]));      
       }
     }
     scan2.close();

     int[] value = new int[values.size()];
     int[] sorted = new int[values.size()];
     for(int i=0; i<values.size(); i++){
      value[i] = values.get(i);
    }


    int max =0; 
    for(int i =0; i < value.length; i++){
      if(value[i] > max){
        max = value[i];
      }
    }
    
    int count = 1000;
    long start;
    long end;
    
    while(count <= value.length){
      int[] temp = new int[count];
      for(int i = 0; i < count; i++){
        temp[i] = value[i];
      }
      //System.out.println("Before: " + Arrays.toString(value));
      start = System.nanoTime();
      sorted = bucketSort(temp,max);
      end = System.nanoTime();
      //System.out.println("After:  " + Arrays.toString(value));
      fileOutput(count+ ","+ (end - start));
      count += 1000;
    }
      

    //sorted = bucketSort(value,max);

    String printrange="";
    System.out.println("Enter range to print e.g 1,3");
    System.out.println("To exit, enter exit");
    while(scan.hasNext()){
  
      printrange = scan.nextLine();
      if(printrange.equalsIgnoreCase("exit")) System.exit(0);
      int i = printrange.indexOf(',');
      int startVal = Integer.parseInt(printrange.substring(0,i));
      int endVal = Integer.parseInt(printrange.substring(i+1));
      range(sorted,startVal,endVal);
      System.out.println("Enter range to print e.g 1,3");
      System.out.println("To exit, enter exit");             
    }
  }
}