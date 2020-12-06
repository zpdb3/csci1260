public class Firework extends Consumable{
	private int fearLevel;
	
//	public Firework(){
//		super();
//	}

	public Firework(){
		super("Firework", 20, 3);
		this.fearLevel = fearLevel;
	}
	
	
	
	public int getFearLevel(){
		return fearLevel;
	}
	
	public void setFearLevel(int fearLevel){
		this.fearLevel = fearLevel;
	}
}