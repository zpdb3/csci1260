// ******
// Filename:   IHitable
// Team:       Big Bois
// Team Members: Austen Boda, Duncan Hayes, Eric Caton,
//                               Jason Joyce, and Paul Brummitt
// ******
// The implementation of IHitable will be lead by Jason Joyce



public interface IHitable
{
  


  // ***********************
  //   getMaxHealth()
  //   returns the current value of maxHealth
  // ***********************  
  
  int getMaxHealth();

  // ***********************
  //   getCurrentHealth()
  //   returns the current value of currentHealth
  // ***********************  

  int getCurrentHealth();


  // ***********************
  //   isHitableDestroyed()
  //   returns true if current value <= 0
  //   otherwise, returns false
  // ***********************  

  boolean isHitableDestroyed();


  // ***********************
  //   takeDamage()
  //   subtracts the provided damage from
  //   currentHealth and returns the result
  // ***********************  

  int takeDamage(int dmg, int fire, int ice);


  // ***********************
  //   heal()
  //   adds the passed value to currentHealth
  //   up to a maximum of maxHealth
  //   returns the amount of health that was added
  // ***********************  

  int heal(int amt);
   


}

