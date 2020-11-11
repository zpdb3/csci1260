// ******
// Filename:   Driver
// Team:       Big Bois
// Team Members: Austen Boda, Duncan Hayes, Eric Caton,
//                               Jason Joyce, and Paul Brummitt
// ******
/*
*   Programmed By:  Eric M. Caton
*   This is a simple loop driven driver for the RPG scaffold.
*   Version 1.0 uploaded October 20, 2020
*/

import java.util.Scanner;

class WorldDriver
{
    public static void main(String[] args)
    {
        boolean exitCondition = true;  //the exit condition for our loop will iterate at least once
        Scanner commandScan = new Scanner(System.in);  //the scanner for user input

        EquipmentManager equipMan = new EquipmentManager();  //an instance of the EquipmentManager class
        World newWorld = new World();  //an instance of the World class
//        Person person1 = new Person();
//        IHitable target1 = new IHitable();
//	IInventory entity1 = new IInventory();
//	IInventory entity2 = new IInventory();
	Equipment eqmt = new Equipment();
        commandScan.nextLine();

        while (exitCondition)  //beginning of the while loop controlled by our exit condition variable
        {
            //our instructions for the user and main user interface
            System.out.print(
                    "Command List:\n" +
                    "   \"clear\"-             Clears all fields\n" +
                    "   \"count equipment\"-   Counts all equipment and returns an integer result\n" +
                    "   \"count armor\"-       Counts all armor and returns an integer result\n" +
                    "   \"count weapons\"-     Counts all weapons and returns an integer result\n" +
                    "   \"list basic\"-        Lists all equipment in the form of a comma separated list\n" +
                    "   \"list detailed\"-     Lists all equipment and their stats in a formatted table\n" +
                    "   \"add plackart\"-      Adds a default plackart\n" +
                    "   \"add helmet\"-        Adds a default helmet\n" +
                    "   \"add spear\"-         Adds a default spear\n" +
                    "   \"add sword\"-         Adds a default sword\n" +
                    "   \"add longbow\"-       Adds a default longbow\n" +
                    "   \"add throwingAxe\"-   Adds a default throwingAxe\n" +
                    "   \"complexAdd\"-        Used in place of add to add a user defined equipment, read documentation\n" +
                    "                          to find arguments\n" +
                    "   \"quit\"-              Exits the program\n\n" +
                    "Remove Commands:\n" +
                    "   type \"rmv\" followed by a space then the name of the item to be removed followed by \n" +
                    "   another space then the index number to be removed\n" +
                    "   Example- rmv longBow 3\n\n" +
                    "Info Commands:\n" +
                    "   type \"info\" followed by a space then the name of the item that you want info on followed \n" +
                    "   by another space then the index number of the item you are requesting information for\n\n" +
                    "Enter your command:  ");

            String userCommand = commandScan.nextLine();  //receive user input

            /*
            *  this is where the string will be parsed to determine the users commands
            */
            String[] userCommandArray = userCommand.split(" ", 11);  //split the users command string into a string array
            String commandType, countType = "", listType = "", equipType = "", errorType;   //variables to concisely show programmers
                                                                                            //whats up in the code.

            errorType = " ";  //our error type string variable, will be compared at the end of the loop to throw error or not

            commandType = userCommandArray[0];  //get the user first word command, should be one of the words in the elif
                                                //elif statement should be self explanatory.

            if (commandType.equalsIgnoreCase("count"))
            {
                countType = userCommandArray[1];
            }
            else if (commandType.equalsIgnoreCase("list"))
            {
                listType = userCommandArray[1];
            }
            else if (commandType.equalsIgnoreCase("add"))
            {
                equipType = userCommandArray[1];                 
            }
            else if (commandType.equalsIgnoreCase("complexAdd"))
            {
                equipType = userCommandArray[1];
            }
            else if (commandType.equalsIgnoreCase("clear"))
            {
                //intentionally left blank
            }
            else if (commandType.equalsIgnoreCase("rmv"))
            {
                //intentionally left blank
            }
            else if (commandType.equalsIgnoreCase("info"))
            {
                //intentionally left blank
            }
            else if (commandType.equalsIgnoreCase("quit"))
            {
                //intentionally left blank
            }
            else
            {
                errorType = "Invalid command entry, check spelling and try again.";
            }

            switch (commandType)  //main switch to process commands
            {
                /*
                *   if clear command is given use EquipmentManagers built in method to clear all of the equipment.
                */

//	test World.java

                case "clear":
                case "CLEAR":
//		      Person Paul = new Person();	// How will I create a person to use in the speakTo method
		      newWorld.makeChest();
			pause();
		      newWorld.makeBarrel();
			pause();
		      newWorld.makeHuman();
			pause();
		      newWorld.makeGoblin();
			pause();
		      newWorld.listChests();
			String result=newWorld.listChests();
			System.out.println("Back in the driver.");
			System.out.println(newWorld.listChests());
			pause();
//                    newWorld.listBarrels();
//			result=newWorld.listBarrels();
			System.out.println(newWorld.listBarrels());
//			System.out.println(result + ".");
			pause();
		      newWorld.listPeople();
			pause();
		      newWorld.listTargets();
			pause();
//		      newWorld.speakTo(person1);	// To use speakTo requires passing a Person variable
			pause();
//		      newWorld.attack(target1);		// To attack, must pass an IHITABLE
			pause();
//		      newWorld.transferEquipment(entity1,entity2);
			pause();
//		      newWorld.peakInside(entity1);
			pause();
//		      newWorld.getPersonInfo(person1);	// To use speakTo requires passing a Person variable
			pause();
		      newWorld.getPlayerInfo();	// To use speakTo requires passing a Person variable
			pause();
		      newWorld.listPlayerInventory();	// To use speakTo requires passing a Person variable
			pause();
		      newWorld.equipEquipment(eqmt);
			pause();
//		      newWorld.useEquipment(eqmt,person1);
			pause();

//                    equipMan.clearAll();
//                    System.out.print("All equipment removed.");
                    pause();
                    break;

                /*
                *   if count command is given check to see what is going to be counted and store it in the intHolder,
                *   then print the information to the console.  if countType is wrong store the error.
                */
                case "count":
                case "COUNT":

                    int intHolder = 0;

                    switch (countType)
                    {
                        case "equipment":
                        case "EQUIPMENT":

                            intHolder = equipMan.countEquipment();
                            break;

                        case "armor":
                        case "ARMOR":

                            intHolder = equipMan.countArmor();
                            break;

                        case "weapons":
                        case "WEAPONS":

                            intHolder = equipMan.countWeapon();
                            break;

                        default:

                            errorType = "Error in type of item to count, check spelling and try again.";
                    }//end of count switch

                    System.out.print(countType + " count:  " + intHolder + ".");
                    pause();
                    break;

                /*
                *   if list command is given check to see if it is the basic or detailed list then use EquipmentManager
                *   to access the needed method and print the required list to the console.  if listType is wrong store
                *   the error.
                */
                case "list":
                case "LIST":

                    switch (listType)
                    {
                        case "basic":
                        case "BASIC":

                            System.out.print(equipMan.getEquipmentList() + ".");
                            pause();
                            break;

                        case "detailed":
                        case "DETAILED":

                            System.out.print(equipMan.getEquipmentListDetails());
                            pause();
                            break;

                        default:

                            errorType = "Error in type of list to display, check spelling and try again.";
                    }//end of list switch

                    break;

                /*
                *   if add command is given find equipment to add create a new instance of that equipment then add it
                *   to EquipmentManager.  if equipType is wrong store the error.
                */
                case "add":
                case "ADD":

                    switch (equipType)
                    {
                        case "plackart":
                        case "PLACKART":

                            Plackart p = new Plackart();
                            equipMan.addPlackart(p);
                            errorType = "Plackart added.";
                            break;

                        case "helmet":
                        case "HELMET":

                            Helmet h = new Helmet();
                            equipMan.addHelmet(h);
                            errorType = "Helmet added.";
                            break;

                        case "spear":
                        case "SPEAR":

                            Spear sp = new Spear();
                            equipMan.addSpear(sp);
                            errorType = "Spear added.";
                            break;

                        case "sword":
                        case "SWORD":

                            Sword sw = new Sword();
                            equipMan.addSword(sw);
                            errorType = "Sword added.";
                            break;

                        case "longBow":
                        case "longbow":
                        case "LONGBOW":

                            LongBow lb = new LongBow();
                            equipMan.addLongBow(lb);
                            errorType = "Long Bow added.";
                            break;

                        case "throwingAxe":
                        case "throwingaxe":
                        case "THROWINGAXE":

                            ThrowingAxe ta = new ThrowingAxe();
                            equipMan.addThrowingAxe(ta);
                            break;

                        default:

                            errorType = "Error in type of equipment, check spelling and try again.";
                    }//end of add switch

                    break;

                /*
                *   Uses the parsed string array userCommandArray to initialize holder variables and pass those values
                *   to instances of the appropriate equipment types that the user would like to create then stores
                *   those equipments in the appropriate array list in EquipmentManager (equipMan)
                */
                case "complexAdd":
                case "complexadd":
                case "COMPLEXADD":

                    switch (equipType)
                    {
                        case "plackart":
                        case "PLACKART":

                            int price = Integer.valueOf(userCommandArray[2]);
                            double durability = (Double.valueOf(userCommandArray[3]) / 100.0);
                            int armorBonus = Integer.valueOf(userCommandArray[4]);
                            boolean ice = userCommandArray[5].equalsIgnoreCase("true") ? true : false;
                            boolean fire = userCommandArray[6].equalsIgnoreCase("true") ? true : false;
                            Plackart plk = new Plackart(price, durability, armorBonus, ice, fire);
                            equipMan.addPlackart(plk);
                            break;

                        case "helmet":
                        case "HELMET":

                            price = Integer.valueOf(userCommandArray[2]);
                            durability = (Double.valueOf(userCommandArray[3]) / 100.0);
                            armorBonus = Integer.valueOf(userCommandArray[4]);
                            ice = userCommandArray[5].equalsIgnoreCase("true") ? true : false;
                            fire = userCommandArray[6].equalsIgnoreCase("true") ? true : false;
                            Helmet hlm = new Helmet(price, durability, armorBonus, ice, fire);
                            equipMan.addHelmet(hlm);
                            break;

                        case "spear":
                        case "SPEAR":

                            price = Integer.valueOf(userCommandArray[2]);
                            durability = (Double.valueOf(userCommandArray[3]) / 100.0);
                            int normalDamage = Integer.valueOf(userCommandArray[4]);
                            int iceDamage = Integer.valueOf(userCommandArray[5]);
                            int fireDamage = Integer.valueOf(userCommandArray[6]);
                            WeaponHandedness weaponHand;
                            if (userCommandArray[7].equalsIgnoreCase("onehanded"))
                                weaponHand = WeaponHandedness.OneHanded;
                            else if (userCommandArray[7].equalsIgnoreCase("twohanded"))
                                weaponHand = WeaponHandedness.TwoHanded;
                            else
                                weaponHand = WeaponHandedness.Versatile;
                            Spear spr = new Spear(normalDamage, iceDamage, fireDamage, weaponHand, price, durability);
                            equipMan.addSpear(spr);
                            break;

                        case "sword":
                        case "SWORD":

                            price = Integer.valueOf(userCommandArray[2]);
                            durability = (Double.valueOf(userCommandArray[3]) / 100.0);
                            normalDamage = Integer.valueOf(userCommandArray[4]);
                            iceDamage = Integer.valueOf(userCommandArray[5]);
                            fireDamage = Integer.valueOf(userCommandArray[6]);
                            if (userCommandArray[7].equalsIgnoreCase("onehanded"))
                                weaponHand = WeaponHandedness.OneHanded;
                            else if (userCommandArray[7].equalsIgnoreCase("twohanded"))
                                weaponHand = WeaponHandedness.TwoHanded;
                            else
                                weaponHand = WeaponHandedness.Versatile;
                            Sword srd = new Sword(normalDamage, iceDamage, fireDamage, weaponHand, price, durability);
                            equipMan.addSword(srd);
                            break;

                        case "longBow":
                        case "longbow":
                        case "LONGBOW":

                            price = Integer.valueOf(userCommandArray[2]);
                            durability = (Double.valueOf(userCommandArray[3]) / 100.0);
                            normalDamage = Integer.valueOf(userCommandArray[4]);
                            iceDamage = Integer.valueOf(userCommandArray[5]);
                            fireDamage = Integer.valueOf(userCommandArray[6]);
                            if (userCommandArray[7].equalsIgnoreCase("onehanded"))
                                weaponHand = WeaponHandedness.OneHanded;
                            else if (userCommandArray[7].equalsIgnoreCase("twohanded"))
                                weaponHand = WeaponHandedness.TwoHanded;
                            else
                                weaponHand = WeaponHandedness.Versatile;
                            double range = Double.valueOf(userCommandArray[8]);
                            int currentAmmo = Integer.valueOf(userCommandArray[9]);
                            int maxAmmo = Integer.valueOf(userCommandArray[10]);
                            LongBow lnb = new LongBow(normalDamage, iceDamage, fireDamage, weaponHand, price, durability, range, maxAmmo);
                            equipMan.addLongBow(lnb);
                            break;

                        case "throwingAxe":
                        case "throwingaxe":
                        case "THROWINGAXE":

                            price = Integer.valueOf(userCommandArray[2]);
                            durability = (Double.valueOf(userCommandArray[3]) / 100.0);
                            normalDamage = Integer.valueOf(userCommandArray[4]);
                            iceDamage = Integer.valueOf(userCommandArray[5]);
                            fireDamage = Integer.valueOf(userCommandArray[6]);
                            if (userCommandArray[7].equalsIgnoreCase("onehanded"))
                                weaponHand = WeaponHandedness.OneHanded;
                            else if (userCommandArray[7].equalsIgnoreCase("twohanded"))
                                weaponHand = WeaponHandedness.TwoHanded;
                            else
                                weaponHand = WeaponHandedness.Versatile;
                            range = Double.valueOf(userCommandArray[8]);
                            currentAmmo = Integer.valueOf(userCommandArray[9]);
                            maxAmmo = Integer.valueOf(userCommandArray[10]);
                            ThrowingAxe tra = new ThrowingAxe(normalDamage, iceDamage, fireDamage, weaponHand, price, durability, range, maxAmmo);
                            equipMan.addThrowingAxe(tra);
                            break;

                        default:

                            errorType = "Error in type of equipment, check spelling and try again.";
                    }//end of complexAdd switch

                    break;

                /*
                *   if rmv command is given find the type of equipment to remove and array location then remove it.
                */
                case "rmv":
                case "RMV":

                    int rmvIndex = Integer.parseInt(userCommandArray[2]);  //get the index from the array and convert to int.

                    equipMan.removeEquipment(userCommandArray[1], rmvIndex);
                    System.out.println("Item Removed.");
                    pause();
                    break;

                /*
                *   if info command is given find the type of equipment to get information for then print the
                *   information.
                */
                case "info":
                case "INFO":

                    int printIndex = Integer.parseInt(userCommandArray[2]);  //get the index from the array and convert to int.

                    System.out.println(equipMan.getEquipmentDetails(equipType, printIndex));
                    pause();
                    break;

                /*
                *   if quit command is given set exitCondition to false, thank the user for using the driver, once the
                *   user hits enter loop will be exited and program will end.
                */
                case "quit":
                case "QUIT":

                    exitCondition = false;
                    System.out.println("Thank you for using the game driver.");
                    pause();
                    break;

                default:

                    errorType = "Invalid command entry, check spelling and try again.";
            }//end of outer switch

            if (!errorType.equalsIgnoreCase(" "))  //if errorType has a stored error display it then redo the loop.
            {
                System.out.println(errorType);
                pause();
            }
            clearScreen();  //clear the screen at the end of the loop.
        }//end of while loop
    }//end of Main

    public static void clearScreen()  //method to clear the screen not working
    {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void pause()  //method to pause the program and run again after the user presses enter
    {
        Scanner commandScan = new Scanner(System.in);
        System.out.print("\nPress enter to continue.");
        commandScan.nextLine();
    }


    



}//end of Driver