package org.mql.java.Heap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class HeapTest {
	private Heap heap;
	private ByteArrayOutputStream outputStream;

	@BeforeEach
	void setUp() throws Exception {
		heap = new Heap();
		outputStream = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outputStream));
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void insert() {
		heap.insert(9);
		heap.insert(20);
		heap.insert(77);
		heap.insert(1);
		heap.insert(58);
		heap.insert(30);
		heap.displayNodes();
		String[] nodes = outputStream.toString().trim().replaceAll("\n", ",").split(",");
		List<Integer> list = Stream.of(nodes).map(node -> Integer.valueOf(node.trim())).collect(Collectors.toList());
		Assertions.assertIterableEquals(list, heap.getNodes());
	}

	@Test
	void delete() {
		heap.insert(9);
		heap.insert(20);
		heap.insert(77);
		heap.insert(1);
		heap.insert(58);
		heap.insert(30);
		Integer initialMinValue = heap.getMinValue();
		heap.delete();
		Integer minValueAfterDeletion = heap.getMinValue();
		assertNotEquals(initialMinValue, minValueAfterDeletion);
	}

	@Test
	void getMinValue() {
		heap.insert(9);
		heap.insert(20);
		heap.insert(77);
		heap.insert(1);
		heap.insert(58);
		heap.insert(30);
		assertEquals(1, heap.getMinValue());
	}

	@Test
	void displayNodes() {
		heap.insert(9);
		heap.insert(20);
		heap.insert(77);
		heap.insert(1);
		heap.insert(58);
		heap.insert(30);
		heap.displayNodes();
		String[] nodes = outputStream.toString().trim().replaceAll("\n", ",").split(",");
		List<Integer> list = Stream.of(nodes).map(node -> Integer.valueOf(node.trim())).collect(Collectors.toList());
		Assertions.assertIterableEquals(list, heap.getNodes());
	}
}
