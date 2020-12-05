public class Firework extends Consumable{
	private int fearLevel;
	
	public Firework(){
		super(name, price, durability);
		this.fearLevel = fearLevel;
	}
	
	public Firework(){
		super();
	}
	
	public int getFearLevel(){
		return fearLevel;
	}
	
	public void setFearLevel(int fearLevel){
		this.fearLevel = fearLevel
	}
}