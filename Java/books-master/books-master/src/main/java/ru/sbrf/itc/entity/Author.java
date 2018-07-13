package ru.sbrf.itc.entity;

/**
 * Класс объекта "автор".
 */
public class Author {
    private int id;
    private String firstName;
    private String secondName;
    private String middleName;

    public Author() {
    }


    public Author(String fName, String lName, String mName) {
        this.firstName = fName;
        this.secondName = lName;
        this.middleName = mName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }
}
