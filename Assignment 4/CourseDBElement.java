
/**
 * @author Frank Choukouali
 *CourseDBElement implements Comparable, and consists of five attributes: 
 *the Course ID (a String), the CRN (an int), 
 *the number of credits (an int), 
 *the room number (a String), and 
 *the instructor name (a String).   
 */
public class CourseDBElement implements Comparable {
	private String courseID;
	private int crn;
	private int number_of_credits;
	private String room_number;
	private String intructor_name;

	/**
	 * Default Constructor
	 */
	public CourseDBElement() {
		this.courseID=null;
		this.room_number=null;
		this.intructor_name = null;
		this.crn=0;
		this.number_of_credits=0;
	}
	
	/**
	 * Parameterized constructor
	 * @param courseID
	 * @param crn
	 * @param number_of_credits
	 * @param room_number
	 * @param intructor_name
	 */
	public CourseDBElement(String courseID, int crn, int number_of_credits, String room_number, String intructor_name) {
		this.courseID = courseID;
		this.crn = crn;
		this.number_of_credits = number_of_credits;
		this.room_number = room_number;
		this.intructor_name = intructor_name;
	}

	/**
	 *
	 */
	public boolean compareTo(CourseDBElement courseDBElement) {
		if (this.crn > courseDBElement.crn) 
			return true;
		if (this.crn == courseDBElement.crn) 
			return false;
		
		return false;
		
	}
	
	/*
	 * Setters and Getters
	 */

	/**
	 * return the course ID
	 * @return courseID
	 */
	public String getCourseID() {
		return courseID;
	}

	/**
	 * Changes the value of courseID to the new one in parameter
	 * @param courseID
	 */
	public void setCourseID(String courseID) {
		this.courseID = courseID;
	}

	/**
	 * return the crn of the course
	 * @return crn
	 */
	public int getCRN() {
		return crn;
	}

	/**
	 * Changes the value of crn to the new one in parameter
	 * @param crn
	 */
	public void setCRN(int crn) {
		this.crn = crn;
	}

	/**
	 * return the number of credits of the course
	 * @return number_of_credits
	 */
	public int getNumber_of_credits() {
		return number_of_credits;
	}

	/**
	 * Changes the value of number_of_credits to the new one in parameter
	 * @param number_of_credits
	 */
	public void setNumber_of_credits(int number_of_credits) {
		this.number_of_credits = number_of_credits;
	}

	/**
	 * return the room number of the course
	 * @return room_number
	 */
	public String getRoom_number() {
		return room_number;
	}

	/**
	 * Changes the value of room_number to the new one in parameter
	 * @param room_number
	 */
	public void setRoom_number(String room_number) {
		this.room_number = room_number;
	}

	/**
	 * return the intructor name of the course
	 * @return intructor_name
	 */
	public String getIntructor_name() {
		return intructor_name;
	}

	/**
	 * Changes the value of intructor_name to the new one in parameter
	 * @param intructor_name
	 */
	public void setIntructor_name(String intructor_name) {
		this.intructor_name = intructor_name;
	}
	public String toString() {
		return "\nCourse:"+this.getCourseID()+" CRN:"+this.getCRN()
		+" Credits:"+ this.getNumber_of_credits() +" Instructor:"
				+ this.getIntructor_name() +" Room:"+ this.getRoom_number();
	  }
	@Override
	public int hashCode() {
		
		
		String crn_string = String.valueOf(getCRN());
	    long result = 1;
	    final  int prime = 31;
	    for (int i = 0; i < crn_string.length(); i++) {
	    	result = prime * result + crn_string.charAt(i);
	    }
	    return (int) result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CourseDBElement other = (CourseDBElement) obj;
		
		if (crn != other.crn)
			return false;
		
		return true;
	}

	

	
	
}
