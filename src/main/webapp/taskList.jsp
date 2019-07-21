<%@ page import="javagda21.model.ChecklistItem" %>
<%@ page import="java.util.List" %>
<%@ page import="javagda21.model.Checklist" %><%--
  Created by IntelliJ IDEA.
  User: macbookpawel
  Date: 2019-07-21
  Time: 15:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<jsp:include page="/header.jsp"></jsp:include>
<table>
    <tr>
        <th style="width: 150px">nazwa</th>
        <th style="width: 150px">opis</th>
        <th style="width: 150px">id</th>
        <th style="width: 150px">status</th>
        <th style="width: 150px">usun</th>
        <th style="width: 150px">Edytuj</th>
    </tr>
    <%String name = "";
        List<ChecklistItem> checklistItems = (List<ChecklistItem>) request.getAttribute("checklistList");
        for (ChecklistItem checklist : checklistItems) {
            out.println("<tr>");
            out.println("<td>" + checklist.getName() + "</td>");
            out.println("<td>" + checklist.getDiscription() + "</td>");
            out.println("<td>" + checklist.getId() + "</td>");
            out.println("<td>" + checklist.getStatus() + "</td>");
            out.print("<td>" + "<a href=\"/checklist/remove?id=" + checklist.getId() + "\">" + "usun</a>" + "</td>");
            out.print("<td>" + "<a href=\"/checklist/taskList?id=" + checklist.getId() + "\">" + " edytuj</a>" + "</td>");
            out.println("</tr>");
            name = checklist.getChecklist().getName();
        }

    %>
</table>
<h2><%=name%></h2>
</body>
</html>
