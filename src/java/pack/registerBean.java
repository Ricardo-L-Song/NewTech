/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pack;

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
            Connection conn;
            PrintWriter out;
            ResultSet rs;
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
    public void init() throws ServletException {
        super.init(); //To change body of generated methods, choose Tools | Templates.
        conn=null;
        out=null;
        rs=null;
    }
        
     @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        super.doGet(request, response);
        }
    
    @Override
    public void destroy() {
        super.destroy(); //To change body of generated methods, choose Tools | Templates.
        try{
        conn.close();
        out.close();
        rs.close();
        }catch(SQLException se){
            out.println(se.toString());
        }
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
      out=response.getWriter();
//     int userId = Integer.parseInt(request.getParameter("username"));
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
          
        try{
        Class.forName("com.mysql.jdbc.Driver").newInstance(); 
        conn=DriverManager.getConnection("jdbc:mysql://localhost/mydb","root","SL886886");
        UserProfile vo=new UserProfile();
        vo.setUsername(username);
        vo.setPassword(password);
        vo.setFirstname(firstname);
        vo.setMiddlename(middlename);
        vo.setLastname(lastname);
        vo.setAddress1(address1);
        vo.setAddress2(address2);
        vo.setCity(city);
        vo.setState(state);
        vo.setPincode(pincode);
        vo.setEmail(email);
        vo.setPhone(phone);
        Boolean isSuccess=doCreate(vo);
      
//        if(userId==all.get(i).getUserId()&&password.equals(all.get(i).getUserPassword()))
//        out.println(all.get(i).getUserPassword());
         if(isSuccess==true)
        {
            
//               HttpSession session=request.getSession();
//             String usernameString=(String)session.getAttribute("username");
             response.sendRedirect("registersuccess.html");
        }else{
            out.println("注册失败");
          
        } 
        }catch(Exception e){
          e.printStackTrace();
        }
    }

   //查询全部数据 数据查询
        public boolean doCreate(UserProfile vo) throws Exception {//vo只是作为了一个媒介 要想理解此次操作 还是看pstmt.setXXX是用来增加数据的 对应数据库的操作
          PreparedStatement pstmt=null;
          String query=null;
            String sql = "INSERT INTO user_profile(username, password, firstname, middlename, lastname, address1, address2, city, state, pincode, email, phone) "  
	            + "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";  
        pstmt=conn.prepareStatement(sql);
        pstmt.setString(1, vo.getUsername());
        pstmt.setString(2, vo.getPassword());
        pstmt.setString(3, vo.getFirstname());
        pstmt.setString(4, vo.getMiddlename());
        pstmt.setString(5, vo.getLastname());
        pstmt.setString(6, vo.getAddress1());
        pstmt.setString(7, vo.getAddress2());
        pstmt.setString(8, vo.getCity());
        pstmt.setString(9, vo.getState());
        pstmt.setString(10, vo.getPincode());
        pstmt.setString(11, vo.getEmail());
        pstmt.setInt(12, vo.getPhone());
        
        return pstmt.executeUpdate()>0;//如果为真 就是执行了操作 返回true1 否则返回false0
    }
    
    }




