import java.util.ArrayList;
public class Crow extends Animal{
	
	private int maxFear;
	private int currentFear;
	
	public Crow(String name, int currentFear, int maxFear){
		super(name);
		this.currentFear = currentFear;
		this.maxFear = maxFear;
		ArrayList<String> crowDialog = new ArrayList<>();
        crowDialog.add("CAW! CAW! CAW!");
        crowDialog.add("Crow are very intelligent, I even learned to speak");
        crowDialog.add("Please don't hurt me... Oops I mean CAW! CAW!");
		super.setThingsToSay(crowDialog);
	}
}