public class Product {
  private int productID;
  private String productName;
  private int quantity;
  private double price;
  private char status;
  private int supplierID;

    public Product (int productID, String productName, int quantity, double price, char status, int supplierID) {
      this.productID = productID;
      this.productName = productName;
      this.quantity = quantity;
      this.price = price;
      this.status = status;
      this.supplierID = supplierID;
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


    public int getSupplierID() {
      return supplierID;
    }

}
