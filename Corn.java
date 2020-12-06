public class Corn extends Seed{
	
	public Corn(){
		super();
	}
	
	public Corn(String name, int price,double durability, OptimalTool optimalTool, boolean crowAble, boolean sheepAble)
	{
		super(name,price,durability,optimalTool,crowAble,sheepAble);
	}
	
	public boolean grow(){
		return true;
	}
}