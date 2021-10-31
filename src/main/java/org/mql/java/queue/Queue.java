package org.mql.java.queue;

public class Queue<T> {
	private Node<T> head;
	private Node<T> tail;

	private class Node<T> {
		private T data;
		private Node<T> next;

		public Node(T data) {
			this.data = data;
		}
	}

	public Queue() {
	}

	public boolean isEmpty() {
		return head == null;
	}

	public T peek() {
		T data = head.data;
		head = head.next;
		return data;
	}

	public void add(T data) {
		Queue<T>.Node<T> node = new Node<T>(data);
		if (head == null) {
			head = node;
			tail = head;
		} else {
			tail.next = node;
			tail = node;
		}
	}

	public T remove() {
		T data = this.head.data;
		if (isEmpty()) {
			return null;
		}
		if (this.head == this.tail) {
			head = tail = null;
			return data;
		} else {
			this.head = this.head.next;
			return data;
		}
	}

	public static <T> Queue<T> of(T... elements) {
		Queue<T> queue = new Queue<T>();
		for (T element : elements) {
			queue.add(element);
		}
		return queue;

	}

}
