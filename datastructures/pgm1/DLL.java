   /*
       Doubly-Linked List Implementation
       Jacob Myers

   */
  
  import java.io.*;
  import java.util.*;
  
  public class DLL {
	 Node head;
  
	 class Node {
		 int data;
		 Node prev;
		 Node next;
		 // next and prev are null by default
  
		 //constructor to create a new node
		 Node(int d){
			 data = d;
		 }
	 }
  
	 //insertion method, default insertion (at the head)
	 public void push(int newVal)
		 {
			 System.out.println("Adding " + newVal + " to the head.");
			 //allocates a new node and puts in the value
			 Node newNode = new Node(newVal);
			 newNode.next = head;
			 newNode.prev = null;
			
			 if (head != null) {head.prev = newNode;}
			 head = newNode;
		 }
  
  
	 public boolean search(int val)
	 {
		 Node current = head;
		 while (current != null)
		 {
			 if (current.data == val)
				 return true; //found
				 current = current.next;
		 }
	 return false;
	 }  
	
	 public void specialInsert(int prevVal,int newVal){
		
		 Node current = head;
		
		 while (current.next != null)
		 {
			 if (current.data == prevVal){//allocate a new node and puts in the value
				 Node newValNode = new Node(newVal);
				 //makes newNode's next prevNode's next
				 newValNode.next = current.next;
				 //makes prevNode's next newNode
				 current.next = newValNode;
				 //makes newNode's prevNode
				 newValNode.prev = current;
		
				 // changes prev of newNode's next node
				 if(newValNode.next != null){
					 newValNode.next.prev = newValNode;
					 break;
				 }
			 }
			 current = current.next;
		 }
		 return;
		 }
		
		
	
  
	 void deleteNode(int val) {
	  //System.out.println("made it here");
		 Node toDelete = head;
		 while (toDelete != null){
			 if (toDelete.data == val){
			 System.out.println("Found " + val + ", will be deleted");
  
			 toDelete.prev.next = toDelete.next;
			 toDelete.next.prev = toDelete.prev;
						
			 return;
			}
			toDelete = toDelete.next;
		 }
	 }
  
	 public void printList(){
		Node temp = head;
		System.out.print("Doubly Linked List: ");
		while(temp!=null){
			System.out.print(" " + temp.data);
			temp = temp.next;
		}
		System.out.println();
	}
  
	 public static void main(String[] args) {
		 DLL dll = new DLL();
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
					 if(inputOp.contains("_")){
						 String inputOp2 = inputOp;
  
						 //finds int at the beginning of the string
						 convert = inputOp.split("[._a-z]")[0];
						 int newVal = Integer.parseInt(convert);
  
						 //finds int at the end of the string
						 String newValString = Integer.toString(newVal);
						 inputOp2 = inputOp2.replace(newValString+".in_","");
						 int prevVal = Integer.parseInt(inputOp2);
  
						 dll.specialInsert(prevVal,newVal);
  
						 System.out.println(newVal + " has been inserted after " + prevVal);
						 dll.printList();
  
					 }else{
						 convert = inputOp.replace(".in","");
						 num = Integer.parseInt(convert);
						 dll.push(num);
						 System.out.println(num + " has been inserted at the head");
						 dll.printList();
					 }              
				 }
				 if(inputOp.endsWith(".del")){
					 convert = inputOp.replace(".del","");
					 num = Integer.parseInt(convert);
					 dll.deleteNode(num);
					 dll.printList();
					 System.out.println(num + " has been deleted");
				 }
				 if(inputOp.endsWith(".sch")){
					 Boolean found = false;
					 convert = inputOp.replace(".sch","");
					 num = Integer.parseInt(convert);
					 found = dll.search(num);
					
					 if(found){
						 System.out.println(num + " found");
					 }else{
						 System.out.println(num + " not found");
					 }
				 }
			 }
		 }catch (FileNotFoundException ex){System.out.println("file not found");}
	 }
  
  }
  
  
  
  