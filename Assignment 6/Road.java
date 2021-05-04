
/**
 * @author Frank Choukouali
 *The class Road that can represent the edges of a Graph of Towns. 
 *The class must implement Comparable. The class stores references to the two vertices(Town endpoints), 
 *the distance between vertices, and a name, and the traditional methods (constructors, getters/setters, toString, etc.), 
 *and a compareTo, which compares two Road objects. 
 *Since this is a undirected graph, an edge from A to B is equal to an edge from B to A.
 */
public class Road implements Comparable<Road> {
	private Town source;
	private Town destination;
	private int weight;
	private String name;
	
	public Road(Town source, Town destination, int weight, String name) {
		this.source=source;
		this.destination = destination;
		this.weight = weight;
		this.name = name;
	}
	public Road(Town source, Town destination,  String name) {
		this.source=source;
		this.destination = destination;
		this.weight = 1;
		this.name = name;
	}

	


	public String getName() {
		return name;
	}

	@Override
	public int compareTo(Road arg0) {
		return this.name.compareTo(arg0.name);
	}
	public boolean contains(Town town) {
		return town.equals(this.source) || town.equals(this.destination);
	}
	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public Town getDestination() {
		return destination;
	}

	public void setDestination(Town destination) {
		this.destination = destination;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Town getSource() {
		return source;
	}

	public void setSource(Town source) {
		this.source = source;
	}

	@Override
	public String toString() {
		return this.getName();
	}

	

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Road other = (Road) obj;
		if (destination == null) {
			if (other.destination != null)
				return false;
		} else if (!destination.equals(other.destination))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (source == null) {
			if (other.source != null)
				return false;
		} else if (!source.equals(other.source))
			return false;
		if (weight != other.weight)
			return false;
		return true;
	}

}
