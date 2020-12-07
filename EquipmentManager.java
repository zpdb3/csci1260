// ******
// Filename:   EquipmentManager
// Team:       Big Bois
// Team Members: Austen Boda, Duncan Hayes, Eric Caton,
//                               Jason Joyce, and Paul Brummitt
// ******
// Written by Paul Brummitt

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
  
  //clears equipment in arrayLists
  public void clearAllEquipment() 
  {
	equipment.clear();
  }
  

// removeByEquipment

  public void removeByEquipment(Equipment e) {
    equipment.remove(e);
  }


//Receives an index to be removed from equipment.
  public void removeEquipment(int index) {
	equipment.remove(index);
  }

  public String listEquipment() {	        						
	String list = "";					// for each loop and return outside the loop
	for(Equipment e: equipment){
		list += "     " + e.getName() + "\n";
	}
	return list;
  }


// getEquipmentDetails

  public String getEquipmentDetails(int index) 
  {
    return equipment.get(index).toString();
  }


// addEquipment
  public void addEquipment(Equipment e)
  {
	this.equipment.add(e);
  }

// *******************************************
// **** Overrides begin here *****************
// *******************************************


// *** pickUp() ******************************
// *** overrides pickUp() in IInventory ******
// *******************************************

  public void pickUp(Equipment equipment){
	addEquipment(equipment);
  }



// *** override countTools in IInventory ***

  public int countTools() 
  {
	int toolCount =0;
	for(int i=0; i<equipment.size(); i++)
	{
		if(equipment.get(i) instanceof Tool)
		{
			toolCount++;
		}
	}
	return toolCount; 
  }


// *** override countConsumables in IInventory ***

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

// ***         countIron            ***
// *** looks for instance of iron   ***
// *** and returns a count for iron ***

  public int countIron()
  {
	int ironCount =0;
	for(int i=0; i<equipment.size(); i++)
	{
		if(equipment.get(i) instanceof Iron)
		{
			ironCount++;
		}
	}
	return ironCount; 
  }


// ***         countGold            ***
// *** looks for instance of Gold   ***
// *** and returns a count for Gold ***

  public int countGold()
  {
	int goldCount =0;
	for(int i=0; i<equipment.size(); i++)
	{
		if(equipment.get(i) instanceof Gold)
		{
			goldCount++;
		}
	}
	return goldCount; 
  }


// ***         countLumber          ***
// *** looks for instance of lumber ***
// *** and returns count for lumber ***

  public int countLumber()
  {
	int lumberCount =0;
	for(int i=0; i<equipment.size(); i++)
	{
		if(equipment.get(i) instanceof Lumber)
		{
			lumberCount++;
		}
	}
	return lumberCount; 
  }


// ***         countSeed            ***
// *** looks for instance of seed   ***
// *** and returns a count for seed ***

  public int countSeed()
  {
	int seedCount =0;
	for(int i=0; i<equipment.size(); i++)
	{
		if(equipment.get(i) instanceof Seed)
		{
			seedCount++;
		}
	}
	return seedCount; 
  }




// *** override countEquipment in IInventory ***

  public int countEquipment() 
  {
    return equipment.size();
  }


// *** override getEquipmentList in IInventory ***
  public String getEquipmentList() {	        						
	String list = "";					// for each loop and return outside the loop
	for(Equipment e: equipment){
		list += "     " + e.getName() + "\n";
	}
	return list;
  }



// *** override getEquipmentInfo in IInventory ***

  public String getEquipmentInfo(int index){
	  return getEquipmentDetails(index);
  }


// *** override getEquipment in IInventory ***

  public Equipment getEquipment(int index){
	return equipment.get(index);
  }



// *** override dropEquipment in IInventory ***
  public void dropEquipment(int index){
	removeEquipment(index);
  }

// *** override dropAllEquipment in IInventory ***

  public void dropAllEquipment(){
	clearAllEquipment();
  }
  
}
