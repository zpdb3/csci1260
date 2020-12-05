public class GoldPieces extends Consumable{
	
	private int Amount
	
	public GoldPieces(String name, int price, double durability, int amount){
		super(name, price, durability);
		this.amount = amount;
	}
	
	public GoldPieces(){
		super();
	}
	
	public int getAmount(){
		return Amount;
	}
	
	public void setAmount(int amount){
		amount = Amount;
	}
	
	public boolean buyItem(Equipment item, int price){
		pickUp(item);
		Amount - price = Amount;
		return true; 
	}
	
	public boolean sellItem(Equipment item, int price){
		pickUp(item);
		Amount + price = Amount;
		return true;
	}
}