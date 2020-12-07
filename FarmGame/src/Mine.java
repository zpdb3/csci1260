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
        setIconPath("MineIcon.png");
        setDescription(generateDescription(name));
        setOptimalTool("shovel");
        setHasScarecrow(false);
        populateArea();
        animalArea();
        mineralArea();
        lumberArea();
        seedArea();
        if(name.equalsIgnoreCase("Strip Mine")){
            setImagePath("stripMine.png");
        }
        else if(name.equalsIgnoreCase("Placer Mine")){
            setImagePath("placerMine.png");
        }
        else {
            setImagePath("horizontalMine.png");
        }
    }

    public Mine(String name, String iconPath, String imagePath, String type, String description, String optimalTool,
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
        int roll = dice.nextInt(3);
        ArrayList<Person> personAL = new ArrayList<Person>();
        for(int count = 0; count < roll; count++){
            personAL.add((Person) new Neighbor());
        }
        setPersonAL(personAL);
    }

    public void populateArea(int min, String prefType) {
        Random dice = new Random();
        int roll = dice.nextInt(3) + min;
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
        int roll = dice.nextInt(2);
        ArrayList<Animal> animalAL = new ArrayList<Animal>();
        for(int count = 0; count < roll; count++){
            animalAL.add(new Crow());
        }
        setAnimalAL(animalAL);
    }

    public void animalArea(int min, String prefType) {
        Random dice = new Random();
        int roll = dice.nextInt(2) + min;
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
        int roll = dice.nextInt(10);
        ArrayList<Ore> oreAL = new ArrayList<Ore>();
        for(int count = 0; count < roll; count++){
            if(count % 3 == 0){
                oreAL.add(new Gold());
            }
            else{
                oreAL.add(new Iron());
            }
        }
        setOreAL(oreAL);
    }

    public void mineralArea(int min, String prefType) {
        Random dice = new Random();
        int roll = dice.nextInt(10) + min;
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
        int roll = dice.nextInt(3);
        ArrayList<Lumber> lumberAL = new ArrayList<Lumber>();
        for(int count = 0; count < roll; count++){
            lumberAL.add(new Lumber());
        }
        setLumberAL(lumberAL);
    }

    public void lumberArea(int min) {
        Random dice = new Random();
        int roll = dice.nextInt(3) + min;
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
            seedAL.add(new Corn());
        }
        setSeedAL(seedAL);
    }

    public void seedArea(int min, String prefType) {
        Random dice = new Random();
        int roll = dice.nextInt(2) + min;
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

    public void improve(boolean improved){

    }
}
