/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

 import java.sql.Connection;
  import java.sql.DriverManager;
  import java.sql.PreparedStatement;
  import java.sql.ResultSet;
  import java.sql.SQLException;
/**
 *
 * @author sl
 */
public class BaseDao {
     private static String driver="com.mysql.jdbc.Driver";
      private static String url="jdbc:mysql://localhost/mydb";
      private static String user="root";
     private static String password="SL886886";
     
      /***
 22      * 连接数据库的方法
 23      * @return
 24      * @throws ClassNotFoundException
 25      * @throws SQLException
 26      */
     public static Connection getCon() throws ClassNotFoundException, SQLException{
          Class.forName(driver);//加载数据库驱动
          System.out.println("测试加载数据库成功");
        Connection con=DriverManager.getConnection(url, user, password);
         System.out.println("测试数据库链接成功");
         return con;
     }
  
     /***
 36      * 关闭数据库的方法
 37      * @param con
 38      * @param ps
 39      * @param rs
 40      */
      public static void close(Connection con,PreparedStatement ps,ResultSet rs){
         if(rs!=null){//关闭资源，避免出现异常
             try {
                 rs.close();
             } catch (SQLException e) {
                 // TODO Auto-generated catch block
                 e.printStackTrace();
              }
         }
         if(ps!=null){
             try {
                 ps.close();
             } catch (SQLException e) {
                 // TODO Auto-generated catch block
                  e.printStackTrace();
              }
         }
          if(con!=null){
             try {
                 con.close();
             } catch (SQLException e) {
                 // TODO Auto-generated catch block
                 e.printStackTrace();
              }
         }
      }
      
      /***
 69      * 同意增删改的方法
 70      * @param sql
 71      * @param arr
 72      * @return
 73      */
      public static boolean addUpdateDelete(String sql,Object[] arr){
          Connection con=null;
          PreparedStatement ps=null;
          try {
              con=BaseDao.getCon();//第一步 ：连接数据库的操作
             ps=con.prepareStatement(sql);//第二步：预编译
              //第三步：设置值
              if(arr!=null && arr.length!=0){
                  for(int i=0;i<arr.length;i++){
                      ps.setObject(i+1, arr[i]);
                  }
              }
              int count=ps.executeUpdate();//第四步：执行sql语句
              if(count>0){
                 return true;
              }else{
                  return false;
              }
          } catch (ClassNotFoundException e) {
              // TODO Auto-generated catch block
              e.printStackTrace();
          } catch (SQLException e) {
              // TODO Auto-generated catch block
              e.printStackTrace();
          }
          return false;
     }
     
     public static void main(String[] args) {
         try {
             BaseDao.getCon();
         } catch (ClassNotFoundException e) {
             // TODO Auto-generated catch block
             e.printStackTrace();
         } catch (SQLException e) {
             // TODO Auto-generated catch block
             e.printStackTrace();
         }
     }
}
