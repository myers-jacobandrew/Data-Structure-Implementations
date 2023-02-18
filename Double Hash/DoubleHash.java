/*
Jacob Myers
Double Hash program
*/
import java.util.*;
import java.io.*;
public class DoubleHash{
	String [] elements;
	int arrayLength;
	public int items=0;

	public DoubleHash(int size){
		arrayLength = size;
		elements = new String [arrayLength];
		Arrays.fill(elements, " ");
	}

	public void insert(String val){
		System.out.println("trying to insert " +val+ ":");
		int index = Integer.parseInt(val) % arrayLength;
		int step = 3 - (Integer.parseInt(val) % 3);

		while(elements[index].equals(" ")== false){
			index+= step;
			index %= arrayLength;
		}
		elements[index] = val;
		items++;
	}
	public boolean search(String val){
		int index = Integer.parseInt(val) % arrayLength;
		int step = 3 - (Integer.parseInt(val) % 3);

		while (elements[index].equals(" ")== false) {
				if (elements[index].equals(val)) {
				return true;
				}
				index+= step;
				index %= arrayLength;
		}
		//outside of loop false
		return false;
	}
	public void delete(String val){
		System.out.println("trying to delete "  + val + ":");
		int index = Integer.parseInt(val) % arrayLength;
		int step = 3 - (Integer.parseInt(val) % 3);

		while (elements[index].equals(" ")== false) {
			if (elements[index].equals(val)) {
				elements[index] = " ";
				items--;
				return;
			}
		index+= step;
		index %= arrayLength;
		}
		System.out.println(val + " not found, deletion step ignored");
		return;
	}
	public static String hashCompute(String val){
		if(val.endsWith(".in") || val.endsWith(".del") || val.endsWith(".sch")){
			int index = val.indexOf('.');
			val = val.substring(0,index);
		}
		return val;
	}
	public void printList(){
		System.out.println();
		System.out.println("printing our hash table:");
		if(items == 0){
			System.out.println("hash table has no elements");
			return;
		}

		for(int i=0; i<arrayLength; i++){
			System.out.println(i + ": " + elements[i]);
		}
	System.out.println("end of hash table");
	System.out.println();
	}

	public void DoubleHashFunction(String[] stringsForArray, String[] theArray)
	{
		for (int n = 0; n < stringsForArray.length; n++)
		{
			String newElementVal = stringsForArray[n];
			int arrayindex = Integer.parseInt(newElementVal) % arrayLength;
			int step = 7 - (Integer.parseInt(newElementVal) % 7);
			System.out.println("step distance: " + step);

			while (theArray[arrayindex] != "-1")
			{
				arrayindex += step;
				arrayindex %= arrayLength;
			}
			theArray[arrayindex] = newElementVal;
		}
	}



	public static void main(String [] args){

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

			String num;
			String inputOp;
			String convert;
			
			//array with split inputs, space is the delimite			
			String[] sepArray = inVal.split("\\s+");
			convert = sepArray[0];
            int max = Integer.parseInt(convert); // N value
			DoubleHash dh = new DoubleHash(max);
			
			//for(int i=0; i<sepArray.length; i++){
				//System.out.println(sepArray[i]);
			//}
		   
			// iterate through input array and operations
			for(int i=1; i<sepArray.length; i++){
				inputOp = sepArray[i];
				num = hashCompute(inputOp);
				if (dh.items != max){
					if(inputOp.endsWith(".in")){ 
							dh.printList();
							dh.insert(num);
							dh.printList();
					}
					else if(inputOp.endsWith(".del")){
						dh.printList();
						dh.delete(num);
						dh.printList();
					}
					else if(inputOp.endsWith(".sch")){ 
						boolean found = dh.search(num);
						if (found == true){
							System.out.println("found: " + num);
							System.out.println();
						}
						else{
							System.out.println("not found : "+num);
							System.out.println();
						}
					}
				}
				else{
					break;
				}
			}
		}catch (FileNotFoundException ex){System.out.println("file not found");}
	}
}
