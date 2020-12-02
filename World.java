// ******
// Filename  World.java
// Team:     Big Bois
// Team Members: Austen Boda, Duncan Hayes, Eric Caton, 
//               Jason Joyce, and Paul Brummitt 
// ******

// Written by Paul Brummitt

import java.security.SecureRandom;
import java.util.*;


public class World
{
  // see p. 475 in text for help with ArrayList objects
//  public ArrayList<Chest>  chests;	//Declare an array of chests
//  public ArrayList<Barrel> barrels;	//Declare an array of barrels
  public ArrayList<Person> people;	//Declare an array of people
//  public Neighbor  player;			//The avatar for the player of the game

  public World()
  {

//    chests  = new ArrayList<Chest>();
//    barrels = new ArrayList<Barrel>();
    people  = new ArrayList<Person>();
//    player = new Person();

    // The following statements begin filling the arrays    	
    makeChest();			 					
    makeChest();
    makeChest();
    makeBarrel();
    makeBarrel();
    makeBarrel();
    makeGoblin();
    makeGoblin();
    makeGoblin();
    makeHuman();


  }

  // ***********************
  //   makeChest Method
  // ***********************  
  public void makeChest() {
//    Chest newChest = new Chest();


//    chests.add(newChest);		//adds a chest to the array of chests

		   
  }  

// ***********************
  //   makeBarrel Method
  // ***********************  
  public void makeBarrel() {
//    Barrel newBarrel = new Barrel();   
//    barrels.add(newBarrel);		//adds a barrel to the array of ba

  }

  // ***********************
  //   makeHuman Method
  // ***********************  
  public void makeHuman() {
//    Human newHuman = new Human();
//    people.add(newHuman); 		//adds a human to the array of people

  }

  // ***********************
  //   makeGoblin Method
  // ***********************  
  public void makeGoblin() {
//    Trader newTrader = new Trader();
//    people.add(newTrader);		//adds a Trader to the array of people
  }

  // ***********************
  //   listChests Method			
  // ***********************  
  public String listChests() {

    int iterator = 0;
    String returnString = "";
    
//    for (Chest name : chests) {
//    returnString += "\n" + iterator + ". Chest: \n" + name.getEquipmentList(); 
//    iterator++;
//    }
       
    return returnString;

  }


    // ***********************
  //   listBarrels Method
  // ***********************  
  public String listBarrels() {
    
    int iterator = 0;
    String returnString = "";
    
//    for (Barrel name : barrels) {
//    returnString += "\n" + iterator + ". Barrel: \n" + name.getEquipmentList(); 
//    iterator++;
//    }
       
    return returnString;

  }

  // ***********************
  //   listPeople Method
  // ***********************  
  public String listPeople() {

    int iterator = 0;
    String returnString = "";
    
//    for (Person name : people) {
//    returnString += "\n" + iterator + name.getName(); 
//    iterator++;
//    }
       
    return returnString;
  }

  // ***********************
  //   listTargets Method			//???Does it matter how items
  // ***********************                    //   in listTargets are numbered
  public String listTargets() {

    return this.listChests() + this.listBarrels() + this.listPeople();
  }

  // ***********************
  //   speakTo Method				
  // ***********************  			
  public String speakTo(Person person) {

//	return person.saySomething();
	return ""; 			//Remove this line  
  }

  // ***********************
  //   attack Method				// ??? What is the range of damage that can be done
  // ***********************  
//  public int attack(IHitable target) {
//  	int dmgHld;
//	dmgHld = player.attack(target);
//	System.out.println(dmgHld == 0 ? "No weapon equipped!" : "Target hit.");
//	return dmgHld;
//  }

  // ***********************
  //   transferEquipment
  // ***********************  
  public void transferEquipment(IInventory source, IInventory destination) {

   	destination.transferAllEquipmentFrom(source);

  }



  // ***********************
  //   peakInside
  // ***********************  
  public String peakInside(IInventory inventory) {
    
	return inventory.getEquipmentList();


  }

  // ***********************
  //   getPersonInfo
  // ***********************  
  public String getPersonInfo(Person person) {

// 	return person.getName() + "\nHealth:  " +  person.getCurrentHealth() + "/" + person.getMaxHealth();
	return "";

  }

  // ***********************
  //   getPlayerInfo
  // ***********************  
  public String getPlayerInfo() {
//    return player.getName() + "\nHealth:  " +  player.getCurrentHealth() + "/" + player.getMaxHealth();
      return "";
    

  }

  // ***********************
  //   listPlayerInventory
  // ***********************  
  public String listPlayerInventory() {
//   return player.getEquipmentList();
  return "";
  }


  // ***********************
  //   equipEquipment
  // ***********************  
  public boolean equipEquipment(Equipment eqmt) {
//    return player.equip(eqmt);
      return true;			// remove this line
  }

  // ***********************
  //   useEquipment
  // ***********************  
  public boolean useEquipment(Equipment eqmt, Person target) {
    
	return eqmt.use(target);

  }



}