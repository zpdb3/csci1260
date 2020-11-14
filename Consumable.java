  // ***********************
  //   Class: Consumable
  //   
  // ***********************  

public abstract class Consumable extends Equipment implements IUsable		 
{
  String n;
  int price;
  double durability;

  // ***********************
  //   Constructor for Consumable
  //   
  // ***********************  

  public Consumable(String name, int price, double durability)  // Constructor
  {
            
  }

  // ***********************
  //   destroy() Method
  //   sets durability to 0
  // ***********************  


  public void destroy()
  {
    durability = 0;
  }

// ***********************
  //   use() Method
  //   overrides the IUsable
  // ***********************  


  public boolean use()
  {
    return true;
  }







}
