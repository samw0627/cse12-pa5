/**
 * TODO: Complete the solution for Sanctuary
 */
import java.util.HashMap;
import java.util.Set;

public class Sanctuary {
    
    HashMap<String, Integer> sanctuary;
    int maxAnimals;
    int maxSpecies;

    public Sanctuary(int maxAnimals, int maxSpecies) {
        if(maxAnimals < 0 || maxSpecies < 0){
            throw new IllegalArgumentException();
        }
        this.maxAnimals = maxAnimals;
        this.maxSpecies = maxSpecies;
        this.sanctuary = new HashMap<String, Integer>();
    }

    public int getNum(String species) {
        if(species == null){
            throw new IllegalArgumentException();
        }
        if(!this.sanctuary.containsKey(species)){
            return 0;
        }
        return this.sanctuary.get(species);
    }
    
    public int getTotalAnimals() {
        int sum = 0;
        for (String species : this.sanctuary.keySet()) {
            sum += this.getNum(species);
        }
        return sum;
    }
    
    public int getTotalSpecies() {

        return this.sanctuary.keySet().size();
    }

    public int rescue(String species, int num) {
        if(num <= 0 || species == null){
            throw new IllegalArgumentException();
        }
        if(this.sanctuary.size()<maxSpecies && this.getTotalAnimals() < maxAnimals){
            int total = this.getTotalAnimals() + num;
            int overflow;
            if(total > maxAnimals){
                overflow = total - maxAnimals;
                this.sanctuary.put(species, this.getNum(species) + num - overflow);
                return overflow;
            }
            else{
                this.sanctuary.put(species, this.getNum(species) + num);
                return 0;
            }
        }
        return num;
    }

    public void release(String species, int num) {
        if(num <= 0 || num> this.getNum(species) || species == null || this.sanctuary.containsKey(species) == false){
            throw new IllegalArgumentException();
        }
        this.sanctuary.replace(species, this.getNum(species)-num);
        if(this.getNum(species) == 0){
            this.sanctuary.remove(species);
        }
    }
}
