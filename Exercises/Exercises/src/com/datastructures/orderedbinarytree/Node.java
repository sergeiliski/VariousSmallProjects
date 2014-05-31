package com.datastructures.orderedbinarytree;

public class Node {

	private Node leftNode, rightNode;
	private int data;

	public Node(int data) {
		this.data = data;
		leftNode = rightNode = null;
	}

	public void setLeftNode(Node leftNode) {
		this.leftNode = leftNode;
	}

	public void setRightNode(Node rightNode) {
		this.rightNode = rightNode;
	}

	public void setData(int data) {
		this.data = data;
	}

	public Node getLeftNode() {
		return leftNode;
	}

	public Node getRightNode() {
		return rightNode;
	}

	public int getData() {
		return data;
	}
}
