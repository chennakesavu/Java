package com.nt;

import java.util.Scanner;

public class LibraryManagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Library library = new Library();

        while (true) {
            System.out.println("\n--- Library Management System ---");
            System.out.println("1. Add Book");
            System.out.println("2. Update Book");
            System.out.println("3. Delete Book");
            System.out.println("4. Borrow Book");
            System.out.println("5. Return Book");
            System.out.println("6. Track Overdue Books");
            System.out.println("7. Add User");
            System.out.println("8. Display Library");
            System.out.println("9. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Book ID: ");
                    String bookId = scanner.nextLine();
                    System.out.print("Enter Book Title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter Book Author: ");
                    String author = scanner.nextLine();
                    library.addBook(new Book(bookId, title, author));
                    break;
                case 2:
                    System.out.print("Enter Book ID to update: ");
                    bookId = scanner.nextLine();
                    System.out.print("Enter New Title: ");
                    title = scanner.nextLine();
                    System.out.print("Enter New Author: ");
                    author = scanner.nextLine();
                    library.updateBook(bookId, title, author);
                    break;
                case 3:
                    System.out.print("Enter Book ID to delete: ");
                    bookId = scanner.nextLine();
                    library.deleteBook(bookId);
                    break;
                case 4:
                    System.out.print("Enter User ID: ");
                    String userId = scanner.nextLine();
                    System.out.print("Enter Book ID: ");
                    bookId = scanner.nextLine();
                    library.borrowBook(userId, bookId);
                    break;
                case 5:
                    System.out.print("Enter User ID: ");
                    userId = scanner.nextLine();
                    System.out.print("Enter Book ID: ");
                    bookId = scanner.nextLine();
                    library.returnBook(userId, bookId);
                    break;
                case 6:
                    library.trackOverdueBooks();
                    break;
                case 7:
                    System.out.print("Enter User ID: ");
                    userId = scanner.nextLine();
                    System.out.print("Enter User Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter User Role (Student/Librarian): ");
                    String role = scanner.nextLine();
                    library.addUser(new User(userId, name, role));
                    break;
                case 8:
                    library.displayLibrary();
                    break;
                case 9:
                    System.out.println("Exiting the system. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
