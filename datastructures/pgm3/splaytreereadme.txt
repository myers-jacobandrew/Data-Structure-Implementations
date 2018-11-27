Jacob Myers
splay tree implementation readme

this serves as a supplement to my splay tree program.

compile: 
javac SplayTree.java

run:
java SplayTree

will ask immediately for input file, i included a text file called splay.txt containing:
"1.in 3.in 5.in 3.del 2.in 3.sch"

feel free to try it with any other input file following the same format


input:
1.in 3.in 5.in 3.del 2.in 3.sch

output:
1 has been inserted
Tree printed in-order below:
1
3 has been inserted
Tree printed in-order below:
3 1
5 has been inserted
Tree printed in-order below:
5 3 1
3 has been deleted
Tree printed in-order below:
5 1
2 has been inserted
Tree printed in-order below:
5 2 1
3 not found

