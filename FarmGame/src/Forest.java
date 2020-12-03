/*
 *  Programmed By:  Eric M. Caton
 *  This is the Forest class for Farm Game
 *  Version 1.0 last updated Nov 29, 2020
 */

import java.util.ArrayList;
import java.util.Random;

public class Forest extends Exterior {

    public Forest(){
        super();
        String name = generateName();
        setName(name);
        setDescription(generateDescription(name));
        setOptimalTool("axe");
        setHasScarecrow(false);
        populateArea();
        animalArea();
        mineralArea();
        lumberArea();
        seedArea();
    }

    public Forest(String name, String description, String optimalTool, boolean hasScarecrow){
        super(name, description, optimalTool, hasScarecrow);
        populateArea();
        animalArea();
        mineralArea();
        lumberArea();
        seedArea();
    }

    public void populateArea(){
        Random dice = new Random();
        int roll = dice.nextInt(2);
        ArrayList<Person> personAL = new ArrayList<Person>();
        for(int count = 0; count < roll; count++){
            if(dice.nextInt(50) < 10)
                personAL.add((Person) new Trader());
            else
                personAL.add((Person) new Neighbor());
        }
        setPersonAL(personAL);
    }

    public void animalArea(){
        Random dice = new Random();
        int roll = dice.nextInt(5);
        ArrayList<Animal> animalAL = new ArrayList<Animal>();
        for(int count = 0; count < roll; count++){
            if(dice.nextInt(2) == 0)
                animalAL.add((Animal)new Crow());
            else
                animalAL.add((Animal)new Sheep());
        }
        setAnimalAL(animalAL);
    }

    public void mineralArea(){
        Random dice = new Random();
        int roll = dice.nextInt(3);
        ArrayList<Ore> oreAL = new ArrayList<Ore>();
        for(int count = 0; count < roll; count++){
            oreAL.add((Ore)new Iron());
        }
        setOreAL(oreAL);
    }

    public void lumberArea(){
        Random dice = new Random();
        int roll = dice.nextInt(15);
        ArrayList<Lumber> lumberAL = new ArrayList<Lumber>();
        for(int count = 0; count < roll; count++){
            lumberAL.add(new Lumber());
        }
        setLumberAL(lumberAL);
    }

    public void seedArea(){
        Random dice = new Random();
        int roll = dice.nextInt(4);
        ArrayList<Seed> seedAL = new ArrayList<Seed>();
        for(int count = 0; count < roll; count++){
            if((roll + 1) % 2 == 0)
                seedAL.add((Seed) new Carrot());
            else if((roll + 1) % 3 == 0)
                seedAL.add((Seed) new Watermelon());
            else
                seedAL.add((Seed) new Corn());
        }
        setSeedAL(seedAL);
    }

    public String generateName(){
        Random dice = new Random();
        int roll = dice.nextInt(3);
        String name = "";
        switch(roll){
            case 0: name = "Rain Forest"; break;
            case 1: name = "Boreal Forest"; break;
            case 2: name = "Temperate Forest"; break;
        }
        return name;
    }

    public String generateDescription(String name){
        String description = "";
        switch(name){
            case "Rain Forest": description = "A forest teaming with life, it is hot and seems like it is about to rain."; break;
            case "Boreal Forest": description = "A chill falls upon you as you enter this forest.  You see many good lumber trees."; break;
            case "Temperate Forest": description = "A large forest with a comfortable climate."; break;
        }
        return description;
    }

    public void improve(String improvement){

    }
}
