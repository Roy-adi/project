package emps;

import java.awt.Choice;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import net.proteanit.sql.DbUtils;

public class ViewEmployee extends JFrame implements ActionListener {
	JTable table;
	Choice cemployeeId;
	JButton search, print, update, back;
	 ViewEmployee() {
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		
		JLabel searchlbl = new JLabel("Search by Employee Id");
        searchlbl.setBounds(20, 20, 150, 20);
        add(searchlbl);
        cemployeeId = new Choice();
        cemployeeId.setBounds(180, 20, 150, 20);
        add(cemployeeId);
        
        try {
            conn c = new conn();
            ResultSet rs = c.s.executeQuery("select * from employee");
            while(rs.next()) {
                cemployeeId.add(rs.getString("empId"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
		
		table =new JTable();
		try {
			conn c = new conn();
			ResultSet r = c.s.executeQuery("select * from employee");
			table.setModel(DbUtils.resultSetToTableModel(r));
		}catch(Exception e4) {
			e4.printStackTrace();
		}
		
		JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(0, 100, 900, 600);
        add(jsp);
        
        search = new JButton("Search");
        search.setBounds(20, 70, 80, 20);
        search.addActionListener(this);
        add(search);
        
        print = new JButton("Print");
        print.setBounds(120, 70, 80, 20);
        print.addActionListener(this);
        add(print);
        
        update = new JButton("Update");
        update.setBounds(220, 70, 80, 20);
        update.addActionListener(this);
        add(update);
        
        back = new JButton("Back");
        back.setBounds(320, 70, 80, 20);
        back.addActionListener(this);
        add(back);
		
		setSize(900,700);
		setLocation(300, 100);
		setVisible(true);
		
	}
	 
	 public void actionPerformed(ActionEvent ae) {
		 if (ae.getSource()==search) {
			 String query = "select * from employee where empId = '"+cemployeeId.getSelectedItem()+"'";
			 try {
				 conn c = new conn();
				 ResultSet rs = c.s.executeQuery(query);
				 table.setModel(DbUtils.resultSetToTableModel(rs));
				 
			 }catch (Exception e5) {
				 e5.printStackTrace();
			 }
		 }else if (ae.getSource()==print) {
			 try {
				 table.print();
			 }catch (Exception e6) {
				 e6.printStackTrace();
			 }
			 
		 }else if (ae.getSource()==update) {
			 setVisible(false);
			 new UpdateEmployee(cemployeeId.getSelectedItem());
			 
		 }else {
			 setVisible(false);
			 new home();
		 }
	 }

	public static void main(String[]args) {
		new ViewEmployee();
	}
}
