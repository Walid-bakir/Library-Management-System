public class Test {
    public static void main(String[] args) {
        // Create Books
        Book book1 = new Book("To Kill a Mockingbird", "Harper Lee", "978-0-06-112008-4", 10.99);
        Book book2 = new Book("1984", "George Orwell", "978-0-452-28423-4", 9.99);
        Book book3 = new Book("The Great Gatsby", "F. Scott Fitzgerald", "978-0-7432-7356-5", 8.99);
        Book book4 = new Book("One Hundred Years of Solitude", "Gabriel Garcia Marquez", "978-0-06-088328-7", 12.99);
        Book book5 = new Book("A Passage to India", "E.M. Forster", "978-0-15-671142-5", 11.99);
        Book book6 = new Book("Invisible Man", "Ralph Ellison", "978-0-679-60139-5", 14.99);
        Book book7 = new Book("Don Quixote", "Miguel de Cervantes", "978-0-06-093434-7", 13.99);
        Book book8 = new Book("Beloved", "Toni Morrison", "978-0-09-976011-5", 9.99);
        Book book9 = new Book("Mrs. Dalloway", "Virginia Woolf", "978-0-15-662870-9", 7.99);
        Book book10 = new Book("Jane Eyre", "Charlotte Bronte", "978-0-14-144114-6", 10.99);

        // Create Reader
        Reader reader = new Reader("John Doe", "JD123");

        // Borrow Books
        reader.borrowBook(book1);
        reader.borrowBook(book4);
        reader.borrowBook(book7);
        reader.borrowBook(book10);

        // Display Borrowed Books
        System.out.println("Books borrowed by " + reader.getName() + ":");
        reader.displayBooksBorrowed();

        // Optionally, save the reader's data
        reader.saveReaderData();
    }
}
