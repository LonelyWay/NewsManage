<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<style type="text/css">
	div{
		width:375px;
		margin:0px auto;
	}
</style>
</head>
<body>
	<div>
		<form>
			<fieldset>
				<legend>添加用户</legend>
				<p>
					<label for="uname">用户名：</label><input type="text" name="username" id="uname"/>&nbsp;<span></span>
				</p>
				<p>
					<label for="pwd">密码：</label><input type="text" name="password" id="pwd"/>&nbsp;<span></span>
				</p>
				<p>
					<input type="submit" value="提 交 "/>
				</p>
			</fieldset>
		</form>
	</div>
</body>
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript">
	$(function($){
		var submit = $("input[type='submit']");
		$("#uname").blur(function(){
			var name = $(this).val();
			if(name==null||name.length==0){
				$(this).next().html("用户名不能为空！").css("color","red");
			}else{
				$(this).next().html("");
			}
		});
		$("#pwd").blur(function(){
			var pwd = $(this).val();
			if(pwd==null||pwd.length==0){
				$(this).next().html("密码不能为空！").css("color","red");
			}else{
				$(this).next().html("");
			}
		});
		submit.click(function(){
			var name=$("#uname").val().trim();
			var pwd = $("#pwd").val().trim();
			if(name.length>0&&pwd.length>0){
				$.get("../UserServlet",{username:name,password:pwd},function(data){
					alert(data);
				});
			}else{
				if(name.length==0){
					alert("用户名不能为空！")
				}
				if(pwd.length==0){
					alert("密码不能为空！")
				}
			}
			
		})
	})
</script>
</html>
