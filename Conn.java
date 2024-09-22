package Controller;

import Model.Dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.xml.ws.Response;

public class Conn {

    public static Connection connection() {

        Connection con = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tododb", "root", "");
        } catch (Exception e) {
            System.out.println(e);
        }

        return con;
    }

    public static int insert(Dao obj) {
        int i = 0;

        try {
            Connection con = Conn.connection();
            PreparedStatement ps = con.prepareStatement("insert into tasks (description,status)values(?,?)");

            ps.setString(1, obj.getDescription());
            ps.setBoolean(2, obj.getStatus());

            i = ps.executeUpdate();
            System.out.println("Task is added successfully:" + i);
        } catch (Exception e) {
            System.out.println(e);
        }

        return i;
    }

    public static List<Dao> getallTasks() {
        List<Dao> list = new ArrayList<Dao>();

        try {
            Connection con = Conn.connection();
            PreparedStatement ps = con.prepareStatement("select * from tasks");

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Dao e = new Dao();

                e.setId(rs.getInt(1));
                e.setDescription(rs.getString(2));
                e.setStatus(rs.getBoolean(3));

                list.add(e);
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }

        return list;
    }
    public static Dao getId(int id){
        Dao e=new Dao();
        
        try{
            Connection con=Conn.connection();
            PreparedStatement ps=con.prepareStatement("select * from tasks where id=?");
            
            ps.setInt(1, id);
            ResultSet rs=ps.executeQuery();
            
            while(rs.next()){
                e.setId(rs.getInt(1));
                e.setDescription(rs.getString(2));
                e.setStatus(rs.getBoolean(3));
            }
        }
        catch(Exception e2){
            System.out.println(e2);
        }
        
        return e;
    }
    public static int update(Dao e){
        int s=0;
        
        try{
            Connection con=Conn.connection();
            PreparedStatement ps=con.prepareStatement("update tasks set description=? where id=?");
            
            ps.setString(1, e.getDescription());
            ps.setInt(2, e.getId());
            
            s=ps.executeUpdate();
            con.close();
        }
        catch(Exception e3){
            System.out.println(e3);
        }
        
        return s;
    }
    public static int delete(int id){
        int s=0;
        
        try{
            Connection con=Conn.connection();
            PreparedStatement ps=con.prepareStatement("delete from tasks where id=?");
            
            ps.setInt(1, id);
            s=ps.executeUpdate();
            con.close();
        }
        catch(Exception e4){
            System.out.println(e4);
        }
        
        return s;
    }
    public static int status(int id){
        int s=0;
        
        try{
            Connection con=Conn.connection();
            PreparedStatement ps=con.prepareStatement("update tasks set status=True where id=?");
            
            ps.setInt(1, id);
           s= ps.executeUpdate();
            
            
            con.close();
       
        }
        catch(Exception e4){
            System.out.println(e4);
        }
        return s;
    }
}
