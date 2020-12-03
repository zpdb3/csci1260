  // ***********************
  //   Class: GoldPieces
  //   
  // ***********************  

public abstract class GoldPieces extends Equipment implements IUsable		 
{

  // ***********************
  //   Constructor for GoldPieces
  //   
  // ***********************  

  public GoldPieces(String n, int p, double d)  // Constructor
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
