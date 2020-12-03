import java.util.ArrayList;
import java.util.Random;

public class Animal extends IInventory{
	private String name;
	private ArrayList<String> dialog; 
	
	public Animal(String name){
		this.name = name;
		dialog = new ArrayList<>();
	}
	
	public String talk(){
		Random rand = new Random();
        int randomNum = rand.nextInt(dialog.size()-1);
        return dialog.get(randomNum);
	}
	
	public String getName(){
		return name;
	}
	
	public String getInfo(){
		return "Name: " + name + " Fear level: "; //+ currentFear + "/" + maxFear;
	}
	
	public void setThingsToSay(ArrayList<String> list){
		dialog = list;
	}
	
}