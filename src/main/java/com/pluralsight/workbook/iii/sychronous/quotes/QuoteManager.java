package com.pluralsight.workbook.iii.sychronous.quotes;

import java.util.ArrayList;

public class QuoteManager {
    private ArrayList<Quote> quotes;

    public QuoteManager() {
        quotes = new ArrayList<>();
        loadQuotes();
    }

    private void loadQuotes() {
        quotes.add(new Quote("The only thing we have to fear is fear itself.", "Franklin D. Roosevelt", "Speech", 1933));
        quotes.add(new Quote("Brevity is the soul of wit", "William Shakespeare", "Literature", 1602));
        quotes.add(new Quote("Stay hungry, stay foolish", "Steve Jobs", "Motivation", 2005));
        quotes.add(new Quote("Heal the world, make it a better place.", "Michael Jackson", "Wisdom", 1992));
        quotes.add(new Quote("The only way to do great work is to love what you do.", "Steve Jobs", "Motivation", 2005));
        quotes.add(new Quote("Innovation distinguishes between a leader and a follower.", "Steve Jobs", "Technology", 2001));
    }

    public ArrayList<Quote> getQuotes() {
        return quotes;
    }

    public void printAllQuotes() {
        for (Quote q : quotes) {
            System.out.println(q);
        }
    }
}