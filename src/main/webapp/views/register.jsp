<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>论坛注册页面</title>
</head>


<body style="background-image:url(images/002.bmp);background-position:center; background-repeat:repeat-y;">
<h1></h1>
<table width="300" border="1"  align="center"> 
    <tr> 
        <td colspan="2">注册窗口</td> 
    <tr> 
        <td>用户名</td> 
        <td><input id="rusername" type="text" name="username" size="20" maxlength="10" ></td> 
    </tr> 
    <tr> 
        <td>密码</td> 
        <td><input id="rpassword" type="password" name="password" size="20" maxlength="15"></td> 
    </tr> 
    <tr> 
        <td>确认密码</td> 
        <td><input id="rpassword2" type="password" name="password2" size="20"maxlength="15"></td> 
    </tr> 
    <tr> 
        <td>手机号</td> 
        <td><input id="rphone"type="text" name="phone" size="20" maxlength="11"></td> 
    </tr> 
    <tr> 
        <td>年龄</td> 
        <td><input id="rage" type="int" name="age" size="20" maxlength="3"></td> 
    </tr> 
    <tr> 
        <td>Email</td> 
        <td><input id="remail" type="text" name="email" size="20" maxlength="20"></td> 
    </tr> 
    <tr> 
        <td colspan="2">
        <!--<input type="submit" name="submit" value="登录">--> 
        <button id="register">注册</button> 
        <input type="button" onclick="window.location.href=('login')" value="返回">
    </tr>
    
</table>
<p id="createResult"></p><br>

<script type="text/javascript" charset="UTF-8">
document.getElementById("register").onclick=function(){
	var request=new XMLHttpRequest();
	request.open("POST","register_action",true);
	request.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	<!--request.overrideMimeType("text/json;charset=utf-8");-->
	var data="username="+document.getElementById("rusername").value
			+"&password="+document.getElementById("rpassword").value
			+"&password2="+document.getElementById("rpassword2").value
			+"&phone="+document.getElementById("rphone").value
			+"&age="+document.getElementById("rage").value
			+"&email="+document.getElementById("remail").value;
	
	request.send(data);
	request.onreadystatechange=function(){
		if(request.readyState===4){
			if(request.status===200){
				var jsondata=request.responseText;
				var jsonobj=eval('('+jsondata+')');
				if(jsonobj.sure==true){
					window.location.href="bbs"; 
				}else{
					document.getElementById("createResult").innerHTML=jsonobj.errormsg;
				}
				
			}else{
				alert("发生错误"+request.status);
			}
		}
	}
	
}

</script>
</body>
</html>