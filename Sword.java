// ******
// Filename:   Sword
// Team:       Big Bois
// Team Members: Austen Boda, Duncan Hayes, Eric Caton,
//                               Jason Joyce, and Paul Brummitt
// ******
// The implementation of Sword will be lead by Eric Caton

public class Sword extends Weapon {

    public Sword() {
        super();
        setName("Sword");
        setNormalDamage(5);
        setWeaponHandedness(WeaponHandedness.Versatile);
    }

    public Sword(int dmg, int ice, int fire, WeaponHandedness wp, int price, double durability) {
        super("Sword", dmg, ice, fire, wp, price, durability);
    }
}
