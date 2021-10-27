package pzhu.listener;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class OnlineCounterListener  implements HttpSessionListener {
	@Override
	public void sessionCreated(HttpSessionEvent sre) {
		// TODO Auto-generated method stub
		System.out.println("�Ự����");
		ServletContext sc=sre.getSession().getServletContext();
		
		Object o=sc.getAttribute("count");//��ʷ�����˴�
		Object obj=sc.getAttribute("online");//��������
		
		if(o==null){  //��һ���˴η��ʳ���
			 sc.setAttribute("count", 1);
		}else{   //���ǵ�һ�η�����ԭ�����˴���+1
			Integer i=(Integer)o;
		    sc.setAttribute("count", i+1);
		}
		
		if(obj==null){  //��һ�����ߵ���
			sc.setAttribute("online", 1);
		}else{       //�������ߵ��˴�
			Integer i=(Integer) obj;
			sc.setAttribute("online", i+1);
		}
		
	}
	@Override
	public void sessionDestroyed(HttpSessionEvent sre) {
		// TODO Auto-generated method stub
		System.out.println("�Ự����");
		ServletContext sc=sre.getSession().getServletContext();
	    //���ûỰ���ٴ���ʵ�����������ĸ���	
		Integer i=(Integer)sc.getAttribute("online");
		sc.setAttribute("online", i-1);
		}	
}