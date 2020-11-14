// ******
// Filename:   EquipmentManager
// Team:       Big Bois
// Team Members: Austen Boda, Duncan Hayes, Eric Caton,
//                               Jason Joyce, and Paul Brummitt
// ******
// The implementation of EquipmentManager will be lead by Duncan Hayes, Eric Caton 

import java.security.SecureRandom;
import java.util.*;
import java.util.Random;
// A class that inventories equipment
public class EquipmentManager implements IInventory
{
  private ArrayList<Equipment> equipment;

 
  public EquipmentManager() 
  {
    equipment = new ArrayList<Equipment>();
  }
  
  //clears all arrayLists
  public void clearAll() 
  {
	this.equipment.clear();
  }
  
  // This method uses the countArmor and countWeapon method to determine an equipment total.
//  @Override
  public int countEquipment() 
  {
    return equipment.size();
  }
//  @Override
  public int countArmor() 
  {
    int armorCount =0;
	for(int i=0; i<equipment.size(); i++)
	{
		if(equipment.get(i) instanceof Armor)
		{
			armorCount++;
		}
	}
	return armorCount;
  }
//  @Override
  public int countWeapon()
  {
    int weaponCount =0;
	for(int i=0; i<equipment.size(); i++)
	{
		if(equipment.get(i) instanceof Weapon)
		{
			weaponCount++;
		}
	}
	return weaponCount;
  }
//  @Override
  public int countConsumables()
  {
	int consumableCount =0;
	for(int i=0; i<equipment.size(); i++)
	{
		if(equipment.get(i) instanceof Consumable)
		{
			consumableCount++;
		}
	}
	return consumableCount; 
  }
  //Recieves an index to be removed from equipment.
  public void removeEquipment(int index) {
	equipment.remove(index);
  }
  
//  @Override
  public void dropEquipment(int index){
	removeEquipment(index);
  }
//  @Override
  public void dropAllEquipment(){
	clearAll();
  }
  
 
 

  
   //GET EQUIPMENT METHODS
	
//  @Override
  public String getEquipmentList() {	        // ??? Change needed						
	String list = "";					// for each loop and return outside the loop
	for(Equipment e: equipment){
		list += "\n" + e;
	}
	return list;
  }
  
  public String getEquipmentListDetails() { 
  	String list = "";
	for(Equipment e: equipment){
   		list += "\n" + e.toString();
        } 
	return list;
 }
  

  public String getEquipmentDetails(int index) 
  {
    return equipment.get(index).toString();
  }
    
//  @Override
  public String getEquipmentInfo(int index){
	  return getEquipmentDetails(index);
  }

//  @Override
  public Equipment getEquipment(int index){
	return equipment.get(index);
  }
  
//  @Override
  public void addEquipment(Equipment e)
  {
	this.equipment.add(e);
  }
  
//  @Override
  public void pickup(Equipment equipment){
	addEquipment(equipment);
  }
  
//  @Override

// ??? Needs to use a loop 
  public void transferAllEquipmentFrom(IInventory other){
	
	for(int i=0; i<other.countEquipment(); i++){
		pickup(other.getEquipment(i));
	}
	other.dropAllEquipment();
	
  }
  
  
  public static Weapon makeRandomWeapon()
  {
	Random counter = new Random();
	int storage = 0;
        Weapon returnWeapon = new Weapon();

	storage = counter.nextInt(4);
	if(storage == 0)
	{
		Sword sword = new Sword();
		return (Weapon) sword;
	}
	if(storage == 1)
	{
		Spear spear = new Spear();
		return (Weapon) spear;
	}
	if(storage == 2)
	{
		LongBow longBow = new LongBow();
		return (Weapon) longBow;
	}
	if(storage == 3)
	{
		ThrowingAxe throwingAxe = new ThrowingAxe();
		return (Weapon) throwingAxe;
	}
        
        return returnWeapon;
        
  }
  
  public static Armor makeRandomArmor()
  {
	int storage = 0;
        Armor returnArmor = new Armor();
	Random counter = new Random();
	storage = counter.nextInt(2);
	if(storage == 0)
	{
		Helmet helmet = new Helmet();
		return (Armor) helmet;
	}
	if(storage == 1)
	{
		Plackart plackart = new Plackart();
		return (Armor) plackart;
	}
        return returnArmor;
  } 
  
  public static Consumable makeRandomConsumable()
  {
	HealthKit healthKit = new HealthKit();
		return (Consumable) healthKit;
  }
  

  
  
  
  
  //This private getEquipmentDetails produces the String representation of the Equipment that is selected in the public method.
  /*private String getEquipmentDetails(ArrayList list, int index) {
    String infoHolder;
    infoHolder = list.get(index).toString();
    return infoHolder;
  }*/

}
