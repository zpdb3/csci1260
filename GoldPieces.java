public class GoldPieces extends Consumable{
	
	private int amount;

	
	public GoldPieces(String name, int price, double durability, int amount){
		super(name, price, durability);
		this.amount = amount;
	}
	
	public GoldPieces(){
		super();
		amount = 200;
	}
	
	public int getAmount(){
		return amount;
	}
	
	public void setAmount(int amount){
		this.amount = amount;
	}
	
	public boolean buyItem(int price){
		if(amount>price){
			amount = amount - price;
			
		}
		if(amount<price){
			return false;
		}
		return true; 
	}
	
	public boolean sellItem(int price){
		
		amount = amount + price;
		return true;
	}           
}