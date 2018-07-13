package ru.sbrf.itc.entity;

/**
 * Класс объекта "книга".
 */
public class Book {
    private int id;
    private int idAuthor;
    private String title;
    private int year;

    public Book()
    {

    }
    public Book(int idAuthor, String title,int year){
        this.idAuthor = idAuthor;
        this.title = title;
        this.year = year;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdAuthor() {
        return idAuthor;
    }

    public void setIdAuthor(int idAuthor) {
        this.idAuthor = idAuthor;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
