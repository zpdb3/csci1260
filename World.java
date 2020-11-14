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
  public ArrayList<Chest>  chests;	//Declare an array of chests
  public ArrayList<Barrel> barrels;	//Declare an array of barrels
  public ArrayList<Person> people;	//Declare an array of people
  public Person player;			//The avatar for the player of the game

  public World()
  {

    chests  = new ArrayList<Chest>();
    barrels = new ArrayList<Barrel>();
    people  = new ArrayList<Person>();

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
    Chest newChest = new Chest();
    System.out.println("You have called makeChest");	// removeMe

//    Chest[0].addEquipment((Equipment) EquipmentManager.makeRandomWeapon());	// +++ adds a random weapon
//    EquipmentManager.makeRandomArmor();		// +++ adds a random armor
//    EquipmentManager.makeRandomConsumable();	// +++ adds a random consumable

    chests.add(newChest);		//adds a chest to the array of chests
//    chests(0).addEquipment(EquipmentManager.makeRandomWeapon());
      System.out.println("Index: " + 0 + " Name: " +
                          chests.get(0));				   
  }  

// ***********************
  //   makeBarrel Method
  // ***********************  
  public void makeBarrel() {
    System.out.println("You have called makeBarrel");	// removeMe    
    barrels.add(new Barrel());		//adds a barrel to the array of barrels
    EquipmentManager.makeRandomWeapon();	// +++ adds a random weapon
    EquipmentManager.makeRandomArmor();		// +++ adds a random armor
    EquipmentManager.makeRandomConsumable();	// +++ adds a random consumable

  }

  // ***********************
  //   makeHuman Method
  // ***********************  
  public void makeHuman() {
    System.out.println("You have called makeHuman");	// removeMe
  people.add(new Human()); 		//adds a human to the array of people

  }

  // ***********************
  //   makeGoblin Method
  // ***********************  
  public void makeGoblin() {
    System.out.println("You have called makeGoblin");	// removeMe

    people.add(new Goblin());		//adds a goblin to the array of people
  }

  // ***********************
  //   listChests Method			
  // ***********************  
  public String listChests() {
    System.out.println("You have called listChests.");
    int iterator = 0;
    String returnString = "Chests: \n";
    
    Chest chest1 = new Chest();
    
    chests.add(chest1);

    System.out.println("The ArrayList has " +
                        chests.size() + 
                       " objects stored in it.");
     

    for (Chest name : chests)
      System.out.println(name);

    System.out.println(chests);


    for (int index = 0; index < chests.size(); index++)
    {
      System.out.println("Index: " + index + " Name: " +
                          chests.get(index));
    }    
    return returnString;

  }


  // ***********************
  //   listChests Method-old / not used			
  // ***********************  
/*
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
*/
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
  //   speakTo Method				
  // ***********************  			
  public String speakTo(Person person) {
    
	Random counter = new Random();
	int storage = 0;
	String returnValue="";
	storage = counter.nextInt(3);
	if(storage == 0)
	{						// ??? may need if to determine villager vs goblin
		return "I've got something to say";     // ??? update this
	}
	if(storage == 1)
	{
		return "I've got something to say too";     // ??? update this
	}
	if(storage == 2)
	{
		return "I've got something to say three";     // ??? update this
	}

	return returnValue;    
  }

  // ***********************
  //   attack Method				// ??? What is the range of damage that can be done
  // ***********************  
  public int attack(IHitable target) {
  // Look at the weapon the person has
  // i.e. player.weapon.attack(target) and it will return the int value of damage done to target 
  // pass to Weapon.attack the target
  // take damage value returned value returned and then call the take damage method
     int returnValue = 0;			// ??? remove this line and fix the line below
//    int returnValue = player.Weapon.attack(target);
    return returnValue;
  }

  // ***********************
  //   transferEquipment
  // ***********************  
  public void transferEquipment(IInventory source, IInventory destination) {

   

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
//    this.use(target);						// ??? Fix this line
    return true;

  }



}