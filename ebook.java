class ebook extends book {
    private String filetype;
    
    public ebook(String isbn, String title, String author, int year, double price, String filetype) {
        super(isbn, title, author, year, price);
        this.filetype = filetype;
    }
    
    public String getFiletype() { 
        return filetype; 
    }
    
    @Override
    public String getBookType() {
        return "ebook";
    }
    
    @Override
    public boolean isPurchased() {
        return true; 
    }
    
    @Override
    public double processPurchase(int quantity, String email, String address) throws Exception {
        double totalAmount = price * quantity;
        
        MailService.sendEBook(this, quantity, email);
        
        return totalAmount;
    }
}