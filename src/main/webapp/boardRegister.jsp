<%--
  Created by IntelliJ IDEA.
  User: 2hyeonho
  Date: 2022/10/27
  Time: 5:36 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8"/>
</head>
<body>
<!--게시물 등록을 할 수 있는 텍스트박스와 텍스트박스의 내용을 전송해서 등록하는 기능-->
<h1>게시물 등록</h1>
<form method="post" action="/user/boardRegister.do">
    제목: <input type="text" name="title" /><br />
    내용: <textarea name="content" cols="30" rows="5"></textarea><br />
    <input type="submit" value="게시물 등록" />
</form>
</body>
</html>
