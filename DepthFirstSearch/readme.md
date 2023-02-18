# Depth First Search Implementation

This is a Java implementation of the Depth First Search (DFS) algorithm created by Jacob Myers. The algorithm takes an adjacency matrix as an input and outputs another adjacency matrix representing a DFS tree. Along the diagonal of the output matrix, each cell contains the discovery time/finish time of the corresponding vertex once the algorithm completes.

## Algorithm Description

The algorithm works by traversing the graph in a depth-first manner, starting from a given source node. It uses a boolean array to keep track of visited nodes and a queue to store the nodes to be visited.

## Usage

To use the algorithm, run the `main` method of the `depthFirstSearch` class. When prompted, enter the name of a file containing an adjacency matrix.

## Input

The adjacency matrix must be stored in a text file, with the matrix entries separated by spaces or newlines. The file can contain the value "inf" to represent an infinite distance between two nodes.

## Output

The algorithm outputs an adjacency matrix representing a DFS tree. Along the diagonal of the output matrix, each cell contains the discovery time/finish time of the corresponding vertex once the algorithm completes.
