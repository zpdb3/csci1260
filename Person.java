// ******
// Filename:   Person
// Team:       Big Bois
// Team Members: Austen Boda, Duncan Hayes, Eric Caton,
//                               Jason Joyce, and Paul Brummitt
// ******
// Written by Paul Brummitt

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
// ** setTool() Method ***************
// ********************************


    public boolean setTool(Equipment e) {	// sets hammer as the tool to be used
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

        else if(e instanceof Hoe){		// sets hoe as the tool to be used
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

        else if(e instanceof Axe){		// sets axe as the tool
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


        else if(e instanceof Shovel){		// sets shovel as the tool
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

// ********************************				
// ** buyItem() Method *****			
// ********************************		

    public boolean buyItem(Equipment e, int price) {		// buy an item takes Equipment and Int for price
        boolean buySuccess = false;
        if(gold.buyItem(price) == true) {			// calls the buyItem in GoldPieces
	  this.pickUp(e);
	  buySuccess = true;
            
                        }
            else {
	      buySuccess = false;            
            }

	return buySuccess;

        }
	
// ********************************				
// ** sellItem() Method *****			
// ********************************		
// sell item takes Person, Equipment and Int

    public boolean sellItem(Person p, Equipment e, int price) {	
        boolean sellSuccess = p.buyItem(e, price);
        if(sellSuccess) {
	  gold.sellItem(price);
	  inventory.removeByEquipment(e);  
        }

	return sellSuccess;

    }



// ********************************				
// ** fearResponse() Method *****			
// ********************************		

    public boolean fearResponse(int fear) {
      currentFear += fear;
      
      if (currentFear > (maxFear/2)) {

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
// ** pickUp() override Method *****			
// ********************************		


    public void pickUp(Equipment e) {		//comment
        this.inventory.addEquipment(e);
    }

// ***** countTools override() Method ***************

    public int countTools() {			//comment
	return inventory.countTools();
    }

// ***** countConsumables override() Method ***************

    public int countConsumables() {			//comment
	return inventory.countConsumables();
    }

// ***** getEquipmentList override() Method ***************

    public String getEquipmentList() {		//comment
        return this.inventory.getEquipmentList();
    }

// ***** getEquipmentInfo override() Method ***************

    public String getEquipmentInfo(int index) {	//comment
        return this.inventory.getEquipmentDetails(index);
    }

// ***** getEquipment override() Method ***************

    public Equipment getEquipment(int index) {	//comment
	return this.inventory.getEquipment(index);
    }

// ***** dropEquipment override() Method ***************

    public void dropEquipment(int index) {		
   	this.inventory.removeEquipment(index);
    }

// ***** dropAllEquipment override() Method ***********

    public void dropAllEquipment(){			
        this.inventory.clearAllEquipment();
    }

// ***** addEquipment override() Method ***************

    public void addEquipment(Equipment e){
	this.inventory.addEquipment(e);
    }


}
