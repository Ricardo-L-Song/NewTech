# NewTech
最近期末的JSP要交大作业，我选择的是做一个在线购物书店,实现登陆注册购物车结算的功能。

### 一.项目总览以及使用的JS组件框架:
![捕获.JPG](https://upload-images.jianshu.io/upload_images/9003228-eb73c93fb99b7ad5.JPG?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)
根据项目结构 知道用的是DAO设计模式，然后使用了[JS组件库SUI](http://sui.taobao.org/sui/docs/index.html),然后看看项目完成以后大概是这样.
**引导页**
![引导页.gif](https://upload-images.jianshu.io/upload_images/9003228-2c8177a30df56cc3.gif?imageMogr2/auto-orient/strip)

**注册**
![注册.gif](https://upload-images.jianshu.io/upload_images/9003228-ef9167e9270d0b1e.gif?imageMogr2/auto-orient/strip)

**登陆**
![登陆.gif](https://upload-images.jianshu.io/upload_images/9003228-cc55447a17154c94.gif?imageMogr2/auto-orient/strip)

**图书列表**
![图书列表 (1).gif](https://upload-images.jianshu.io/upload_images/9003228-7613acec257c87a9.gif?imageMogr2/auto-orient/strip)

**图书详情以及购物车**
![图书详情以及购物车.gif](https://upload-images.jianshu.io/upload_images/9003228-3b45a516fcd7f910.gif?imageMogr2/auto-orient/strip)

**结算**
![结算.gif](https://upload-images.jianshu.io/upload_images/9003228-4e244230f2e8d213.gif?imageMogr2/auto-orient/strip)

### 二.数据库设计以及代码实现
user_profile表:实现登陆注册
![user_profile表.JPG](https://upload-images.jianshu.io/upload_images/9003228-b86e81e9596f2b6c.JPG?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

book_details表:实现图书列表以及图书详情
![book_details表.JPG](https://upload-images.jianshu.io/upload_images/9003228-2198d9083f5818c7.JPG?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

payment表:实现结算
![payment表.JPG](https://upload-images.jianshu.io/upload_images/9003228-aa3f7666565162b2.JPG?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

然后是代码:首先是根据数据库表生成的实体类:
UserProfile:
```
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pack;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author sl
 */
@Entity
@Table(name = "user_profile")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UserProfile.findAll", query = "SELECT u FROM UserProfile u")
    , @NamedQuery(name = "UserProfile.findByIdUserProfile", query = "SELECT u FROM UserProfile u WHERE u.idUserProfile = :idUserProfile")
    , @NamedQuery(name = "UserProfile.findByUsername", query = "SELECT u FROM UserProfile u WHERE u.username = :username")
    , @NamedQuery(name = "UserProfile.findByPassword", query = "SELECT u FROM UserProfile u WHERE u.password = :password")
    , @NamedQuery(name = "UserProfile.findByFirstname", query = "SELECT u FROM UserProfile u WHERE u.firstname = :firstname")
    , @NamedQuery(name = "UserProfile.findByMiddlename", query = "SELECT u FROM UserProfile u WHERE u.middlename = :middlename")
    , @NamedQuery(name = "UserProfile.findByLastname", query = "SELECT u FROM UserProfile u WHERE u.lastname = :lastname")
    , @NamedQuery(name = "UserProfile.findByAddress1", query = "SELECT u FROM UserProfile u WHERE u.address1 = :address1")
    , @NamedQuery(name = "UserProfile.findByAddress2", query = "SELECT u FROM UserProfile u WHERE u.address2 = :address2")
    , @NamedQuery(name = "UserProfile.findByCity", query = "SELECT u FROM UserProfile u WHERE u.city = :city")
    , @NamedQuery(name = "UserProfile.findByState", query = "SELECT u FROM UserProfile u WHERE u.state = :state")
    , @NamedQuery(name = "UserProfile.findByPincode", query = "SELECT u FROM UserProfile u WHERE u.pincode = :pincode")
    , @NamedQuery(name = "UserProfile.findByEmail", query = "SELECT u FROM UserProfile u WHERE u.email = :email")
    , @NamedQuery(name = "UserProfile.findByPhone", query = "SELECT u FROM UserProfile u WHERE u.phone = :phone")})
public class UserProfile implements Serializable {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "username")
    private Collection<Payment> paymentCollection;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idUser_Profile")
    private Integer idUserProfile;
    @Basic(optional = false)
    @Column(name = "username")
    private String username;
    @Basic(optional = false)
    @Column(name = "password")
    private String password;
    @Basic(optional = false)
    @Column(name = "firstname")
    private String firstname;
    @Basic(optional = false)
    @Column(name = "middlename")
    private String middlename;
    @Basic(optional = false)
    @Column(name = "lastname")
    private String lastname;
    @Basic(optional = false)
    @Column(name = "address1")
    private String address1;
    @Basic(optional = false)
    @Column(name = "address2")
    private String address2;
    @Basic(optional = false)
    @Column(name = "city")
    private String city;
    @Basic(optional = false)
    @Column(name = "state")
    private String state;
    @Basic(optional = false)
    @Column(name = "pincode")
    private String pincode;
    @Basic(optional = false)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @Column(name = "phone")
    private int phone;

    public UserProfile() {
    }

    public UserProfile(Integer idUserProfile) {
        this.idUserProfile = idUserProfile;
    }

    public UserProfile(Integer idUserProfile, String username, String password, String firstname, String middlename, String lastname, String address1, String address2, String city, String state, String pincode, String email, int phone) {
        this.idUserProfile = idUserProfile;
        this.username = username;
        this.password = password;
        this.firstname = firstname;
        this.middlename = middlename;
        this.lastname = lastname;
        this.address1 = address1;
        this.address2 = address2;
        this.city = city;
        this.state = state;
        this.pincode = pincode;
        this.email = email;
        this.phone = phone;
    }

    public Integer getIdUserProfile() {
        return idUserProfile;
    }

    public void setIdUserProfile(Integer idUserProfile) {
        this.idUserProfile = idUserProfile;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getMiddlename() {
        return middlename;
    }

    public void setMiddlename(String middlename) {
        this.middlename = middlename;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUserProfile != null ? idUserProfile.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserProfile)) {
            return false;
        }
        UserProfile other = (UserProfile) object;
        if ((this.idUserProfile == null && other.idUserProfile != null) || (this.idUserProfile != null && !this.idUserProfile.equals(other.idUserProfile))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pack.UserProfile[ idUserProfile=" + idUserProfile + " ]";
    }

    @XmlTransient
    public Collection<Payment> getPaymentCollection() {
        return paymentCollection;
    }

    public void setPaymentCollection(Collection<Payment> paymentCollection) {
        this.paymentCollection = paymentCollection;
    }
    
}
```
BookDetails:
```
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pack;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author sl
 */
@Entity
@Table(name = "book_details")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BookDetails.findAll", query = "SELECT b FROM BookDetails b")
    , @NamedQuery(name = "BookDetails.findByIdBookDetails", query = "SELECT b FROM BookDetails b WHERE b.idBookDetails = :idBookDetails")
    , @NamedQuery(name = "BookDetails.findByCategoryName", query = "SELECT b FROM BookDetails b WHERE b.categoryName = :categoryName")
    , @NamedQuery(name = "BookDetails.findByBookId", query = "SELECT b FROM BookDetails b WHERE b.bookId = :bookId")
    , @NamedQuery(name = "BookDetails.findByTitle", query = "SELECT b FROM BookDetails b WHERE b.title = :title")
    , @NamedQuery(name = "BookDetails.findByAuthor", query = "SELECT b FROM BookDetails b WHERE b.author = :author")
    , @NamedQuery(name = "BookDetails.findByPublisher", query = "SELECT b FROM BookDetails b WHERE b.publisher = :publisher")
    , @NamedQuery(name = "BookDetails.findByIsbn", query = "SELECT b FROM BookDetails b WHERE b.isbn = :isbn")
    , @NamedQuery(name = "BookDetails.findByPrice", query = "SELECT b FROM BookDetails b WHERE b.price = :price")
    , @NamedQuery(name = "BookDetails.findByDescription", query = "SELECT b FROM BookDetails b WHERE b.description = :description")})
public class BookDetails implements Serializable {

    @Basic(optional = false)
    @Column(name = "pic")
    private String pic;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idBook_Details")
    private Integer idBookDetails;
    @Basic(optional = false)
    @Column(name = "category_name")
    private String categoryName;
    @Basic(optional = false)
    @Column(name = "book_id")
    private int bookId;
    @Basic(optional = false)
    @Column(name = "title")
    private String title;
    @Basic(optional = false)
    @Column(name = "author")
    private String author;
    @Basic(optional = false)
    @Column(name = "publisher")
    private String publisher;
    @Basic(optional = false)
    @Column(name = "isbn")
    private String isbn;
    @Basic(optional = false)
    @Column(name = "price")
    private int price;
    @Column(name = "description")
    private String description;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bookId")
    private Collection<BillTable> billTableCollection;

    public BookDetails() {
    }

    public BookDetails(Integer idBookDetails) {
        this.idBookDetails = idBookDetails;
    }

    public BookDetails(Integer idBookDetails, String categoryName, int bookId, String title, String author, String publisher, String isbn, int price) {
        this.idBookDetails = idBookDetails;
        this.categoryName = categoryName;
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.isbn = isbn;
        this.price = price;
    }

    public Integer getIdBookDetails() {
        return idBookDetails;
    }

    public void setIdBookDetails(Integer idBookDetails) {
        this.idBookDetails = idBookDetails;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @XmlTransient
    public Collection<BillTable> getBillTableCollection() {
        return billTableCollection;
    }

    public void setBillTableCollection(Collection<BillTable> billTableCollection) {
        this.billTableCollection = billTableCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idBookDetails != null ? idBookDetails.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BookDetails)) {
            return false;
        }
        BookDetails other = (BookDetails) object;
        if ((this.idBookDetails == null && other.idBookDetails != null) || (this.idBookDetails != null && !this.idBookDetails.equals(other.idBookDetails))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pack.BookDetails[ idBookDetails=" + idBookDetails + " ]";
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }
    
}

```
Payment:
```
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pack;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author sl
 */
@Entity
@Table(name = "payment")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Payment.findAll", query = "SELECT p FROM Payment p")
    , @NamedQuery(name = "Payment.findByIdPayment", query = "SELECT p FROM Payment p WHERE p.idPayment = :idPayment")
    , @NamedQuery(name = "Payment.findByTotalAmount", query = "SELECT p FROM Payment p WHERE p.totalAmount = :totalAmount")
    , @NamedQuery(name = "Payment.findByCreditcardNum", query = "SELECT p FROM Payment p WHERE p.creditcardNum = :creditcardNum")
    , @NamedQuery(name = "Payment.findByCreditcardType", query = "SELECT p FROM Payment p WHERE p.creditcardType = :creditcardType")})
public class Payment implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idPayment")
    private Integer idPayment;
    @Basic(optional = false)
    @Column(name = "total_amount")
    private int totalAmount;
    @Basic(optional = false)
    @Column(name = "creditcard_num")
    private int creditcardNum;
    @Basic(optional = false)
    @Column(name = "creditcard_type")
    private int creditcardType;
    @JoinColumn(name = "bill_num", referencedColumnName = "bill_num")
    @ManyToOne(optional = false)
    private BillTable billNum;
    @JoinColumn(name = "username", referencedColumnName = "username")
    @ManyToOne(optional = false)
    private UserProfile username;

    public Payment() {
    }

    public Payment(Integer idPayment) {
        this.idPayment = idPayment;
    }

    public Payment(Integer idPayment, int totalAmount, int creditcardNum, int creditcardType) {
        this.idPayment = idPayment;
        this.totalAmount = totalAmount;
        this.creditcardNum = creditcardNum;
        this.creditcardType = creditcardType;
    }

    public Integer getIdPayment() {
        return idPayment;
    }

    public void setIdPayment(Integer idPayment) {
        this.idPayment = idPayment;
    }

    public int getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(int totalAmount) {
        this.totalAmount = totalAmount;
    }

    public int getCreditcardNum() {
        return creditcardNum;
    }

    public void setCreditcardNum(int creditcardNum) {
        this.creditcardNum = creditcardNum;
    }

    public int getCreditcardType() {
        return creditcardType;
    }

    public void setCreditcardType(int creditcardType) {
        this.creditcardType = creditcardType;
    }

    public BillTable getBillNum() {
        return billNum;
    }

    public void setBillNum(BillTable billNum) {
        this.billNum = billNum;
    }

    public UserProfile getUsername() {
        return username;
    }

    public void setUsername(UserProfile username) {
        this.username = username;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPayment != null ? idPayment.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Payment)) {
            return false;
        }
        Payment other = (Payment) object;
        if ((this.idPayment == null && other.idPayment != null) || (this.idPayment != null && !this.idPayment.equals(other.idPayment))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pack.Payment[ idPayment=" + idPayment + " ]";
    }
    
}

```


工具类util包下的数据库连接类BaseDao:
```
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
      private static String user="***";
     private static String password="******";//这里数据库账号密码就不贴了
     
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
     //测试用例
//     public static void main(String[] args) {
//         try {
//             BaseDao.getCon();
//         } catch (ClassNotFoundException e) {
//             // TODO Auto-generated catch block
//             e.printStackTrace();
//         } catch (SQLException e) {
//             // TODO Auto-generated catch block
//             e.printStackTrace();
//         }
//     }
}

```
然后书DAO数据层的Book类以及User类的接口以及回调方法实现:
BookDao：
```
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import pack.BookDetails;

/**
 *
 * @author sl
 */
public interface BookDao {
       /***
15      * 图书的查询的方法
16      * @param sql
17      * @param arr
18      * @return
19      */
     public List<BookDetails> select(String sql,Object[] arr);
     
     /***
23      * 按照图书编号进行查询
24      * @param id
25      * @return
26      */
     public BookDetails getBook(Integer id);
     
     public List<BookDetails> getBooks(String category);
     
     public List<BookDetails> queryAll();
}

```
BookDaoImpl:
```
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

```
UserDao:
```
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import pack.UserProfile;

/**
 *
 * @author sl
 */
public interface UserDao {
    //用户登陆方法声明/回调声明 查询的方法都是返回的对象 返回查询的对象 或者是list对象或者是VO类对象
    public UserProfile login(UserProfile user);
    //用户注册方法声明/回调声明 //增加更新删除的方法 插入的方法都是返回一个布尔值 成功或者失败
    public boolean register(UserProfile user);
    //查询用户的信息
    public List<UserProfile>selectUser(String sql,Object[]arr);
}

```
UserDaoImpl:
```
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

```

业务层service包下的Book类代码:
BookService：
```
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;
import pack.BookDetails;

/**
 *
 * @author sl
 */
public interface BookService {
     /***
15      * 图书信息查询的方法
16      * @return
17      */
     public List<BookDetails> select(BookDetails book);
     
     public List<BookDetails> getBooks(BookDetails book);
    
     /***
21      * 根据id进行查询
22      * @param id
23      * @return
24      */
     public BookDetails getBook(BookDetails book);
     
     public List<BookDetails> queryAll();
}

```
BookServiceImpl:
```
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.BookDao;
import dao.BookDaoImpl;
import java.util.ArrayList;
import java.util.List;
import pack.BookDetails;

/**
 *
 * @author sl
 */
public class BookServiceImpl implements BookService{
    private BookDao dao=new BookDaoImpl();
     
     public List<BookDetails> select(BookDetails book){
         //String sql="select * from book ";
         StringBuilder sql=new StringBuilder("select * from book_details where 1=1 ");
         //sql语句
         List<Object> list=new ArrayList<Object>();
         if(book!=null){
             
             if( book.getBookId()!=0){
                 sql.append(" and book_id=? ");
                 list.add(book.getBookId());
             }
             /*list.add(book.getBookname());
32             list.add(book.getPrice());
33             list.add(book.getAuthor());
34             list.add(book.getPic());
35             list.add(book.getPublish());*/
         }
         
        return dao.select(sql.toString(), list.toArray());
     }
 
    @Override
    public BookDetails getBook(BookDetails book) {
        if(book!=null && book.getBookId()!=0){
             return dao.getBook(book.getBookId());
         }
         return null;
    }

    @Override
    public List<BookDetails> getBooks(BookDetails book) {
        if(book!=null && !book.getCategoryName().equals("")){
              return dao.getBooks(book.getCategoryName());
         }
        else{
         return null;
        }
       
    }

    @Override
    public List<BookDetails> queryAll() {
            return dao.queryAll();
    }
    
    
}

```

然后把上述准备工作做完以后，我们根据JSP页面上的步骤流程 一步步调用代码:
首先是引导页，
index.html：
```
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta name="description" content="">
  <title>New Tech在线购物商店</title>
//导入样式以及JS组件库
  <link href="http://g.alicdn.com/sj/dpl/1.5.1/css/sui.min.css" rel="stylesheet">
   <link href="http://g.alicdn.com/sj/dpl/1.5.1/css/sui-append.css" rel="stylesheet">
  <script type="text/javascript" src="http://g.alicdn.com/sj/lib/jquery/dist/jquery.min.js"></script>
  <script type="text/javascript" src="http://g.alicdn.com/sj/dpl/1.5.1/js/sui.min.js"></script>
   <style type="text/css">
 body{background:url(3.jpg)}
 </style>
</head>
<body>   
    <br/>
    <br/>
    <br/>
    <div align="center" data-step="1" data-intro="欢迎大家来到New Tech在线购物商店" class="divcont">
        <marquee width="400" scrollamount=7> <FONT face=楷体_GB2312 color="blue" size=5>欢迎来到New Tech在线购物商店</font></marquee>
    </div>
    <br/>
    <br />
    <br />
    <br />
    <br />
    <div align="center">
        <div data-step="2" data-intro="请先完成你的注册" data-position="right" class="divcont">
     <a href="register.html" class="sui-btn btn-xlarge btn-danger">注册</a>
     </div>
     &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
      <div data-step="3" data-intro="注册完成后 我们就可以开始shopping啦" data-position="left" class="divcont">
      <a href="login.html" class="sui-btn btn-xlarge btn-danger">登陆</a>
      </div>
    </div>
    <a href="javascript:void(0);" class="sui-btn btn-xlarge btn-primary">展示操作</a>
   <script>
      $.introJs().start();//这里是JS组件库里 新手引导的JS函数
</script>
</body>
</html>

```
然后我们点击注册，跳转到register.html：
```
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta name="description" content="">
  <title>注册</title>
  <link href="http://g.alicdn.com/sj/dpl/1.5.1/css/sui.min.css" rel="stylesheet">
   <link href="http://g.alicdn.com/sj/dpl/1.5.1/css/sui-append.css" rel="stylesheet">
  <script type="text/javascript" src="http://g.alicdn.com/sj/lib/jquery/dist/jquery.min.js"></script>
  <script type="text/javascript" src="http://g.alicdn.com/sj/dpl/1.5.1/js/sui.min.js"></script>
    <script type="text/javascript">
 //刷新验证码
// function HandlerClick(){
//  alert('登陆成功');
// }
 </script>
    <style type="text/css">
 body{background:url(3.jpg)}
 </style>
</head>
<body>
  <div class="sui-container" >
    <ul class="sui-breadcrumb">
      <li><a href="index1.html">引导页</a></li>
      <li class="active">注册</li>
    </ul>
    
    <form class="sui-form form-horizontal sui-validate" method="post" action="http://localhost:8080/NewTech/registerBean">
      <div class="control-group">
        <label class="sui-label label-info">用户名：</label>
        <div class="controls">
            <input class="input-medium" type='text' name="username" data-rules="required|minlength=2|maxlength=50" />
        </div>
      </div>
        
      <div class="control-group">
        <label class="sui-label label-info">密码：</label>
        <input class="input-medium" type="password" name="password" data-rules='required'>
      </div>
        
        <div class="control-group">
        <label class="sui-label label-info">first Name：</label>
        <input class="input-medium" type="text" name="firstname" data-rules='required'>
      </div>
        
        <div class="control-group">
        <label class="sui-label label-info">middle Name：</label>
        <input class="input-medium" type="text" name="middlename" data-rules='required'>
      </div>
        <div class="control-group">
        <label class="sui-label label-info">last Name：</label>
        <input class="input-medium" type="text" name="lastname" data-rules='required'>
      </div>
        
         <div class="control-group">
        <label class="sui-label label-info">地址1：</label>
        <input class="input-medium" type="text" name="address1" data-rules='required'>
      </div>
         <div class="control-group">
        <label class="sui-label label-info">地址2：</label>
        <input class="input-medium" type="text" name="address2" data-rules='required'>
      </div>
        
         <div class="control-group">
        <label class="sui-label label-info">城市：</label>
        <input class="input-medium" type="text" name="city" data-rules='required'>
      </div>
        
         <div class="control-group">
        <label class="sui-label label-info">国家：</label>
        <input class="input-medium" type="text" name="state" data-rules='required'>
      </div>
        
          <div class="control-group">
        <label class="sui-label label-info">身份证号码：</label>
        <input class="input-medium" type="text" name="pincode" data-rules='required'>
      </div>
        
          <div class="control-group">
        <label class="sui-label label-info">邮箱：</label>
        <input class="input-medium" type="text" name="email" data-rules='required'>
      </div>
        
          <div class="control-group">
        <label class="sui-label label-info"> 电话：</label>
        <input class="input-medium" type="text" name="phone" data-rules='required'>
      </div>
        
      <div class="control-group">
        <div class="controls">
            <input type="submit" class="sui-btn btn-xlarge btn-danger" value="注册">
        </div>
      </div>
    </form> 
  </div>
</body>
</html>

```
使用registerBean处理注册的逻辑:
```
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

```
回到引导页，点击登陆，进入login.html：
```
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta name="description" content="">
  <title>登陆</title>
  <link href="http://g.alicdn.com/sj/dpl/1.5.1/css/sui.min.css" rel="stylesheet">
  <script type="text/javascript" src="http://g.alicdn.com/sj/lib/jquery/dist/jquery.min.js"></script>
  <script type="text/javascript" src="http://g.alicdn.com/sj/dpl/1.5.1/js/sui.min.js"></script>
    <script type="text/javascript">
 //刷新验证码
// function HandlerClick(){
//  alert('登陆成功');
// }
 </script>
    <style type="text/css">
 body{background:url(3.jpg)}
 </style>
</head>
<body>
  <div class="sui-container">
    <ul class="sui-breadcrumb">
      <li><a href="index1.html">引导页</a></li>
      <li class="active">登陆</li>
    </ul>
    
    <form class="sui-form form-horizontal sui-validate"  method="get" action="http://localhost:8080/NewTech/loginBean">
      <div class="control-group">
        <label class="sui-label label-info">用户名：</label>
        <div class="controls">
            <input class="input-medium" type="text" data-rules="required|minlength=2|maxlength=50" name="username" >
        </div>
      </div>
        
      <div class="control-group">
        <label class="sui-label label-info">密码：</label>
        <input class="input-medium" type="text" data-rules='required' name="password" >
      </div>
        
       
      <div class="control-group">
        <div class="controls">
<!--            <input type="button" class="sui-btn btn-primary btn-xlarge" value="登陆" onClick='HandlerClick()'>-->
              <input type="submit" class="sui-btn btn-xlarge btn-danger" value="登陆">
        </div>
      </div>
    </form> 
  </div>
</body>
</html>

```
使用loginBean处理登陆的逻辑：
```
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

```
登陆成功以后进入图书列表页面selectcategory.jsp，我们可以通过表单刷新Book_Details类的category字段属性，再根据这个字段来查询刷新图书列表在book.jsp中显示:
selectcategory.jsp:
```
<%-- 
    Document   : selectcategory
    Created on : 2018-5-29, 14:22:37
    Author     : sl
--%>

<%@page import="service.BookServiceImpl"%>
<%@page import="java.util.List"%>
<%@page import="pack.BookDetails"%>
<%@page import="java.sql.*"%>
<%@ page language="java" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>购物页面</title>
<style>
    td{border:1px solid green;}
</style>
  <link href="http://g.alicdn.com/sj/dpl/1.5.1/css/sui.min.css" rel="stylesheet">
  <script type="text/javascript" src="http://g.alicdn.com/sj/lib/jquery/dist/jquery.min.js"></script>
  <script type="text/javascript" src="http://g.alicdn.com/sj/dpl/1.5.1/js/sui.min.js"></script>
   <style type="text/css">
 body{background:url(33_4.jpg)}
 </style>
</head>
<body>
 <!--创建数据表 create table `goods` (id int not null auto_increment primary key,goods_name varchar(20), goodspic varchar(30),goods_pri varchar(20), goods_name_en varchar(20)); -->
<label class="sui-btn btn-primary btn-xlarge">欢迎用户</label>
<label class="sui-btn btn-primary btn-xlarge">
<%= 
    session.getAttribute("username")
%>
<%
    if(session.getAttribute("username")==null){
    response.sendRedirect("login.html");
    }
    %>
</label>
<br />
<label class="sui-btn btn-primary btn-xlarge">请选择书本的类别:</label>
<form class="sui-form form-horizontal sui-validate"   name="form1" method="post" action="http://localhost:8080/NewTech/book.jsp">

<!-- <select name="category_name">
  <option value="English">英国文学</option>
  <option value="China">中国文学</option>
  <option value="UMA">美国文学</option>
 </select>-->
 <div class="input-control">
     <input type="text" name="category_name" class="input-thin" data-rules='required'><i class="sui-icon icon-touch-magnifier"></i>
  </div>

<!--<input class="input-medium" type="text"  name="category_name" >-->
  <label >
  <input class="sui-btn btn-xlarge btn-danger" type="submit" name="Submit" value="提交" />
  </label>
<!--  <a href="/servletProject/listItem">查看购物车</a></p>-->
</form>

<%
     BookServiceImpl service=new BookServiceImpl();
    List<BookDetails>list=service.queryAll();
    %>
<div  style="text-align:center;width:700px;align-content: center">
<table class="sui-table table-primary" align="center" width="40%" border="1px" >
     <tr>
       <th>书本封面</th>
        <th>书名</th>
<!--         <th>作者</th>
      <th>出版社</th>
        <th>编号</th>
        <th>价格</th>-->
   </tr>
    <%
        for(BookDetails b:list){    
    %>
    <tr align="center">
       <td><img src="<%=b.getPic() %>" width="300px"></td>
       <td><a href="dobook.jsp?id=<%=b.getBookId()%>"  class="sui-btn btn-xlarge btn-danger"><%=b.getTitle()%></a></td>
<!--         <td><%=b.getAuthor()%></td>
       <td><%=b.getPublisher()%></td>
        <td><%=b.getIsbn() %></td>
        <td><%=b.getPrice() %></td>-->
     </tr>
    <%} %>
 </table>
</div>
</body>
</html>
```
book.jsp:
```
<%@page import="java.util.List"%>
  <%@page import="service.BookServiceImpl"%>
  <%@page import="pack.BookDetails"%>
  <%@ page language="java" contentType="text/html; charset=UTF-8"
      pageEncoding="UTF-8"%>
  <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
  <html>
  <head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 <title>图书列表的页面</title>
  <link href="http://g.alicdn.com/sj/dpl/1.5.1/css/sui.min.css" rel="stylesheet">
  <script type="text/javascript" src="http://g.alicdn.com/sj/lib/jquery/dist/jquery.min.js"></script>
  <script type="text/javascript" src="http://g.alicdn.com/sj/dpl/1.5.1/js/sui.min.js"></script>
  <style type="text/css">
 body{background:url(33_4.jpg)}
 </style>
 </head>
 <body>
 <%
     String categoryString=request.getParameter("category_name");
      
     //图书的实体类创建一个对象
     BookDetails book=new BookDetails();
     //图书的业务逻辑层层
     BookServiceImpl service=new BookServiceImpl();
     book.setCategoryName(categoryString);
    List<BookDetails> list=service.getBooks(book);
   
 %>
 
<!-- <label class="sui-btn btn-primary btn-xlarge">我的购物车</label>-->
<div>
    <a href="docart.jsp" class="sui-btn btn-xlarge btn-danger">我的购物车</a>
</div>
<div  style="text-align:center;width:700px;align-content: center">
<table class="sui-table table-primary" align="center" width="40%" border="1px" >
     <tr>
       <th>书本封面</th>
        <th>书名</th>
<!--         <th>作者</th>
      <th>出版社</th>
        <th>编号</th>
        <th>价格</th>-->
   </tr>
    <%
        for(BookDetails b:list){    
    %>
    <tr align="center">
       <td><img src="<%=b.getPic() %>" width="300px"></td>
       <td><a href="dobook.jsp?id=<%=b.getBookId()%>"  class="sui-btn btn-xlarge btn-danger"><%=b.getTitle()%></a></td>
<!--         <td><%=b.getAuthor()%></td>
       <td><%=b.getPublisher()%></td>
        <td><%=b.getIsbn() %></td>
        <td><%=b.getPrice() %></td>-->
     </tr>
    <%} %>
 </table>
</div>
 </body>
 </html>
```
然后根据我们在book.jsp中点击的响应书本的链接 将其id传入给dobook.jsp，我们根据这个书本的id，调用数据层业务层的代码，查询出书本的全部信息，在detail.jsp页面显示出来：
dobook.jsp:
```
<%-- 
    Document   : dobook
    Created on : 2018-5-30, 8:48:08
    Author     : sl
--%>

<%@page import="service.BookServiceImpl"%>
<%@page import="service.BookService"%>
<%@page import="pack.BookDetails"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            BookDetails book=new BookDetails();
     String sid=request.getParameter("id");
     Integer id=Integer.parseInt(sid);
     BookService service=new BookServiceImpl();
     book.setBookId(id);
     BookDetails books=service.getBook(book);
    
     session.setAttribute("book", books);
     response.sendRedirect("detail.jsp");
            %>
    </body>
</html>

```
detail.jsp:
```
<%@page import="pack.BookDetails"%>
 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
  <html>
  <head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>图书详细信息的页面</title>
   <link href="http://g.alicdn.com/sj/dpl/1.5.1/css/sui.min.css" rel="stylesheet">
  <script type="text/javascript" src="http://g.alicdn.com/sj/lib/jquery/dist/jquery.min.js"></script>
  <script type="text/javascript" src="http://g.alicdn.com/sj/dpl/1.5.1/js/sui.min.js"></script>
  <style type="text/css">
 body{background:url(33_4.jpg)}
 </style>
  </head>
 <body>
 <%
  BookDetails book=(BookDetails)session.getAttribute("book");
 %>
 <div style="text-align:left;font-size:36px;">
 
     <a href="docart.jsp" class="sui-btn btn-xlarge btn-danger">我的购物车</a>
 </div>
 <div  style="text-align:center;width:1000px;align-content: center">
<table class="sui-table table-primary" align="center" width="40%" border="1px" >
     <tr >
         <th>图书封面</th>
         <th>图书名称</th>
         <th>图书作者</th>
         <th>图书出版社</th>
         <th>图书编号</th>
         <th>图书价格</th>
     </tr>
     <tr>
         <td><img src="<%=book.getPic() %>" width="300px"></td>
         <td><%=book.getTitle()%></td>
         <td><%=book.getAuthor() %></td>
         <td><%=book.getPublisher() %></td>
<!--32         <td><img src="images/book.getPic()"</td>-->
            <td><%=book.getIsbn()%></td>
         <td><%=book.getPrice() %></td>
     </tr>
     <tr>
         <td colspan="2"></td>
         <td><a href="cart.jsp" class="sui-btn btn-xlarge btn-danger">添加到购物车</a></td>
         <td><a href="selectcategory.jsp" class="sui-btn btn-xlarge btn-danger">图书列表</a></td>
         
         <td colspan="2"></td>
     </tr>
     
 </table>
 </div>
 </body>
 </html>
```
然后我们如果点击了添加到购物车，那么就有了购物结算的逻辑，我们准备好购物车的模型代码cart.jsp以及购物车添加书本以及计算书本总价的docart.jsp:
cart.jsp:
```
<%@page import="java.util.HashMap"%>
  <%@page import="pack.CartItem"%>
  <%@page import="java.util.Map"%>
  <%@page import="pack.BookDetails"%>
  <%@ page language="java" contentType="text/html; charset=UTF-8"
      pageEncoding="UTF-8"%>
  <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
  <html>
  <head>
 <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 <title>添加到购物车</title>
 </head>
 <body>
 <%
     //购物车功能
     //1:首先考虑我购买的是哪一本书籍，这里可以使用id确认也可以使用session中取出哪一本书籍
     BookDetails book=(BookDetails)session.getAttribute("book");
     
     //2:考虑如何把书籍放到购物车中
         //2.1:首先考虑是否有购物车，如果没有，则创建，如果有直接使用
         //2.2:其次先将购物车从session中拿出来，不存在就创建。
     Map<Integer,CartItem> cart=(Map<Integer,CartItem>)session.getAttribute("cart");
     //如果没有购物车，那么创建，只有第一次访问才会操作
     if(cart==null){
         //new一个购物车
         cart=new HashMap<>();
     }
     
     //3:考虑如何把书籍放到购物车中
         //3.1:第一考虑购物车中是否有该书籍，所以先从购物车中获取该书籍，如果为空，那么没有该书籍
     CartItem item=(CartItem)cart.get(book.getBookId());
     if(item==null){
         //如果购物车中不存在该书籍，那么创建，且数量默认为1
         item=new CartItem();
         //将书籍放到购物车中
         item.setBook(book);
         //将书籍的默认数量为1
         item.setNumber(1);
     }else{
         //如果购物车中以及有该书籍，那么数量加1 
         item.setNumber(item.getNumber()+1);
     }
     
     //4:考虑如何把购物车项(即挑选的书籍是哪一个和书本的数量)放到购物车中
     cart.put(book.getBookId(),item);
     
     //5:将购物车放到session中，方便后面取出来
     session.setAttribute("cart", cart);
     
     response.sendRedirect("docart.jsp");
 %>
</body>
 </html>

```
docart.jsp:
```
<%@page import="pack.CartItem"%>
 <%@page import="java.util.Map"%>
  <%@ page language="java" contentType="text/html; charset=UTF-8"
     pageEncoding="UTF-8"%>
  <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
  <html>
  <head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>我的购物车的页面</title>
   <link href="http://g.alicdn.com/sj/dpl/1.5.1/css/sui.min.css" rel="stylesheet">
  <script type="text/javascript" src="http://g.alicdn.com/sj/lib/jquery/dist/jquery.min.js"></script>
  <script type="text/javascript" src="http://g.alicdn.com/sj/dpl/1.5.1/js/sui.min.js"></script>
  <style type="text/css">
 body{background:url(33_4.jpg)}
 </style>
 </head>
 <body>
     <div  style="text-align:center;width: 500px;align-content:center">
 <table class="sui-table table-primary" align="center" width="40%" border="1px" align="center" >
     <thead>
     <tr>
         <th>书本编号</th>
         <th>书本名称</th>
         <th>书本单价</th>
         <th>书本数量</th>
         <th>书本小计</th>
     </tr>
     </thead>
     <%
         //1:将添加到购物车里面的物品显示出来
          Map<Integer,CartItem> map=(Map<Integer,CartItem>)session.getAttribute("cart");
         
         //2:将购物车里面的内容遍历出来
         double count=0;//显示出总价格
           if(map!=null){
       
          
         for(Map.Entry<Integer,CartItem> entry : map.entrySet()){
            
             //计算出每一样的书籍一共花了多少钱
             double price=entry.getValue().getBook().getPrice() * entry.getValue().getNumber();    
             //计算出一共花了多少钱
             count=count+price;
     %>
     <tbody>
     <tr align="center">    
         <td><%=entry.getKey() %></td>
         <td><%=entry.getValue().getBook().getTitle()%></td>
        <td><%=entry.getValue().getBook().getPrice() %></td>
         <td><%=entry.getValue().getNumber() %></td>
         <td><%=entry.getValue().getBook().getPrice() * entry.getValue().getNumber()%></td>
         
     </tr>
     <%}
}else{
       response.sendRedirect("failcart.html");
}
     %>
     <tr>
         <td colspan="4" align="right" class="sui-btn btn-xlarge btn-primary">价格总计</td>
         &nbsp;
                  &nbsp;
         &nbsp;
         &nbsp;
         &nbsp;

         <td class="sui-btn btn-xlarge btn-info"><%=count %></td>
     </tr>
     </tbody>
 </table>
     </div>
 <div style="text-align:center;font-size:36px;">
     <a href="selectcategory.jsp" class="sui-btn btn-xlarge btn-danger">返回图书列表</a>
     <a href="payment.html" class="sui-btn btn-xlarge btn-danger">结算</a>
 </div>    
 </body>
 </html>

```
然后我们点击结算，跳转到payment.html：
```
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta name="description" content="">
  <title>新建待办事项</title>
  <link href="http://g.alicdn.com/sj/dpl/1.5.1/css/sui.min.css" rel="stylesheet">
  <script type="text/javascript" src="http://g.alicdn.com/sj/lib/jquery/dist/jquery.min.js"></script>
  <script type="text/javascript" src="http://g.alicdn.com/sj/dpl/1.5.1/js/sui.min.js"></script>
    <script type="text/javascript">
 //刷新验证码
// function HandlerClick(){
//  alert('登陆成功');
// }
 </script>
    <style type="text/css">
 body{background:url(33_4.jpg)}
 </style>
</head>
<body>

    <form class="sui-form form-horizontal sui-validate"  method="get" action="http://localhost:8080/NewTech/paymentInfoServlet">
      <div class="control-group">
        <label class="sui-label label-info">请输入你的信用卡号：</label>
        <div class="controls">
            <input class="input-medium" type="text" data-rules="required|minlength=2|maxlength=50" name="creditcard_num" >
        </div>
      </div>
        
      <div class="control-group">
        <label class="sui-label label-info">请输入你的信用卡类型：</label>
        <input class="input-medium" type="text" data-rules='required' name="creditcard_type" >
      </div>
        
       
      <div class="control-group">
        <div class="controls">
<!--            <input type="button" class="sui-btn btn-primary btn-xlarge" value="登陆" onClick='HandlerClick()'>-->
              <input type="submit" class="sui-btn btn-xlarge btn-danger" value="登陆">
        </div>
      </div>
    </form> 
</body>
</html>
```
我们通过paymentInfoServlet来进行信用卡的验证，通过vo类与数据库交互:
```

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
        conn=DriverManager.getConnection("jdbc:mysql://localhost/mydb","****","*******");//数据库用户名密码略
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

```
以上就完成了我们的项目啦~以下github项目地址:[Ricardo_L_Song](https://github.com/Ricardo-L-Song/NewTech)

