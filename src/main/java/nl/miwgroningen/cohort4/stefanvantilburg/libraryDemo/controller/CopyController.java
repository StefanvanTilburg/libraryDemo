package nl.miwgroningen.cohort4.stefanvantilburg.libraryDemo.controller;

import nl.miwgroningen.cohort4.stefanvantilburg.libraryDemo.model.Book;
import nl.miwgroningen.cohort4.stefanvantilburg.libraryDemo.model.Copy;
import nl.miwgroningen.cohort4.stefanvantilburg.libraryDemo.repository.BookRepository;
import nl.miwgroningen.cohort4.stefanvantilburg.libraryDemo.repository.CopyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.Optional;

/**
 * @author Stefan van Tilburg <s.g.van.tilburg@st.hanze.nl>
 */
@Controller
public class CopyController {

    @Autowired
    BookRepository bookRepository;

    @Autowired
    CopyRepository copyRepository;

    @GetMapping("/copy/add/{bookID}")
    protected String addCopy(@PathVariable("bookID") Integer bookID) {
        Optional<Book> OptionalBook = bookRepository.findById(bookID);
        if (OptionalBook.isPresent()) {
            Copy copy = new Copy();
            copy.setBook(OptionalBook.get());
            copyRepository.save(copy);
        }
        return "redirect:/books";
    }
    @GetMapping("/copy/add/t/{bookTitle}")
    protected String addCopy(@PathVariable("bookTitle") String bookTitle) {
        Optional<Book> OptionalBook = bookRepository.findByTitle(bookTitle);
        if (OptionalBook.isPresent()) {
            Copy copy = new Copy();
            copy.setBook(OptionalBook.get());
            copyRepository.save(copy);
        }
        return "redirect:/books";
    }
}
