package com.capgemini.datastructurelinkedlist;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class MyLinkedListTest {

	private MyNode<Integer> firstNode;
	private MyNode<Integer> secondNode;
	private MyNode<Integer> thirdNode;
	private MySortedLinkedList<Integer> mySortedLinkedList;

	@Before
	public void setup() {
		firstNode = new MyNode<Integer>(56);
		secondNode = new MyNode<Integer>(30);
		thirdNode = new MyNode<Integer>(70);
		mySortedLinkedList = new MySortedLinkedList<Integer>();
	}

	@Test
	public void WhenAddedRandomly_ShouldGetAddedInOrderTest() {
		mySortedLinkedList.addElementInOrder(firstNode);
		mySortedLinkedList.addElementInOrder(secondNode);
		mySortedLinkedList.addElementInOrder(new MyNode<Integer>(40));
		mySortedLinkedList.addElementInOrder(thirdNode);
		mySortedLinkedList.printLinkedList();
		assertEquals(4, mySortedLinkedList.size());
		boolean result = mySortedLinkedList.getHead().equals(secondNode)
						&& mySortedLinkedList.getHead().getNext().getKey().equals(40)
						&& mySortedLinkedList.getHead().getNext().getNext().equals(firstNode)
						&& mySortedLinkedList.getTail().equals(thirdNode);
		assertTrue(result);

	}
}