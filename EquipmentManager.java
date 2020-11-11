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
public class EquipmentManager implements Inventory
{
  private ArrayList<Equipment> equipment;

 
  public EquipmentManager() 
  {
    equipment = new ArrayList<Equipment>();
  }
  
  //clears all arrayLists
  public void clearAll() 
  {
	equipment.clear();
  }
  
  // This method uses the countArmor and countWeapon method to determine an equipment total.
  @Override
  public int countEquipment() 
  {
    return equipment.size();
  }
  @Override
  public int countArmor() 
  {
    int armorCount =0;
	for(int i=0; i<equipment.size(); i++)
	{
		if(equipment(i)== typeOF(Armor))
		{
			armorCount++;
		}
	}
	return armorCount;
  }
  @Override
  public int countWeapon()
  {
    int weaponCount =0;
	for(int i=0; i<equipment.size(); i++)
	{
		if(equipment(i)== typeOf(Weapon))
		{
			weaponCount++;
		}
	}
	return weaponCount;
  }
  @Override
  public int countConsumables()
  {
	int consumbaleCount =0;
	for(int i=0; i<equipment.size(); i++)
	{
		if(equipment(i)== typeOf(Consumable))
		{
			consumbaleCount++;
		}
	}
	return consumableCount; 
  }
  //Recieves an index to be removed from equipment.
  public void removeEquipment(int index) {
	equipment.remove(index);
  }
  
  @Override
  public void dropEquipment(int index){
	removeEquipment(index);
  }
  @Override
  public void dropAllEquipment(){
	equipment.clearAll();
  }
  
 
 

  
   //GET EQUIPMENT METHODS
	
  @Override
  public String getEquipmentList() {							

	for(int i =0; i<equipment.size(); i++){
		return equipment(i).toString();
	}
  }
  
  public String getEquipmentListDetails() {
  
	for(int i =0; i<equipment.size(); i++){
		return equipment(i).toString();
  }
  }
  
  public String getEquipmentDetails(int index) 
  {
    return equipment(index).toString;
  }
    
  @Override
  public String getEquipmentInfo(int index){
	  return getEquipmentDetails(index);
  }

  @Override
  public Equipment getEquipment(int index){
	return equipment(index);
  }
  
  @Override
  public void addEquipment(Equipment e)
  {
	equipment.add(e); 
  }
  
  @Override
  public void Pickup(Equipment e){
	equipment.addEquipment(e);
  }
  
  @Override
  public void transferAllEquipmentFrom(IInventory other){
	
    for(int i =0; i<equipment.size(); i++){
		equipment(i).pickup();
  }
	other.dropAllEquipment();
	
  }
  
  
  public static Weapon makeRandomWeapon()
  {
	Random counter = new Random();
	int storage = 0;
	storage = counter.nextInt(4);
	if(storage == 0)
	{
		Sword sword = new Sword();
	}
	if(storage == 1)
	{
		Spear spear = new Spear();
	}
	if(storage == 2)
	{
		LongBow longBow = new LongBow();
	}
	if(storage == 3)
	{
		ThrowingAxe throwingAxe = new ThrowingAxe();
	}
  }
  
  public static Armor makeRandomArmor()
  {
	int storage = 0;
	Random counter = new Random();
	storage = counter.nextInt(2);
	if(storage == 0)
	{
		Helmet helmet = new Helmet();
	}
	if(storage == 1)
	{
		Plackart plackart = new Plackart();
	}
  } 
  
  public static void makeRandomConsumable()
  {
	HealthKit healthKit = new HealthKit();
  }
  

  
  
  
  
  //This private getEquipmentDetails produces the String representation of the Equipment that is selected in the public method.
  /*private String getEquipmentDetails(ArrayList list, int index) {
    String infoHolder;
    infoHolder = list.get(index).toString();
    return infoHolder;
  }*/

}
