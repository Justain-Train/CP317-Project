package services;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import interfaces.IWriteFile;
import models.Inventory;



public class WriteInventoryFile implements IWriteFile<Inventory> {

  /*
   * This method writes the inventory to a file
   * @param fileName the name of the file to write to
   * @param inventory the list of inventory to write to the file
   * @throws IOException if there is an error writing to the file
   * @return void
   */
  @Override
  public void writeFile(String fileName, ArrayList<Inventory> inventory) throws IOException {
    try {
      FileWriter writer = new FileWriter(fileName);
      //Iterate through the inventory list
      for (Inventory inventorys : inventory) {
        //Write the inventory to the file
        writer.write(inventorys.getProductID() + "," + inventorys.getProductName() + ", " + 
        inventorys.getQuantity() + ", $" + inventorys.getPrice() + ", " + inventorys.getStatus() + ", " + inventorys.getSupplierName() + "\n");
      }
      writer.close();

    } catch (IOException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
  }
  
}
    


