import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

class BasicDoubleLinkedList_STUDENT_Test {
	BasicDoubleLinkedList<String> linkedStringStudents;
	
	public String a = "Frank";
	public String b = "Choukouali";
	public String c = "Noumbissie";
	public String d = "Leonel";
	public String e = "Armel";
	public String f = "Chokouali";
	public String g = "Tcheuffa";
	public String h = "Jean";
	StringComparator comparator;

	@BeforeEach
	void setUp() throws Exception {
		linkedStringStudents = new BasicDoubleLinkedList<String>();
		comparator = new StringComparator();
		linkedStringStudents.addToEnd(a);
		linkedStringStudents.addToEnd(b);
		linkedStringStudents.addToEnd(c);
		linkedStringStudents.addToEnd(d);
		linkedStringStudents.addToFront(e);
	}

	@AfterEach
	void tearDown() throws Exception {
		linkedStringStudents = null;
		comparator = null;
	}
	
	@Test
	public void testGetSize() {
		assertEquals(5,linkedStringStudents.getSize());
	}
	
	@Test
	public void testAddToEnd() {
		assertEquals(d, linkedStringStudents.getLast());
		linkedStringStudents.addToEnd(f);
		assertEquals(f, linkedStringStudents.getLast());
		linkedStringStudents.addToEnd(g);
		assertEquals(g, linkedStringStudents.getLast());
	}
	
	@Test
	public void testAddToFront() {
		assertEquals(e, linkedStringStudents.getFirst());
		linkedStringStudents.addToFront(f);
		assertEquals(f, linkedStringStudents.getFirst());
		linkedStringStudents.addToFront(g);
		assertEquals(g, linkedStringStudents.getFirst());

	}
	
	@Test
	public void testGetFirst() {
		assertEquals(e, linkedStringStudents.getFirst());
		linkedStringStudents.addToFront(f);
		assertEquals(f, linkedStringStudents.getFirst());

	}

	@Test
	public void testGetLast() {
		assertEquals(d, linkedStringStudents.getLast());
		linkedStringStudents.addToEnd(f);
		assertEquals(f, linkedStringStudents.getLast());
	}
	
	@Test
	public void testToArrayList()
	{
		
		linkedStringStudents.addToEnd(f);
		linkedStringStudents.addToFront(g);
		linkedStringStudents.addToEnd(h);
		ArrayList<String> list = linkedStringStudents.toArrayList();
		
		assertEquals(g,list.get(0));
		assertEquals(e,list.get(1));
		assertEquals(a,list.get(2));
		assertEquals(b,list.get(3));
		assertEquals(c,list.get(4));
		assertEquals(d,list.get(5));
		assertEquals(f,list.get(6));
		assertEquals(h,list.get(7));
	}
	
	@Test
	public void testIteratorSuccessfulNext() {
		linkedStringStudents.addToEnd(f);
		linkedStringStudents.addToFront(g);
		ListIterator<String> iterator = linkedStringStudents.iterator();
		
		assertEquals(true, iterator.hasNext());
		assertEquals(g, iterator.next());
		assertEquals(e, iterator.next());
		assertEquals(a, iterator.next());
		assertEquals(true, iterator.hasNext());
		assertEquals(b, iterator.next());
		
	}
	
	@Test
	public void testIteratorSuccessfulPrevious() {
		ListIterator<String> iterator = linkedStringStudents.iterator();
		
		linkedStringStudents.addToEnd(f);
		linkedStringStudents.addToFront(g);
		linkedStringStudents.addToEnd(h);
		
		assertEquals(true, iterator.hasNext());
		assertEquals(e, iterator.next());
		assertEquals(a, iterator.next());
		assertEquals(b, iterator.next());
		assertEquals(c, iterator.next());
		assertEquals(true, iterator.hasPrevious());
		assertEquals(c, iterator.previous());
		assertEquals(b, iterator.previous());
		assertEquals(a, iterator.previous());
		assertEquals(e, iterator.previous());
		assertEquals(g, iterator.previous());
		assertEquals(false, iterator.hasPrevious());
	}
	
	@Test
	public void testIteratorNoSuchElementExceptionNext() {
		linkedStringStudents.addToEnd(f);
		linkedStringStudents.addToFront(g);
		linkedStringStudents.addToEnd(h);
		
		ListIterator<String> iterator = linkedStringStudents.iterator();	
		assertEquals(g, iterator.next());
		assertEquals(e, iterator.next());
		assertEquals(a, iterator.next());
		assertEquals(b, iterator.next());
		assertEquals(c, iterator.next());
		assertEquals(d, iterator.next());
		assertEquals(f, iterator.next());
		assertEquals(h, iterator.next());
		
		try{
			iterator.next();
			assertTrue("Did not throw a NoSuchElementException",false);
		}
		catch (NoSuchElementException e)
		{
			assertTrue("Successfully threw a NoSuchElementException",true);
		}
		catch (Exception e)
		{
			assertTrue("Threw an exception other than the NoSuchElementException", false);
		}
		
	}
	
	@Test
	public void testIteratorNoSuchElementExceptionPrevious() {
		linkedStringStudents.addToEnd(f);
		linkedStringStudents.addToFront(g);
		linkedStringStudents.addToEnd(h);
		
		ListIterator<String> iterator = linkedStringStudents.iterator();	
		assertEquals(g, iterator.next());
		assertEquals(e, iterator.next());
		assertEquals(e, iterator.previous());
		assertEquals(g, iterator.previous());
		
		try{
			iterator.previous();
			assertTrue("Did not throw a NoSuchElementException",false);
		}
		catch (NoSuchElementException e)
		{
			assertTrue("Successfully threw a NoSuchElementException",true);
		}
		catch (Exception e)
		{
			assertTrue("Threw an exception other than the NoSuchElementException", false);
		}
	}
	
	@Test
	public void testIteratorUnsupportedOperationException() {
		ListIterator<String> iterator = linkedStringStudents.iterator();		
		
		try{
			iterator.previousIndex();
			assertTrue("Did not throw a UnsupportedOperationException",false);
		}
		catch (UnsupportedOperationException e)
		{
			assertTrue("Successfully threw a UnsupportedOperationException",true);
		}
		catch (Exception e)
		{
			assertTrue("Threw an exception other than the UnsupportedOperationException", false);
		}
		
	}
	
	@Test
	public void testRemove() {
		
		assertEquals(d, linkedStringStudents.getLast());
		linkedStringStudents.addToEnd(f);
		linkedStringStudents.remove(f, comparator);
		assertEquals(d, linkedStringStudents.getLast());
		
	}

	@Test
	public void testRetrieveFirstElement() {
		linkedStringStudents.addToFront(a);
		assertEquals(a, linkedStringStudents.getFirst());
		assertEquals(a, linkedStringStudents.retrieveFirstElement());
		assertEquals(e, linkedStringStudents.getFirst());
	}

	@Test
	public void testRetrieveLastElement() {
		linkedStringStudents.addToEnd(a);
		assertEquals(a, linkedStringStudents.getLast());
		assertEquals(a, linkedStringStudents.retrieveLastElement());
		assertEquals(d, linkedStringStudents.getLast());
	}

	private class StringComparator implements Comparator<String> {

		@Override
		public int compare(String arg0, String arg1) {
			return arg0.compareTo(arg1);
		}
		
	}

}