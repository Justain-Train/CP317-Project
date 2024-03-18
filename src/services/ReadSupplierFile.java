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
*/
 @Override
  public ArrayList<Supplier> readFile(String fileName, ArrayList<Supplier> suppliers) throws IOException{
    File file = new File(fileName);
    Scanner scanner = new Scanner(file);
    return suppliers;
  }
}
