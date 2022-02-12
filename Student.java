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
        int lastCompareRaw = this.lastName.compareTo(((Student)o).getLastName());

        int firstCompareRaw = this.firstName.compareTo((((Student) o).getFirstName()));

        int PIDCompareRaw = this.getPID().compareTo((((Student) o).getPID()));

        int lastCompare = 0;
        int firstCompare = 0;
        int PIDCompare = 0;

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
