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