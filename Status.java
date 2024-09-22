
package View;

import Controller.Conn;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Status extends HttpServlet{
    
    public void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
        
        res.setContentType("text/html");
        PrintWriter out= res.getWriter();
        
        int id=Integer.parseInt(req.getParameter("id"));
        int s=Conn.status(id);
        
        if (s > 0) {
            out.print("<center><h2>Task status updated successfully</h2></center>"+"<br><br>");
            out.print("<center><a href='web2'>Show tasks</a></center>");
        } else {
            out.print("<center><h2>Failed to update task status</h2></center>"+"<br><br>");
            out.print("<center><a href='web2'>Try again</a></center>");
        }
        out.close();
    }
}
