/*
 *  Programmed By:  Eric M. Caton
 *  This is the Structure class for Farm Game
 *  Version 1.0 last updated Nov 29, 2020
 */

import java.util.ArrayList;
import java.util.Random;

public class Structure implements IArea {

    private String name;
    private String description;
    private String optimalTool;
    private boolean hasScarecrow;
    private ArrayList<Person> personAL;
    private ArrayList<Animal> animalAL;
    private ArrayList<Seed> seedAL;
    private ArrayList<Lumber> lumberAL;
    private ArrayList<Ore> oreAL;

    public Structure(){
        String name = generateName();
        this.name = name;
        description = generateDescription(name);
        optimalTool = "hammer";
        hasScarecrow = false;
        personAL = new ArrayList<Person>();
        animalAL = new ArrayList<Animal>();
        seedAL = new ArrayList<Seed>();
        lumberAL = new ArrayList<Lumber>();
        oreAL = new ArrayList<Ore>();
        if(name.equalsIgnoreCase("warehouse")){
            mineralArea();
            lumberArea();
            seedArea();
        }
        else{
            populateArea();
        }
    }

    public Structure(String name, String description, String optimalTool, boolean hasScarecrow){
        this.name = name;
        this.description = description;
        this.optimalTool = optimalTool;
        this.hasScarecrow = hasScarecrow;
        personAL = new ArrayList<Person>();
        animalAL = new ArrayList<Animal>();
        seedAL = new ArrayList<Seed>();
        lumberAL = new ArrayList<Lumber>();
        oreAL = new ArrayList<Ore>();
        if(name.equalsIgnoreCase("warehouse")){
            mineralArea();
            lumberArea();
            seedArea();
        }
        else{
            populateArea();
        }
    }

    public void populateArea(){
        Random dice = new Random();
        int roll = dice.nextInt(6);
        ArrayList<Person> personAL = new ArrayList<Person>();
        for(int count = 0; count < roll; count++){
            if(dice.nextInt(50) < 20)
                personAL.add((Person) new Trader());
            else
                personAL.add((Person) new Neighbor());
        }
        this.personAL = personAL;
    }

    public void animalArea(){

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
        this.oreAL = oreAL;
    }

    public void lumberArea(){
        Random dice = new Random();
        int roll = dice.nextInt(15);
        ArrayList<Lumber> lumberAL = new ArrayList<Lumber>();
        for(int count = 0; count < roll; count++){
            lumberAL.add(new Lumber());
        }
        this.lumberAL = lumberAL;
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
        this.seedAL = seedAL;
    }

    public String generateName(){
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

    public String generateDescription(String name){
        String description = "";
        switch(name){
            case "General Store": description = "A well kept store, has about anything you could need for improving the local area."; break;
            case "Cozy Inn": description = "A cozy little inn perhaps resting here will provide extra rewards."; break;
            case "Warehouse": description = "An empty warehouse.  Well empty of people..."; break;
        }
        return description;
    }

    public void improve(String improvement){

    }
}
