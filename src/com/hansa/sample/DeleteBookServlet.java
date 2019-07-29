package com.hansa.sample;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Enumeration;

@WebServlet(name = "DeleteBookServlet")
public class DeleteBookServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Enumeration<String> parameters = request.getParameterNames();
        HttpSession session = request.getSession(true);

        PrintWriter out = response.getWriter();
        ArrayList<Book> books = (ArrayList<Book>)session.getAttribute("bookList");

        ArrayList<Integer> indexArray = new ArrayList<>();
        Integer index = 0;


        if(books != null) {
            while (parameters.hasMoreElements()) {
                index = Integer.parseInt(parameters.nextElement());
                indexArray.add(index);
//                if (index < books.size()){
//                    books.remove(index);
//                } else if(index == books.size()){
//                    books.remove(index-1);
//                }
            }

            for(int i = indexArray.size() - 1; i >= 0; i--) {
                int valuesOfIndexArray = indexArray.get(i);
                books.remove(valuesOfIndexArray);
            }

        }

        session.setAttribute("bookList", books);
        // Lets redirect to index.jsp
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
