package com.datastructures.orderedbinarytree;

public class BinaryTree {

	private Node root;

	public void insert(int data) {
		if (root == null) {
			root = new Node(data);
		} else {
			insert(data, root);
		}
	}

	public void insert(int data, Node node) {
		if (data <= node.getData()) { // Inserting in left node
			if (node.getLeftNode() == null) { // Checks whether a left node
												// exists
				node.setLeftNode(new Node(data));
			} else { // If it exists, go deeper inside the left side
				insert(data, node.getLeftNode());
			}
		} else if (data > node.getData()) { // Inserting in right node
			if (node.getRightNode() == null) { // Checks whether a right node
												// exists
				node.setRightNode(new Node(data));
			} else { // If it exists, go deeper inside the right tree
				insert(data, node.getRightNode());
			}
		}
	}

	public void preorderTraversal() {
		preorderHelper(root);
	}

	public void inorderTraversal() {
		inorderHelper(root);
	}

	public void postorderTraversal() {
		postorderHelper(root);
	}

	private void preorderHelper(Node node) {
		if (node != null) {
			System.out.print(node.getData() + " ");
			preorderHelper(node.getLeftNode());
			preorderHelper(node.getRightNode());
		}
	}

	private void inorderHelper(Node node) {
		if (node != null) {
			inorderHelper(node.getLeftNode());
			System.out.print(node.getData() + " ");
			inorderHelper(node.getRightNode());
		}
	}

	private void postorderHelper(Node node) {
		if (node != null) {
			postorderHelper(node.getLeftNode());
			postorderHelper(node.getRightNode());
			System.out.print(node.getData() + " ");
		}
	}
}
