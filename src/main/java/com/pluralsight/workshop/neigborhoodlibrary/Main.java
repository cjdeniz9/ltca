package com.pluralsight.workshop.neigborhoodlibrary;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Book[] books = new Book[20];

        books[0] = new Book(1, "978-0743273565", "The Great Gatsby", false, "");
        books[1] = new Book(2, "978-0061120084", "To Kill a Mockingbird", false, "");
        books[2] = new Book(3, "978-0451524935", "1984", false, "");
        books[3] = new Book(4, "978-0618260300", "The Hobbit", false, "");
        books[4] = new Book(5, "978-0544003415", "The Lord of the Rings", false, "");
        books[5] = new Book(6, "978-0439139601", "Harry Potter and the Goblet of Fire", false, "");
        books[6] = new Book(7, "978-0316769488", "The Catcher in the Rye", false, "");
        books[7] = new Book(8, "978-0141439600", "Pride and Prejudice", false, "");
        books[8] = new Book(9, "978-0307277671", "The Road", false, "");
        books[9] = new Book(10, "978-0143127550", "The Alchemist", false, "");
        books[10] = new Book(11, "978-0385504201", "The Da Vinci Code", false, "");
        books[11] = new Book(12, "978-0679783268", "Brave New World", false, "");
        books[12] = new Book(13, "978-0747532743", "Harry Potter and the Philosopher's Stone", false, "");
        books[13] = new Book(14, "978-0307387899", "The Kite Runner", false, "");
        books[14] = new Book(15, "978-0062315007", "Sapiens: A Brief History of Humankind", false, "");
        books[15] = new Book(16, "978-1451673319", "Fahrenheit 451", false, "");
        books[16] = new Book(17, "978-0140283334", "Animal Farm", false, "");
        books[17] = new Book(18, "978-0307474278", "Gone Girl", false, "");
        books[18] = new Book(19, "978-0060850524", "The Shining", false, "");
        books[19] = new Book(20, "978-0553380163", "A Game of Thrones", false, "");

        homeScreen(scanner, books);
        scanner.close();
    }

    public static void homeScreen(Scanner scanner, Book[] books) {
        System.out.println();
        System.out.println("Welcome to the Neighborhood Library!");
        System.out.println("Select one of the options below:");
        System.out.println("1. Show Available Books");
        System.out.println("2. Show Checked Out Books");
        System.out.println("3. Exit");
        System.out.print("> ");
        int option = scanner.nextInt();
        scanner.nextLine();

        if (option == 1) {
            avaliableBooks(scanner, books);
        } else if (option == 2) {
            checkedOutBooks(scanner, books);
        } else if (option == 3) {
            System.out.println();
            System.out.println("Thank you for visiting the Neighborhood Library. Hope to see you again soon!");
        }
    }

    public static void avaliableBooks(Scanner scanner, Book[] books) {
        System.out.println();
        System.out.println("=== AVAILABLE BOOKS ===");

        for (Book book : books) {
            if (!book.isCheckedOut()) {
                System.out.println("id: " + book.getId());
                System.out.println("ISBN: " + book.getIsbn());
                System.out.println("Title: " + book.getTitle());
                System.out.println("=======================");
            }
        }

        System.out.println();
        System.out.println("Would you like to:");
        System.out.println("C. Check out a book");
        System.out.println("X. Exit");
        System.out.print("> ");
        String option = scanner.nextLine();

        if (option.equalsIgnoreCase("c")) {
            System.out.println();
            System.out.print("Enter the id of the book you'll like to check out: ");
            int id = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Enter your name: ");
            String name = scanner.nextLine();
            books[id - 1].checkOut(name);
            books[id - 1].setCheckedOut(true);

            System.out.println();
            System.out.println("Checking out '" + books[id - 1].getTitle() + "'...");
            pause(1000);
            System.out.println("Checking out to " + name + "...");
            pause(1000);
            System.out.println("Successfully checked out");
            pause(1000);
            System.out.println();
            System.out.println("Returning to home screen...");
            pause(1000);
            homeScreen(scanner, books);
        } else if (option.equalsIgnoreCase("x")) {
            System.out.println();
            System.out.println("Returning to home screen...");
            pause(1000);
            homeScreen(scanner, books);
        }
    }

    public static void checkedOutBooks(Scanner scanner, Book[] books) {
        System.out.println();
        System.out.println("=== CHECKED OUT BOOKS ===");

        int isEmpty = 0;

        for (Book book : books) {
            if (book.isCheckedOut()) {
                System.out.println("id: " + book.getId());
                System.out.println("ISBN: " + book.getIsbn());
                System.out.println("Title: " + book.getTitle());
                System.out.println("Checked out to: " + book.getCheckedOutTo());
                System.out.println("=========================");
                isEmpty += 1;
            }
        }

        if (isEmpty == 0) {
            System.out.println("No books have been checked out");
        }

        System.out.println();
        System.out.println("Would you like to:");

        if (isEmpty != 0) {
            System.out.println("C. Check in a book");
        }

        System.out.println("X. Exit");
        System.out.print("> ");
        String option = scanner.nextLine();

        if (option .equalsIgnoreCase("c")) {
            System.out.println();
            System.out.print("Enter the id of the book you'll like ot check in: ");
            int id = scanner.nextInt();
            scanner.nextLine();

            if (id > 0) {
                String name = books[id - 1].getCheckedOutTo();
                books[id - 1].checkIn();
                System.out.println();
                System.out.println("'" + books[id - 1].getTitle() + "' has been successfully checked in. Thank you " + name + "!");
                pause(1000);
                System.out.println();
                System.out.println("Returning to home screen...");
                pause(1000);
                homeScreen(scanner, books);
            }
        } else if (option.equalsIgnoreCase("x")) {
            System.out.println();
            System.out.println("Returning to home screen...");
            pause(1000);
            homeScreen(scanner, books);
        }
    }

    public static void pause(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


