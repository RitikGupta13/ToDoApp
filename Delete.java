
package View;

import Controller.Conn;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Delete extends HttpServlet{
    
    public void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
        
        res.setContentType("text/html");
        PrintWriter out=res.getWriter();
        
        int id=Integer.parseInt(req.getParameter("id"));
        int s=Conn.delete(id);
        
        if(s>0){
            out.print("<center><h2>Data is deleted</h2></center>"+"<br><br>");
            out.print("<center><a href='web2'>Show tasks</a></center>");
        }
        else{
            System.out.println("<center><h2>Tasks are not deleted</h2></center>");
        }
    }
}
