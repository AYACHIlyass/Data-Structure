package org.mql.java.Queue;

import java.util.Iterator;

public class Stack<T> implements Iterable<T> {
	class Node {
		private T data;
		private Node next;

		public Node(T data) {
			this.data = data;
		}
	}

	private Node top;

	public boolean isEmpty() {
		return top == null;
	}

	public T peek() {
		return top.data;
	}

	public void push(T data) {
		Node newNode = new Node(data);
		if (isEmpty()) {
			top = new Node(data);
		} else {
			newNode.next = top;
			top = newNode;
		}
	}

	public T pop() {
		T data = top.data;
		top = top.next;
		return data;
	}

	public Iterator<T> iterator() {
		return new QueueIterator(top);
	}

	private class QueueIterator implements Iterator<T> {
		private Node current;

		public QueueIterator(Node current) {
			this.current = current;
		}

		public boolean hasNext() {
			return current != null;
		}

		public T next() {
			T data = current.data;
			current = current.next;
			return data;
		}

	}

}
