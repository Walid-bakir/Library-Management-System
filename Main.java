public class Main {
    public static void main(String[] args) {
        // Create Books
        Book[] books = new Book[40];
        for (int i = 0; i < books.length; i++) {
            books[i] = new Book("Book " + (i + 1), "Author " + (i + 1), "ISBN" + (i + 1), 10.0 * (i + 1));
        }

        // Create Readers
        Reader[] readers = new Reader[5];
        for (int i = 0; i < readers.length; i++) {
            readers[i] = new Reader("Reader " + (i + 1), "ID" + (i + 1));
        }

        // Test Borrowing Books
        readers[0].borrowBook(books[0]); // Successful borrowing
        readers[0].borrowBook(books[1]); // Successful borrowing
        readers[1].borrowBook(books[0]); // Should be unsuccessful as it's already borrowed

        // Test Returning Books
        readers[0].returnBook(books[0]); // Successful return
        readers[1].borrowBook(books[0]); // Now it should be successful

        // Display Borrowed Books for a Reader
        readers[0].displayBooksBorrowed();

        // Simulate Overdue and Return Overdue Books
        // Here you need to manually adjust dates in the booksBorrowed HashMap of a reader to test overdue functionality
        // readers[2].returnOverdueBooks();

        // Display Readers and their borrowed books
        for (Reader reader : readers) {
            reader.displayBooksBorrowed();
        }
    }
}
