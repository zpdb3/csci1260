/*
 *  Programmed By:  Eric M. Caton
 *  This is the Exterior abstract class for Farm Game
 *  Version 1.0 last updated Nov 29, 2020
 */

import java.util.ArrayList;

public abstract class Exterior implements IArea {

    private String name;
    private String description;
    private String optimalTool;
    private boolean hasScarecrow;
    private boolean improved;
    private ArrayList<Person> personAL;
    private ArrayList<Animal> animalAL;
    private ArrayList<Seed> seedAL;
    private ArrayList<Lumber> lumberAL;
    private ArrayList<Ore> oreAL;

    public Exterior() {
        personAL = new ArrayList<Person>();
        animalAL = new ArrayList<Animal>();
        seedAL = new ArrayList<Seed>();
        lumberAL = new ArrayList<Lumber>();
        oreAL = new ArrayList<Ore>();
    }

    public Exterior(String name, String description, String optimalTool, boolean hasScarecrow){
        this.name = name;
        this.description = description;
        this.optimalTool = optimalTool;
        this.hasScarecrow = hasScarecrow;
        personAL = new ArrayList<Person>();
        animalAL = new ArrayList<Animal>();
        seedAL = new ArrayList<Seed>();
        lumberAL = new ArrayList<Lumber>();
        oreAL = new ArrayList<Ore>();
    }

    public void setName(String name){
        this.name = name;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public void setOptimalTool(String optimalTool){
        this.optimalTool = optimalTool;
    }

    public void setHasScarecrow(boolean hasScarecrow){
        this.hasScarecrow = hasScarecrow;
    }

    public void setImproved(boolean improved) { this.improved = improved;}

    public String getName(){
        return name;
    }

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

    public boolean hasPerson() {
        return personAL.isEmpty();
    }

    public boolean hasAnimal() {
        return animalAL.isEmpty();
    }

    public boolean hasSeed() {
        return seedAL.isEmpty();
    }

    public boolean hasLumber() {
        return lumberAL.isEmpty();
    }

    public boolean hasOre() {
        return oreAL.isEmpty();
    }
}
