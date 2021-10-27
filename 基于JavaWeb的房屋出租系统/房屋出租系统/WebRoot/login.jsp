<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'login.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style type="text/css">
	div{
				
				border-radius: 10px;
				width: 500px;
				margin: 0px auto;
				margin-top: 40px;	
			}
	
	</style>
	<script type="text/javascript">
	//校验用户名
	function checkUname(){
		var uname=document.getElementById("uname").value;
		var unamespan=document.getElementById("unameSpan");
		var reg=/^[A-z][0-9A-z]{5,9}$/;  //正则表达式
		if (uname==""||uname==null){
			unamespan.innerHTML="用户名不能为空"; 
			unamespan.style.color="red";
			return false;
		}else if(reg.test(uname)){
			unamespan.innerHTML="用户名正确"; 
			unamespan.style.color="green";
			return true;
		}
		else{
			unamespan.innerHTML="请使用正确的用户名格式"; 
			unamespan.style.color="red";
			return false;
		}
	}
	
	function checkPassword(){
		var password=document.getElementById("password").value;
		var passwordspan=document.getElementById("passwordSpan");
		if (password==""||password==null){
			passwordspan.innerHTML="密码不能为空"; 
			passwordspan.style.color="red";
			return false;
		}else{
			passwordspan.innerHTML=""; 
		}
		return true;
	}

	//统一检验函数
	function checkall(){
		if(!checkUname()||!checkPassword()){
			alert("请输入正确的账户和密码！");
			return false;
		}
		return true;
	}
	</script>

  </head>
  
  <body>
  	
  
  	
   <div>
      <form name="reg"  action="servlet/LoginServlet"method="post"  onsubmit="return checkall()">
      <table>
     <tr> 
     <td>用户名：</td>
     <td><input type="text" name="uname" id="uname"  value=""  alt="用户名"  onblur="checkUname();"/></td><td><span id="unameSpan">*请输入6-10位,首位是字母的账户</span></td>
     </tr>
     <tr>
      <td>密&nbsp;&nbsp;码:</td>
      <td><input type="password" name="password"  id="password" value=""  alt="密码" onblur="checkPassword();"/></td><td><span id="passwordSpan">*请输入密码</span></td>
  
      </tr>
      <tr>
         <td>验证码：</td>
         <td><input type="text" name="formCode"></td>
           <td><img src="/lease/CheckServlet"><br/></td>  
        </tr>
        <tr>
        <td></td>
              <td><input type="submit" value="登录" id="bt"  /></td>
         </tr>
      </table>
    </form>
    </div>
    
    历史访问人次:${applicationScope.count }
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    	在线人数:${applicationScope.online }
  </body>
</html>
