
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

    private static class products {

        public products() {
        }
    }


public class PRODUCTS extends JFrame{
    String name, phone; // Temporary variables to hold name and phone when saving
    private final JLabel CustomerName = new JLabel("Name"); // Label "Name"
    private final JLabel PRODUCT = new JLabel("enter products"); // Label "Phone"
    private final JLabel PRICE = new JLabel("Contacts: "); // Label showing how many contacts
    private final JTextField txtName = new JTextField(15); // Box to type name, 15 columns wide
    private final JTextField txtPhone = new JTextField(15); // Box to type phone, 15 columns wide
    private final JButton btnProcess = new JButton("PROCESS"); // SAVE button
   
    ArrayList<String[]> contactList = new ArrayList<>(); // List to store all customer names,prices and product type
    private final Path filePath = Paths.get("data.txt"); // File where contacts are saved
    private final JTextArea txtDisplay = new JTextArea(10, 60); // Unused text area, kept for future use
}
 public static void main(String[] args) {
        new products(); // Create the window
    }

