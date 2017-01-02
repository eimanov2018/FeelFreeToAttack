package Server;

import java.io.IOException;
import java.io.ObjectOutputStream;
import static java.lang.System.out;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Login extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");

        ObjectOutputStream out = new ObjectOutputStream(response.getOutputStream());
        String n = request.getParameter("name");
        String p = request.getParameter("pass");
        System.out.println(n);
        System.out.println(p);

        if (validate(n, p)) {
            response.sendRedirect("/FeelFreeToAttack/success.jsp");
        } else {
            out.writeObject("Sorry username or password error");
        }
        out.close();
    }

    public static boolean validate(String name, String pass) {
        boolean status = false;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = (com.mysql.jdbc.Connection) DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/Web", "root", "root");

//        PreparedStatement ps=con.prepareStatement(    
//              "select * from javatpoint_user where name=? and password=?");    
            Statement st = con.createStatement();
            String query = "select * from javatpoint_user where name='" + name + "' and password='" + pass + "'";
            ResultSet rs = st.executeQuery(query);

//          ps.setString(1,name);    
//          ps.setString(2,pass);    
            //ResultSet rs=ps.executeQuery();    
            status = rs.next();
        } catch (Exception e) {
            System.out.println(e);
        }
        return status;
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);

    }
}
