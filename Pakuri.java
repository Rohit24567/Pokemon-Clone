public class Pakuri {
    //attributes exclusive to each species
    private String species;
    private int attack;
    private int defense;
    private int speed;

    public Pakuri (String species){
        this.species = species;
        attack = (species.length() * 7) + 9;
        defense = (species.length() * 5) + 17;
        speed = (species.length() * 6) + 13;
    }
    //list of getters to access a Pakuri's attributes

    public String getSpecies(){
        return species;
    }

    public int getAttack(){
        return attack;
    }

    public int getDefense(){
        return defense;
    }

    public int getSpeed(){
        return speed;
    }

    public int setAttack (int newAttack){
        attack = newAttack;
        return attack;
    }

    //perform this method to level up all the int attributes of the species
    public void evolve(){
        attack *= 2;
        defense *= 4;
        speed *= 3;
    }
}
