// ******
// Filename:   Trader
// Team:       Big Bois
// Team Members: Austen Boda, Duncan Hayes, Eric Caton,
//                               Jason Joyce, and Paul Brummitt
// ******
// Written by Paul Brummitt


import java.util.ArrayList;

public class Trader extends Person{

    public Trader() {
        this("Trader");
    }

    public Trader(String name) {
        super(name);
        ArrayList<String> TraderWordSalad = new ArrayList<>();
        TraderWordSalad.add("A carrot a day keeps the doctor away!");
        TraderWordSalad.add("What's it going to take to put you in a new tractor today?");
        TraderWordSalad.add("While you were playing pattycake, Uncle Rico just made some moolah!");
        super.setThingsToSay(TraderWordSalad);
    }
}
