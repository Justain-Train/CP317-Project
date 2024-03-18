package models;

public class Supplier {

  private int supplierID;
  private String supplierName;
  private String address;
  private String phone;
  private String email;

    public Supplier (int supplierID, String supplierName, String address, String phone, String email) {
      this.supplierID = supplierID;
      this.supplierName = supplierName;
      this.address = address;
      this.phone = phone;
      this.email = email;
    }
    
    public int getSupplierID() {
      return supplierID;
    }
    
    public String getSupplierName() {
      return supplierName;
    }

    public String getAddress() {
      return address;
    }

    public String getPhone() {
      return phone;
    }

    public String getEmail() {
      return email;
    }

}
