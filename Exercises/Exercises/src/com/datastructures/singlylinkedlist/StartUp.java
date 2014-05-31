package com.datastructures.singlylinkedlist;

public class StartUp {

	public static void main(String[] args) {
		System.out.println("Singly linked list:\n");

		SinglyLinkedList list = new SinglyLinkedList();

		if (list.isEmpty()) {
			System.out.println("The list is empty.");
		}

		System.out.println("Adding the following data: 5, 9, 2, 3, 1, 0, 3, 5, 6");
		list.addLast(5);
		list.addLast(9);
		list.addLast(2);
		list.addLast(3);
		list.addLast(1);
		list.addLast(0);
		list.addLast(3);
		list.addLast(5);
		list.addLast(6);

		System.out.print("Current list: ");
		list.drawList();

		System.out.print("\nSize of the current list: " + list.getListSize());

		System.out.print("\nRemoving the first node: ");
		list.deleteFront();
		list.drawList();

		System.out.print("\nRemoving the last node: ");
		list.deleteLast();
		list.drawList();

		System.out.print("\nSize of the current list: " + list.getListSize());

		System.out.print("\nInserting node after the Nth node: ");
		list.insertNodeAfter(3, 2, 99);
		list.drawList();

		System.out.print("\nInserting string node within a list of integer nodes: ");
		list.insertNodeAfter(2, 1, "test");
		list.drawList();
	}
}
