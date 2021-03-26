import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Frank Choukouali
 *
 */
public class CourseDBManager_STUDENT_Test {
	private CourseDBManagerInterface courseManager = new CourseDBManager();

	/**
	 * Create an instance of CourseDBManager
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		courseManager = new CourseDBManager();
	}

	/**
	 * Set courseManager reference to null
	 * @throws Exception
	 */
	@After
	public void tearDown() throws Exception {
		courseManager = null;
	}

	/**
	 * Test for the add method
	 */
	@Test
	public void testAddToDB() {
		try {
			courseManager.add("CMSC140",46457,4,"CS140","Ara Kechiantz");
			courseManager.add("CMSC203",21557,4,"CS203","Khandan Monshi");
		}
		catch(Exception e) {
			fail("This should not have caused an Exception");
		}
	}
	
	/**
	 * Test for the showAll method
	 */
	@Test
	public void testShowAll() {
		courseManager.add("CMSC140",46457,4,"CS140","Ara Kechiantz");
		courseManager.add("CMSC203",21557,4,"CS203","Khandan Monshi");
		courseManager.add("CMSC204",32191,4,"CS204","Khandan Monshi");
		ArrayList<String> list = courseManager.showAll();
		
		
		assertEquals(list.get(0),"\nCourse:CMSC203 CRN:21557 Credits:4 Instructor:Khandan Monshi Room:CS203");
		assertEquals(list.get(1),"\nCourse:CMSC140 CRN:46457 Credits:4 Instructor:Ara Kechiantz Room:CS140");
		assertEquals(list.get(2),"\nCourse:CMSC204 CRN:32191 Credits:4 Instructor:Khandan Monshi Room:CS204");
			}
	/**
	 * Test for the read method
	 */
	@Test
	public void testRead() {
		try {
			File inputFile = new File("Test1.txt");
			PrintWriter inFile = new PrintWriter(inputFile);
			inFile.println("CMSC203 21557 4 CS203 Khandan Monshi");
			inFile.print("CMSC204 46457 4 CS204 Khandan Monshi");
			
			inFile.close();
			courseManager.readFile(inputFile);
			//System.out.println(courseManager.showAll());
		} catch (Exception e) {
			fail("Should not have thrown an exception");
		}
	}
}
