  # Doubly-Linked List Implementation

This is a Java implementation of a doubly-linked list, which allows for efficient traversal in both forward and backward directions. It contains the following methods:

-   `push(int newVal)`: inserts a new node at the head of the list.
-   `search(int val)`: searches for a node with the given value in the list, returning `true` if it is found and `false` otherwise.
-   `specialInsert(int prevVal, int newVal)`: inserts a new node with value `newVal` after the first occurrence of a node with value `prevVal` in the list.
-   `deleteNode(int val)`: deletes the first occurrence of a node with value `val` from the list.
-   `printList()`: prints the current contents of the list.

The implementation also includes a `main` method that reads in a file of instructions, with the following format:

-   Each line in the file contains an instruction in the form `X.Y`, where `X` is an integer and `Y` is a string indicating the operation to perform.
-   If `Y` ends with `.in`, a node with value `X` is inserted into the list. If `Y` ends with `_Z.in`, a node with value `X` is inserted after the first occurrence of a node with value `Z` in the list.
-   If `Y` ends with `.del`, the first occurrence of a node with value `X` is deleted from the list.
-   If `Y` ends with `.sch`, the list is searched for a node with value `X`.

The implementation also includes basic error handling for file input.
