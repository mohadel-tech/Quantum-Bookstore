class paperBook extends book {
    private int stock;
    
    public paperBook(String isbn, String title, String author, int year, double price, int stock) {
        super(isbn, title, author, year, price);
        this.stock = stock;
    }
    
    public int getStock() { 
        return stock; 
    }
    public void setStock(int stock) { 
        this.stock = stock; 
    }
    
    @Override
    public String getBookType() {
        return "Paper";
    }
    
    @Override
    public boolean isPurchasable() { 
        return stock > 0;
    }
    
    @Override
    public double processPurchase(int quantity, String email, String address) throws Exception {
        if (quantity > stock) {
            throw new Exception("Quantum book store: Insufficient stock. Available: " + stock + ", Requested: " + quantity);
        }
        
        stock -= quantity;
        double totalAmount = price * quantity;
        
       
        ShippingService.shipBook(this, quantity, address);
        
        return totalAmount;
    }
}
