import javax.swing.*;
import gui.FileGui;

class Main {

  public static void main(String[] args) {
    SwingUtilities.invokeLater(new Runnable() {
      @Override
      public void run() {
        new FileGui().setVisible(true);
      }
    });
  }
}

