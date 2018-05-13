<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form name="form1" action="register_action" method="post"> 
<table width="200" border="1"> 
    <tr> 
        <td colspan="2">注册窗口</td> 
    <tr> 
        <td>用户名</td> 
        <td><input type="text" name="username" size="20" maxlength="10" ></td> 
    </tr> 
    <tr> 
        <td>密码</td> 
        <td><input type="password" name="password" size="20" maxlength="15"></td> 
    </tr> 
    <tr> 
        <td>确认密码</td> 
        <td><input type="password" name="password2" size="20"maxlength="15"></td> 
    </tr> 
    <tr> 
        <td>手机号</td> 
        <td><input type="text" name="phone" size="20" maxlength="11"></td> 
    </tr> 
    <tr> 
        <td>年龄</td> 
        <td><input type="text" name="age" size="20" maxlength="3"></td> 
    </tr> 
    <tr> 
        <td>Email</td> 
        <td><input type="text" name="email" size="20" maxlength="20"></td> 
    </tr> 
    <tr> 
        <td colspan="2"><input type="submit" 
		name="submit" value="登录"> <a href="test">返回</a></td> 
    </tr> 
</table> 
</form> 
</body>
</html>