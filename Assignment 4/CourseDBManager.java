import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;
/**
 * @author Frank Choukouali
 *
 */
public class CourseDBManager implements CourseDBManagerInterface {
	
	CourseDBStructure courseDBStructure = new CourseDBStructure(5);

	/**
	 * Adding a CDE
	 * @param courseID
	 * @param crn
	 * @param number_of_credits
	 * @param room_number
	 * @param intructor_name
	 */
	@Override
	public void add(String id, int crn, int credits, String roomNum, String instructor) {
		CourseDBElement courseDBElt= new CourseDBElement(id,crn,credits,roomNum,instructor);
		courseDBStructure.add(courseDBElt);

	}

	/**
	 * Read file 
	 *@param input
	 */
	@Override
	public void readFile(File input) throws FileNotFoundException {
		
		try {
			Scanner myReader = new Scanner(input);
			while (myReader.hasNextLine()) {
				String[] args = myReader.nextLine().split(" ");
				String name = "";
				for (int i = 4; i < args.length; i++) {
					name += args[i] + " ";
				}
				add(args[0], Integer.parseInt(args[1]), Integer.parseInt(args[2]), args[3], name);
			}
			myReader.close();

		} catch (FileNotFoundException e) {
			throw new FileNotFoundException("File not found.");
		}
		
		
	}

	/**
	 *Show all elements available in the list
	 */
	@Override
	public ArrayList<String> showAll() {
		ArrayList<String> lists = new ArrayList<String>();
		for(LinkedList<CourseDBElement> linkedlistCourseDB: courseDBStructure.hashTable) {
			
			if(linkedlistCourseDB !=null) 
				for(CourseDBElement courseDBElement: linkedlistCourseDB) {
					String oneCourseELmt = "\nCourse:"+courseDBElement.getCourseID()+" CRN:"+courseDBElement.getCRN()+" Credits:"+ courseDBElement.getNumber_of_credits() +" Instructor:"+ courseDBElement.getIntructor_name() +" Room:"+ courseDBElement.getRoom_number();
					
					lists.add(oneCourseELmt);
				}
			
		}
		return lists;
	}

	/**
	 * Retrieve a specific course with its crn
	 * @param crn
	 * @return a CourseDBElement
	 */
	@Override
	public CourseDBElement get(int crn) {
		try {
			return courseDBStructure.get(crn);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}
