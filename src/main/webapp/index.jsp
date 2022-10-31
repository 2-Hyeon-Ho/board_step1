<%--
  Created by IntelliJ IDEA.
  User: 2hyeonho
  Date: 2022/10/27
  Time: 9:20 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <body>
  <h1>
    현호's 게시판
  </h1>
  <form method="post" action="/login.do">
    <input type="text" name="id" /><br />
    <input type="password" name="pwd" /><br />
    <input type="submit" name="Login">
  </form>
  </body>
</html>
