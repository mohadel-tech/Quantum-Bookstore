class demoBook extends book {
    
    public demoBook(String isbn, String title, String author, int year) {
        super(isbn, title, author, year, 0.0); 
    }
    
    @Override
    public String getBookType() {
        return "Showcase";
    }
    
    @Override
    public boolean isPurchasable() { 
        return false; 
    }
    
    @Override
    public double processPurchase(int quantity, String email, String address) throws Exception {
        throw new Exception("Quantum book store: Showcase books are not for sale");
    }
}
