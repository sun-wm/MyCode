package pzhu.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pzhu.pojo.House;
import pzhu.service.HouseService;
import pzhu.service.impl.HouseServiceImpl;

public class HouseMpdifyServlet extends HttpServlet {
	private HouseService  hs=new HouseServiceImpl();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//设置请求和响应编码格式
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		//获取用户数据
		String province=request.getParameter("province");
		String place=request.getParameter("place");
		String price=request.getParameter("price");
		String introduce=request.getParameter("introduce");
		String surplus=request.getParameter("surplus");
		String number=request.getParameter("number");
		House house=new House();
		System.out.println(place);
		//给house赋值
//		house.setProvince(province);
//		house.setPrice(Integer.parseInt(price));
//		house.setPlace(place);
//		house.setSurplus(Integer.parseInt(surplus));
//		house.setNumber(number);
//		house.setIntroduce(introduce);
		
		System.out.println("开始修改");
		int index=hs.modifyHouse(house);
		System.out.println(index);
		if(index>0){
			System.out.println("修改成功");
			response.sendRedirect("servlet/UserShowServlet");
			return;
		}else{
			response.sendRedirect("modifyHouse.jsp");
			System.out.println("null");
			return;
		}
		
		
		
		
		
		
		
		
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
