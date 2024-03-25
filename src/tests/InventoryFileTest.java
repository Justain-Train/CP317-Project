package tests;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import services.GenerateInventory;
import services.ReadProductFile;
import services.ReadSupplierFile;
import services.WriteInventoryFile;
import models.Inventory;
import models.Product;
import models.Supplier;

public class InventoryFileTest {

  private final String testProductFile = "CP317-Project/src/tests/files/testProductFile.txt";
  private final String testSupplierFile = "CP317-Project/src/tests/files/testSupplierFile.txt";

  @BeforeEach
  public void setUp() {
    try {
      FileWriter productWriter = new FileWriter(testProductFile);
      FileWriter supplierWriter = new FileWriter(testSupplierFile);
      productWriter.write("1, product1, description1, $1.00, 1, B, 1\n");
      supplierWriter.write("1, supplier1, address, contactPhone, contactEmail\n");
      productWriter.close(); // Close the inventoryWriter
      supplierWriter.close(); // Close the supplierWriter
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @AfterEach
  public void tearDown() {

    new File(testProductFile).delete();
    new File(testSupplierFile).delete();

  }

  @Test
  public void testGenerateInventoryFile() throws IOException {
    ReadProductFile readProductFile = new ReadProductFile();
    ReadSupplierFile readSupplierFile = new ReadSupplierFile();

    ArrayList<Product> products = readProductFile.readFile(testProductFile);
    ArrayList<Supplier> suppliers = readSupplierFile.readFile(testSupplierFile);
    ArrayList<Inventory> inventory = GenerateInventory.generateInventory(products,suppliers);

    assertEquals(1, inventory.size());
    assertEquals(1, inventory.get(0).getProductID());
    assertEquals("product1", inventory.get(0).getProductName());
    assertEquals(1, inventory.get(0).getQuantity());
    assertEquals(1.00, inventory.get(0).getPrice());
    assertEquals('B', inventory.get(0).getStatus());
    assertEquals("supplier1", inventory.get(0).getSupplierName());
  }

  @Test
  public void testWriteInventory() throws IOException {
    ArrayList<Inventory> inventory = new ArrayList<>();
    inventory.add(new Inventory(1, "Product1", 100, 10.00, 'A', "Supplier1"));

    WriteInventoryFile writeInventoryFile = new WriteInventoryFile();
    writeInventoryFile.writeFile("CP317-Project/src/tests/files/testInventory.txt", inventory);

    File file = new File("CP317-Project/src/tests/files/testInventory.txt");
    assertEquals(true, file.exists());


  
  }
}

