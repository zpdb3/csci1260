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
  public ArrayList<Chest>  chests;	//Declare an array of chests
  public ArrayList<Barrel> barrels;	//Declare an array of barrels
  public ArrayList<Person> people;	//Declare an array of people
  public Person player;			//The avatar for the player of the game

  public World()
  {
    // Enter code here
    chests  = new ArrayList<Chest>();	//Instantiate the array
    barrels = new ArrayList<Barrel>();	//Instantiate the array
    people  = new ArrayList<Person>();	//Instantiate the array
    	
    makeChest();			 					
    makeChest();
    makeChest();
    makeBarrel();
    makeBarrel();
    makeBarrel();
    makeGoblin();			//???Ask about instanceOf
    makeGoblin();
    makeGoblin();
    makeHuman();
    
//    Goblin goblinName = makeGoblin();
//    people.add = makeHuman();    	
    
    
  }
  
  // ***********************
  //   makeChest Method
  // ***********************  
  public void makeChest() {
    System.out.println("You have called makeChest");	// removeMe
    chests.add(new Chest());		//???I am adding these to the World
					//   but not sure about the "Named" part
    
	

  }

// ***********************
  //   makeBarrel Method
  // ***********************  
  public void makeBarrel() {
    System.out.println("You have called makeBarrel");	// removeMe    
    barrels.add(new Barrel());
  }

  // ***********************
  //   makeHuman Method
  // ***********************  
  public void makeHuman() {
    System.out.println("You have called makeHuman");	// removeMe
    people.add(new Person());

  }

  // ***********************
  //   makeGoblin Method
  // ***********************  
  public void makeGoblin() {
    System.out.println("You have called makeGoblin");	// removeMe

    people.add(new Goblin());

  }
  // ***********************
  //   listChests Method				//???Example of adding item to chest
  // ***********************  
  public String listChests() {
      //Refer to EquipmentManager getEquipmentList()
      //and getEquipmentListDetails()
    int iterator = 0;
    String returnString = "Chests: \n";
    if (chests.isEmpty()) {
      returnString += "<<empty>>\n";
    }      
    else
      for (Chest c : chests) {
        returnString += iterator + ". " + c + "\n";
        iterator++;
    }
    iterator = 0;
    
    return returnString;

  }

  // ***********************
  //   listBarrels Method
  // ***********************  
  public String listBarrels() {
    System.out.println("You have called listBarrels");
    int iterator = 1;
    String returnString = "Barrels: \n";

    if (barrels.isEmpty())
      returnString += "<<empty>>\n";
    else
      for (Barrel b : barrels) {
        System.out.println(b);
        returnString += iterator + ". " + b + "\n";
        iterator++;
    }
    iterator = 1;

    return "Update Return Value Here";
  }

  // ***********************
  //   listPeople Method
  // ***********************  
  public String listPeople() {

    System.out.println("You have called listPeople");
    int iterator = 1;
    String returnString = "People: \n";

    if (people.isEmpty())
      returnString += "<<empty>>\n";
    else
      for (Person p : people) {
        System.out.println(p);
        returnString += iterator + ". " + p + "\n";
        iterator++;
    }
    iterator = 1;

    return "Update Return Value Here";
  }

  // ***********************
  //   listTargets Method			//???Does it matter how items
  // ***********************                    //   in listTargets are numbered
  public String listTargets() {

    System.out.println("You have called listTargets");
    int iterator = 1;
    String returnString = "Targets: \n";

    if (people.isEmpty() && barrels.isEmpty())
      returnString += "<<empty>>\n";
    else
    {
      listPeople();
      listBarrels();
    }
    iterator = 1;

    return "Update Return Value Here";
  }

  // ***********************
  //   speakTo Method				// ??? Are the things to say designed in Person
  // ***********************  			// or in World
  public String speakTo(Person person) {
      //Enter code for speakTo here
    System.out.println("You have called speakTo");	// removeMe
    return "Update Return Value Here";
  }


  // ***********************
  //   attack Method				// ??? What is the range of damage that can be done
  // ***********************  
  public String attack(IHitable target) {
  
    System.out.println("You have called attack");	// removeMe
    return "Update Return Value Here";
  }


  // ***********************
  //   transferEquipment
  // ***********************  
  public void transferEquipment(IInventory source, IInventory destination) {
      //Enter code for transferEquipment here
    System.out.println("You have called transferEquipment");	// removeMe

  }



  // ***********************
  //   peakInside
  // ***********************  
  public String peakInside(IInventory inventory) {
    System.out.println("You have called peakInside");	// removeMe

    return "Update Return Value Here";


  }

  // ***********************
  //   getPersonInfo
  // ***********************  
  public String getPersonInfo(Person person) {
    System.out.println("You have called getPersonInfo");	// removeMe

    return "Update Return Value Here";


  }

  // ***********************
  //   getPlayerInfo
  // ***********************  
  public String getPlayerInfo() {
    System.out.println("You have called getPlayerInfo");	// removeMe

    return "Update Return Value Here";

  }

  // ***********************
  //   listPlayerInventory
  // ***********************  
  public String listPlayerInventory() {
    System.out.println("You have called listPlayerInventory");	// removeMe

    return "Update Return Value Here";

  }


  // ***********************
  //   equipEquipment
  // ***********************  
  public boolean equipEquipment(Equipment eqmt) {
    System.out.println("You have called equipEquipment");	// removeMe

    return true;

  }

  // ***********************
  //   useEquipment
  // ***********************  
  public boolean useEquipment(Equipment eqmt, Person target) {
    System.out.println("You have called useEquipment");		// removeMe

    return true;

  }




}
