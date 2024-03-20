package services;

import java.util.ArrayList;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import interfaces.IReadFile;
import models.Supplier;

 public class ReadSupplierFile implements IReadFile<Supplier> {

  /* 
  * This method reads the supplier file and returns an arraylist of suppliers
  * @param fileName - the name of the file to be read
  * @param suppliers - the arraylist of suppliers
  * @return suppliers - the arraylist of suppliers
*/
 @Override
  public ArrayList<Supplier> readFile(String fileName) throws IOException{
    ArrayList<Supplier> suppliers = new ArrayList<>();
    try {
      File file = new File(fileName);
      Scanner scanner = new Scanner(file);
      while (scanner.hasNextLine()) {
        String line = scanner.nextLine();
        String[] supplierInfo = line.split(",");
        int supplierID = Integer.parseInt(supplierInfo[0]);
        suppliers.add(new Supplier(supplierID, supplierInfo[1], supplierInfo[2], supplierInfo[3], supplierInfo[4]));
      }
      scanner.close();
    } catch (IOException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
  
    return suppliers;
  }
}
