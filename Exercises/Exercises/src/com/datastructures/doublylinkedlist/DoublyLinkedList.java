package com.datastructures.doublylinkedlist;

public class DoublyLinkedList {

	private Node firstNode;
	private Node lastNode;
	private int listSize;

	public DoublyLinkedList() {
		this.firstNode = null;
		this.lastNode = null;
		listSize = 0;
	}

	public boolean isEmpty() {
		return (listSize == 0);
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

	public void drawList() {

		if (listSize == 0) {
			System.out.print("This list is empty...");
		} else {
			Node currentNode = firstNode;

			while (currentNode != null) {
				System.out.print(currentNode.getData() + ", ");
				currentNode = currentNode.getNextNode();
			}

		}
	}

	public void add(Object data) {
		Node newNode = new Node(data);
		newNode.setNext(null);

		if (firstNode == null) {
			firstNode = newNode;
		} else {
			Node oldLastNode = lastNode;
			oldLastNode.setNext(newNode);
			newNode.setPrev(oldLastNode);
		}

		lastNode = newNode;
		listSize++;
	}

	public void addFront(Object data) {
		Node node = new Node(data);
		node.setPrev(null);

		if (firstNode == null) {
			firstNode = node;
		} else {
			Node tempNode = firstNode;
			firstNode = node;
			node.setNext(tempNode);
		}

		listSize++;
	}

	public void removeFront() {
		if (firstNode != null) {
			firstNode = firstNode.getNextNode();
			listSize--;
		}
	}

	public void removeLast() {
		Node currentNode = firstNode;
		while (currentNode != null) {
			if (currentNode.getNextNode() == null) {
				lastNode = currentNode.getPrevNode();
				lastNode.setNext(null);
				currentNode = null;
			} else {
				currentNode = currentNode.getNextNode();
			}
		}
		listSize--;
	}

	public void removeNode(Object data, int occurrence) {
		Node currentNode = firstNode;
		int occ = 0;

		while (currentNode != null) {
			if (currentNode.getData().equals(data)) {
				occ++;
			}

			if (occ == occurrence) {
				Node nextNode = currentNode.getNextNode();
				Node prevNode = currentNode.getPrevNode();
				prevNode.setNext(nextNode);
				break;
			}

			currentNode = currentNode.getNextNode();
		}

		listSize--;
	}

	public void insertNodeAfter(Object previousNode, int occurrence, Object data) {
		Node currentNode = firstNode;
		int occ = 0;

		while (currentNode != null) {
			if (currentNode.getData().equals(previousNode)) {
				occ++;
			}
			if (occ == occurrence) {
				Node newNode = new Node(data);
				newNode.setNext(currentNode.getNextNode());
				newNode.setPrev(currentNode.getPrevNode());
				currentNode.setNext(newNode);
				break;
			}
			currentNode = currentNode.getNextNode();
		}

		listSize++;
	}

}
