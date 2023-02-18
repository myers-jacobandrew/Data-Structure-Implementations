# Double Hash Implementation

This program implements a hash table using the double hashing technique. It provides the ability to insert, search, and delete elements from the hash table.

### How to Use

1.  Compile the DoubleHash.java file.
2.  Run the compiled file using the command "java DoubleHash".
3.  Enter the name of the input file when prompted.
4.  The program reads in the contents of the input file and performs the operations specified in the file.

### Input File Format

The input file should be in the following format:

-   The first line should contain a single integer value `N` that specifies the maximum number of elements in the hash table.
-   The remaining lines should contain the operations to be performed on the hash table. Each operation should be on a separate line and should be in the format `<value>.<operation>`, where `<value>` is the value to be inserted, searched, or deleted and `<operation>` is either "in" for insert, "sch" for search, or "del" for delete.

### Example Input File


`10 1.in 2.in 3.in 4.in 5.in 6.in 7.in 8.in 9.in 10.in 1.del 4.del 7.del 10.del 1.sch 4.sch 7.sch 10.sch`

### Note

This program uses the Double Hashing technique with a step size of 3. The hash function used is `(val % arrayLength)`.

If the input file name is not provided or the file is not found, the program will output "file not found".
