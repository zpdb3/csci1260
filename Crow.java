import java.util.ArrayList;

public class Crow extends Person{

    public Crow() {
        this("Crow");
    }

    public Crow(String name) {
        super(name);
        ArrayList<String> CrowWordSalad = new ArrayList<>();
        CrowWordSalad.add("Me know nothing about that.  Me simple Crow.");
        CrowWordSalad.add("Me just sitting here sharpening my sword... Who's buggin' me now?");
        CrowWordSalad.add("Ohhh!  Lunch delivered itself today!");
        super.setThingsToSay(CrowWordSalad);
    }
}
