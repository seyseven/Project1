package ru.sbrf.itc.service;

import ru.sbrf.itc.dao.AuthorDAO;
import ru.sbrf.itc.dao.BookDAO;
import ru.sbrf.itc.entity.Author;
import ru.sbrf.itc.entity.Book;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookService {
    private final static String DB_USERNAME = "sa";
    private final static String DB_PASSWORD = "";
    private final static String DB_DRIVER = "org.h2.Driver";
    private final static String DB_URL = "jdbc:h2:~/test5";

    Scanner scan = new Scanner(System.in);
    private BookDAO bookDao;
    private AuthorDAO authorDao;

    public BookService() {
        Connection connection = getConnection();
        bookDao = new BookDAO(connection);
        authorDao = new AuthorDAO(connection);
    }

    public Connection getConnection() {
        try {
            Class.forName(DB_DRIVER);
            return DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Connection ERROR");
        }
        return null;
    }

    private String readStringParam(String caption) {
        System.out.print(caption + ": ");
        return scan.next();
    }

    private int readIntParam(int caption) {
        System.out.print(caption + ": ");
        return scan.nextInt();
    }







    public void addAuthor() {
        String fName = readStringParam("FName");
        String lName = readStringParam("LName");
        String mName = readStringParam("MName");
        Author author = new Author(fName, lName, mName);
        authorDao.add(author);
    }

    public void showAuthor() {
        List<Author> authors = authorDao.findAll();
        for (Author author : authors) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("id: ");
            stringBuilder.append(author.getId());
            stringBuilder.append("|");

            stringBuilder.append("FName: ");
            stringBuilder.append(author.getFirstName());
            stringBuilder.append("|");

            stringBuilder.append("LName: ");
            stringBuilder.append(author.getSecondName());
            stringBuilder.append("|");

            stringBuilder.append("MName: ");
            stringBuilder.append(author.getMiddleName());
            stringBuilder.append("|");

            System.out.println(stringBuilder.toString());
        }
    }




    public void showBook() {
        List<Book> books = bookDao.findAll();
        for (Book book : books) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("id: ");
            stringBuilder.append(book.getId());
            stringBuilder.append("|");

            stringBuilder.append("FName: ");
            stringBuilder.append(book.getTitle());
            stringBuilder.append("|");

            stringBuilder.append("LName: ");
            stringBuilder.append(book.getYear());
            stringBuilder.append("|");

            stringBuilder.append("MName: ");
            stringBuilder.append(book.getIdAuthor());
            stringBuilder.append("|");

        }
    }
        public void addBook()
        {
            String Title = readStringParam("Title");
            int year =  readIntParam(1996);
            int idAuthor = readIntParam(76);
            Book book = new Book(idAuthor, Title, year);
            bookDao.add(book);
        }

         public void removeAuthor(int id) {
            authorDao.remove(id);
        }

         public void removeBook(int id) {
            bookDao.remove(id);
        }

    public void updateBook()
    {
        String Title = readStringParam("Title");
        int year =  readIntParam(1996);
        int idAuthor = readIntParam(76);
        Book book = new Book(idAuthor,Title,year);
        bookDao.update(book);
    }
    public void updateAuthor()
    {
        String fName = readStringParam("FName_1");
        String lName = readStringParam("LName_2");
        String mName = readStringParam("MName_3");
        Author author = new Author(fName, lName, mName);
        authorDao.update(author);
    }


    public void ShowMenu() {
        System.out.println();
        System.out.println("3 :show book table");
        System.out.println("4 :show author table");
        System.out.println();
        System.out.println("5 :add in author table");
        System.out.println("6 :add in book table");
        // System.out.println();
         System.out.println("7 :remove from book ");
         System.out.println("8 :remove from author ");
        // System.out.println();
        System.out.println("9 :update from author ");
        System.out.println("10 :update from author ");
        System.out.println();
        System.out.println("11 :exit ");
    }
}
