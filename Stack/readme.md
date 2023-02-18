# Stack Implementation

This is a Java implementation of a stack data structure, written by Jacob Myers. A stack is a data structure that follows the Last-In-First-Out (LIFO) principle, meaning the most recently added element is the first to be removed. The stack allows for adding and removing elements, as well as displaying the current stack state.

The implementation defines a `Stack` class with the following methods:

-   `Stack(int n)`: a constructor that initializes the stack with a maximum capacity of `n`.
-   `void push(int val)`: adds an integer value `val` to the top of the stack, or prints an error message and exits the program if the stack is full.
-   `void pop()`: removes the top element from the stack if it exists.
-   `void display()`: prints out the current elements in the stack.

The `main` method prompts the user to enter a file name containing stack operations. Each operation is then parsed and executed in order, and the resulting stack state is displayed. The operations can be either a push operation, denoted by the string ".push" followed by an integer value, or a pop operation, denoted by the string "pop".

To run the implementation, compile the `Stack.java` file and run the resulting `Stack.class` file. When prompted, enter the name of the file containing the stack operations.
