package com.capgemini.datastructurelinkedlist;

public class MyLinkedList {

	private INode head;
	private INode tail;

	public MyLinkedList() {
		this.head = null;
		this.tail = null;
	}

	public INode getHead() {
		return head;
	}

	public void setHead(INode head) {
		this.head = head;
	}

	public INode getTail() {
		return tail;
	}

	public void setTail(INode tail) {
		this.tail = tail;
	}

	/**
	 * Add element in the linked list
	 */
	public void add(INode newNode) {
		if (head == null) {
			head = newNode;
			tail = newNode;
		} else {
			INode tempNode = this.getHead();
			this.setHead(newNode);
			this.getHead().setNext(tempNode);
		}
	}

	/**
	 * Appending element in the list
	 */
	public void append(INode newNode) {
		if (head == null) {
			this.head = newNode;
		}
		if (tail == null) {
			this.tail = newNode;
		} else {
			tail.setNext(newNode);
			tail = newNode;
		}
	}

	/**
	 * @param myNode
	 * @param newNode To insert an element between two elements
	 */
	public void insert(INode myNode, INode newNode) {
		INode tempNode = myNode.getNext();
		myNode.setNext(newNode);
		newNode.setNext(tempNode);
	}

	/**
	 * Remove the element at head
	 */
	public INode pop() {
		INode tempNode = head;
		head = head.getNext();
		return tempNode;
	}

	/**
	 * Remove the element at tail
	 */
	public INode popLast() {
		INode tempNode = head;
		while (!tempNode.getNext().equals(tail)) {
			tempNode = tempNode.getNext();
		}
		tail = tempNode;
		tempNode = tempNode.getNext();
		tail.setNext(null);
		return tempNode;
	}

	/**
	 * To print the linked list
	 */
	public void printLinkedList() {
		StringBuffer myNodes = new StringBuffer("My Nodes: ");
		INode tempNode = this.getHead();
		while (tempNode.getNext() != null) {
			myNodes.append(tempNode.getKey());
			if (!tempNode.equals(getTail())) {
				myNodes.append("->");
			}
			tempNode = tempNode.getNext();
		}
		myNodes.append(tempNode.getKey());
		System.out.println(myNodes);
	}
}
