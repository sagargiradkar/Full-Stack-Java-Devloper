package controller;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    // In-memory list to simulate a database
    private final List<Book> books = new ArrayList<>();

    // GET: Retrieve all books
    @GetMapping
    public List<Book> getAllBooks() {
        return books;
    }

    // GET: Retrieve a book by ID
    @GetMapping("/{id}")
    public Book getBookById(@PathVariable int id) {
        return books.stream()
                .filter(book -> book.getId() == id)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Book not found with ID: " + id));
    }

    // POST: Add a new book
    @PostMapping
    public String addBook(@RequestBody Book book) {
        books.add(book);
        return "Book added successfully!";
    }

    // PUT: Update an existing book
    @PutMapping("/{id}")
    public String updateBook(@PathVariable int id, @RequestBody Book updatedBook) {
        Book book = books.stream()
                .filter(b -> b.getId() == id)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Book not found with ID: " + id));

        book.setTitle(updatedBook.getTitle());
        book.setAuthor(updatedBook.getAuthor());
        return "Book updated successfully!";
    }

    // DELETE: Delete a book by ID
    @DeleteMapping("/{id}")
    public String deleteBook(@PathVariable int id) {
        books.removeIf(book -> book.getId() == id);
        return "Book deleted successfully!";
    }
}
