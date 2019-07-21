package javagda21.servlets;

import javagda21.database.DatabaseSession;
import javagda21.database.EntityDao;
import javagda21.model.Checklist;
import org.hibernate.Session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.text.html.parser.Entity;
import java.io.IOException;

@WebServlet("/checklist/add")
public class ChecklistAddServlet extends HttpServlet {
    EntityDao dao = new EntityDao();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/addChechlist.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        Checklist checklist = new Checklist();
        checklist.setName(name);
        dao.saveOrUpdate(checklist);
        resp.sendRedirect("/checklist/add");
    }
}
