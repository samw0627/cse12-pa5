///////////////////////////////////////////////////////////////////////////////
//                   
// Main Class File:  Sanctuary.java
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
import java.util.HashMap;
import java.util.Set;

/**
 *  A class that uses HashMap to help organize 
 * all the animals at the sanctuary.
 *
 * Bugs: none known
 *
 * @author       Sam Wong
 */
public class Sanctuary {
    /** Container to store all the animal species in the sanctuary.
    *  The String represents the name of the animal species and 
    * the Integer represents the number of that species at the sanctuary. */
    HashMap<String, Integer> sanctuary; 
    /**The maximum number of animals that the sanctuary can support.*/
    int maxAnimals;
    /**The maximum number of species that the sanctuary can support.*/
    int maxSpecies;

    /**
     * Initialize the HashMap with no elements. 
     * Initialize the other instance variables accordingly.
     * @param maxAnimals
     * @param maxSpecies
     */
    public Sanctuary(int maxAnimals, int maxSpecies) {
        if(maxAnimals < 0 || maxSpecies < 0){
            throw new IllegalArgumentException();
        }
        this.maxAnimals = maxAnimals;
        this.maxSpecies = maxSpecies;
        this.sanctuary = new HashMap<String, Integer>();
    }
    /**
     * Return the number of animals at the sanctuary that are of the given 
     * species. If the given species does not exist at the sanctuary, return 0. 
     * @param Species - the animal species to be calculated
     * @return an integer that represents the total number of animal of a 
     * particular species
     */
    public int getNum(String species) {
        if(species == null){
            throw new IllegalArgumentException();
        }
        //Check if the Hashtable contains target key
        if(!this.sanctuary.containsKey(species)){
            return 0;
        }
        return this.sanctuary.get(species);
    }

    /**
     * Return the total number of animals at the sanctuary. 
     * @return an integer that represents the total number of animals
     */
    public int getTotalAnimals() {
        int sum = 0;
        //Loop through each type of species
        for (String species : this.sanctuary.keySet()) {
            //add to the sum
            sum += this.getNum(species);
        }
        return sum;
    }
     /**
     * Return the total number of species at the sanctuary. 
     * @return an integer that represents the total number of species
     */
    public int getTotalSpecies() {

        return this.sanctuary.keySet().size();
    }

     /**
     * If it does not exceed the maxAnimals nor maxSpecies of the sanctuary, 
     * add num animals of species to the sanctuary. 
     * If adding num animals exceeds a maximum limit, 
     * add as many animals as permitted.
     * @param The type of species to be added
     * @param The number of animals to be added
     * @return an integer that represents the total number of animals that can't
     * be rescued
     */
    public int rescue(String species, int num) {
        if(num <= 0 || species == null){
            throw new IllegalArgumentException();
        }
        //Check if size is sanctuary still has room
        if(this.sanctuary.size()<maxSpecies && this.getTotalAnimals() < 
        maxAnimals){
            int total = this.getTotalAnimals() + num; 
            int overflow;
            if(total > maxAnimals){ //calculate the overflow if at max capacity
                overflow = total - maxAnimals;
                this.sanctuary.put(species, this.getNum(species) + num - 
                overflow); //Fill the animals till max capacity
                return overflow;
            }
            else{
                this.sanctuary.put(species, this.getNum(species) + num);
                return 0;
            }
        }
        return num;
    }
 /**
     * Remove num animals of species from the sanctuary. 
     * Remove the species from the sanctuary if its remaining count reaches 0.
     * @param The type of species to be released
     * @param The number of animals to be released
     * 
     */
    public void release(String species, int num) {
        if(num <= 0 || num> this.getNum(species) || species == null || this.sanctuary.containsKey(species) == false){
            throw new IllegalArgumentException();
        }
        //Release Animals and change the total number of animals
        this.sanctuary.replace(species, this.getNum(species)-num);
        if(this.getNum(species) == 0){
            this.sanctuary.remove(species);
        }
    }
}
