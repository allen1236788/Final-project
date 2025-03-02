import javax.swing.*;
import java.awt.event.*;
import java.awt.Font;
 


public class CertificateRenew {


        // Constructor to initialize values
    public CertificateRenew(String Lname, String Fname, String Mname, String Suffix,
    String Bday, String Age, String Sex, String Address, String Contact, String Kind,
    String Make, String Model, String DateReleased, String Classification, String InsuranceCompany,
    String License, String OldCertNum, String DateRegistered, String RenewalDate) {
           
        JFrame frame=new JFrame("Certificate");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(630,700);
        frame.setLayout(null);
       
        JLabel COR = new JLabel("Certificate of Registration");
        COR.setBounds(230,0,200,100);
        frame.add(COR);
       
        JTextField textFieldDateRegistered=new JTextField("   Date of Registration: " + DateRegistered + "\t\t\t" + "          Renewal Date: " + RenewalDate);
        textFieldDateRegistered.setBounds(40,96,532,45);
        textFieldDateRegistered.setEditable(false); 
        frame.add(textFieldDateRegistered);


        JTextField textFieldFirstName=new JTextField("   " + Fname + " " + Mname + " " + Lname);
        textFieldFirstName.setBounds(40,140,444,45);
        textFieldFirstName.setEditable(false); 
        frame.add(textFieldFirstName);
       
        JTextField textFieldSex=new JTextField("   " + Sex);
        textFieldSex.setBounds(483,140,89,45);
        textFieldSex.setEditable(false); // amo ni gin change ko amo na nag blue ang bg hindi white kay para hindi maedit ang text
        frame.add(textFieldSex);
       
        JTextField textFieldBday=new JTextField("   " + Bday);
        textFieldBday.setBounds(40,183,170,45);
        textFieldBday.setEditable(false);
        frame.add(textFieldBday);


        JTextField textFieldAge=new JTextField("   " + Age);
        textFieldAge.setBounds(208,183,195,45);
        textFieldAge.setEditable(false);
        frame.add(textFieldAge);


        JTextField textFieldContact=new JTextField("   " + Contact);
        textFieldContact.setBounds(402,183,170,45);
        textFieldContact.setEditable(false);
        frame.add(textFieldContact);
       
        JTextField textFieldAddress=new JTextField("   " + Address);
        textFieldAddress.setBounds(40,227,532,45);
        textFieldAddress.setEditable(false);
        frame.add(textFieldAddress);
       
        JTextField textFieldKind=new JTextField("   " + Kind);
        textFieldKind.setBounds(208,269,195,45);
        textFieldKind.setEditable(false);
        frame.add(textFieldKind);
       
        JTextField textFieldClass=new JTextField("   " + Classification);
        textFieldClass.setBounds(402,269,170,45);
        textFieldClass.setEditable(false);
        frame.add(textFieldClass);
       
        JTextField textFieldLicense=new JTextField("   " + License);
        textFieldLicense.setBounds(40,269,170,45);
        textFieldLicense.setEditable(false);
        frame.add(textFieldLicense);




        JTextField textFieldMake=new JTextField("   " + Make);
        textFieldMake.setBounds(40,313,170,45);
        textFieldMake.setEditable(false);
        frame.add(textFieldMake);


        JTextField textFieldModel=new JTextField("   " + Model);
        textFieldModel.setBounds(208,313,195,45);
        textFieldModel.setEditable(false);
        frame.add(textFieldModel);
       
        JTextField textFieldDateReleased=new JTextField("   " + DateReleased);
        textFieldDateReleased.setBounds(402,313,170,45);
        textFieldDateReleased.setEditable(false);
        frame.add(textFieldDateReleased);
       
        JTextField textFieldOldCertNum=new JTextField("   " + OldCertNum);
        textFieldOldCertNum.setBounds(40,357,267,45);
        textFieldOldCertNum.setEditable(false);
        frame.add(textFieldOldCertNum);
       
        JTextField textFieldInsuranceCompany=new JTextField("   " + InsuranceCompany);
        textFieldInsuranceCompany.setBounds(305,357,267,45);
        textFieldInsuranceCompany.setEditable(false);
        frame.add(textFieldInsuranceCompany);


        frame.setVisible(true);
   
    }
}















