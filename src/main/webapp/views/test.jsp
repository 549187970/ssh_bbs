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
    <title>Test</title>
</head>
<body>
    <form action="login" method="post">
    	账号：<input type="text" name="username"><br>
    	密码：<input type="password" name="password"><br>
    	<input type="submit" value="登录">      
    </form>
    <form action="register" method="post">
    	<input type="submit" value="注册">
    </form>
</body>
</html>
