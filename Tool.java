// ******
// Filename:   Tool
// Team:       Big Bois
// Team Members: Austen Boda, Duncan Hayes, Eric Caton,
//                               Jason Joyce, and Paul Brummitt
// ******
// The implementation of Tool will be lead by Jason Joyce

public class Tool extends Equipment
{
  private int optimalUseTime;                   //declares optimalUseTime as an int
  private int subOptimalUseTime;                //declares subOptimalUseTime as an int
  private double correctUseDegredation;         //declares correctUseDegredation as an double
  private double incorrectUseDegredation;       //declares incorrectUseDegredation as an double
  private String optimalUse;                    //delcares optimalUse as a String


  public Tool() 
  {
    super();
  }

  //sets the name, price, durability, optimalUse, subOptimalUseTime, correctUseDegredation, incorrectUseDegredation, optimalUse of the tool
  public Tool(String name, int price, double durability, int optimalUseTime, int subOptimalUseTime,
              double correctUseDegredation, double incorrectUseDegredation, String optimalUse)
  {
    super(name, price, durability);
    setOptimalUseTime(optimalUseTime);
    setSubOptimalUseTime(subOptimalUseTime);
    setCorrectUseDegredation(correctUseDegredation);
    setIncorrectUseDegredation(incorrectUseDegredation);
    setOptimalUse(optimalUse);
  }

  //returns optimalUseTime
  public int getOptimalUseTime() 
  {
    return optimalUseTime;
  }

  //returns subOptimalUseTIme
  public int getSubOptimalUseTime() 
  {
    return subOptimalUseTime;
  }

  //returns CorrectUseDegredation
  public double getCorrectUseDegredation() 
  {
    return correctUseDegredation;
  }

  //returns IncorrectUseDegredation
  public double getIncorrectUseDegredation() 
  {
    return incorrectUseDegredation;
  }

  //returns OptimalUse
  public String getOptimalUse() 
  {
    return optimalUse; 
  }

  //sets the OptimalUseTime for the Tool
  public void setOptimalUseTime(int t) 
  {
    optimalUseTime = t;
  }

  //sets the SubOptimalUseTime for the Tool
  public void setSubOptimalUseTime(int t) 
  {
    subOptimalUseTime = t;
  }

  //sets the CorrectUseDegredation for the Tool 
  public void setCorrectUseDegredation(double d) 
  {
    correctUseDegredation = d; 
  }

  //sets the IncorrectUseDegredation for the Tool 
  public void setIncorrectUseDegredation(double d) 
  { 
    incorrectUseDegredation = d; 
  }

  //sets OptimalUse of the tool
  public void setOptimalUse(String s) 
  { 
    optimalUse = s; 
  }






 

}
