/*
 *  Programmed By:  Eric M. Caton
 *  This is the Structure class for Farm Game
 *  Version 1.0 last updated Nov 29, 2020
 */

import java.util.ArrayList;
import java.util.Random;

public class Structure implements IArea {

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

    public Structure(){
        String name = generateName();
        this.name = name;
        iconPath = "SettlementIcon.png";
        type = "Structure";
        description = generateDescription(name);
        optimalTool = "hammer";
        hasScarecrow = false;
        this.improved = false;
        personAL = new ArrayList<Person>();
        animalAL = new ArrayList<Animal>();
        seedAL = new ArrayList<Seed>();
        lumberAL = new ArrayList<Lumber>();
        oreAL = new ArrayList<Ore>();
        pickUpableAL = new ArrayList<Equipment>();
        if(name.equalsIgnoreCase("warehouse")){
            imagePath = "warehouse.png";
            mineralArea();
            lumberArea();
            seedArea();
        }
        else if(name.equalsIgnoreCase("Cozy Inn")){
            imagePath = "medievalInn.png";
            populateArea();
        }
        else {
            imagePath = "generalStore.png";
            populateArea();
        }
    }

    public Structure(String name, String iconPath, String imagePath, String type, String description, String optimalTool,
                     boolean hasScarecrow, int minPerson, String prefPerson, int minAnimal, String prefAnimal, int minSeed,
                     String prefSeed, int minLumber, int minOre, String prefOre){
        this.name = name;
        this.iconPath = iconPath;
        this.imagePath = imagePath;
        this.type = type;
        this.description = description;
        this.optimalTool = optimalTool;
        this.hasScarecrow = hasScarecrow;
        this.improved = false;
        personAL = new ArrayList<Person>();
        animalAL = new ArrayList<Animal>();
        seedAL = new ArrayList<Seed>();
        lumberAL = new ArrayList<Lumber>();
        oreAL = new ArrayList<Ore>();
        pickUpableAL = new ArrayList<Equipment>();
        if(name.equalsIgnoreCase("warehouse")){
            mineralArea(minOre, prefOre);
            lumberArea(minLumber);
            seedArea(minSeed, prefSeed);
        }
        else {
            populateArea(minPerson, prefPerson);
        }
    }

    public void setName(String name) { this.name = name; }

    public void setIconPath(String path) { iconPath = path; }

    public void setImagePath(String path) { imagePath = path; }

    public void setType(String type) { this.type = type;}

    public void setDescription(String description) { this.description = description; }

    public void setOptimalTool(String optimalTool) { this.optimalTool = optimalTool; }

    public void setHasScarecrow(boolean hasScarecrow) { this.hasScarecrow = hasScarecrow; }

    public void setImproved(boolean improved) { this.improved = improved; }

    public String getName() { return name; }

    public String getIconPath() { return iconPath; }

    public String getImagePath() { return imagePath; }

    public String getType() { return type; }

    public String getDescription() { return description; }

    public String getOptimalTool() { return optimalTool; }

    public boolean getHasScarecrow() { return hasScarecrow; }

    public boolean getImproved() { return improved;}

    public void setPersonAL(ArrayList<Person> person) { personAL = person; }

    public void setAnimalAL(ArrayList<Animal> animal) { animalAL = animal; }

    public void setSeedAL(ArrayList<Seed> seed) { seedAL = seed; }

    public void setLumberAL(ArrayList<Lumber> lumber) { lumberAL = lumber; }

    public void setOreAL(ArrayList<Ore> ore) { oreAL = ore; }

    public void setPickUpable(ArrayList<Equipment> equipment) { pickUpableAL = equipment; }

    public boolean hasPerson() { return !personAL.isEmpty(); }

    public boolean hasAnimal() { return !animalAL.isEmpty(); }

    public boolean hasSeed() { return !seedAL.isEmpty(); }

    public boolean hasLumber() { return !lumberAL.isEmpty(); }

    public boolean hasOre() { return !oreAL.isEmpty(); }

    public boolean hasEquipment() { return !pickUpableAL.isEmpty(); }

    public void populateArea() {
        Random dice = new Random();
        int roll = dice.nextInt(6);
        ArrayList<Person> personAL = new ArrayList<Person>();
        for(int count = 0; count < roll; count++){
            if(dice.nextInt(50) < 20)
                personAL.add(new Trader());
            else
                personAL.add(new Neighbor());
        }
        this.personAL = personAL;
    }

    public void populateArea(int min, String prefType) {
        Random dice = new Random();
        int roll = dice.nextInt(6) + min;
        int weight = prefType.equalsIgnoreCase("trader") ? 10 : 0;
        ArrayList<Person> personAL = new ArrayList<Person>();
        for(int count = 0; count < roll; count++){
            if(dice.nextInt(50) < 20 + weight)
                personAL.add(new Trader());
            else
                personAL.add(new Neighbor());
        }
        this.personAL = personAL;
    }

    public void animalArea() { }

    public void animalArea(int min, String prefType) { }

    public void mineralArea() {
        Random dice = new Random();
        int roll = dice.nextInt(10);
        ArrayList<Ore> oreAL = new ArrayList<Ore>();
        for(int count = 0; count < roll; count++){
            if(count%3 == 0){
                oreAL.add(new Gold());
            }
            else{
                oreAL.add(new Iron());
            }
        }
        this.oreAL = oreAL;
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
        this.oreAL = oreAL;
    }

    public void lumberArea() {
        Random dice = new Random();
        int roll = dice.nextInt(15);
        ArrayList<Lumber> lumberAL = new ArrayList<Lumber>();
        for(int count = 0; count < roll; count++){
            lumberAL.add(new Lumber());
        }
        this.lumberAL = lumberAL;
    }

    public void lumberArea(int min) {
        Random dice = new Random();
        int roll = dice.nextInt(15) + min;
        ArrayList<Lumber> lumberAL = new ArrayList<Lumber>();
        for(int count = 0; count < roll; count++){
            lumberAL.add(new Lumber());
        }
        this.lumberAL = lumberAL;
    }

    public void seedArea() {
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
        this.seedAL = seedAL;
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
        this.seedAL = seedAL;
    }

    public String generateName() {
        Random dice = new Random();
        int roll = dice.nextInt(3);
        String name = "";
        switch(roll){
            case 0: name = "General Store"; break;
            case 1: name = "Cozy Inn"; break;
            case 2: name = "Warehouse"; break;
        }
        return name;
    }

    public String generateDescription(String name) {
        String description = "";
        switch(name){
            case "General Store": description = "A well kept store, has about anything you could need for improving the local area."; break;
            case "Cozy Inn": description = "A cozy little inn perhaps resting here will provide extra rewards."; break;
            case "Warehouse": description = "An empty warehouse.  Well empty of people..."; break;
        }
        return description;
    }

    public Equipment chop() {
        return null;
    }

    public Equipment farm() {
        return null;
    }

    public Equipment mine() {
        return null;
    }

    public String scareCrow(Scarecrow s) {
        if(getHasScarecrow()) {
            return "This area already has a scarecrow.";
        }
        else {
            return "It would be useless to place a scarecrow here";
        }
    }

    public String firework(Firework f) {
        if(f.getAmount() == 0) {
            return "You don't have any fireworks on you.";
        }
        else {
            return "It seems like a bad place to use fireworks...";
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
        ArrayList<Equipment> hold = new ArrayList<Equipment>();
        for(Equipment e : pickUpableAL)
            hold.add(e);
        for(Equipment e : lumberAL)
            hold.add(e);
        for(Equipment e : oreAL)
            hold.add(e);
        for(Equipment e : seedAL)
            hold.add(e);
        return hold;
    }

    public int rest() {
        if(getName().equalsIgnoreCase("Farmers Only Inn") || getName().equalsIgnoreCase("Cozy Inn"))
            return 15;
        else
            return 12;
    }

    public boolean checkIfImproved() {
        return improved;
    }

    public String improve() {
        setImproved(true);
        description += "  The walls look to be recently repaired and there is a new well outside.";
        return "You patch some walls and install a new well.";
    }

    public void addBack(Equipment e) {
        if(e instanceof Lumber)
            lumberAL.add((Lumber) e);
        if(e instanceof Ore)
            oreAL.add((Ore) e);
        if(e instanceof Seed)
            seedAL.add((Seed) e);
    }
}
