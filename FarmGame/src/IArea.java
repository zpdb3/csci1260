/*
 *  Programmed By:  Eric M. Caton
 *  This is the IArea interface for Farm Game
 *  Version 1.0 last updated Nov 29, 2020
 */

public interface IArea {

    public void populateArea();
    public void animalArea();
    public void mineralArea();
    public void lumberArea();
    public void seedArea();
    public String generateName();
    public String generateDescription(String name);
    public void improve(String improvement);
}
