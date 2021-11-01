package org.mql.java.Queue;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StackTest {

	Stack<String> names;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		names = new Stack<String>();
	}

	@AfterEach
	void tearDown() throws Exception {
		names = null;
	}

	@Test
	void isEmpty() {
		assertTrue(names.isEmpty());
	}

	@Test
	void peek() {
		names.push("ilyass");
		names.push("ayach");
		names.push("mouad");
		assertEquals(names.peek(), "mouad");
	}

	@Test
	void push() {
		names.push("ilyass");
		names.push("ayach");
		names.push("mouad");
		assertEquals(names.peek(), "mouad");
	}

	@Test
	void pop() {
		names.push("ilyass");
		names.push("ayach");
		names.push("mouad");
		assertEquals(names.pop(), "mouad");
	}

	@Test
	void iterator() {
		names.push("ilyass");
		names.push("ayach");
		names.push("mouad");
		for (String name : names) {
			assertNotNull(name);
		}
	}

}
