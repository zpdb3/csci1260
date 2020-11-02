import java.util.ArrayList;

public class Goblin extends Person{

    public Goblin() {
        super("Goblin");
        ArrayList<String> goblinWordSalad = new ArrayList<>();
        goblinWordSalad.add("Me know nothing about that.  Me simple goblin.");
        goblinWordSalad.add("Me just sitting here sharpening my sword... Who's buggin' me now?");
        goblinWordSalad.add("Ohhh!  Lunch delivered itself today!");
        super.setThingsToSay(goblinWordSalad);
    }

    public Goblin(String name) {
        super(name);
        ArrayList<String> goblinWordSalad = new ArrayList<>();
        goblinWordSalad.add("Me know nothing about that.  Me simple goblin.");
        goblinWordSalad.add("Me just sitting here sharpening my sword... Who's buggin' me now?");
        goblinWordSalad.add("Ohhh!  Lunch delivered itself today!");
        super.setThingsToSay(goblinWordSalad);
    }
}
