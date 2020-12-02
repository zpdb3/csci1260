import java.util.ArrayList;

public class Sheep extends Person {

    public Sheep() {
        this("Villager");
    }

    public Sheep(String name) {
        super(name);
        ArrayList<String> villagerWordSalad = new ArrayList<>();
        villagerWordSalad.add("I used to be an adventurer like you, then I took an arrow to the knee.");
        villagerWordSalad.add("Help!  Help!  I'm being repressed! Come see the violence inherent in the system!");
        villagerWordSalad.add("Oh, but you can't expect to wield supreme executive power just because some watery " +
                "tart threw a sword at you!");
//        super.setThingsToSay(villagerWordSalad);
    }
}
