import java.util.ArrayList;
import java.util.Random;

public abstract class Person implements IHitable, IInventory{

    private String name;
    private ArrayList<String> thingsToSay;
    private Helmet helmet;
    private Plackart plackart;
    private Weapon weapon;
    private EquipmentManager inventory;
    private int maxHealth;
    private int currentHealth;
    private Equipment e;

    public Person(String name) {
        this.name = name;
        maxHealth = getMaxHealth(); //removed this.MaxHealth and super.GetMaxHealth ???
        currentHealth = getCurrentHealth(); //removed this.currentHealth & super.get ???
     }

    public String saySomething() {

        Random rand = new Random();
        int rando = rand.nextInt(3);
        return thingsToSay.get(rando);
    }

    public boolean equip(Equipment e) {
        boolean equipSuccess = false;
        if(e instanceof Helmet) {
            if(e == null) {
                helmet = (Helmet)e;
                equipSuccess = true;
            }
            else {
                pickup(helmet);       // ??? removed super.
                helmet = (Helmet)e;
                equipSuccess = true;
            }
        }
        else if(e instanceof Plackart){
            if(e == null) {
                plackart = (Plackart)e;
                equipSuccess = true;
            }
            else {
                pickup(plackart);       ///??? removed super.
                plackart = (Plackart)e;
                equipSuccess = true;
            }
        }
        else if(e instanceof Weapon){
            if(e == null) {
                weapon = (Weapon)e;
                equipSuccess = true;
            }
            else {
                pickup(weapon);		//???remove super.pickup
                weapon = (Weapon)e;
                equipSuccess = true;
            }
        }

        return equipSuccess;
    }
/* ---- ??? add this back
    public int attack(IHitable target) {
        int damageDone;
        if(this.weapon == null)
            damageDone = 0;
        else
            damageDone = weapon.attack();
        return damageDone;
    }
*/
    public String getName() {
        return this.name;
    }

    public String toString() {
        String buildString = "";
        buildString += "Name:     " + name + "\n";
        buildString += "Health:   " + this.currentHealth + "/" + this.maxHealth + "\n";
        buildString += "Helmet:   " + this.helmet.getName() + "\n";
        buildString += "Plackart: " + this.plackart.getName() + "\n";
        buildString += "Weapon:   " + this.weapon.getName();
        return buildString;
    }

    public ArrayList<String> getThingsToSay() {
        return this.thingsToSay;
    }

    public void setThingsToSay(ArrayList<String> list) {
        this.thingsToSay = list;
    }

    /*
     *  Implementation of IHitable
     */

    public int getMaxHealth() {
        return this.maxHealth;
    }

    public int getCurrentHealth() {
        return this.currentHealth;
    }

    public boolean isHitableDestroyed() {
      return false;				//??? change return
    }

    public int takeDamage(int dmg, int fire, int ice) {
        int totalDamage = 0;

        if(helmet != null && helmet.hasFireProtection()){
            if(fire != 0)
                fire = fire - 3 > 0 ? fire - 3 : 0;
        }

        if(helmet != null && helmet.hasIceProtection()){
            if(ice != 0)
                ice = ice - 3 > 0 ? ice - 3 : 0;
        }

        if(plackart != null && plackart.hasFireProtection()){
            if(fire != 0)
                fire = fire - 3 > 0 ? fire - 3 : 0;
        }

        if(plackart != null && plackart.hasIceProtection()){
            if(ice != 0)
                ice = ice - 3 > 0 ? ice - 3 : 0;
        }
        totalDamage = dmg + ice + fire;

        if(helmet != null)
            totalDamage -= helmet.getArmorBonus() / 2;

        if(plackart != null)
            totalDamage -= plackart.getArmorBonus() / 2;

        if(totalDamage < 0)
            totalDamage = 0;

        return totalDamage;
    }

    public int heal(int amt) {
	  return 0; //??? change return
    }

    /*
     *  Implementation of IInventory
     */

    public void pickup(Equipment e) {

    }

    public void transferAllEquipmentFrom(IInventory other) {

    }

    public int countArmor() {
      return 0; //??? change return
    }

  // ***********************
  //   countEquipment()
  //   counts equipment on hand
  // ***********************  
  
    public int countEquipment()  {
      return 0;
    }


    public int countWeapon() {
  return 0; //??? change return
    }

    public int countConsumables() {
  return 0; //??? change return
    }

    public String getEquipmentList() {
      return ""; //??? change return
    }

    public String getEquipmentInfo(int index) {
      return ""; //??? change return
    }


    public Equipment getEquipment(int index) {
      return e;  
    }

    public void dropEquipment(int index) {

    }

    public void dropAllEquipment() {

    }
}
