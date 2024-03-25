package services;
import java.util.ArrayList;

import models.Supplier;


public class FindSupplierID {

  
  public static String compare(ArrayList<Supplier> suppliers,  int supplierID) {
    //Iterate through the suppliers list to find the supplier with the given supplierID
    for (Supplier supplier : suppliers) {
      //If the supplierID matches the given supplierID, return the supplier name
      if (supplier.getSupplierID() == supplierID) {
        return supplier.getSupplierName();
      }
    }
    return "Supplier not found";
  }
}

