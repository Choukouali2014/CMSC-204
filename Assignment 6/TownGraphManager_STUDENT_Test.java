


import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class TownGraphManager_STUDENT_Test {
	private TownGraphManagerInterface graph;
	private String[] town;
	  
	@Before
	public void setUp() throws Exception {
		  graph = new TownGraphManager();
		  town = new String[7];
		  
		  for (int i = 1; i < 7; i++) {
			  town[i] = "Town_" + i;
			  graph.addTown(town[i]);
		  }
		  
		  graph.addRoad(town[1], town[2], 2, "Road_12");
		  graph.addRoad(town[1], town[3], 1, "Road_13");
		  graph.addRoad(town[2], town[5], 6, "Road_23");
		  graph.addRoad(town[3], town[6], 1, "Road_36");
		 
		 
	}

	@After
	public void tearDown() throws Exception {
		graph = null;
	}

	@Test
	public void testAddRoad() {
		ArrayList<String> roads = graph.allRoads();
		assertEquals("Road_12", roads.get(0));
		assertEquals("Road_13", roads.get(1));
		assertEquals("Road_23", roads.get(2));
		assertEquals("Road_36", roads.get(3));
		graph.addRoad(town[4], town[6], 1,"Road_46");
		roads = graph.allRoads();
		assertEquals("Road_12", roads.get(0));
		assertEquals("Road_13", roads.get(1));
		assertEquals("Road_23", roads.get(2));
		assertEquals("Road_36", roads.get(3));
		assertEquals("Road_46", roads.get(4));
		
	}

	@Test
	public void testGetRoad() {
		assertEquals("Road_12", graph.getRoad(town[1], town[2]));
		assertEquals("Road_36", graph.getRoad(town[3], town[6]));
	}

	@Test
	public void testAddTown() {
		assertEquals(false, graph.containsTown("Town_8"));
		graph.addTown("Town_8");
		assertEquals(true, graph.containsTown("Town_8"));
	}
	
	@Test
	public void testDisjointGraph() {
		assertEquals(false, graph.containsTown("Town_7"));
		graph.addTown("Town_7");
		ArrayList<String> path = graph.getPath(town[1],"Town_7");
		assertFalse(path.size() > 0);
	}

	@Test
	public void testContainsTown() {
		assertEquals(true, graph.containsTown("Town_3"));
		assertEquals(false, graph.containsTown("Town_8"));
	}

	@Test
	public void testContainsRoadConnection() {
		assertEquals(true, graph.containsRoadConnection(town[2], town[5]));
		assertEquals(false, graph.containsRoadConnection(town[3], town[1]));
	}

	@Test
	public void testAllRoads() {
		ArrayList<String> roads = graph.allRoads();
		assertEquals("Road_12", roads.get(0));
		assertEquals("Road_13", roads.get(1));
		assertEquals("Road_23", roads.get(2));
		assertEquals("Road_36", roads.get(3));
	}

	@Test
	public void testDeleteRoadConnection() {
		assertEquals(true, graph.containsRoadConnection(town[2], town[5]));
		graph.deleteRoadConnection(town[2], town[5], "Road_23");
		assertEquals(false, graph.containsRoadConnection(town[2], town[5]));
	}

	@Test
	public void testDeleteTown() {
		assertEquals(true, graph.containsTown("Town_1"));
		graph.deleteTown(town[1]);
		assertEquals(false, graph.containsTown("Town_1"));
	}
	
	@Test
	public void testAllTowns() {
		ArrayList<String> roads = graph.allTowns();
		assertEquals("Town_1", roads.get(0));
		assertEquals("Town_2", roads.get(1));
		assertEquals("Town_3", roads.get(2));
	}

	@Test
	public void testGetPath() {
		ArrayList<String> path = graph.getPath(town[1],town[6]);
		  assertNotNull(path);
		  assertTrue(path.size() > 0);
		  assertEquals("Town_1 via Road_13 to Town_3 1 mi",path.get(0).trim());
	
	}
	
	

}