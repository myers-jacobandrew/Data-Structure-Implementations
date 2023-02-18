# Dijkstra's Shortest Path Algorithm

This is an implementation of Dijkstra's Shortest Path Algorithm in Java. It reads a graph from a file, applies the algorithm to find the shortest paths, and prints the resulting matrix to the console.

## Usage

1.  Compile the program by running the command `javac dijkstra.java`.
2.  Run the program with `java dijkstra`.
3.  Enter the name of the input file when prompted. An example input file named `test` is provided in the repository.
4.  The program will output the resulting matrix to the console.

## Input File Format

The input file should contain a square matrix with values separated by whitespace. The value `inf` should be used to represent infinity. An example input file is provided in the repository as `test`.

## Output

The program will output the matrix representing the shortest paths to the console. A value of `0` represents the shortest path from a node to itself, and a value of `inf` represents the absence of a path between two nodes.
