package services;

import java.util.ArrayList;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import interfaces.IReadFile;
import models.Supplier;

 public class ReadSupplierFile implements IReadFile<Supplier> {

 @Override
  public ArrayList<Supplier> readFile(String fileName) throws IOException{
    ArrayList<Supplier> suppliers = new ArrayList<>();
    try {
      File file = new File(fileName);
      Scanner scanner = new Scanner(file);
      while (scanner.hasNextLine()) {
        String line = scanner.nextLine();
        String[] supplierInfo = line.split(",");
        if (supplierInfo.length != 5) {
          throw new IOException("Invalid supplier file format");
        }
        int supplierID = Integer.parseInt(supplierInfo[0]);
        suppliers.add(new Supplier(supplierID, supplierInfo[1].trim(), supplierInfo[2].trim(), supplierInfo[3].trim(), supplierInfo[4].trim()));
      }
      scanner.close();
    } catch (IOException e) {
      e.printStackTrace();
      throw e;
    } catch (NumberFormatException e) {
      e.printStackTrace();
      throw e;
    
    }
  
    return suppliers;
  }
}
