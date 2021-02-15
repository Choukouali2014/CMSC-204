


import static org.junit.jupiter.api.Assertions.*;



import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author Frank Choukouali
 * 
 */
class GradebookTester {
	GradeBook gradeBook, gradeBook_two; 
	@BeforeEach
	void setUp() throws Exception {
		 gradeBook = new GradeBook(5);
		 gradeBook_two = new GradeBook(5);
		gradeBook.addScore(70.5);
		gradeBook.addScore(60.3);
		gradeBook.addScore(10.1);
		gradeBook_two.addScore(50);
		gradeBook_two.addScore(75);
	}

	@AfterEach
	void tearDown() throws Exception {
		gradeBook = gradeBook_two = null;
	}

	@Test
	void testSum() {
		assertEquals(140.9, gradeBook.sum());
		assertEquals(125, gradeBook_two.sum(),.0001);
	} 
	@Test
	void testMinimum() {
		assertEquals(10.1, gradeBook.minimum());
		assertEquals(50, gradeBook_two.minimum(),.001);
	}
	
	
	@Test 
	void testToString() {
		assertTrue(gradeBook.toString().equals("70.5 60.3 10.1"));
		assertTrue(gradeBook_two.toString().equals("50.0 75.0"));
	}
	@Test
	void testAddScore() {
		assertTrue(gradeBook.toString().equals("70.5 60.3 10.1"));
		assertTrue(gradeBook_two.toString().equals("50.0 75.0"));
	}
	
	@Test
	void testFinalScore() {
		assertEquals(130.8, gradeBook.finalScore());
		assertEquals(75, gradeBook_two.finalScore());
	}
	
	@Test
	void testGetScoresSize() {
		assertEquals(3, gradeBook.getScoreSize());
		assertEquals(2, gradeBook_two.getScoreSize());
	}
	
	
	
	

}
