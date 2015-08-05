package com.prabhash.java.interview.ch2;

public class ConvertLinkedListToNumber {
	
	/**
	 * Convert a number represented as Linked List to an integer.
	 * 
	 * @param root
	 * @return valueAsInt
	 */
	public static int getValueFromList(LinkedListImpl.Node root) {
		
	    if (root == null){
	        return 0;
	    }
	    
	    int valueAsInt = 0;
	    
	    LinkedListImpl.Node tempRoot = root;
	    
	    while (tempRoot != null) {
	    	
	        valueAsInt = valueAsInt * 10;
	        valueAsInt = valueAsInt + tempRoot.getData();
	        tempRoot = tempRoot.getNext();
	        
	    }
	    
	    return valueAsInt;
	    
	}

	/**
	 * Parse given integer and convert that to a Linked List. 
	 * 
	 * @param num
	 * @return listToReturn
	 */
	public static LinkedListImpl.Node convertNumberToList(int num) {
		
		LinkedListImpl.Node listToReturn = null;

		while (num != 0) {
			
			int lastPlaceValue = num % 10;
			
			num /= 10;
			
			LinkedListImpl.Node currNode = new LinkedListImpl.Node(lastPlaceValue);

			if (listToReturn == null) {
				listToReturn = currNode;
			}
			else {
				//List not empty
				currNode.setNext(listToReturn);
				listToReturn = currNode;
			}

		}
		return listToReturn;  

	}
	
	public static void main(String[] args) {
		
		LinkedListImpl ll = new LinkedListImpl();
		
		ll.addNode(4);
		ll.addNode(5);
		ll.addNode(8);
		
		int num = getValueFromList(ll.getHead());
		System.out.println("Number is: " + num);
		
		LinkedListImpl.Node convertedLL = convertNumberToList(num);
		
		System.out.println("\nHere is the Linked List:");
		LinkedListImpl.prettyPrintLinkedList(convertedLL);
		
	}

}
