/*
 *  Programmed By:  Eric M. Caton
 *  This is the world for Farm Game
 *  Version 1.0 last updated Nov 29, 2020
 */

import java.util.ArrayList;
import java.util.Random;

public class Field extends Exterior {

    public Field(){
        super();
        String name = generateName();
        setName(name);
        setDescription(generateDescription(name));
        setOptimalTool("hoe");
        setHasScarecrow(false);
        populateArea();
        animalArea();
        mineralArea();
        lumberArea();
        seedArea();
    }

    public Field(String name, String description, String optimalTool, boolean hasScarecrow){
        super(name, description, optimalTool, hasScarecrow);
        populateArea();
        animalArea();
        mineralArea();
        lumberArea();
        seedArea();
    }

    public void populateArea(){
        Random dice = new Random();
        int roll = dice.nextInt(6);
        ArrayList<Person> personAL = new ArrayList<Person>();
        for(int count = 0; count < roll; count++){
            if(dice.nextInt(60) < 10)
                personAL.add((Person) new Trader());
            else
                personAL.add((Person) new Neighbor());
        }
        setPersonAL(personAL);
    }

    public void animalArea(){
        Random dice = new Random();
        int roll = dice.nextInt(8);
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
        int roll = dice.nextInt(1);
        ArrayList<Ore> oreAL = new ArrayList<Ore>();
        for(int count = 0; count < roll; count++){
            oreAL.add((Ore)new Iron());
        }
        setOreAL(oreAL);
    }

    public void lumberArea(){
        Random dice = new Random();
        int roll = dice.nextInt(2);
        ArrayList<Lumber> lumberAL = new ArrayList<Lumber>();
        for(int count = 0; count < roll; count++){
            lumberAL.add(new Lumber());
        }
        setLumberAL(lumberAL);
    }

    public void seedArea(){
        Random dice = new Random();
        int roll = dice.nextInt(20);
        ArrayList<Seed> seedAL = new ArrayList<Seed>();
        for(int count = 0; count < roll; count++){
            if((roll + 1) % 2 == 0)
                seedAL.add((Seed) new Corn());
            else if((roll + 1) % 5 == 0)
                seedAL.add((Seed) new Watermelon());
            else
                seedAL.add((Seed) new Carrot());
        }
        setSeedAL(seedAL);
    }

    public String generateName(){
        Random dice = new Random();
        int roll = dice.nextInt(3);
        String name = "";
        switch(roll){
            case 0: name = "Terraced Hills"; break;
            case 1: name = "Fallow Field"; break;
            case 2: name = "Hayfield"; break;
        }
        return name;
    }

    public String generateDescription(String name){
        String description = "";
        switch(name){
            case "Terraced Hills": description = "A series of well engineered terraces built on to hills to maximize arable land availability."; break;
            case "Fallow Field": description = "A flat farming field, seems to have little growing on it."; break;
            case "Pasture": description = "A large piece of fenced in land with wild grass growing."; break;
        }
        return description;
    }

    public void improve(String improvement){

    }
}
