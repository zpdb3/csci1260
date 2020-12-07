/*
 *  Programmed By:  Eric M. Caton
 *  This is the IArea interface for Farm Game
 *  Version 1.0 last updated Nov 29, 2020
 */

import java.util.ArrayList;

public interface IArea {

    public void populateArea();
    public void populateArea(int min, String prefType);
    public void animalArea();
    public void animalArea(int min, String prefType);
    public void mineralArea();
    public void mineralArea(int min, String prefType);
    public void lumberArea();
    public void lumberArea(int min);
    public void seedArea();
    public void seedArea(int min, String prefType);
    public String generateName();
    public String generateDescription(String name);
    public Equipment chop();
    public Equipment farm();
    public Equipment mine();
    public boolean getHasScarecrow();
    public String scareCrow(Scarecrow s);
    public String firework(Firework f);
    public String talk();
    public ArrayList<Equipment> pickUp();
    public int rest();
    public boolean checkIfImproved();
    public String improve();
    public void addBack(Equipment e);
    public boolean hasEquipment();
    public String getName();
    public String getIconPath();
    public String getImagePath();
    public String getType();
    public String getDescription();
}
