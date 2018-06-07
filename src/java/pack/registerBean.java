/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pack;

import dao.UserDao;
import dao.UserDaoImpl;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
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
public class registerBean extends HttpServlet {

            String username;
            String password;
            String firstname;
            String middlename;
            String lastname;
            String address1;
            String address2;
            String city;
            String state;
            String pincode;
            String email;
            int phone;

        
     @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        super.doGet(request, response);
        }
    


    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override   
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //405错误这里 不要加super
        response.setContentType("text/html;charset=UTF-8");


//获取register的JSP页面提交的数据
       username= request.getParameter("username");
       password=request.getParameter("password");
         firstname=request.getParameter("firstname");
         middlename=request.getParameter("middlename");
         lastname=request.getParameter("lastname");
         address1=request.getParameter("address1");
         address2=request.getParameter("address2");
         city=request.getParameter("city");
         state=request.getParameter("state");
         pincode=request.getParameter("pincode");
           email=request.getParameter("email");
           try {
             phone=Integer.parseInt(request.getParameter("phone"));//这个int类型的需要加try catch
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
          
           UserProfile user=new UserProfile();
           //将数据与VO类进行交互
           user.setUsername(username);
        user.setPassword(password);
        user.setFirstname(firstname);
        user.setMiddlename(middlename);
        user.setLastname(lastname);
        user.setAddress1(address1);
        user.setAddress2(address2);
        user.setCity(city);
        user.setState(state);
        user.setPincode(pincode);
        user.setEmail(email);
        user.setPhone(phone);
           //与数据层进行交互
           UserDao dao=new UserDaoImpl();
         boolean flag=dao.register(user);
         if(flag){
        response.sendRedirect("registersuccess.html");
     }else{
         response.sendRedirect("register.jsp");
    }

    }

    
    }




