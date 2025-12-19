//Task 1
//public class Main {
//    public static void main(String[] args) {
//        Rectangle r1 = new Rectangle();
//        Rectangle r2 = new Rectangle(3, 4);
//
//        System.out.println(r1);
//        System.out.println(r2);
//    }
//}
//
//class Rectangle {
//
//    private double width;
//    private double height;
//    private int id;
//    private static int idGen = 1;
//
//    public Rectangle() {
//        width = 1.0;
//        height = 1.0;
//        id = idGen++;
//    }
//
//    public Rectangle(double width, double height) {
//        this();
//        setWidth(width);
//        setHeight(height);
//    }
//
//    public double getWidth() {
//        return width;
//    }
//
//    public void setWidth(double width) {
//        if (width <= 0) {
//            throw new IllegalArgumentException("Width must be greater than 0");
//        }
//        this.width = width;
//    }
//
//    public double getHeight() {
//        return height;
//    }
//
//    public void setHeight(double height) {
//        if (height <= 0) {
//            throw new IllegalArgumentException("Height must be greater than 0");
//        }
//        this.height = height;
//    }
//
//    public double area() {
//        return width * height;
//    }
//
//    public double perimeter() {
//        return 2 * (width + height);
//    }
//
//    @Override
//    public String toString() {
//        return "Rectangle id=" + id + ", width=" + width + ", height=" + height;
//    }
//}
//Task 2
//public class Main {
//    public static void main(String[] args) {
//        Book b1 = new Book("Java Basics", "John Smith", 2020);
//        Book b2 = new Book();
//
//        b1.markAsBorrowed();
//
//        System.out.println(b1);
//        System.out.println(b2);
//    }
//}
//
//class Book {
//
//    private int id;
//    private static int idGen = 1;
//    private String title;
//    private String author;
//    private int year;
//    private boolean available;
//
//    // Default constructor
//    public Book() {
//        id = idGen;
//        idGen++;
//        available = true;
//    }
//
//    // Constructor with parameters
//    public Book(String title, String author, int year) {
//        this();
//        setTitle(title);
//        setAuthor(author);
//        setYear(year);
//    }
//
//    // Getters and setters
//    public int getId() {
//        return id;
//    }
//
//    public String getTitle() {
//        return title;
//    }
//
//    public void setTitle(String title) {
//        if (title == null || title.isEmpty()) {
//            throw new IllegalArgumentException("Title cannot be empty");
//        }
//        this.title = title;
//    }
//
//    public String getAuthor() {
//        return author;
//    }
//
//    public void setAuthor(String author) {
//        if (author == null || author.isEmpty()) {
//            throw new IllegalArgumentException("Author cannot be empty");
//        }
//        this.author = author;
//    }
//
//    public int getYear() {
//        return year;
//    }
//
//    public void setYear(int year) {
//        int currentYear = 2025;
//        if (year < 1500 || year > currentYear) {
//            throw new IllegalArgumentException("Year is not valid");
//        }
//        this.year = year;
//    }
//
//    public boolean isAvailable() {
//        return available;
//    }
//
//    public void setAvailable(boolean available) {
//        this.available = available;
//    }
//
//    public void markAsBorrowed() {
//        available = false;
//    }
//
//    public void markAsReturned() {
//        available = true;
//    }
//
//    @Override
//    public String toString() {
//        return "Book id=" + id +
//                ", title=" + title +
//                ", author=" + author +
//                ", year=" + year +
//                ", available=" + available;
//    }
//}
//Task 3
//import java.util.ArrayList;
//import java.util.Scanner;
//
//public class Main {
//    public static void main(String[] args) {
//        LibraryApp app = new LibraryApp();
//        app.run();
//    }
//}
//
//class LibraryApp {
//
//    private ArrayList<Book> books = new ArrayList<>();
//    private Scanner scanner = new Scanner(System.in);
//
//    public void run() {
//        boolean running = true;
//
//        while (running) {
//            System.out.println("\nWelcome to Library App!");
//            System.out.println("1. Print all books");
//            System.out.println("2. Add new book");
//            System.out.println("3. Search books by title");
//            System.out.println("4. Borrow a book");
//            System.out.println("5. Return a book");
//            System.out.println("6. Delete a book by id");
//            System.out.println("7. Quit");
//
//            System.out.print("Choose option: ");
//            int choice = scanner.nextInt();
//            scanner.nextLine(); // clear line
//
//            switch (choice) {
//                case 1:
//                    printAllBooks();
//                    break;
//                case 2:
//                    addNewBook();
//                    break;
//                case 3:
//                    searchByTitle();
//                    break;
//                case 4:
//                    borrowBook();
//                    break;
//                case 5:
//                    returnBook();
//                    break;
//                case 6:
//                    deleteBook();
//                    break;
//                case 7:
//                    running = false;
//                    System.out.println("Goodbye!");
//                    break;
//                default:
//                    System.out.println("Wrong choice");
//            }
//        }
//    }
//
//    private void printAllBooks() {
//        if (books.isEmpty()) {
//            System.out.println("No books in the library");
//            return;
//        }
//        for (Book b : books) {
//            System.out.println(b);
//        }
//    }
//
//    private void addNewBook() {
//        System.out.print("Title: ");
//        String title = scanner.nextLine();
//
//        System.out.print("Author: ");
//        String author = scanner.nextLine();
//
//        System.out.print("Year: ");
//        int year = scanner.nextInt();
//        scanner.nextLine();
//
//        Book book = new Book(title, author, year);
//        books.add(book);
//
//        System.out.println("Book added");
//    }
//
//    private void searchByTitle() {
//        System.out.print("Enter part of title: ");
//        String text = scanner.nextLine().toLowerCase();
//
//        boolean found = false;
//        for (Book b : books) {
//            if (b.getTitle().toLowerCase().contains(text)) {
//                System.out.println(b);
//                found = true;
//            }
//        }
//
//        if (!found) {
//            System.out.println("No books found");
//        }
//    }
//
//    private void borrowBook() {
//        System.out.print("Enter book id: ");
//        int id = scanner.nextInt();
//        scanner.nextLine();
//
//        Book book = findById(id);
//        if (book == null) {
//            System.out.println("Book not found");
//            return;
//        }
//
//        if (book.isAvailable()) {
//            book.markAsBorrowed();
//            System.out.println("Book borrowed");
//        } else {
//            System.out.println("Book is already borrowed");
//        }
//    }
//
//    private void returnBook() {
//        System.out.print("Enter book id: ");
//        int id = scanner.nextInt();
//        scanner.nextLine();
//
//        Book book = findById(id);
//        if (book == null) {
//            System.out.println("Book not found");
//            return;
//        }
//
//        if (!book.isAvailable()) {
//            book.markAsReturned();
//            System.out.println("Book returned");
//        } else {
//            System.out.println("Book was not borrowed");
//        }
//    }
//
//    private void deleteBook() {
//        System.out.print("Enter book id: ");
//        int id = scanner.nextInt();
//        scanner.nextLine();
//
//        Book book = findById(id);
//        if (book == null) {
//            System.out.println("Book not found");
//            return;
//        }
//
//        books.remove(book);
//        System.out.println("Book deleted");
//    }
//
//    private Book findById(int id) {
//        for (Book b : books) {
//            if (b.getId() == id) {
//                return b;
//            }
//        }
//        return null;
//    }
//}
//
//class Book {
//
//    private int id;
//    private static int idGen = 1;
//    private String title;
//    private String author;
//    private int year;
//    private boolean available;
//
//    public Book() {
//        id = idGen++;
//        available = true;
//    }
//
//    public Book(String title, String author, int year) {
//        this();
//        setTitle(title);
//        setAuthor(author);
//        setYear(year);
//    }
//
//    public int getId() {
//        return id;
//    }
//
//    public String getTitle() {
//        return title;
//    }
//
//    public void setTitle(String title) {
//        if (title == null || title.isEmpty()) {
//            throw new IllegalArgumentException();
//        }
//        this.title = title;
//    }
//
//    public String getAuthor() {
//        return author;
//    }
//
//    public void setAuthor(String author) {
//        if (author == null || author.isEmpty()) {
//            throw new IllegalArgumentException();
//        }
//        this.author = author;
//    }
//
//    public int getYear() {
//        return year;
//    }
//
//    public void setYear(int year) {
//        int currentYear = 2025;
//        if (year < 1500 || year > currentYear) {
//            throw new IllegalArgumentException();
//        }
//        this.year = year;
//    }
//
//    public boolean isAvailable() {
//        return available;
//    }
//
//    public void markAsBorrowed() {
//        available = false;
//    }
//
//    public void markAsReturned() {
//        available = true;
//    }
//
//    @Override
//    public String toString() {
//        return "Book id=" + id +
//                ", title=" + title +
//                ", author=" + author +
//                ", year=" + year +
//                ", available=" + available;
//    }
//}
