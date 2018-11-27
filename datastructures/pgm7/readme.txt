Jacob Myers
dijkstra's shortest path implementation readme

this serves as a supplement to my dijkstra's shortest path program.

compile: 
javac dijkstra.java

run:
java dijkstra

will ask immediately for input file, I included a text file called test containing:
inf	10	inf	5	inf
inf	inf	1	2	inf
inf	inf	inf	inf	4
inf	3	9	inf	2
7	inf	4	inf	inf


from input.txt will print out based on shortest path:
0 0 0 0 0
0 8 0 0 0
0 0 9 0 0
0 0 0 5 0
0 0 0 0 7