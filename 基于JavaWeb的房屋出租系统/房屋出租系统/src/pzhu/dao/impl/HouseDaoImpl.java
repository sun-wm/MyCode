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
			//����JDBC����
			Connection conn=null;
			PreparedStatement ps=null;
			ResultSet rs=null;
			//�����û����󣬲���ʼ��
			List<House> list=new ArrayList<House>();
			try {
				//��������
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				//��ȡ����
				conn=DriverManager.getConnection("jdbc:sqlserver://localhost:1443;DatabaseName=XSPJJFB","sa","123456");
				//����SQL���
				String sql="select ST.Sno,Sex,Dept,sum(SC.Grade*C.Score/100) AS ����  "
						+ "from Student ST,SC,Course C where ST.Sno=SC.Sno  and SC.Cno=C.Cno  "
						+ "GROUP BY ST.Sno,Sex,Dept";
				//Ԥ����
				ps=conn.prepareStatement(sql);
				//ִ��SQL���
				rs=ps.executeQuery();
				//����
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
				//�ر���Դ
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
		//����JDBC����
		Connection conn=null;
		PreparedStatement ps=null;

		//�����û����󣬲���ʼ��
		int index=0;
		try {
			//��������
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/jsp?characterEncoding=utf-8","root","123456");
			Class.forName("com.mysql.jdbc.Driver");
			//��ȡ����
			//����SQL���
			String sql="insert into fangyuan values(?,?,?,?,?,?)";
			//Ԥ����
			ps=conn.prepareStatement(sql);
			//ִ��SQL���
			//���ռλ��
//			ps.setObject(1, house.getProvince());
//			ps.setObject(2, house.getPlace());
//			ps.setObject(3, house.getPrice());
//			ps.setObject(4, house.getIntroduce());
//			ps.setObject(5, house.getSurplus());
//			ps.setObject(6, house.getNumber());
			//ִ��SQL(�ɹ�index����1�����ɹ�����0)����executeUpdate(sql)��INSERT��UPDATE �� DELETE ���ʱ�����ص�����Ӱ��������������µ�������
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
		//����JDBC����
				Connection conn=null;
				PreparedStatement ps=null;

				//�����û����󣬲���ʼ��
				int index=0;
				try {
					//��������
					conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/jsp?characterEncoding=utf-8","root","123456");
					Class.forName("com.mysql.jdbc.Driver");
					//��ȡ����
					//����SQL���
					String sql="delete from fangyuan where �ص�=?";
					//ִ��SQL���
					ps=conn.prepareStatement(sql);
					//���ռλ��
					ps.setObject(1, place);
					//ִ��SQL(�ɹ�index����1�����ɹ�����0)����executeUpdate(sql)��INSERT��UPDATE �� DELETE ���ʱ�����ص�����Ӱ��������������µ�������
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
		//����JDBC����
				Connection conn=null;
				PreparedStatement ps=null;

				//�����û����󣬲���ʼ��
				int index=0;
				try {
					//��������
					conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/jsp?characterEncoding=utf-8","root","123456");
					Class.forName("com.mysql.jdbc.Driver");
					//��ȡ����
					//����SQL���
					String sql="update fangyuan set ʡ��=?,�ص�=?,�۸�=?,ס������=?,�෿��ʣ=?,�����绰=? where �ص�=?";
					//Ԥ����
					ps=conn.prepareStatement(sql);
					//ִ��SQL���
					//���ռλ��
					
//					ps.setObject(1, house.getProvince());
//					ps.setObject(2, house.getPlace());
//					ps.setObject(3, house.getPrice());
//					ps.setObject(4, house.getIntroduce());
//					ps.setObject(5, house.getSurplus());
//					ps.setObject(6, house.getNumber());
//					ps.setObject(7, house.getPlace());
					//ִ��SQL(�ɹ�index����1�����ɹ�����0)����executeUpdate(sql)��INSERT��UPDATE �� DELETE ���ʱ�����ص�����Ӱ��������������µ�������
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

