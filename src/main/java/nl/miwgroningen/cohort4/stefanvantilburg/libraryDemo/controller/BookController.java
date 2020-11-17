package nl.miwgroningen.cohort4.stefanvantilburg.libraryDemo.controller;

import nl.miwgroningen.cohort4.stefanvantilburg.libraryDemo.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

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

    // Reageren op GET verzoeken van type book (deze getter haalt een view)
    // moet gebruikt worden met protected keyword
    // returned timeleaf html bestand naam
    @GetMapping({"/", "/books"})
    protected String showBooks(){
        return "bookOverview";
    }
}
