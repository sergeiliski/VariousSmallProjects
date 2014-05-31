package com.datastructures.doublylinkedlist;

public class Node {

	private Node prevNode;
	private Node nextNode;
	private Object data;

	public Node(Object data) {
		this.data = data;
	}

	public Node(Object data, Node prevNode, Node nextNode) {
		this(data);
		this.prevNode = prevNode;
		this.nextNode = nextNode;
	}

	public void setNext(Node nextNode) {
		this.nextNode = nextNode;
	}

	public void setPrev(Node prevNode) {
		this.prevNode = prevNode;
	}

	public Node getNextNode() {
		return nextNode;
	}

	public Node getPrevNode() {
		return prevNode;
	}

	public Object getData() {
		return data;
	}
}
