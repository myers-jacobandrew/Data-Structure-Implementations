# Queue Implementation

This is a simple implementation of a queue in Java created by Jacob Myers. The `Queue` class contains methods for adding and removing elements to and from the queue, as well as a `display` method for printing out the current contents of the queue.

The `main` method reads in input from a file specified by the user, which is expected to contain a series of operations to be performed on the queue. Operations include adding elements to the queue and removing the element at the head of the queue.

To run the implementation, compile the Java source code and run the resulting `.class` file. When prompted, enter the name of the input file that contains the operations to be performed on the queue.

Example usage:

```
$ javac Queue.java
$ java Queue
Enter the name of the input file:
input.txt
adding 10 to the queue.
adding 20 to the queue.
adding 30 to the queue.
The inputs were:
2.in
10.in
20.in
30.in
del
del
The queue:
20 30
```
