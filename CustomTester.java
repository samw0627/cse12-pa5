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
    }

    /**
     * Test the compareTo method when [TODO]
     */
    @Test
    public void testCompareTo() {

    }

    // ----------------Course class----------------
    /**
     * Test the enroll method when [TODO]
     */
    @Test
    public void testEnroll() {

    }

    /**
     * Test the unenroll method when [TODO]
     */
    @Test
    public void testUnenroll() {

    }

    /**
     * Test the getRoster method when [TODO]
     */
    @Test
    public void testGetRoster() {

    }

    // ----------------Sanctuary class----------------
    /**
     * Test the constructor when [TODO]
     */
    @Test
    public void testSanctuaryConstructor() {

    }

    /**
     * Test the rescue method when [TODO]
     */
    @Test
    public void testRescueTestOne(){

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

