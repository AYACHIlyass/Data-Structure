package org.mql.java.LinkedList;

import java.util.Iterator;

public class LinkedList<T> implements Iterable<T> {
	private T value;
	private LinkedList<T> next;

	public LinkedList(T value) {
		super();
		this.value = value;
	}

	public void addAtEnd(T value) {
		if (this.value == null) {
			this.value = value;
		} else if (this.next == null) {
			this.next = new LinkedList<T>(value);
		} else {
			this.next.addAtEnd(value);
		}
	}

	public LinkedList<T> addAtBegining(T value) {
		LinkedList<T> head = new LinkedList<T>(value);
		if (value != null) {
			head.next = this;
		}
		return head;
	}

	public T get(int index) {

		if (value != null && index == 0) {
			return this.value;
		} else if (this.next == null) {
			throw new ArrayIndexOutOfBoundsException();
		} else {
			return this.next.get(index - 1);
		}
	}

	public int size() {
		if (value == null) {
			return 0;
		} else if (this.next == null) {
			return 1;
		} else {
			return this.next.size() + 1;
		}
	}

	public Iterator<T> iterator() {
		return new IteratorImpl(this);
	}

	private class IteratorImpl implements Iterator<T> {

		private LinkedList<T> current;

		public IteratorImpl(LinkedList<T> linkedList) {
			this.current = linkedList;
		}

		public boolean hasNext() {
			return current.next != null;
		}

		public T next() {
			T value = current.value;
			current = current.next;
			return value;
		}

	}

}
