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
	/* .append()
	 * list size increases by one when appending a String, a null, or an int primitive (not the wrapper class)
	 */
	
	@Test
	public void testAppend() {
		int size = list.size()+1;
		list.append("Fourth name");
		assertEquals(size, 4);
	}
	@Test
	public void testAppendNothing() {
		Object o = null;
		int size = list.size()+1;
		list.append(o);
		assertEquals(size, 4);
	}
	@Test
	public void testAppendIntPrimitive() {
		int size = list.size()+1;
		list.append(3);
		assertEquals(size, 4);
	}
	
	/* .get()
	 * returns value when in range
	 * throws correct error when above or below index range
	 */
	
	@Test
	public void testGet() {
		assertEquals(list.get(1), "John");
	}
	@Test (expected = IndexOutOfBoundsException.class)
	public void testGetIndexAboveBounds() {
		list.get(list.size());
	}
	@Test (expected = IndexOutOfBoundsException.class)
	public void testGetIndexBelowBounds() {
		list.get(-4);
	}
	
	/* .set()
	 * changes value when in range
	 * throws correct error when above or below index range
	 */
	
	@Test
	public void testSet() {
		list.set(1, "ulmer");
		assertEquals(list.get(1), "ulmer");
	}
	@Test (expected = IndexOutOfBoundsException.class)
	public void testSetIndexAboveBounds() {
		list.set(5, "ulmer");
	}
	@Test (expected = IndexOutOfBoundsException.class)
	public void testSetIndexBelowBounds() {
		list.set(-4, "ulmer");
	}

	/* .size()
	 * returns correct value for initial list
	 * returns correct value for empty list
	 */
	
	@Test
	public void testSize() {
		assertEquals(list.size(), 3);
	}
	@Test
	public void testSizeWhenEmpty() {
		MyLinkedList emptyList = new MyLinkedList();
		assertEquals(emptyList.size(), 0);
	}
	
}
