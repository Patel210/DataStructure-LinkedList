package com.capgemini.datastructurelinkedlist;

public class MyNode<K extends Comparable> implements INode<K> {
	private K key;
	private INode next;

	public MyNode(K key) {
		this.key = key;
		this.next = null;
	}

	public INode getNext() {
		return next;
	}

	public void setNext(INode next) {
		this.next = next;
	}

	@Override
	public K getKey() {
		return key;
	}

	@Override
	public void setKey(K key) {
		this.key = key;
	}
}
