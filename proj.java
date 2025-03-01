import javax.swing.*;
import java.awt.event.*;
import java.awt.Font;
 
public class proj {
    public static void main(String[]args){
        JFrame frame=new JFrame("Vehicle Registration");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(630,700);

        frame.setLayout(null);
 
     
        JLabel labelFirstName=new JLabel("First Name: ");
        labelFirstName.setBounds(340,180,150,20);
        frame.add(labelFirstName);
       
        JLabel labelMiddleName=new JLabel("Middle Name: ");
        labelMiddleName.setBounds(210,180,150,20);
        frame.add(labelMiddleName);
 
        JLabel labelLastName=new JLabel("Last Name: ");
        labelLastName.setBounds(85,180,100,20);
        frame.add(labelLastName);

        JLabel labelSuffix=new JLabel("SUFFIX ");
        labelSuffix.setBounds(503,180,50,20);
        frame.add(labelSuffix);
       


        JLabel labelBday=new JLabel("Bday (M/D/Y): ");
        labelBday.setBounds(50,245,150,30);
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
       
        JTextField textFieldFirstName=new JTextField();
        textFieldFirstName.setBounds(50,120,150,50);
        frame.add(textFieldFirstName);
         JTextField textFieldMiddleName=new JTextField();
        textFieldMiddleName.setBounds(200,120,100,50);
        frame.add(textFieldMiddleName);
        JTextField textFieldLastName=new JTextField();
        textFieldLastName.setBounds(300,120,150,50);
        frame.add(textFieldLastName);
        JTextField textFieldSuffix=new JTextField();
        textFieldSuffix.setBounds(500,120,50,50);
        frame.add(textFieldSuffix);
       
        JTextField textFieldBday=new JTextField();
        textFieldBday.setBounds(150,250,240,40);
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
        textFieldContact.setBounds(150,415,240,30);
        frame.add(textFieldContact); 
 
 
 
JButton buttonRenew= new JButton("RENEW");
buttonRenew.setBounds(50,500,180,70);
frame.add(buttonRenew);

JButton buttonRegisterButton= new JButton("REGISTER");
buttonRegisterButton.setBounds(350,500,180,70);
frame.add(buttonRegisterButton);

JTextArea textArea= new JTextArea();
textArea.setBounds(0,0,0,0);
textArea.setEditable(false);
frame.add(textArea);

buttonRenew.addActionListener(new ActionListener(){
    @Override
    public void actionPerformed(ActionEvent e){
            new Renew();
           
     
          
    }
});
buttonRegisterButton.addActionListener(new ActionListener(){
    @Override
    public void actionPerformed(ActionEvent e){
        new Register();
    }
});
    
        frame.setVisible(true);
       
    }
}
