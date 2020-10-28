// ******
// Filename
// Team:                   Big Bois
// Team Members: Austen Boda, Duncan Hayes, Eric Caton, 
//                               Jason Joyce, and Paul Brummitt 
// ******

// The implementation of LongBow will be lead by Paul Brummitt
// Composed by Eric Caton and Paul Brummitt
// Testing by Austen Boda and Jason Joyce

public class LongBow extends Ranged {  

    public LongBow() {			// Sets constructor with no parameters
        super();			// default call to super
        setName("Long Bow");		// set name of the weapon
        setNormalDamage(5);		// set Normal Damage to the default value
        setPrice(85);			// set the Price to the default value
        setWeaponHandedness(WeaponHandedness.TwoHanded);	// set WeaponHandedness using enum
        setMaxAmmo(100);		// set default value of MaxAmmo to 100
        addAmmo(getMaxAmmo()/2);	// set current ammo value to 50% of maxAmmo value
        setRange(150);			// set the default range to 150
    }
    // Set constructor with parameters
    public LongBow(int dmg, int ice, int fire, WeaponHandedness wp, int price, double durability, double range, int maxAmmo) {
        super("Long Bow", dmg, ice, fire, wp, price, durability, range, maxAmmo); // call to super to set values
    }
}
