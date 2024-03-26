package project;

public class Book {
    private String title;
    private String author;
    private String isbn;
    private boolean isAvailable;

    // Constructor
    public Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.isAvailable = true; // By default, the book is available for borrowing.
    }

    // Getters
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getISBN() {
        return isbn;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    // Method to mark the book as borrowed
    public void borrowBook() {
        if(isAvailable) {
            isAvailable = false;
        } else {
            throw new IllegalStateException("This book is currently not available for borrowing.");
        }
    }

    // Optionally, you might want to add a method to mark the book as returned
    public void returnBook() {
        isAvailable = true;
    }
}

