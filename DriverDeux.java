/*
 *  Programmed By:  Eric M. Caton
 *  This is a simple loop driven driver for the RPG scaffold 2
 *  Version 2.0 last update November 10, 2020
 */

import java.util.Scanner;

class DriverDeux {
    public static void main(String[] args){

        boolean exitCondition = true;   //the exit condition for our loop will iterate at least once
        Scanner commandScan = new Scanner(System.in);   //the scanner for user input
        EquipmentManager equipMan = new EquipmentManager(); //an instance of the EquipmentManager class
        World currentStateOfThings = new World();   //an instance of the World class

        System.out.println("Welcome to the game (name tbd and lore as well)... ");    //where the initial plot goes
        pause(); clearScreen(); //pause and clear the screen when they move on

        while(exitCondition){   //beginning of the while loop controlled by our exit condition variable

            /*
             *  our instructions for the user and main user interface
             */
            System.out.println(
                    "Command List:\n\n" +
                    "   make commands:\n" +
                    "       \"make barrel\"-        Creates a barrel object.\n" +
                    "       \"make chest\"-         Creates a chest object.\n" +
                    "       \"make human\"-         Creates a villager object.\n" +
                    "       \"make goblin\"-        Creates a goblin object.\n\n" +
                    "   player commands:\n" +
                    "       \"my stats\"-           Displays the player stats.\n" +
                    "       \"my inventory\"-       Displays the player inventory.\n\n" +
                    "   observation commands:\n" +
                    "       \"list interactables\"- Lists all objects that can be interacted with.\n" +
                    "       \"list containers\"-    Lists all interactable inanimate objects.\n" +
                    "       \"list people\"-        Lists all interactable creatures.\n" +
                    "       \"look at\"-            Inspect an object.\n\n" +
                    "   interaction commands:\n" +
                    "       \"use\"-                Use an item.\n" +
                    "       \"transfer\"-           Transfer all items.\n" +
                    "       \"attack\"-             Make an attack.\n" +
                    "       \"speak\"-              Talk to something.\n" +
                    "   menu commands:\n" +
                    "       \"exit\"-               Exit the game.\n\n"
            );

            /*
             *  this is where the string will be parsed to determine the users command
             */
            String[] userCommandArray = getUserInput(2);
            String primaryCmnd = "", secondaryCmnd = "", errorType = " ";    //variables to concisely show whats up in the code

            primaryCmnd = userCommandArray[0].toLowerCase();  //get the primary command from the command array

            /*
             *  else if to check to see if primary command is a valid entry and to see if secondary command needs to be
             *  initialized.
             */
            if(primaryCmnd.equalsIgnoreCase("make")
               || primaryCmnd.equalsIgnoreCase("my")
               || primaryCmnd.equalsIgnoreCase("list"))
                {secondaryCmnd = userCommandArray[1].toLowerCase();}
            else if(primaryCmnd.equalsIgnoreCase("look")
                    || primaryCmnd.equalsIgnoreCase("use")
                    || primaryCmnd.equalsIgnoreCase("transfer")
                    || primaryCmnd.equalsIgnoreCase("attack")
                    || primaryCmnd.equalsIgnoreCase("speak"))
                {/*intentionally left blank*/}
            else
                {errorType = "Invalid command entry, check spelling and try again.";}

            /*
             *  The switch that will process the users command while doing minor error checking
             */
            switch(primaryCmnd){

                case "make":
                case "my":
                case "list":
                    /*
                     *  If make, my or list command is given go through secondary command switch
                     */
                    String returnInfo = "";
                    switch(secondaryCmnd){
                        case "barrel":
                            currentStateOfThings.makeBarrel();
                            returnInfo = secondaryCmnd + " created successfully.";
                            break;

                        case "chest":
                            currentStateOfThings.makeChest();
                            returnInfo = secondaryCmnd + " created successfully.";
                            break;

                        case "human":
                            currentStateOfThings.makeHuman();
                            returnInfo = secondaryCmnd + " created successfully.";
                            break;

                        case "goblin":
                            currentStateOfThings.makeGoblin();
                            returnInfo = secondaryCmnd + " created successfully.";
                            break;

                        case "stats":
                            returnInfo = currentStateOfThings.getPlayerInfo();
                            break;

                        case "inventory":
                            returnInfo = currentStateOfThings.listPlayerInventory();
                            break;

                        case "interactables":
                            returnInfo = currentStateOfThings.listTargets();
                            break;

                        case "containers":
                            returnInfo = currentStateOfThings.listChests() + "\n" + currentStateOfThings.listBarrels();
                            break;

                        case "people":
                            returnInfo = currentStateOfThings.listPeople();
                            break;

                        default:
                            errorType = "Invalid command entry, check spelling and try again.";
                    }// end of secondary command switch
                    System.out.println(errorType.equalsIgnoreCase(" ") ? returnInfo : errorType);
                    break;

                case "look":
                case "use":
                case "transfer":
                case "attack":
                case "speak":
                    /*
                     * List out what the player can interact with, give clear instructions on how to pick what they want
                     * to interact with then take their input validate it then print it out.
                     */
                    System.out.println(currentStateOfThings.listTargets());
                    System.out.println(
                            "\nChoose the object/person you would like to interact with by typing in the category\n" +
                            "of the object/person then the number it is in the list then if applicable the specific\n" +
                            "item name.\n" +
                            "       Examples:\n" +
                                        "\"chest 1\"-               Interact with the chest.\n" +
                                        "\"chest 1 healthkit\"-    Interact with the health kit inside the chest.\n\n" +
                            "Item/person to interact with:  "
                    );

                    /*
                     *  this is where the string will be parsed to determine the users command
                     */
                    userCommandArray = getUserInput(3);
                    String objOrPer = " ", secObjOrPer = " ", specificItem = " ", outPutString = "";

                    objOrPer = userCommandArray[0].toLowerCase();
                    int specificChoice = checkNumExist(userCommandArray, 1), secSpecificChoice;
                    specificItem = userCommandArray[2];

                    switch(objOrPer){
                        case "barrel":
                            if(primaryCmnd.equalsIgnoreCase("look"))
                                outPutString = "Looks like a well made barrel, could probably be used to age whisky " +
                                               "pretty good...";
                            else if(primaryCmnd.equalsIgnoreCase("use")) {
                                outPutString = "You quickly open and close the barrel a few times.";                    //<---still needs work
                            }
                            else if(primaryCmnd.equalsIgnoreCase("transfer")){
                                System.out.println(currentStateOfThings.listTargets());
                                System.out.println(
                                        "Where would you like to transfer the contents to?\n" +
                                        "   Options:\n" +
                                        "       \"me\"-         How selfish, take all the loot.\n\n" +
                                        "       A target from the list:\n" +
                                        "           Example:    \"villager 1\"\n" +
                                        "   Choice:  "
                                );
                                userCommandArray = getUserInput(2);
                                secObjOrPer = userCommandArray[0].toLowerCase();
                                secSpecificChoice = checkNumExist(userCommandArray, 1);

                                switch(secObjOrPer){
                                    case "barrel":
                                        currentStateOfThings.transferEquipment((IInventory) currentStateOfThings.barrels.get(specificChoice),
                                                (IInventory) currentStateOfThings.barrels.get(secSpecificChoice));
                                        outPutString = "All items transferred from one barrel to the other.";
                                        break;
                                    case "chest":
                                        currentStateOfThings.transferEquipment((IInventory) currentStateOfThings.barrels.get(specificChoice),
                                                (IInventory) currentStateOfThings.chests.get(secSpecificChoice));
                                        outPutString = "All items transferred from the barrel to the chest.";
                                        break;
                                    case "villager":
                                        currentStateOfThings.transferEquipment((IInventory) currentStateOfThings.barrels.get(specificChoice),
                                                (IInventory) currentStateOfThings.people.get(secSpecificChoice));
                                        outPutString = "The villager protested a bit meekly as you added the barrel full\n" +
                                                "of items to his pockets, what are you even doing with your life?";
                                        break;
                                    case "goblin":
                                        currentStateOfThings.transferEquipment((IInventory) currentStateOfThings.barrels.get(specificChoice),
                                                (IInventory) currentStateOfThings.people.get(secSpecificChoice));
                                        outPutString = "The goblin does not look amused as you dump a barrel worth of\n" +
                                                       "items onto him";
                                    case "me":
                                        currentStateOfThings.transferEquipment((IInventory) currentStateOfThings.barrels.get(specificChoice),
                                                (IInventory) currentStateOfThings.player);
                                        outPutString = "Ohhh yeah all the loot baby, nothing left in that barrel now!";
                                        break;
                                    default:
                                        outPutString = "Unable to combine the two inventories.";
                                }//end of barrel transfer switch
                            }//end of transfer else if
                            else if(primaryCmnd.equalsIgnoreCase("attack")){
                                outPutString = "You attack the barrel doing " + currentStateOfThings.attack((IHitable) currentStateOfThings.barrels.get(specificChoice)) +
                                               " damage.";
                            }
                            else if(primaryCmnd.equalsIgnoreCase("speak")){
                                outPutString = "You tell the barrel your hopes, dreams and deepest fears.  Although it\n" +
                                               "does not give a reply you feel like you made a friend today.";
                            }
                            break;

                        case "chest":
                            if(primaryCmnd.equalsIgnoreCase("look"))
                                outPutString = "Looks like a well made chest, could be a mimic though...";
                            else if(primaryCmnd.equalsIgnoreCase("use")) {
                                outPutString = "You cautiously fiddle with the latch, no teeth yet...";                 //<---still needs work
                            }
                            else if(primaryCmnd.equalsIgnoreCase("transfer")){
                                System.out.println(currentStateOfThings.listTargets());
                                System.out.println(
                                        "Where would you like to transfer the contents to?\n" +
                                                "   Options:\n" +
                                                "       \"me\"-         How selfish, take all the loot.\n\n" +
                                                "       A target from the list:\n" +
                                                "           Example:    \"villager 1\"\n" +
                                                "   Choice:  "
                                );
                                userCommandArray = getUserInput(2);
                                secObjOrPer = userCommandArray[0].toLowerCase();
                                secSpecificChoice = checkNumExist(userCommandArray, 1);

                                switch(secObjOrPer){
                                    case "barrel":
                                        currentStateOfThings.transferEquipment((IInventory) currentStateOfThings.chests.get(specificChoice),
                                                (IInventory) currentStateOfThings.barrls.get(secSpecificChoice));
                                        outPutString = "All items transferred from the chest to the barrel.";
                                        break;
                                    case "chest":
                                        currentStateOfThings.transferEquipment((IInventory) currentStateOfThings.chests.get(specificChoice),
                                                (IInventory) currentStateOfThings.chests.get(secSpecificChoice));
                                        outPutString = "All items transferred from one chest to the other.";
                                        break;
                                    case "villager":
                                        currentStateOfThings.transferEquipment((IInventory) currentStateOfThings.chests.get(specificChoice),
                                                (IInventory) currentStateOfThings.people.get(secSpecificChoice));
                                        outPutString = "The villager protested a bit meekly as you added the chest full\n" +
                                                "of items to his pockets, what are you even doing with your life?";
                                        break;
                                    case "goblin":
                                        currentStateOfThings.transferEquipment((IInventory) currentStateOfThings.chests.get(specificChoice),
                                                currentStateOfThings.people.get(secSpecificChoice));
                                        outPutString = "The goblin does not look amused as you dump a chest worth of items\n" +
                                                       "onto him.";
                                        break;
                                    case "me":
                                        currentStateOfThings.transferEquipment((IInventory) currentStateOfThings.chests.get(specificChoice),
                                                (IInventory) currentStateOfThings.player);
                                        outPutString = "Ohhh yeah all the loot baby, nothing left in that chest now!\n" +
                                                       "Also wasn't a Mimic, score!";
                                        break;
                                    default:
                                        outPutString = "Unable to combine the two inventories.";
                                }//end of barrel transfer switch
                            }//end of transfer else if
                            else if(primaryCmnd.equalsIgnoreCase("attack")){
                                outPutString = "You attack the chest doing " + currentStateOfThings.attack((IHitable) currentStateOfThings.chests.get(specificChoice)) +
                                        " damage.";
                            }
                            else if(primaryCmnd.equalsIgnoreCase("speak")){
                                outPutString = "You tell the chest your hopes, dreams and deepest fears.  Did it just\n" +
                                               "laugh a little?  Stupid thing.";
                            }
                            break;

                        case "villager":
                            if(primaryCmnd.equalsIgnoreCase("look"))
                                outPutString = currentStateOfThings.getPersonInfo((Person) currentStateOfThings.people.get(specificChoice));
                            else if(primaryCmnd.equalsIgnoreCase("use")) {
                                outPutString = "You realize the villager has a truck and you need help moving...\n" +
                                               "You ask him to help you move while calling him friend.";                //<---still needs work
                            }
                            else if(primaryCmnd.equalsIgnoreCase("transfer")){
                                System.out.println(currentStateOfThings.listTargets());
                                System.out.println(
                                        "Where would you like to transfer the contents to?\n" +
                                                "   Options:\n" +
                                                "       \"me\"-         How selfish, take all the loot.\n\n" +
                                                "       A target from the list:\n" +
                                                "           Example:    \"villager 1\"\n" +
                                                "   Choice:  "
                                );
                                userCommandArray = getUserInput(2);
                                secObjOrPer = userCommandArray[0].toLowerCase();
                                secSpecificChoice = checkNumExist(userCommandArray, 1);

                                switch(secObjOrPer){
                                    case "barrel":
                                        currentStateOfThings.transferEquipment((IInventory) currentStateOfThings.people.get(specificChoice),
                                                (IInventory) currentStateOfThings.barrls.get(secSpecificChoice));
                                        outPutString = "All items transferred from the villager to the barrel.";
                                        break;
                                    case "chest":
                                        currentStateOfThings.transferEquipment((IInventory) currentStateOfThings.people.get(specificChoice),
                                                (IInventory) currentStateOfThings.chests.get(secSpecificChoice));
                                        outPutString = "All items transferred from the villager to the chest.";
                                        break;
                                    case "villager":
                                        currentStateOfThings.transferEquipment((IInventory) currentStateOfThings.people.get(specificChoice),
                                                (IInventory) currentStateOfThings.people.get(secSpecificChoice));
                                        outPutString = "The villager protested a bit meekly as you added the other villagers \n" +
                                                "belongings to his pockets, strangely no one made a big scene of it.";
                                        break;
                                    case "goblin":  //currently not supported
                                        currentStateOfThings.transferEquipment((IInventory) currentStateOfThings.people.get(specificChoice),
                                                (IInventory) currentStateOfThings.people.get(secSpecificChoice));
                                        outPutString = "The goblin thanks you as you empty the villagers items into his\n" +
                                                       "dirty loincloth.";
                                        break;
                                    case "me":
                                        currentStateOfThings.transferEquipment((IInventory) currentStateOfThings.people.get(specificChoice),
                                                (IInventory) currentStateOfThings.player);
                                        outPutString = "You strip the villager of everything he has while he just stands \n" +
                                                       "there.  Talk about NPC behavior!";
                                        break;
                                    default:
                                        outPutString = "Unable to combine the two inventories.";
                                }//end of barrel transfer switch
                            }//end of transfer else if
                            else if(primaryCmnd.equalsIgnoreCase("attack")){
                                outPutString = "You attack the villager doing " + currentStateOfThings.attack((IHitable) currentStateOfThings.people.get(specificChoice)) +
                                        " damage.";
                            }
                            else if(primaryCmnd.equalsIgnoreCase("speak")){
                                outPutString = "You tell the person your hopes, dreams and deepest fears.\n" +
                                               "They reply:  " + currentStateOfThings.speakTo((Person) currentStateOfThings.people.get(specificChoice));
                            }
                            break;

                        case "goblin":
                            if(primaryCmnd.equalsIgnoreCase("look"))
                                outPutString = currentStateOfThings.getPersonInfo((Person) currentStateOfThings.people.get(specificChoice));
                            else if(primaryCmnd.equalsIgnoreCase("use")) {
                                outPutString = "You would rather not associate with the goblin, even if you do need help moving.";                    //<---still needs work
                            }
                            else if(primaryCmnd.equalsIgnoreCase("transfer")){
                                System.out.println(currentStateOfThings.listTargets());
                                System.out.println(
                                        "Where would you like to transfer the contents to?\n" +
                                                "   Options:\n" +
                                                "       \"me\"-         How selfish, take all the loot.\n\n" +
                                                "       A target from the list:\n" +
                                                "           Example:    \"villager 1\"\n" +
                                                "   Choice:  "
                                );
                                userCommandArray = getUserInput(2);
                                secObjOrPer = userCommandArray[0].toLowerCase();
                                secSpecificChoice = checkNumExist(userCommandArray, 1);

                                switch(secObjOrPer){
                                    case "barrel":
                                        currentStateOfThings.transferEquipment((IInventory) currentStateOfThings.people.get(specificChoice),
                                                (IInventory) currentStateOfThings.barrls.get(secSpecificChoice));
                                        outPutString = "All items transferred from the goblin to the barrel.";
                                        break;
                                    case "chest":
                                        currentStateOfThings.transferEquipment((IInventory) currentStateOfThings.people.get(specificChoice),
                                                (IInventory) currentStateOfThings.chests.get(secSpecificChoice));
                                        outPutString = "All items transferred from the goblin to the chest.";
                                        break;
                                    case "villager":
                                        currentStateOfThings.transferEquipment((IInventory) currentStateOfThings.people.get(specificChoice),
                                                (IInventory) currentStateOfThings.people.get(secSpecificChoice));
                                        outPutString = "The villager protested a bit meekly as you added the  goblins \n" +
                                                "belongings to his pockets, the goblin does not look happy.";
                                        break;
                                    case "goblin":  //currently not supported
                                        currentStateOfThings.transferEquipment((IInventory) currentStateOfThings.people.get(specificChoice),
                                                (IInventory) currentStateOfThings.people.get(secSpecificChoice));
                                        outPutString = "The goblin didn't notice you add his inventory to the other goblin,\n" +
                                                       "sweet prank bro!";
                                        break;
                                    case "me":
                                        currentStateOfThings.transferEquipment((IInventory) currentStateOfThings.people.get(specificChoice),
                                                (IInventory) currentStateOfThings.player);
                                        outPutString = "You strip the goblin of everything he has while he just stands \n" +
                                                       "there.  You know deep down that if a combat function existed this\n" +
                                                       "goblin would be going ham on you.";
                                        break;
                                    default:
                                        outPutString = "Unable to combine the two inventories.";
                                }//end of barrel transfer switch
                            }//end of transfer else if
                            else if(primaryCmnd.equalsIgnoreCase("attack")){
                                outPutString = "You attack the goblin doing " + currentStateOfThings.attack((IHitable) currentStateOfThings.people.get(specificChoice)) +
                                        " damage.";
                            }
                            else if(primaryCmnd.equalsIgnoreCase("speak")){
                                outPutString = "You tell the goblin your hopes, dreams and deepest fears.\n" +
                                        "They reply:  " + currentStateOfThings.speakTo((Person) currentStateOfThings.people.get(specificChoice));
                            }
                            break;

                        default:
                    }//end of look/use/transfer/attack/speak switch

                    System.out.println(outPutString);

                    break;

                case "exit":
                    /*
                     * Set the exitCondition to false thank the user for using the game driver then dip on out
                     */
                    exitCondition = false;
                    System.out.println("Thank you for using the game driver.");
                    pause();
                    break;

                default:

                    errorType = "Invalid command entry, check spelling and try again.";

            }//end of primary command switch
        }//end of while loop
    }//end of Main




    /*
     * Reusable methods for main.
     */
    public static void clearScreen()  //method to clear the screen not working **ON MAC**
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

    public static String[] getUserInput(int num)   //method to get input from the user and turn it into a string array
    {
        Scanner commandScan = new Scanner(System.in);
        String holder = commandScan.nextLine();
        clearScreen();
        String[] userCommandArray = holder.split(" ", num);
        return userCommandArray;
    }

    public static int checkNumExist(String[] check, int sub){
        int returnValue;
        try{
            returnValue = Integer.parseInt(check[sub]);
        }
        catch(Exception e){
            returnValue = -1;
        }
        return returnValue;
    }

}//end of DriverDeux
