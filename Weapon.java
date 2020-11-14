// ******
// Filename:   Weapon
// Team:       Big Bois
// Team Members: Austen Boda, Duncan Hayes, Eric Caton,
//                               Jason Joyce, and Paul Brummitt
// ******
// The implementation of Weapon will be lead by Duncan Hayes

public class Weapon extends Equipment
{
  private int normalDamage;             //declares normalDamage as an int
  private int iceDamage;                //declares iceDamage as an int
  private int fireDamage;               //declares fireDamage as an int
  private WeaponHandedness weaponHand;  //declares WeaponHandedness

  public Weapon() {
    super();
  }

  //sets the name, price, durability, damage, fire/ice damage, and the weapon handedness
  public Weapon(String name, int dmg, int ice, int fire, WeaponHandedness wp, int price, double durability) {  
    super(name, price, durability);
    setNormalDamage(dmg);
    setFireDamage(fire);
    setIceDamage(ice);
    setWeaponHandedness(wp);
  }
  
  //overrides the getName method from equipment to add necessary prefixes/suffixes.
  public String getName() {            
    String nameHolder = super.getName();
    if (iceDamage > 0 && fireDamage > 0)
      nameHolder += " of Mighty Wrath";
    else if (fireDamage > 0)
      nameHolder += "Flaming " + nameHolder;
    else if (iceDamage > 0)
      nameHolder += "Frozen " + nameHolder;
    return nameHolder;
  }

  //returns normalDamage
  public int getNormalDamage() {      
    return normalDamage;
  }

  //returns FireDamage
  public int getFireDamage() {        
    return fireDamage;
  }

  //returns IceDamage
  public int getIceDamage() {         
    return iceDamage;
  }

  //returns the WeaponHandedness
  public WeaponHandedness getWeaponHandedness() {     
    return weaponHand;
  }

  //sets the NormalDamage for the Weapon
  public void setNormalDamage(int dmg) {              
    normalDamage = dmg;
  }

  //sets the IceDamage for the Weapon
  public void setIceDamage(int dmg) {                 
    iceDamage = dmg;
  }

  //sets the FireDamage for the Weapon
  public void setFireDamage(int dmg) {                
    fireDamage = dmg;
  }

  //sets the Weapon Handedness of the weapon
  public void setWeaponHandedness(WeaponHandedness wp) {  
    weaponHand = wp;
  }

  public String toString() {
    return ("{name: \"" + super.getName() + "\", price: " + super.getPrice() + ", durability: \"" +
            super.getDurability() + "\", normal: " + this.getNormalDamage() + ", ice: " + this.getIceDamage() +
            ", fire: " + this.getFireDamage() + ", weaponHandedness: \"" + this.getWeaponHandedness() + "\"}" );
  }
  
  public int attack(IHitable hitable){
	return hitable.takeDamage(getNormalDamage(), getFireDamage(), getIceDamage());
        
  }
  

  public boolean use(Person person){
	attack(person);
	
	return person.isHitableDestroyed();
  }







}
