public class Scarecrow extends Consumable{
	
	private int fearLevel;
	
	public Scarecrow(String name, int price, double durability, int fearLevel){
		super(name, price, durability);
		this.fearLevel = fearLevel;
	}
	
	public Scarecrow(){
		super();
	}
	
	public int getFearLevel(){
		return fearLevel;
	}
	
	public void setFearLevel(int fearLevel){
		this.fearLevel = fearLevel;
	}
}