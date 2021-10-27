package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.Player;


public class MysqlNBAplayer {
	Connection con=null;
	Statement stmt=null;
	PreparedStatement psmt=null;
	public void getConnection(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/nbaplayer?useUnicode=true&characterEncoding=UTF-8", "root", "123456"); 
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void insert(Player player){
		getConnection();
		try {
			psmt=con.prepareStatement("insert into NBAplayer values(?,?,?,?,?)");
			psmt.setInt(1, player.getId());
			psmt.setString(2,player.getName());
			psmt.setInt(3, player.getAge());
			psmt.setDouble(4, player.getSalary());
			psmt.setString(5, player.getLocation());
			psmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				if(psmt!=null){
					psmt.close();psmt=null;
				}
				if(con!=null){
					con.close();con=null;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public ResultSet query(int id){
		getConnection();
		ResultSet rs=null;
			try {
				stmt=con.createStatement();
				rs=stmt.executeQuery("select * from NBAplayer where id="+id);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return rs;
	}
    public void DEL(int id) {
	getConnection();
    try {
		psmt=con.prepareStatement("delete from NBAplayer where id=?");
	    psmt.setInt(1, id);
	    psmt.execute();
	
	} catch (SQLException e) {
		// TODO 自动生成的 catch 块
		e.printStackTrace();
	}
}	  
	public void update(Player player){
		getConnection();
		try {
			psmt=con.prepareStatement("update nbaplayer set name=?,age=?,salary=?,location=? where id=?");
			psmt.setString(1,player.getName());
			psmt.setInt(2, player.getAge());
			psmt.setDouble(3, player.getSalary());
			psmt.setString(4,player.getLocation());
			psmt.setInt(5, player.getId());
			psmt.executeUpdate();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
	public ResultSet query(){
		getConnection();
		ResultSet rs=null;
			try {
				stmt=con.createStatement();
				rs=stmt.executeQuery("select * from NBAplayer");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return rs;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}











