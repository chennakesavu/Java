package com.nt;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class User {
    private String id;
    private String name;
    private String role; // e.g., Student or Librarian
    private Map<Book, LocalDate> borrowedBooks;

    public User(String id, String name, String role) {
        this.id = id;
        this.name = name;
        this.role = role;
        this.borrowedBooks = new HashMap<>();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getRole() {
        return role;
    }

    public Map<Book, LocalDate> getBorrowedBooks() {
        return borrowedBooks;
    }

    public void borrowBook(Book book) {
        borrowedBooks.put(book, LocalDate.now());
    }

    public void returnBook(Book book) {
        borrowedBooks.remove(book);
    }

    @Override
    public String toString() {
        return "User{" +
                "ID='" + id + '\'' +
                ", Name='" + name + '\'' +
                ", Role='" + role + '\'' +
                ", BorrowedBooks=" + borrowedBooks.size() +
                '}';
    }
}