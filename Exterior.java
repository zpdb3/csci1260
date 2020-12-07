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
    private int areaFear;
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
        improved = false;
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

    public boolean hasPerson() { return !personAL.isEmpty(); }

    public boolean hasAnimal() { return !animalAL.isEmpty(); }

    public boolean hasSeed() { return !seedAL.isEmpty(); }

    public boolean hasLumber() { return !lumberAL.isEmpty(); }

    public boolean hasOre() { return !oreAL.isEmpty(); }

    public boolean hasEquipment() { return !pickUpableAL.isEmpty(); }

    public Equipment chop() {
        if(hasLumber()){
            Lumber l = lumberAL.get(lumberAL.size() - 1);
            lumberAL.remove(lumberAL.size() - 1);
            return l;
        }
        return null;
    }

    public Equipment farm() {
        if(hasSeed()) {
            Seed s = seedAL.get(seedAL.size() - 1);
            seedAL.remove(seedAL.size() - 1);
            return s;
        }
        return null;
    }

    public Equipment mine() {
        if(hasOre()) {
            Ore o = oreAL.get(oreAL.size() - 1);
            oreAL.remove(oreAL.size() - 1);
            return o;
        }
        return null;
    }

    public String scareCrow(Scarecrow s) {
        if(s != null && !getHasScarecrow()) {
            setHasScarecrow(true);
            areaFear = s.getFearLevel();
            for (Animal a : animalAL){
                if(a.fearResponse(areaFear))
                    animalAL.remove(a);
            }
            return "You set up the scarecrow and see some crows leave the area.";
        }
        else if(getHasScarecrow()) {
            return "This area already has a scarecrow.";
        }
        else {
            return "You do not have a scarecrow to place.";
        }
    }

    public String firework(Firework f) {
        if(f.getAmount() > 0) {
            for (Animal a : animalAL) {
                if(a.fearResponse(f.getFearLevel()))
                    animalAL.remove(a);
            }
            for (Person p : personAL) {
                if (p.fearResponse(f.getFearLevel()))
                    personAL.remove(p);
            }
            if(personAL.isEmpty()) {
                return "If any animals were around you spooked them for sure.";
            }
            else {
                return "Spooked those animals... and some people nearby.";
            }
        }
        else {
            return "You don't have any fireworks on you.";
        }
    }

    public String talk() {
        if(hasPerson()) {
            Random dice = new Random();
            return personAL.get(dice.nextInt(personAL.size())).talk();
        }
        else if (hasAnimal()) {
            Random dice = new Random();
            return animalAL.get(dice.nextInt(animalAL.size())).talk();
        }
        return "There is no one here to talk to.";
    }

    public ArrayList<Equipment> pickUp() {
        if(hasEquipment()) {
            return pickUpableAL;
        }
        else {
            return null;
        }
    }

    public int rest() {
        return 10;
    }

    public boolean checkIfImproved() {
        return improved;
    }

    public String improve() {
        setImproved(true);
        description += "  ";
        return "";
    }

    public void addBack(Equipment e) {
        if(e instanceof Lumber)
            lumberAL.add((Lumber) e);
        if(e instanceof Ore)
            oreAL.add((Ore) e);
        if(e instanceof Seed)
            seedAL.add((Seed) e);
    }

    public void concatDescription(String s) {
        description += s;
    }
}
