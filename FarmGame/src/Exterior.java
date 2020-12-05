/*
 *  Programmed By:  Eric M. Caton
 *  This is the Exterior abstract class for Farm Game
 *  Version 1.0 last updated Nov 29, 2020
 */

import java.util.ArrayList;
import java.util.Random;

public abstract class Exterior implements IArea {

    private String name;
    private String iconPath;
    private String imagePath;
    private String type;
    private String description;
    private String optimalTool;
    private boolean hasScarecrow;
    private boolean improved;
    private ArrayList<Person> personAL;
    private ArrayList<Animal> animalAL;
    private ArrayList<Seed> seedAL;
    private ArrayList<Lumber> lumberAL;
    private ArrayList<Ore> oreAL;
    private ArrayList<Equipment> pickUpableAL;

    public Exterior() {
        improved = false;
        personAL = new ArrayList<Person>();
        animalAL = new ArrayList<Animal>();
        seedAL = new ArrayList<Seed>();
        lumberAL = new ArrayList<Lumber>();
        oreAL = new ArrayList<Ore>();
        pickUpableAL = new ArrayList<Equipment>();
    }

    public Exterior(String name, String iconPath, String imagePath, String type, String description, String optimalTool,
                    boolean hasScarecrow){
        this.name = name;
        this.iconPath = iconPath;
        this.imagePath = imagePath;
        this.type = type;
        this.description = description;
        this.optimalTool = optimalTool;
        this.hasScarecrow = hasScarecrow;
        personAL = new ArrayList<Person>();
        animalAL = new ArrayList<Animal>();
        seedAL = new ArrayList<Seed>();
        lumberAL = new ArrayList<Lumber>();
        oreAL = new ArrayList<Ore>();
        pickUpableAL = new ArrayList<Equipment>();
    }

    public void setName(String name){
        this.name = name;
    }

    public void setIconPath(String path) { iconPath = path; }

    public void setImagePath(String path) { imagePath = path; }

    public void setType(String type) { this.type = type; }

    public void setDescription(String description){
        this.description = description;
    }

    public void setOptimalTool(String optimalTool){
        this.optimalTool = optimalTool;
    }

    public void setHasScarecrow(boolean hasScarecrow){
        this.hasScarecrow = hasScarecrow;
    }

    public void setImproved(boolean improved) { this.improved = improved; }

    public String getName(){
        return name;
    }

    public String getIconPath() { return iconPath; }

    public String getImagePath() { return imagePath; }

    public String getType() { return type; }

    public String getDescription(){
        return description;
    }

    public String getOptimalTool(){
        return optimalTool;
    }

    public boolean getHasScarecrow(){
        return hasScarecrow;
    }

    public boolean getImproved() { return improved;}

    public void setPersonAL(ArrayList<Person> person){
        personAL = person;
    }

    public void setAnimalAL(ArrayList<Animal> animal){
        animalAL = animal;
    }

    public void setSeedAL(ArrayList<Seed> seed){
        seedAL = seed;
    }

    public void setLumberAL(ArrayList<Lumber> lumber){
        lumberAL = lumber;
    }

    public void setOreAL(ArrayList<Ore> ore){
        oreAL = ore;
    }

    public void setPickUpableAL(ArrayList<Equipment> equipment) { pickUpableAL = equipment; }

    public boolean hasPerson() { return personAL.isEmpty(); }

    public boolean hasAnimal() { return animalAL.isEmpty(); }

    public boolean hasSeed() { return seedAL.isEmpty(); }

    public boolean hasLumber() { return lumberAL.isEmpty(); }

    public boolean hasOre() { return oreAL.isEmpty(); }

    public boolean hasEquipment() { return pickUpableAL.isEmpty(); }

    public boolean checkIfImproved() {
        return improved;
    }

    public void improve(boolean improved) {

    }
}
