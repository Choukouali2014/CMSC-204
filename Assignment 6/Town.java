import java.util.ArrayList;

/**
 * @author Frank Choukouali
 * Represents an town as a node of a graph. 
 * The Town class holds the name of the town and a list of adjacent towns, and other fields as desired, 
 * and the traditional methods (constructors, getters/setters, toString, etc.). 
 * It will implement the Comparable interface These are the minimum methods that are needed. 
 * Please feel free to add as many methods as you need.
 *
 */
public class Town implements Comparable<Town> {
	private String name;
	private Town previous;
	private int weight;
	boolean isVisited;
	private ArrayList<Town> adjacentTown;
	
	public Town(String name) {
		this.name = name;
		this.adjacentTown = new ArrayList<Town>();
		this.weight= Integer.MAX_VALUE;
		this.isVisited=false;
	}

	public Town(Town t) {
		this.name = t.name;
		this.adjacentTown = t.adjacentTown;
		this.weight= t.weight;
		this.previous = t.previous;
		this.isVisited=t.isVisited;
	}
	
	public void setName(String townName) {
		this.name = townName;
	}
	public boolean isVisited() {
		return isVisited;
	}

	public void setVisited(boolean isVisited) {
		this.isVisited = isVisited;
	}

	public String getName() {
		return name;
	}

	public Town getPrevious() {
		return previous;
	}

	public void setPrevious(Town previous) {
		this.previous = previous;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	@Override
	public int compareTo(Town arg0) {
		return this.name.compareTo(arg0.name);
		
	}

	@Override
	public int hashCode() {
		return name.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Town other = (Town) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	public ArrayList<Town> getAdjacentTown() {
		return adjacentTown;
	}

	public void setAdjacentTown(Town adjacentTown) {
		this.adjacentTown.add(adjacentTown);
	}
	
	

}
