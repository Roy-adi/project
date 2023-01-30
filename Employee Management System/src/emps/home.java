package emps;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class home extends JFrame implements ActionListener{

	JButton view ,update, remove ,add; 
	home(){
		setLayout(null);
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/home.jpg"));
		Image i2 = i1.getImage().getScaledInstance(1100, 700, Image.SCALE_DEFAULT);
		ImageIcon i3= new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(0,0, 1120, 630);
		add(image);
		
		JLabel heading = new JLabel("Employee Management System");
		heading.setBounds(620,20,400,40);
		heading.setFont(new Font("TAHOMA",Font.BOLD,25));
		image.add(heading);
		
		add = new JButton("Add Employee");
		add.setBounds(650,80,150,40);
		add.addActionListener(this);
		image.add(add);
		
		view = new JButton("view Employee");
		view.setBounds(820,80,150,40);
		view.addActionListener(this);
		image.add(view);
		
		remove = new JButton("remove Employee");
		remove.setBounds(650,140,150,40);
		remove.addActionListener(this);
		image.add(remove);
		
		update = new JButton("update Employee");
		update.setBounds(820,140,150,40);
		update.addActionListener(this);
		image.add(update);
		
		setSize(1120,630);
		setLocation(250,100);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()== add) {
			setVisible(false);
			new AddEmployee<Object>();
	}else if (ae.getSource()== view) {
		setVisible(false);
		new ViewEmployee();
	}else if (ae.getSource()==update) {
		setVisible(false);
		new ViewEmployee();
	}else {
		setVisible(false);
		new RemoveEmployee();
	}
	}
	
	public static void main(String[]args) {
		new home ();
	}
}
