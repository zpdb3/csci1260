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
        setIconPath("ForestIcon.png");
        setDescription(generateDescription(name));
        setOptimalTool("axe");
        setHasScarecrow(false);
        populateArea();
        animalArea();
        mineralArea();
        lumberArea();
        seedArea();
        if(name.equalsIgnoreCase("Boreal Forest")){
            setImagePath("borealForest.png");
        }
        else if(name.equalsIgnoreCase("Rain Forest")){
            setImagePath("rainForest.png");
        }
        else {
            setImagePath("temperateForest.png");
        }
    }

    public Forest(String name, String iconPath, String imagePath, String type, String description, String optimalTool,
                  boolean hasScarecrow, int minPerson, String prefPerson, int minAnimal, String prefAnimal, int minSeed,
                  String prefSeed, int minLumber, int minOre, String prefOre){
        super(name, iconPath, imagePath, type, description, optimalTool, hasScarecrow);
        populateArea(minPerson, prefPerson);
        animalArea(minAnimal, prefAnimal);
        mineralArea(minOre, prefOre);
        lumberArea(minLumber);
        seedArea(minSeed, prefSeed);
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

    public void populateArea(int min, String prefType) {
        Random dice = new Random();
        int roll = dice.nextInt(2) + min;
        int weight = prefType.equalsIgnoreCase("trader") ? 10 : 0;
        ArrayList<Person> personAL = new ArrayList<Person>();
        for(int count = 0; count < roll; count++){
            if(dice.nextInt(50) < 20 + weight)
                personAL.add(new Trader());
            else
                personAL.add(new Neighbor());
        }
        setPersonAL(personAL);
    }

    public void animalArea(){
        Random dice = new Random();
        int roll = dice.nextInt(5);
        ArrayList<Animal> animalAL = new ArrayList<Animal>();
        for(int count = 0; count < roll; count++){
            if(dice.nextInt(2) == 0)
                animalAL.add(new Crow());
            else
                animalAL.add(new Sheep());
        }
        setAnimalAL(animalAL);
    }

    public void animalArea(int min, String prefType) {
        Random dice = new Random();
        int roll = dice.nextInt(5) + min;
        int weight = prefType.equalsIgnoreCase("sheep") ? 3 : 0;
        ArrayList<Animal> animalAL = new ArrayList<Animal>();
        for(int count = 0; count < roll; count++){
            if(dice.nextInt(weight) == 0)
                animalAL.add(new Crow());
            else
                animalAL.add(new Sheep());
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

    public void mineralArea(int min, String prefType) {
        Random dice = new Random();
        int roll = dice.nextInt(4) + min;
        int weight = prefType.equalsIgnoreCase("gold") ? 2 : 3;
        ArrayList<Ore> oreAL = new ArrayList<Ore>();
        for(int count = 0; count < roll; count++){
            if(count % weight == 0)
                oreAL.add(new Gold());
            else
                oreAL.add(new Iron());
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

    public void lumberArea(int min) {
        Random dice = new Random();
        int roll = dice.nextInt(15) + min;
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
                seedAL.add(new Carrot());
            else if((roll + 1) % 3 == 0)
                seedAL.add(new Watermelon());
            else
                seedAL.add(new Corn());
        }
        setSeedAL(seedAL);
    }

    public void seedArea(int min, String prefType) {
        Random dice = new Random();
        int roll = dice.nextInt(4) + min;
        ArrayList<Seed> seedAL = new ArrayList<Seed>();
        for(int count = 0; count < roll; count++, min--){
            if(min != 0){
                switch(prefType){
                    case "Watermelon":
                        seedAL.add(new Watermelon()); break;
                    case "Carrot":
                        seedAL.add(new Carrot()); break;
                    default:
                        seedAL.add(new Corn()); break;
                }
            }
            else {
                if ((roll + 1) % 2 == 0)
                    seedAL.add(new Corn());
                else if ((roll + 1) % 5 == 0)
                    seedAL.add(new Watermelon());
                else
                    seedAL.add(new Carrot());
            }
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
}
