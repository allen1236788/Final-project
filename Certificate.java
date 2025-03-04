import javax.swing.*;
import java.awt.event.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.awt.Font;
 


public class Certificate {




        // Constructor to initialize values
    public Certificate(String Lname, String Fname, String Mname, String Suffix,
    String Bday, String Age, String Sex, String Address, Long Contact, String Kind,
    String Make, String Model, String DateReleased, String Classification,
    String License) {
           
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter date = DateTimeFormatter.ofPattern("MM/dd/yy");
        String dateOfReg = currentDate.format(date);  
        LocalDate renewalD = currentDate.plusYears(1);
        String renewalDate = date.format(renewalD);




        JFrame frame=new JFrame("Certificate of Registration");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(630,700);
        frame.setLayout(null);
       
        JLabel COR = new JLabel("Certificate of Registration");
        COR.setBounds(230,20,200,100);
        frame.add(COR);
       
        JLabel labelDateRegistered=new JLabel("Date of Registration: " + dateOfReg);
        labelDateRegistered.setBounds(40,120,532,45);
        frame.add(labelDateRegistered);


        JLabel labelRenewalDate=new JLabel("Renewal Date: " + renewalDate);
        labelRenewalDate.setBounds(40,507,532,45);
        frame.add(labelRenewalDate);


        JLabel labelAmount=new JLabel("Amount: PHP 2000.00");
        labelAmount.setBounds(430,507,532,45);
        frame.add(labelAmount);


        JTextField textFieldName=new JTextField("   Name: " + Fname + " " + Mname + " " + Lname + " " + Suffix);
        textFieldName.setBounds(40,183,444,45); 
        textFieldName.setEditable(false);
        frame.add(textFieldName);
       
        JTextField textFieldSex=new JTextField("   Sex: " + Sex);
        textFieldSex.setBounds(483,183,89,45);
        textFieldSex.setEditable(false);
        frame.add(textFieldSex);
       
        JTextField textFieldBday=new JTextField("   Birthday: " + Bday);
        textFieldBday.setBounds(40,226,170,45);
        textFieldBday.setEditable(false);
        frame.add(textFieldBday);


        JTextField textFieldAge=new JTextField("   Age: " + Age);
        textFieldAge.setBounds(208,226,98,45);
        textFieldAge.setEditable(false);
        frame.add(textFieldAge);


        JTextField textFieldContact=new JTextField("   Contact Number: " + Contact);
        textFieldContact.setBounds(305,226,267,45);
        textFieldContact.setEditable(false);
        frame.add(textFieldContact);
       
        JTextField textFieldAddress=new JTextField("   Address: " + Address);
        textFieldAddress.setBounds(40,270,532,45);
        textFieldAddress.setEditable(false);
        frame.add(textFieldAddress);
       
        JTextField textFieldKind=new JTextField("   Vehicle Type: " + Kind);
        textFieldKind.setBounds(40,356,267,45);
        textFieldKind.setEditable(false);
        frame.add(textFieldKind);
       
        JTextField textFieldClass=new JTextField("   Vehicle Classification: " + Classification);
        textFieldClass.setBounds(342,312,230,45);
        textFieldClass.setEditable(false);
        frame.add(textFieldClass);
       
        JTextField textFieldLicense=new JTextField("   Vehicle License Plate Number: " + License);
        textFieldLicense.setBounds(40,312,307,45);
        textFieldLicense.setEditable(false);
        frame.add(textFieldLicense);


        JTextField textFieldMake=new JTextField("   Vehicle Make: " + Make);
        textFieldMake.setBounds(40,400,267,45);
        textFieldMake.setEditable(false);
        frame.add(textFieldMake);


        JTextField textFieldModel=new JTextField("   Vehicle Model: " + Model);
        textFieldModel.setBounds(305,400,267,45);
        textFieldModel.setEditable(false);
        frame.add(textFieldModel);
       
        JTextField textFieldDateReleased=new JTextField("   Vehicle Year: " + DateReleased);
        textFieldDateReleased.setBounds(305,356,267,45);
        textFieldDateReleased.setEditable(false);
        frame.add(textFieldDateReleased);
       
   


        frame.setVisible(true);
   
    }
}



