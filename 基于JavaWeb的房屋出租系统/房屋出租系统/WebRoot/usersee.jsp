<%@ page language="java" import="java.util.*,pzhu.pojo.House " pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  
    <base href="<%=basePath%>">
    
    <title>My JSP starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style type="text/css">
	h1{
		color: azure;
		}
	body{
	background-image:url(Tupian/logo.jpg);
	background-size:cover;
	}
	table{
	opacity:0.9;
	}
	</style>

  </head>
  
  <body >
  <br/><br/>
    <h1 align="center">学生总绩点</h1>
<table align="center">
   <tr>
   <th>学号</th>
   <th>性别</th>
   <th>学院</th>
   <th>总绩点</th>
   </tr>
   <c:forEach items="${list }" var="list" varStatus="vs">
		<c:choose>
		<c:when test="${vs.index%2==0 }"> <tr style="background-color:gray"></c:when>
		<c:otherwise><tr style="background-color:yellow"></c:otherwise>
		</c:choose>
 
     	<td>${list.Sno }</td>
    	<td>${list.Sex }</td>
    	<td>${list. Dept}</td>
    	<td>${list. Classno}</td>
    	<td> <input type="button"  value="删除" onclick="window.location.href='delete?name=${list.place}'"></td>
    	 </tr>
    	 </c:forEach>
    	
    
 
    <tr>
       <td>
       <form action="addHouse.jsp"  method="post"  name="delete">
		       <input type="submit" value="增加" />
		    </form>
       </td>
       <td>
       <form action="modifyHouse.jsp"  method="post"  name="modify">
		       <input type="submit" value="修改" />
		    </form>
       </td> 
    </tr>
</table>

历史访问人次:${applicationScope.count }
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    	在线人数:${applicationScope.online }
  </body>
</html>
