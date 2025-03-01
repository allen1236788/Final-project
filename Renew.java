import javax.swing.*;
import java.awt.event.*;
import java.awt.Font;
 
public class Renew {
    public Renew(){
        JFrame frame=new JFrame("Login Form");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800,700);

        frame.setLayout(null);
 
        JLabel labelFirstName=new JLabel("First Name: ");
        labelFirstName.setBounds(340,150,150,20);
        frame.add(labelFirstName);
       
        JLabel labelMiddleName=new JLabel("Middle Name: ");
        labelMiddleName.setBounds(210,150,150,20);
        frame.add(labelMiddleName);
 
        JLabel labelLastName=new JLabel("Last Name: ");
        labelLastName.setBounds(85,150,100,20);
        frame.add(labelLastName);

        
        JLabel labelSuffix=new JLabel("SUFFIX ");
        labelSuffix.setBounds(503,150,50,20);
        frame.add(labelSuffix);
       
        JLabel label1=new JLabel("Password: ");
        label1.setBounds(50,210,150,30);
        frame.add(label1);
       
        JLabel label2=new JLabel("Password: ");
        label2.setBounds(50,260,150,30);
        frame.add(label2);
       
        JLabel label3=new JLabel("Password: ");
        label3.setBounds(50,310,150,30);
        frame.add(label3);  
       


        JTextArea textFieldFirstName=new JTextArea();
        textFieldFirstName.setBounds(50,100,150,50);
        frame.add(textFieldFirstName);
         JTextArea textFieldMiddleName=new JTextArea();
        textFieldMiddleName.setBounds(200,100,100,50);
        frame.add(textFieldMiddleName);
        JTextArea textFieldLastName=new JTextArea();
        textFieldLastName.setBounds(300,100,150,50);
        frame.add(textFieldLastName);
        JTextArea textFieldSuffix=new JTextArea();
        textFieldSuffix.setBounds(500,100,50,50);
        frame.add(textFieldSuffix);
 
 
       /*  JPasswordField pass=new JPasswordField();
        pass.setBounds(150,110,250,50);
        frame.add(pass);
  */
       
        JTextField textField1=new JTextField();
        textField1.setBounds(150,200,250,50);
        frame.add(textField1);
 
       
        JTextField textField2=new JTextField();
        textField2.setBounds(150,260,250,50);
        frame.add(textField2);
 
       
        JTextField textField3=new JTextField();
        textField3.setBounds(150,320,250,50);
        frame.add(textField3); 
 
JButton buttonL= new JButton("Register Now!");
buttonL.setBounds(50,500,150,50);
frame.add(buttonL);


JTextArea textArea= new JTextArea();
textArea.setBounds(0,0,0,0);
textArea.setEditable(false);
frame.add(textArea);

buttonL.addActionListener(new ActionListener(){
    @Override
    public void actionPerformed(ActionEvent e){
        String lname = textFieldLastName.getText();
        String fname = textFieldFirstName.getText();
        String mname = textFieldMiddleName.getText();
        String suffix = textFieldSuffix.getText();
        /* String bday = textFieldBday.getText();
        String age = textFieldAge.getText();
        String contact = textFieldContact.getText();
        String address = textFieldAddress.getText();
     */


        new CertificateRenew(lname, fname, mname, suffix);
    }
});

// Set the frame visible
frame.setVisible(true);
}
    }



