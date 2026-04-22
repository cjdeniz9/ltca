package com.pluralsight.workshop.neigborhoodlibrary;

import java.util.Scanner;

public class Book {

    Scanner scanner = new Scanner(System.in);

    // Object
    private int id;
    private String isbn;
    private String title;
    private boolean isCheckedOut;
    private String  checkedOutTo;

    // Constructor
    public Book(int _id, String _isbn, String _title, boolean _isCheckedOut, String _checkedOutTo) {
        this.id = _id;
        this.isbn = _isbn;
        this.title = _title;
        this.isCheckedOut = _isCheckedOut;
        this.checkedOutTo = _checkedOutTo;
    }

    // Getter and Setter
    public int getId() {
        return id;
    }

    public void setId(int _id) {
        this.id = _id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String _isbn) {
        this.isbn = _isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String _title) {
        this.title = _title;
    }

    public boolean isCheckedOut() {
        return isCheckedOut;
    }

    public void setCheckedOut(boolean _checkedOut) {
        isCheckedOut = _checkedOut;
    }

    public String getCheckedOutTo() {
        return checkedOutTo;
    }

    public void setCheckedOutTo(String _checkedOutTo) {
        this.checkedOutTo = _checkedOutTo;
    }

    // Methods
    void checkOut(String name) {
        setCheckedOutTo(name);
    }

    void checkIn() {
        setCheckedOut(false);
        setCheckedOutTo("");
    }
}



