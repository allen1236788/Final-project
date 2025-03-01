import javax.swing.*;
import java.awt.event.*;
import java.awt.Font;
 
public class Register {
    public Register(){
        //amo ni ang gin saylo from register
        JFrame frame=new JFrame("Certificate of Registration");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(630,700);

        frame.setLayout(null);

        
        JLabel labelKind=new JLabel("Kind of Vehicle: ");
        labelKind.setBounds(50,80,150,30);
        frame.add(labelKind);
       
        JLabel labelMiddleName=new JLabel("Make: ");
        labelMiddleName.setBounds(360,80,150,30);
        frame.add(labelMiddleName);
 
        JLabel labelLastName=new JLabel("Model: ");
        labelLastName.setBounds(50,180,100,30);
        frame.add(labelLastName);

        JLabel labelSuffix=new JLabel("Date released: ");
        labelSuffix.setBounds(360,180,100,30);
        frame.add(labelSuffix);
       


        JLabel labelBday=new JLabel("vehicle classification: private/government/diplomatic");
        labelBday.setBounds(50,180,300,200);
        frame.add(labelBday);
       
        JLabel VehicleLicense=new JLabel("Vehicle License plate number");
        VehicleLicense.setBounds(50,290,200,200);
        frame.add(VehicleLicense);
       
       
       
       /*  JTextField textFieldKind=new JTextField();
        textFieldKind.setBounds(150,80,100,30);
        frame.add(textFieldKind);

        JTextField textFieldMiddleName=new JTextField();
        textFieldMiddleName.setBounds(100,150,100,30);
        frame.add(textFieldMiddleName);
        JTextField textFieldLastName=new JTextField();
        textFieldLastName.setBounds(100,200,100,30);
        frame.add(textFieldLastName);
        
        JTextField textFieldSuffix=new JTextField();
        textFieldSuffix.setBounds(100, 250,50,30);
        frame.add(textFieldSuffix);

        JTextField textFieldBday=new JTextField();
        textFieldBday.setBounds(100, 300,150,30);
        frame.add(textFieldBday);
 */
       
        JTextField textFieldVehicleLicense=new JTextField();
        textFieldVehicleLicense.setBounds(50,410,250,40);
        frame.add(textFieldVehicleLicense); 

    

JButton buttonS= new JButton("REGISTER");
buttonS.setBounds(190,500,250,80);
frame.add(buttonS);

JTextArea textArea= new JTextArea();
textArea.setBounds(0,0,0,0);
textArea.setEditable(false);
frame.add(textArea);

buttonS.addActionListener(new ActionListener(){
    @Override
    public void actionPerformed(ActionEvent e){
        /* String lname = textFieldLastName.getText();
        String fname = textFieldFirstName.getText();
        String mname = textFieldMiddleName.getText();
        String suffix = textFieldSuffix.getText();
        String bday = textFieldBday.getText();
        String age = textFieldAge.getText();
     
    


        new Certificate(lname, fname, mname, suffix, bday, age);*/
    }
});

// Set the frame visible
frame.setVisible(true);
}

           
     
          
    }

