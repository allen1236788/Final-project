import javax.swing.*;
import java.awt.event.*;
import java.awt.Font;
 
public class Renew {
    public Renew(){
        JFrame frame=new JFrame("Renewal");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(630,700);

        frame.setLayout(null);

        /* ,insurance compay name, old certification number, date registered, renewal date */
        JLabel labelKind=new JLabel("Kind of Vehicle: ");
        labelKind.setBounds(50,80,150,30);
        frame.add(labelKind);
       
        JLabel labelMiddleName=new JLabel("Make: ");
        labelMiddleName.setBounds(280,80,150,30);
        frame.add(labelMiddleName);
 
        JLabel labelLastName=new JLabel("Model: ");
        labelLastName.setBounds(510,80,150,30);
        frame.add(labelLastName);

        JLabel labelSuffix=new JLabel("Date released: ");
        labelSuffix.setBounds(50,160,100,30);
        frame.add(labelSuffix);
       


        JLabel labelBday=new JLabel("vehicle classification: private/government/diplomatic");
        labelBday.setBounds(360,160,100,30);
        frame.add(labelBday);
       
        JLabel VehicleLicense=new JLabel("Vehicle License plate number");
        VehicleLicense.setBounds(360,150,300,200);
        frame.add(VehicleLicense);
       
        JLabel InsuranceCompanyName=new JLabel("Insurance Company Name: ");
        InsuranceCompanyName.setBounds(50,150,200,200);
        frame.add(InsuranceCompanyName);

        JLabel OldCertificationNum=new JLabel("Old Certification Number: ");
        OldCertificationNum.setBounds(50,250,200,200);
        frame.add(OldCertificationNum);

        JLabel DateRegistered=new JLabel("Date Regstered: ");
        DateRegistered.setBounds(50,300,200,200);
        frame.add(DateRegistered);
        JLabel RenewalDate=new JLabel("Renewal Date: ");
        RenewalDate.setBounds(360,300,200,200);
        frame.add(RenewalDate);
       
        JTextField textFieldOldCertificationNum=new JTextField();
        textFieldOldCertificationNum.setBounds(200,330,360,40);
        frame.add(textFieldOldCertificationNum);


        JTextField textFieldVehicleLicense=new JTextField();
        textFieldVehicleLicense.setBounds(50,420,200,40);
        frame.add(textFieldVehicleLicense); 

        JTextField textFieldRenewalDate=new JTextField();
        textFieldRenewalDate.setBounds(360,420,200,40);
        frame.add(textFieldRenewalDate); 

    

JButton buttonS= new JButton("RENEW");
buttonS.setBounds(185,520,250,80);
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

