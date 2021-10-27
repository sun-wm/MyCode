package pzhu.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.AbandonedConnectionCleanupThread;

import pzhu.pojo.House;
import pzhu.service.HouseService;
import pzhu.service.impl.HouseServiceImpl;

public class HouseShowServlet extends HttpServlet {
	private HouseService  hs=new HouseServiceImpl();


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		
		List<House> list=hs.showHouses();
		List<House> list1=new ArrayList<House>();
		
		System.out.println(list);
		if(list==null){
			System.out.println("¿ÕÖµ");
		}else{
			System.out.println(list);
			}
		request.setAttribute("list", list1);
		RequestDispatcher forwardobj=request.getRequestDispatcher("see.jsp");
		forwardobj.forward(request,response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
