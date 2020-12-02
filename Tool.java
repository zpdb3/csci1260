// ******
// Filename:   Tool
// Team:       Big Bois
// Team Members: Austen Boda, Duncan Hayes, Eric Caton,
//                               Jason Joyce, and Paul Brummitt
// ******
// The implementation of Tool will be lead by Duncan Hayes

public class Tool extends Equipment
{
  private int normalDamage;             //declares normalDamage as an int
  private int iceDamage;                //declares iceDamage as an int
  private int fireDamage;               //declares fireDamage as an int
  private OptimalTool ToolHand;  //declares OptimalTool

  public Tool() {
    super();
  }

  //sets the name, price, durability, damage, fire/ice damage, and the Tool handedness
  public Tool(String name, int dmg, int ice, int fire, OptimalTool wp, int price, double durability) {  
    super(name, price, durability);
    setNormalDamage(dmg);
    setFireDamage(fire);
    setIceDamage(ice);
    setOptimalTool(wp);
  }
  
  //overrides the getName method from equipment to add necessary prefixes/suffixes.
  public String getName() {            
    String nameHolder = super.getName();
    if (iceDamage > 0 && fireDamage > 0)
      nameHolder += " of Mighty Wrath";
    else if (fireDamage > 0)
      nameHolder += "Flaming " + nameHolder;
    else if (iceDamage > 0)
      nameHolder += "Frozen " + nameHolder;
    return nameHolder;
  }

  //returns normalDamage
  public int getNormalDamage() {      
    return normalDamage;
  }

  //returns FireDamage
  public int getFireDamage() {        
    return fireDamage;
  }

  //returns IceDamage
  public int getIceDamage() {         
    return iceDamage;
  }

  //returns the OptimalTool
  public OptimalTool getOptimalTool() {     
    return ToolHand;
  }

  //sets the NormalDamage for the Tool
  public void setNormalDamage(int dmg) {              
    normalDamage = dmg;
  }

  //sets the IceDamage for the Tool
  public void setIceDamage(int dmg) {                 
    iceDamage = dmg;
  }

  //sets the FireDamage for the Tool
  public void setFireDamage(int dmg) {                
    fireDamage = dmg;
  }

  //sets the Tool Handedness of the Tool
  public void setOptimalTool(OptimalTool wp) {  
    ToolHand = wp;
  }

  public String toString() {
    return ("{name: \"" + super.getName() + "\", price: " + super.getPrice() + ", durability: \"" +
            super.getDurability() + "\", normal: " + this.getNormalDamage() + ", ice: " + this.getIceDamage() +
            ", fire: " + this.getFireDamage() + ", OptimalTool: \"" + this.getOptimalTool() + "\"}" );
  }
  
//  public int attack(IHitable hitable){
//	int dmgHld;
//	dmgHld = hitable.takeDamage(getNormalDamage(), getFireDamage(), getIceDamage());
//	if(hitable.isHitableDestroyed())
//		System.out.println("Target is destroyed.");
//	else
//		System.out.println("Tis only a flesh wound!");
//	return dmgHld;
  //}
  

  public boolean use(Person person){
//	return person.equip(this);
	return true;				// remove this line	
  }





 

}
