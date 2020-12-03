import java.util.ArrayList;
import java.util.Random;

public abstract class Animal extends IInventory{
	private String name;
	private ArrayList<String> dialog;
	private EquipmentManager inventory;
	
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
		inventory.countTools();
	}
	
	public int countConsumables(){
		inventory.countConsumables();
	}
	
	public int countEquipment(){
		return countTools() + countConsumables();
	}
	
	public String getEquipmentList(){
		inventory.listEquipment();
	}
	
	public String getEquipmentInfo(int index){
		inventory.getEquipmentDetails();
	}
	
	public Equipment getEquipment(int index){
		inventory.getEquipment();
	}
	
	public void dropAllEquipment(int index){
		inventory.clearAllEquipment();
	}
	
	public void dropEquipment(int index){
		inventory.removeEquipment(index);
	}
	
	public void addEquipment(Equipment equipment){
		inventory.addEquipment();
	}
}