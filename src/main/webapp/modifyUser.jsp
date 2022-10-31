<%--
  Created by IntelliJ IDEA.
  User: 2hyeonho
  Date: 2022/10/29
  Time: 11:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8"/>
</head>
<body>
<h1>사용자 정보 수정</h1>
<form method="post" action="/admin/userModify.do">
    아이디: <input type="text" placeholder="변경할 아이디" name="modifyId" /><br />
    패스워드: <input type="password" placeholder="새로운 패스워드" name="pwd" /><br />
    이름: <input type="text" placeholder="새로운 이름" name="name" /><br />
    이미지파일: <input type="text" placeholder="새로운 이미지파일" name="profileFileName" /><br />
    <input type="submit" value="사용자 변경"/><br/>
</form>
</body>
</html>
