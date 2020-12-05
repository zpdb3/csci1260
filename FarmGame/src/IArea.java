/*
 *  Programmed By:  Eric M. Caton
 *  This is the IArea interface for Farm Game
 *  Version 1.0 last updated Nov 29, 2020
 */

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
    public boolean checkIfImproved();
    public void improve(boolean improved);
}
