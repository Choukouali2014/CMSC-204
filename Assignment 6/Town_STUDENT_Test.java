import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Town_STUDENT_Test {
	private Town t_1, t_2;
	
	@BeforeEach
	void setUp() throws Exception {
	 t_1 = new Town("Bethesda"); 
	 t_2= new Town("College Park");
	 t_1.setAdjacentTown(t_2);
	 t_2.setAdjacentTown(t_1);
	}

	@AfterEach
	void tearDown() throws Exception {
		t_1=t_2=null;
	}

	
	
	@Test
	void testWeight() {
		assertEquals(t_1.getWeight(), Integer.MAX_VALUE);
		t_2.setWeight(12);
		assertEquals(t_2.getWeight(), 12);
	}
	
	@Test
	void testPreviousTown() {
		t_1.setPrevious(t_2);
		assertEquals(t_1.getPrevious(), t_2);
	}
	
	@Test
	void testAdjacentTowns() {
		assertEquals(t_1.getAdjacentTown().contains(t_2), true);
	}
	
	@Test
	void testCompareTo() {
		assertEquals(t_1.compareTo(t_2), -1);
		Town t = new Town("Bethesda");
		assertEquals(t_1.compareTo(t), 0);
	}
	
	@Test
	void testEquals() {
		Town t = new Town(t_2);
		assertEquals(t_1.equals(t_2), false);
		assertEquals(t_2.equals(t), true);
	}
	
	@Test
	void testHashCode() {
		
		Town t = new Town("College Park");
		assertEquals(t_2.hashCode() == t.hashCode(), true);
		assertEquals(t_1.hashCode() == t_2.hashCode(), false);
	}

}
