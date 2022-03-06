<%--
  Created by IntelliJ IDEA.
  User: on-off
  Date: 06.03.2022
  Time: 23:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<c:forEach var="polls" items="${requestScope.get('poll')}">
   <ul><li><a href="beginPoll.jsp"><c:out value="${polls.name}" /></a></li></ul>
</c:forEach>
</body>
</html>
