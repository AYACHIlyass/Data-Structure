package org.mql.java.Heap;

import java.util.ArrayList;
import java.util.List;

public class Heap {
	private List<Integer> nodes;

	public Heap() {
		nodes = new ArrayList<Integer>();
	}

	private int getParentIndex(int childIndex) {
		return (childIndex - 1) / 2;
	}

	private int getLeftChildIndex(int parentIndex) {
		return 2 * parentIndex + 1;
	}

	private int getRightChildIndex(int parentIndex) {
		return 2 * parentIndex + 2;
	}

	public void insert(Integer node) {
		nodes.add(node);
		int parentIndex = getParentIndex(getLastIndex());
		if (parentIndex >= 0) {
			Integer parentNode = nodes.get(parentIndex);
			bubbleUpNode(node, parentNode);
		}
	}

	private void bubbleUpNode(Integer node, Integer parentNode) {
		if (parentNode.compareTo(node) == 1) {
			exchangePlaces(node, parentNode);
			int nodeIndex = getIndexOfNode(node);
			int parentIndex = getParentIndex(nodeIndex);
			if (parentIndex >= 0 && nodes.get(parentIndex).compareTo(node) == 1) {
				bubbleUpNode(node, nodes.get(parentIndex));
			}
		}

	}

	private void exchangePlaces(Integer node, Integer parentNode) {
		int nodeIndex = getIndexOfNode(node);
		int parentIndex = getIndexOfNode(parentNode);
		nodes.set(parentIndex, node);
		nodes.set(nodeIndex, parentNode);
	}

	private int getIndexOfNode(Integer node) {
		return nodes.indexOf(node);
	}

	public void delete() {
		nodes.set(0, nodes.get(getLastIndex()));
		nodes.remove(getLastIndex());
		bubbleDwonNode(nodes.get(0));
	}

	private void bubbleDwonNode(Integer node) {
		int nodeIndex = getIndexOfNode(node);
		if (hasLeftChild(nodeIndex) && hasRightChild(nodeIndex)) {
			Integer rightNode = nodes.get(getRightChildIndex(nodeIndex));
			Integer leftNode = nodes.get(getLeftChildIndex(nodeIndex));
			if (rightNode < leftNode && rightNode < node) {
				exchangePlaces(rightNode, node);
				bubbleDwonNode(node);
			} else if (leftNode < rightNode && leftNode < node) {
				exchangePlaces(leftNode, node);
				bubbleDwonNode(node);
			} else {
				return;
			}
		} else if (hasRightChild(node) && !hasLeftChild(node)) {
			Integer rightNode = nodes.get(getRightChildIndex(nodeIndex));
			if (rightNode < node) {
				exchangePlaces(rightNode, node);
				bubbleDwonNode(node);
			} else {
				return;
			}
		} else if (hasLeftChild(node) && !hasRightChild(node)) {
			Integer leftNode = nodes.get(getRightChildIndex(nodeIndex));
			if (leftNode < node) {
				exchangePlaces(leftNode, node);
				bubbleDwonNode(node);
			} else {
				return;
			}
		} else {
			return;
		}
	}

	private boolean hasLeftChild(int nodeIndex) {
		int leftIndex = getLeftChildIndex(nodeIndex);
		return leftIndex > 0 && leftIndex <= getLastIndex();
	}

	private boolean hasRightChild(int nodeIndex) {
		int rightIndex = getRightChildIndex(nodeIndex);
		return rightIndex > 0 && rightIndex <= getLastIndex();
	}

	private int getLastIndex() {
		return nodes.size() - 1;
	}

	public void displayNodes() {
		System.out.println(nodes.get(0));
		for (int j = 0; j < nodes.size() / 2; j++) {
			displayNodeChildren(j);
		}
	}

	private void displayNodeChildren(int parentIndex) {
		if (hasLeftChild(parentIndex)) {
			System.out.println(nodes.get(getLeftChildIndex(parentIndex)));
		}
		if (hasRightChild(parentIndex)) {
			System.out.println(nodes.get(getRightChildIndex(parentIndex)));
		}
	}

	public List<Integer> getNodes() {
		return nodes;
	}

	public Integer getMinValue() {
		return nodes.get(0);
	}
}
