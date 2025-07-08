import java.util.*;
import java.time.LocalDate;

class QuantumBookstore {
    private Map<String, book> inventory;

    public QuantumBookstore() {
        this.inventory = new HashMap<>();
    }

    // Add a book to the inventory
    public void addBook(book book) {
        inventory.put(book.getIsbn(), book);
        System.out.println("Quantum book store: Added book - " + book);
    }

    // Remove and return outdated books
    public List<book> removeOutdatedBooks(int yearsThreshold) {
        List<book> removedBooks = new ArrayList<>();
        int currentYear = LocalDate.now().getYear();

        Iterator<Map.Entry<String, book>> iterator = inventory.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, book> entry = iterator.next();
            book book = entry.getValue();

            if (currentYear - book.getYearPublished() > yearsThreshold) {
                removedBooks.add(book);
                iterator.remove();
                System.out.println("Quantum book store: Removed outdated book - " + book);
            }
        }
        return removedBooks;
    }

    // Buy a book
    public double buyBook(String isbn, int quantity, String email, String address) throws Exception {
        book book = inventory.get(isbn);

        if (book == null) {
            throw new Exception("Quantum book store: Book with ISBN " + isbn + " not found");
        }

        if (!book.isPurchased()) {
            throw new Exception("Quantum book store: Book '" + book.getTitle() + "' is not available for purchase");
        }

        double totalAmount = book.processPurchase(quantity, email, address);

        System.out.println("Quantum book store: Purchase successful. Total amount: $" +
                String.format("%.2f", totalAmount));

        return totalAmount;
    }

    // Get book by ISBN
    public book getBook(String isbn) {
        return inventory.get(isbn);
    }

    // Get all books
    public Collection<book> getAllBooks() {
        return inventory.values();
    }

    // Display inventory
    public void displayInventory() {
        System.out.println("Quantum book store: Current Inventory:");
        System.out.println("=====================================");

        if (inventory.isEmpty()) {
            System.out.println("No books in inventory.");
            return;
        }

        for (book book : inventory.values()) {
            System.out.println(book + " - Type: " + book.getBookType() +
                    " - Price: $" + String.format("%.2f", book.getPrice()));

            if (book instanceof paperBook) {
                System.out.println("  Stock: " + ((paperBook) book).getStock());
            } else if (book instanceof ebook) {
                System.out.println("  Format: " + ((ebook) book).getFiletype());
            } else if (book instanceof demoBook) {
                System.out.println("  Status: Demo/Showcase (Not for sale)");
            }
            System.out.println();
        }
    }
}
