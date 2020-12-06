import java.util.ArrayList;
import java.util.Random;

public abstract class Animal implements IInventory{
	private String name;
	private ArrayList<String> dialog;
	private EquipmentManager inventory;

	public Animal(){
	}
	
	public Animal(String name){
		this.name = name;
		dialog = new ArrayList<>();
		inventory = new EquipmentManager();
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
	
	//Implement IInventory
	
	public void pickUp(Equipment equipment){
		inventory.addEquipment(equipment);
	}
	
	public int countTools(){
		return inventory.countTools();
	}
	
	public int countConsumables(){
		return inventory.countConsumables();
	}
	
	public int countEquipment(){
		return countTools() + countConsumables();
	}
	
	public String getEquipmentList(){
		return inventory.listEquipment();
	}
	
	public String getEquipmentInfo(int index){
		return inventory.getEquipmentDetails(index);
	}
	
	public Equipment getEquipment(int index){
		return inventory.getEquipment(index);
	}
	
	public void dropAllEquipment(){
		inventory.clearAllEquipment();
	}
	
	public void dropEquipment(int index){
		inventory.removeEquipment(index);
	}
	
	public void addEquipment(Equipment equipment){
		inventory.addEquipment(equipment);
	}
}