import javax.swing.*;
import java.awt.event.*;
import java.awt.Font;
 
public class proj {
    public static void main(String[]args){
        JFrame frame=new JFrame("Vehicle Registration Form");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(630,700);
        frame.setLayout(null);
 


       
        JLabel Welcome = new JLabel("Welcome to Vehicle Registration!");
        Welcome.setBounds(200,0,200,100);
        frame.add(Welcome);
        JLabel labelFirstName=new JLabel("First Name");
        labelFirstName.setBounds(340,180,150,20);
        frame.add(labelFirstName);
        JLabel labelMiddleName=new JLabel("Middle Name");
        labelMiddleName.setBounds(210,180,150,20);
        frame.add(labelMiddleName);
        JLabel labelLastName=new JLabel("Last Name");
        labelLastName.setBounds(85,180,100,20);
        frame.add(labelLastName);
        JLabel labelSuffix=new JLabel("Suffix");
        labelSuffix.setBounds(503,180,50,20);
        frame.add(labelSuffix);
        JLabel labelBday=new JLabel("Birthday (MM/DD/YY): ");
        labelBday.setBounds(50,255,150,30);
        frame.add(labelBday);
        JLabel labelAge=new JLabel("Age: ");
        labelAge.setBounds(410,245,150,50);
        frame.add(labelAge);
        JLabel labelSex=new JLabel("Sex: ");
        labelSex.setBounds(50,310,150,30);
        frame.add(labelSex);  
        JLabel labelAddress=new JLabel("Address: ");
        labelAddress.setBounds(50,360,150,30);
        frame.add(labelAddress);  
        JLabel labelContact=new JLabel("Contact Number:");
        labelContact.setBounds(50,410,150,30);
        frame.add(labelContact);
       




        JTextField textFieldLastName=new JTextField();
        textFieldLastName.setBounds(50,120,150,50);
        frame.add(textFieldLastName);


        JTextField textFieldMiddleName=new JTextField();
        textFieldMiddleName.setBounds(200,120,100,50);
        frame.add(textFieldMiddleName);


        JTextField textFieldFirstName=new JTextField();
        textFieldFirstName.setBounds(300,120,150,50);
        frame.add(textFieldFirstName);


        JTextField textFieldSuffix=new JTextField();
        textFieldSuffix.setBounds(500,120,50,50);
        frame.add(textFieldSuffix);


        JTextField textFieldBday=new JTextField();
        textFieldBday.setBounds(200,250,180,40);
        frame.add(textFieldBday);


        JTextField textFieldAge=new JTextField();
        textFieldAge.setBounds(450,250,50,40);
        frame.add(textFieldAge);


        JTextField textFieldSex=new JTextField();
        textFieldSex.setBounds(150,310,240,30);
        frame.add(textFieldSex);


        JTextField textFieldAddress=new JTextField();
        textFieldAddress.setBounds(150,360,350,30);
        frame.add(textFieldAddress);


        JTextField textFieldContact=new JTextField();
        textFieldContact.setBounds(150,410,240,30);
        frame.add(textFieldContact);






        JButton buttonRenew= new JButton("RENEW");
        buttonRenew.setBounds(70,500,180,70);
        frame.add(buttonRenew);


        JButton buttonRegisterButton= new JButton("REGISTER");
        buttonRegisterButton.setBounds(350,500,180,70);
        frame.add(buttonRegisterButton);






        buttonRenew.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                String lname = textFieldLastName.getText();
                String fname = textFieldFirstName.getText();
                String mname = textFieldMiddleName.getText();
                String suffix = textFieldSuffix.getText();
                String bday = textFieldBday.getText();
                String age = textFieldAge.getText();
                String sex = textFieldSex.getText();
                String address = textFieldAddress.getText();
                String contact = textFieldContact.getText();
               
                new Renew(lname, fname, mname, suffix, bday, age, sex, address, contact);
            }
        });




        buttonRegisterButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                String lname = textFieldLastName.getText();
                String fname = textFieldFirstName.getText();
                String mname = textFieldMiddleName.getText();
                String suffix = textFieldSuffix.getText();
                String bday = textFieldBday.getText();
                String age = textFieldAge.getText();
                String sex = textFieldSex.getText();
                String address = textFieldAddress.getText();
                String contact = textFieldContact.getText();
               
                new Register(lname, fname, mname, suffix, bday, age, sex, address, contact);
            }
        });
           
                frame.setVisible(true);
       
    }
}





























