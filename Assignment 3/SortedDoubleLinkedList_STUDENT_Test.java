import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import java.util.Comparator;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SortedDoubleLinkedList_STUDENT_Test {
	SortedDoubleLinkedList<String> linkedStringStudents;
	
	
	
	
	public String a = "Armel";
	public String b = "Brandon";
	public String c = "Choukouali";
	public String d = "Donald";
	public String e = "Emmanuel";
	public String f = "Frank";
	public String g = "Gounou";
	public String h = "Handsome";
	StringComparator comparator;
	//Alphabetic order: a b c d e f g h 
	
	@BeforeEach
	void setUp() throws Exception {
		comparator = new StringComparator();
		linkedStringStudents = new SortedDoubleLinkedList<String>(comparator);
	}

	@AfterEach
	void tearDown() throws Exception {
		linkedStringStudents = null;
		comparator = null;
	}
	
	@Test
	public void testAddToEnd() {
		try {
			linkedStringStudents.addToEnd(a);
			assertTrue("Did not throw an UnsupportedOperationException", false);
		}
		catch (UnsupportedOperationException e)
		{
			assertTrue("Successfully threw an UnsupportedOperationException", true);
		}
		catch (Exception e)
		{
			assertTrue("Threw an exception other than the UnsupportedOperationException", false);
		}
	}

	@Test
	public void testAddToFront() {
		try {
			linkedStringStudents.addToFront(a);
			assertTrue("Did not throw an UnsupportedOperationException", false);
		}
		catch (UnsupportedOperationException e)
		{
			assertTrue("Successfully threw an UnsupportedOperationException", true);
		}
		catch (Exception e)
		{
			assertTrue("Threw an exception other than the UnsupportedOperationException", false);
		}
	}

	@Test
	public void testIteratorSuccessfulNext() {
		linkedStringStudents.add(a);
		linkedStringStudents.add(b);
		linkedStringStudents.add(c);
		linkedStringStudents.add(d);

		ListIterator<String> iterator = linkedStringStudents.iterator();
		
		assertEquals(a, iterator.next());
		assertEquals(b, iterator.next());
		assertEquals(c, iterator.next());
		assertEquals(d, iterator.next());

	}

	@Test
	public void testIteratorSuccessfulPrevious() {
		linkedStringStudents.add(a);
		linkedStringStudents.add(b);
		linkedStringStudents.add(c);
		linkedStringStudents.add(d);

		ListIterator<String> iterator = linkedStringStudents.iterator();
		
		assertEquals(a, iterator.next());
		assertEquals(b, iterator.next());
		assertEquals(c, iterator.next());
		assertEquals(d, iterator.next());
		
		assertEquals(d, iterator.previous());
		assertEquals(c, iterator.previous());
		assertEquals(b, iterator.previous());
	}
	
	@Test
	public void testIteratorNoSuchElementException() {
		linkedStringStudents.add(a);
		linkedStringStudents.add(b);
		linkedStringStudents.add(c);
		linkedStringStudents.add(d);
		
		ListIterator<String> iterator = linkedStringStudents.iterator();
		
		assertEquals(a, iterator.next());
		assertEquals(b, iterator.next());
		assertEquals(c, iterator.next());
		assertEquals(d, iterator.next());
		
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
	public void testIteratorUnsupportedOperationExceptionString() {
		linkedStringStudents.add(a);
		linkedStringStudents.add(b);
		linkedStringStudents.add(c);
		linkedStringStudents.add(d);
		
		ListIterator<String> iterator = linkedStringStudents.iterator();
		
		try{
			iterator.remove();
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

	private class StringComparator implements Comparator<String> {

		@Override
		public int compare(String arg0, String arg1) {
			return arg0.compareTo(arg1);
		}
		
	}

}