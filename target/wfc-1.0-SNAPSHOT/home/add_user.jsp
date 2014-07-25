<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2014/7/3
  Time: 17:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>

    <s:form action="/home/user_addUser.action" method="POST">
        用户名：<s:textfield name="user.userName"/><br>
        密  码：<s:textfield name="user.password"/><br>
        联系电话：<s:textfield name="user.phone"/><br>
        地  址：<s:textfield name="user.address"/><br>
        <s:submit value="确定"/>
    </s:form>

</body>
</html>
