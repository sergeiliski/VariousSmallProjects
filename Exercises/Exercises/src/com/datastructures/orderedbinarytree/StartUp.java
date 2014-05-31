package com.datastructures.orderedbinarytree;

import java.util.Random;

public class StartUp {

	private static Random random = new Random();

	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		int value;

		System.out.println("Random values: ");
		for (int i = 0; i < 10; i++) {
			value = random.nextInt(100);
			System.out.print(value + " ");
			tree.insert(value);
		}

		System.out.println("\n\nPreorder:");
		tree.preorderTraversal();
		System.out.println("\n\nInorder:");
		tree.inorderTraversal();
		System.out.println("\n\nPostorder:");
		tree.postorderTraversal();
	}
}
