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

    <s:form action="/home/section_add.action" method="POST">
        <s:textfield name="section.title"/><br>
        <s:textfield name="section.content"/><br>
        <s:textfield name="section.coverUrl"/><br>
        <s:submit value="确定"/>
    </s:form>

</body>
</html>
