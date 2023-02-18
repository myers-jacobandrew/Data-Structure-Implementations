  # maxHeap.java Readme

## Description

`maxHeap.java` is a Java implementation of a max heap data structure. The program reads in an input file, with the following format: `"pre|post|in 1.in 3.in 5.in del 6.in 7.in del"`. The program displays the heap before and after insertion and deletion of the given input values.

## How to Use

### Execution

To execute the program, compile the `maxHeap.java` file by running `javac maxHeap.java` on the command line. This will generate a `maxHeap.class` file. Then, run the program using the command `java maxHeap`.

### Input File

The program reads in an input file that should be in the following format:

`"pre|post|in 1.in 3.in 5.in del 6.in 7.in del"`

The first part of the input string is the order in which the heap is traversed, followed by a sequence of insert and delete operations on the heap.

-   "pre" for pre-order traversal
-   "post" for post-order traversal
-   "in" for in-order traversal

### Output

The program outputs the following:

-   The original heap before insertion or deletion
-   The updated heap after each insertion or deletion operation

## Class Members

### maxHeap()

This is the class constructor that initializes an empty heap.

### siftUp()

This method moves the last element of the heap up to its correct position.

### insertHeap(int i)

This method adds a new integer element to the heap and calls the `siftUp()` method to reorder the heap.

### siftDown()

This method moves the first element of the heap down to its correct position.

### delete()

This method removes the root element of the heap and calls the `siftDown()` method to reorder the heap.

### preOrder(int count), inOrder(int count), postOrder(int count)

These methods traverse the heap in pre-order, in-order, and post-order respectively, and print each element.

### main(String[] args)

This is the main method of the class. It reads in the input file and performs the insert and delete operations on the heap. It also calls the appropriate traversal method and prints the heap before and after each operation.
