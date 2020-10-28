// ******
// Filename:   Ranged
// Team:       Big Bois
// Team Members: Austen Boda, Duncan Hayes, Eric Caton,
//                               Jason Joyce, and Paul Brummitt
// ******
// The implementation of Ranged will be lead by Eric Caton

public class Ranged extends Weapon
{
  private double range;
  private int currentAmmo;
  private int maxAmmo;

  public Ranged() {
    super();
  }

  public Ranged(String name, int dmg, int ice, int fire, WeaponHandedness wp, int price, double durability, double range, int maxAmmo) {
    super(name, dmg, ice, fire, wp, price, durability);
    setRange(range);
    setMaxAmmo(maxAmmo);
    addAmmo(((int) getMaxAmmo() / 2));
  }

  public double getRange() {
    return this.range;
  }

  public int getAmmo() {
    return this.currentAmmo;
  }

  public int getMaxAmmo() {
    return this.maxAmmo;
  }

  public void setRange(double r) {
    this.range = r;
  }

  public void setMaxAmmo(int m) {
    this.maxAmmo = m;
  }

  public int addAmmo(int a) {
    int amtToBeAdded = (this.currentAmmo + a > this.maxAmmo) ? (this.maxAmmo - this.currentAmmo) : a;
    this.currentAmmo += amtToBeAdded;
    return amtToBeAdded;
  }

  //returns properties about the selected ranged weapon in String form
  public String toString() {
    return ("{name:\"" + this.getName() + "\", price:" + this.getPrice() + ", durability:\"" +
            this.getDurabilityStatus() + "\", normal:" + this.getNormalDamage() + ", ice:" +
            this.getIceDamage() + ", fire:" + this.getFireDamage() + ", weaponHandedness:\"" +
            this.getWeaponHandedness() + "\", range:" + this.getRange() + ", currentAmmo:" +
            this.getAmmo() + ",maxAmmo:" + this.getMaxAmmo() + "}");
  }

}
