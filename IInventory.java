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
  
  void pickUp(Equipment equipment);

  // ***********************
  //   transferAllEquipmentFrom()
  //   method to transfer equipment
  // ***********************  
  
  //void transferAllEquipmentFrom(IInventory other);

  // ***********************
  //   countArmor()
  //   enumerate armor on hand
  // ***********************  
  
  //int countArmor();

  // ***********************
  //   countWeapon()
  //   counts the weapons
  // ***********************  
  
  int countTools();

  // ***********************
  //   countTools()
  //   counts Tools on hand
  // ***********************  
  
  int countConsumables();

  // ***********************
  //   countEquipment()
  //   counts equipment on hand
  // ***********************  
  
  int countEquipment();

  // ***********************
  //   getEquipmentList()
  //   provides a list of equipment
  // ***********************  
  
  String getEquipmentList();

  // ***********************
  //   getEquipmentInfo()
  //   gets info about equipment status
  // ***********************  
  
  String getEquipmentInfo(int Index);

  // ***********************
  //   getEquipment()
  //   picks up the equipment passed in the variable
  // ***********************  
  
  Equipment getEquipment(int Index);

  // ***********************
  //   dropEquipment()
  //   drops the item at the index referenced in the passed variable
  // ***********************  
  
 // ***********************
  //   addEquipment)
  //   add
  // ***********************  
 
  void addEquipment(Equipment equipment);   

  void dropEquipment(int Index);

  // ***********************
  //   dropAllEquipment)
  //   drops all items
  // ***********************  
  
  void dropAllEquipment();


}
