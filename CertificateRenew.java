import javax.swing.*;
import java.awt.event.*;
import java.awt.Font;
 

public class CertificateRenew {

        
        // Constructor to initialize values
    public CertificateRenew(String fname, String mname, String lname, String suffix) {
            
        JFrame frame=new JFrame("Certificate");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(630,700);

        frame.setLayout(null);
        
        
        JTextField textFieldFirstName=new JTextField(fname);
        textFieldFirstName.setBounds(35,100,170,85);
        textFieldFirstName.setEditable(false); // amo ni gin change ko amo na nag blue ang bg hindi white kay para hindi maedit ang text
        frame.add(textFieldFirstName);

        JTextField textFieldMiddleName=new JTextField(mname);
        textFieldMiddleName.setBounds(203,100,194,85);
        textFieldMiddleName.setEditable(false);
        frame.add(textFieldMiddleName);

        JTextField textFieldLastName=new JTextField(lname);
        textFieldLastName.setBounds(395,100,170,85);
        textFieldLastName.setEditable(false);
        frame.add(textFieldLastName);
        
       
        /* JTextArea textFieldBday=new JTextArea(bday);
        textFieldBday.setBounds(35,184,530,85);
        textFieldBday.setEditable(false);
        frame.add(textFieldBday);
 
       
        JTextField textFieldAge=new JTextField(age);
        textFieldAge.setBounds(35,250,530,132);
        frame.add(textFieldAge);
 
    
        JTextField textFieldAddress=new JTextField(address);
        textFieldAddress.setBounds(35,380,265,140);
        frame.add(textFieldAddress); 
 
        JTextField textFieldContact=new JTextField(contact);
        textFieldContact.setBounds(299,380,265,140);
        frame.add(textFieldContact); 
 */
        JTextArea textArea= new JTextArea();
        textArea.setBounds(0,0,0,0);
        textArea.setEditable(false);
        frame.add(textArea);
    
        frame.setVisible(true);
    
    }
}



