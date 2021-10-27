<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
	<head>
                                   <base href="<%=basePath%>">
	                   <meta http-equiv="pragma" content="no-cache">
	                  <meta http-equiv="cache-control" content="no-cache">
	                  <meta http-equiv="expires" content="0">    
	                   <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	                    <meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
		<meta charset="utf-8">
		<title>浏览页面</title>
		<style type="text/css">
			.d_1{
				float: left;
			
			}
			#div_1{
				height: 40px;
				background-image:url(Tupian/logo.jpg);
			}
			#div_2{
				text-align: right;
				
			}
			fieldset{
				width: 100%;
				height: 100%;
			}
			body{
			background-image:url(Tupian/fengjing.jpg);
			background-size:cover;
			}
			
			
		</style>
	</head>
	<body >
		<div  id="div_1" >
			<h1 align="center" background-color="red">轻松租房电子商务网站</h1>
			
		</div>
		<hr />
		<div  id="div_2" >
			<form action="login.jsp"  method="post"  name="管理员登入表单">
		       <input type="submit" value="管理员登入" />
		    </form>
		</div>
		<hr />
		<fieldset >
			<font face="微软雅黑"  size=2 color="black" >房源信息</font>
			<table border="1px" cellspacing="1px" >
				    <tr>
					   <td>城市</td>
					  	<td> <input type="button"  value="北京 " onclick="window.location.href='show?name=北京'"></td>
					  	<td> <input type="button"  value="上海 " onclick="window.location.href='show?name=上海'"></td>
					  	<td> <input type="button"  value="广州 " onclick="window.location.href='show?name=广州'"></td>
					  	<td> <input type="button"  value="深圳 " onclick="window.location.href='show?name=深圳'"></td>
						<!-- <td><input type="submit" value="北京"   name="name"/></td>
						<td><input type="submit" value="上海"  name="name"/></td>
						<td><input type="submit" value="广州"  name="name"/></td>
						<td><input type="submit" value="深圳"  name="name"/></td> -->
					</tr>
			</table>
			
		
			<!--   北京  -->
			
			<div class="d_1">
			<table >
				<tr >
					<td rowspan="5" width=200px height=50px  >
						<img src="Tupian/gugong.jpg"  width=200px height=200px />
					</td>
					<td    width=400px>地&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;点：北京故宫         </td>
				</tr>
				<tr >
					<td    width=400px>房&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;价：999999         </td>
				</tr>
				<tr >
					<td    width=400px>详&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;情：一年四季有军队驻守 一年四季有军队驻守      </td>
				</tr>
				<tr >
					<td    width=400px>剩余房间：0       </td>
				</tr>
				<tr >
					<td    width=400px>联系电话：110      </td>
				</tr>
			</table>
			</div>
			
			
			<!--   上海  -->
			<div class="d_1" style="margin-left: 200px;">
			<table>
				<tr >
					<td rowspan="5" width=200px height=50px>
						<img src="Tupian/shanghai.jpg"   width=200px height=200px />
					</td>
					<td    width=400px>地&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;点：上海高楼        </td>
				</tr>
				<tr >
					<td    width=400px>房&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;价：35500        </td>
				</tr>
				<tr >
					<td    width=400px>详&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;情：四室二厅三卫，500平米，会展中心旁，两层楼      </td>
				</tr>
				<tr >
					<td    width=400px>剩余房间：0       </td>
				</tr>
				<tr >
					<td    width=400px>联系电话：13754899254      </td>
				</tr>
			</table>
			</div>
			
			<!--   广州  -->
			<div class="d_1">
			<table>
				<tr >
					<td rowspan="5" width=200px height=50px>
						<img src="Tupian/guangzou.jpg"   width=200px height=200px />
					</td>
					<td    width=400px>地&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;点：广州         </td>
				</tr>
				<tr >
					<td    width=400px>房&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;价：5555        </td>
				</tr>
				<tr >
					<td    width=400px>详&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;情：  四室二厅一厨三卫，196平米     </td>
				</tr>
				<tr >
					<td    width=400px>剩余房间：0       </td>
				</tr>
				<tr >
					<td    width=400px>联系电话：18426548964    </td>
				</tr>
			</table>
			</div>
			<!--   深圳  -->
			<div class="d_1" style="margin-left: 200px;">
			<table>
				<tr >
					<td rowspan="5" width=200px height=50px>
						<img src="Tupian/shengzhen.jpg"  width=200px height=200px />
					</td>
					<td    width=400px>地&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;点：深圳         </td>
				</tr>
				<tr >
					<td    width=400px>房&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;价：6566         </td>
				</tr>
				<tr >
					<td    width=400px>详&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;情：五室一厅，一厨五卫，11楼，东边套，169平米，基础家具齐全（可合住）      </td>
				</tr>
				<tr >
					<td    width=400px>剩余房间：10      </td>
				</tr>
				<tr >
					<td    width=400px>联系电话：17925463254     </td>
				</tr>
			</table>
			</div>
		</fieldset>
	历史访问人次:${applicationScope.count }
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    	在线人数:${applicationScope.online }
	</body>
</html>
