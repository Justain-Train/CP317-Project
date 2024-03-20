package services;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import interfaces.IWriteFIle;
import models.Inventory;


public class WriteInventoryFile implements IWriteFIle<Inventory> {

  @Override
  public void writeFile(ArrayList<Inventory> arrayList) throws IOException {
    try {
      FileWriter writer = new FileWriter("inventoryFile.txt");
      for (Inventory inventory : arrayList) {
        writer.write(inventory.getProductID() + "," + inventory.getProductName() + ", " + 
        inventory.getQuantity() + ", $" + inventory.getPrice() + ", " + inventory.getStatus() + "," + inventory.getSupplierName() + "\n");
      }
      writer.close();

    } catch (IOException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
  }
  
}
    


