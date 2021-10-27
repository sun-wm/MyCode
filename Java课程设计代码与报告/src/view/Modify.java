package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.Player;
import dao.MysqlNBAplayer;

public class Modify extends JPanel {
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
	private JLabel lblNewLabel_4;
	private JTextField textField;
	private MysqlNBAplayer mysqlNBAplayer=new MysqlNBAplayer();

	/**
	 * Create the panel.
	 */
	public Modify() {//修改球员信息
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
		
		button = new JButton("\u4FEE\u6539");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonActionPerformed(e);
			}
		});
		button.setBounds(187, 260, 113, 27);
		add(button);

		lblNewLabel_4 = new JLabel("\u8F93\u5165\u60A8\u8981\u4FEE\u6539\u7684\u7403\u5458\u7403\u53F7\uFF1A");
		lblNewLabel_4.setBounds(0, 9, 220, 21);
		add(lblNewLabel_4);
		
		textField = new JTextField();
		textField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFieldActionPerformed(e);
			}
		});
		textField.setBounds(187, 6, 86, 24);
		add(textField);
		textField.setColumns(10);

	}

	protected void textFieldActionPerformed(ActionEvent e) {
		ResultSet resultSet=null;
		int id=Integer.valueOf(textField.getText().trim());

		resultSet=mysqlNBAplayer.query(id);
		try {
			if(resultSet.next()){
				playerID.setText(String.valueOf(resultSet.getInt(1)));
				playerName.setText(resultSet.getString(2));
				playerAge.setText(resultSet.getString(3));
				playerSalary.setText(resultSet.getString(4));
				playerLocation.setText(resultSet.getString(5));
				
			}
		} catch (SQLException e1) {
			// TODO 自动生成的 catch 块
			e1.printStackTrace();
		}
	}
	protected void buttonActionPerformed(ActionEvent e) {
		int id=Integer.valueOf(textField.getText().trim());
	    if(JOptionPane.showConfirmDialog(this,"是否确认修改！")==0){
		    String name=playerName.getText().trim();
		    int age=Integer.parseInt(playerAge.getText().trim());
		    double salary=Double.parseDouble(playerSalary.getText().trim());
		    String location=playerLocation.getText().trim();
		    Player  player=new Player(id,name, age, salary, location);
	    	mysqlNBAplayer.update(player);
	    	playerID.setText(" ");
		    playerName.setText(" ");
		    playerAge.setText(" ");
		    playerSalary.setText(" ");
		    playerLocation.setText(" ");
		    
	    }

	}

}
