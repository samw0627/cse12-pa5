/**
 * TODO: Complete the solution for Course
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;

public class Course {
    HashSet<Student> enrolled;
    private final int capacity;
    private final String department;
    private final String number;
    private final String description;
    private final static String TEMPLATE = "%s %s [%s]\n%s";

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
        return this.description;
    }

    public int getCapacity(){
        return this.capacity;
    }

    public boolean enroll(Student student) {
        if(student == null){
            throw new IllegalArgumentException();
        }

        if(this.enrolled.size() < this.getCapacity() && 
        this.enrolled.contains(student) == false){
            this.enrolled.add(student);
            return true;
        }
        return false;
    }

    public boolean unenroll(Student student) {
        
        if(student == null){
            throw new IllegalArgumentException();
        }

        if(this.enrolled.contains(student) == true){
            this.enrolled.remove(student);
            return true;
        }
        return false;
    }

    public void cancel() {
        this.enrolled.clear();
    }

    public boolean isFull() {
        if(this.enrolled.size() == this.getCapacity()){
            return true;
        }
        return false;
    }

    public int getEnrolledCount() {
        return this.enrolled.size();
    }

    public int getAvailableSeats() {
        return this.capacity - this.enrolled.size();
    }

    public HashSet<Student> getStudents() {
        return this.enrolled;
    }

    public ArrayList<Student> getRoster() {
        ArrayList<Student> rosterArray = new ArrayList<Student>();
        Iterator<Student> listStud = enrolled.iterator();
        while(listStud.hasNext() == true){
            rosterArray.add(listStud.next());
        }
        Collections.sort(rosterArray);
        return rosterArray;
    }

    public String toString() {
        return String.format(TEMPLATE, this.department, this.number,
         this.capacity, this.description);
    }
}

