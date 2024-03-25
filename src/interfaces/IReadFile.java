package interfaces;

import java.io.IOException;
import java.util.ArrayList;


//Interface to read a file
public interface IReadFile<T> {
  ArrayList<T> readFile(String fileName) throws IOException;
}



