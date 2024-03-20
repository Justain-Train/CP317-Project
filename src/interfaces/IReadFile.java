package interfaces;

import java.io.IOException;
import java.util.ArrayList;


public interface IReadFile<T> {
  ArrayList<T> readFile(String fileName) throws IOException;
}



