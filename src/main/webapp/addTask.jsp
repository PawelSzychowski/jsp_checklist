<%@ page import="javagda21.model.Status" %><%--
  Created by IntelliJ IDEA.
  User: macbookpawel
  Date: 2019-07-21
  Time: 15:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<h2>Dodaj checkliste</h2>

<jsp:include page="/header.jsp"></jsp:include>
<form action="/task/taskAdd" method="post">
    <input type="hidden" name="checklistId" value="<%=request.getAttribute("checklistId")%>">
    <select name="status">
        <%
            for(Status s:Status.values()){%>
        <option value="<%=s%>"><%=s%></option>
        <%
            }
        %>
    </select>
    </br>

    nazwa przedmiotu <input type="text"  name="name">
    </br>

    Czy Zrobione <input type="checkbox"  name="completed">
    </br>

    Opis <input type="text"  name="discription">
    </br>

    <input type="submit">
</form>
<body>

</body>
</html>
