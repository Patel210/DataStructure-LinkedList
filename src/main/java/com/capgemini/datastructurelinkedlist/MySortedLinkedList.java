package com.capgemini.datastructurelinkedlist;

public class MySortedLinkedList<K extends Comparable> {

	private INode head;
	private INode tail;

	public MySortedLinkedList() {
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
	 * Add element in the sorted linked list
	 */

	public void addElementInOrder(INode newNode) {
		int size = size();

		if (size == 0) {
			head = newNode;
			tail = newNode;
		}
		else if (size == 1) {
			if (head.getKey().compareTo(newNode.getKey()) == 1) {
				INode tempNode = head;
				head = newNode;
				head.setNext(tempNode);

			}
			if (head.getKey().compareTo(newNode.getKey()) == -1) {
				tail.setNext(newNode);
				tail = newNode;
			}
		} 
		else {
			INode pointer1 = head;
			INode pointer2 = head.getNext();
			while (pointer2 != null) {
				if ((pointer1.getKey()).compareTo(newNode.getKey()) == -1
						&& pointer2.getKey().compareTo(newNode.getKey()) == 1) {
					pointer1.setNext(newNode);
					newNode.setNext(pointer2);
					break;
				}
				pointer2 = pointer2.getNext();
				pointer1 = pointer1.getNext();

				if (pointer1 == tail) {
					tail.setNext(newNode);
					tail = newNode;
				}
			}
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
	 * @param key Searching node with particular key
	 * @return
	 */
	public INode search(K key) {
		INode myNode = null;
		INode tempNode = head;
		while (tempNode != null) {
			if (tempNode.getKey().equals(key)) {
				myNode = tempNode;
				break;
			}
			tempNode = tempNode.getNext();
		}
		return myNode;
	}

	/**
	 * @param key    To insert an element after some element in the list
	 * @param newKey
	 */
	public void insertAfterParticularElementUsingKeys(K key, K newKey) {
		INode myNode = search(key);
		if (myNode != null) {
			insert(myNode, new MyNode<>(newKey));
		} else {
			System.out.println("Cannot add as no node, by this key, present in the list");
		}
	}

	/**
	 * @param key To Delete particular element from the Linked List
	 * @return
	 */
	public boolean deleteAnElement(K key) {
		INode myNode = search(key);
		if (myNode != null) {
			INode tempNode = head;
			while (tempNode != tail) {
				if (tempNode.getNext().equals(myNode)) {
					INode temp = tempNode.getNext();
					tempNode.setNext(temp.getNext());
					break;
				} else {
					tempNode = tempNode.getNext();
				}
			}
			return true;
		} else {
			return false;
		}
	}

	/**
	 * To get the size of the Linked List
	 */
	public int size() {
		INode tempNode = head;
		if (head == null) {
			return 0;
		} else {
			int count = 1;
			while (tempNode != tail) {
				count++;
				tempNode = tempNode.getNext();
			}
			return count;
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
