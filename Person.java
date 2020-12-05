import java.util.ArrayList;
import java.util.Random;

public abstract class Person implements IInventory{

    private String name;
    private ArrayList<String> dialog;
    private Pickaxe pickaxe;
    private Hoe hoe; 
    private Axe axe;
    private Shovel shovel;
    private EquipmentManager inventory;

    public Person(String name) {
        this.name = name;
	this.dialog = new ArrayList<>();
	this.pickaxe = new Pickaxe();
	this.hoe = new Hoe();
	this.axe = new Axe();
	this.inventory = new EquipmentManager();

    }
// ********************************
// ** talk() Method ***************
// ********************************

    public String talk() {

        Random rand = new Random();
        int rando = rand.nextInt(3);
        return dialog.get(rando);
    }

// ********************************
// ** setThingsToSay() Method *****
// ********************************

    public void setThingsToSay(ArrayList<String> list) {
        this.thingsToSay = list;
    }



}
