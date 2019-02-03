// Dafne Culha- 260785524 - ECSE 202 Assignment 4

package A4;

public class listNode {

	// A class for storing string datas. Has 2 data fields for the data and the link to
	// the next node in the list and has three constructors.

	public String data;    // data stored in this node
	public listNode next;  // link to next node in the list

	// Constructor 1: public ListNode() which creates node with data "", null link
	public listNode() {
		this ("", null);
	}

	// Constructor 2: public ListNode (String data) which creates node with given data, null link
	public listNode (String data) {
		this (data, null);
	}

	// Constructor 3: public ListNode(int data, ListNode next) which creates node with given data and given link
	public listNode (String data, listNode next) {
		this.data = data;
		this.next = next;
	}
}
