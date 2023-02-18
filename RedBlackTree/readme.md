# Red Black Tree Implementation

This program implements a red-black tree data structure in Java.

## Compilation and Running the Program

To compile the program, run the following command:

`javac RedBlackTree.java`

To run the program, execute the following command:

`java RedBlackTree`

The program will immediately ask for an input file. You can use the text file "test" included in the program's directory as an example. The contents of "test" are:


`1.in 3.in 5.in 4.in 7.in 4.del 18.in 14.in 12.in 6.in 3.in`

Once you enter the input file name, the program will print the tree's in-order traversal to the console.

## Example Output

After running the program with the "test" input file, the following output will be printed to the console:


```
Enter the name of the input file: test 
Tree after insertion: 1
Tree after insertion: 1, 3
Tree after insertion: 1, 3, 5
Tree after insertion: 1, 3, 4, 5 
Tree after insertion: 1, 3, 4, 5, 7
Tree(inorder) after deletion: 1, 3, 5, 7 
Tree after insertion: 1, 3, 5, 7, 18
Tree after insertion: 1, 3, 5, 7, 14, 18
Tree after insertion: 1, 3, 5, 7, 12, 14, 18
Tree after insertion: 1, 3, 5, 6, 7, 12, 14, 18
3 is already in the tree. 1, 3, 5, 6, 7, 12, 14, 18
```

This output shows the tree's in-order traversal at various points during the program's execution. The tree is initially empty, and nodes are added to it one by one as specified in the input file. The output also shows the effect of deleting a node, as well as the result of attempting to insert a node that is already in the tree.
