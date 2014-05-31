package com.datastructures.singlylinkedlist;

public class Node {

	private Node nextNode;
	private Object data;

	public Node(Object data) {
		this.data = data;
	}

	public Node(Object data, Node nextNode) {
		this(data);
		this.nextNode = nextNode;
	}

	public void setNext(Node nextNode) {
		this.nextNode = nextNode;
	}

	public Node getNextNode() {
		return nextNode;
	}

	public Object getData() {
		return data;
	}
}
