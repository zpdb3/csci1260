

public class HealthKit extends Consumable 
{

  int initialValue=0;


  // ***********************
  //   Constructor for HealthKit
  //   
  // ***********************  
  public HealthKit()  // Constructor
    {
      super("Health Kit",50,1.0); 
    }

  // ***********************
  //   use() Method
  //   calls Peron's heal() and passes a 5 and returns true if > 0 is received
  // ***********************  

  public boolean use(Person person)
  {
     
    return person.heal(5) > 0?true:false;	// ternary operator true does 1st condition
  }  

    

//    initialValue = iHitable.heal(5);

  
  






}