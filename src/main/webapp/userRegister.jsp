<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta charset="UTF-8"/>
</head>
<body>
<h1>사용자 추가</h1>
<form method="post" action="/admin/userRegister.do">
  아이디: <input type="text" name="id" /><br />
  패스워드: <input type="password" name="pwd" /><br />
  이름: <input type="text" name="name" /><br />
  이미지파일: <input type="text" name="profileFileName" /><br />
  <input type="submit" value="사용자 등록"/><br/>
</form>
<a href="/userCheck.jsp">처음으로</a>
</body>
</html>
