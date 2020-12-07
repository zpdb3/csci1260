/*
 *  Programmed By:  Eric M. Caton
 *  This is the world for Farm Game
 *  Version 1.0 last updated Nov 29, 2020
 */

import java.io.*;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Random;
import java.util.ArrayList;

public class World {

    public HashMap<Integer, IArea> worldMap;
    private int currentIndex;
    private String loadPath;
    private int actions;
    private int days;
    private Player player;
    private ArrayList<Structure> potentialStructures;
    private ArrayList<Forest> potentialForests;
    private ArrayList<Mine> potentialMines;
    private ArrayList<Field> potentialFields;


    public World() {
        loadPath = "onlyStart.csv";
        worldMap = new HashMap<Integer, IArea>();
        currentIndex = 12;
        actions = 10;
        days = 14;
        player = new Player();
        worldMap.put(currentIndex, loadStartingArea(loadPath));

        for (int count = 0; count < 25; count++) {
            if (count != 12)
                worldMap.put(count, createRandomArea());
        }
    }// end World() constructor

    public World(String loadPath){

        potentialFields = new ArrayList<Field>();
        potentialMines = new ArrayList<Mine>();
        potentialForests = new ArrayList<Forest>();
        potentialStructures = new ArrayList<Structure>();
        Random dice = new Random();
        int areaRoll;
        int typeRoll;
        worldMap = new HashMap<Integer, IArea>();
        currentIndex = 12;
        loadPotentialAreas(loadPath);
        this.loadPath = loadPath;
        actions = 10;
        days = 14;
        player = new Player();
        worldMap.put(currentIndex, loadStartingArea(loadPath));

        for (int count = 0; count < 25; count++) {
            if (count != 12){
                areaRoll = dice.nextInt(6);
                typeRoll = dice.nextInt(3);
                switch(areaRoll) {
                    case 0:
                        worldMap.put(count, potentialStructures.get(typeRoll)); break;
                    case 1:
                        worldMap.put(count, potentialMines.get(typeRoll)); break;
                    case 2:
                    case 3:
                        worldMap.put(count, potentialFields.get(typeRoll)); break;
                    default:
                        worldMap.put(count, potentialForests.get(typeRoll)); break;
                }

            }
        }
    }

    private IArea loadStartingArea(String loadPath) {
        String name = "";
        String iconPath = "";
        String imagePath = "";
        String type = "";
        String description = "";
        String optimalTool = "";
        boolean hasScarecrow = false;
        int minPeople = 0;
        String prefPeople = "";
        int minAnimal = 0;
        String prefAnimal = "";
        int minSeed = 0;
        String prefSeed = "";
        int minLumber = 0;
        int minOre = 0;
        String prefOre = "";

        try {
            Scanner scanFile = new Scanner(new File(loadPath));
            scanFile.useDelimiter(",");
            for (int count = 0; scanFile.hasNext(); count++) {
                switch (count) {
                    case 0: name = scanFile.next(); break;
                    case 1: iconPath = scanFile.next(); break;
                    case 2: imagePath = scanFile.next(); break;
                    case 3: type = scanFile.next(); break;
                    case 4: description = scanFile.next(); break;
                    case 5: optimalTool = scanFile.next(); break;
                    case 6: hasScarecrow = scanFile.next().equalsIgnoreCase("true"); break;
                    case 7: minPeople = Integer.parseInt(scanFile.next()); break;
                    case 8: prefPeople = scanFile.next(); break;
                    case 9: minAnimal = Integer.parseInt(scanFile.next()); break;
                    case 10: prefAnimal = scanFile.next(); break;
                    case 11: minSeed = Integer.parseInt(scanFile.next()); break;
                    case 12: prefSeed = scanFile.next(); break;
                    case 13: minLumber = Integer.parseInt(scanFile.next()); break;
                    case 14: minOre = Integer.parseInt(scanFile.next()); break;
                    case 15: prefOre = scanFile.next(); break;
                }
            }
        }
        catch( IOException e) {

        }

        Structure startArea = new Structure(name, iconPath, imagePath, type, description, optimalTool, hasScarecrow, minPeople,
                prefPeople, minAnimal, prefAnimal, minSeed, prefSeed, minLumber, minOre, prefOre);
        return startArea;
    }// end IArea createStartingArea()

    private void loadPotentialAreas(String loadPath) {
        String name = "";
        String iconPath = "";
        String imagePath = "";
        String type = "";
        String description = "";
        String optimalTool = "";
        boolean hasScarecrow = false;
        int minPeople = 0;
        String prefPeople = "";
        int minAnimal = 0;
        String prefAnimal = "";
        int minSeed = 0;
        String prefSeed = "";
        int minLumber = 0;
        int minOre = 0;
        String prefOre = "";

        try {
            Scanner scanFile = new Scanner(new File(loadPath));
            scanFile.useDelimiter(",");
            while (scanFile.hasNext()) {
                for (int count = 0; scanFile.hasNext() && count < 16; count++) {
                    switch (count) {
                        case 0: name = scanFile.next(); break;
                        case 1: iconPath = scanFile.next(); break;
                        case 2: imagePath = scanFile.next(); break;
                        case 3: type = scanFile.next(); break;
                        case 4: description = scanFile.next(); break;
                        case 5: optimalTool = scanFile.next(); break;
                        case 6: hasScarecrow = scanFile.next().equalsIgnoreCase("true"); break;
                        case 7: minPeople = Integer.parseInt(scanFile.next()); break;
                        case 8: prefPeople = scanFile.next(); break;
                        case 9: minAnimal = Integer.parseInt(scanFile.next()); break;
                        case 10: prefAnimal = scanFile.next(); break;
                        case 11: minSeed = Integer.parseInt(scanFile.next()); break;
                        case 12: prefSeed = scanFile.next(); break;
                        case 13: minLumber = Integer.parseInt(scanFile.next()); break;
                        case 14: minOre = Integer.parseInt(scanFile.next()); break;
                        case 15: prefOre = scanFile.next(); break;
                    }
                }
                if (type.equalsIgnoreCase("structure")) {
                    potentialStructures.add(new Structure(name, iconPath, imagePath, type, description, optimalTool, hasScarecrow,
                            minPeople, prefPeople, minAnimal, prefAnimal, minSeed, prefSeed, minLumber, minOre, prefOre));
                } else if (type.equalsIgnoreCase("forest")) {
                    potentialForests.add(new Forest(name, iconPath, imagePath, type, description, optimalTool, hasScarecrow,
                            minPeople, prefPeople, minAnimal, prefAnimal, minSeed, prefSeed, minLumber, minOre, prefOre));
                } else if (type.equalsIgnoreCase("mine")) {
                    potentialMines.add(new Mine(name, iconPath, imagePath, type, description, optimalTool, hasScarecrow,
                            minPeople, prefPeople, minAnimal, prefAnimal, minSeed, prefSeed, minLumber, minOre, prefOre));
                } else {
                    potentialFields.add(new Field(name, iconPath, imagePath, type, description, optimalTool, hasScarecrow,
                            minPeople, prefPeople, minAnimal, prefAnimal, minSeed, prefSeed, minLumber, minOre, prefOre));
                }
            }
        }
        catch (IOException e) {

        }
    }

    private IArea createRandomArea() {
        Random dice = new Random();
        int roll = dice.nextInt(10);

        switch (roll) {
            case 0:
                return new Structure();
            case 1:
            case 2:
            case 3:
            case 4:
                return new Field();
            case 5:
            case 6:
            case 7:
                return new Forest();
            case 8:
            case 9:
                return new Mine();
            default:
                return new Field();
        }
    }// end IArea createRandomArea()

    public String chop() {
        if(updateActions()) {
            Equipment e = worldMap.get(currentIndex).chop();
            if (e != null && player.axeEquipped()) {
                player.useAxe(e);
                player.addEquipment(e);
                return "You chop a tree with your axe and add the lumber to your inventory.";
            } else if (e != null && player.shovelEquipped()) {
                player.useShovel(e);
                player.addEquipment(e);
                return "You use your shovel to chop down a tree, not the best use of it, but you do not have an axe.  You add the lumber to your inventory.";
            } else if (e != null && player.hoeEquipped()) {
                player.useHoe(e);
                player.addEquipment(e);
                return "You use your hoe to get the tree down, terrible use of it, but you do not have an axe.  You add the lumber to your inventory.";
            } else if (e != null && player.hammerEquipped()) {
                player.useHammer();
                player.addEquipment(e);
                return "You use your hammer on the tree and eventually bring it down, not efficient at all, but you do not have an axe.  You add the lumber to your inventory.";
            } else if (worldMap.get(currentIndex) instanceof Structure) {
                worldMap.get(currentIndex).addBack(e);
                setActions(actions++);
                return "It would not be a good idea to swing an axe around in here.";
            }
            worldMap.get(currentIndex).addBack(e);
            setActions(actions++);
            return "You do not have anything you can use to harvest lumber.";
        }
        setActions(actions++);
        return "You need to rest.";
    }

    public String farm() {
        if (updateActions()) {
            Equipment e = worldMap.get(currentIndex).farm();
            if (e != null && player.hoeEquipped()) {
                player.useHoe(e);
                player.addEquipment(e);
                return "You dig up some seeds with your hoe and add them to your inventory.";
            } else if (e != null && player.shovelEquipped()) {
                player.useShovel(e);
                player.addEquipment(e);
                return "You use your shovel to dig up some seeds, not the best use of it, but you do not have a hoe.  You add the seed to your inventory.";
            } else if (e != null && player.axeEquipped()) {
                player.useAxe(e);
                player.addEquipment(e);
                return "You use your axe on the soil and eventually find some seed, terrible use of it, but you do not have a hoe.  You add the seed to your inventory.";
            } else if (e != null && player.hammerEquipped()) {
                player.useHammer();
                player.addEquipment(e);
                return "You use your hammer on the soil and eventually find some seed, not efficient at all, but you do not have a hoe.  You add the seed to your inventory.";
            } else if (worldMap.get(currentIndex) instanceof Structure) {
                worldMap.get(currentIndex).addBack(e);
                setActions(actions++);
                return "It would not be a good idea to swing a hoe around in here.";
            }
            worldMap.get(currentIndex).addBack(e);
            setActions(actions++);
            return "You do not have anything you can use to harvest seed.";
        }
        setActions(actions++);
        return "You need to rest";
    }

    public String mine() {
        if(updateActions()) {
            Equipment e = worldMap.get(currentIndex).mine();
            if (e != null && player.shovelEquipped()) {
                player.useShovel(e);
                player.addEquipment(e);
                return "You dig up some ore with your shovel and add them to your inventory.";
            } else if (e != null && player.hoeEquipped()) {
                player.useHoe(e);
                player.addEquipment(e);
                return "You use your hoe to dig up some ore, not the best use of it, but you do not have a shovel.  You add the ore to your inventory.";
            } else if (e != null && player.axeEquipped()) {
                player.useAxe(e);
                player.addEquipment(e);
                return "You use your axe on the rock and eventually find some ore, terrible use of it, but you do not have a shovel.  You add the ore to your inventory.";
            } else if (e != null && player.hammerEquipped()) {
                player.useHammer();
                player.addEquipment(e);
                return "You use your hammer on the rock and eventually find some ore, not efficient at all, but you do not have a shovel.  You add the ore to your inventory.";
            } else if (worldMap.get(currentIndex) instanceof Structure) {
                worldMap.get(currentIndex).addBack(e);
                setActions(actions++);
                return "It would not be a good idea to swing a shovel around in here.";
            }
            setActions(actions++);
            worldMap.get(currentIndex).addBack(e);
            return "You do not have anything you can use to collect ore.";
        }
        setActions(actions++);
        return "You need to rest";
    }

    public String scareCrow() {
        int index = player.findEquipment("scarecrow");
        if(index != -1) {
           String saying = worldMap.get(currentIndex).scareCrow((Scarecrow) player.getEquipment(index));
           player.dropEquipment(index);
           return saying;
        }
        else
            return "You do not have a scarecrow to place.";
    }

    public String firework() {
        int index = player.findEquipment("firework");
        return worldMap.get(currentIndex).firework((Firework) player.getEquipment(index));
    }

    public String talk() {
        return worldMap.get(currentIndex).talk();
    }

    public String pickUp() {
        if(updateActions()) {
            if(worldMap.get(currentIndex).hasEquipment()) {
                for (Equipment e : worldMap.get(currentIndex).pickUp()) {
                    player.addEquipment(e);
                }
                return "You have picked up all the loose items laying around.";
            }
            setActions(actions++);
            return "There is nothing to pick up.";
        }
        setActions(actions++);
        return "You need to rest.";
    }

    public String hammer() {
        if(updateActions() && !worldMap.get(currentIndex).checkIfImproved()) {
            int lumberIndex = player.findEquipment("lumber");
            int ironIndex = player.findEquipment("iron");
            int goldIndex = player.findEquipment("gold");
            if (goldIndex != -1 && ironIndex != -1 && lumberIndex != -1) {
                player.dropEquipment(goldIndex);
                ironIndex = player.findEquipment("iron");
                player.dropEquipment(ironIndex);
                lumberIndex = player.findEquipment("lumber");
                player.dropEquipment(lumberIndex);
                player.useHammer();
                return worldMap.get(currentIndex).improve();
            }
            setActions(actions++);
            return "You do not have the material to improve this area.";
        }
        setActions(actions++);
        return "You are not capable of improving this area any further.";
    }

    public String rest() {
        if(updateDays()) {
            setActions(worldMap.get(currentIndex).rest());
            return "";
        }
        else {
            return getScore();
        }
    }

    public void setCurrentIndex(int newIndex) { currentIndex = newIndex; }

    public void setActions(int actions) { this.actions = actions; }

    public void setDays(int days) { this.days = days; }

    public int getCurrentIndex() { return currentIndex; }

    public int getActions() { return actions; }

    public int getDays() { return days; }

    public boolean hasActions() {
        return actions != 0;
    }

    public boolean hasDays() {
        return days != 0;
    }

    public boolean updateActions() {
        if(actions > 0) {
            actions--;
            return true;
        }
        else {
            return false;
        }
    }

    public boolean updateDays() {
        if(days > 0) {
            days--;
            return true;
        }
        else {
            return false;
        }
    }

    public String getScore() {
        int areaImproved = 0;
        int scarecrowCount = 0;
        int ironCount = player.countIron();
        int goldCount = player.countGold();
        int lumberCount = player.countLumber();
        int seedCount = player.countSeed();

        for(int count = 0; count < 25; count++) {
            if(worldMap.get(count).checkIfImproved())
                areaImproved++;
            if(worldMap.get(count).getHasScarecrow() && worldMap.get(count) instanceof Field);
                scarecrowCount++;
        }

        int totalScore = ironCount + seedCount + lumberCount + (goldCount * 2) + (scarecrowCount * 10) + (areaImproved * 10);

        return "You have achieved a total score of:  " + totalScore;
    }

    public boolean checkGameOver() {
        if(!hasDays() && !hasActions()) {
            return true;
        }
        return false;
    }
}// end World Class
