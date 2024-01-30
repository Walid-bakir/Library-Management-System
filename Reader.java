import java.util.HashMap;
import java.util.ArrayList;
import java.util.Map;
import java.time.LocalDate;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Reader {
    private String name;
    private String id;
    private HashMap<Book, LocalDate> booksBorrowed;
    private double totalBorrowedValue;

    // Constructor
    public Reader(String name, String id) {
        this.name = name;
        this.id = id;
        this.booksBorrowed = new HashMap<>();
        this.totalBorrowedValue = 0.0;
    }

    // Getters
    public String getName() {
        return this.name;
    }

    public String getId() {
        return this.id;
    }

    // Method to borrow a book
    public void borrowBook(Book book) {
        if (book.getIsBorrowed() == null && (this.totalBorrowedValue + book.getPrice() <= 1000)) {
            this.booksBorrowed.put(book, LocalDate.now()); // Current date
            this.totalBorrowedValue += book.getPrice();
            book.setIsBorrowed(this);
        } else {
            System.out.println("The book is either already borrowed or exceeds the borrowing limit.");
        }
    }

    // Method to return a book
    public void returnBook(Book book) {
        if (this.booksBorrowed.containsKey(book)) {
            this.totalBorrowedValue -= book.getPrice();
            this.booksBorrowed.remove(book);
            book.resetIsBorrowed();
        } else {
            System.out.println("This book was not borrowed by this reader.");
        }
    }

    // Method to check for overdue books
    public void checkOverdueBooks() {
        LocalDate today = LocalDate.now();
        for (Map.Entry<Book, LocalDate> entry : booksBorrowed.entrySet()) {
            LocalDate borrowedDate = entry.getValue();
            if (borrowedDate.plusDays(30).isBefore(today)) {
                System.out.println(entry.getKey().getName() + " is overdue.");
            }
        }
    }

    // Method to return overdue books
    public void returnOverdueBooks() {
        LocalDate today = LocalDate.now();
        ArrayList<Book> overdueBooks = new ArrayList<>();

        // First, identify overdue books
        for (Map.Entry<Book, LocalDate> entry : booksBorrowed.entrySet()) {
            LocalDate borrowedDate = entry.getValue();
            if (borrowedDate.plusDays(30).isBefore(today)) {
                overdueBooks.add(entry.getKey());
            }
        }

        // Then, return them
        for (Book book : overdueBooks) {
            returnBook(book);
        }
    }


    // Method to display books borrowed by the reader
    public void displayBooksBorrowed() {


        if (totalBorrowedValue != 0){
          System.out.println("Books borrowed by " + this.name + ":");
          for (Book book : this.booksBorrowed.keySet()) {
              System.out.println(book.getName() + " by " + book.getAuthor());
          }
        } else{
          System.out.println(this.getName() +  " has no borrowed books");
        }
    }

    // Method to save reader's borrowed books to a file
    public void saveReaderData() {
        String filename = "readers/" + this.id + ".txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (Map.Entry<Book, LocalDate> entry : booksBorrowed.entrySet()) {
                Book book = entry.getKey();
                LocalDate borrowDate = entry.getValue();
                String line = book.getIsbn() + "," + borrowDate.toString() + "\n";
                writer.write(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    
}
