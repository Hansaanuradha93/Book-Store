package com.hansa.sample;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@WebServlet(name = "BookServlet")
public class BookServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // Lets get a print writer here
        PrintWriter out = response.getWriter();

        // Lets get the values of jsp page
        String isbn = request.getParameter("isbn");
        String desk = request.getParameter("shortdesc");
        String price = request.getParameter("price");

        // Lets create a session
        HttpSession session = request.getSession(true);

        // Lets create a index to store the number of books
        int index = 1;
        // Lets try to retrieve the index from a session
        if(session.getAttribute("id") != null) {
            index = Integer.parseInt((String) session.getAttribute("id"));
        }

        // Lets create a new book
        Book book = new Book(isbn, desk, price);
        // Lets add the book to a session
        session.setAttribute(String.valueOf(index), book);

        // Lets increase the index
        index++;

        // Lets store the index in a session
        session.setAttribute("id", String.valueOf(index));

        // Lets pass the index to index.jsp
        request.setAttribute("id", String.valueOf(index));
        request.getRequestDispatcher("index.jsp").forward(request, response);

        // Lets redirect to index.jsp
        response.sendRedirect("index.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {}
}
