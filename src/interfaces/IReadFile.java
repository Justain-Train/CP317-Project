package interfaces;

import java.io.IOException;
import java.util.ArrayList;

import models.Supplier;

public interface IReadFile<T> {
  ArrayList<T> readFile(String fileName,ArrayList<Supplier> suppliers) throws IOException;
}



