  // Jacob Myers
// red black tree

import java.util.*;
import java.io.*;

public class RedBlackTree {

    //never changes
    private int black=1;
    private int red=0;

    private class Node {
        int key, color = black;
        Node left=nil;
        Node right=nil;
        Node parent=nil;
        

        //constructor
        Node(int key){
            this.key = key;
        }
    }

    //init
    private Node nil = new Node(0);
    private Node root = nil;


    //insertion function, insert z where it goes, fix any violations
    public void insert(Node node){
        Node temp = root;
        //first insert
        if (root == nil){
            root = node;
            // set color
            node.color = black;
            //set parent to null
            node.parent = nil;            
        }
        else{
            //set color to red
            node.color = red;
            while(true){
                //left
                if(node.key < temp.key) {
                    //first left
                    if (temp.left == nil){
                        temp.left = node;
                        node.parent = temp;
                        //found proper location
                        break;
                    }
                    //set new parent to left child
                    else {
                        temp = temp.left;
                    }
                }
                //right
                else if (node.key > temp.key){
                    //first right
                    if(temp.right == nil){
                        temp.right = node;
                        node.parent = temp;
                        //found proper location
                        break;
                    }
                    //set new parent to right child
                    else{
                        temp = temp.right;
                    }
                }
            }
            //needs to do fixing here
            fix1(node);
        }
    }

    private void fix1(Node node) {
        while (node.parent.color == red) {
            Node uncle = nil;
            if (node.parent == node.parent.parent.left) {
                uncle = node.parent.parent.right;

                if (uncle != nil && uncle.color == red) {
                    node.parent.color = black;
                    uncle.color = black;
                    node.parent.parent.color = red;
                    node = node.parent.parent;
                    continue;
                }

                //2 rotations
                if (node == node.parent.right) {
                    node = node.parent;
                    rotateLeft(node);
                }
                node.parent.color = black;
                node.parent.parent.color = red;

                rotateRight(node.parent.parent);

            } else {
                uncle = node.parent.parent.left;
                 if (uncle != nil && uncle.color == red) {
                    node.parent.color = black;
                    uncle.color = black;
                    node.parent.parent.color = red;
                    node = node.parent.parent;
                    continue;
                }

                //2 rotations
                if (node == node.parent.left) {
                    node = node.parent;
                    rotateRight(node);
                }
                node.parent.color = black;
                node.parent.parent.color = red;

                rotateLeft(node.parent.parent);
            }
        }
        root.color = black;
    }


    //deletion function, find z, delete, then fix any violations
    boolean delete(Node z){
        //base, empty tree
        if ((z = locate(z, root)) == null){
            System.out.println(z +" could not be found");
            return false;
        }

        Node x;
        Node temp = z;
        int currentColor = temp.color;
    
        if(z.left == nil){
            x = z.right;
            change(z, z.right);
        }else if(z.right == nil){
            x = z.left;
            change(z, z.left);
        }else{
            temp = findMin(z.right);
            currentColor = temp.color;
            x = temp.right;
            if(temp.parent == z)
                x.parent = temp;
            else{
                change(temp, temp.right);
                temp.right = z.right;
                temp.right.parent = temp;
            }
            change(z, temp);
            temp.left = z.left;
            temp.left.parent = temp;
            temp.color = z.color;
        }
        if(currentColor==black)
            fix2(x);  //deletion fixing
        return true;
    }

    void change(Node a, Node b){
        if(a.parent == nil){
            root = b;
        }else if(a == a.parent.left){
            a.parent.left = b;
        }else
            a.parent.right = b;
        b.parent = a.parent;
    }

    Node findMin(Node subRoot){
        while(subRoot.left != nil){
            subRoot = subRoot.left;
        }
        return subRoot;
    }
    public void fix2(Node x){
        while(x != root && x.color == black){
            if(x == x.parent.left){
                Node temp = x.parent.right;
                if(temp.color == red){
                    temp.color = black;
                    x.parent.color = red;
                    rotateLeft(x.parent); //rotate parent left
                    temp = x.parent.right;
                }
                if(temp.left.color == black && temp.right.color == black){
                    temp.color = red;
                    x = x.parent;
                    continue;
                }
                if(temp.right.color == black){
                    temp.left.color = black;
                    temp.color = red;
                    rotateRight(temp); //rotate right
                    temp = x.parent.right;
                }
                if(temp.right.color == red){
                    temp.color = x.parent.color;
                    x.parent.color = black;
                    temp.right.color = black;
                    rotateLeft(x.parent); //rotate parent left
                    x = root;
                }
            }else{
                Node temp = x.parent.left;
                if(temp.color == red){
                    temp.color = black;
                    x.parent.color = red;
                     //rotate parent right
                    rotateRight(x.parent);
                    temp = x.parent.left;
                }
                if(temp.right.color == black && temp.left.color == black){
                    temp.color = red;
                    x = x.parent;
                    continue;
                }
                else if(temp.left.color == black){
                    temp.right.color = black;
                    temp.color = red;
                    rotateLeft(temp);
                    temp = x.parent.left;
                }
                if(temp.left.color == red){
                    temp.color = x.parent.color;
                    x.parent.color = black;
                    temp.left.color = black;
                    rotateRight(x.parent);
                    x = root;
                }
            }
        }//end of while loop
        x.color = black;
    }


    void rotateRight(Node x){
        if (x.parent != nil) {
            if (x == x.parent.left) {
                x.parent.left = x.left;
            }else{
                x.parent.right = x.left;
            }
            x.left.parent = x.parent;
            x.parent = x.left;
            if (x.left.right != nil) {
                x.left.right.parent = x;
            }
            x.left = x.left.right;
            x.parent.right = x;
        }else{
            Node ln = root.right; //left node
            root.left = root.left.right;
            ln.right.parent = root;
            root.parent = ln;
            ln.right = root;
            ln.parent = nil;
            root = ln;
        }
    }
    void rotateLeft(Node x){
        if (x.parent != nil) {
            if (x == x.parent.left) {
                x.parent.left = x.right;
            }else{
                x.parent.right = x.right;
            }
            x.right.parent = x.parent;
            x.parent = x.right;
            if (x.right.left != nil) {
                x.right.left.parent = x;
            }
            x.right = x.right.left;
            x.parent.left = x;
        }else{
            Node rn = root.right; //right node
            root.right = rn.left;
            rn.left.parent = root;
            root.parent = rn;
            rn.left = root;
            rn.parent = nil;
            root = rn;
        }
    }

    //finds node(used in search and deletion)
    public Node locate(Node z, Node node){
        if (root == nil){return null;} //base case, empty tree
    
        //z < parent(starts at root, which will be passed in as an argument)
        if (z.key < node.key) {
            if (node.left != nil) {
                return locate(z, node.left);
            }
        } 
        //z > parent(starts at root, which will be passed in as an argument)
        else if (z.key > node.key) {
            if (node.right != nil) { 
                return locate(z, node.right);
            }
        } 
        // z == key, return it 
        else if (z.key == node.key) {
            return node;
        }
        return null;
    }

    // pass in root to print whole tree
    //in order: left, root, right
    public void printTree(Node current){
        if(current != nil){
            printTree(current.left);
            System.out.print(current.key+", ");
            printTree(current.right);
        }
    }

    public void start(){
        try{
			//reads in file name
			Scanner scan = new Scanner(System.in);
			System.out.println("Enter the name of the input file: ");
			System.out.flush();
			String fileName = scan.nextLine();
			scan.close();

			//reads in file contents
			Scanner readIn = new Scanner(new File(fileName));
			String inVal ="";

			// reads in the input as a string
			while (readIn.hasNext()){
				inVal += readIn.nextLine();
			}
			readIn.close();
            String inputOp;
			//array with split inputs, space is the delimiter
			String[] sepArray = inVal.split("\\s+");
			for(int i=0; i < sepArray.length; i++){
				//System.out.println(sepArray[i]);
			}
			String currentOp;
			String convert;
			int num = 0;
            // iterate through input array
            


			for(int i=0; i < sepArray.length; i++){
				//System.out.println(sepArray[i]);
				inputOp = sepArray[i];							
				if(inputOp.contains(".in")){
                    convert = inputOp.replace(".in","");
                    num = Integer.parseInt(convert);
                    Node node = new Node(num);
                    //check for duplicate
                    if(locate(node, root) != null){
                        System.out.println(num + " is already in the tree.");
                        printTree(root);
                        System.out.println();
                    }
                    else{

                        insert(node);
                        System.out.println("Tree after insertion:");
                        printTree(root);
                        System.out.println();
					}				
				}
				else if(inputOp.endsWith(".del")){
					convert = inputOp.replace(".del","");
                    num = Integer.parseInt(convert);
                    Node node = new Node(num);

					delete(node);
					System.out.println("Tree(inorder) after deletion:");
                    printTree(root);
                    System.out.println();
                    }
                } //end of for loop
		    }catch (FileNotFoundException ex){System.out.println("file not found");}
        }

    public static void main(String[] args){
        RedBlackTree rbt = new RedBlackTree();
        rbt.start();
    }


}
