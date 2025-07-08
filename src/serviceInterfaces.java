class ShippingService {
    public static void shipBook(paperBook book, int quantity, String address) {
        System.out.println("Quantum book store: Shipping " + quantity + " copies of '" +
                book.getTitle() + "' to address: " + address);
    }
}

class MailService {
    public static void sendEBook(ebook book, int quantity, String email) {
        System.out.println("Quantum book store: Sending " + quantity + " copies of '" +
                book.getTitle() + "' (" + book.getFiletype() + ") to email: " + email);
    }
}