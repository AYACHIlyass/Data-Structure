package org.mql.java;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mql.java.LinkedList.LinkedList;

class LinkedListTest {
	private static LinkedList<String> names;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		names = new LinkedList<String>("ilyass");
	}

	@Test
	void get() {
		assertEquals(names.get(0), "ilyass");
	}

	@Test
	void addAtBegining() {
		LinkedList<String> newHead = names.addAtBegining("ayach");
		assertEquals(newHead.get(0), "ayach");
	}

	@Test
	void addAtEnd() {
		names.addAtEnd("ayoub");
		assertEquals(names.get(1), "ayoub");
	}

	@Test
	void size() {
		names.addAtEnd("ayoub");
		names.addAtEnd("yassine");
		assertEquals(names.size(), 3);
	}

	@Test
	void iterator() {
		names.addAtEnd("ayoub");
		names.addAtEnd("yassine");
		assertNotNull(names);
		for (String name : names) {
			assertNotNull(name);
		}
	}

	@AfterEach
	void tearDown() throws Exception {
		names = null;
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

}
