
package View;

import Controller.Conn;
import Model.Dao;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Insert extends HttpServlet{
    public void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
        
        res.setContentType("text/html");
        PrintWriter out=res.getWriter();
        
       String d= req.getParameter("description");
       boolean status=false;
        Dao obj=new Dao();
        obj.setDescription(d);
        obj.setStatus(status);
        
        int i=Conn.insert(obj);
        
        if(i>0){
            out.print("<center><h2>Your task is added successfully</h2></center>"+"<br><br>");
            out.print("<center><a href='index.html'>Add more task</a></center>");
        }
        
        else{
            System.out.println("<center><h2>Your task is not added</h2></center>");
        }
        
        out.close();
    }
    
}
