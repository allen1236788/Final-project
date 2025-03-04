import javax.swing.*;
import java.awt.event.*;
import java.awt.Font;
 
public class Renew{
    public Renew(String lname, String fname, String mname, String suffix,
    String bday, String age, String sex, String address, Long contact){


     
        JFrame frame=new JFrame("Renewal");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(630,700);
        frame.setLayout(null);




     
        JLabel labelKind=new JLabel("Kind of Vehicle: ");
        labelKind.setBounds(50,80,150,30);
        frame.add(labelKind);
       
        JLabel VehicleMake=new JLabel("Vehicle Make: ");
        VehicleMake.setBounds(195,160,150,30);
        frame.add(VehicleMake);
 
        JLabel VehicleModel=new JLabel("Vehicle Model: ");
        VehicleModel.setBounds(390,160,150,30);
        frame.add(VehicleModel);


        JLabel VehicleDate=new JLabel("Vehicle Model Year: ");
        VehicleDate.setBounds(50,160,150,30);
        frame.add(VehicleDate);


        JLabel VehicleClassification=new JLabel("Vehicle Classification:");
        VehicleClassification.setBounds(280,80,300,30);
        frame.add(VehicleClassification);
       
        JLabel VehicleLicense=new JLabel("Vehicle License Plate Number:");
        VehicleLicense.setBounds(360,160,300,200);
        frame.add(VehicleLicense);
       
        JLabel InsuranceCompanyName=new JLabel("Insurance Company Name: ");
        InsuranceCompanyName.setBounds(50,160,200,200);
        frame.add(InsuranceCompanyName);


        JLabel OldCertificationNum=new JLabel("Old Certification Number: ");
        OldCertificationNum.setBounds(50,260,200,200);
        frame.add(OldCertificationNum);


       


       
        JTextField textFieldOldCertificationNum=new JTextField();
        textFieldOldCertificationNum.setBounds(200,340,360,40);
        frame.add(textFieldOldCertificationNum);






        JTextField textFieldInsuranceCompanyName = new JTextField();
        textFieldInsuranceCompanyName.setBounds(50,280,200,40);  
        frame.add(textFieldInsuranceCompanyName);


        JTextField textFieldDateReleased = new JTextField();
        textFieldDateReleased.setBounds(50,200,120,40);  
        frame.add(textFieldDateReleased);


        JTextField textFieldVehiclePlate = new JTextField();
        textFieldVehiclePlate.setBounds(360,280,200,40);  
        frame.add(textFieldVehiclePlate);


        String[]Classification={"Private","Government","Diplomatic"};
        JComboBox<String>vehicleClass=new JComboBox<>(Classification);
        vehicleClass.setBounds(280,110,280,40);
        frame.add(vehicleClass);


        String[]Kind={"Sedan","Motorcyle","Truck","SUV"};
        JComboBox<String>vehicleKind=new JComboBox<>(Kind);
        vehicleKind.setBounds(50,110,200,40);
        frame.add(vehicleKind);
       
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
            try{
                String Lname = lname;
                String Fname = fname;
                String Mname = mname;
                String Suffix = suffix;
                String Bday = bday;
                String Age = age;
                String Sex = sex;
                String Address = address;
                Long Contact = contact;
                String Kind = (String) vehicleKind.getSelectedItem();
                String Make = textFieldVehicleMake.getText();
                String Model = textFieldVehicleModel.getText();
                String DateReleased = textFieldDateReleased.getText();
                String Classification = (String) vehicleClass.getSelectedItem();
                String InsuranceCompany = textFieldInsuranceCompanyName.getText();
                String License = textFieldVehiclePlate.getText();
                String OldCertNum = textFieldOldCertificationNum.getText();
                if(Make.isEmpty()|| Kind.isEmpty()|| Model.isEmpty() || DateReleased.isEmpty() || Classification.isEmpty() || InsuranceCompany.isEmpty()|| License.isEmpty()|| OldCertNum.isEmpty()){
                    JOptionPane.showMessageDialog(null, "Answer all the fields", "Empty Field", JOptionPane.ERROR_MESSAGE);
                }else if (Make.matches(".*\\d.*")|| InsuranceCompany.matches(".*\\d.*")) {
                        JOptionPane.showMessageDialog(null, "This Field should not contain numbers.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
                }else if (License.length() !=6){
                        JOptionPane.showMessageDialog(null, "Please input a valid license plate number.");
                }else{
                    if(DateReleased.length()!=4){
                        JOptionPane.showMessageDialog(null, "Invalid year!");
                    }else{
                    new CertificateRenew(Lname, Fname, Mname, Suffix, Bday, Age, Sex, Address,
                    Contact, Kind, Make, Model, DateReleased, Classification, InsuranceCompany,
                    License, OldCertNum);
                    }
                }
            }catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null,"Invalid Input, Please enter number only!");
                }
            }
        });
        frame.setVisible(true);
        }  
            }