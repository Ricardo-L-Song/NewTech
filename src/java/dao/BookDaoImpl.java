/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import pack.BookDetails;
import util.BaseDao;

/**
 *
 * @author sl
 */
public class BookDaoImpl implements BookDao{
     @Override
     public List<BookDetails> select(String sql, Object[] arr) {
          Connection con=null;
          PreparedStatement ps=null;
         ResultSet rs=null;
          try {
              con=BaseDao.getCon();//第一步连接数据库
              ps=con.prepareStatement(sql);//第二步：预编译
              if(arr!=null){
                  for(int i=0;i<arr.length;i++){
                      ps.setObject(i+1, arr[i]);
                  }
              }
              //第四步执行sql
              rs=ps.executeQuery();
              List<BookDetails> list=new ArrayList<BookDetails>();
              while(rs.next()){
                  BookDetails book=new BookDetails();
                  book.setBookId(rs.getInt("book_id"));
                  book.setTitle(rs.getString("title"));
                  book.setAuthor(rs.getString("author"));
                  book.setPublisher(rs.getString("publisher"));
                  book.setIsbn(rs.getString("isbn"));
                  book.setPrice(rs.getInt("price"));
                  book.setPic(rs.getString("pic"));
                  book.setCategoryName("category_name");
                  list.add(book);
              }
              return list;
          } catch (ClassNotFoundException e) {
              // TODO Auto-generated catch block
              e.printStackTrace();
          } catch (SQLException e) {
              // TODO Auto-generated catch block
              e.printStackTrace();
          }finally{
              //关闭资源，避免出现异常
              BaseDao.close(con, ps, rs);
          }
          
          return null;
      }
     
  //根据书的ID查找书本
      @Override
      public BookDetails getBook(Integer id) {
          Connection con=null;
          PreparedStatement ps=null;
          ResultSet rs=null;
          try {
              con=BaseDao.getCon();//第一步连接数据库
              String sql="select * from book_details where book_id = ? ";
              ps=con.prepareStatement(sql);//第二步：预编译
              ps.setInt(1, id);
              
              //第四步执行sql
              rs=ps.executeQuery();
              while(rs.next()){
                  BookDetails books=new BookDetails();
                  books.setBookId(rs.getInt("book_id"));
                  books.setTitle(rs.getString("title"));
                  books.setAuthor(rs.getString("author"));
                  books.setPublisher(rs.getString("publisher"));
                  books.setIsbn(rs.getString("isbn"));
                  books.setPrice(rs.getInt("price"));
                  books.setPic(rs.getString("pic"));
                   books.setCategoryName("category_name");
                  return books;
              }
          } catch (ClassNotFoundException e) {
              // TODO Auto-generated catch block
              e.printStackTrace();
          } catch (SQLException e) {
              // TODO Auto-generated catch block
              e.printStackTrace();
          }finally{
              //关闭资源，避免出现异常
              BaseDao.close(con, ps, rs);
         }
          
          return null;
      }
//根据书的类型查找书本
    @Override
    public List<BookDetails> getBooks(String category) {
       Connection con=null;
          PreparedStatement ps=null;
          ResultSet rs=null;
          try {
              con=BaseDao.getCon();//第一步连接数据库
              String sql="select * from book_details where category_name = ? ";
              ps=con.prepareStatement(sql);//第二步：预编译
              ps.setString(1, category);
              
              //第四步执行sql
              rs=ps.executeQuery();
               List<BookDetails> list=new ArrayList<BookDetails>();
              while(rs.next()){
                  BookDetails books=new BookDetails();
                  books.setBookId(rs.getInt("book_id"));
                  books.setTitle(rs.getString("title"));
                  books.setAuthor(rs.getString("author"));
                  books.setPublisher(rs.getString("publisher"));
                  books.setIsbn(rs.getString("isbn"));
                  books.setPrice(rs.getInt("price"));
                  books.setPic(rs.getString("pic"));
                   books.setCategoryName("category_name");
                  list.add(books);
              }
              return list;
          } catch (ClassNotFoundException e) {
              // TODO Auto-generated catch block
              e.printStackTrace();
          } catch (SQLException e) {
              // TODO Auto-generated catch block
              e.printStackTrace();
          }finally{
              //关闭资源，避免出现异常
              BaseDao.close(con, ps, rs);
         }
          
          return null;

    }

    @Override
    public List<BookDetails> queryAll() {
           Connection con=null;
          PreparedStatement ps=null;
          ResultSet rs=null;
          try {
              con=BaseDao.getCon();//第一步连接数据库
              String sql="select * from book_details";
              ps=con.prepareStatement(sql);//第二步：预编译
             
              
              //第四步执行sql
              rs=ps.executeQuery();
             List<BookDetails> list=new ArrayList<BookDetails>();
              while(rs.next()){
                  BookDetails books=new BookDetails();
                  books.setBookId(rs.getInt("book_id"));
                  books.setTitle(rs.getString("title"));
                  books.setAuthor(rs.getString("author"));
                  books.setPublisher(rs.getString("publisher"));
                  books.setIsbn(rs.getString("isbn"));
                  books.setPrice(rs.getInt("price"));
                  books.setPic(rs.getString("pic"));
                   books.setCategoryName("category_name");
                  list.add(books);
              }
              return list;
          } catch (ClassNotFoundException e) {
              // TODO Auto-generated catch block
              e.printStackTrace();
          } catch (SQLException e) {
              // TODO Auto-generated catch block
              e.printStackTrace();
          }finally{
              //关闭资源，避免出现异常
              BaseDao.close(con, ps, rs);
         }
          
          return null;
    }
      
    
      
}
