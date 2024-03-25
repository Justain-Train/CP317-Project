package services;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import interfaces.IWriteFile;
import models.Inventory;


public class WriteInventoryFile implements IWriteFile<Inventory> {

  @Override
  public void writeFile(String fileName, ArrayList<Inventory> inventory) throws IOException {
    try {
      FileWriter writer = new FileWriter(fileName);
      for (Inventory inventorys : inventory) {
        writer.write(inventorys.getProductID() + "," + inventorys.getProductName() + ", " + 
        inventorys.getQuantity() + ", $" + inventorys.getPrice() + ", " + inventorys.getStatus() + "," + inventorys.getSupplierName() + "\n");
      }
      writer.close();

    } catch (IOException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
  }
  
}
    


