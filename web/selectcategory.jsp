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
<form class="sui-form form-horizontal sui-validate"   name="form1" method="post" action="http://localhost:8080/NewTech1/book.jsp">

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
