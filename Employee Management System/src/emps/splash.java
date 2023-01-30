package emps;

import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class splash extends JFrame implements ActionListener {

	splash(){
		getContentPane().setBackground(Color.white);
		setLayout(null);
		JLabel heading = new JLabel("Employee Management System");
		heading.setBounds(60,30,1200,60);
		heading.setFont(new Font("serif",Font.PLAIN,60));
		heading.setForeground(Color.RED);
		add(heading);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/logo1.jpeg"));
		Image i2 = i1.getImage().getScaledInstance(1100, 700, Image.SCALE_DEFAULT);
		ImageIcon i3= new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(50, 100, 1050, 500);
		add(image);
		JButton clickhere = new JButton("click Here");
		clickhere.setBounds(400, 400, 150, 70);
		clickhere.setBackground(Color.black);
		clickhere.setForeground(Color.white);
		clickhere.addActionListener(this);
		image.add(clickhere);
		setSize(1170,650);
		setLocation(200,50);
		setVisible(true);
		
	}

	
	public void actionPerformed(ActionEvent ae) {
		setVisible(false);
		new login();
	}
	
	
	public static void main(String[]args) {
		new splash();
	}
}
