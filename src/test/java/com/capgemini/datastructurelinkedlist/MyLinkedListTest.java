package com.capgemini.datastructurelinkedlist;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class MyLinkedListTest {
	
	private MyNode<Integer> firstNode;
	private MyNode<Integer> secondNode;
	private MyNode<Integer> thirdNode;
	private MyLinkedList myLinkedList;
	
	@Before
	public void setup() {
	firstNode = new MyNode<Integer>(56);
	secondNode = new MyNode<Integer>(30);
	thirdNode = new MyNode<Integer>(70);
	myLinkedList = new MyLinkedList();
	}

	@Test
	public void given3Number_WhenLinked_ShouldLinkLikeLinkedList() {
		firstNode.setNext(secondNode);
		secondNode.setNext(thirdNode);
		boolean result = firstNode.getNext().equals(secondNode) && secondNode.getNext().equals(thirdNode);
		assertTrue(result);
	}
	
	@Test
	public void given3Numbers_WhenAdded_ShouldAddOnTheTop() {
		MyNode<Integer> firstNode = new MyNode<Integer>(70);
		MyNode<Integer> secondNode = new MyNode<Integer>(30);
		MyNode<Integer> thirdNode = new MyNode<Integer>(56);
		myLinkedList.add(firstNode);
		myLinkedList.add(secondNode);
		myLinkedList.add(thirdNode);
		myLinkedList.printLinkedList();
		boolean result = myLinkedList.getHead().equals(thirdNode) && myLinkedList.getHead().getNext().equals(secondNode)
				&& myLinkedList.getTail().equals(firstNode);
		assertTrue(result);
	}
	
	@Test
	public void given3Numbers_WhenAppended_ShouldBeAddedToLast() {
		myLinkedList.add(firstNode);
		myLinkedList.append(secondNode);
		myLinkedList.append(thirdNode);
		myLinkedList.printLinkedList();
		boolean result = myLinkedList.getHead().equals(firstNode) && myLinkedList.getHead().getNext().equals(secondNode)
				&& myLinkedList.getTail().equals(thirdNode);
		assertTrue(result);
	}
	
	@Test
	public void given3Numbers_WhenInsertingSecondInBetween_ShouldAddInBetween() {
		myLinkedList.add(firstNode);
		myLinkedList.append(thirdNode);
		myLinkedList.insert(firstNode, secondNode);
		myLinkedList.printLinkedList();
		boolean result = myLinkedList.getHead().equals(firstNode) && myLinkedList.getHead().getNext().equals(secondNode)
				&& myLinkedList.getTail().equals(thirdNode);
		assertTrue(result);
	}
	
	@Test
	public void given3Numbers_WhenPoped_ShouldRemoveTheHeadNode() {
		myLinkedList.add(firstNode);
		myLinkedList.append(thirdNode);
		myLinkedList.insert(firstNode, secondNode);
		MyNode<Integer> myNode = (MyNode<Integer>) myLinkedList.pop();
		myLinkedList.printLinkedList();
		boolean result = myLinkedList.getHead().equals(secondNode) && myLinkedList.getTail().equals(thirdNode);
		assertTrue(result);
		assertEquals(firstNode, myNode);
	}
	
	@Test
	public void given3Numbers_WhenPopedLast_ShouldRemoveTheTailNode() {
		myLinkedList.add(firstNode);
		myLinkedList.append(thirdNode);
		myLinkedList.insert(firstNode, secondNode);
		MyNode<Integer> myNode = (MyNode<Integer>) myLinkedList.popLast();
		System.out.println(myNode.getKey());
		myLinkedList.printLinkedList();
		boolean result = myLinkedList.getHead().equals(firstNode) && myLinkedList.getTail().equals(secondNode);
		assertEquals(thirdNode, myNode);
		assertTrue(result);
	}
}