// ******
// Filename:   EquipmentManager
// Team:       Big Bois
// Team Members: Austen Boda, Duncan Hayes, Eric Caton,
//                               Jason Joyce, and Paul Brummitt
// ******
// The implementation of EquipmentManager will be lead by Duncan Hayes
// Scaffold by Paul Brummitt, written by Eric Caton and Duncan Hayes


import java.security.SecureRandom;
import java.util.*;

// A class that inventories equipment
public class EquipmentManager
{
  private ArrayList<Plackart> plackarts;
  private ArrayList<Helmet> helmets;
  private ArrayList<LongBow> longBows;
  private ArrayList<ThrowingAxe> throwingAxes;
  private ArrayList<Spear> spears;
  private ArrayList<Sword> swords;
 
  public EquipmentManager() {
        plackarts = new ArrayList<>();
	helmets = new ArrayList<>();
	longBows = new ArrayList<>();
	throwingAxes = new ArrayList<>();
	spears = new ArrayList<>();
	swords = new ArrayList<>();
  }

  public void clearAll() {
	plackarts.clear();
	helmets.clear();
	longBows.clear();
	throwingAxes.clear();
	spears.clear();
	swords.clear();
  }

  public int countEquipment() {
    return (countArmor() + countWeapon());
  }

  public int countArmor() {
    return (plackarts.size() + helmets.size());
  }

  public int countWeapon() {
    return (longBows.size() + throwingAxes.size() + spears.size() + swords.size());
  }

  public void removeEquipment(String list, int index) {

    switch (list) {
      case "plackart":
      case "PLACKART":

        removeEquipment(plackarts, index);
        break;

      case "helmet":
      case "HELMET":

        removeEquipment(helmets, index);
        break;

      case "spear":
      case "SPEAR":

        removeEquipment(spears, index);
        break;

      case "sword":
      case "SWORD":

        removeEquipment(swords, index);
        break;

      case "longBow":
      case "longbow":
      case "LONGBOW":

        removeEquipment(longBows, index);
        break;

      case "throwingAxe":
      case "throwingaxe":
      case "THROWINGAXE":

        removeEquipment(throwingAxes, index);
        break;

      default:

    }//end of rmv switch
  }

  public String getEquipmentDetails(String list, int index) {

    String infoHolder = "";

    switch (list) {
      case "plackart":
      case "PLACKART":
        infoHolder = this.getEquipmentDetails(plackarts, index);
        break;

      case "helmet":
      case "HELMET":
        infoHolder = this.getEquipmentDetails(helmets, index);
        break;

      case "spear":
      case "SPEAR":
        infoHolder = this.getEquipmentDetails(spears, index);
        break;

      case "sword":
      case "SWORD":
        infoHolder = this.getEquipmentDetails(swords, index);
        break;

      case "longBow":
      case "longbow":
      case "LONGBOW":
        infoHolder = this.getEquipmentDetails(longBows, index);
        break;

      case "throwingAxe":
      case "throwingaxe":
      case "THROWINGAXE":
        infoHolder = this.getEquipmentDetails(throwingAxes, index);
        break;

      default:

    }//end of info switch

    return infoHolder;
  }

  public String getEquipmentList() {
	int iterator = 1;
    String returnString = "Plackarts: \n";

    if (plackarts.isEmpty())
      returnString += "<<empty>>\n";
    else
      for (Plackart p : plackarts) {
        returnString += iterator + ". " + p.getName() + "\n";
        iterator++;
      }
      iterator = 1;

    returnString += "Helmets:  \n";
    if (helmets.isEmpty())
      returnString += "<<empty>>\n";
    else
      for(Helmet h : helmets) {
        returnString += iterator + ". " + h.getName() + "\n";
        iterator++;
      }
      iterator = 1;

    returnString += "Long Bows:  \n";
    if (longBows.isEmpty())
      returnString += "<<empty>>\n";
    else
      for(LongBow l : longBows) {
        returnString += iterator + ". " + l.getName() + "\n";
        iterator++;
      }
      iterator = 1;

    returnString += "Throwing Axes:  \n";
    if (throwingAxes.isEmpty())
      returnString += "<<empty>>\n";
    else
      for(ThrowingAxe t : throwingAxes) {
        returnString += iterator + ". " + t.getName() + "\n";
        iterator++;
      }
      iterator = 1;

    returnString += "Spears:  \n";
    if (spears.isEmpty())
      returnString += "<<empty>>\n";
    else
      for(Spear s : spears) {
        returnString += iterator + ". " + s.getName() + "\n";
        iterator++;
      }
      iterator = 1;

    returnString += "Swords:  \n";
    if (swords.isEmpty())
      returnString += "<<empty>>\n";
    else
      for(Sword s : swords) {
        returnString += iterator + ". " + s.getName() + "\n";
        iterator++;
      }

    return returnString;
  }

  public String getEquipmentListDetails() {
    int iterator = 1;
    String returnString = "Plackarts: \n";

    if (plackarts.isEmpty())
      returnString += "<<empty>>\n";
    else
      for (Plackart p : plackarts) {
        returnString += iterator + ". " + p.toString() + "\n";
        iterator++;
      }
    iterator = 1;

    returnString += "Helmets:  \n";
    if (helmets.isEmpty())
      returnString += "<<empty>>\n";
    else
      for(Helmet h : helmets) {
        returnString += iterator + ". " + h.toString() + "\n";
        iterator++;
      }
    iterator = 1;

    returnString += "Long Bows:  \n";
    if (longBows.isEmpty())
      returnString += "<<empty>>\n";
    else
      for(LongBow l : longBows) {
        returnString += iterator + ". " + l.toString() + "\n";
        iterator++;
      }
    iterator = 1;

    returnString += "Throwing Axes:  \n";
    if (throwingAxes.isEmpty())
      returnString += "<<empty>>\n";
    else
      for(ThrowingAxe t : throwingAxes) {
        returnString += iterator + ". " + t.toString() + "\n";
        iterator++;
      }
    iterator = 1;

    returnString += "Spears:  \n";
    if (spears.isEmpty())
      returnString += "<<empty>>\n";
    else
      for(Spear s : spears) {
        returnString += iterator + ". " + s.toString() + "\n";
        iterator++;
      }
    iterator = 1;

    returnString += "Swords:  \n";
    if (swords.isEmpty())
      returnString += "<<empty>>\n";
    else
      for(Sword s : swords) {
        returnString += iterator + ". " + s.toString() + "\n";
        iterator++;
      }

    return returnString;
  }

  public void addPlackart(Plackart p) {
    plackarts.add(p);
  }

  public void addHelmet(Helmet h) {
    helmets.add(h);
  }

  public void addLongBow(LongBow b) {
    longBows.add(b);
  }
  
  public void addThrowingAxe(ThrowingAxe a) {
    throwingAxes.add(a);
  }

  public void addSpear(Spear s) {
    spears.add(s);
  }

  public void addSword(Sword s) {
    swords.add(s);
  }

  private void removeEquipment(ArrayList list, int index) {
	list.remove(index);
  }

  private String getEquipmentDetails(ArrayList list, int index) {
    String infoHolder;
    infoHolder = list.get(index).toString();
    return infoHolder;
  }

}
