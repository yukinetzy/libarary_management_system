import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Library {
    private String name;
    private List<Book> books;
    private List<LibraryMember> members;

    public Library(String name) {
        this.name = name;
        this.books = new ArrayList<>();
        this.members = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void addMember(LibraryMember member) {
        members.add(member);
    }

    public List<LibraryMember> getMembers() {
        return members;
    }

    public void showBooks() {
        System.out.println("Books available in the library:");
        for (Book book : books) {
            System.out.println(book);
        }
    }

    public Book searchBookByTitle(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }

    public void borrowBook(LibraryMember member, String bookTitle) {
        Book book = searchBookByTitle(bookTitle);
        if (book != null) {
            book.borrow();
        } else {
            System.out.println("The book '" + bookTitle + "' is not available in the library.");
        }
    }

    public void returnBook(LibraryMember member, String bookTitle) {
        Book book = searchBookByTitle(bookTitle);
        if (book != null) {
            book.returnBook();
        } else {
            System.out.println("The book '" + bookTitle + "' is not part of our collection.");
        }
    }

    public void showMembers() {
        System.out.println("Library Members:");
        for (LibraryMember member : members) {
            System.out.println(member);
        }
    }

    public static void main(String[] args) {
        Library library = new Library("City Central Library");

        // Adding books to the library
        library.addBook(new Book("Java Programming", "James Gosling", "12345"));
        library.addBook(new Book("Data Structures", "Donald Knuth", "67890"));
        library.addBook(new Book("Algorithms", "Robert Sedgewick", "11223"));

        // Adding members to the library
        library.addMember(new LibraryMember("John Doe", "M001", 25));
        library.addMember(new LibraryMember("Jane Smith", "M002", 30));

        // Interaction
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Show all books");
            System.out.println("2. Borrow a book");
            System.out.println("3. Return a book");
            System.out.println("4. Show all library members");
            System.out.println("5. Exit");

            int option = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (option) {
                case 1:
                    library.showBooks();
                    break;
                case 2:
                    System.out.println("Enter your member ID: ");
                    String memberId = scanner.nextLine();
                    System.out.println("Enter book title to borrow: ");
                    String borrowTitle = scanner.nextLine();
                    LibraryMember member = library.members.stream()
                            .filter(m -> m.getMemberID().equals(memberId))
                            .findFirst()
                            .orElse(null);
                    if (member != null) {
                        library.borrowBook(member, borrowTitle);
                    } else {
                        System.out.println("Member not found.");
                    }
                    break;
                case 3:
                    System.out.println("Enter your member ID: ");
                    String returnMemberId = scanner.nextLine();
                    System.out.println("Enter book title to return: ");
                    String returnTitle = scanner.nextLine();
                    LibraryMember returnMember = library.members.stream()
                            .filter(m -> m.getMemberID().equals(returnMemberId))
                            .findFirst()
                            .orElse(null);
                    if (returnMember != null) {
                        library.returnBook(returnMember, returnTitle);
                    } else {
                        System.out.println("Member not found.");
                    }
                    break;
                case 4:
                    library.showMembers();
                    break;
                case 5:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid option. Try again.");
                    break;
            }
        }

        scanner.close();
    }
}
