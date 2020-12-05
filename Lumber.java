public class Lumber extends Consumable{
	private OptimalTool optimalTool;
	
	public Lumber(String name, int price, double durability, OptimalTool optimalTool){
		super(name, price, durability, optimalTool);
	}
	
	public Lumber(){
		super();
	}
	
	public void setOptimalTool(OptimalTool optimalTool){
		this.optimalTool = optimalTool;
	}
	
	public OptimalTool getOptimalTool(){
		return optimalTool;
	}
}
