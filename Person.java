import java.util.ArrayList;
import java.util.Random;

public abstract class Person implements IInventory{

    private String name;
    private ArrayList<String> dialog;
    private Hammer hammer;
    private Hoe hoe; 
    private Axe axe;
    private Shovel shovel;
    private EquipmentManager inventory;
    private GoldPieces gold;
    private int maxFear;
    private int currentFear;

    public Person(String name) {
        this.name = name;
	this.maxFear = 25;
	this.currentFear = 5;
	this.dialog = new ArrayList<>();
	this.hammer = new Hammer();
	this.hoe = new Hoe();
	this.axe = new Axe();
	this.inventory = new EquipmentManager();

    }

// ********************************
// ** talk() Method ***************
// ********************************

    public String talk() {

        Random rand = new Random();
        int rando = rand.nextInt(3);
        return dialog.get(rando);
    }


// ********************************
// ** equip() Method ***************
// ********************************


    public boolean setTool(Equipment e) {		// equip the hammer here
        boolean equipSuccess = false;
        if(e instanceof Hammer) {             
            if(e == null) {
                hammer = (Hammer)e;			
                equipSuccess = true;
            }
            else {
                this.pickUp(hammer);
                hammer = (Hammer)e;
                equipSuccess = true;
            }
        }

        else if(e instanceof Hoe){		// equip the hoe here
            if(e == null) {
                hoe = (Hoe)e;
                equipSuccess = true;
            }
            else {
                this.pickUp(hoe);
                hoe = (Hoe)e;
                equipSuccess = true;
            }
        }

        else if(e instanceof Axe){		// equip the axe here
            if(e == null) {
                axe = (Axe)e;
                equipSuccess = true;
            }
            else {
                this.pickUp(axe);
                axe = (Axe)e;
                equipSuccess = true;
            }
        }


        else if(e instanceof Shovel){		// equip the shovel here
            if(e == null) {
                shovel = (Shovel)e;
                equipSuccess = true;
            }
            else {
                this.pickUp(shovel);
                shovel = (Shovel)e;
                equipSuccess = true;
            }
        }




        return equipSuccess;
    }

// ********************************		//???		
// ** buyItem() Method *****			
// ********************************		

    public boolean buyItem(Equipment e, int price) {		// buy an item takes Equipment and Int for price
        boolean buySuccess = false;
        if(gold.buyItem(price) == true) {
	  this.pickUp(e);
	  buySuccess = true;
            
                        }
            else {
	      buySuccess = false;            
            }

	return buySuccess;

        }
	


  
  


// ********************************		//???		
// ** sellItem() Method *****			
// ********************************		

    public boolean sellItem(Person p, Equipment e, int price) {	// sell item takes Person, Equipment and Int
        boolean sellSuccess = p.buyItem(e, price);
        if(sellSuccess) {
	  gold.sellItem(price);
	  inventory.removeByEquipment(e);  
	            
                        }
          

	return sellSuccess;

        }



// ********************************		//???		
// ** fearResponse() Method *****			
// ********************************		

    public boolean fearResponse(int fear) {
      currentFear += fear;
      
      if (currentFear > (maxFear/2)) {
        // make new arrayList of comments
        return false;
      }
      if (currentFear > maxFear) {
        return true;
      }
    return false;
      
    }



// ********************************		
// ** setDialog() Method *****			
// ********************************		

    public void setThingsToSay(ArrayList<String> list) {
        this.dialog = list;
    }


// ********************************		
// ** pickUp() Method *****			
// ********************************		

    public void pickUp(Equipment e) {		//comment
        this.inventory.addEquipment(e);
    }

  public int countTools() {			//comment
	return inventory.countTools();
}

public int countConsumables() {			//comment
	return inventory.countConsumables();
}

public String getEquipmentList() {		//comment
        return this.inventory.getEquipmentList();
}

public String getEquipmentInfo(int index) {	//comment
        return this.inventory.getEquipmentDetails(index);
}

public Equipment getEquipment(int index) {	//comment
	return this.inventory.getEquipment(index);
}

public void dropEquipment(int index) {		//comment
  this.inventory.removeEquipment(index);
}

public void dropAllEquipment(){			//comment
        this.inventory.clearAllEquipment();
}

public void addEquipment(Equipment e){
}


}
