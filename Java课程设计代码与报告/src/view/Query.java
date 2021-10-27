package view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EtchedBorder;

import model.Player;
import dao.MysqlNBAplayer;

public class Query extends JPanel {
	private JButton btnNewButton;
	private JScrollPane scrollPane;
	private JTable table;
	String[] colName={"球号","姓名","年龄","工资","位置"};
	MysqlNBAplayer mysqlNBAplayer=new MysqlNBAplayer();
	LinkedList<Player> list=new LinkedList<Player>();
	ResultSet  rs=null;
	Object[][] record=null;
	/**
	 * Create the panel.
	 */
	public Query() {//查看球员信息
		setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		setLayout(new BorderLayout(0, 0));
		
		btnNewButton = new JButton("\u5237\u65B0");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnNewButtonActionPerformed(e);
			}
		});
		add(btnNewButton, BorderLayout.SOUTH);
		
		scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);
		
		rs=mysqlNBAplayer.query();
		if (rs==null) {
			record=new Object[2][colName.length];
			table = new JTable(record,colName);
		}else {
			showTab();
		}
		try {
			if(rs!=null) rs.close();
			rs=null;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		scrollPane.setViewportView(table);

	}
	public void getList() {
		list.clear();
		rs=mysqlNBAplayer.query();
		try {
			while (rs.next()) {
				int id=rs.getInt(1);
				String name=rs.getString(2);
				int age=rs.getInt(3);
				double salary=rs.getDouble(4);
				String location=rs.getString(5);
				Player s=new Player(id, name, age, salary, location);
				list.add(s);
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
	}
	
	public void showTab() {
		getList();
		record=new Object[list.size()][5];
		for (int i = 0; i < record.length; i++) {
			Player s = list.get(i);
			record[i][0]=s.getId();
			record[i][1]=s.getName();
			record[i][2]=s.getAge();
			record[i][3]=s.getSalary();
			record[i][4]=s.getLocation();		
		}
		table=new JTable(record, colName);
	    scrollPane.setViewportView(table);
	}

	protected void btnNewButtonActionPerformed(ActionEvent e) {
		showTab();
	}

}
