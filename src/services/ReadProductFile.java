package services;

import java.util.ArrayList;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import interfaces.IReadFile;
import models.Product;



public class ReadProductFile implements IReadFile<Product> {

  @Override
  public ArrayList<Product> readFile(String fileName) throws IOException {
    ArrayList<Product> products = new ArrayList<Product>();
  try{
    File file = new File(fileName);
    Scanner scanner = new Scanner(file);
    while (scanner.hasNextLine()) {
      String line = scanner.nextLine();
      String[] productInfo = line.split(",");
      if (productInfo.length != 7) {
        throw new IOException("Invalid product file format");
}
      int productID = Integer.parseInt(productInfo[0]);
      int productQuantity = Integer.parseInt(productInfo[4].trim());
      double productPrice = Double.parseDouble(productInfo[3].replace("$", "").trim());
      char productStatus =  productInfo[5].charAt(1);
      int productSupplierID = Integer.parseInt(productInfo[6].trim());
      products.add(new Product(productID, productInfo[1].trim(),productInfo[2].trim(), productQuantity, productPrice, productStatus, productSupplierID));
    }
      scanner.close();
  } catch (IOException e) {
    e.printStackTrace();
    throw e;
  } catch (NumberFormatException e) {
    e.printStackTrace();
    throw e;
  
  }
  return products;
  }
}
