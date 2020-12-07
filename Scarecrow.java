public class Scarecrow extends Consumable{
	
	private int fearLevel;

	public Scarecrow(int fearLevel) {
		super("Scarecrow", 10, 10);
		this.fearLevel = fearLevel;
	}
	
	public Scarecrow(String name, int price, double durability, int fearLevel){
		super(name, price, durability);
		this.fearLevel = 5;
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