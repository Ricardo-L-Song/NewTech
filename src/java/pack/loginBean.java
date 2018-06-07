package pack;

import dao.UserDao;
import dao.UserDaoImpl;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import pack.UserProfile;

/**
 *
 * @author sl
 */
public class loginBean extends HttpServlet {

        
     @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

//     int userId = Integer.parseInt(request.getParameter("username"));
      String userId = request.getParameter("username");
      String password=request.getParameter("password");
      UserProfile user=new UserProfile();
      user.setUsername(userId);
      user.setPassword(password);
      
      //与VO层进行交互
      UserDao dao=new UserDaoImpl();
      UserProfile userBack=dao.login(user);
      if(userBack!=null){
      HttpSession session=request.getSession();
          session.setAttribute("username",userBack.getUsername());
          response.sendRedirect("selectcategory.jsp");
      }else if(userBack==null){
      response.sendRedirect("faillogin.html");
      }

        }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp); //To change body of generated methods, choose Tools | Templates.
    }


    
    }









