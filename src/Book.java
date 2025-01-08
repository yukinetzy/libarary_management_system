public class Book {
    private String title;
    private String author;
    private String ISBN;
    private boolean isAvailable;

    public Book(String title, String author, String ISBN) {
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.isAvailable = true;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getISBN() {
        return ISBN;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void borrow() {
        if (isAvailable) {
            isAvailable = false;
            System.out.println("The book '" + title + "' has been borrowed.");
        } else {
            System.out.println("The book '" + title + "' is currently unavailable.");
        }
    }

    public void returnBook() {
        isAvailable = true;
        System.out.println("The book '" + title + "' has been returned.");
    }

    @Override
    public String toString() {
        return "Book: " + title + ", Author: " + author + ", ISBN: " + ISBN + ", Available: " + (isAvailable ? "Yes" : "No");
    }
}
