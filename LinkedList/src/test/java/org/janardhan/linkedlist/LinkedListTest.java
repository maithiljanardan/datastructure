package org.janardhan.linkedlist;

import org.junit.Test;

public class LinkedListTest {

	public static void main(String[] args) {
		LinkedList<Integer> list = new LinkedList<Integer>();

		list.insertAtBeginning(4);
		System.out.println(list);
		list.insertAtBeginning(10);
		list.insertAtEnd(45);
		list.printList();
	}

}
