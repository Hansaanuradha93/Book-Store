<%@ page import="com.hansa.sample.Book" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: hansaanuradha
  Date: 2019-07-27
  Time: 15:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
    <style>
      table, th, td {
        border: 1px solid black;
        border-collapse: collapse;
      }
      th, td {
        padding: 5px;
        text-align: left;
      }
      input {
        background-color: #4CAF50; /* Green */
        border: none;
        color: white;
        margin-top: 8px;
        margin-bottom: 8px;
        padding: 8px 16px;
        text-align: center;
        text-decoration: none;
        display: inline-block;
        font-size: 16px;
      }
    </style>
  </head>
  <body>
  <%@ include file="header.jsp" %>

  <table style="width:100%">
    <tr>
      <th>ISBN No</th>
      <th>Short Desk</th>
      <th>Price</th>
      <th>Delete</th>
    </tr>

    <%
      // Lets create a array list of books to store the books
      ArrayList<Book> books = new ArrayList<Book>();

      // Lets create index variable to get the index
      int index = 1;

      // Lets try to retrieve the index from a session
      if(session.getAttribute("id") != null) {
        index = Integer.parseInt((String)session.getAttribute("id"));
      }

      // Lets go through every index to get all the books
      for(int i = 1; i <= index; i++) {
        Book newBook = (Book) session.getAttribute("" + i);

        if(newBook != null) {
          // Lets add each retrieved book from the session to the books array list
          books.add(newBook);
        }
      }

      // Let go through each book
      if(books != null) {
        for(Book book: books) {
    %>
    <tr>
      <th><%=book.getIsbn()%></th>
      <th><%=book.getDesc()%></th>
      <th><%=book.getPrice()%></th>
      <th>Delete</th>
    </tr>
    <%
        }
      }
    %>
  </table>
  <input type="submit" value="Delete Book(s)">
  <hr>
  <h2>Add a Book</h2>
  <form action="BookServlet" method="POST">
    <input type="text" placeholder="ISBN Number" name="isbn" ><br>
    <input type="text" placeholder="Short Description" name="shortdesc"><br>
    <input type="text" placeholder="Price" name="price"><br>
    <input type="submit" value="OK">
  </form>
  <hr>
  <%@ include file="footer.jsp" %>
  </body>
</html>
