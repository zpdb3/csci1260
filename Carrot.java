public class Carrot extends Seed{
	
	public Carrot(){
		super();
	}
	
	public Carrot(String name, int price,double durability, OptimalTool optimalTool, boolean crowAble, boolean sheepAble)
	{
		super(name,price,durability,optimalTool,crowAble,sheepAble);
	}
	
	public boolean grow(){
		return true;
	}
}