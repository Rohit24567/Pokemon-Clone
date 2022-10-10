import java.util.Scanner;

public class PakuriProgram {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Pakudex: Tracker Extraordinaire!");

        //set maximum species the Pakudex can hold
        int capacity = 0;
        boolean goodInput = false;

        //check to see if input provided for capacity is valid and applicable
        while(!goodInput){
            System.out.println("Enter max capacity of the Pakudex: ");

            String userInput = scanner.next();
            try{
                capacity = Integer.parseInt(userInput);
                if(capacity < 1){
                    System.out.println("Please enter a valid size.");
                    goodInput = false;
                }else{
                    goodInput = true;
                }
            }catch(Exception e){
                System.out.println("Please enter a valid size.");
                goodInput = false;
            }
        }

        //create a new Pakudex object with the specified capacity
        System.out.println("The Pakudex can hold " +  capacity + " species of Pakuri.");
        Pakudex pakudex = new Pakudex(capacity);
        boolean end = false;

        while(!end) {

            int menuChoice = 0;

            boolean goodOption = false;

            while(!goodOption && !end){
                //present the menu of choices for the user to choose from
                System.out.println("Pakudex Main Menu \n----------------- \n1. List Pakuri\n" +
                        "2. Show Pakuri\n3. Add Pakuri\n4. Evolve Pakuri\n5. Sort Pakuri\n6. Exit");

                System.out.println("What would you like to do?");

                String strMenuChoice = scanner.next();
                try{
                    menuChoice = Integer.parseInt(strMenuChoice);

                    if (menuChoice == 1) {
                        String[] arrayOfSpecies = pakudex.getSpeciesArray();

                        //if the array of species is empty return an error message
                        if (arrayOfSpecies == null || arrayOfSpecies.length == 0) {
                            System.out.println("No Pakuri in Pakudex yet!");
                            System.out.println();
                        }
                        else if (arrayOfSpecies[0] == null) {
                            System.out.println("No Pakuri in Pakudex yet!");
                            System.out.println();
                        }
                        else {
                            //iterate through the array to present each pakuri name
                            System.out.println("Pakuri In Pakudex:");
                            for (int i = 0; i < arrayOfSpecies.length; i++) {
                                if (arrayOfSpecies[i] != null) {
                                    System.out.println(i + 1 + ". " + arrayOfSpecies[i]);
                                }
                            }
                            System.out.println();
                        }
                    }
                    else if (menuChoice == 2) {
                        System.out.println("Enter the name of the species to display: ");
                        String nameOfSpecies = scanner.next();
                        String[] arrayOfPakuri = pakudex.getSpeciesArray();

                        //if the array of species is empty return an error message
                        if (arrayOfPakuri == null || arrayOfPakuri.length == 0) {
                            System.out.println("Error: No such Pakuri!");
                        }
                        else  if (arrayOfPakuri[0] == null) {
                            System.out.println("Error: No such Pakuri!");
                        }
                        else {
                            //within the array of species, access the desired species and call the getStats() method to display info about the pakuri
                            for (int i = 0; i < arrayOfPakuri.length; i++) {
                                if (arrayOfPakuri[i] != null && arrayOfPakuri[i].equals(nameOfSpecies)) {
                                    int[] statsArr = pakudex.getStats(nameOfSpecies);
                                    System.out.println("Species: " + nameOfSpecies);
                                    System.out.println("Attack: " + statsArr[0]);
                                    System.out.println("Defense: " + statsArr[1]);
                                    System.out.println("Speed: " + statsArr[2]);
                                    System.out.println();
                                }
                            }
                        }
                    }
                    else if (menuChoice == 3) {
                        String[] array = pakudex.getSpeciesArray();

                        //if the array of species is empty return an error message
                        if (array != null && array[0] != null && array.length == capacity) {
                            System.out.println("Error: Pakudex is full!");

                        } else if (array != null && array.length == capacity && array[array.length - 1] != null) {
                            System.out.println("Error: Pakudex is full!");
                        }
                        else {
                            System.out.println("Enter the name of the species to add: ");
                            String pName = scanner.next();
                            pakudex.addPakuri(pName);
                        }
                        System.out.println();
                    }

                    else if (menuChoice == 4) {
                        System.out.println("Enter the name of the species to evolve: ");
                        String pakuriToEvolve = scanner.next();
                        boolean evolved = false;
                        try {
                            String[] pakArr = pakudex.getSpeciesArray();
                            //iterate through the array of species and call the evolve method on the identified species
                            if (pakArr != null && pakArr[0] != null && pakArr.length != 0) {
                                int i = 0;
                                for (String name : pakArr) {
                                    i++;
                                    if (name.equals(pakuriToEvolve)) {
                                        pakudex.evolveSpecies(pakuriToEvolve);
                                        evolved = true;
                                    }

                                }
                                if(evolved == true) {
                                    System.out.println(pakuriToEvolve + " has evolved!");
                                }  else {
                                    System.out.println("Error: No such Pakuri!");
                                }
                            }
                            goodOption = true;
                        } catch (Exception e) { //return an error message if the species is not in the array of species
                            System.out.println("Error: No such Pakuri!");
                        }
                    }
                    else if (menuChoice == 5) { //sort the pakuri alphabetically
                        pakudex.sortPakuri();
                        System.out.println("Pakuri have been sorted!");
                        System.out.println();
                    }
                    else if (menuChoice == 6) { //exit code -- end using the pakudex
                        System.out.println("Thanks for using Pakudex! Bye!");
                        end = true;
                    }
                    else {
                        System.out.println("Unrecognized menu selection!");
                        System.out.println();
                    }
                }
                catch(Exception e){
                    //return a message if the user inputs an improper menu selection
                    System.out.println("Unrecognized menu selection!");
                    goodOption = false;
                }
            }
        }
    }
}
