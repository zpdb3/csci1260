// ******
// Filename:   Neighbor
// Team:       Big Bois
// Team Members: Austen Boda, Duncan Hayes, Eric Caton,
//                               Jason Joyce, and Paul Brummitt
// ******
// Written by Paul Brummitt


import java.util.ArrayList;

public class Neighbor extends Person {

    int maxFear;
    int currentFear;

    public Neighbor() {
        this("Neighbor", 100, 20);
    }

    public Neighbor(String name, int maxFear, int currentFear) {
        super(name);
        ArrayList<String> neighborWordSalad = new ArrayList<>();
        neighborWordSalad.add("Been farming long?");
        neighborWordSalad.add("I guess you'll have to like it or lump it!");
        neighborWordSalad.add("You might need a doctor every once in a while, but every day ... " +
                "three times a day, you need a farmer!");
       super.setThingsToSay(neighborWordSalad);
    }

 // ***********************
  //   addEquipment)
  //   add
  // ***********************  
 
public  void addEquipment(Equipment equipment){

  }   



}
