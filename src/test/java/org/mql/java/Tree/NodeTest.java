package org.mql.java.Tree;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class NodeTest {
	Node<String> root;
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		root = new Node<String>("ayach");
		System.setOut(new PrintStream(outContent));
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void insert() {
		root.insert("ayoub");
		assertTrue(root.contains("ayoub"));
	}

	@Test()
	void insertExistingValue() {
		root.insert("ayoub");
		assertThrows(RuntimeException.class, () -> {
			root.insert("ayoub");
		});
	}

	@Test
	void displayTree() {
		root.displayTree();
		assertEquals("ayach", outContent.toString().trim());
	}

	@Test
	void testContains() {
		root.insert("ayoub");
		assertTrue(root.contains("ayoub"));
	}

}
