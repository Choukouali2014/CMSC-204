import java.io.IOException;
import java.util.LinkedList;
/**
 * @author Frank Choukouali
 *
 */
public class CourseDBStructure implements CourseDBStructureInterface {

	public LinkedList<CourseDBElement>[] hashTable;
	

	/**
	 * @param number
	 */
	@SuppressWarnings("unchecked")
	public CourseDBStructure(int number) {
		this.hashTable = new LinkedList[number];
	}
	/**
	 * 
	 */
	@SuppressWarnings("unchecked")
	public CourseDBStructure() {
		this.hashTable = new LinkedList[0];
	}

	/**
	 * @param string
	 * @param i
	 */
	@SuppressWarnings("unchecked")
	public CourseDBStructure(String string, int i) {
		this.hashTable = new LinkedList[i];
	}

	/** 
	* Use the hashcode of the CourseDatabaseElement to see if it is 
	* in the hashtable.
	* 
	* If the CourseDatabaseElement does not exist in the hashtable,
	* add it to the hashtable.
	* 
	* @param element the CDE to be added
	*/
	@Override
	public void add(CourseDBElement courseDBElement) {
		int i = getHash(courseDBElement);
		if (hashTable[i] == null) {
		      hashTable[i] = new LinkedList<CourseDBElement>();
		      hashTable[i].add(courseDBElement);
		    } else {
		      if (hashTable[i].contains(courseDBElement))
		        return;
		      else
		        hashTable[i].add(courseDBElement);
		    }
	}

	/** 
	* Use the hashcode of the CourseDatabaseElement to see if it is 
	* in the hashtable.
	* 
	* If the CourseDatabaseElement is in the hashtable, return it
	* If not, throw an IOException
	* 
	* @param element the CDE to be added
	 * @throws IOException 
	*/
	@Override
	public CourseDBElement get(int crn) throws IOException {
		 CourseDBElement cde_temp = new CourseDBElement();
		 cde_temp.setCRN(crn);
		    int i = getHash(cde_temp);
		for (CourseDBElement courseDBElmt: hashTable[i]) {
			if (courseDBElmt.getCRN() == crn)
				return courseDBElmt;
		}
		throw new IOException("Element not found");
	}

	/**
	* Returns the size of the ConcordanceDataStructure (number of indexes in the array)
	*/
	@Override
	public int getTableSize() {
		return this.hashTable.length;
	}
	
	
	  /**
	   * Returns the index 
		 * @param cde
		 * @return the element index
		 */
	private int getHash(CourseDBElement cde) {
	    int i = cde.hashCode() % this.hashTable.length;
	    if (i < 0) {
	      i += hashTable.length;
	    }
	    return i;
	  }

}
