import javax.swing.*;
import java.awt.event.*;
import java.awt.Font;

public class Register{
   
    public Register(String lastname, String firstname, String middlename, String Ssuffix,
    String birthday, String Aage, String Ssex, String Aaddress, String contact){

        JFrame frame=new JFrame("Registration");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(630,700);
        frame.setLayout(null);

        JLabel VehicleInfo = new JLabel("Vehicle Information");
        VehicleInfo.setBounds(50, 15, 200,100);
        VehicleInfo.setFont(new Font("Arial", Font.BOLD, 17));
        frame.add(VehicleInfo);
     
        JLabel labelKind=new JLabel("Kind of Vehicle: ");
        labelKind.setBounds(50,100,150,30);
        frame.add(labelKind);
       
        JLabel VehicleMake=new JLabel("Vehicle Make: ");
        VehicleMake.setBounds(195,180,150,30);
        frame.add(VehicleMake);
 
        JLabel VehicleModel=new JLabel("Vehicle Model: ");
        VehicleModel.setBounds(390,180,150,30);
        frame.add(VehicleModel);

        JLabel VehicleDate=new JLabel("Vehicle Model Year: ");
        VehicleDate.setBounds(50,180,150,30);
        frame.add(VehicleDate);

        JLabel VehicleClassification=new JLabel("Vehicle Classification:");
        VehicleClassification.setBounds(280,100,300,30);
        frame.add(VehicleClassification);
       
        JLabel VehicleLicense=new JLabel("Vehicle License Plate Number:");
        VehicleLicense.setBounds(50,190,300,200);
        frame.add(VehicleLicense);

        JTextField textFieldDateReleased = new JTextField();
        textFieldDateReleased.setBounds(50,220,120,40);  
        frame.add(textFieldDateReleased);

        JTextField textFieldVehiclePlate = new JTextField();
        textFieldVehiclePlate.setBounds(50,310,200,40);  
        frame.add(textFieldVehiclePlate);

        String[]Classification={"","PRIVATE","GOVERNMENT","DIPLOMATIC"};
        JComboBox<String>vehicleClass=new JComboBox<>(Classification);
        vehicleClass.setBounds(280,130,280,40);
        frame.add(vehicleClass);

        String[]Kind={"","SEDAN","MOTORCYCLE","TRUCK","SUV", "VAN"};
        JComboBox<String>vehicleKind=new JComboBox<>(Kind);
        vehicleKind.setBounds(50,130,200,40);
        frame.add(vehicleKind);

        JTextField textFieldVehicleMake = new JTextField();
        textFieldVehicleMake.setBounds(195,220,170,40);  
        frame.add(textFieldVehicleMake);

        JTextField textFieldVehicleModel = new JTextField();
        textFieldVehicleModel.setBounds(390,220,170,40);  
        frame.add(textFieldVehicleModel);
  
        JButton buttonS= new JButton("REGISTER");
        buttonS.setBounds(185,460,250,80);
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
                String Contact = contact;
                String Kind = (String) vehicleKind.getSelectedItem();
                String Make = textFieldVehicleMake.getText().trim().toUpperCase();
                String Model = textFieldVehicleModel.getText().trim().toUpperCase();
                String DateReleased = textFieldDateReleased.getText().trim();
                String Classification = (String) vehicleClass.getSelectedItem();      
                String License = textFieldVehiclePlate.getText().trim().replace(" ", "").toUpperCase()  ;

                if(Make.isEmpty()|| Kind.equals("")|| Model.isEmpty() || DateReleased.isEmpty() || Classification.equals("") || License.isEmpty()){
                    JOptionPane.showMessageDialog(null, "Answer all the fields", "Empty Field", JOptionPane.ERROR_MESSAGE);

                 }else{
                    /* int DateR=Integer.parseInt(DateReleased); */
                    if(DateReleased.length()!=4){
                        JOptionPane.showMessageDialog(null, "Invalid year!");
                    }else if (Make.matches(".*\\d.*")) {
                            JOptionPane.showMessageDialog(null, "Vehicle Make should not contain numbers.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
                    }else if (License.length() < 6 || License.length() > 7){
                            JOptionPane.showMessageDialog(null, "Please input a valid license plate number.");
                    }else{
                        try{
                            int drYear = Integer.parseInt(DateReleased);
                            if (drYear < 1900 || drYear > 2025){
                                JOptionPane.showMessageDialog(null,"Invalid year.");
                            } else{
                                new Certificate(Lname, Fname, Mname, Suffix, Bday, Age, Sex, Address,
                                Contact, Kind, Make, Model, DateReleased, Classification, License);
                            }
                        } catch (Exception ex){
                            throw new Exception("Please input a valid year.");
                            }
                    }
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null,"Invalid Input. Please enter number only!");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null,ex.getMessage(), "Invalid Input",JOptionPane.ERROR_MESSAGE);
            }
            }    
        });

        frame.setVisible(true);
        }
     
            }
