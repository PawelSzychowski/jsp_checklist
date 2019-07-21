<%--
  Created by IntelliJ IDEA.
  User: macbookpawel
  Date: 2019-07-21
  Time: 14:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Dodaj checkliste</h2>

<jsp:include page="/header.jsp"></jsp:include>

<form action="/checklist/add" method="post">
    <input type="text" name="name">
    </br>
    <input type="submit">
</form>
</body>
</html>
