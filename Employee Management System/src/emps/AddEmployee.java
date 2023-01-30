package emps;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class AddEmployee<JDateChoosere> extends JFrame implements ActionListener {
	Random ran = new Random();
	int number = ran.nextInt(999999);
	
	 JTextField tfname, tffname,tdob, tfaddress, tfphone, tfaadhar, tfemail, tfsalary, tfdesignation;
	 JComboBox edu;
	 JLabel lblempId;
	 JButton add, back;
   AddEmployee(){
	   getContentPane().setBackground(Color.white);
	   setLayout(null);
	   
	   JLabel heading = new JLabel("Add Employee Details");
	   heading.setBounds(270, 30, 500, 50);
	   heading.setFont(new Font("SAN_Serif", Font.BOLD,35));
	   add(heading);
	   
	   JLabel fname = new JLabel("Name");
	   fname.setBounds(50, 150, 150, 30);
	   fname.setFont(new Font("serif",Font.PLAIN,20));
	   add(fname);
	   
	   tfname = new JTextField();
	   tfname.setBounds(200, 150, 150, 30);
	   add(tfname);
	   
	   JLabel labelfname = new JLabel("Father's Name");
       labelfname.setBounds(400, 150, 150, 30);
       labelfname.setFont(new Font("serif", Font.PLAIN, 20));
       add(labelfname);
       
       tffname = new JTextField();
       tffname.setBounds(600, 150, 150, 30);
       add(tffname);
       
       JLabel labeldob = new JLabel("Date of Birth");
       labeldob.setBounds(50, 200, 150, 30);
       labeldob.setFont(new Font("serif", Font.PLAIN, 20));
       add(labeldob);
       
       tdob = new JTextField();
       tdob.setBounds(200, 200, 150, 30);
       add(tdob);
       
       JLabel labelsalary = new JLabel("Salary");
       labelsalary.setBounds(400, 200, 150, 30);
       labelsalary.setFont(new Font("serif", Font.PLAIN, 20));
       add(labelsalary);
       
       tfsalary = new JTextField();
       tfsalary.setBounds(600, 200, 150, 30);
       add(tfsalary);
       
       JLabel labeladdress = new JLabel("Address");
       labeladdress.setBounds(50, 250, 150, 30);
       labeladdress.setFont(new Font("serif", Font.PLAIN, 20));
       add(labeladdress);
       
       tfaddress = new JTextField();
       tfaddress.setBounds(200, 250, 150, 30);
       add(tfaddress);
       
       JLabel labelphone = new JLabel("Phone");
       labelphone.setBounds(400, 250, 150, 30);
       labelphone.setFont(new Font("serif", Font.PLAIN, 20));
       add(labelphone);
       
       tfphone = new JTextField();
       tfphone.setBounds(600, 250, 150, 30);
       add(tfphone);
       
       JLabel labelemail = new JLabel("Email");
       labelemail.setBounds(50, 300, 150, 30);
       labelemail.setFont(new Font("serif", Font.PLAIN, 20));
       add(labelemail);
       
       tfemail = new JTextField();
       tfemail.setBounds(200, 300, 150, 30);
       add(tfemail);
       
       JLabel labeleducation = new JLabel("Higest Education");
       labeleducation.setBounds(400, 300, 150, 30);
       labeleducation.setFont(new Font("serif", Font.PLAIN, 20));
       add(labeleducation);
       
       String course[]= {"BBA","B.Tech","MBA","M.Tech"};
       edu = new JComboBox(course);
       edu.setBounds(600, 300, 150, 30);
       add(edu);
       
       JLabel labeldesignation = new JLabel("Designation");
       labeldesignation.setBounds(50, 350, 150, 30);
       labeldesignation.setFont(new Font("serif", Font.PLAIN, 20));
       add(labeldesignation);
       
       tfdesignation = new JTextField();
       tfdesignation.setBounds(200, 350, 150, 30);
       add(tfdesignation);
       
       JLabel labelaadhar = new JLabel("Aadhar Number");
       labelaadhar.setBounds(400, 350, 150, 30);
       labelaadhar.setFont(new Font("serif", Font.PLAIN, 20));
       add(labelaadhar);
       
       tfaadhar = new JTextField();
       tfaadhar.setBounds(600, 350, 150, 30);
       add(tfaadhar);
       
       JLabel labelempId = new JLabel("Employee id");
       labelempId.setBounds(50, 400, 150, 30);
       labelempId.setFont(new Font("serif", Font.PLAIN, 20));
       add(labelempId);
       
       lblempId = new JLabel("" + number);
       lblempId.setBounds(200, 400, 150, 30);
       lblempId.setFont(new Font("serif", Font.PLAIN, 20));
       add(lblempId);
       
       add = new JButton("Add Details");
       add.setBounds(250, 550, 150, 40);
       add.addActionListener(this);
       add.setBackground(Color.BLACK);
       add.setForeground(Color.WHITE);
       add(add);
       
       back = new JButton("Back");
       back.setBounds(450, 550, 150, 40);
       back.addActionListener(this);
       back.setBackground(Color.BLACK);
       back.setForeground(Color.WHITE);
       add(back);
       
       
	   
	   setSize(900,700);
	   setLocation(250,50);
	   setVisible(true);
   }
	
   public void actionPerformed(ActionEvent ae) {
   
	   if (ae.getSource()== add) {
		   
		   String name = tfname.getText();
		   String father_name = tffname.getText() ;
		   String DOB = tdob.getText();
		   String salary = tfsalary.getText();
           String address = tfaddress.getText();
           String phone = tfphone.getText();
           String email = tfemail.getText();
           String education = (String)edu.getSelectedItem();
           String designation = tfdesignation.getText();
           String aadhar = tfaadhar.getText();
           String empId = lblempId.getText();
           
           try {
        	   conn con = new conn();
        	   String query = "insert into employee values('"+name+"','"+father_name+"', '"+DOB+"', '"+salary+"', '"+address+"', '"+phone+"', '"+email+"', '"+education+"', '"+designation+"', '"+aadhar+"', '"+empId+"')";
        	   con.s.executeUpdate(query);
        	   JOptionPane.showMessageDialog(null, "Updated Successful");
        	   setVisible(false);
        	   new home();
           }catch(Exception e2) {
        	   e2.printStackTrace();
           }
	   }else {
		   setVisible(false);
		   new home();
	   }
   }
	
	
	public static void main(String[]args) {
		new AddEmployee();
	}
}
