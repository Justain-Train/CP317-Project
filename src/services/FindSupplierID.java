package services;
import java.util.ArrayList;

import models.Supplier;


public class FindSupplierID {

  
  public static String compare(ArrayList<Supplier> suppliers,  int supplierID) {
    for (Supplier supplier : suppliers) {
      if (supplier.getSupplierID() == supplierID) {
        return supplier.getSupplierName();
      }
    }
    return "Supplier not found";
  }
}

