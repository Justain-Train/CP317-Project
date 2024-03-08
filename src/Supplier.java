
public class Supplier {

  private int supplierID;
  private String supplierName;

    public Supplier (int supplierID, String supplierName) {
      this.supplierID = supplierID;
      this.supplierName = supplierName;
    }
    
    public int getsupplierID() {
      return supplierID;
    }
    
    public String getsupplierName() {
      return supplierName;
    }

}
