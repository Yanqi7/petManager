<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/12/12
  Time: 16:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="cn">
<head>
    <title>添加新宠物</title>
    <script src="/static/js/jquery-3.6.0.min.js"></script>
    <script src="/static/js/jquery.js"></script>
    <style>
        #box {
            width: 600px;
            margin: 10px auto;
        }
        h2 {
            text-align: center;
        }
        td:first-child {
            text-align: right;
        }
        tr:last-child>td {
            text-align: center;
        }
    </style>
</head>
<body>
    <div id="box">
        <h2>宠物的基本信息</h2>
        <form>
            <table width="100%">
                <tr>
                    <input type="hidden" name="action" value="add">
                    <td>昵称：</td>
                    <td><input type="text" name="petName"></td>
                </tr>
                <tr>
                    <td>品种：</td>
                    <td>
                        <select name="petBreed">
                            <option value="0">--请选择--</option>
                            <option value="1">狗</option>
                            <option value="2">猫</option>
                            <option value="3">鸟</option>
                            <option value="4">兔</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>性别：</td>
                    <td>
                        <input type="radio" name="petSex" value="1" checked> 雄
                        <input type="radio" name="petSex" value="2"> 雌
                    </td>
                </tr>
                <tr>
                    <td>出生日期：</td>
                    <td><input type="text" name="birthday"> yyyy-MM-dd</td>
                </tr>
                <tr>
                    <td>宠物描述：</td>
                    <td><textarea rows="5" cols="50" name="description"></textarea></td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="button" onclick="add()" value="提交">
                        <input type="reset">
                    </td>
                </tr>
            </table>
        </form>
        <div><p id="info"></p></div>
    </div>
</body>
<script>
    function add(){
        var petName = $("#petName").val()
        var petBreed = $("#petBreed").val()
        var petSex = $("#petSex").val()
        var birthday = $("#birthday").val()
        var description = $("#description").val()

        $.ajax({
            url:"/doadd",
            rs:{
                petName:petName,
                petBreed:petBreed,
                petSex:petSex,
                birthday:birthday,
                description:description
            },
            type:"post",
            success: function(rs) {
                // 成功时的回调函数
                if(rs=="1"){
                    $("#info").html("宠物有重名！请更换");
                }else if(rs=="2"){
                    $("#info").html("宠物已存在！");
                }else if(rs =="3"){
                    alert("录入成功！跳转到列表页")
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
