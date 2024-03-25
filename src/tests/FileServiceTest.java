package tests;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import services.ReadSupplierFile;
import services.ReadProductFile;

public class FileServiceTest {
  
  private final String testProductFile = "CP317-Project/src/tests/files/testProductFile.txt" ;
  private final String testSupplierFile = "CP317-Project/src/tests/files/testSupplierFile.txt";

  @BeforeEach
  public void setUp() {
    try {
      FileWriter productWriter = new FileWriter(testProductFile);
      FileWriter supplierWriter = new FileWriter(testSupplierFile);
      productWriter.write("1, product1, description1, $1.00, 1, B, 1\n");
      supplierWriter.write("1, supplier1, address, contactPhone, contactEmail\n");
      productWriter.close(); // Close the productWriter
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
  public void testReadProductFile() throws IOException {
    ReadProductFile readProductFile = new ReadProductFile();
    ArrayList<models.Product> products = readProductFile.readFile(testProductFile);

    assertEquals(1, products.size());
    assertEquals(1, products.get(0).getProductID());
    assertEquals("product1", products.get(0).getProductName());
    assertEquals("description1", products.get(0).getDescription());
    assertEquals(1.00, products.get(0).getPrice());
    assertEquals(1, products.get(0).getQuantity());
    assertEquals('B', products.get(0).getStatus());
    assertEquals(1, products.get(0).getSupplierID());
  }

  @Test 
  public void testReadSupplierFile() throws IOException {
    ReadSupplierFile readSupplierFile = new ReadSupplierFile();
    ArrayList<models.Supplier> suppliers = readSupplierFile.readFile(testSupplierFile);

    assertEquals(1, suppliers.size());
    assertEquals(1, suppliers.get(0).getSupplierID());
    assertEquals("supplier1", suppliers.get(0).getSupplierName());
    assertEquals("address", suppliers.get(0).getAddress());
    assertEquals("contactPhone", suppliers.get(0).getPhone());
    assertEquals("contactEmail", suppliers.get(0).getEmail());
  }

  @Test
  public void testInvalidProductFileFormat() {
    ReadProductFile reader = new ReadProductFile();
    assertThrows(IOException.class, () -> reader.readFile("CP317-Project/src/tests/files/invalidProductFile.txt"));
    assertThrows(NumberFormatException.class, () -> reader.readFile("CP317-Project/src/tests/files/invalidProductFile2.txt"));
}

  @Test
  public void testInvalidSupplierFileFormat() {
    ReadSupplierFile reader = new ReadSupplierFile();
    assertThrows(IOException.class, () -> reader.readFile("CP317-Project/src/tests/files/invalidSupplierFile.txt"));
    assertThrows(NumberFormatException.class, () -> reader.readFile("CP317-Project/src/tests/files/invalidSupplierFile2.txt"));
  } 

}