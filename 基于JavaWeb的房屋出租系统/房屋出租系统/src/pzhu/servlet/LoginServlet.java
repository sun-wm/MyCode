package pzhu.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.jws.soap.SOAPBinding.Use;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pzhu.pojo.User;
import pzhu.service.UserService;
import pzhu.service.impl.UserServiceImpl;


public class LoginServlet extends HttpServlet {
private UserService  us=new UserServiceImpl();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		//1.获取用户名和密码
				String name=request.getParameter("uname");
				String psw=request.getParameter("password");
				
		//2.1判断验证码是否一致
				String userCode=request.getParameter("formCode");
				String serverCode=(String)request.getSession().getAttribute("code");	
				
				List<User> list=us.showUsers();
				int i=0;
				int b=0;
				for(i=0;i<list.size();i++){
					if(list.get(i).getUsername().equals(name)&&list.get(i).getPassword().equals(psw))
					{
						b=i;
						break;
					}
				}
				if(serverCode.equalsIgnoreCase(userCode)){
					//验证码正确，允许登录
					if(list.get(b).getUsername().equals(name)&&list.get(b).getPassword().equals(psw)){
						//登陆成功
						Cookie cookie=new Cookie("zu",name);
						cookie.setMaxAge(3*24*3600);
						System.out.println(cookie.getValue());
//						cookie.setPath("/leasel");
						response.addCookie(cookie);
						response.sendRedirect("/lease/servlet/UserShowServlet");
					}else{
						//登陆失败
						System.out.println("密码错误");
						response.sendRedirect("/lease/login.jsp");
					}
				}else{
					System.out.println("验证错误");
					response.sendRedirect("/lease/login.jsp");
				}
		
		
		
		

		
		
		
		
		
		
		
		
		
		
		
		
		
		
}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
		
	}

}
