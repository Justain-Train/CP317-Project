package services;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import models.Inventory;
import models.Product;
import models.Supplier;

/*
 * This class generates the inventory list by iterating through the products list and adding the product to the inventory list
 
  * @param products - the list of products
  * @param suppliers - the list of suppliers
  * @return inventory - the list of inventory
 */
public class GenerateInventory {
  
  public static ArrayList<Inventory> generateInventory(ArrayList<Product> products, ArrayList<Supplier> suppliers) {
    ArrayList<Inventory> inventory = new ArrayList<Inventory>();
    //Iterate through the products list
    for (Product product : products) {
      String supplierName = FindSupplierID.compare(suppliers, product.getSupplierID());
      //Add the product to the inventory list
      inventory.add(new Inventory(product.getProductID(), product.getProductName(), product.getQuantity(), product.getPrice(),product.getStatus(),supplierName));
    }
    //Sort the inventory list by productID
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



