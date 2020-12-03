  // ***********************
  //   Class: Scarecrow
  //   
  // ***********************  

public abstract class Scarecrow extends Equipment implements IUsable		 
{

  // ***********************
  //   Constructor for Scarecrow
  //   
  // ***********************  

  public Scarecrow(String n, int p, double d)  // Constructor
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
