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
        neighborWordSalad.add("I used to be an adventurer like you, then I took an arrow to the knee.");
        neighborWordSalad.add("Help!  Help!  I'm being repressed! Come see the violence inherent in the system!");
        neighborWordSalad.add("Oh, but you can't expect to wield supreme executive power just because some watery " +
                "tart threw a sword at you!");
//        super.setDialog(neighborWordSalad);
    }

 // ***********************
  //   addEquipment)
  //   add
  // ***********************  
 
public  void addEquipment(Equipment equipment){

  }   



}
