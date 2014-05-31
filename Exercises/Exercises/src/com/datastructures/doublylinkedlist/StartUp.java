package com.datastructures.doublylinkedlist;

public class StartUp {

	public static void main(String[] args) {
		System.out.println("Doubly linked list:\n");

		DoublyLinkedList list = new DoublyLinkedList();

		if (list.isEmpty()) {
			System.out.println("The list is empty");
		}

		System.out.println("Adding the following data to list: 5, 2, Hola, %90%, 0.5, 2, lala");
		list.add(5);
		list.add(2);
		list.add("Hola");
		list.add("%90%");
		list.add(0.5);
		list.add(2);
		list.add("lala");

		System.out.print("Current list: ");
		list.drawList();

		System.out.print("\nAdding 'Front' to the front: ");
		list.addFront("Front");
		list.drawList();

		System.out.print("\nRemoving the first node: ");
		list.removeFront();
		list.drawList();

		System.out.print("\nRemoving the last node: ");
		list.removeLast();
		list.drawList();

		System.out.print("\nSize of the current list: " + list.getListSize());

		System.out.print("\nAdding \"8\" after the 2nd '2': ");
		list.insertNodeAfter(2, 2, 8);
		list.drawList();

		System.out.print("\nRemoving the 2nd \"2\": ");
		list.removeNode(2, 2);
		list.drawList();
	}

}
