package services;
import java.util.ArrayList;

import models.Supplier;

/* This class is used to find the supplier name for each product.
* The compare method returns the supplier name.
* @param suppliers - the arraylist of suppliers
* @param supplierID - the supplier id
* @return supplier.getSupplierName() - the supplier name
* @return "Supplier not found" - if the supplier is not found

*/ 
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

