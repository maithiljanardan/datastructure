package org.janardhan.linkedlist;

import org.janardhan.node.Node;

public class LinkedList<T> {

	private Node<T> head;
	private int size;

	public LinkedList() {
		this.head = null;
		this.size = 0;
	}

	/**
	 * This method inserts a new node at the beginning of the list.
	 * 
	 * If the linked list is empty, a new node is created and make the head node.
	 * Otherwise a new node is created and made head which now points to previous
	 * head node.
	 * 
	 * 
	 * @param data
	 *            is the data that the node will store
	 * @author janardhan
	 */
	public void insertAtBeginning(T data) {

		Node<T> node = new Node<T>();
		node.setData(data);

		// if no node is present create a new node and make it head node
		if (head == null) {
			node.setNext(null);
			head = node;

		}
		// Create a new node and point it to head and then make this node head
		// node
		else {
			node.setNext(head);
			head = node;
		}

		size++; // increment size
	}

	/**
	 * This method inserts a new node at the end of the list.
	 * 
	 * If the list is empty, creates a head node. Otherwise traverses to the last
	 * node and inserts a new node
	 * 
	 * @param data
	 */
	public void insertAtEnd(T data) {

		Node<T> node = new Node<T>();
		node.setData(data);

		// if list is empty, create a new node and mark it as head node
		if (head == null) {
			node.setNext(null);
			head = node;

		} else {
			Node<T> lastNode = head;

			while (lastNode.getNext() != null)
				lastNode = lastNode.getNext();

			lastNode.setNext(node);
			node.setNext(null);
		}
		size++;
	}

	/**
	 * This method insets a new node at some position
	 * 
	 * @param position
	 * @param data
	 */
	public void insertAtPosition(int position, T data) {

		Node<T> node = new Node<T>();
		node.setData(data);
		node.setNext(null);

		Node<T> temp = head;
		int pointer = 1;

		if (head == null) {
			head = node;
		}
		if (position == 1) {
			node.setNext(head);
			head = node;
		} else {

			while (pointer < position - 1 && pointer < size) {

				temp = temp.getNext();
				++pointer;
			}
			node.setNext(temp.getNext());
			temp.setNext(node);
		}

		size++;
	}

	/**
	 * This methods deletes a node present at a position
	 * 
	 * @param position
	 */
	public void deleteAtPosition(int position) {

		Node<T> tempNode = head;
		Node<T> previousNode = null;

		if (position == 1) {
			head = tempNode.getNext();
		} else {
			for (int i = 1; i < position; i++) {
				previousNode = tempNode;
				tempNode = tempNode.getNext();
			}
			previousNode.setNext(tempNode.getNext());
		}
		size--;
	}

	/**
	 * This method deletes the head node
	 * 
	 * @return
	 */
	public T deleteAtBeginning() {

		Node<T> tempNode = head;
		head = tempNode.getNext();

		return tempNode.getData();
	}

	/**
	 * This method returns the position of element to be searched
	 * 
	 * @param node
	 * @param data
	 * @return
	 */

	public int searchNode(Node<T> node, T data) {

		// Code to prevent the loop to go into eternity still need to be written
		if (node == null)
			node = head;
		if (node.getData() == data)
			return 1;
		return 1 + searchNode(node.getNext(), data);

	}

	/**
	 * Function to swap Nodes x and y in linked list by changing links
	 * 
	 * @param x
	 * @param y
	 */

	public void swapNodes(T x, T y) {

		// Nothing to do if x and y are same
		if (x == y)
			return;

		// Search for x (keep track of prevX and CurrX)
		Node<T> prevX = null, currX = head;
		while (currX != null && currX.getData() != x) {
			prevX = currX;
			currX = currX.getNext();
		}

		// Search for y (keep track of prevY and currY)
		Node<T> prevY = null, currY = head;
		while (currY != null && currY.getData() != y) {
			prevY = currY;
			currY = currY.getNext();
		}

		// If either x or y is not present, nothing to do
		if (currX == null || currY == null)
			return;

		// If x is not head of linked list
		if (prevX != null)
			prevX.setNext(currY);
		else // make y the new head
			head = currY;

		// If y is not head of linked list
		if (prevY != null)
			prevY.setNext(currX);
		else // make x the new head
			head = currX;

		// Swap next pointers
		Node<T> temp = currX.getNext();
		currX.setNext(currY.getNext());
		currY.setNext(temp);
	}

	public T GetNth(int index) {
		T t = null;
		Node<T> current = head;
		int count = 0; /*
						 * index of Node we are currently looking at
						 */
		while (current != null) {
			if (count == index)
				return current.getData();
			count++;
			current = current.getNext();
		}

		/*
		 * if we get to this line, the caller was asking for a non-existent element so
		 * we assert fail
		 */
		assert (false);
		return t;
	}

	/**
	 * 
	 * Function to print middle of linked list
	 * 
	 */
	public void printMiddle() {

		Node<T> slow_ptr = head;
		Node<T> fast_ptr = head;

		if (head != null) {

			while (fast_ptr != null && fast_ptr.getNext() != null) {

				fast_ptr = fast_ptr.getNext().getNext();
				slow_ptr = slow_ptr.getNext();
			}

			System.out.println("The middle element is [" + slow_ptr.getData() + "] \n");
		}
	}

	/**
	 * Function to get the nth node from the last of a linked list
	 * 
	 * @param n
	 */
	public void printNthFromLast(int n) {

		int len = 0;

		Node<T> temp = head;

		// 1) count the number of nodes in Linked List
		while (temp != null) {

			temp = temp.getNext();
			len++;
		}

		// check if value of n is not more than length of
		// the linked list
		if (len < n)
			return;

		temp = head;

		// 2) get the (n-len+1)th node from the begining
		for (int i = 1; i < len - n + 1; i++)
			temp = temp.getNext();

		System.out.println(temp.getData());
	}

	/**
	 * Function deletes the entire linked list
	 */
	public void deleteList() {
		head = null;
	}

	/**
	 * Counts the no. of occurences of a node (search_for) in a linked list (head)
	 */
	public int count(T search_for) {

		Node<T> current = head;
		int count = 0;
		while (current != null) {
			if (current.getData() == search_for)
				count++;
			current = current.getNext();
		}
		return count;
	}

	/**
	 * 
	 * @param node
	 * @return
	 */
	public Node<T> reverseList(Node<T> node) {

		Node<T> prev = null;
		Node<T> current = node;
		Node<T> next = null;

		while (current != null) {

			next = current.getNext();
			current.setNext(prev);
			prev = current;
			current = next;
		}
		node = prev;
		return node;
	}

	/*
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 */
	public void printList() {
		Node<T> node = head;
		System.out.print(node.getData() + " ");
		while (node.getNext() != null) {
			System.out.print(node.getNext().getData() + " ");
			node = node.getNext();

		}
	}

	@Override
	public String toString() {
		Node<T> node = head;

		StringBuffer sBuffer = new StringBuffer("");
		while (node.getNext() != null) {
			sBuffer.append(node.getData());
			node = node.getNext();
		}

		return sBuffer.toString();

	}

}
