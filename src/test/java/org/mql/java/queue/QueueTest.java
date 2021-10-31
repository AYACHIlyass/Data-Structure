package org.mql.java.queue;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class QueueTest {
	Queue<String> queue;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {

	}

	@BeforeEach
	void setUp() throws Exception {
		queue = new Queue<String>();
	}

	@Test
	void isEmpty() {
		assertTrue(queue.isEmpty());
	}

	@Test
	void Add() {
		queue.add("ilyass");
		queue.add("ayach");
		queue.add("yassine");
		queue.add("ayoub");
		assertFalse(queue.isEmpty());
	}

	@Test
	void Peek() {
		queue.add("ilyass");
		queue.add("ayach");
		queue.add("yassine");
		queue.add("ayoub");
		assertEquals(queue.peek(), "ilyass");
	}

	@Test
	void Remove() {
		queue.add("ilyass");
		queue.add("ayach");
		queue.add("yassine");
		queue.add("ayoub");
		assertEquals(queue.remove(), "ilyass");
	}

	@Test
	void of() {
		Queue<String> newQueue = Queue.of("ilyass", "ayach");
		assertEquals(newQueue.peek(), "ilyass");
	}

	@AfterEach
	void tearDown() throws Exception {
		queue = null;
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

}
