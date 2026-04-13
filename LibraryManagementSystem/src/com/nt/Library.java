package com.nt;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

class Library {
    private List<Book> books;
    private List<User> users;

    public Library() {
        books = new ArrayList<>();
        users = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
        System.out.println("Book added successfully: " + book);
    }

    public void updateBook(String bookId, String newTitle, String newAuthor) {
        for (Book book : books) {
            if (book.getId().equals(bookId)) {
                books.remove(book);
                books.add(new Book(bookId, newTitle, newAuthor));
                System.out.println("Book updated successfully.");
                return;
            }
        }
        System.out.println("Book not found.");
    }

    public void deleteBook(String bookId) {
        books.removeIf(book -> book.getId().equals(bookId));
        System.out.println("Book deleted successfully.");
    }

    public void borrowBook(String userId, String bookId) {
        User user = getUserById(userId);
        Book book = getBookById(bookId);

        if (user == null) {
            System.out.println("User not found.");
            return;
        }
        if (book == null || book.isBorrowed()) {
            System.out.println("Book not available for borrowing.");
            return;
        }

        book.setBorrowed(true);
        user.borrowBook(book);
        System.out.println("Book borrowed successfully.");
    }

    public void returnBook(String userId, String bookId) {
        User user = getUserById(userId);
        Book book = getBookById(bookId);

        if (user == null || book == null || !book.isBorrowed()) {
            System.out.println("Invalid return request.");
            return;
        }

        book.setBorrowed(false);
        user.returnBook(book);
        System.out.println("Book returned successfully.");
    }

    public void trackOverdueBooks() {
        System.out.println("Overdue Books:");
        for (User user : users) {
            for (Map.Entry<Book, LocalDate> entry : user.getBorrowedBooks().entrySet()) {
                if (entry.getValue().plusDays(14).isBefore(LocalDate.now())) {
                    System.out.println("User: " + user.getName() + ", Book: " + entry.getKey().getTitle() + ", Borrowed on: " + entry.getValue());
                }
            }
        }
    }

    public void addUser(User user) {
        users.add(user);
        System.out.println("User added successfully: " + user);
    }

    private User getUserById(String userId) {
        return users.stream().filter(user -> user.getId().equals(userId)).findFirst().orElse(null);
    }

    private Book getBookById(String bookId) {
        return books.stream().filter(book -> book.getId().equals(bookId)).findFirst().orElse(null);
    }

    public void displayLibrary() {
        System.out.println("\nLibrary Books:");
        books.forEach(System.out::println);
        System.out.println("\nLibrary Users:");
        users.forEach(System.out::println);
    }
}