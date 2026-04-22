package com.pluralsight.workbook.iii.sychronous.quotes;

public class Quote {
    private String text;
    private String author;
    private String category;
    private int year;

    public Quote(String _text, String _author, String _category, int _year) {
        this.text = _text;
        this.author = _author;
        this.category = _category;
        this.year = _year;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        if (author == null || author.length() < 2) {
            throw new IllegalArgumentException("Author name is too short");
        }
        this.author = author;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return text + " - " + author + " (" + year + ")";
    }
}


