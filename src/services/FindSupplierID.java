package services;
import java.util.ArrayList;

import models.Supplier;

/* This class is used to find the supplier name for each product.*/  // Path: src/FindSupplierID.java
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

