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
