package interfaces;

import java.io.IOException;
import java.util.ArrayList;


public interface IWriteFile<T> {
    void writeFile(String fileName, ArrayList<T> arrayList) throws IOException;
}
