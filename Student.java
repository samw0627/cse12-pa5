/**
 * TODO: Complete the solution for Student
 */
import java.util.Objects;

public class Student implements Comparable<Student> {
    private final String firstName;
    private final String lastName;
    private final String PID;

    public Student(String firstName, String lastName, String PID) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.PID = PID;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getPID() {
        return this.PID;
    }

    @Override
    public boolean equals(Object o) {
        if(o == null){
            return false;
        }
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

    @Override
    public int hashCode() {
        return Objects.hash(firstName,lastName,PID);
    }

    @Override
    public int compareTo(Student o) {
        if(this.equals(o)){
            return 0;
        }
        int lastCompare = this.lastName.compareTo(((Student)o).getLastName());
        int firstCompare = this.firstName.compareTo((((Student) o).getFirstName()));
        int PIDCompare = this.getPID().compareTo((((Student) o).getPID()));

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
