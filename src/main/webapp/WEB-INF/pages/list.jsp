<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>管理列表</title>
    <style>
        #box {
            width: 600px;
            margin: 10px auto;
        }
        p,td {
            text-align: center;
        }
        .bg1 {
            background-color: #efefef;
        }
        .bg2 {
            background-color: lightblue;
        }
    </style>
</head>
<body>
    <div><h1>欢迎你 ${username}</h1></div>
    <div id="box">
        <form action="/list" method="get">
            <p>品种：<select name="petBreed">
                <option value="0">--请选择--</option>
                <option value="1">狗</option>
                <option value="2">猫</option>
                <option value="3">鸟</option>
                <option value="4">兔</option>
            </select> <input type="submit" value="查询"> <a href="/add">新增宠物</a> </p>
        </form>
        <table width="100%" border="1">
            <tr class="bg1">
                <th>宠物昵称</th>
                <th>出生日期</th>
                <th>性别</th>
            </tr>
            <c:forEach items="${list}" var="pet" varStatus="status">
                <c:if test="${status.index%2==0}"><tr></c:if>
                <c:if test="${status.index%2==1}"><tr class="bg2"></c:if>
                    <td>${pet.petName}</td>
                    <td>${pet.birthday}</td>
                    <td>
                        <c:if test="${pet.petSex==1}">雄</c:if>
                        <c:if test="${pet.petSex==2}">雌</c:if>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</body>

</html>
