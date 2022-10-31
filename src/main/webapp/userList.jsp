<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8"/>
</head>
<body>
<!--가입한 사용자들이 나오고 사용자를 클릭하면 정보 수정과 삭제가 가능하도록 구현-->
<h1>사용자 목록</h1>
아이디: ${userId}<br/>
프로필이미지: ${userProfileFileName}<br/>
<br/>
<a href="/modifyUser.jsp">사용자 정보 수정</a><br/>
<a href="/removeUser.jsp">사용자 삭제</a><br/>
<a href="/userCheck.jsp">처음으로</a>
</body>
</html>
