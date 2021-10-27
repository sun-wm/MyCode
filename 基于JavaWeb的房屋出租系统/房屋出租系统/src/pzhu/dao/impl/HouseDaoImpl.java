package pzhu.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pzhu.dao.HouseDao;
import pzhu.pojo.House;


public class HouseDaoImpl implements HouseDao{
	@Override
	public List<House> selectAllHouses(){
			//定义JDBC对象
			Connection conn=null;
			PreparedStatement ps=null;
			ResultSet rs=null;
			//定义用户对象，并初始化
			List<House> list=new ArrayList<House>();
			try {
				//加载驱动
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				//获取连接
				conn=DriverManager.getConnection("jdbc:sqlserver://localhost:1443;DatabaseName=XSPJJFB","sa","123456");
				//创建SQL语句
				String sql="select ST.Sno,Sex,Dept,sum(SC.Grade*C.Score/100) AS 绩点  "
						+ "from Student ST,SC,Course C where ST.Sno=SC.Sno  and SC.Cno=C.Cno  "
						+ "GROUP BY ST.Sno,Sex,Dept";
				//预处理
				ps=conn.prepareStatement(sql);
				//执行SQL语句
				rs=ps.executeQuery();
				//遍历
				while(rs.next()){
					list.add(new House(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4)));
//					Book book=new Book();
//					book.setId(rs.getInt("id"));
//					book.setName(rs.getString("name"));
//					book.setPrice(rs.getDouble("price"));
//					book.setAuthor(rs.getString("author"));
//					book.setPublisher(rs.getString("publisher"));
//					list.add(book);
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

	public int insertHouse(House house){
		//定义JDBC对象
		Connection conn=null;
		PreparedStatement ps=null;

		//定义用户对象，并初始化
		int index=0;
		try {
			//加载驱动
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/jsp?characterEncoding=utf-8","root","123456");
			Class.forName("com.mysql.jdbc.Driver");
			//获取连接
			//创建SQL语句
			String sql="insert into fangyuan values(?,?,?,?,?,?)";
			//预处理
			ps=conn.prepareStatement(sql);
			//执行SQL语句
			//添加占位符
//			ps.setObject(1, house.getProvince());
//			ps.setObject(2, house.getPlace());
//			ps.setObject(3, house.getPrice());
//			ps.setObject(4, house.getIntroduce());
//			ps.setObject(5, house.getSurplus());
//			ps.setObject(6, house.getNumber());
			//执行SQL(成功index等于1，不成功等于0)。当executeUpdate(sql)是INSERT、UPDATE 或 DELETE 语句时，返回的是受影响的行数（即更新的行数）
			index=ps.executeUpdate(); 
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
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
      return index;
	
	}
	
	public int deleteHouse(String place){
		//定义JDBC对象
				Connection conn=null;
				PreparedStatement ps=null;

				//定义用户对象，并初始化
				int index=0;
				try {
					//加载驱动
					conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/jsp?characterEncoding=utf-8","root","123456");
					Class.forName("com.mysql.jdbc.Driver");
					//获取连接
					//创建SQL语句
					String sql="delete from fangyuan where 地点=?";
					//执行SQL语句
					ps=conn.prepareStatement(sql);
					//添加占位符
					ps.setObject(1, place);
					//执行SQL(成功index等于1，不成功等于0)。当executeUpdate(sql)是INSERT、UPDATE 或 DELETE 语句时，返回的是受影响的行数（即更新的行数）
					index=ps.executeUpdate(); 
				} catch (Exception e) {
					e.printStackTrace();
				}finally{
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
				      return index;
	}

	@Override
	public int reviseHouse(House house) {
		//定义JDBC对象
				Connection conn=null;
				PreparedStatement ps=null;

				//定义用户对象，并初始化
				int index=0;
				try {
					//加载驱动
					conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/jsp?characterEncoding=utf-8","root","123456");
					Class.forName("com.mysql.jdbc.Driver");
					//获取连接
					//创建SQL语句
					String sql="update fangyuan set 省份=?,地点=?,价格=?,住房介绍=?,余房间剩=?,房东电话=? where 地点=?";
					//预处理
					ps=conn.prepareStatement(sql);
					//执行SQL语句
					//添加占位符
					
//					ps.setObject(1, house.getProvince());
//					ps.setObject(2, house.getPlace());
//					ps.setObject(3, house.getPrice());
//					ps.setObject(4, house.getIntroduce());
//					ps.setObject(5, house.getSurplus());
//					ps.setObject(6, house.getNumber());
//					ps.setObject(7, house.getPlace());
					//执行SQL(成功index等于1，不成功等于0)。当executeUpdate(sql)是INSERT、UPDATE 或 DELETE 语句时，返回的是受影响的行数（即更新的行数）
					index=ps.executeUpdate(); 
				} catch (Exception e) {
					e.printStackTrace();
				}finally{
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
		      return index;
		
		
	}
	
	}

