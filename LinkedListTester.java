package dataStructures;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;



public class LinkedListTester {
	private static MyLinkedList list;
	
	/* create test data for all tests:  
	 list of "Jeb", "John", "Third name"
	 */
	@Before
	public void setupClass() {
		list = new MyLinkedList();
		list.append("Jeb");
		list.append("John");
		list.append("Third name");
	}
	
	@Test
	public void testInsert() {
		list.insert("ulmer", 1);
		assertEquals(list.get(1), "ulmer");
		assertEquals(list.get(2), "John");
		assertEquals(list.size(), 4);
	}
	
	@Test
	public void testAppend() {
		list.append("Fourth name");
		assertEquals(list.size(), 4);
	}
	
	@Test
	public void testGet() {
		assertEquals(list.get(1), "John");
	}

	@Test
	public void testSet() {
		list.set(1, "ulmer");
		assertEquals(list.get(1), "ulmer");
		assertEquals(list.size(), 3);
	}
	@Test (expected = IndexOutOfBoundsException.class)
	public void testSetIndexAboveBounds() {
		list.set(5, "ulmer");
	}
	@Test (expected = IndexOutOfBoundsException.class)
	public void testSetIndexBelowBounds() {
		list.set(-4, "ulmer");
	}

	@Test
	public void testSize() {
		assertEquals(list.size(), 3);
	}
}
