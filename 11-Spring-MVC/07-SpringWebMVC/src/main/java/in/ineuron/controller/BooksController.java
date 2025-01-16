package in.ineuron.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import in.ineuron.binding.Books;

@Controller
public class BooksController {

    @GetMapping("/booksForm")
    public String showBooksForm(Model model) {
        model.addAttribute("book", new Books()); // Add an empty `Books` object to the model
        return "books-form";
    }

    @PostMapping("/saveBook")
    public String saveBook(@ModelAttribute("book") Books book, Model model) {
        model.addAttribute("message", "Book details submitted successfully!");
        return "books-result";
    }
}
