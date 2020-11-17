package nl.miwgroningen.cohort4.stefanvantilburg.libraryDemo.controller;

import nl.miwgroningen.cohort4.stefanvantilburg.libraryDemo.model.Book;
import nl.miwgroningen.cohort4.stefanvantilburg.libraryDemo.repository.AuthorRepository;
import nl.miwgroningen.cohort4.stefanvantilburg.libraryDemo.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author Stefan van Tilburg <s.g.van.tilburg@st.hanze.nl>
 *
 * Stuur de views voor Book aan
 */
@Controller
public class BookController {

    // Equivalent van DAO
    @Autowired
    BookRepository bookRepository;

    @Autowired
    AuthorRepository authorRepository;

    // Reageren op GET verzoeken van type book (deze getter haalt een view)
    // moet gebruikt worden met protected keyword
    // returned timeleaf html bestand naam
    @GetMapping({"/", "/books"})
    protected String showBooks(Model model) {
        model.addAttribute("allBooks", bookRepository.findAll());
        return "bookOverview";
    }

    @GetMapping("/books/add")
    protected String showBookForm(Model model) {
        model.addAttribute("book", new Book());
        model.addAttribute("allAuthors", authorRepository.findAll());
        return "bookForm";
    }

    // Dit noem je binding : @ModelAttribute("book") Book book
    // Dat ga je controleren in je BindingResult
    @PostMapping("/books/add")
    protected String saveOrUpdateBook(@ModelAttribute("book") Book book, BindingResult result) {
        if (result.hasErrors()) {
            return "bookForm";
        } else {
            bookRepository.save(book);
            return "redirect:/books";
        }
    }
}
