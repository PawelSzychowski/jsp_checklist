package javagda21.servlets;

import javagda21.database.EntityDao;
import javagda21.model.Checklist;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@WebServlet("/task/taskList")
public class TaskListServlet extends HttpServlet {
    EntityDao entityDao = new EntityDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");

        if (id != null) {
            Optional<Checklist> checklist = entityDao.findById(Checklist.class, Long.parseLong(id));
            if (checklist.isPresent()) {
                req.setAttribute("checklistList", checklist.get().getChecklistItems());
            } else {
                System.err.println("nie udało sie odnalezc zadan");
            }

        }
        req.getRequestDispatcher("/taskList.jsp").forward(req, resp);
    }
}

