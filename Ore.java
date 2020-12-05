public class Ore extends Consumable {
	
	private OptimalTool optimalTool;
	
	public Ore(String name, int price, double durability, OptimalTool optimalTool){
		super(name,price,durability);
		this.optimalTool = optimalTool;
	}
	
	public Ore(){
		super();
	}
	
	public OptimalTool getOptimalTool(){
		return optimalTool;
	}
	
	public void setOptimalTool(OptimalTool optimalTool){
		this.optimalTool = optimalTool;
	}
}