
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
    
    public int getsupplierID() {
      return supplierID;
    }
    
    public String getsupplierName() {
      return supplierName;
    }

    public String getaddress() {
      return address;
    }

    public String getphone() {
      return phone;
    }

    public String getemail() {
      return email;
    }

}
