# Merge Sort Implementation

This is an implementation of the Merge Sort algorithm in Java. Merge sort is a divide-and-conquer algorithm that sorts an array by breaking it down into smaller sub-arrays and sorting those sub-arrays recursively.

## Usage

To use this implementation, create a new instance of the `MergeSort` class, passing in an `ArrayList` of integers to be sorted. You can then call the `mergeSort` method to sort the array.

The class also includes two methods for printing out the sorted array:

-   `range()` will print the entire sorted array
-   `range(start, end)` will print a specified range of the sorted array

The `fileOutput` method can be used to write the elapsed time of each sorting operation to a text file called `mergeOutput.txt`.

## Example

```java
import java.util.ArrayList;

public class Example {
  public static void main(String[] args) {
    ArrayList<Integer> array = new ArrayList<Integer>();
    array.add(5);
    array.add(2);
    array.add(9);
    array.add(3);
    array.add(6);

    MergeSort sort = new MergeSort(array);
    sort.mergeSort(0, array.size() - 1);
    sort.range();
  }
}

```

Output:

`2, 3, 5, 6, 9,` 

## Input

This implementation allows you to input an unsorted list of integers from a file. When you run the program, you will be prompted to enter the filename. The program expects the file to contain a single line of integers, separated by commas.

## Testing

This implementation includes a testing function that will sort the array multiple times, each time increasing the size of the sub-array that is sorted. The elapsed time of each sort is written to a file called `mergeOutput.txt`.
