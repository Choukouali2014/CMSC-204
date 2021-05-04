import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Road_STUDENT_Test {
	private Town t_1, t_2;
	private Road road;
	

	@BeforeEach
	void setUp() throws Exception {
		t_1 = new Town("Bethesda");
		t_2 = new Town("College Park");
		road = new Road(t_1,t_2,12,"I-495");
	}

	@AfterEach
	void tearDown() throws Exception {
		t_1=t_2=null;
		road=null;
	}
	@Test
	void testCompareTo() {

		Road rd_2 = new Road(t_1, t_2, 12, "I-495");
		assertEquals(rd_2.compareTo(road), 0);
		Road rd_1 = new Road(t_2, t_1, 9, "I-270");
		assertEquals(road.compareTo(rd_1), 2);
		
	}

	@Test
	void testContain() {
		assertEquals(road.contains(t_1), true);
		assertEquals(road.contains(t_2), true);
	}
	@Test
	void testWeight() {
		assertEquals(road.getWeight() == 12, true);
	}
	
	@Test
	void testEquals() {
		Road rd= new Road(t_1, t_2, 12, "I-495");
		assertEquals(rd.equals(road), true);
	}
	@Test
	void testSource() {
		assertEquals(road.getSource().equals(t_1), true);
	}
	
	
}
