// Dafne Culha - 260785524 - ECSE 202 Assignment 4

package A4;

public class Stack {

	listNode top = null;

	// A method to store data in the order they are put into the stack. 
	public void push (String data) {

		// If stack is empty, the top of the stack will just be a new node.
		if (top==null) {

			top = new listNode (data);	
		}

		// If it is not empty, the previous top of the stack will be "pushed" 
		// so the new node will be the new top of the stack.
		else {
			listNode node = new listNode (data);
			node.next= top;
			top = node;	
		}
	}

	// A method to pop the data in the reverse order they were pushed.
	public String pop () {

		// If the stack is empty, just return null.
		if (top==null) { 
			return null;
		}

		// If it is not empty, the top of the stack will be "popped" and returned.
		// And the new top will be the node "pushed" before the old top.
		else {
			String str = top.data;
			top= top.next;
			return str;
		}
	}
}


