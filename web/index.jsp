<%@ page import="model.Poll" %>
<%@ page import="java.util.List" %><%--

  Created by IntelliJ IDEA.
  User: on-off
  Date: 05.03.2022
  Time: 14:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <% List<Poll> polls = (List<Poll>) request.getAttribute("poll");%>

  <a href="/poll">Poll page</a>
  </body>
</html>
