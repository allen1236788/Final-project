import javax.swing.*;
import java.awt.event.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.awt.Font;
 
public class Renew{
    public Renew(String lname, String fname, String mname, String suffix,
    String bday, String age, String sex, String address, String contact){




        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter date = DateTimeFormatter.ofPattern("MM/dd/yy");
        String dateOfReg = currentDate.format(date);  
        LocalDate renewalD = currentDate.plusYears(1);
        String renewalDate = date.format(renewalD);
   


        JFrame frame=new JFrame("Renewal");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(630,700);
        frame.setLayout(null);


     
        JLabel labelKind=new JLabel("Kind of Vehicle: ");
        labelKind.setBounds(50,80,150,30);
        frame.add(labelKind);
       
        JLabel VehicleMake=new JLabel("Make: ");
        VehicleMake.setBounds(195,160,150,30);
        frame.add(VehicleMake);
 
        JLabel VehicleModel=new JLabel("Model: ");
        VehicleModel.setBounds(390,160,150,30);
        frame.add(VehicleModel);


        JLabel VehicleDate=new JLabel("Date released: ");
        VehicleDate.setBounds(50,160,100,30);
        frame.add(VehicleDate);


        JLabel VehicleClassification=new JLabel("Vehicle Classification:");
        VehicleClassification.setBounds(280,80,300,30);
        frame.add(VehicleClassification);
       
        JLabel VehicleLicense=new JLabel("Vehicle License Plate Number:");
        VehicleLicense.setBounds(360,150,300,200);
        frame.add(VehicleLicense);
       
        JLabel InsuranceCompanyName=new JLabel("Insurance Company Name: ");
        InsuranceCompanyName.setBounds(50,150,200,200);
        frame.add(InsuranceCompanyName);


        JLabel OldCertificationNum=new JLabel("Old Certification Number: ");
        OldCertificationNum.setBounds(50,250,200,200);
        frame.add(OldCertificationNum);


        JLabel DateRegistered=new JLabel("Date Registered: ");
        DateRegistered.setBounds(50,300,200,200);
        frame.add(DateRegistered);
        JLabel RenewalDate=new JLabel("Renewal Date: ");
        RenewalDate.setBounds(360,300,200,200);
        frame.add(RenewalDate);




       
        JTextField textFieldOldCertificationNum=new JTextField();
        textFieldOldCertificationNum.setBounds(200,330,360,40);
        frame.add(textFieldOldCertificationNum);


        JTextField textFieldDateRegistered=new JTextField(dateOfReg);
        textFieldDateRegistered.setBounds(50,420,200,40);
        textFieldDateRegistered.setEditable(false);
        frame.add(textFieldDateRegistered);


        JTextField textFieldRenewalDate=new JTextField(renewalDate);
        textFieldRenewalDate.setBounds(360,420,200,40);
        textFieldRenewalDate.setEditable(false);
        frame.add(textFieldRenewalDate);


        JTextField textFieldInsuranceCompanyName = new JTextField();
        textFieldInsuranceCompanyName.setBounds(50,270,200,40);  
        frame.add(textFieldInsuranceCompanyName);


        JTextField textFieldDateReleased = new JTextField();
        textFieldDateReleased.setBounds(50,200,120,40);  
        frame.add(textFieldDateReleased);


        JTextField textFieldVehiclePlate = new JTextField();
        textFieldVehiclePlate.setBounds(360,270,200,40);  
        frame.add(textFieldVehiclePlate);




        String[]Classification={"Private","Government","Diplomatic"};
        JComboBox<String>vehicleClass=new JComboBox<>(Classification);
        vehicleClass.setBounds(280,110,280,40);
        frame.add(vehicleClass);


        JTextField textFieldKind = new JTextField();
        textFieldKind.setBounds(50,110,200,40);  
        frame.add(textFieldKind);


        JTextField textFieldVehicleMake = new JTextField();
        textFieldVehicleMake.setBounds(195,200,170,40);  
        frame.add(textFieldVehicleMake);


        JTextField textFieldVehicleModel = new JTextField();
        textFieldVehicleModel.setBounds(390,200,170,40);  
        frame.add(textFieldVehicleModel);






        JButton buttonS= new JButton("RENEW");
        buttonS.setBounds(185,520,250,80);
        frame.add(buttonS);






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
                String Kind = textFieldKind.getText();
                String Make = textFieldVehicleMake.getText();
                String Model = textFieldVehicleModel.getText();
                String DateReleased = textFieldDateReleased.getText();
                String Classification = (String) vehicleClass.getSelectedItem();
                String InsuranceCompany = textFieldInsuranceCompanyName.getText();
                String License = textFieldVehiclePlate.getText();
                String OldCertNum = textFieldOldCertificationNum.getText();
                String DateRegistered = textFieldDateRegistered.getText();
                String RenewalDate = textFieldRenewalDate.getText();
       
                new CertificateRenew(Lname, Fname, Mname, Suffix, Bday, Age, Sex, Address,
                Contact, Kind, Make, Model, DateReleased, Classification, InsuranceCompany,
                License, OldCertNum, DateRegistered, RenewalDate);
    }
});




// Set the frame visible
frame.setVisible(true);
}
         
    }
