import java.util.Arrays;
import java.util.Comparator;

public class Pakudex {

    private int maxCapacity;
    private static Pakuri pakArray[];

    public Pakudex() {
        //initialize a Pakudex with a max capacity of 20 if no parameters given
        maxCapacity = 20;
        pakArray = new Pakuri [maxCapacity];
    }

    public Pakudex(int capacity) {
        //initialize a Pakudex with the capacity from the user
        maxCapacity = capacity;
        pakArray = new Pakuri [maxCapacity];
    }

    public int getSize() {
        //return the current population size within the Pakudex
        int currentSize = 0;
        if(pakArray != null && pakArray[0] != null) {
            for (int i = 0; i < pakArray.length; i++) {
                if (pakArray[i] != null) {
                    currentSize++;
                }
            }
        }
        return currentSize;
    }

    public int getCapacity(){
        return maxCapacity;
    }

    public String[] getSpeciesArray(){
        //produce an array of the names of each Pakuri in the Pakudex
        String [] pakNames = null;
        if(pakArray != null && pakArray[0] != null) {
            pakNames =  new String[getSize()];
            for(int i = 0; i < pakArray.length; i++) {
                if (pakArray[i] != null) {
                    pakNames[i] = pakArray[i].getSpecies();
                }
            }
        }
        return pakNames;
    }

    public int[] getStats(String species){
        //return an array of information specific to each pakuri
        if(pakArray != null && pakArray[0] != null) {
            for (int i = 0; i < pakArray.length; i++) {
                if (pakArray[i] != null && pakArray[i].getSpecies().equals(species)) {
                    int[] statistics = new int[3];
                    statistics[0] = pakArray[i].getAttack();
                    statistics[1] = pakArray[i].getDefense();
                    statistics[2] = pakArray[i].getSpeed();
                    return statistics;
                }
            }
        }
        return null;
    }

    public void sortPakuri() {
        //organize the Pakuri in alphabetical order (name-wise)
        for(int i = 0; i < pakArray.length; i ++) {
            for (int j = i + 1; j < pakArray.length -1 ; j++) {
                if(pakArray[j] != null && pakArray[i] != null){
                    int compare = pakArray[i].getSpecies().compareTo(pakArray[j].getSpecies());
                    if (compare > 0) {
                        Pakuri p = pakArray[j];
                        pakArray[j] = pakArray[i];
                        pakArray[i] = p;
                    }
                }
            }
        }
    }

    public boolean addPakuri(String species){
        //check to see if the pakudex is full; if so, return an error message
        for(int i = 0; i < pakArray.length; i ++){
            if(i == pakArray.length - 1 && pakArray[i] != null){
                System.out.println("Error: Pakudex is full!");
                return false;
            }
            Pakuri obj = new Pakuri(species);

            //add the pakuri species to the array if and only if the species is not already contained within the Pakudex
            if(pakArray[i] == null){
                pakArray[i] = obj;
                System.out.println("Pakuri species " + pakArray[i].getSpecies() + " successfully added!");
                return true;
            }else if(pakArray[i].getSpecies().equals(obj.getSpecies())){
                System.out.println("Error: Pakudex already contains this species!");
                return false;
            }
        }
        return false;
    }

    public boolean evolveSpecies(String species){
        //level up all attributes of the Pakuri using the .evolve() method from Pakuri.java
        if(pakArray != null && pakArray[0] != null) {
            for (int i = 0; i < pakArray.length; i++) {
                if (pakArray[i] != null && pakArray[i].getSpecies().equals(species)) {
                    pakArray[i].evolve();
                    return true;
                }
            }
        }
        return false;
    }

    public Pakuri getPakuri(String species){
        for(Pakuri obj: pakArray){
            if(obj.getSpecies().equals(species)){
                return obj;
            }
        }
        return null;
    }

    public void setSpeciesArray(Pakuri[] sortedPakArr){
        pakArray = sortedPakArr;
    }

}