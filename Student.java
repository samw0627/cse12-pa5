///////////////////////////////////////////////////////////////////////////////
//                   
// Main Class File:  Student.java
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
import java.util.Objects;

/**
 *  A class that organizes students
 *
 * Bugs: none known
 *
 * @author       Sam Wong
 */
public class Student implements Comparable<Student> {
    /**A string representing the first name of the student.*/
    private final String firstName;
    /**A string representing the last name of the student. */
    private final String lastName;
    /**A string representing the PID of the student. 
     * This is unique for each student.*/
    private final String PID;

    /**
     * Initialize the student’s information
     * Initialize the other instance variables accordingly.
     * @param firstName
     * @param lastName
     * @param PID
     */
    public Student(String firstName, String lastName, String PID) {
        if(firstName == null || lastName == null || PID == null){
            throw new IllegalArgumentException();
        }
        this.firstName = firstName;
        this.lastName = lastName;
        this.PID = PID;
    }

    /**
     * Return the student’s last name
     * @return last name
     */
    public String getLastName() {
        return this.lastName;
    }
    /**
     * Return the student’s First name
     * @return First name
     */
    public String getFirstName() {
        return this.firstName;
    }

     /**
     * Return the student’s PID
     * @return PID
     */
    public String getPID() {
        return this.PID;
    }

    /**Returns true if o is also a non-null Student and all the instance 
     * variables of o equal the instance variable of the current Student 
     * object. Otherwise, return false.
     * @param Student Object
     * @return a boolean that checks if objects are equal */
    @Override
    public boolean equals(Object o) {
        if(o == null){
            return false;
        }
        if(o instanceof Student){
            if(!this.firstName.equals((((Student) o).getFirstName()))){
                return false;
            }
            if(!this.lastName.equals((((Student) o).getLastName())) ){
                return false;
            }
            if(!this.getPID().equals((((Student) o).getPID()))){
                return false;
            }
            return true;
        }
       
        return false;
    }
    /**
    * Return the hash value generated by Object’s hash function. 
    * The hash function should generate a hash value in the order of 
        the student’s firstName, lastName, and PID.
    * @return integer hash value
    */
    @Override
    public int hashCode() {
        return Objects.hash(firstName,lastName,PID);
    }
    /**
     * Returns 0 if all the instance variables are equivalent. 
     * Returns a negative value if the current object 
     * lexicographically comes before Student o. 
     * Returns a positive value if the current object lexicographically 
     * comes after Student o. 
     * @param Student object
     * @param Integer: result of comparison
     */
    @Override
    public int compareTo(Student o) {
        if(this.equals(o)){
            return 0;
        }
        //Get the raw comparison score
        int lastCompareRaw = this.lastName.compareTo(((Student)o).
        getLastName());

        int firstCompareRaw = this.firstName.compareTo((((Student) o).
        getFirstName()));

        int PIDCompareRaw = this.getPID().compareTo((((Student) o).getPID()));

        int lastCompare = 0;
        int firstCompare = 0;
        int PIDCompare = 0;
        //Map the score to -1,0,1
        if(lastCompareRaw > 0){
            lastCompare = 1;
        }
        if(lastCompareRaw < 0){
            lastCompare = -1;
        }

        if(firstCompareRaw > 0){
            firstCompare = 1;
        }
        if(firstCompareRaw < 0){
            firstCompare = -1;
        }
        if(PIDCompareRaw > 0){
            PIDCompare = 1;
        }
        if(PIDCompareRaw < 0){
            PIDCompare = -1;
        }
        //return the results
        if(lastCompare == 0){
            if(firstCompare == 0){
                return PIDCompare;
            }
            else{
                return firstCompare;
            }
        }
        else{
            return lastCompare;
        }
    }
}
