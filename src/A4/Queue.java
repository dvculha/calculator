// Dafne Culha - 260785524 - ECSE 202 Assignment 4

package A4;

public class Queue {

	listNode front;
	listNode back;

	// A method to determine if the queue is empty or not.
	// Returns true if empty, false if not.
	public boolean isEmpty() {

		if(front == null)
			return true;
		else
			return false;
	}


	// A method to add a data to the back of the queue.
	public void enqueue (String data) {

		listNode newNode = new listNode(data);

		// If the queue is empty front item and back item are both the newNode.
		if(isEmpty()) {
			front = newNode;
			back = newNode;
		}

		// If the queue is not empty, the old back of the queue will be the one before the newNode
		// And newNode will be the new back of the queue.
		else {
			back.next = newNode;
			back = newNode;
		}
	}

	public String dequeue () {

		// If the queue is empty, just return "-1".
		if(isEmpty()) 
			return "-1";

		// If not empty, return the first item of the queue (front item)
		// and remove front node, make the next item in queue the new front item.
		else {
			String frontData = front.data;
			front = front.next;
			return frontData;
		}
	}
}

