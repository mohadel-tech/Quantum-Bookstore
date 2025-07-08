# Quantum-Bookstore


A Java-based bookstore management system that demonstrates object-oriented programming principles including inheritance, polymorphism, and abstract classes.

![image](https://github.com/user-attachments/assets/69077027-094c-490c-aa2f-5675d7ea7119)
![image](https://github.com/user-attachments/assets/3084ef37-bbd8-432e-a55e-ac7b9766c988)


## Overview

The Quantum Bookstore system manages different types of books (paper books, ebooks, and demo books) with various functionalities including inventory management, purchasing, and automated cleanup of outdated books.

## Features

- **Multi-type Book Management**: Support for paper books, ebooks, and demo/showcase books
- **Inventory Management**: Add books to inventory and display current stock
- **Purchase System**: Buy books with different processing for each book type
- **Automated Cleanup**: Remove outdated books based on publication year
- **Error Handling**: Comprehensive error scenarios for invalid purchases

## Project Structure

```
src/
├── QuantumBookstoreFullTest.java    # Main test class with comprehensive testing
├── bookStore.java                   # Main bookstore management class
├── book.java                        # Abstract base class for all books
├── paperBook.java                   # Paper book implementation
├── ebook.java                       # Electronic book implementation
├── demoBook.java                    # Demo/showcase book implementation
└── serviceInterfaces.java           # Shipping and mail service utilities
```

## Book Types

### Paper Books
- Physical books with stock management
- Require shipping address for purchase
- Stock decreases with each purchase
- Cannot be purchased if out of stock

### Ebooks
- Digital books with file format specification
- Sent via email after purchase
- No stock limitations
- Available in various formats (PDF, EPUB, etc.)

### Demo Books
- Showcase books not available for purchase
- Price set to $0.00
- Used for display purposes only

## Usage

### Running the Application

```bash
cd src
javac *.java
java QuantumBookstoreFullTest
```

### Sample Output

The application runs comprehensive tests covering:

1. **Adding Books**: Demonstrates adding different book types to inventory
2. **Buying Books**: Shows successful purchases and processing
3. **Removing Outdated Books**: Automatically removes books older than specified threshold
4. **Error Scenarios**: Tests invalid purchase attempts

## Test Results

Below are screenshots showing the complete test execution:

### Initial Test Run and Book Addition
![Test Output Part 1](image1.png)

The first image shows:
- Starting the full test suite
- Adding various book types to inventory
- Current inventory display with book details
- Successful purchase operations with shipping and email notifications

### Cleanup and Error Handling
![Test Output Part 2](image2.png)

The second image demonstrates:
- Removal of outdated books (older than 15 years)
- Updated inventory after cleanup
- Error scenario testing for invalid purchases
- Completion of the full test suite

## Key Features Demonstrated

- **Polymorphism**: Different book types override abstract methods differently
- **Exception Handling**: Comprehensive error management for edge cases
- **Service Integration**: Shipping and email services for different book types
- **Inventory Management**: Real-time stock tracking and updates

## Error Scenarios Covered

1. Attempting to purchase non-existent books
2. Trying to buy showcase/demo books
3. Requesting more stock than available
4. Invalid ISBN handling

## Technical Implementation

- Uses HashMap for efficient book lookup by ISBN
- Implements Iterator pattern for safe removal during iteration
- Demonstrates proper exception handling and custom error messages
- Shows service layer integration for shipping and email functionality

## Future Enhancements

- Database integration for persistent storage
- User authentication and account management
- Advanced search and filtering capabilities
- Order history and tracking
- Payment processing integration
