// ******
// Filename:   IInventory
// Team:       Big Bois
// Team Members: Austen Boda, Duncan Hayes, Eric Caton,
//                               Jason Joyce, and Paul Brummitt
// ******
// The implementation of IInventory will be lead by Austen Boda and Paul Brummitt

public interface IInventory		//interface declaration vs class 
{
  // ***********************
  //   pickup() Method
  //   picks up the equipment passed in the variable
  // ***********************  
  
public void pickUp(Equipment equipment);


  // ***********************
  //   countWeapon()
  //   counts the weapons
  // ***********************  
  
public  int countTools();

  // ***********************
  //   countTools()
  //   counts Tools on hand
  // ***********************  
  
public  int countConsumables();

  // ***********************
  //   getEquipmentList()
  //   provides a list of equipment
  // ***********************  
  
public   String getEquipmentList();

  // ***********************
  //   getEquipmentInfo()
  //   gets info about equipment status
  // ***********************  
  
  public   String getEquipmentInfo(int Index);

  // ***********************
  //   getEquipment()
  //   picks up the equipment passed in the variable
  // ***********************  
  
  public   Equipment getEquipment(int Index);

  // ***********************
  //   dropEquipment()
  //   drops the item at the index referenced in the passed variable
  // ***********************  

  public   void dropEquipment(int Index);
  
 // ***********************
  //   addEquipment)
  //   add
  // ***********************  
 
  public  void addEquipment(Equipment equipment);   



  // ***********************
  //   dropAllEquipment)
  //   drops all items
  // ***********************  
  
  public   void dropAllEquipment();


}
