package pzhu.listener;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class OnlineCounterListener  implements HttpSessionListener {
	@Override
	public void sessionCreated(HttpSessionEvent sre) {
		// TODO Auto-generated method stub
		System.out.println("会话创建");
		ServletContext sc=sre.getSession().getServletContext();
		
		Object o=sc.getAttribute("count");//历史访问人次
		Object obj=sc.getAttribute("online");//在线人数
		
		if(o==null){  //第一个人次访问程序
			 sc.setAttribute("count", 1);
		}else{   //不是第一次访问在原来的人次上+1
			Integer i=(Integer)o;
		    sc.setAttribute("count", i+1);
		}
		
		if(obj==null){  //第一个在线的人
			sc.setAttribute("online", 1);
		}else{       //后续在线的人次
			Integer i=(Integer) obj;
			sc.setAttribute("online", i+1);
		}
		
	}
	@Override
	public void sessionDestroyed(HttpSessionEvent sre) {
		// TODO Auto-generated method stub
		System.out.println("会话销毁");
		ServletContext sc=sre.getSession().getServletContext();
	    //利用会话销毁次数实现在线人数的更新	
		Integer i=(Integer)sc.getAttribute("online");
		sc.setAttribute("online", i-1);
		}	
}