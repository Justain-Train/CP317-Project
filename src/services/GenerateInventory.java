package services;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import models.Inventory;
import models.Product;
import models.Supplier;


public class GenerateInventory {
  
  public static ArrayList<Inventory> generateInventory(ArrayList<Product> products, ArrayList<Supplier> suppliers) {
    ArrayList<Inventory> inventory = new ArrayList<Inventory>();
   
    for (Product product : products) {
      String supplierName = FindSupplierID.compare(suppliers, product.getSupplierID());
      inventory.add(new Inventory(product.getProductID(), product.getProductName(), product.getQuantity(), product.getPrice(),product.getStatus(),supplierName));
    }

    Collections.sort(inventory, new Comparator<Inventory>() {

      //Override from Comparator API
      @Override
      public int compare(Inventory i1, Inventory i2) {
        return Integer.compare(i1.getProductID(), i2.getProductID());
      }
    });

    return inventory;
  }
}



