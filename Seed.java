public class Seed extends Consumable 
{

  private OptimalTool optimalTool;
  private boolean crowAble;
  private boolean sheepAble;


  // ***********************
  //   Constructor for Seed
  //   
  // ***********************  
  public Seed(String name, int price, double durability, OptimalTool optimalTool, boolean crowAble, boolean sheepAble)  // Constructor
    {
      this.name = name;
	  this.durability = durability;
	  this.optimalTool = optimalTool;
	  this.crowAble = crowAble;
	  this.sheepAble = sheepAble;
    }

  // ***********************
  //   use() Method
  //   calls Peron's heal() and passes a 5 and returns true if > 0 is received
  // ***********************  

  public OptimalTool getOptimalTool(){
	  return optimalTool;
  }
  
  public boolean getCrowAble(){
	  return crowAble;
  }
  
  public void setOptimalTool(OptimalTool optimalTool){
	  this.optimalTool = optimalTool;
  }
  
  public void setSheepAble(boolean b){
	  b = sheepAble;
  }
  
  public void setCrowAble(boolean b){
	  b = crowAble;
  }
  
  public boolean grow(){
	  
  }

  
  






}
