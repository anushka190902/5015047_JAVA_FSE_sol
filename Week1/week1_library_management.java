import java.util.ArrayList;
class Book {
    int bookId;
    String title;
    String author;

    public Book(int bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}


public class BookSearch {

    // Linear search for a book by title
    public static Book linearSearch(ArrayList<Book> books, String targetTitle) {
        for (Book book : books) {
            if (book.title.equalsIgnoreCase(targetTitle)) {
                return book;
            }
        }
        return null; // Book not found
    }
    // Binary search for a book by title (assuming the list is sorted)
    public static Book binarySearch(Book[] books, String targetTitle) {
        int low = 0;
        int high = books.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int cmp = books[mid].title.compareToIgnoreCase(targetTitle);

            if (cmp == 0) {
                return books[mid]; // Book found
            } else if (cmp < 0) {
                low = mid + 1; // Search in the right half
            } else {
                high = mid - 1; // Search in the left half
            }
        }
        return null; // Book not found
    }

    public static void main(String[] args) {
        ArrayList<Book> books = new ArrayList<>();
        books.add(new Book(1, "To Kill a Mockingbird", "Harper Lee"));
        books.add(new Book(2, "1984", "George Orwell"));
        books.add(new Book(3, "The Great Gatsby", "F. Scott Fitzgerald"));

        String searchTitle = "1984";
        Book foundBook = linearSearch(books, searchTitle);
        if (foundBook != null) {
            System.out.println("Book found: " + foundBook);
        } else {
            System.out.println("Book not found.");
        }
        
    }
}
