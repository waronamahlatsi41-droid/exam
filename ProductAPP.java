

package updated;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;





public class ProductAPP extends JFrame{
    String name,price;
    private final JLabel customerName = new JLabel("Name");
    private JLabel productPrice = new JLabel("Phone");
    private final JLabel lblCount = new JLabel("Contacts: ");
    private final JTextField txtName = new JTextField(15);
    private final JTextField txtPhone = new JTextField(15);
    private final JButton btnProcess = new JButton("process");
    private final JButton btnExit = new JButton("EXIT");
    
    ArrayList<String[]> contactList= new ArrayList<>();
    private final Path filePath = Paths.get("data.txt");
    private final JTextArea txtDisplay =  new JTextArea(10,60);
    
    private final DefaultTableModel tblModel = new DefaultTableModel(new String[]{"Name", "Phone"},0){
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };
    
    private final JTable tblContacts = new JTable(tblModel);
    private final JScrollPane scrollPane = new JScrollPane(tblContacts);
    // create a menu bar 
    private final JMenuBar menuBar= new JMenuBar();
    private final JMenu fileMenu = new JMenu("File");
    private final JMenu toolsMenu = new JMenu("View");
    private final JMenu helpMenu = new JMenu("Help");
    
    private final JMenuItem newItem = new JMenuItem("New contact");
    private final JMenuItem loadItem = new JMenuItem("Load Contacts");
    private final JMenuItem saveItem = new JMenuItem("Save contacts");
    private final JMenuItem reportItem = new JMenuItem("View report");
    private final JMenuItem exitItem = new JMenuItem("Exit");
    
    private final JMenuItem refreshItem = new JMenuItem("Refresh contacts");
    private final JMenuItem aboutItem = new JMenuItem("About");
    
    
    public ProductAPP(){
        setTitle("Book App");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
         setLayout(new BorderLayout());
         buildMenu();
        add(buildInputPanel(),BorderLayout.NORTH);
        add(BuildDisplayPanel(),BorderLayout.CENTER);
        add(buildButtonPanel(),BorderLayout.SOUTH);
        tblContacts.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e) {
               selectContact();
            }
        });
       loadFromFile();
       displayContacts();
        setVisible(true);
    }
    private void buildMenu() {
        
        fileMenu.add(exitItem);
        fileMenu.add(loadItem);
        fileMenu.add(saveItem);
        fileMenu.addSeparator();
        fileMenu.add(reportItem);
        fileMenu.addSeparator();
        fileMenu.add(exitItem);
        toolsMenu.add(refreshItem);
        helpMenu.add(aboutItem);
        
        menuBar.add(fileMenu);
        menuBar.add(toolsMenu);
        menuBar.add(helpMenu);
        setJMenuBar(menuBar);
        newItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { 
                clearFields();
            }

            private void clearFields() {
                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }
        });
        loadItem.addActionListener(new ActionListener(){
              @Override
            public void actionPerformed(ActionEvent e) {
                contactList.clear();
                loadFromFile();
                displayContacts();
                showLoadWindow();
                        
            }

            private void showLoadWindow() {
                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }
            
        });        
        saveItem.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                saveToFile();
                JOptionPane.showMessageDialog(ProductAPP.this, " Contacts saved to contacts.txt");
             
        }
        });
            
    reportItem.addActionListener(new ActionListener(){
        @Override
            public void actionPerformed(ActionEvent e) {
             showReportWindow();
                
             
    }

            private void showReportWindow() {
                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }
    });
    exitItem.addActionListener(new ActionListener(){
        @Override
            public void actionPerformed(ActionEvent e) {
             System.exit(0);
                
             
    }
    });
    refreshItem.addActionListener(new ActionListener(){
        @Override
            public void actionPerformed(ActionEvent e) {
             displayContacts();
                
             
    }
    }); JOptionPane.showMessageDialog(ProductAPP.this, "contact book /n" 
            + " manage, save, update and delete contacts");
    
    
            
            
        
       
        
        
        
        
        
        
        
    }
    private JPanel buildInputPanel(){
        JPanel panel =new JPanel(new GridLayout(2, 2, 8, 8));
        panel.setBackground(new Color(230,240,245));
        panel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createTitledBorder("New Contact"),
                BorderFactory.createEmptyBorder(10,10,10,10)));
        
        txtName.setToolTipText("Enter the customers's full name");
        txtPrice.setToolTipText("Enter the price");
        
        panel.add(customerName);
        panel.add(txtName);
        panel.add(productPrice);
        panel.add(txtPhone);
        return panel;
    }
     private JPanel BuildDisplayPanel(){
        JPanel dPanel = new JPanel(new BorderLayout());
        dPanel.setBackground(new Color(230, 240, 245));
        dPanel.setBorder(BorderFactory.createCompoundBorder(
       BorderFactory.createTitledBorder("Contact Details"),
                BorderFactory.createEmptyBorder(5,5,5,5)));
   
   dPanel.add(scrollPane,BorderLayout.CENTER);
   return dPanel;
   
    }
     private void selectContact() {
         int row = tblContacts.getSelectedRow();
         if(row!= -1){
             txtName.setText(contactList.get(row)[0]);
             txtPhone.setText(contactList.get(row)[1]);
         }
    
}

     
     
    private JPanel buildButtonPanel(){
        
     JPanel panel = new JPanel(new BorderLayout(10, 5));
    panel.setBackground(new Color(230, 240, 245));
    panel.setBorder(
        BorderFactory.createEmptyBorder(5, 10, 5, 10)
    );

    // Left side: contact count
    lblCount.setText("Contacts: " + contactList.size());
    panel.add(lblCount, BorderLayout.WEST);

    // Right side: buttons
    JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
    buttonPanel.setBackground(new Color(230, 240, 245));

    buttonPanel.add(btnProcess);
  

    panel.add(buttonPanel, BorderLayout.EAST);

    btnProcess.setToolTipText("Add this customer to your list");

    btnProcess.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            name = txtName.getText().trim();
            price = txtPrice.getText().trim();
            if (!name.isEmpty() && !price.isEmpty()) {
                contactList.add(new String[]{name,price});
                saveToFile();
               displayContacts();


            }
                    txtName.setText("");
                    txtPrice.setText("");

                    JOptionPane.showMessageDialog(
                        ProductAPP.this, "customer Saved!"
                    );

        }
    });
            // Update button - updates the selected contact with new values from textfields
        btnProcess.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = tblContacts.getSelectedRow(); // get selected row index
                if (row == -1) { // no row selected
                    JOptionPane.showMessageDialog(ProductAPP.this, "Select a contact first!");
                    return;
                }
                name = txtName.getText().trim(); // get new name
                productPrice = txtPrice.getText().trim(); // get new price
                if (name.isEmpty() || price.isEmpty()) {
                    JOptionPane.showMessageDialog(ProductAPP.this, "Name and Phone required");
                    return;
                }
                contactList.set(row, new String[]{name, price}); // update ArrayList
                saveToFile(); // save updated list to contacts.txt
                displayContacts(); // refresh table
                txtName.setText(""); // clear inputs
                txtPhone.setText("");
                JOptionPane.showMessageDialog(ProductAPP.this, "Contact Updated!");
            }
        });

        // Delete button - removes selected contact from list and file
        btnProcess.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = tblContacts.getSelectedRow(); // get selected row
                if (row == -1) { // check if selected
                    JOptionPane.showMessageDialog(ProductAPP.this, "customer is proccessed");
                    return;
                }
                contactList.remove(row); // remove from ArrayList
                saveToFile(); // update file
                displayContacts(); // refresh table to show changes
                txtName.setText(""); // clear fields
                txtPhone.setText("");
            }
        });

        // Exit button - closes the application
        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0); // terminate program
            }
        });

    return panel;
    }
    
private void saveToFile(){
    try(BufferedWriter writer = Files.newBufferedWriter(filePath, StandardCharsets.UTF_8)){
        for(String[] contact : contactList){
            writer.write(contact[0] +"\t" + contact[1]);
            writer.newLine();
        }
    }catch(IOException e)
    {
        JOptionPane.showMessageDialog(
                       this, "Error saving contacts: "+e.getMessage()
                    );
    }
}
private void loadFromFile(){
    if(!Files.exists(filePath))
    {
        return;
    }
    try(BufferedReader reader = Files.newBufferedReader(filePath, StandardCharsets.UTF_8)){
        String line;
        while((line = reader.readLine())!= null){
            String[] data = line.split("\t", -1);
            if(data.length == 2){
                contactList.add(new String[]{data[0],data[1]});
            }
        }
    }catch (IOException e ){
         JOptionPane.showMessageDialog(
                       this, "Error reading contacts: "+e.getMessage()
                    );
    }       
}
private void displayContacts(){
    tblModel.setRowCount(0);
    for(String[] contact : contactList){
        tblModel.addRow(new Object[]{contact[0], contact[1]});
    }
    lblCount.setText("Contacts: " + contactList.size());
} 


   public static void main(String[] args) 
   { 
             new ProductAPP();
   }
}