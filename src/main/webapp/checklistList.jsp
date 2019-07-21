<%@ page import="javagda21.model.Checklist" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: macbookpawel
  Date: 2019-07-21
  Time: 14:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Moje zadania</h2>

<jsp:include page="/header.jsp"></jsp:include>
<table>
    <tr>
        <th style="width: 150px">nazwa</th>
        <th style="width: 150px">data utworzenia</th>
        <th style="width: 150px">id</th>
        <th style="width: 150px">czy zarchiwizowana</th>
        <th style="width: 150px">Remove</th>
        <th style="width: 150px">Pokaz zadania</th>
        <th style="width: 150px">Dodaj zadania</th>
    </tr>
    <%
        List<Checklist> checklists = (List<Checklist>) request.getAttribute("checklistList");
        for (Checklist checklist : checklists) {
            out.println("<tr>");
            out.println("<td>" + checklist.getName() + "</td>");
            out.println("<td>" + checklist.getDataCreated() + "</td>");
            out.println("<td>" + checklist.getId() + "</td>");
            out.println("<td>" + checklist.isArchived() + "</td>");
            out.print("<td>" + "<a href=\"/checklist/remove?id=" + checklist.getId() + "\">" + "Remove</a>" + "</td>");
            out.print("<td>" + "<a href=\"/task/taskList?id=" + checklist.getId() + "\">" + " Pokaz zadania</a>" + "</td>");
            out.print("<td>" + "<a href=\"/task/taskAdd?id=" + checklist.getId() + "\">" + "Dodaj zadania</a>" + "</td>");
            out.println("</tr>");
        }

    %>
</table>

</body>
</html>
