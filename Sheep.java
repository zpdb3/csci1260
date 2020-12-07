import java.util.ArrayList;
public class Sheep extends Animal{
	
	private int maxFear;
	private int currentFear;

	public Sheep() {
		super();
	}
	
	public Sheep(String name, int currentFear, int maxFear){
		super(name);
		this.currentFear = currentFear;
		this.maxFear = maxFear;
		ArrayList<String> sheepDialog = new ArrayList<>();
        sheepDialog.add("bahhhhhhhh");
        sheepDialog.add("The Sheep stares into your soul blankly");
		super.setThingsToSay(sheepDialog);
	}

	public boolean fearResponse(int fear) {
		currentFear += fear;

		if (currentFear > (maxFear/2)) {

			return false;
		}
		if (currentFear > maxFear) {
			return true;
		}
		return false;

	}
}