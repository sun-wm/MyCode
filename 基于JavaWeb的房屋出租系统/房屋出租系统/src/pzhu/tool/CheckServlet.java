package pzhu.tool;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class CheckServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//1.得到图片
		VerifyCode  vc=new VerifyCode();
		BufferedImage image=vc.getImage();
		//2.获取验证码的随机字符：和用户输入的验证码进行比较
		String serverCode =vc.getText();
		request.getSession().setAttribute("code",serverCode);
		//3.字节输出流
		OutputStream out=response.getOutputStream();
		//4.把图片写道浏览器
		VerifyCode.output(image, out);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
