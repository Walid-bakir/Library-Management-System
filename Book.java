public class Book {
    // Attributes
    private String name;
    private String author;
    private String isbn;
    private double price;
    private Reader isBorrowed; // Reference to the Reader who has borrowed the book

    // Constructor
    public Book(String name, String author, String isbn, double price) {
        this.name = name;
        this.author = author;
        this.isbn = isbn;
        this.price = price;
        this.isBorrowed = null; // By default, the book is not borrowed when created
    }

    // Getters
    public String getName() {
        return this.name;
    }

    public String getAuthor() {
        return this.author;
    }

    public String getIsbn() {
        return this.isbn;
    }

    public double getPrice() {
        return this.price;
    }

    public Reader getIsBorrowed() {
        return this.isBorrowed; // Returns the Reader object or null
    }

    // Setters
    public void setIsBorrowed(Reader reader) {
        this.isBorrowed = reader; // Sets the Reader who has borrowed the book
    }

    public void resetIsBorrowed() {
        this.isBorrowed = null; // Resets the borrowed status
    }

    // Display Book Information
    public void displayInfo() {
        System.out.println("Book Name: " + name);
        System.out.println("Author: " + author);
        System.out.println("ISBN: " + isbn);
        System.out.println("Price: " + price);
        String borrowedStatus = (isBorrowed != null) ? "Yes, by " + isBorrowed.getName() : "No";
        System.out.println("Borrowed: " + borrowedStatus);
    }
}
