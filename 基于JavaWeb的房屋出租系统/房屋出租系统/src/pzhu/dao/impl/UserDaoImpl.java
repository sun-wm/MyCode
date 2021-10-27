package pzhu.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pzhu.dao.UserDao;
import pzhu.pojo.User;

public class UserDaoImpl implements UserDao {
	public List<User> selectAllUsers(){
		//定义JDBC对象
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		//定义用户对象，并初始化
		List<User> list=new ArrayList<User>();
		try {
			//加载驱动
			Class.forName("com.mysql.jdbc.Driver");
			//获取连接
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/jsp","root","123456");
			//创建SQL语句
			String sql="select * from t_user";
			//预处理
			ps=conn.prepareStatement(sql);
			//执行SQL语句
			rs=ps.executeQuery();
			//遍历
			while(rs.next()){
				list.add(new User(rs.getString(1),rs.getString(2)));
//				Book book=new Book();
//				book.setId(rs.getInt("id"));
//				book.setName(rs.getString("name"));
//				book.setPrice(rs.getDouble("price"));
//				book.setAuthor(rs.getString("author"));
//				book.setPublisher(rs.getString("publisher"));
//				list.add(book);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			//关闭资源
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}
	
	
	
}
