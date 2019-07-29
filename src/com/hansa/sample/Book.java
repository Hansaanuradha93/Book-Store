package com.hansa.sample;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Enumeration;

// This class models books
public class Book implements Serializable {

    // Properties
    private String isbn;
    private String desc;
    private String price;

    // Constructors
    public Book() {}
    public Book(String isbn, String desc, String price) {
        this.isbn = isbn;
        this.desc = desc;
        this.price = price;
    }

    // Getters and Setters
    public String getIsbn() {return isbn;}

    public void setIsbn(String isbn) {this.isbn = isbn;}

    public String getDesc() {return desc;}

    public void setDesc(String desc) {this.desc = desc;}

    public String getPrice() {return price;}

    public void setPrice(String price) {this.price = price;}

    // Methods
    // Lets add books
    static void addBook(HttpServletRequest request) {
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
    }

    // Lets delete books
    static void deleteBook(HttpServletRequest request) {
        // Lets get the parameter names from the form
        Enumeration<String> parameters = request.getParameterNames();

        // Lets create a session
        HttpSession session = request.getSession(true);

        // Lets retrieve the books from the session
        ArrayList<Book> books = (ArrayList<Book>)session.getAttribute("bookList");

        // Lets create a indexArray to
        ArrayList<Integer> indexArray = new ArrayList<>();
        Integer index = 0;
        int valuesOfIndexArray = 0;


        // Lets check whether we have some books
        if(books != null) {
            // Lets go through all the parameter names
            while (parameters.hasMoreElements()) {
                // Lets get the parameter value
                index = Integer.parseInt(parameters.nextElement());
                // Lets add the parameter value to the indexArray
                indexArray.add(index);
            }

            // Lets go through all the elements of indexArray
            for(int i = indexArray.size() - 1; i >= 0; i--) {
                // Lets get each index
                valuesOfIndexArray = indexArray.get(i);
                // Lets remove the corresponding book from the book array list
                books.remove(valuesOfIndexArray);
            }

        }

        // Lets save the books in a session
        session.setAttribute("bookList", books);
    }

}


