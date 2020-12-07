public class Firework extends Consumable{
	private int fearLevel;
	private int amount;
	
//	public Firework(){
//		super();
//	}

	public Firework(){
		super("Firework", 20, 3);
		this.fearLevel = 5;
	}

	public Firework(int amount){
		super("Firework", 20, 3);
		fearLevel = 5;
	}

	public int getAmount() {
		return amount;
	}
	
	public int getFearLevel(){
		return fearLevel;
	}
	
	public void setFearLevel(int fearLevel){
		this.fearLevel = fearLevel;
	}
}