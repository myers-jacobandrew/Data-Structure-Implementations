/*

Jacob Myers
maxHeap.java

max heap implementation,

reads in a user's input file, with following format "pre|post|in 1.in 3.in 5.in del 6.in 7.in del"

will display heap before and after insertion and deletion
*/

import java.util.*;
import java.io.*;
public class maxHeap{
	public ArrayList <Integer> heapList;

  public maxHeap(){  
   	heapList = new ArrayList<Integer>();
  }

  public void siftUp(){
    int index = heapList.size() - 1;
      while (index > 0) {
        int parentIndex = (index-1)/2;
        int i = (int)heapList.get(index);
        int parent = (int)heapList.get(parentIndex);
        if (i > parent) {

					heapList.set(index, parent);
          heapList.set(parentIndex, i);

					index = parentIndex;
        }
        else {
          break;
        }
      }
  }
  public void insertHeap(int i) {
    heapList.add(i);
    siftUp();
  }
  public void siftDown() {
    int index = 0;
    int left = 2*index+1;
    while (left < heapList.size()) {
      int max = left, right = left + 1;
      if (right < heapList.size()) {
      if (heapList.get(right).compareTo(heapList.get(left)) > 0) {
        max++;
      }
    }
    if (heapList.get(index).compareTo(heapList.get(max)) < 0) {
      int temp = (int)heapList.get(index);
      heapList.set(index, heapList.get(max));
      heapList.set(max, temp);
      index = max;
      left = 2*index+1;
    }
    else {
      break;
    }
  }
}
  public int delete()
    throws NoSuchElementException {
      if (heapList.size() == 0) {
        throw new NoSuchElementException();
      }
      if (heapList.size() == 1) {
        return heapList.remove(0);
      }
      int hold = heapList.get(0);
      heapList.set(0, heapList.remove(heapList.size()-1));
      siftDown();
      return hold;
    }


  //pre order function
  public void preOrder(int count) {
    if (heapList.size() == 0) {
      System.out.println("the heap has no elements");
      return;
    }
    if (count >= heapList.size())
    return;
    System.out.println(heapList.get(count));
    preOrder(2*count+1);
    preOrder(2*count+2);
  }
  //in order function
	public void inOrder(int count){
		if(heapList.size()==0){
			System.out.println("the heap has no elements");
			return;
		}
		if(count >= heapList.size()) return;
		inOrder(2*count+1);
		System.out.println(heapList.get(count));
		inOrder(2*count+2);
	}
	//post order function
	public void postOrder(int count){
		if(heapList.size()==0){
			System.out.println("the heap has no elements");
			return;
		}
		if(count >= heapList.size()) return;
		postOrder(2*count+1);
		postOrder(2*count+2);
		System.out.print(heapList.get(count));
	}


	public static void main(String[] args) {
		maxHeap newheapList = new maxHeap();

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
			for(int i=0; i<sepArray.length; i++){
			//	System.out.println(sepArray[i]);
			}
			int num = 0;
			String travel = sepArray[0];
			System.out.println(travel);

			//check opereation and then travel type : pre, post or in,
			for(int i=1; i < sepArray.length; i++){
				//System.out.println(sepArray[i]);
				inputOp = sepArray[i];
				//checks if inputOp is an insert
				if(inputOp.endsWith(".in")){
					inputOp = inputOp.replace(".in","");
					num = Integer.parseInt(inputOp);
					if(travel.contains("pre")){
						System.out.println("trying to insert "+ num + "\ncurrent heap before insertion:");
						newheapList.preOrder(0);
						newheapList.insertHeap(num);
						System.out.println("after insertion: ");
						newheapList.preOrder(0);
					}
					else if(travel.contains("post")){
						System.out.println("trying to insert "+ num + "\ncurrent heap before insertion:");
						newheapList.postOrder(0);
						newheapList.insertHeap(num);
						System.out.println("after insertion: ");
						newheapList.postOrder(0);
					}
					else if(travel.contains("in")){
						System.out.println("trying to insert "+ num + "\ncurrent heap before insertion:");
						newheapList.inOrder(0);
						newheapList.insertHeap(num);
						System.out.println("after insertion: ");
						newheapList.inOrder(0);
					}
				}

				//checks for del in inputOp
				else if(inputOp.equals("del")){
					if(travel.contains("pre")){
						System.out.println("before deletion: ");
						newheapList.preOrder(0);
						newheapList.delete();
						System.out.println("after deletion: ");
						newheapList.preOrder(0);
					}
					else if(travel.contains("post")){
						System.out.println("before deletion: ");
						newheapList.postOrder(0);
						newheapList.delete();
						System.out.println("after deletion: ");
						newheapList.postOrder(0);
					}
					else if(travel.contains("in")){
						System.out.println("before deletion: ");
						newheapList.inOrder(0);
						newheapList.delete();
						System.out.println("after deletion: ");
						newheapList.inOrder(0);
					}
				}

			}
		}catch (FileNotFoundException ex){System.out.println("file not found");}
	}
}