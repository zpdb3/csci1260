/*
 *  Programmed By:  Eric M. Caton
 *  This is the world for Farm Game
 *  Version 1.0 last updated Nov 29, 2020
 */

import java.util.HashMap;
import java.util.Random;

public class World {

    public HashMap<int, IArea> worldMap;
    public IArea currentArea;

    public World() {
        currentArea = loadStartingArea();
        worldMap.put(12, currentArea);

        for (int count = 0; count < 25; count++) {
            if (count != 12)
                worldMap.put(count, createRandomArea());
        }
    }// end World() constructor

    private IArea loadStartingArea() {
        //file AO here to load beginning information.
        Structure startArea = new Structure("Farmers Only Inn", "A rustic little inn in a small farming community", "hammer", false);
        return startArea;
    }// end IArea createStartingArea()

    private IArea createRandomArea() {
        Random dice = new Random();
        int roll = dice.nextInt(10);

        switch (roll) {
            case 0:
                Structure structure = new Structure();
                return structure;
            case 1:
            case 2:
            case 3:
            case 4:
                Field field = new Field();
                return field;
            case 5:
            case 6:
            case 7:
                Forest forest = new Forest();
                return forest;
            case 8:
            case 9:
                Mine mine = new Mine();
                return mine;
            default:
                Structure structureDefault = new Structure();
                return structureDefault;
        }
    }// end IArea createRandomArea()

}// end World Class
