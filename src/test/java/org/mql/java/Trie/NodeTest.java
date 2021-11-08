package org.mql.java.Trie;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class NodeTest {
	private Node trie;
	private static final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

	@BeforeAll
	static void setUpBeforClass() {
		System.setOut(new PrintStream(outContent));
	}

	@BeforeEach
	void setUp() throws Exception {
		trie = new Node();
	}

	@AfterEach
	void tearDown() throws Exception {
		trie = null;
	}

	@Test
	void contains() {
		trie.insert("ilyass");
		assertEquals(true, trie.contains("ilyass"));
	}

	@Test
	void insert() {
		trie.insert("ilyass");
		assertEquals(true, trie.contains("ilyass"));
	}

	@Test
	void startsWith() {
		trie.insert("ilyass");
		assertEquals(true, trie.startsWith("il"));
	}

	@Test
	void displayTrie() {
		trie.insert("ilyass");
		trie.displayTrie();
		assertEquals("ilyass", outContent.toString().trim());
	}

}
