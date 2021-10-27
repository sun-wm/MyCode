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
		//1.�õ�ͼƬ
		VerifyCode  vc=new VerifyCode();
		BufferedImage image=vc.getImage();
		//2.��ȡ��֤�������ַ������û��������֤����бȽ�
		String serverCode =vc.getText();
		request.getSession().setAttribute("code",serverCode);
		//3.�ֽ������
		OutputStream out=response.getOutputStream();
		//4.��ͼƬд�������
		VerifyCode.output(image, out);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
