// ******
// Filename:   ThrowingAxe
// Team:       Big Bois
// Team Members: Austen Boda, Duncan Hayes, Eric Caton,
//                               Jason Joyce, and Paul Brummitt
// ******
// The implementation of ThrowingAxe will be lead by Paul Brummitt

public class ThrowingAxe extends Ranged {

    public ThrowingAxe() {
        super();
        setName("Throwing Axe");
        setNormalDamage(8);
        setPrice(125);
        setWeaponHandedness(WeaponHandedness.OneHanded);
    }

    public ThrowingAxe(int dmg, int ice, int fire, WeaponHandedness wp, int price, double durability, double range, int maxAmmo) {
        super("Throwing Axe", dmg, ice, fire, wp, price, durability, range, maxAmmo);
    }
}
