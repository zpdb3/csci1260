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

    public Person(String name) {
        this.name = name;
        this.maxHealth = 50;
        this.currentHealth = 40;
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
                this.pickup(helmet);
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
                this.pickup(plackart);
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
                this.pickup(weapon);
                weapon = (Weapon)e;
                equipSuccess = true;
            }
        }

        return equipSuccess;
    }

    public int attack(IHitable target) {
        int damageDone;
        if(this.weapon == null)
            damageDone = 0;
        else
            damageDone = weapon.attack();
        return damageDone;
    }

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
        return this.currentHealth <= 0;
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
        int amtHealed;
        amtHealed = this.currentHealth + amt > this.maxHealth ? this.maxHealth - this.currentHealth : amt;
        currentHealth += amtHealed;
        return amtHealed;
    }

    /*
     *  Implementation of IInventory
     */

    public void pickup(Equipment e) {
        this.inventory.addEquipment(e);
    }

    public void transferAllEquipmentFrom(IInventory other) {
        int count = other.countEquipment();
        for(int iterate = 0 ; iterate < count ; iterate++){
            this.inventory.pickup(other.getEquipment[iterate]);
        }
        other.dropAllEquipment();
    }

    public int countArmor() {
        return this.inventory.countArmor();
    }

    public int countWeapon() {
        return this.inventory.countWeapon();
    }

    public int countConsumables() {
        return this.inventory.countConsumables();
    }

    public int countEquipment() {
        return countArmor() + countWeapon() + countConsumables();
    }

    public String getEquipmentList() {
        return this.inventory.getEquipmentList();
    }

    public String getEquipmentInfo(int index) {
        return this.inventory.getEquipmentDetails(index);
    }

    public Equipment getEquipment(int index) {
        return this.inventory.getEquipment(index);
    }

    public void dropEquipment(int index) {
        this.inventory.removeEquipment(index);
    }

    public void dropAllEquipment() {
        this.inventory.clearAll();
    }
}
