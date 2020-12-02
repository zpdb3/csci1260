  // ***********************
  //   Class: Consumable
  //   
  // ***********************  

public abstract class Consumable extends Equipment implements IUsable		 
{

  // ***********************
  //   Constructor for Consumable
  //   
  // ***********************  

  public Consumable(String n, int p, double d)  // Constructor
  {
    super(n, p, d);
         
  }

  // ***********************
  //   destroy() Method
  //   sets durability to 0
  // ***********************  


  public void destroy()
  {
    super.setDurability(0);
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
