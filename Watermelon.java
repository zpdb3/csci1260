public class Watermelon extends Seed{
	
	public Watermelon(){
		super();
	}
	
	public Watermelon(String name, int price,double durability, OptimalTool optimalTool, boolean crowAble, boolean sheepAble)
	{
		super(name,price,durability,optimalTool,crowAble,sheepAble);
	}
	
	public boolean grow(){
		return true;
	}
}