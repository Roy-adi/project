package emps;

import java.awt.Color;


import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.*;
import java.sql.ResultSet;

public class login extends JFrame implements ActionListener {
	
	JTextField tun, tpas;

	login(){
		getContentPane().setBackground(Color.white);
		setLayout(null);
		
		JLabel un = new JLabel("Username");
		un.setBounds(40, 20, 100, 30);
		add(un);
		
		tun = new JTextField();
		tun.setBounds(150, 20, 150, 30);
		add(tun);
		
		JLabel pas = new JLabel("Password");
		pas.setBounds(40, 70, 100, 30);
		add(pas);
		
		tpas = new JTextField();
		tpas.setBounds(150, 70, 150, 30);
		add(tpas);
		
		JButton clickhere = new JButton("LogIn");
		clickhere.setBounds(150, 140, 150, 30);
		clickhere.setBackground(Color.black);
		clickhere.setForeground(Color.white);
		clickhere.addActionListener(this);
		add(clickhere);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/logo4.png"));
		Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
		ImageIcon i3= new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(350, 10, 200, 200);
		add(image);
		
		
		setSize(600,300);
		setLocation(450,200);
		setVisible(true);
	}
	
	
	public static void main(String[]args) {
		new login();
	}


	@Override
	public void actionPerformed(ActionEvent e) {
	
		try {
			String username= tun.getText();
			String password = tpas.getText();
			
			String query =" select * from login where username = '"+username+"' and password = '"+password+"'";
			
			conn c =new conn();
			ResultSet rs=  c.s.executeQuery(query);
			if (rs.next()) {
				setVisible(false);
				new home();
			}else {
				JOptionPane.showMessageDialog(null, "Invalid Username or Password");
				setVisible(false);
			}
		}catch (Exception e1) {
			e1.printStackTrace();
		}
		
	}
}
