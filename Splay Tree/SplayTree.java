/*

Jacob Myers
Splay Tree implementation
printed in order

*/

import java.util.Scanner;
import java.io.*;

    
class Node
{    
    Node left, right, parent;
    int value;

    public Node()
    {
        this(0, null, null, null);
    }          
    public Node(int val)
    {
        this(val, null, null, null);
    } 

    public Node(int val, Node left, Node right, Node parent)
    {
        this.left = left;
        this.right = right;
        this.parent = parent;
        this.value = val;         
    }    
}

class Splay{
    private Node root;

    //splay tree constrtr.
  public Splay(){
        root = null;
    }
  
    
    public void insert(int val){
        Node r = root;
        Node par = null;

        //while root is nonnull
        while(r != null){
            par = r;
            if (val < par.value){
                r = r.right;
            }
            else{
                r = r.left;
            }
        }
        r = new Node();
        r.value = val;
        r.parent = par;
        if (par == null){
            root = r;
        }
        else if (val < par.value){
            par.right = r;
        }
        else{
            par.left = r;
        }
        //Splay function
        Splay(r);
    }

    //dependency, for search and delete
    private Node locateNode(int val)
    {
        Node r = root;
        while (r != null)
        {
            if (val < r.value)
                r = r.right;
            else if (val > r.value)
                r = r.left;
            else
                return r;
        }
        return null;
    }

    //returns true if found
    public boolean search(int val)
     {
         return locateNode(val) != null;
     }

    void rotateRight(Node child, Node par){

        //error handling
        if ((child == null) || (par == null) || (par.left != child) || (child.parent != par)){
            throw new RuntimeException("Error");
        }
        if (par.parent != null)
        {
            if (par == par.parent.left)
                par.parent.left = child;
            else 
                par.parent.right = child;
        }
        if (child.right != null){
            child.right.parent = par;
        }
        child.parent = par.parent;
        par.parent = child;
        par.left = child.right;
        child.right = par;
    }

    void rotateLeft(Node child, Node par){

        //error handling
        if ((child == null) || (par == null) || (par.right != child) || (child.parent != par)){
            throw new RuntimeException("Error");
        }
        if (par.parent != null)
        {
            if (par == par.parent.left)
                par.parent.left = child;
            else 
                par.parent.right = child;
        }
        if (child.left != null){
            child.left.parent = par;
        }
        //pretty much the same as rotate right but reversed
        child.parent = par.parent;
        par.parent = child;
        par.right = child.left;
        child.left = par;
    }

    public void delete(int val)
    {
        //locateNode finds the node the val is in
        Node node = locateNode(val);
        remNode(node);
    }

    private void remNode(Node node)
    {
        if (node == null){
            return;
        }
        Splay(node);
        if((node.left != null) && (node.right !=null))
        { 
            Node low = node.left;
            while(low.right!=null){
                low = low.right;
            }
            low.right = node.right;
            node.right.parent = low;
            node.left.parent = null;
            root = node.left;
        }
        else if (node.right != null)
        {
            node.right.parent = null;
            root = node.right;
        } 
        else if( node.left !=null)
        {
            node.left.parent = null;
            root = node.left;
        }
        else
        {
            root = null;
        }
        node.parent = null;
        node.left = null;
        node.right = null;
        node = null;
    }

    //splay func, passes in node val
    private void Splay(Node val)
    {
        while (val.parent != null)
        {
            Node Par = val.parent;
            //grandparent
            Node grPar = Par.parent;
            if (grPar == null)
            {
                if (val == Par.left)
                    rotateRight(val, Par);
                else
                    rotateLeft(val, Par);                 
            } 
            else
            {
                if (val == Par.left)
                {
                    if (Par == grPar.left)
                    {
                        rotateLeft(Par, grPar);
                        rotateRight(val, Par);
                    }
                    else 
                    {
                        rotateRight(val, val.parent);
                        rotateLeft(val, val.parent);
                    }
                }
                else 
                {
                    if (Par == grPar.left)
                    {
                        rotateLeft(val, val.parent);
                        rotateRight(val, val.parent);
                    } 
                    else 
                    {
                        rotateLeft(Par, grPar);
                        rotateRight(val, Par);
                    }
                }
            }
        }
        root = val;
    }

    //printed inorder, no return
    public void printTree()
    {
        printTree(root);
    }
    //no return
    private void printTree(Node r)
    {
        if (r != null)
        {
            printTree(r.left);
            System.out.print(r.value +" ");
            printTree(r.right);
        }
    }
}

public class SplayTree{
    public static void main(String[] args) {
        Splay st = new Splay();
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
            int number;
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
                    st.insert(num);
                    System.out.println();
                    System.out.println(num + " has been inserted\nTree printed in-order below:");
                    st.printTree();
                }				
                if(inputOp.endsWith(".del")){
                    convert = inputOp.replace(".del","");
                    num = Integer.parseInt(convert);
                    st.delete(num);
                    System.out.println();
                    System.out.println(num + " has been deleted\nTree printed in-order below:");
                    st.printTree();
                }
                if(inputOp.endsWith(".sch")){
                    convert = inputOp.replace(".sch","");
                    num = Integer.parseInt(convert);
                    boolean found = st.search(num);
                    System.out.println();
                    if(found == true){ System.out.println(num + " found");
                    }
                    else{ System.out.println(num + " not found");}
                }

            }    
        }catch (FileNotFoundException ex){System.out.println("file not found");}
    }
}
      

