/**
 * CustomTester.java
 * Name: Sam Wong
 * ID: A15975678
 * Email: c6wong@ucsd.edu
 * Sources used:JavaDoc
 * 
 * Custom Tester for Sanctuary, Course and Student. Implements test that have
 * been tested by PublicTester
 */

import java.util.*;
import static org.junit.Assert.*;
import org.junit.*;

/**
 * 11 Tests for Sanctuary, COurse and Student
 *
 * Bugs: none known
 *
 * @author    Sam Wong
 */
public class CustomTester {

    // ----------------Student class----------------
    /**
     * Test the equals method when two students are different
     */
    @Test
    public void testEquals() {
        Student student = new Student("Sam", "Wong", "A12345678");  
        Student student2 = null ;        
      
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
     * Test the rescue method when the sancturary is at max capacity
     */
    @Test
    public void testRescueTestTwo(){
        Sanctuary sanct2 = new Sanctuary(15, 2);
        sanct2.sanctuary.put("Panda", 15);
        assertEquals(5,sanct2.rescue("Parrot", 5));
        assertTrue(sanct2.sanctuary.containsKey("Panda"));
        assertFalse(sanct2.sanctuary.containsKey("Parrot"));
        assertEquals(15, (int)sanct2.sanctuary.get("Panda"));


    }

    @Test
    public void testRescueTestThree(){
        Sanctuary sanct2 = new Sanctuary(10,2);
        sanct2.sanctuary.put("Dog", 1);
        sanct2.rescue("Parrot", 3);
        assertEquals(0,sanct2.rescue("Dog", 2));
        assertTrue(sanct2.sanctuary.containsKey("Dog"));
        assertEquals(3, (int)sanct2.sanctuary.get("Dog"));

       


       


    }

    @Test
    public void testRescueTestFour(){
        Sanctuary sanct2 = new Sanctuary(0,3);
        assertEquals(10, sanct2.rescue("Panda",10));
        assertEquals(10, sanct2.rescue("Panda",10));
        assertEquals(0, sanct2.sanctuary.size() );
    }


        

    /**
     * Test the release method when all animals of that species 
     * have been released
     */
    @Test
    public void testReleaseTestOne(){
        Sanctuary sanctuary = new Sanctuary(40, 5);
        sanctuary.sanctuary.put("Fox", 40);

        sanctuary.release("Fox", 40);
        assertFalse(sanctuary.sanctuary.containsKey("Fox"));


    }

    /**
     * Test the release method when num is less than 0
     */
    @Test
    public void testReleaseTestTwo(){
        Sanctuary sanctuary = new Sanctuary(40, 5);
        sanctuary.sanctuary.put("Fox", 40);

        try{
            sanctuary.release("Fox", 0);
            fail();
        }
        catch(IllegalArgumentException E){
            try{
                sanctuary.release("Fox", 500);
                fail();
            }
            catch(IllegalArgumentException E2){
                try{
                    sanctuary.release(null, 1);
                    fail();
                }
                catch(IllegalArgumentException E3){
                    try{
                        sanctuary.release("Pando", 1);
                        fail();
                    }
                    catch(IllegalArgumentException E4){
            
                    }
                }
        
            }
        }

        

        
      

    }
}

