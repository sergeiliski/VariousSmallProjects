package com.datastructures.singlylinkedlist;

public class SinglyLinkedList {

	private Node firstNode;
	private Node lastNode;
	private int listSize;

	public SinglyLinkedList() {
		firstNode = null;
		lastNode = null;
		listSize = 0;
	}

	public boolean isEmpty() {
		return (firstNode == null);
	}

	public Node getFirstNode() {
		return firstNode;
	}

	public Node getLastNode() {
		return lastNode;
	}

	public int getListSize() {
		return listSize;
	}

	public void addFront(Object data) {
		Node node = new Node(data);

		if (firstNode == null) {
			node.setNext(null);
			lastNode = node;
		} else {
			node.setNext(firstNode);
		}

		firstNode = node;
		listSize++;
	}

	public void addLast(Object data) {
		Node node = new Node(data);
		node.setNext(null);

		if (firstNode == null) {
			firstNode = node;
		} else {
			lastNode.setNext(node);
		}

		lastNode = node;
		listSize++;
	}

	public void deleteFront() {
		if (firstNode != null) {
			Node deletedNode = firstNode;
			firstNode = deletedNode.getNextNode();
			deletedNode = null;
			listSize--;
		}
	}

	public void deleteLast() {
		if (lastNode != null) {
			Node currentNode = firstNode;
			Node nextNode = currentNode.getNextNode();
			Node nextNextNode = null;

			while (currentNode != null) {
				nextNode = currentNode.getNextNode();

				if (nextNode != null) {
					nextNextNode = nextNode.getNextNode();

					if (nextNextNode == null) {
						lastNode = currentNode;
						currentNode.setNext(null);
					}
				}
				currentNode = nextNode;
			}
			listSize--;
		}
	}

	public void drawList() {
		if (listSize == 0) {
			System.out.println("The list is empty...");
		} else {
			Node currentNode = firstNode;

			while (currentNode != null) {
				System.out.print(currentNode.getData() + ", ");
				currentNode = currentNode.getNextNode();
			}
		}
	}

	public void insertNodeAfter(Object nodeBefore, int occurrence, Object data) {
		Node currentNode = firstNode;

		while (currentNode != null) {
			if (currentNode.getData().equals(nodeBefore)) {
				occurrence--;
			}
			if (occurrence == 0) {
				Node newNode = new Node(data, currentNode.getNextNode());
				currentNode.setNext(newNode);
				break;
			}
			currentNode = currentNode.getNextNode();
		}
		listSize++;
	}

}
