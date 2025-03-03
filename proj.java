import javax.swing.*;
import java.awt.event.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
 
        JLabel Welcome = new JLabel("Vehicle Registration Form");
        Welcome.setBounds(230,0,200,100);
        frame.add(Welcome);


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
        textFieldLastName.setBounds(50,120,150,50);
        frame.add(textFieldLastName);


         JTextField textFieldMiddleName=new JTextField();
        textFieldMiddleName.setBounds(200,120,100,50);
        frame.add(textFieldMiddleName);


        JTextField textFieldFirstName=new JTextField();
        textFieldFirstName.setBounds(300,120,150,50);
        frame.add(textFieldFirstName);


        JTextField textFieldSuffix=new JTextField();
        textFieldSuffix.setBounds(500,120,50,50);
        frame.add(textFieldSuffix);
       
        JTextField textFieldBday=new JTextField();
        textFieldBday.setBounds(190,250,240,30);
        frame.add(textFieldBday);
 
        JTextField textFieldAge=new JTextField();
        textFieldAge.setBounds(500,250,50,30);
        frame.add(textFieldAge);


        //have to make the sex scrollable  
        String[]items={"Male","Female","Other"};
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
        buttonRenew.setBounds(80,500,180,70);
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
           
           
            String ContactNum = textFieldContact.getText().trim();
            try{
                Long.parseLong(ContactNum);
                if(ContactNum.length()!=11){
                    JOptionPane.showMessageDialog(null, "Contact Number must be 11 digit.");
                }else{  
        
                String lname = textFieldLastName.getText();
                String fname = textFieldFirstName.getText();
                String mname = textFieldMiddleName.getText();
                String suffix = textFieldSuffix.getText();
                String bday = textFieldBday.getText();
                String age = textFieldAge.getText();
                String sex = (String)Sex.getSelectedItem();
                String address = textFieldAddress.getText();
                Long contactN = Long.parseLong(ContactNum);
               
                if(lname.isEmpty()|| fname.isEmpty()|| mname.isEmpty() || bday.isEmpty() || age.isEmpty() || sex.isEmpty() || address.isEmpty()){
                    JOptionPane.showMessageDialog(null, "Answer all the fields", "Empty Field", JOptionPane.ERROR_MESSAGE);
                }else{
                    if (!isValidDate(bday)) { 
                        JOptionPane.showMessageDialog(null, 
                            "Invalid date format. Please use MM/DD/YY.", 
                            "Date Error", JOptionPane.ERROR_MESSAGE);
                    } else {
                        int ageint = Integer.parseInt(age); // gn convert ko pra n m read as integer 
                        if (ageint < 17){
                            JOptionPane.showMessageDialog(null, "Must be 18 years old.");
                        }else{
                            new Renew(lname, fname, mname, suffix, bday, age, sex, address, contactN);
                        }
                            }
                                }
                                    }}catch (NumberFormatException ex) {
                                        JOptionPane.showMessageDialog(null, "Enter Valid Contact Number.",
                                        "Invalid Input", JOptionPane.ERROR_MESSAGE);
                 }
            }
        });


    buttonRegisterButton.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e){


            String Contact = textFieldContact.getText().trim();
            try{
                Long.parseLong(Contact);
            if(Contact.length()!=11){
                JOptionPane.showMessageDialog(null, "Contact Number must be 11 digit.");
            }else{


                String lastname = textFieldLastName.getText();
                String firstname = textFieldFirstName.getText();
                String middlename = textFieldMiddleName.getText();
                String Ssuffix = textFieldSuffix.getText();
                String birthday = textFieldBday.getText();
                String Aage = textFieldAge.getText();
                String Ssex = (String)Sex.getSelectedItem();
                String Aaddress = textFieldAddress.getText();
                Long CcontactN = Long.parseLong(Contact);

                if(lastname.isEmpty()|| firstname.isEmpty()|| middlename.isEmpty() || birthday.isEmpty() || Aage.isEmpty() ||Ssex.isEmpty() || Aaddress.isEmpty()){
                    JOptionPane.showMessageDialog(null, "Answer all the fields", "Empty Field", JOptionPane.ERROR_MESSAGE);
                }else if (!isValidDate(birthday)) { 
                        JOptionPane.showMessageDialog(null, 
                            "Invalid date format. Please use MM/DD/YY.", 
                            "Date Error", JOptionPane.ERROR_MESSAGE);
                    } else{
                        int Aageint = Integer.parseInt(Aage); // gn convert ko pra n m read as integer 
                    if (Aageint < 17){
                       JOptionPane.showMessageDialog(null, "Must be 18 years old"); 
                     
                        }else{ 
                                new Register(lastname, firstname, middlename, Ssuffix, birthday, Aage, Ssex, Aaddress, CcontactN);     
                        }
                    }
                }
            }catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "Enter Valid Contact Number.",
                        "Invalid Input", JOptionPane.ERROR_MESSAGE);
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

