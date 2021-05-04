import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Graph implements GraphInterface<Town, Road> {
	private HashSet<Town> setTowns = new HashSet<Town>();
	private HashSet<Road> setRoads = new HashSet<Road>();
	private ArrayList<Town> unvisitedV;
	private ArrayList<Town> visitedV;
	/**
     * Returns an edge connecting source vertex to target vertex if such
     * vertices and such edge exist in this graph. Otherwise returns
     * null. If any of the specified vertices is null
     * returns null
     *
     * In undirected graphs, the returned edge may have its source and target
     * vertices in the opposite order.
     *
     * @param sourceVertex source vertex of the edge.
     * @param destinationVertex target vertex of the edge.
     *
     * @return an edge connecting source vertex to target vertex.
     */
	@Override
	public Road getEdge(Town sourceVertex, Town destinationVertex) {
		for(Road road: setRoads) 
			if(road.contains(sourceVertex) && road.contains(destinationVertex))
				return road;
		
		return null;
	}
	/**
     * Creates a new edge in this graph, going from the source vertex to the
     * target vertex, and returns the created edge. 
     * 
     * The source and target vertices must already be contained in this
     * graph. If they are not found in graph IllegalArgumentException is
     * thrown.
     *
     *
     * @param sourceVertex source vertex of the edge.
     * @param destinationVertex target vertex of the edge.
     * @param weight weight of the edge
     * @param description description for edge
     *
     * @return The newly created edge if added to the graph, otherwise null.
     *
     * @throws IllegalArgumentException if source or target vertices are not
     * found in the graph.
     * @throws NullPointerException if any of the specified vertices is null.
     */
	@Override
	public Road addEdge(Town sourceVertex, Town destinationVertex, int weight, String description) {
		if(sourceVertex ==null || destinationVertex==null) throw new NullPointerException();
		if(!containsVertex(sourceVertex) || !containsVertex(destinationVertex)) throw new IllegalArgumentException();
		Road road = new Road(sourceVertex,destinationVertex,weight,description);
		sourceVertex.setAdjacentTown(destinationVertex); destinationVertex.setAdjacentTown(sourceVertex);
		setRoads.add(road);
		return road;
	}
	/**
     * Adds the specified vertex to this graph if not already present. More
     * formally, adds the specified vertex, v, to this graph if
     * this graph contains no vertex u such that
     * u.equals(v). If this graph already contains such vertex, the call
     * leaves this graph unchanged and returns false. In combination
     * with the restriction on constructors, this ensures that graphs never
     * contain duplicate vertices.
     *
     * @param v vertex to be added to this graph.
     *
     * @return true if this graph did not already contain the specified
     * vertex.
     *
     * @throws NullPointerException if the specified vertex is null.
     */
	@Override
	public boolean addVertex(Town v) {
		if(v==null) throw new NullPointerException();
		if(!setTowns.contains(v)) {
			setTowns.add(v);
			return true;
		}
		
		
		return false;
	}
	/**
     * Returns true if and only if this graph contains an edge going
     * from the source vertex to the target vertex. In undirected graphs the
     * same result is obtained when source and target are inverted. If any of
     * the specified vertices does not exist in the graph, or if is
     * null, returns false.
     *
     * @param sourceVertex source vertex of the edge.
     * @param destinationVertex target vertex of the edge.
     *
     * @return true if this graph contains the specified edge.
     */
	@Override
	public boolean containsEdge(Town sourceVertex, Town destinationVertex) {
		for (Road rd : setRoads) 
			if ((rd.getSource().equals(sourceVertex) && rd.getDestination().equals(destinationVertex)))
				return true;
		
		return false;
	}
	/**
     * Returns true if this graph contains the specified vertex. More
     * formally, returns true if and only if this graph contains a
     * vertex u such that u.equals(v). If the
     * specified vertex is null returns false.
     *
     * @param v vertex whose presence in this graph is to be tested.
     *
     * @return true if this graph contains the specified vertex.
     */
	@Override
	public boolean containsVertex(Town v) {
		for(Town town: setTowns)
			if(town.equals(v))
				return true;
		return false;
	}

	@Override
	public Set<Road> edgeSet() {
		return setRoads;
	}
	 /**
     * Returns a set of all edges touching the specified vertex (also
     * referred to as adjacent vertices). If no edges are
     * touching the specified vertex returns an empty set.
     *
     * @param vertex the vertex for which a set of touching edges is to be
     * returned.
     *
     * @return a set of all edges touching the specified vertex.
     *
     * @throws IllegalArgumentException if vertex is not found in the graph.
     * @throws NullPointerException if vertex is null.
     */

	@Override
	public Set<Road> edgesOf(Town vertex) {
		if(vertex == null ) throw new NullPointerException();
		if(!containsVertex(vertex)) throw new IllegalArgumentException();
		
		Set<Road> stRoad = new HashSet<>();
		for(Road road: setRoads) {
			if(road.contains(vertex))
				stRoad.add(road);
		}
		return stRoad;
	}
	/**
     * Removes an edge going from source vertex to target vertex, if such
     * vertices and such edge exist in this graph. 
     * 
     * If weight >- 1 it must be checked
     * If description != null, it must be checked 
     * 
     * Returns the edge if removed
     * or null otherwise.
     *
     * @param sourceVertex source vertex of the edge.
     * @param destinationVertex target vertex of the edge.
     * @param weight weight of the edge
     * @param description description of the edge
     *
     * @return The removed edge, or null if no edge removed.
     */

	@Override
	public Road removeEdge(Town sourceVertex, Town destinationVertex, int weight, String description) {
		 Road returnRoad = null;
		if(weight>-1 || description != null) {
			for(Road rd: setRoads) {
				if(rd.contains(sourceVertex) && rd.contains(destinationVertex)) {
					returnRoad = rd;
					setRoads.remove(rd);
					return returnRoad;
				}
			}
		}
		return null;
	}
	/**
     * Removes the specified vertex from this graph including all its touching
     * edges if present. More formally, if the graph contains a vertex 
     * u such that u.equals(v), the call removes all edges
     * that touch u and then removes u itself. If no
     * such u is found, the call leaves the graph unchanged.
     * Returns true if the graph contained the specified vertex. (The
     * graph will not contain the specified vertex once the call returns).
     *
     * If the specified vertex is null returns false.
     *
     * @param v vertex to be removed from this graph, if present.
     *
     * @return true if the graph contained the specified vertex;
     * false otherwise.
     */
	@Override
	public boolean removeVertex(Town v) {
		if(v!=null) {
			for(Town t: setTowns) {
				if(t.equals(v)) {
					ArrayList<Town> adjacent = t.getAdjacentTown();
					for(Town adjt: adjacent ) 
						setRoads.remove(this.getEdge(v, adjt));
				setTowns.remove(v);
				return true;
				}
			}
			
		}
		return false;
	}

	@Override
	public Set<Town> vertexSet() {
		return setTowns;
	}
	

    /**
     * Find the shortest path from the sourceVertex to the destinationVertex
     * call the dijkstraShortestPath with the sourceVertex
     * @param sourceVertex starting vertex
     * @param destinationVertex ending vertex
     * @return An arraylist of Strings that describe the path from sourceVertex
     * to destinationVertex
     * They will be in the format: startVertex "via" Edge "to" endVertex weight
	 * As an example: if finding path from Vertex_1 to Vertex_10, the ArrayList<String>
	 * would be in the following format(this is a hypothetical solution):
	 * Vertex_1 via Edge_2 to Vertex_3 4 (first string in ArrayList)
	 * Vertex_3 via Edge_5 to Vertex_8 2 (second string in ArrayList)
	 * Vertex_8 via Edge_9 to Vertex_10 2 (third string in ArrayList)
     */ 

	@Override
	public ArrayList<String> shortestPath(Town sourceVertex, Town destinationVertex) {
		this.dijkstraShortestPath(sourceVertex);
		ArrayList<String> result = new ArrayList<String>(); 
		Town dest = destinationVertex;
		Town pTown =  destinationVertex.getPrevious();
		while(pTown != null) {
			Road r = this.getEdge(pTown, dest);
			result.add(pTown.getName()+" via "+r.getName()+" to "
			+dest.getName()+ " "+r.getWeight()+" mi");
			dest=pTown;
			pTown = dest.getPrevious();
		}
		Collections.reverse(result);
		return result;
	}
	
	/**
     * Dijkstra's Shortest Path Method.  Internal structures are built which
     * hold the ability to retrieve the path, shortest distance from the
     * sourceVertex to all the other vertices in the graph, etc.
     * @param sourceVertex the vertex to find shortest path from
     * 
     */

	@Override
	public void dijkstraShortestPath(Town sourceVertex) {
		 unvisitedV = new ArrayList<Town>();
		 visitedV = new ArrayList<Town>();

		 for(Town town: setTowns)
			 unvisitedV.add(town);
		 
		 sourceVertex.setWeight(0);
		 
		 while(!unvisitedV.isEmpty()) {
			 int dist=0;
			 int shortDist = Integer.MAX_VALUE;
			 Town shortTown=null;
			 for(int i=0;i<this.unvisitedV.size();i++) {
				 if(this.unvisitedV.get(i).getWeight()< shortDist) {
					 shortTown = unvisitedV.get(i);
					 shortDist = this.unvisitedV.get(i).getWeight();
				 }
			 }
			 if(shortTown!=null) {
				 shortTown.setVisited(true);
				 dist+= shortDist;
				 ArrayList<Town> adjs = shortTown.getAdjacentTown();
				 for(Town town: adjs) {
					 if(!town.isVisited()) {
						int newDist = calWeight(shortTown,town,dist);
						 if(newDist < town.getWeight()) {
							 town.setWeight(newDist);
							 town.setPrevious(shortTown);
						 }
					 }
				 }
				 visitedV.add(shortTown);
				 unvisitedV.remove(shortTown);
			 }else { break;}
			 
		 }
		
	}
	
	/**
	 * @param t_1
	 * @param t_2
	 * @param old_weight
	 * @return the new Weight
	 */
	public int calWeight(Town t_1, Town t_2, int old_weight) {
		return this.getEdge(t_1, t_2).getWeight()+old_weight;
	}

}
