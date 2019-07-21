package javagda21.servlets;

import javafx.concurrent.Task;
import javagda21.database.EntityDao;
import javagda21.model.Checklist;
import javagda21.model.ChecklistItem;
import javagda21.model.Status;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@WebServlet("/task/taskAdd")
public class AddTaskServlet extends HttpServlet {
    EntityDao entityDao = new EntityDao();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String checklistId = req.getParameter("id");
        req.setAttribute("checklistId", checklistId);
        req.getRequestDispatcher("/addTask.jsp").forward(req,resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String checklistId = req.getParameter("checklistId");
        Optional<Checklist> checklist = entityDao.findById(Checklist.class,Long.parseLong(checklistId));
        if(checklist.isPresent()){
            ChecklistItem checklistItem = new ChecklistItem();
            checklistItem.setCompleted(req.getParameter("toCorrect") == null ? false : req.getParameter("toCorrect").equalsIgnoreCase("on"));
            checklistItem.setName(req.getParameter("name"));
            checklistItem.setDiscription(req.getParameter("discription"));
            checklistItem.setStatus(Status.valueOf(req.getParameter("status")));
            checklistItem.setChecklist(checklist.get());
            entityDao.saveOrUpdate(checklistItem);
            checklist.get().getChecklistItems().add(checklistItem);
            entityDao.saveOrUpdate(checklist.get());

        }
        resp.sendRedirect("/task/taskAdd?id="+checklistId);
    }
}
