package gui;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.ArrayList;
import services.GenerateInventory;
import services.ReadProductFile;
import services.ReadSupplierFile;
import services.WriteInventoryFile;
import models.Inventory;
import models.Product;
import models.Supplier;


/*
 * FileGui class creates a GUI frame that allows the user to select product and supplier files and generate an inventory file
 */
public class FileGui extends JFrame{

  private JButton selectProductFileButton;
  private JButton selectSupplierFileButton;
  private JButton generateInventoryButton;
  private JLabel statusLabel;
  private String productFilePath;
  private String supplierFilePath;

  public FileGui() {
    createGUI();
  }

  private void createGUI() {
    /*Creates Buttons for GUI frame */
    selectProductFileButton = new JButton("Select Product File");
    selectSupplierFileButton = new JButton("Select Supplier File");
    generateInventoryButton = new JButton("Generate Inventory");
    statusLabel = new JLabel(" ");
    statusLabel.setPreferredSize(new Dimension(400,30));

    /*Action Listeners for buttons */
    selectProductFileButton.addActionListener(this::selectProductFile);
    selectSupplierFileButton.addActionListener(this::selectSupplierFile);
    generateInventoryButton.addActionListener(this::generateInventory);

    /*Sets up GUI frame */
    this.setTitle("Inventory Generator");
    this.setLayout(new FlowLayout());
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Closes window when x is clicked
    this.add(selectProductFileButton); 
    this.add(selectSupplierFileButton);
    this.add(generateInventoryButton);
    this.add(statusLabel);

    this.pack(); //Sets size of frame to fit all components
    this.setLocationRelativeTo(null); 

  }

    
  /*
   * Selects the product file to be used for generating inventory
   * @param e ActionEvent
   * @return void
   */
  private void selectProductFile(ActionEvent e) {
  try {
    JFileChooser fileChooser = new JFileChooser();
    int returnValue = fileChooser.showOpenDialog(null);
    if (returnValue == JFileChooser.APPROVE_OPTION) {
      productFilePath = fileChooser.getSelectedFile().getAbsolutePath(); //Gets the absolute path of the file
      String fileName = fileChooser.getSelectedFile().getName(); //Gets the name of the file
      if (!fileName.equals("ProductFile.txt")){
        productFilePath = null;
        throw new IllegalArgumentException("Invalid file name or extention. Please select a .txt file named ProductFile");
      };
      statusLabel.setText("Selected Product File: " + productFilePath);
    }
  }
  catch (IllegalArgumentException ex) {
    JOptionPane.showMessageDialog(null, ex.getMessage(),"Error", JOptionPane.ERROR_MESSAGE);
    }
  }

  /*
   * Selects the supplier file to be used for generating inventory
   * @param e ActionEvent
   * @return void
   */
  private void selectSupplierFile(ActionEvent e) {
  try {
    JFileChooser fileChooser = new JFileChooser();
    int returnValue = fileChooser.showOpenDialog(null);
    if (returnValue == JFileChooser.APPROVE_OPTION) {
      supplierFilePath = fileChooser.getSelectedFile().getAbsolutePath(); //Gets the absolute path of the file
      String fileName = fileChooser.getSelectedFile().getName(); //Gets the name of the file
      if (!fileName.equals("SupplierFile.txt")){
        supplierFilePath = null;
        //Throws an exception if the file name is not SupplierFile.txt
        throw new IllegalArgumentException("Invalid file name or extention. Please select a .txt file named SupplierFile");
      };
      statusLabel.setText("Selected Supplier File: " + supplierFilePath);
    }

    } catch (IllegalArgumentException ex) {
      JOptionPane.showMessageDialog(null, ex.getMessage(),"error", JOptionPane.ERROR_MESSAGE);
    }

  }
  /*
   * Generates the inventory based on the product and supplier files selected
   * @param e ActionEvent
   * @return void
   */
  private void generateInventory(ActionEvent e) {
    if (productFilePath == null || supplierFilePath == null) {

      statusLabel.setText("Please select both files"); //Displays error message if files are not selected
      return;
    }

    ReadProductFile readProductFile = new ReadProductFile();
    ReadSupplierFile readSupplierFile = new ReadSupplierFile();

    try {
      ArrayList<Product> products = readProductFile.readFile(productFilePath); 
      ArrayList<Supplier> suppliers = readSupplierFile.readFile(supplierFilePath);
      ArrayList<Inventory> inventory = GenerateInventory.generateInventory(products, suppliers);
      WriteInventoryFile writeInventoryFile = new WriteInventoryFile();
      writeInventoryFile.writeFile("Inventory.txt", inventory); 
      statusLabel.setText("Inventory generated successfully");

      //Displays error message if an exception is thrown
    } catch (IOException ex) { 
      JOptionPane.showMessageDialog(null, ex.getMessage() ,"Error", JOptionPane.ERROR_MESSAGE);
    
      //Caught from NumberFormatException in ReadProductFile
    } catch (NumberFormatException ex) {
      JOptionPane.showMessageDialog(null, "Tuple formatting error. Could not generate inventory","Error", JOptionPane.ERROR_MESSAGE);
    }
  }

}
