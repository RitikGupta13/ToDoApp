package View;

import Controller.Conn;
import Model.Dao;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Showtasks extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        
        out.println("<html><head><title>Show Tasks</title>");
        out.println("<link rel='stylesheet' type='text/css' href='style.css'></head><body>");
        out.println("<div class='container'>");

        out.print("<h1>Details of Added Tasks</h1>");

        List<Dao> li = Conn.getallTasks();

        out.print("<table>");
        out.print("<tr><th>Id</th><th>Description</th><th>Status</th><th>Edit</th><th>Delete</th><th>Result</th></tr>");

        for (Dao e : li) {
            out.print("<tr>");
            out.print("<td>" + e.getId() + "</td><td>" + e.getDescription() + "</td><td>" + (e.getStatus() ? "Completed" : "Pending") + "</td><td><a href='update?id=" + e.getId() + "'>update</a></td><td><a href='delete?id=" + e.getId() + "'>delete</a></td>");
            if (!e.getStatus()) {
                out.print("<td><a href='status?id=" + e.getId() + "'>Mark as Completed</a></td>");
            } else {
                out.print("<td>Completed</td>");
            }
            out.print("</tr>");
        }
        out.print("</table>");
        out.println("<div class='add-new-task'><a href='index.html'>Add new task</a></div>");
        out.print("</div></body></html>");
        out.close();
    }
}
