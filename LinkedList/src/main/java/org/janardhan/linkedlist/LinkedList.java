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
	 * This method inserts a new node at the beginning of the list
	 * 
	 * @param data
	 */
	public void insertAtBeginning(T data) {

		// if no node is present create a new node and make it head node
		if (head == null) {
			Node<T> node = new Node<T>();
			node.setData(data);
			node.setNext(null);
			head = node;

		}
		// Create a new node and point it to head and then make this node head
		// node
		else {
			Node<T> node = new Node<T>();
			node.setData(data);
			node.setNext(head);
			head = node;
		}

		size++; // increment size
	}

	/**
	 * This method inserts a new node at the end of the list
	 * 
	 * @param data
	 */
	public void insertAtEnd(T data) {

		// if list is empty, create a new node and mark it as head node
		if (head == null) {
			Node<T> node = new Node<T>();
			node.setData(data);
			node.setNext(null);
			head = node;

		} else {
			Node<T> node = new Node<T>();
			node.setData(data);
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
}
