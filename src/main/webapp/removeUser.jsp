<%--
  Created by IntelliJ IDEA.
  User: 2hyeonho
  Date: 2022/10/30
  Time: 12:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8"/>
</head>
<body>
<h1>사용자 삭제</h1>
<form method="post" action="/admin/userRemove.do">
    아이디: <input type="text" placeholder="삭제할 아이디" name="removeId" /><br />
    <input type="submit" value="사용자 삭제"/><br/>
</form>
</body>
</html>
