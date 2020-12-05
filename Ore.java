public class Ore{
	
	private OptimalTool optimalTool;
	
	public Ore(String name, int price, double durability, OptimalTool optimalTool){
		super(name,price,durability);
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