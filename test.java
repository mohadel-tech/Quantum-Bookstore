import java.util.*;

class QuantumBookstoreFullTest {
    public static void main(String[] args) {
        QuantumBookstore store = new QuantumBookstore();

        System.out.println("Quantum book store: Starting Full Test");
        System.out.println("======================================");

        testAddingBooks(store);

        testBuyingBooks(store);

        testRemovingOutdatedBooks(store);

        testErrorScenarios(store);

        System.out.println("Quantum book store: Full Test Completed");
    }

     public static void testAddingBooks(QuantumBookstore store) {
        System.out.println("\nQuantum book store: Testing Adding Books");
        System.out.println("----------------------------------------");

        // Add different types of books
        store.addBook(new paperBook("978-0134685991", "Effective Java", "Joshua Bloch", 2017, 45.99, 10));
        store.addBook(new ebook("978-0321356680", "Effective C++", "Scott Meyers", 2005, 35.99, "PDF"));
        store.addBook(new demoBook("978-0201633610", "Design Patterns", "Gang of Four", 1994));
        store.addBook(new paperBook("978-0132350884", "Clean Code", "Robert Martin", 2008, 42.99, 5));
        store.addBook(
                new ebook("978-0596009205", "Head First Design Patterns", "Freeman & Robson", 2004, 39.99, "EPUB"));

        store.displayInventory();
    }

    public static void testBuyingBooks(QuantumBookstore store) {
        System.out.println("\nQuantum book store: Testing Buying Books");
        System.out.println("----------------------------------------");

        try {
            // Buy a paper book
            double amount1 = store.buyBook("978-0134685991", 2, "customer@example.com", "123 Main St, City, State");
            System.out.println("Purchase 1 completed. Amount paid: $" + String.format("%.2f", amount1));

            // Buy an ebook
            double amount2 = store.buyBook("978-0321356680", 1, "customer@example.com", "");
            System.out.println("Purchase 2 completed. Amount paid: $" + String.format("%.2f", amount2));

            // Display updated inventory
            store.displayInventory();

        } catch (Exception e) {
            System.out.println("Purchase failed: " + e.getMessage());
        }
    }

    public static void testRemovingOutdatedBooks(QuantumBookstore store) {
        System.out.println("\nQuantum book store: Testing Removing Outdated Books");
        System.out.println("---------------------------------------------------");

        // Remove books older than 15 years
        List<book> removedBooks = store.removeOutdatedBooks(15);

        System.out.println("Removed " + removedBooks.size() + " outdated books:");
        for (book book : removedBooks) {
            System.out.println("- " + book);
        }

        store.displayInventory();
    }

    public static void testErrorScenarios(QuantumBookstore store) {
        System.out.println("\nQuantum book store: Testing Error Scenarios");
        System.out.println("-------------------------------------------");

        // Test buying non-existent book
        try {
            store.buyBook("invalid-isbn", 1, "customer@example.com", "123 Main St");
        } catch (Exception e) {
            System.out.println("Expected error: " + e.getMessage());
        }

        // Test buying showcase book
        try {
            store.buyBook("978-0201633610", 1, "customer@example.com", "123 Main St");
        } catch (Exception e) {
            System.out.println("Expected error: " + e.getMessage());
        }

        // Test buying more stock than available
        try {
            store.buyBook("978-0132350884", 10, "customer@example.com", "123 Main St");
        } catch (Exception e) {
            System.out.println("Expected error: " + e.getMessage());
        }
    }
}