// ******
// Filename:   Chest
// Team:       Big Bois
// Team Members: Austen Boda, Duncan Hayes, Eric Caton,
//                               Jason Joyce, and Paul Brummitt
// ******
// The implementation of Chest will be lead by Austen Boda

public class Chest implements IUsable, IInventory
{
    private EquipmentManager inventory;


    public Chest() //creates a new armor object named Chest that possesses the                                              //attribute fire protection
    {
//        super();
        String name = "Chest";
//        activateFireProtection();


    }


     public boolean use()
      {
        return true;
      }

     public void Pickup(Equipment e) {
       inventory.addEquipment(e);
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
            this.inventory.pickup(other.getEquipment(iterate));
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


