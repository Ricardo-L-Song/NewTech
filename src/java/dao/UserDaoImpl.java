/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import pack.UserProfile;
import util.BaseDao;

/**
 *
 * @author sl
 */
public class UserDaoImpl implements UserDao{
    //数据库的连接都要try catch 不同的是 查询的方法要在数据层DAO层写 增删改则可以借助工具类中 封装好的try catch
    //回调方法 登陆
    @Override
    public UserProfile login(UserProfile user) {//传入一个有用户名和密码的对象 如果查询到了 就返回 没有对象为null
           Connection connection=null;//数据库连接类
           PreparedStatement ps=null;//执行sql语句
           ResultSet rs=null;//返回的结果
           try {
                //1.获取数据库连接
            connection=BaseDao.getCon();
                //2.书写sql语句
                String sql="SELECT * FROM user_profile WHERE username=? AND password=?";
                //3.预编译
                ps=connection.prepareStatement(sql);
                //4.设置查询条件
                ps.setString(1, user.getUsername());
                ps.setString(2, user.getPassword());
                //5.执行sql语句 返回结果集
                rs=ps.executeQuery();
                UserProfile users=null;
                if(rs.next()){
                //数据库返回的数据与vo类进行交互
                users=new UserProfile();
                users.setUsername(rs.getString("username"));
                users.setPassword(rs.getString("password"));
                users.setPhone(rs.getInt("phone"));
                //....还有一些值
                return users;
                }else{
                return  null;
                }
            
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
               //关闭资源 避免出现异常
               BaseDao.close(connection, ps, rs);
           }
           return null;
    }

    //回调方法 注册
    @Override
    public boolean register(UserProfile user) {
         String sql = "INSERT INTO user_profile(username, password, firstname, middlename, lastname, address1, address2, city, state, pincode, email, phone) "  
	            + "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";  
          List<Object> list=new ArrayList<Object>();
         list.add(user.getUsername());
         list.add(user.getPassword());
          list.add(user.getFirstname());
         list.add(user.getMiddlename());
          list.add(user.getLastname());
          list.add(user.getAddress1());
          list.add(user.getAddress2());
          list.add(user.getCity());
          list.add(user.getState());
          list.add(user.getPincode());
          list.add(user.getEmail());
          list.add(user.getPhone());
         boolean flag=BaseDao.addUpdateDelete(sql,list.toArray());
         if(flag){
             return true;
          }else{
              return false;
          }
    }

    @Override
    public List<UserProfile> selectUser(String sql, Object[] arr) {
//这个是还要在业务层调用的 上面两个方法直接可以进行数据层和JSP的交互 由于我们这里不需要根据名字什么的来查询对象
      //所以这里就不写了  
      return null;
    }
    
}
