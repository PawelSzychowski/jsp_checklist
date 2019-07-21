package javagda21.servlets;

import javagda21.database.EntityDao;
import javagda21.model.Checklist;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/checklist/remove")
public class ChecklistRemoveServlet extends HttpServlet {
    EntityDao dao = new EntityDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long position = Long.parseLong(req.getParameter("id"));
        dao.removeById(Checklist.class,position);
        resp.sendRedirect("/checklist/list");
    }
}
