package view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import dao.MysqlNBAplayer;
import model.Player;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class Insert extends JPanel {
	private JLabel label;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JTextField playerID;
	private JTextField playerName;
	private JTextField playerAge;
	private JTextField playerSalary;
	private JTextField playerLocation;
	private JButton button;
	
	
	/**
	 * Create the panel.
	 */
	public Insert() {
		setLayout(null);
		
		label = new JLabel("\u7403\u53F7\uFF1A");
		label.setBounds(47, 40, 72, 18);
		add(label);
		
		lblNewLabel = new JLabel("\u540D\u5B57\uFF1A");
		lblNewLabel.setBounds(47, 79, 72, 18);
		add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("\u5E74\u9F84\uFF1A");
		lblNewLabel_1.setBounds(47, 123, 72, 18);
		add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("\u5E74\u85AA\uFF1A");
		lblNewLabel_2.setBounds(47, 169, 72, 18);
		add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("\u4F4D\u7F6E\uFF1A");
		lblNewLabel_3.setBounds(47, 214, 72, 18);
		add(lblNewLabel_3);
		
		playerID = new JTextField();
		playerID.setBounds(187, 37, 86, 24);
		add(playerID);
		playerID.setColumns(10);
		
		playerName = new JTextField();
		playerName.setBounds(187, 76, 86, 24);
		add(playerName);
		playerName.setColumns(10);
		
		playerAge = new JTextField();
		playerAge.setBounds(187, 120, 86, 24);
		add(playerAge);
		playerAge.setColumns(10);
		
		playerSalary = new JTextField();
		playerSalary.setBounds(187, 166, 86, 24);
		add(playerSalary);
		playerSalary.setColumns(10);
		
		playerLocation = new JTextField();
		playerLocation.setBounds(187, 211, 86, 24);
		add(playerLocation);
		playerLocation.setColumns(10);
		
		button = new JButton("\u6DFB\u52A0");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				buttonActionPerformed(arg0);
			}
		});
		button.setBounds(187, 260, 113, 27);
		add(button);
		

	

	}
	protected void buttonActionPerformed(ActionEvent arg0) {
		int id=Integer.parseInt(playerID.getText().trim());
	    String name=playerName.getText().trim();
	    int age=Integer.parseInt(playerAge.getText().trim());
	    double salary=Double.parseDouble(playerSalary.getText().trim());
	    String location=playerLocation.getText().trim();
	    Player  player=new Player(id,name, age, salary, location);
	    MysqlNBAplayer mysqlNBAplayer=new MysqlNBAplayer();
	    mysqlNBAplayer.insert(player);
	    
	    playerID.setText(" ");
	    playerName.setText(" ");
	    playerAge.setText(" ");
	    playerSalary.setText(" ");
	    playerLocation.setText(" ");
	    
	    
	}
}





