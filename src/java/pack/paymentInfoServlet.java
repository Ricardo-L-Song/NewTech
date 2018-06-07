
package pack;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import pack.Payment;

public class paymentInfoServlet extends HttpServlet {
            Connection conn;
            PrintWriter out;
            ResultSet rs;
            Boolean isUserBoolean;

    @Override
    public void init() throws ServletException {
        super.init(); //To change body of generated methods, choose Tools | Templates.
        conn=null;
        out=null;
        rs=null;
        isUserBoolean=Boolean.FALSE;
    }
        
     @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
      out=response.getWriter();
//     int userId = Integer.parseInt(request.getParameter("username"));
        int num = Integer.parseInt(request.getParameter("creditcard_num"));
     int type=Integer.parseInt(request.getParameter("creditcard_type"));
        try{
        Class.forName("com.mysql.jdbc.Driver").newInstance(); 
        conn=DriverManager.getConnection("jdbc:mysql://localhost/mydb","***","****");
        List<Payment> all=new ArrayList<Payment>();
        all=findAll();
                out.println(num);
                out.println(type);
        for(int i = 0 ; i < all.size() ; i++) {//我们只需要知道 有没有这个用户名和密码的用户存在 改变boolean值 而不需要知道所有的匹配方式
//        if(userId==all.get(i).getUserId()&&password.equals(all.get(i).getUserPassword()))
//        out.println(all.get(i).getUserPassword());

        out.println(all.get(i).getCreditcardNum());
        
        
        out.println(all.get(i).getCreditcardType());
         if(num==all.get(i).getCreditcardNum()&&type==all.get(i).getCreditcardType())
        {
            isUserBoolean=true;
//            out.println("登陆成功");
        }
//         else{
//            out.println("登陆失败");
//        }
      }//循环结束就为真
        }catch(Exception e){
          e.printStackTrace();
        }
        if(isUserBoolean==Boolean.TRUE){
//            out.println("登陆成功");
            HttpSession session=request.getSession();
            session.setAttribute("creditcard_num",num );
            response.sendRedirect("success.html");
        }else if(isUserBoolean==Boolean.FALSE){
//            out.println("登陆失败");
             response.sendRedirect("fail.html");
        }
        isUserBoolean=Boolean.FALSE;//这里不要忘记重新置空 destroy中置空无用 因为页面没有被销毁
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

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp); //To change body of generated methods, choose Tools | Templates.
    }

   //查询全部数据 数据查询
    public List<Payment> findAll() throws Exception {
                PreparedStatement pstmt=null;
                String query=null;
                List<Payment> all=new ArrayList<Payment>();
                query="SELECT creditcard_num,creditcard_type FROM payment";
                pstmt=this.conn.prepareStatement(query);
                ResultSet rs=pstmt.executeQuery();//对数据库进行查询 有结果返回
                while(rs.next()){//逐行读数据 虽然只有一行
                    Payment vo=new Payment();;
                vo.setCreditcardNum(rs.getInt(1));//逐列读出
                vo.setCreditcardType(rs.getInt(2));
                all.add(vo);//将从数据库返回的数据保存在底层媒介后 往泛型集合中加一个实例化对象
        }
                return all;
    }
    
    }
