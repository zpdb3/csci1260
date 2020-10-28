// ******
// Filename:   Spear
// Team:       Big Bois
// Team Members: Austen Boda, Duncan Hayes, Eric Caton,
//                               Jason Joyce, and Paul Brummitt
// ******
// The implementation of Spear will be lead by Duncan Hayes

public class Spear extends Weapon {

    public Spear() {
    	super();
		setName("Spear");
		setPrice(135);
		setNormalDamage(8);
		setWeaponHandedness(WeaponHandedness.TwoHanded);
    }

    public Spear(int dmg, int ice, int fire, WeaponHandedness wp, int price, double durability) {
    	super("Spear", dmg, ice, fire, wp, price, durability);
	}
}
