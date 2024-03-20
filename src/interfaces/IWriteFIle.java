package interfaces;

import java.io.IOException;
import java.util.ArrayList;


public interface IWriteFIle<T> {
    void writeFile(ArrayList<T> arrayList) throws IOException;
}
