
package classwork;

import java.awt.BorderLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

 public class Classwork extends JFrame {
         String name;
         String phone;
 
     private final JLabel customername = new JLabel("Name");
     private final JLabel labeaparice = new JLabel("price");
     private final JLabel productType = new JLabel("type");
     
     private final JTextField textname = new JTextField(15);
     private final JTextField textPhone = new JTextField(15);
     
     private final  JButton buttonProcesse = new JButton("save");
     private final JButton buttonExit = new JButton("exit");
     private final JTextArea textDisplay = new JTextArea(20, 30);
     
     //array to save what the user input
     String[][] contactList = new String[10][2];
     int count;
     // for the information the user input tob be saved on our form
    
     
     
     public Classwork() {
         setTitle("product app");
         setSize(400,600);
         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         setLocationRelativeTo(null);
         setLayout(new BorderLayout());
         add(BuildInputPanel(),BorderLayout.NORTH);
        add(BuildInputPanel(),BorderLayout.CENTER);
         setVisible(true);
     }
         
         private JPanel BuildInputPanel() {
             
             
                 
             JPanel panel =new JPanel();
             panel.add(customername);
             panel.add(textname);
             panel.add(labeaparice);
             panel.add(textPhone);
             panel.add(buttonProcesse);
             panel.add(buttonExit);
             buttonProcesse.addActionListener(new ActionListener() {
                 @Override
                 public void actionPerformed(ActionEvent e) {
                     name = textname.getText().toString();
                     phone = textPhone.getText().toString();
                     
                  
                     
                 
                     
                     if(!name.isEmpty()) {
                   JOptionPane.showMessageDialog(panel, "please enter name");
                     } else {
                          textDisplay.append(name + "_" + phone + "/n");
                          textname.setText("");
                          textPhone.setText("");
                      
                     }
      
                             
                     
                     
                     
                     
                     
                     
                     
              
                   
                 }
             });
             
             return panel;
         
         
     
 }
     
        
     
     public static void main(String[] args) {
         new Classwork();
         
     }
     }


 


