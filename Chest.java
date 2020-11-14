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

     public void Pickup() {
       inventory.addEquipment(e);
     }


}
