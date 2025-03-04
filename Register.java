import javax.swing.*;
import java.awt.event.*;


import java.awt.Font;
 
public class Register{
    
    public Register(String lastname, String firstname, String middlename, String Ssuffix,
    String birthday, String Aage, String Ssex, String Aaddress, Long CcontactN){

    
        JFrame frame=new JFrame("Registration");
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
        VehicleLicense.setBounds(50,170,300,200);
        frame.add(VehicleLicense);



        JTextField textFieldDateReleased = new JTextField();
        textFieldDateReleased.setBounds(50,200,120,40);  
        frame.add(textFieldDateReleased);




        JTextField textFieldVehiclePlate = new JTextField();
        textFieldVehiclePlate.setBounds(50,290,200,40);  
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




        JButton buttonS= new JButton("REGISTER");
        buttonS.setBounds(185,520,250,80);
        frame.add(buttonS);

        buttonS.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){

            try{
                String Lname = lastname;
                String Fname = firstname;
                String Mname = middlename;
                String Suffix = Ssuffix;
                String Bday = birthday;
                String Age = Aage;
                String Sex = Ssex;
                String Address = Aaddress;
                Long Contact = CcontactN;
                String Kind = (String) vehicleKind.getSelectedItem();
                String Make = textFieldVehicleMake.getText();
                String Model = textFieldVehicleModel.getText();
                String DateReleased = textFieldDateReleased.getText();
                String Classification = (String) vehicleClass.getSelectedItem();      
                String License = textFieldVehiclePlate.getText();
                if(Make.isEmpty()|| Kind.isEmpty()|| Model.isEmpty() || DateReleased.isEmpty() || Classification.isEmpty() || License.isEmpty()){
                    JOptionPane.showMessageDialog(null, "Answer all the fields", "Empty Field", JOptionPane.ERROR_MESSAGE);
                }else if (Make.matches(".*\\d.*")) {
                        JOptionPane.showMessageDialog(null, "Vehicle Make should not contain numbers.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
                }else if (License.length() !=6){
                        JOptionPane.showMessageDialog(null, "Please input a valid license plate number.");

                 }else{
                    /* int DateR=Integer.parseInt(DateReleased); */
                    if(DateReleased.length()!=4){
                    JOptionPane.showMessageDialog(null, "Invalid year!");
                    }else{
                    new Certificate(Lname, Fname, Mname, Suffix, Bday, Age, Sex, Address,
                    Contact, Kind, Make, Model, DateReleased, Classification,
                    License);
                    }
                }
            } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,"Invalid Input!");
                }
            }    
        });

        frame.setVisible(true);
        }
      
            }

