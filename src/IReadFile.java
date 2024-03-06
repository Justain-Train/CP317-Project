
import java.io.IOException;
import java.util.ArrayList;

public interface IReadFile {
  ArrayList<?> readFile(String fileName, ArrayList<Supplier> suppliers) throws IOException;
}



