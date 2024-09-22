
package View;

import Controller.Conn;
import Model.Dao;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class edit1 extends HttpServlet{
    
    public void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
        
        res.setContentType("text/html");
        PrintWriter out=res.getWriter();
        
        int id=Integer.parseInt(req.getParameter("id"));
        String d=req.getParameter("description");
        
        Dao e=new Dao();
        e.setId(id);
        e.setDescription(d);
        
        int s=Conn.update(e);
        
        if(s>0){
            out.print("<center></h2>Tasks are updated</h2></center>"+"<br><br>");
            out.print("<center><a href='web2'>show tasks</a></center>");
        }
        else{
            System.out.println("<center><h2>Tasks are not updated</h2></center>");
        }
            
    }
}
