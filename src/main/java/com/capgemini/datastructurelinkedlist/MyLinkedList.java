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
	 * @param newNode To add elements in the linked list
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