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
        setIconPath("FieldIcon.png");
        setDescription(generateDescription(name));
        setOptimalTool("hoe");
        setHasScarecrow(false);
        populateArea();
        animalArea();
        mineralArea();
        lumberArea();
        seedArea();
        if(name.equalsIgnoreCase("Terraced Hills")){
            setImagePath("terracedField.png");
        }
        else if(name.equalsIgnoreCase("Pasture")){
            setImagePath("pastureField.png");
        }
        else {
            setImagePath("fallowField.png");
        }
    }

    public Field(String name, String iconPath, String imagePath, String type, String description, String optimalTool,
                 boolean hasScarecrow, int minPerson, String prefPerson, int minAnimal, String prefAnimal, int minSeed,
                 String prefSeed, int minLumber, int minOre, String prefOre){
        super(name, iconPath, imagePath, type, description, optimalTool, hasScarecrow);
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

    public void populateArea(int min, String prefType) {
        Random dice = new Random();
        int roll = dice.nextInt(6) + min;
        int weight = prefType.equalsIgnoreCase("trader") ? 15 : 0;
        ArrayList<Person> personAL = new ArrayList<Person>();
        for(int count = 0; count < roll; count++){
            if(dice.nextInt(50) <  weight)
                personAL.add(new Trader());
            else
                personAL.add(new Neighbor());
        }
        setPersonAL(personAL);
    }

    public void animalArea(){
        Random dice = new Random();
        int roll = dice.nextInt(8);
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
        int roll = dice.nextInt(8) + min;
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
        int roll = dice.nextInt(1);
        ArrayList<Ore> oreAL = new ArrayList<Ore>();
        for(int count = 0; count < roll; count++){
            oreAL.add(new Iron());
        }
        setOreAL(oreAL);
    }

    public void mineralArea(int min, String prefType) {
        Random dice = new Random();
        int roll = dice.nextInt(1) + min;
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
        int roll = dice.nextInt(2);
        ArrayList<Lumber> lumberAL = new ArrayList<Lumber>();
        for(int count = 0; count < roll; count++){
            lumberAL.add(new Lumber());
        }
        setLumberAL(lumberAL);
    }

    public void lumberArea(int min) {
        Random dice = new Random();
        int roll = dice.nextInt(2) + min;
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
                seedAL.add(new Corn());
            else if((roll + 1) % 5 == 0)
                seedAL.add(new Watermelon());
            else
                seedAL.add(new Carrot());
        }
        setSeedAL(seedAL);
    }

    public void seedArea(int min, String prefType) {
        Random dice = new Random();
        int roll = dice.nextInt(20) + min;
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

    public void improve(boolean improved){

    }
}
