package org.mql.java.Tree;

public class Node<T extends Comparable<T>> {
	private T value;
	private Node<T> left;
	private Node<T> right;

	public Node(T value) {
		this.value = value;
		this.left = null;
		this.right = null;
	}

	public void insert(T value) {
		int comparison = value.compareTo(this.value);
		if (comparison == 0) {
			throw new RuntimeException("the value already exists");
		}
		if (comparison > 0) {
			if (right == null) {
				Node<T> nodeToAdd = new Node<T>(value);
				right = nodeToAdd;
			} else {
				right.insert(value);

			}
		} else if (comparison < 0) {
			if (left == null) {
				Node<T> nodeToAdd = new Node<T>(value);
				left = nodeToAdd;
			} else {
				left.insert(value);

			}
		}

	}

//	traversing in order 
	public void displayTree() {
		if (left != null) {
			left.displayTree();
		}
		System.out.println(value);
		if (right != null) {
			right.displayTree();
		}
	}

	public boolean contains(T value) {
		int comparison = value.compareTo(this.value);
		if (comparison == 0) {
			return true;
		} else if (comparison > 0) {
			return right != null && right.contains(value);
		} else {
			return left != null && left.contains(value);
		}

	}

}
