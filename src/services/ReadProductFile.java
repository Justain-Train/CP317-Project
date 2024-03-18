package services;

import java.util.ArrayList;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import interfaces.IReadFile;
import models.Product;
import models.Supplier;

/* 
* The readFile method reads the product file and returns an arraylist of products.
* @param fileName - the name of the file to be read
* @param suppliers - the arraylist of suppliers
* @return products - the arraylist of products
*/  


public class ReadProductFile implements IReadFile<Product> {

  @Override
  public ArrayList<Product> readFile(String fileName,ArrayList<Supplier> suppliers) throws IOException {
    ArrayList<Product> products = new ArrayList<Product>();
  try{
    File file = new File(fileName);
    Scanner scanner = new Scanner(file);
    while (scanner.hasNextLine()) {
      String line = scanner.nextLine();
      String[] productInfo = line.split(",");
      int productID = Integer.parseInt(productInfo[0]);
      int productQuantity = Integer.parseInt(productInfo[4].trim());
      double productPrice = Double.parseDouble(productInfo[3].replace("$", "").trim());
      char productStatus =  productInfo[5].charAt(1);
      int productSupplierID = Integer.parseInt(productInfo[6].trim());
      products.add(new Product(productID, productInfo[1],productInfo[2], productQuantity, productPrice, productStatus, productSupplierID));
    }
    scanner.close();

  } catch (IOException e) {
    System.out.println("An error occurred.");
    e.printStackTrace();
  }
  return products;
  }
}
