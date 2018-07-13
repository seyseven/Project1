package ru.sbrf.itc.dao;

import ru.sbrf.itc.entity.Author;
import ru.sbrf.itc.entity.Book;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class BookDAO {
    private Connection connection ;

    public BookDAO(Connection connection) {
        this.connection = connection;
        createTable();
    }

    private void createTable() {
        try {
            Statement st = connection.createStatement();
            st.execute("create table if not exists BOOK( "+
                    "id bigint auto_increment primary key, " +
                    "title varchar(20)," + "year integer," + "idAuthor integer not null references AUTHOR(id));");
            System.out.println("Table author created");
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("ERROR: Create Table");
        }
    }
    //------------------------------------------------------------------------
    public void add(Book book)
    {
        try {
           Statement st = connection.createStatement();
            st.execute("INSERT INTO BOOK(title, year, idAuthor) VALUES('"+book.getTitle()+"',"+book.getYear()+","+book.getIdAuthor()+")");
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Connection ERROR");
        }
    }
    //------------------------------------------------------------------------
    public List<Book> findAll()
    {
        try {
            List<Book> results = new ArrayList<Book>() ;

           Statement st = connection.createStatement();
           ResultSet rs = st.executeQuery("select * from BOOK");
            while (rs.next()) {
                Book book = new Book();
                book.setId(rs.getInt("idBook"));
                book.setTitle(rs.getString("title"));
                book.setYear(rs.getInt("year"));
                book.setIdAuthor(rs.getInt("idAuthor"));

                results.add(book);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("ERROR: Find All.");
        }
        return null;
    }
    //------------------------------------------------------------------------
    public Book update(Book book) {
        try {
          Statement  st = connection.createStatement();


            st.execute("update BOOK set " +
                                        " idAuthor = '" + book.getIdAuthor() + "' " +
                                        ", title = '" + book.getTitle() + "' " +
                                        ", year = " + book.getYear() + " " +
                                        "where idBook =" + book.getId() + ";");

            return book;
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("ERROR: Update.");
        }
        return null;
    }
    //------------------------------------------------------------------------
    public void remove(int id) {
        try {
            Statement st = connection.createStatement();
            st.execute("DELETE FROM BOOK WHERE idBook = "+ id+" ;");
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("ERROR: Remove.");
        }
    }
}
