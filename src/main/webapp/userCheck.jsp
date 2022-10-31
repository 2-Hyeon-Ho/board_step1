<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta charset="UTF-8"/>
</head>
<body>
<c:choose>
    <c:when test="${role eq \"user\"}">
        <h1>User 계정입니다.</h1>
        <ul>
            <li><a href="/boardList.jsp">게시물 목록</a></li>
            <li><a href="/boardRegister.jsp">게시물 등록</a> </li>
            <li><a href="/logout.do">로그아웃</a> </li>
        </ul>
    </c:when>

    <c:when test="${role eq \"admin\"}">
        <h1>Admin 계정입니다.</h1>
        <ul>
            <li><a href="/user/view.do">사용자 목록</a></li>
            <li><a href="/userRegister.jsp">사용자 추가</a> </li>
            <li><a href="/logout.do">로그아웃</a> </li>
        </ul>
    </c:when>
</c:choose>
</body>
</html>
