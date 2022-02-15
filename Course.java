///////////////////////////////////////////////////////////////////////////////
//                   
// Main Class File:  Course.java
// Semester:         Winter 2022
//
// Author:           Sam Wong
// ID:               A15975678
// Emial:           c6wong@ucsd.edu
//
// Sources used:    JavaDoc,Piazza
// Instructor's Name:  Christine Alvorado
//    
//
// Credits:          none
//////////////////////////// 80 columns wide //////////////////////////////////
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
/**
 *  A class that organizes courses
 *
 * Bugs: none known
 *
 * @author       Sam Wong
 */
public class Course {
    /**This is a collection of students that are enrolled in this course. */
    HashSet<Student> enrolled;
    /**This is the maximum number of students that can be enrolled in this course. */
    private final int capacity;
    /**This course falls under this department. */
    private final String department;
    /**This is the course number. */
    private final String number;
    /**This is the description of the course. */
    private final String description;
    /**This is the string template for toString() */
    private final static String TEMPLATE = "%s %s [%s]\n%s";

    
    /**
     * Initialize the course’s information with an 
     * initial enrollment of 0 students.
     * @param department
     * @param number
     * @param description
     * @param capacity
     */
    public Course(String department, String number, String description, int capacity){
            this.department = department;
            this.number = number;
            this.description = description;
            this.capacity = capacity;
            
        }
    /**
     * Return the department name
     * @return department name
     */
    public String getDepartment(){
        return this.department;
    }
    /**
     * Return the course number
     * @return course number
     */
    public String getNumber(){
        return this.number;
    }
    /**
     * Return the description of the course.
     * @return description
     */
    public String getDescription(){
        return this.description;
    }

    /** Return the capacity of the course.
     * @return capacity
    */
    public int getCapacity(){
        return this.capacity;
    }

    /** If there is room in this course and the student is not currently 
     * enrolled, add the student to the course. 
     * Return true for a successful enrollment and false otherwise.
     * @param student
    * @return booekan that indicu=ates if enrollment is successful
    */
    public boolean enroll(Student student) {
        if(student == null){
            throw new IllegalArgumentException();
        }

        if(this.enrolled.size() < this.getCapacity() && 
        this.enrolled.contains(student) == false){ //Check requirements
            this.enrolled.add(student);
            return true;
        }
        return false;
    }

    /** If the student is enrolled in the course, remove them from the course.
     *  Return true for a successful unenrollment and false otherwise. 
     * @param student
    * @return booekan that indicu=ates if unenrollment is successful
    */
    public boolean unenroll(Student student) {
        
        if(student == null){
            throw new IllegalArgumentException();
        }

        if(this.enrolled.contains(student) == true){ // Check condition
            this.enrolled.remove(student);
            return true;
        }
        return false;
    }

    /**If the course is canceled,all of the students are dropped from the course.
     * Remove all the students from the course.
    */
    public void cancel() {
        this.enrolled.clear();
    }

    /**
     * If the course is at its capacity, return true. Otherwise, return false.
     * @return booleran thast indicates if course is full
     */
    public boolean isFull() {
        if(this.enrolled.size() == this.getCapacity()){
            return true;
        }
        return false;
    }
    /**
     * Return the current number of enrolled students.
     * @return total number of student
     */
    public int getEnrolledCount() {
        return this.enrolled.size();
    }

    /**
     * Return the number of students that can still enroll in the course
     *  (assuming everyone stays enrolled).
     * @return integer of available seats
     */
    public int getAvailableSeats() {
        return this.capacity - this.enrolled.size();
    }

    /**
     * Return a shallow copy of all the students enrolled in this course.
     * 
     * @return Hashset of students
     */
    public HashSet<Student> getStudents() {
        return (HashSet<Student>) this.enrolled.clone();
    }
    /**
     * Turn the collection of enrolled students into an ArrayList collection 
     * by iterating through the list using the iterator or a for loop. 
     * @return the final arraylist
     */
    public ArrayList<Student> getRoster() {
        ArrayList<Student> rosterArray = new ArrayList<Student>();
        Iterator<Student> listStud = enrolled.iterator();
        while(listStud.hasNext() == true){ //check if there is nxt element
            rosterArray.add(listStud.next()); //add top arraylist
        }
        Collections.sort(rosterArray); //sort the arraylist based on compare to
                                        // in students
        return rosterArray;
    }

    /**
     * Return a string representation for a Course object. 
     * @return string representation of course based on template format
     */
    public String toString() {
        return String.format(TEMPLATE, this.department, this.number,
         this.capacity, this.description);
    }
}

