public class Seed extends Consumable 
{

  private OptimalTool optimalTool;
  private boolean crowAble;
  private boolean sheepAble;


  // ***********************
  //   Constructor for Seed
  //   
  // *********************** 

  public Seed() {
	super();
}
 
  public Seed(String name, int price, double durability, OptimalTool optimalTool, boolean crowAble, boolean sheepAble)  // Constructor
    {
	  super(name,price,durability);
	  this.optimalTool = optimalTool;
	  this.crowAble = crowAble;
	  this.sheepAble = sheepAble;
    }


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
    return true;	  
  }

  






}
