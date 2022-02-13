/**
 * TODO: Add your file header
 * Name:
 * ID:
 * Email:
 * Sources used: Put "None" if you did not have any external help
 * Some example of sources used would be Tutors, Zybooks, and Lecture Slides
 * 
 * 2-4 sentence file description here
 */

import java.util.*;
import static org.junit.Assert.*;
import org.junit.*;

/**
 * TODO: Add your class header
 * 
 * IMPORTANT: Do not change the method names and points are awarded
 * only if your test cases cover cases that the public tester file
 * does not take into account.
 */
public class CustomTester {

    // ----------------Student class----------------
    /**
     * Test the equals method when two students are different
     */
    @Test
    public void testEquals() {
        Student student = new Student("Sam", "Wong", "A12345678");  
        Student student2 = new Student("Sam", "Lee", "A12345678");        
      
        assertFalse(student.equals(student2));

        Student student3 = new Student("Sam","Wong","A45678903");
        assertFalse(student.equals(student3));

    }

    /**
     * Test the compareTo method when students compared are different
     */
    @Test
    public void testCompareTo() {
        Student student = new Student("Sam", "Wong", "A12345678"); 
        Student student2 = new Student("TJ", "Haas", "A23456789");        
        
        assertEquals(1, student.compareTo(student2));

        Student student3 = new Student("Thomas", "Wong", "A64926593"); 
        assertEquals(-1, student.compareTo(student3));

        Student student4 = new Student("Larry", "Lee", "A34567890");
        Student student5 = new Student("Larry", "Lee", "A56789012");
        assertEquals(-1, student4.compareTo(student5));

    }

    // ----------------Course class----------------
    /**
     * Test the enroll method when student is enrolled already
     */
    @Test
    public void testEnroll() {
        Student student = new Student("Sam", "Wong", "A12345678"); 
        Course cse12 = new Course("CSE", "12", "Data Structures", 196);
        cse12.enrolled = new HashSet<>();
        cse12.enroll(student);
        assertFalse("Student Already Enrolled", cse12.enroll(student));        
       
    }

    /**
     * Test the unenroll method when student is null.
     */
    @Test
    public void testUnenroll() {
        Student student = new Student("Sam", "Wong", "A12345678"); 
        Course cse12 = new Course("CSE", "12", "Data Structures", 196);
        cse12.enrolled = new HashSet<>();
        cse12.enroll(student);
        cse12.unenroll(student);
        assertFalse("Student Does Not Exist", cse12.unenroll(student));
    }

    /**
     * Test the getRoster method when all students have lexicalgraphically 
     * different last names
     */
    @Test
    public void testGetRoster() {
        Course cogs120 = new Course("COGS", "120", "Intro to HCI", 300);
        ArrayList<Student> roster = new ArrayList<Student>();
        Student student = new Student("Sam", "Wong", "A12345678"); 
        Student student2 = new Student("George", "Luo", "A16745435"); 
        Student student3 = new Student("Esther", "Tsai", "A98453627"); 
        Student student4 = new Student("Matthew", "Kong", "A15865748");
        cogs120.enrolled = new HashSet<>();
        cogs120.enroll(student);
        cogs120.enroll(student2);
        cogs120.enroll(student3);
        cogs120.enroll(student4);
        roster = cogs120.getRoster();
        assertEquals(student4, roster.get(0));
        assertEquals(student2, roster.get(1));
        assertEquals(student3, roster.get(2));
        assertEquals(student, roster.get(3));

    }

    @Test
    public void testGetRoster2() {
        Course cogs120 = new Course("COGS", "120", "Intro to HCI", 300);
        ArrayList<Student> roster = new ArrayList<Student>();
        Student student = new Student("Timothy", "Lee", "A12345678"); 
        Student student2 = new Student("Linda", "Lee", "A16745435"); 
        Student student3 = new Student("Avery", "Lee", "A98453627"); 
        Student student4 = new Student("Matthew", "Lee", "A15865748");
        cogs120.enrolled = new HashSet<>();
        cogs120.enroll(student);
        cogs120.enroll(student2);
        cogs120.enroll(student3);
        cogs120.enroll(student4);
        roster = cogs120.getRoster();
        assertEquals(student3, roster.get(0));
        assertEquals(student2, roster.get(1));
        assertEquals(student4, roster.get(2));
        assertEquals(student, roster.get(3));

    }

    // ----------------Sanctuary class----------------
    /**
     * Test the constructor when exception is thrown
     */
    @Test
    public void testSanctuaryConstructor() {
        try{
            Sanctuary sanct = new Sanctuary(-1, -50);
            fail();
        }
        catch (IllegalArgumentException e){
        }
    }

    /**
     * Test the rescue method when max animal is smaller than number of animals
     * rescued.
     */
    @Test
    public void testRescueTestOne(){
        Sanctuary sanct2 = new Sanctuary(15, 2);
        assertEquals(5, sanct2.rescue("Panda", 20));
        assertTrue(sanct2.sanctuary.containsKey("Panda"));
        assertEquals(15, (int)sanct2.sanctuary.get("Panda"));

    }

    /**
     * Test the rescue method when [TODO: fill in another one here]
     */
    @Test
    public void testRescueTestTwo(){

    }

    /**
     * Test the release method when [TODO]
     */
    @Test
    public void testReleaseTestOne(){

    }

    /**
     * Test the release method when [TODO:fill in another one here]
     */
    @Test
    public void testReleaseTestTwo(){

    }
}

