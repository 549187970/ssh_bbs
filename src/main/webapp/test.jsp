<%--
  Created by IntelliJ IDEA.
  User: Shadow
  Date: 11/17/2017
  Time: 1:10 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>
</head>
<body style="background-image:url(images/002.bmp);background-position:center; background-repeat:repeat-y;">
<table width="300" border="1" align="center" style="position:absolute; left:250px; top:100px;" >
	
    <form action="tologin" method="post" >
    	<tr align="center"><td>账号：<input type="text" name="username"></td> </tr>
    	<tr align="center"><td>密码：<input type="password" name="password"></td></tr>
    	<tr align="center"><td><input type="submit" value="登录"> &nbsp;&nbsp;&nbsp;
    	<input type="button" onclick="window.location.href=('register')" value="注册"></td> </tr> 
    </form>
   
 </table>
</body>
</html>
