// ******
// Filename:   Armor
// Team:       Big Bois
// Team Members: Austen Boda, Duncan Hayes, Eric Caton,
//                               Jason Joyce, and Paul Brummitt
// ******
// The implementation of Armor will be lead by Jason Joyce, Duncan Hayes

public class Armor extends Equipment
{
  private int armorBonus;
  private boolean iceProtection;
  private boolean fireProtection;

  public Armor() {
      super();
  }

  public Armor(String name, int price, double durability, int armorBonus, boolean iceProtection, boolean fireProtection) {
      super(name, price, durability);
      this.armorBonus = armorBonus;
      if(iceProtection)
          this.activateIceProtection();
      else
          this.deactivateIceProtection();
      if(fireProtection)
          this.activateFireProtection();
      else
          this.deactivateFireProtection();
  }

  //overrides the getName method from equipment to add necessary suffix.
  public String getName() {
      String nameHold = super.getName();
      if (hasIceProtection() && hasFireProtection())
          nameHold += " of Environmental Protection";
      else if (hasIceProtection())
          nameHold += " of Ice Protection";
      else if (hasFireProtection())
          nameHold += "of Fire Protection";
      return nameHold;
  }

  public int getArmorBonus() {
      return armorBonus;
  }

  public boolean hasIceProtection() {
      return iceProtection;
  }

  public boolean hasFireProtection() {
      return fireProtection;
  }

  public void activateIceProtection() {
      iceProtection = true;
  }

  public void activateFireProtection() {
      fireProtection = true;
  }

  public void deactivateIceProtection() {
      iceProtection = false;
  }

  public void deactivateFireProtection() {
      fireProtection = false;
  }
  
  // returns a string with the details of the specified equipment.
  public String toString() {
      return ("{name:\"" + super.getName() + "\", price:" + super.getPrice() + ", durability:\"" +
              super.getDurabilityStatus() + "\", ice:" + (this.hasIceProtection()) +
              ", fire:" + (this.hasFireProtection()) + "}");
  }

	public boolean use(Person person) {
		return person.equip(this);
	}
}
