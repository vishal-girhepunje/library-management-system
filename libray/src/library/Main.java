package library;

public class Main {
    public static void main(String[] args) {
        // Create Library object
        Library library = new Library();

        // Add books to the library
        Book book1 = new Book(1, "The Great Gatsby", "The Zilla Gaziabaad");
        Book book2 = new Book(2, "To Kill a Mockingbird", "Secret of Success");
        Book book3 = new Book(3, "1984", "Rich DaD Poor Dad");

        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);

        // Borrow books
        try {
            library.borrowBook(101, 1);
            library.borrowBook(102, 2);
            library.borrowBook(103, 3);
        } catch (BookNotAvailableException e) {
            System.out.println(e.getMessage());
        }

        // Return a book
        library.returnBook(2);

        // Print library statistics
        System.out.println("Number of unique members: " + library.getNumberOfUniqueMembers());
        System.out.println("Number of books borrowed: " + library.getNumberOfBooksBorrowed());
        System.out.println("Borrowed books in checkout order: " + library.getBorrowedBooksCheckoutOrder());
        System.out.println("Books sorted by title: " + library.getBooksSortedByTitle());
        System.out.println("Books sorted by ID: " + library.getBooksSortedById());
    }
}

