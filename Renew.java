import javax.swing.*;
import java.awt.event.*;
import java.awt.Font;
 
public class Renew{
    public Renew(String lname, String fname, String mname, String suffix,
    String bday, String age, String sex, String address, String contact){
     
        JFrame frame=new JFrame("Renewal");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(630,700);
        frame.setLayout(null);

        JLabel VehicleInfo = new JLabel("Vehicle Information");
        VehicleInfo.setBounds(50, 15, 200,100);
        VehicleInfo.setFont(new Font("Arial", Font.BOLD, 17));
        frame.add(VehicleInfo);

        JLabel labelKind=new JLabel("Kind of Vehicle: ");
        labelKind.setBounds(50,110,150,30);
        frame.add(labelKind);
       
        JLabel VehicleMake=new JLabel("Vehicle Make: ");
        VehicleMake.setBounds(195,190,150,30);
        frame.add(VehicleMake);
 
        JLabel VehicleModel=new JLabel("Vehicle Model: ");
        VehicleModel.setBounds(390,190,150,30);
        frame.add(VehicleModel);

        JLabel VehicleDate=new JLabel("Vehicle Model Year: ");
        VehicleDate.setBounds(50,190,150,30);
        frame.add(VehicleDate);

        JLabel VehicleClassification=new JLabel("Vehicle Classification:");
        VehicleClassification.setBounds(280,110,300,30);
        frame.add(VehicleClassification);
       
        JLabel VehicleLicense=new JLabel("Vehicle License Plate Number:");
        VehicleLicense.setBounds(360,190,300,200);
        frame.add(VehicleLicense);
       
        JLabel InsuranceCompanyName=new JLabel("Insurance Company Name: ");
        InsuranceCompanyName.setBounds(50,190,200,200);
        frame.add(InsuranceCompanyName);

        JLabel OldCertificationNum=new JLabel("Old Certification Number: ");
        OldCertificationNum.setBounds(50,290,200,200);
        frame.add(OldCertificationNum);

        JTextField textFieldOldCertificationNum=new JTextField();
        textFieldOldCertificationNum.setBounds(200,370,360,40);
        frame.add(textFieldOldCertificationNum);

        JTextField textFieldInsuranceCompanyName = new JTextField();
        textFieldInsuranceCompanyName.setBounds(50,310,200,40);  
        frame.add(textFieldInsuranceCompanyName);

        JTextField textFieldDateReleased = new JTextField();
        textFieldDateReleased.setBounds(50,230,120,40);  
        frame.add(textFieldDateReleased);

        JTextField textFieldVehiclePlate = new JTextField();
        textFieldVehiclePlate.setBounds(360,310,200,40);  
        frame.add(textFieldVehiclePlate);

        String[]Classification={"","PRIVATE","GOVERNMENT","DIPLOMATIC"};
        JComboBox<String>vehicleClass=new JComboBox<>(Classification);
        vehicleClass.setBounds(280,140,280,40);
        frame.add(vehicleClass);

        String[]Kind={"","SEDAN","MOTORCYCLE","TRUCK","SUV","VAN"};
        JComboBox<String>vehicleKind=new JComboBox<>(Kind);
        vehicleKind.setBounds(50,140,200,40);
        frame.add(vehicleKind);
       
        JTextField textFieldVehicleMake = new JTextField();
        textFieldVehicleMake.setBounds(195,230,170,40);  
        frame.add(textFieldVehicleMake);

        JTextField textFieldVehicleModel = new JTextField();
        textFieldVehicleModel.setBounds(390,230,170,40);  
        frame.add(textFieldVehicleModel);

        JButton buttonS= new JButton("RENEW");
        buttonS.setBounds(185,500,250,80);
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
                String Contact = contact;
                String Kind = (String) vehicleKind.getSelectedItem();
                String Make = textFieldVehicleMake.getText().toUpperCase();
                String Model = textFieldVehicleModel.getText().toUpperCase();
                String DateReleased = textFieldDateReleased.getText();
                String Classification = (String) vehicleClass.getSelectedItem();
                String InsuranceCompany = textFieldInsuranceCompanyName.getText().toUpperCase();
                String License = textFieldVehiclePlate.getText().toUpperCase();
                String OldCertNum = textFieldOldCertificationNum.getText();

                if(Make.isEmpty()|| Kind.equals("")|| Model.isEmpty() || DateReleased.isEmpty() || Classification.equals("") || InsuranceCompany.isEmpty()|| License.isEmpty()|| OldCertNum.isEmpty()){
                    JOptionPane.showMessageDialog(null, "Answer all the fields", "Empty Field", JOptionPane.ERROR_MESSAGE);
               
                }else{
                    if(DateReleased.length()!=4){
                        JOptionPane.showMessageDialog(null, "Invalid year!");
                    }else if (Make.matches(".*\\d.*")|| InsuranceCompany.matches(".*\\d.*")) {
                        JOptionPane.showMessageDialog(null, "Vehicle Make or Insurance Company Name should not contain numbers.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
                    }else if (License.length() < 6 || License.length() > 7){
                        JOptionPane.showMessageDialog(null, "Please input a valid license plate number.");
                    }else{
                            try{
                                int drYear = Integer.parseInt(DateReleased);
                                if (drYear < 1900 || drYear > 2025){
                                    JOptionPane.showMessageDialog(null,"Invalid year.");
                                } else {
                                    Integer.parseInt(OldCertNum);
                                    new CertificateRenew(Lname, Fname, Mname, Suffix, Bday, Age, Sex, Address,
                                    Contact, Kind, Make, Model, DateReleased, Classification, InsuranceCompany,
                                    License, OldCertNum);
                                }
                            }catch (Exception ex){
                                throw new Exception("Old Certificate Number and Vehicle Model Year should not contain letters.");
                             }
                        }
                    }
            }catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null,"Invalid Input. Please enter number only!");
            }catch (Exception ex){
                JOptionPane.showMessageDialog(null,ex.getMessage(), "Invalid Input",JOptionPane.ERROR_MESSAGE);
            }
            }
        });
        frame.setVisible(true);
        }  
            }
