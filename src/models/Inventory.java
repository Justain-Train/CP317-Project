package models;
public class Inventory {
  private int productID;
  private String productName;
  private int quantity;
  private double price;
  private char status;
  private String supplierName;

  public Inventory(int productID, String productName, int quantity, double price, char status, String supplierName) {
    this.productID = productID;
    this.productName = productName;
    this.quantity = quantity;
    this.price = price;
    this.status = status;
    this.supplierName = supplierName;
  }

  public int getProductID() {
    return productID;
  }

  public String getProductName() {
    return productName;
  }

  public int getQuantity() {
    return quantity;
  }

  public double getPrice() {
    return price;
  }

  public char getStatus() {
    return status;
  }

  public String getSupplierName() {
    return supplierName;
  }

}
