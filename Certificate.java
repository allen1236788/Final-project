import javax.swing.*;
import java.awt.event.*;
import java.awt.Font;
 


public class Certificate {


        // Constructor to initialize values
    public Certificate(String Lname, String Fname, String Mname, String Suffix,
    String Bday, String Age, String Sex, String Address, String Contact){
        JFrame frame=new JFrame("Certificate");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(630,700);


        frame.setLayout(null);
       
        JLabel COR = new JLabel("Certificate of Registration");
        COR.setBounds(230,0,200,100);
        frame.add(COR);
       
        JTextField textFieldFirstName=new JTextField(Fname);
        textFieldFirstName.setBounds(35,100,170,85);
        textFieldFirstName.setEditable(false); // amo ni gin change ko amo na nag blue ang bg hindi white kay para hindi maedit ang text
        frame.add(textFieldFirstName);


        JTextField textFieldMiddleName=new JTextField(Mname);
        textFieldMiddleName.setBounds(203,100,194,85);
        textFieldMiddleName.setEditable(false);
        frame.add(textFieldMiddleName);




        JTextField textFieldLastName=new JTextField(Lname);
        textFieldLastName.setBounds(395,100,170,85);
        textFieldLastName.setEditable(false);
        frame.add(textFieldLastName);
       
        JTextField textFieldBday=new JTextField(Bday);
        textFieldBday.setBounds(35,184,170,85);
        textFieldBday.setEditable(false);
        frame.add(textFieldBday);
       
        JTextField textFieldAge=new JTextField(Age);
        textFieldAge.setBounds(35,250,530,132);
        textFieldAge.setEditable(false);
        frame.add(textFieldAge);
 

   
        frame.setVisible(true);
   
    }
}



