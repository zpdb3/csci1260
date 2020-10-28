// ******
// Filename:   Helmet
// Team:       Big Bois
// Team Members: Austen Boda, Duncan Hayes, Eric Caton,
//                               Jason Joyce, and Paul Brummitt
// ******
// The implementation of Helmet will be lead by Jason Joyce

public class Helmet extends Armor {

    public Helmet() {
        super();
        super.setName("Helmet");
    }

    public Helmet(int price, double durability, int armorBonus, boolean iceProtection, boolean fireProtection) {
        super("Helmet", price, durability, armorBonus, iceProtection, fireProtection);
    }
}
