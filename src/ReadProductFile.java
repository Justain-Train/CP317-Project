
import java.util.ArrayList;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class ReadProductFile implements IReadFile {

  @Override
  public ArrayList<Product> readFile(String fileName, ArrayList<Supplier> suppliers) throws IOException {
    ArrayList<Product> products = new ArrayList<Product>();
    File file = new File(fileName);
    Scanner scanner = new Scanner(file);
    return products;
  }
}
