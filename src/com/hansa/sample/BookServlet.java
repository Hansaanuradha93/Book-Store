package com.hansa.sample;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@WebServlet(name = "BookServlet")
public class BookServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // Lets get the values of jsp page
        String isbn = request.getParameter("isbn");
        String desc = request.getParameter("shortdesc");
        String price = request.getParameter("price");

        if (!isbn.isEmpty() && !desc.isEmpty() && !price.isEmpty()) {
            // Lets create a session
            HttpSession session = request.getSession(true);

            ArrayList<Book> books;

            if(session.getAttribute("bookList") != null) {
                books = (ArrayList<Book>) session.getAttribute("bookList");
            } else {
                books = new ArrayList<Book>();
            }
            Book newBook = new Book(isbn, desc, price);
            books.add(newBook);

            session.setAttribute("bookList", books);

        }

        // Lets redirect to index.jsp
        request.getRequestDispatcher("index.jsp").forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {}
}
