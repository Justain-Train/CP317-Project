import java.util.ArrayList;
import java.io.IOException;
import models.Supplier;
import services.ReadSupplierFile;
import services.GenerateInventory;
import services.WriteInventoryFile;
import models.Inventory;
import services.ReadProductFile;
import models.Product;
class Main {

  public static void main(String[] args) {
    // Create an instance of ReadSupplierFile
    ReadSupplierFile readSupplierFile = new ReadSupplierFile();
    ReadProductFile readProductFile = new ReadProductFile();
    WriteInventoryFile WriteInventoryFile = new WriteInventoryFile();
    // Create an arraylist of suppliers and Products
    ArrayList<Supplier> suppliers = new ArrayList<>();
    ArrayList<Product> products = new ArrayList<>();
    // Try to read the supplier file and add the suppliers to the arraylist
    try {
      suppliers = readSupplierFile.readFile("Supplier.txt");
      products = readProductFile.readFile("Product.txt");
    } catch (IOException e) {
        e.printStackTrace();
    }
    // Create an arraylist of inventory
    ArrayList<Inventory> inventory = GenerateInventory.generateInventory(products, suppliers);

    // Try to write the inventory to a file
    try {
      WriteInventoryFile.writeFile("Inventory.txt",inventory);
    } catch (IOException e) {
      e.printStackTrace();
    }

    }
  }

