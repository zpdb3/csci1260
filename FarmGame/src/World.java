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

    public HashMap<int, IArea> worldMap;
    public int currentIndex;
    private String loadPath;
    private int actions;
    private int days;

    private ArrayList<Structure> potentialStructures;
    private ArrayList<Forest> potentialForests;
    private ArrayList<Mine> potentialMines;
    private ArrayList<Field> potentialFields;


    public World() {
        loadPath = "onlyStart.csv";
        worldMap = new HashMap<int, IArea>();
        currentIndex = 12;
        actions = 10;
        days = 14;
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
        worldMap = new HashMap<int, IArea>();
        currentIndex = 12;
        loadPotentialAreas(loadPath);
        this.loadPath = loadPath;
        actions = 10;
        days = 14;
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

    public boolean chop() {
        return true;
    }

    public boolean farm() {
        return true;
    }

    public boolean mine() {
        return true;
    }

    public boolean scareCrow() {
        return true;
    }

    public boolean firework() {
        return true;
    }

    public boolean talk() {
        return true;
    }

    public boolean pickUp() {
        return true;
    }

    public boolean hammer() {
        return true;
    }

    public boolean rest() {
        return true;
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
        if(actions - 1 == 0 && days == 0) {
            actions--;
            return true;
        }
        else if(actions -1 == 0 && days >= 1) {
            return false;
        }
        else {
            actions--;
            return true;
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
}// end World Class
