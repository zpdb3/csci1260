/*
 *  Programmed By:  Eric M. Caton
 *  This is the Mine class for Farm Game
 *  Version 1.0 last updated Nov 29, 2020
 */

import java.util.ArrayList;
import java.util.Random;

public class Mine extends Exterior {

    public Mine(){
        super();
        String name = generateName();
        setName(name);
        setDescription(generateDescription(name));
        setOptimalTool("shovel");
        setHasScarecrow(false);
        populateArea();
        animalArea();
        mineralArea();
        lumberArea();
        seedArea();
    }

    public Mine(String name, String description, String optimalTool, boolean hasScarecrow){
        super(name, description, optimalTool, hasScarecrow);
        populateArea();
        animalArea();
        mineralArea();
        lumberArea();
        seedArea();
    }

    public void populateArea(){
        Random dice = new Random();
        int roll = dice.nextInt(3);
        ArrayList<Person> personAL = new ArrayList<Person>();
        for(int count = 0; count < roll; count++){
            personAL.add((Person) new Neighbor());
        }
        setPersonAL(personAL);
    }

    public void animalArea(){
        Random dice = new Random();
        int roll = dice.nextInt(2);
        ArrayList<Animal> animalAL = new ArrayList<Animal>();
        for(int count = 0; count < roll; count++){
            animalAL.add((Animal)new Crow());
        }
        setAnimalAL(animalAL);
    }

    public void mineralArea(){
        Random dice = new Random();
        int roll = dice.nextInt(10);
        ArrayList<Ore> oreAL = new ArrayList<Ore>();
        for(int count = 0; count < roll; count++){
            if(count%3 == 0){
                oreAL.add((Ore)new Gold());
            }
            else{
                oreAL.add((Ore)new Iron());
            }
        }
        setOreAL(oreAL);
    }

    public void lumberArea(){
        Random dice = new Random();
        int roll = dice.nextInt(3);
        ArrayList<Lumber> lumberAL = new ArrayList<Lumber>();
        for(int count = 0; count < roll; count++){
            lumberAL.add(new Lumber());
        }
        setLumberAL(lumberAL);
    }

    public void seedArea(){
        Random dice = new Random();
        int roll = dice.nextInt(2);
        ArrayList<Seed> seedAL = new ArrayList<Seed>();
        for(int count = 0; count < roll; count++){
            seedAL.add((Seed)new Corn());
        }
        setSeedAL(seedAL);
    }

    public String generateName(){
        Random dice = new Random();
        int roll = dice.nextInt(3);
        String name = "";
        switch(roll){
            case 0: name = "Strip Mine"; break;
            case 1: name = "Underground Mine"; break;
            case 2: name = "Placer Mine"; break;
        }
        return name;
    }

    public String generateDescription(String name){
        String description = "";
        switch(name){
            case "Strip Mine": description = "A large scar in the land is visible with exposed bedrock and ore veins."; break;
            case "Underground Mine": description = "An unassuming mine entrance leads to a few diagonal shafts with ore veins."; break;
            case "Placer Mine": description = "A creek runs through the area with sediment being carried slowly through, there are mining pans and sieves laying about."; break;
        }
        return description;
    }

    public void improve(String improvement){

    }
}
