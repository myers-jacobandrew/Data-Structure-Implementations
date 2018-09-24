	/*
		Doubly-Linked list 
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
/*
insertion, insertion after a given X, deletion, search, 
		in : insertion at the head, push(newVal)
		_X : insertion after X, specialInsert(prevNode,newVal)
		del : deletion, pop(val)
		sch : search, search(val), returns true/false
*/
	//insertion method, default insertion (at the head) 
	public void push(int newVal)
		{
			//allocates a new node and puts in the value
			Node newNode = new Node(newVal);
			newNode.next = head;
			newNode.prev = null;
			
			if (head != null) head.prev = newNode;
			
			head = newNode;
		}

	public void specialInsert(Node prevNode,int newVal){
		if(prevNode == null){
			System.out.println("cannot have null for the previous node");
			return;
		}

		//allocate a new node and puts in the value
		Node newNode = Node(newVal);
		//makes newNode's next as prevNode's next
		newNode.next = prevNode.next;
		//makes prevNode's next newNode
		prevNode.next = newNode;
		//makes newNode's prevNode
		newNode.prev = prevNode;

		// changes prev of newNode's next node
		if(newNode.next != null){
			newNode.next.prev = newNode;
		}
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
			for(int i=1; i < sepArray.length; i++){
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
					}else{
						convert = inputOp.replace(".in","");
						num = Integer.parseInt(convert);
						dll.push(num);
						System.out.println(num + " has been inserted at the head");

					}				
				}
				if(inputOp.endsWith(".del")){
					convert = inputOp.replace(".del","");
					num = Integer.parseInt(convert);
					    //delete(num)


					System.out.println(num + " has been deleted");
				}
				if(inputOp.endsWith(".sch")){
					Boolean found = false;
					convert = inputOp.replace(".sch","");
					num = Integer.parseInt(convert);

					//search(num)
					//returns found = T/F

					if(found){
					System.out.println(num + " has been found");
					}else{
					System.out.println(num + " has not been found");
					}
				}
			
			}
		}catch (FileNotFoundException ex){System.out.println("file not found");}
	}

}