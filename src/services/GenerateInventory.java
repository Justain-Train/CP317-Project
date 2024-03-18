package services;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import models.Inventory;
import models.Product;
import models.Supplier;

/* Uses the FindSupplierId class to find the supplier name 
for each product and adds the product to the inventory list.

* The generateInventory method returns an arraylist of inventory.
* @param products - the arraylist of products
* @param suppliers - the arraylist of suppliers
* @return inventory - the arraylist of inventory

*/ 
public class GenerateInventory {
  
  public static ArrayList<Inventory> generateInventory(ArrayList<Product> products, ArrayList<Supplier> suppliers) {
    ArrayList<Inventory> inventory = new ArrayList<Inventory>();
    for (Product product : products) {
      String supplierName = FindSupplierID.compare(suppliers, product.getProductID());
      inventory.add(new Inventory(product.getProductID(), product.getProductName(), product.getQuantity(), product.getPrice(),product.getStatus(),supplierName));
    }

    Collections.sort(inventory, new Comparator<Inventory>() {
      @Override
      public int compare(Inventory i1, Inventory i2) {
        return Integer.compare(i1.getProductID(), i2.getProductID());
      }
    });

    return inventory;
  }
}



