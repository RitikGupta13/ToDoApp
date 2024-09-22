
package View;

import Controller.Conn;
import Model.Dao;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class edit extends HttpServlet{
    public void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
        
        res.setContentType("text/html");
        PrintWriter out=res.getWriter();
        
       int id= Integer.parseInt(req.getParameter("id"));
        Dao e=Conn.getId(id);
        
        out.print("<html><head><title>Edit Task</title>");
        out.print("<link rel='stylesheet' type='text/css' href='style.css'></head><body>");
        out.print("<div class='container'>");
        out.print("<h1>Edit Task</h1>");
        out.print("<form action='updat'>");
        out.print("<table>");
        out.print("<tr><td>Id</td><td><input type='text' name='id' value='"+e.getId()+"'readonly></td></tr>");
        out.print("<tr><td>Task</td><td><input type='text' name='description' value='"+e.getDescription()+"' size='50'></td></tr>");
        out.print("<tr><td colspan='2'><input type='submit' value='update'></td></tr>");
        out.print("</table>");
        out.print("</form>");
        out.print("</div></body></html>");
        out.close();
    }
}
