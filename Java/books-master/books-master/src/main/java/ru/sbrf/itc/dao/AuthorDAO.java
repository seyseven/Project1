package ru.sbrf.itc.dao;

import ru.sbrf.itc.entity.Author;
import ru.sbrf.itc.entity.Book;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AuthorDAO {
    private Connection connection;

    public AuthorDAO(Connection connection) {
        this.connection = connection;
        createTable();
    }

    public void createTable() {
        try {
            Statement st = connection.createStatement();
            st.execute("create table if not exists AUTHOR(" +
                    "id bigint auto_increment primary key, "+
                    "firstName varchar(20), " + "secondName varchar(20), " + "middleName varchar(20));");
            System.out.println("Table author created");
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Create table AUTHOR.");
        }
    }

    public void add(Author author) {
        try {
            Statement st = connection.createStatement();
            st.execute("INSERT INTO AUTHOR(firstName, secondName, middleName) VALUES('" + author.getFirstName() +
                    "','" + author.getSecondName() + "','" + author.getMiddleName() + "')");
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("ERROR: Insert record.");
        }
    }

    public List<Author> findAll() {
        try {
            List<Author> results = new ArrayList<Author>();

            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("select * from AUTHOR");

            while (rs.next()) {
                Author author = new Author();

                author.setId(rs.getInt("id"));
                author.setFirstName(rs.getString("firstName"));
                author.setSecondName(rs.getString("secondName"));
                author.setMiddleName(rs.getString("middleName"));

                results.add(author);
            }

            return results;
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("ERROR: Find All.");
        }

        return null;
    }

    public Author update(Author author) {
        try {
            Statement st = connection.createStatement();
            st.execute("update AUTHOR set firstName = '" + author.getFirstName() + "'" +
                                              ", secondName = '" + author.getSecondName() + "'" +
                                              ", middleName = '" + author.getMiddleName() + "'" +
                                              " where id = " + author.getId() + ";");
            return author;
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("ERROR: Update.");
        }

        return null;
    }

    public void remove(int id) {
        try {
            Statement st = connection.createStatement();
            st.execute("DELETE FROM AUTHOR WHERE id = "+id+" ;");
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Connection ERROR");
        }
    }
}
