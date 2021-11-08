package org.mql.java.Trie;

import java.util.HashMap;
import java.util.Map;

public class Node {
	private Map<Character, Node> children;
	private boolean isEndOfWord;

	public Node() {
		children = new HashMap<Character, Node>();
	}

	public void insert(String word) {

		char c = word.charAt(0);
		if (!children.containsKey(c)) {
			children.put(c, new Node());
		}
		if (word.length() == 1) {
			this.isEndOfWord = true;
		} else {
			children.get(c).insert(word.substring(1));
		}
	}

	public boolean startsWith(String prefix) {
		char c = prefix.charAt(0);
		Node node = this.children.get(c);
		if (node == null) {
			return false;
		}
		if (prefix.length() == 1) {
			return node != null && !node.children.isEmpty();
		} else
			return node.startsWith(prefix.substring(1));
	}

	public boolean contains(String word) {
		char c = word.charAt(0);
		Node node = this.children.get(c);
		if (node == null) {
			return false;
		}
		if (word.length() == 1) {
			return node != null && node.children.isEmpty();
		} else
			return node.contains(word.substring(1));
	}

	public void displayTrie() {
		String result = this.displayTrie(new StringBuffer());
		System.out.println(result);
	}

	private String displayTrie(StringBuffer message) {
		this.children.forEach((key, value) -> {
			if (this.isEndOfWord) {
				message.append(key + "\n");
			} else {
				message.append(key);
				value.displayTrie(message);
			}
		});
		return message.toString();
	}

}
