import java.util.ArrayList;
public class Sheep extends Animal{
	
	private int maxFear;
	private int currentFear;
	
	public Sheep(String name, int currentFear, int maxFear){
		super(name);
		this.currentFear = currentFear;
		this.maxFear = maxFear;
		ArrayList<String> sheepDialog = new ArrayList<>();
        sheepDialog.add("bahhhhhhhh");
        sheepDialog.add("The Sheep stares into your soul blankly");
		super.setThingsToSay(sheepDialog);
	}
}