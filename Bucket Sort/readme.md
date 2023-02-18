# Bucket Sort

Bucket Sort is a sorting algorithm that works by distributing the elements of an array into a number of buckets, each of which is then sorted individually. After all the buckets are sorted, the sorted elements are concatenated into a final sorted array.

The following implementation of Bucket Sort in Java takes an input file name as argument, reads the data from the file into an array, and then sorts the array using Bucket Sort. The implementation includes the following methods:

-   `bucketSort(int[] beginningArray, int max)` - the main method that implements the Bucket Sort algorithm. The method takes an array `beginningArray` and the maximum value `max` in the array, and returns the sorted array.
-   `range(int[] sorted, int start, int end)` - a helper method that prints the elements of the `sorted` array from index `start` to index `end`.
-   `fileOutput(String s)` - a helper method that writes the output of the program to a file named `bucketOutput.txt`.
-   `main(String[] args)` - the main method that reads the data from the input file, sorts the data using Bucket Sort, and writes the output to a file.

## How to use

To use the Bucket Sort implementation, follow these steps:

1.  Create an input file containing the data to be sorted. The file should contain a list of integers separated by commas. For example:
    

-   `5,3,8,1,4,2,7,6`
    
-   Save the input file to a directory on your computer.
    
-   Open a text editor and copy the code of the `BucketSort` class.
    
-   In a Java IDE, create a new Java class and paste the code into the class.
    
-   Save the Java class in the same directory as the input file.
    
-   Compile and run the Java class.
    
-   When prompted, enter the name of the input file. For example:    

1.  `file name: input.txt`
    
2.  The program will sort the data using Bucket Sort and write the output to a file named `bucketOutput.txt` in the same directory as the input file.
    

## Time complexity

The time complexity of Bucket Sort is O(n+k), where n is the number of elements in the array and k is the number of buckets. If the number of buckets is close to the number of elements, the time complexity can be close to O(n^2). However, if the number of buckets is much smaller than the number of elements, the time complexity can be closer to O(n).

## Space complexity

The space complexity of Bucket Sort is O(n+k), where n is the number of elements in the array and k is the number of buckets.
