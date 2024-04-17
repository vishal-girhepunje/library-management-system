package library;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.Stack;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Vector;

//Library class to manage books and members
class Library {
 private ArrayList<Book> books;
 private LinkedList<String> waitingList;
 private Vector<String> members;
 private Stack<Book> returnedBooks;
 private HashSet<String> uniqueMembers;
 private LinkedHashSet<Book> borrowedBooks;
 private TreeSet<String> sortedBookTitles;
 private HashMap<Integer, Book> bookDetails;
 private LinkedHashMap<Integer, Book> bookCheckoutOrder;
 private TreeMap<Integer, Book> sortedBooksById;

 public Library() {
     // Initialize data structures
     books = new ArrayList<>();
     waitingList = new LinkedList<>();
     members = new Vector<>();
     returnedBooks = new Stack<>();
     uniqueMembers = new HashSet<>();
     borrowedBooks = new LinkedHashSet<>();
     sortedBookTitles = new TreeSet<>();
     bookDetails = new HashMap<>();
     bookCheckoutOrder = new LinkedHashMap<>();
     sortedBooksById = new TreeMap<>();
 }

 // Method to add a book to the library
 public void addBook(Book book) {
     books.add(book);
     bookDetails.put(book.getId(), book);
     sortedBookTitles.add(book.getTitle());
     sortedBooksById.put(book.getId(), book);
 }

 // Method to borrow a book
 public void borrowBook(int memberId, int bookId) throws BookNotAvailableException {
     // Check if the book is available
     if (!books.contains(bookDetails.get(bookId))) {
         throw new BookNotAvailableException("Book with ID " + bookId + " is not available for checkout.");
     }

     // Add member to unique members set
     uniqueMembers.add(String.valueOf(memberId));

     // Add book to borrowed books
     borrowedBooks.add(bookDetails.get(bookId));

     // Add book to checkout order
     bookCheckoutOrder.put(bookId, bookDetails.get(bookId));
 }

 // Method to return a book
 public void returnBook(int bookId) {
     // Remove book from borrowed books
     borrowedBooks.remove(bookDetails.get(bookId));

     // Remove book from checkout order
     bookCheckoutOrder.remove(bookId);

     // Push book to returned books stack
     returnedBooks.push(bookDetails.get(bookId));
 }

 // Method to get the number of unique members
 public int getNumberOfUniqueMembers() {
     return uniqueMembers.size();
 }

 // Method to get the number of books borrowed
 public int getNumberOfBooksBorrowed() {
     return borrowedBooks.size();
 }

 // Method to get the list of borrowed books in checkout order
 public List<Book> getBorrowedBooksCheckoutOrder() {
     return new ArrayList<>(bookCheckoutOrder.values());
 }

 // Method to get the list of books sorted by title
 public Set<String> getBooksSortedByTitle() {
     return sortedBookTitles;
 }

 // Method to get the list of books sorted by ID
 public Collection<Book> getBooksSortedById() {
     return sortedBooksById.values();
 }


}

