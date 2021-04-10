package org.dfpl.collection.list;

import static org.junit.Assert.assertEquals;

import java.util.LinkedList;
import java.util.List;

import org.dfpl.collection.linkedlist.JLinkedList;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AddSizeTest {
	@Test
	public void builtInCollection() {
		List<Integer> list = new LinkedList<Integer>();
		for (int i = 0; i < 10; i++) {
			list.add(i);
		}
		assertEquals(list.size(), 10);
	}

	@Test
	public void customCollection() {
		List<Integer> list = new JLinkedList<Integer>();
		for (int i = 0; i < 10; i++) {
			list.add(i);
		}
		assertEquals(list.size(), 10);
	}
}
