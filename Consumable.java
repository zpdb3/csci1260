// ******
// Filename:   Consumbable
// Team:       Big Bois
// Team Members: Austen Boda, Duncan Hayes, Eric Caton,
//                               Jason Joyce, and Paul Brummitt
// ******
// 




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

  public Consumable() {
	super();
} 

  public Consumable(String name, int price, double durability)  // Constructor
  {
    super(name, price, durability);
         
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
