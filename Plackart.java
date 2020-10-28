// ******
// Filename:   Plackart
// Team:       Big Bois
// Team Members: Austen Boda, Duncan Hayes, Eric Caton,
//                               Jason Joyce, and Paul Brummitt
// ******
// The implementation of Plackart will be lead by Austen Boda

public class Plackart extends Armor 
{

    public Plackart() //extends from armor and creates a new armor object named Plackart that possesses the                              //attribute fire protection
    {
        super();
        setName("Plackart");
        activateFireProtection();
    }

    public Plackart(int price, double durability, int armorBonus, boolean iceProtection, boolean fireProtection) //extends from armor to set the default attributes of a Plackart obhect
    {
        super("Plackart", price, durability, armorBonus, iceProtection, fireProtection);
    }
}
