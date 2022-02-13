/**
 * TODO: Complete the solution for Course
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class Course {
    HashSet<Student> enrolled;
    private final int capacity;
    private final String department;
    private final String number;
    private final String description;

    public Course(String department, String number, String description, int capacity){
            this.department = department;
            this.number = number;
            this.description = description;
            this.capacity = capacity;
        }

    public String getDepartment(){
        return this.department;
    }

    public String getNumber(){
        return this.number;
    }

    public String getDescription(){
        return this.department;
    }

    public int getCapacity(){
        return this.capacity;
    }

    public boolean enroll(Student student) {
        if(student == null){
            throw new IllegalArgumentException();
        }

        if(enrolled.size() < this.getCapacity() && enrolled.contains(student) == false){
            enrolled.add(student);
            return true;
        }
        return false;
    }

    public boolean unenroll(Student student) {
        
        if(student == null){
            throw new IllegalArgumentException();
        }

        if(enrolled.contains(student) == true){
            enrolled.remove(student);
            return true;
        }
        return false;
    }

    public void cancel() {
        enrolled.clear();
    }

    public boolean isFull() {
        return false;
    }

    public int getEnrolledCount() {
        return 0;
    }

    public int getAvailableSeats() {
        return 0;
    }

    public HashSet<Student> getStudents() {
        return null;
    }

    public ArrayList<Student> getRoster() {
        return null;
    }

    public String toString() {
        return null;
    }
}

