<%--
  Created by IntelliJ IDEA.
  User: Yanqi
  Date: 2022/7/29
  Time: 12:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="cn">
<head>
    <meta charset="UTF-8">
    <title>登录 Pet Manager</title>
    <script src="/static/js/jquery-3.6.0.min.js"></script>
    <script src="/static/js/jquery.js"></script>
</head>

<body>
    <div>用户登录</div>
    <div>
        <form>
            <div>
                <label for="username">用户名：</label>
                <input type="text" id="username" name="username" placeholder="用户名">
            </div>
            <div>
                <label for="password">密码：</label>
                <input type="password" id="password" name="password" placeholder="密码">
            </div>
            <div>
                <button type="button" onclick="login()" >登&nbsp;&nbsp;录</button>
            </div>
        </form>
        <p id="info" style="color: red"></p>
    </div>
</body>

<script>
    function login(){
        var username = $("#username").val();
        var password = $("#password").val();

        if(username==""){
            $("#info").html("登录账号不能为空！");
            return;
        }
        if(password==""){
            $("#info").html("密码不能为空！");
            return;
        }

        $.ajax({
            url:"/dologin",
            data:{
                username:username,
                password:password
            },
            type:"post",
            success: function(data) {
                // 成功时的回调函数
                if(data=="1"){
                    $("#info").html("登录账号不存在，登录失败！");
                }else if(data=="2"){
                    $("#info").html("密码错误，登录失败！");
                }else if(data =="3"){
                    $("#info").html("登录成功！");
                    location.href="/list";
                }else{
                    alert("服务器内部错误！")
                }
            },
            timeout: 10000,// 超时时间，超时后会调用error后的函数
            error: function() {
                // 请求失败时被调用的函数
                alert("连接服务器超时");
            }
        });
    }
</script>
</html>
