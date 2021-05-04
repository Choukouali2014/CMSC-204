import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.Set;

public class TownGraphManager implements TownGraphManagerInterface {
	private Graph g = new Graph();
	/**
	 * Adds a road with 2 towns and a road name
	 * @param town1 name of town 1 (lastname, firstname)
	 * @param town2 name of town 2 (lastname, firstname)
	 * @param roadName name of road
	 * @return true if the road was added successfully
	 */
	@Override
	public boolean addRoad(String town1, String town2, int weight, String roadName) {
		Town source = this.getTown(town1);
		Town destination = this.getTown(town2);
		if(source != null && destination !=null) {
			this.g.addEdge(source, destination, weight, roadName);
			return true;
		}
		return false;
	}

	/**
	 * Returns the name of the road that both towns are connected through
	 * @param town1 name of town 1 (lastname, firstname)
	 * @param town2 name of town 2 (lastname, firstname)
	 * @return name of road if town 1 and town2 are in the same road, returns null if not
	 */
	@Override
	public String getRoad(String town1, String town2) {
		return this.g.getEdge(new Town(town1), new Town(town2)).getName();
	}
	/**
	 * Adds a town to the graph
	 * @param v the town's name  (lastname, firstname)
	 * @return true if the town was successfully added, false if not
	 */
	@Override
	public boolean addTown(String v) {
		return this.g.addVertex(new Town(v));
	}
	/**
	 * Gets a town with a given name
	 * @param name the town's name 
	 * @return the Town specified by the name, or null if town does not exist
	 */
	@Override
	public Town getTown(String name) {
		Town returnTown=null;
		Set<Town> setTowns = this.g.vertexSet();
		for(Town town: setTowns) {
			if(town.getName().equals(name)) {
				returnTown = town;
				return returnTown;
			}
		}
		return null;
	}
	/**
	 * Determines if a town is already in the graph
	 * @param v the town's name 
	 * @return true if the town is in the graph, false if not
	 */
	@Override
	public boolean containsTown(String v) {
		return this.getTown(v) != null? true : false;
	}
	/**
	 * Determines if a road is in the graph
	 * @param town1 name of town 1 (lastname, firstname)
	 * @param town2 name of town 2 (lastname, firstname)
	 * @return true if the road is in the graph, false if not
	 */
	@Override
	public boolean containsRoadConnection(String town1, String town2) {
		
		return this.g.containsEdge(this.getTown(town1), this.getTown(town2));
	}
	/**
	 * Creates an arraylist of all road titles in sorted order by road name
	 * @return an arraylist of all road titles in sorted order by road name
	 */
	@Override
	public ArrayList<String> allRoads() {
		ArrayList<String> road_title = new ArrayList<String>();
		Set<Road> setRoads = this.g.edgeSet();
		for(Road r: setRoads) {
			road_title.add(r.getName());
		}
		Collections.sort(road_title);
		return road_title;
	}
	/**
	 * Deletes a road from the graph
	 * @param town1 name of town 1 (lastname, firstname)
	 * @param town2 name of town 2 (lastname, firstname)
	 * @param roadName the road name
	 * @return true if the road was successfully deleted, false if not
	 */
	@Override
	public boolean deleteRoadConnection(String town1, String town2, String road) {
		return this.g.removeEdge(this.getTown(town1), this.getTown(town2), 0, road) != null? true: false;
	}
	/**
	 * Deletes a town from the graph
	 * @param v name of town (lastname, firstname)
	 * @return true if the town was successfully deleted, false if not
	 */
	@Override
	public boolean deleteTown(String v) {
		return this.g.removeVertex(this.getTown(v));
	}
	/**
	 * Creates an arraylist of all towns in alphabetical order (last name, first name)
	 * @return an arraylist of all towns in alphabetical order (last name, first name)
	 */
	@Override
	public ArrayList<String> allTowns() {
		ArrayList<String> town_title = new ArrayList<String>();
		Set<Town> setTowns = this.g.vertexSet();
		for(Town r: setTowns) {
			town_title.add(r.getName());
		}
		Collections.sort(town_title);
		return town_title;
	}
	/**
	 * Returns the shortest path from town 1 to town 2
	 * @param town1 name of town 1 (lastname, firstname)
	 * @param town2 name of town 2 (lastname, firstname)
	 * @return an Arraylist of roads connecting the two towns together, null if the
	 * towns have no path to connect them.
	 */
	@Override
	public ArrayList<String> getPath(String town1, String town2) {
		return (this.getTown(town1) !=null && this.getTown(town2)!=null) ? 
				this.g.shortestPath(this.getTown(town1), this.getTown(town2)) : null;
	}

	public void populateTownGraph(File selectedFile) throws FileNotFoundException, IOException{
		try {;
		      Scanner myReader = new Scanner(selectedFile);
		      while (myReader.hasNextLine()) {
		    	  String[] Twons = myReader.nextLine().split(";");
		    	  String[] roads = Twons[0].split(",");
		    	  this.addTown(Twons[1].trim());
		    	  this.addTown(Twons[2].trim());
		    	  this.addRoad(Twons[1].trim(), Twons[2].trim(), Integer.parseInt(roads[1]), roads[0].trim());
		      }
		      myReader.close();
		    } catch (FileNotFoundException e) {
		      e.printStackTrace();
		    }
	}

	
}
