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
  public ArrayList<Chest>  chests;
  public ArrayList<Barrel> barrels;
  public ArrayList<Person> people;
  public Person player;

  public World()
  {
    // Enter code here
    chests  = new ArrayList<Chest>();
    barrels = new ArrayList<Barrel>();
    people  = new ArrayList<Person>();
  }
  
  // ***********************
  //   makeChest Method
  // ***********************  
  public void makeChest() {
      //Enter code for makeChest here

  }

  // ***********************
  //   makeBarrel Method
  // ***********************  
  public void makeBarrel() {
      //Enter code for makeBarrel here

  }

  // ***********************
  //   makeHuman Method
  // ***********************  
  public void makeHuman() {
      //Enter code for makeHuman here

  }

  // ***********************
  //   makeGoblin Method
  // ***********************  
  public void makeGoblin() {
      //Enter code for makeGoblin here

  }

  // ***********************
  //   listChests Method
  // ***********************  
  public String listChests() {
      //Enter code for listChests here
    
    return "Update Return Value Here";

  }

  // ***********************
  //   listBarrels Method
  // ***********************  
  public String listBarrels() {
      //Enter code for listBarrels here

    return "Update Return Value Here";
  }

  // ***********************
  //   listPeople Method
  // ***********************  
  public String listPeople() {
      //Enter code for listPeople here

    return "Update Return Value Here";
  }

  // ***********************
  //   listTargets Method
  // ***********************  
  public String listTargets() {
      //Enter code for listTargets here

    return "Update Return Value Here";
  }

  // ***********************
  //   speakTo Method
  // ***********************  
  public String speakTo(Person person) {
      //Enter code for speakTo here

    return "Update Return Value Here";
  }


  // ***********************
  //   transferEquipment
  // ***********************  
  public void transferEquipment(IInventory source, IInventory destination) {
      //Enter code for transferEquipment here


  }



  // ***********************
  //   peakInside
  // ***********************  
  public String peakInside(IInventory inventory) {
      //Enter code for transferEquipment here

    return "Update Return Value Here";


  }

  // ***********************
  //   getPersonInfo
  // ***********************  
  public String getPersonInfo(Person person) {
      //Enter code for transferEquipment here

    return "Update Return Value Here";


  }

  // ***********************
  //   getPlayerInfo
  // ***********************  
  public String getPlayerInfo() {
      //Enter code for getPlayerInfo here

    return "Update Return Value Here";

  }

  // ***********************
  //   listPlayerInventory
  // ***********************  
  public String listPlayerInventory() {
      //Enter code for getPlayerInfo here

    return "Update Return Value Here";

  }


  // ***********************
  //   equipEquipment
  // ***********************  
  public boolean equipEquipment(Equipment eqmt) {
      //Enter code for getPlayerInfo here

    return true;

  }

  // ***********************
  //   useEquipment
  // ***********************  
  public boolean useEquipment(Equipment eqmt, Person target) {
      //Enter code for useEquipment here

    return true;

  }




}
