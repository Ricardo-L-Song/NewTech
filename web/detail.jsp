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