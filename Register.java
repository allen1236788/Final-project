import javax.swing.*;
import java.awt.event.*;
import java.awt.Font;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


 
public class Register {
    public Register(String lname, String fname, String mname, String suffix,
    String bday, String age, String sex, String address, String contact){

        //need padi gali ang current date amo na ang ma print sa date of registration
        // nga wala ko na put then ang renewal date kun san o sila dapat ma renew
        JFrame frame=new JFrame("Certificate of Registration");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(630,700);


        frame.setLayout(null);


        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter date = DateTimeFormatter.ofPattern("MM/dd/yy");
        String dateOfReg = currentDate.format(date);  
        LocalDate renewalD = currentDate.plusYears(1);
        String renewalDate = date.format(renewalD);
       
        JLabel labelKind=new JLabel("Kind of Vehicle: ");
        labelKind.setBounds(30,80,150,30);
        frame.add(labelKind);
       
        JLabel labelMiddleName=new JLabel("Make: ");
        labelMiddleName.setBounds(340,80,150,30);
        frame.add(labelMiddleName);
 
        JLabel labelLastName=new JLabel("Model: ");
        labelLastName.setBounds(30,180,100,30);
        frame.add(labelLastName);


        JLabel DateRegistered=new JLabel("Date Registered: ");
        DateRegistered.setBounds(50,300,200,200);
        frame.add(DateRegistered);

        JLabel RenewalDate=new JLabel("Renewal Date: ");
        RenewalDate.setBounds(360,300,200,200);
        frame.add(RenewalDate);

        JLabel labelBday=new JLabel("Vehicle Classification: ");
        labelBday.setBounds(340,180,200,30);
        frame.add(labelBday);

       
        JLabel VehicleLicense=new JLabel("Vehicle License Plate Number");
        VehicleLicense.setBounds(30,290,200,30);
        frame.add(VehicleLicense);
       


        String[]kind={"Sedan","Motorcyle","Truck","SUV"};
        JComboBox<String>vehiclekind=new JComboBox<>(kind);
        vehiclekind.setBounds(30,110,250,40);
        frame.add(vehiclekind);

        String[]classi={"Private","Government","Diplomatic"};
        JComboBox<String>vehicleclass=new JComboBox<>(classi);
        vehicleclass.setBounds(340,220,250,40);
        frame.add(vehicleclass);
        
        //Make
        JTextField textFieldMiddleName=new JTextField();
        textFieldMiddleName.setBounds(340,110,250,40);
        frame.add(textFieldMiddleName);


        //Model
        JTextField textFieldLastName=new JTextField();
        textFieldLastName.setBounds(30,220,250,40);
        frame.add(textFieldLastName);

        JTextField textFieldDateRegistered=new JTextField(dateOfReg);
        textFieldDateRegistered.setBounds(50,420,200,40);
        textFieldDateRegistered.setEditable(false);
        frame.add(textFieldDateRegistered);


        JTextField textFieldRenewalDate=new JTextField(renewalDate);
        textFieldRenewalDate.setBounds(360,420,200,40);
        textFieldRenewalDate.setEditable(false);
        frame.add(textFieldRenewalDate);
        
        JTextField textFieldVehicleLicense=new JTextField();
        textFieldVehicleLicense.setBounds(30,330,250,40);
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
        String Lname = lname;
        String Fname = fname;
        String Mname = mname;
        String Suffix = suffix;
        String Bday = bday;
        String Age = age;
        String Sex = sex;
        String Address = address;
        String Contact = contact;

        new Certificate(Lname, Fname, Mname, Suffix, Bday, Age, Sex, Address, Contact);
    }
});


// Set the frame visible
frame.setVisible(true);
}
     
}
