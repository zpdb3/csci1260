// ******
// Filename:   Equipment
// Team:       Big Bois
// Team Members: Austen Boda, Duncan Hayes, Eric Caton,
//                               Jason Joyce, and Paul Brummitt
// ******
// The implementation of Equipment will be written by Jason Joyce

// A class that establishes equipment functionality

public class Equipment 
{

  private String name;          //declares name as a string
  private int price;            //declares price as an int
  private double durability;    //declares durability as a double

  public Equipment() 
  {

  }

  public Equipment(String name, int price, double durability)   //sets the name, price, and durability of each object of equipment
  {
      setName(name);
      setPrice(price);
      setDurability(durability);
  }

  public String getName() //returns name
  {
      return name;
  }

  public int getPrice() //returns price
  {
      return price;
  }

  public double getDurability() //returns durability
  {
      return durability;
  }

  public void setName(String n) //sets name equal to n
  {
      name = n;
  }

  public void setPrice(int p) //sets price equal to p
  {
      price = p;
  }

  public void setDurability(double d) //sets the conditions for what values durability can fall within
  {
      durability = ((d >= 0) && (d <= 1)) ? d : durability;
  }

  public int getSalePrice() //sets the price of a object of equipment based on durability condition
  {
      return (int) (price * (0.30 + durability));
  }

  public void adjustDurability(double d) //changes durability of a object of equipment to a set value
  {

      if (d > -1 && d < 1) {
          if (durability + d > 1)
              durability = 1;
          else if (durability - d < 1)
              durability = 0;
          else
              durability += d;
      }


  }

  
  public boolean use(Person person)
  {
    return true;
  }





}
