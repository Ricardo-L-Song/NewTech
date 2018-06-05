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
