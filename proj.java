import javax.swing.*;
import java.awt.Color;
import java.awt.event.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.awt.Font;
 
public class proj {
    public static void main(String[]args){
        JFrame frame=new JFrame("Vehicle Registration");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(630,700);
        frame.setLayout(null);
 
        JLabel PersonalInfo = new JLabel("Personal Information");
        PersonalInfo.setBounds(50, 60, 150,100);
        PersonalInfo.setFont(new Font("Arial", Font.BOLD, 13));
        frame.add(PersonalInfo);

        JLabel Welcome = new JLabel("Vehicle Registration Form");
        Welcome.setBounds(200,0,200,100);
        Welcome.setFont(new Font("Arial", Font.BOLD, 16));
        frame.add(Welcome);

        JLabel InstructionOne=new JLabel("* If no available answer,type N/A for all fields except for 'Suffix'. For 'Suffix' leave it blank");
        InstructionOne.setBounds(50,450,600,30);
        InstructionOne.setFont(new Font("Arial",Font.ITALIC,12));
        InstructionOne.setForeground(Color.RED);
        frame.add(InstructionOne);

        JLabel InstructionTwo=new JLabel("* Double check your information as you cannot go back to this tab");
        InstructionTwo.setBounds(50,480,500,30);
        InstructionTwo.setFont(new Font("Arial",Font.ITALIC,12));
        InstructionTwo.setForeground(Color.RED);
        frame.add(InstructionTwo);
       
        JLabel labelFirstName=new JLabel("First Name");
        labelFirstName.setBounds(340,200,150,20);
        frame.add(labelFirstName);
       
        JLabel labelMiddleName=new JLabel("Middle Name");
        labelMiddleName.setBounds(214,200,150,20);
        frame.add(labelMiddleName);
 
        JLabel labelLastName=new JLabel("Last Name");
        labelLastName.setBounds(89,200,100,20);
        frame.add(labelLastName);

        JLabel labelSuffix=new JLabel("Suffix ");
        labelSuffix.setBounds(506,200,50,20);
        frame.add(labelSuffix);
       
        JLabel labelBday=new JLabel("Birthday (MM/DD/YY): ");
        labelBday.setBounds(50,248,150,30);
        frame.add(labelBday);
       
        JLabel labelAge=new JLabel("Age: ");
        labelAge.setBounds(460,239,150,50);
        frame.add(labelAge);
       
        JLabel labelSex=new JLabel("Sex: ");
        labelSex.setBounds(50,306,150,30);
        frame.add(labelSex);  

        JLabel labelAddress=new JLabel("Address: ");
        labelAddress.setBounds(50,360,150,30);
        frame.add(labelAddress);  

        JLabel labelContact=new JLabel("Contact Number:");
        labelContact.setBounds(50,413,150,30);
        frame.add(labelContact);
       
        JTextField textFieldLastName=new JTextField();
        textFieldLastName.setBounds(50,140,150,50);
        frame.add(textFieldLastName);

        JTextField textFieldMiddleName=new JTextField();
        textFieldMiddleName.setBounds(200,140,100,50);
        frame.add(textFieldMiddleName);

        JTextField textFieldFirstName=new JTextField();
        textFieldFirstName.setBounds(300,140,150,50);
        frame.add(textFieldFirstName);

        JTextField textFieldSuffix=new JTextField();
        textFieldSuffix.setBounds(500,140,50,50);
        frame.add(textFieldSuffix);
       
        JTextField textFieldBday=new JTextField();
        textFieldBday.setBounds(190,250,240,30);
        frame.add(textFieldBday);
 
        JTextField textFieldAge=new JTextField();
        textFieldAge.setBounds(500,250,50,30);
        frame.add(textFieldAge);

        String[]items={"","MALE","FEMALE","OTHER"};
        JComboBox<String> Sex=new JComboBox<>(items);
        Sex.setBounds(190,306,240,30);
        frame.add(Sex);
 
        JTextField textFieldAddress=new JTextField();
        textFieldAddress.setBounds(190,360,350,30);
        frame.add(textFieldAddress);
 
        JTextField textFieldContact=new JTextField();
        textFieldContact.setBounds(190,415,240,30);
        frame.add(textFieldContact);
 
        JButton buttonRenew= new JButton("RENEW");
        buttonRenew.setBounds(80,530,180,70);
        frame.add(buttonRenew);

        JButton buttonRegisterButton= new JButton("REGISTER");
        buttonRegisterButton.setBounds(350,530,180,70);
        frame.add(buttonRegisterButton);

    buttonRenew.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e){


            try{
                String lname = textFieldLastName.getText().trim().toUpperCase();
                String fname = textFieldFirstName.getText().trim().toUpperCase();
                String mname = textFieldMiddleName.getText().trim().toUpperCase();
                String suffix = textFieldSuffix.getText().trim().toUpperCase();
                String bday = textFieldBday.getText().trim();
                String age = textFieldAge.getText().trim();
                String sex = (String)Sex.getSelectedItem();
                String address = textFieldAddress.getText().trim().toUpperCase();
                String ContactNum = textFieldContact.getText().trim();
   
                if(lname.isEmpty()|| fname.isEmpty()|| mname.isEmpty() || bday.isEmpty() || age.isEmpty()
                || sex.equals("") || address.isEmpty() || ContactNum.isEmpty()){
                    throw new Exception();
                   
                }else{  
                    if (!isValidDate(bday)) {
                        JOptionPane.showMessageDialog(null,
                            "Invalid date format. Please use MM/DD/YY.",
                            "Date Error", JOptionPane.ERROR_MESSAGE);
                    } else {            
                        try{
                            int ageint = Integer.parseInt(age);
                            if(ageint < 18){
                                JOptionPane.showMessageDialog(null, "Must be 18 years old.");
                            } else{  
                           
                            if(ContactNum.length() != 11 || !ContactNum.matches("\\d+")){
                                JOptionPane.showMessageDialog(null, "Contact Number must be 11 digit and must not contain letters.");
                            }else {
                                new Renew(lname, fname, mname, suffix, bday, age, sex, address, ContactNum);
                            }
                        }
                        }catch (NumberFormatException ex){
                            JOptionPane.showMessageDialog(null, "Invalid Input for Age / Contact ", "Invalid Input", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                }
            }catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Answer all the fields", "Empty Field", JOptionPane.ERROR_MESSAGE);
            }
            }
        });

    buttonRegisterButton.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e){
            try{
                String lastname = textFieldLastName.getText().trim().toUpperCase();
                String firstname = textFieldFirstName.getText().trim().toUpperCase();
                String middlename = textFieldMiddleName.getText().trim().toUpperCase();
                String Ssuffix = textFieldSuffix.getText().trim().toUpperCase();
                String birthday = textFieldBday.getText();
                String Aage = textFieldAge.getText();
                String Ssex = (String)Sex.getSelectedItem();
                String Aaddress = textFieldAddress.getText().trim().toUpperCase();
                String contact = textFieldContact.getText().trim();

                if(lastname.isEmpty()|| firstname.isEmpty()|| middlename.isEmpty() || birthday.isEmpty() ||
                Aage.isEmpty() ||Ssex.isEmpty() || Aaddress.isEmpty() || contact.isEmpty()){
                    throw new Exception();
                }else{
                    if (!isValidDate(birthday)) {
                        JOptionPane.showMessageDialog(null,
                            "Invalid date format. Please use MM/DD/YY.",
                            "Date Error", JOptionPane.ERROR_MESSAGE);
                    }
                    else{
                        try{
                            int Aageint = Integer.parseInt(Aage);
                            if (Aageint < 18){
                                JOptionPane.showMessageDialog(null, "Must be 18 years old");
                            }else{
                                if(contact.length() != 11 || !contact.matches("\\d+")){
                                    JOptionPane.showMessageDialog(null, "Contact Number must be 11 digit and must not contain letters.");
   
                                }else{
                                    new Register(lastname, firstname, middlename, Ssuffix, birthday, Aage, Ssex, Aaddress, contact);}
                            }
                       
                        }catch (NumberFormatException ex){
                            JOptionPane.showMessageDialog(null, "Invalid Input for Age / Contact ",
                "Invalid Input", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                }
            }catch (Exception ex) {
                            JOptionPane.showMessageDialog(null,"Answer all the fields.", "Empty Field", JOptionPane.ERROR_MESSAGE);
                }
            }
        });    
                frame.setVisible(true);   
            }
        private static boolean isValidDate(String dateStr) {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yy");
                try {
                    LocalDate.parse(dateStr, formatter);
                    return true;
                } catch (DateTimeParseException e) {
                    return false;
                }
            }       
        }
