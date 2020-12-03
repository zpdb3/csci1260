

public class Gold extends Consumable 
{

  int initialValue=0;


  // ***********************
  //   Constructor for Gold
  //   
  // ***********************  
  public Gold()  // Constructor
    {
      super("Health Kit",50,1.0); 
    }

  // ***********************
  //   use() Method
  //   calls Peron's heal() and passes a 5 and returns true if > 0 is received
  // ***********************  

  public boolean use(Person person)
  {
     
//    return person.heal(5) > 0?true:false;	// ternary operator true does 1st condition
      return true; 				// remove this line
  }  

    

//    initialValue = iHitable.heal(5);

  
  






}