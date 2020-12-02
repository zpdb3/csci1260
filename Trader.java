import java.util.ArrayList;

public class Trader extends Person{

    public Trader() {
        this("Trader");
    }

    public Trader(String name) {
        super(name);
        ArrayList<String> TraderWordSalad = new ArrayList<>();
        TraderWordSalad.add("Me know nothing about that.  Me simple Trader.");
        TraderWordSalad.add("Me just sitting here sharpening my sword... Who's buggin' me now?");
        TraderWordSalad.add("Ohhh!  Lunch delivered itself today!");
        super.setThingsToSay(TraderWordSalad);
    }
}
