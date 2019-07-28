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
        PrintWriter out = response.getWriter();

        String isbn = request.getParameter("isbn");
        String desk = request.getParameter("shortdesc");
        String price = request.getParameter("price");

        HttpSession session = request.getSession(true);

        int index = 1;
        if(session.getAttribute("id") != null) {
            index = Integer.parseInt((String) session.getAttribute("id"));
        }



        Book book = new Book(isbn, desk, price);
        session.setAttribute(String.valueOf(index), book);

        index++;
        session.setAttribute("id", String.valueOf(index));

        request.setAttribute("id", String.valueOf(index));
        request.getRequestDispatcher("index.jsp").forward(request, response);

        response.sendRedirect("index.jsp");


//        HttpSession session = request.getSession(true);
//        session.setAttribute("auth","candidjava");
//
//        String val=(String)session.getAttribute("auth");

        //        String commonString = "/" + isbn + "/" + shortDescription + "/" + price + "/";

//        Cookie cookies[] = null;
//        cookies = request.getCookies();
//        int id = 0;
//
//        if (cookies != null) {
//            for(Cookie cookie: cookies) {
//                if (cookie.getName().equals("id")) {
//                    id = Integer.parseInt(cookie.getValue());
//                }
//            }
//        }
//        id = id + 1;
//
//        Cookie idCookie = new Cookie("id", String.valueOf(id));
//        idCookie.setMaxAge(30 * 60);
//        response.addCookie(idCookie);
//
//        Cookie bookIsbnCookie = new Cookie(id + "isbn", isbn);
//        bookIsbnCookie.setMaxAge(30 * 60);
//        response.addCookie(bookIsbnCookie);
//
//        Cookie bookDescCookie = new Cookie(id + "desk", shortDescription);
//        bookDescCookie.setMaxAge(30 * 60);
//        response.addCookie(bookDescCookie);
//
//        Cookie bookPriceCookie = new Cookie(id + "price", price);
//        bookPriceCookie.setMaxAge(30 * 60);
//        response.addCookie(bookPriceCookie);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {}
}
