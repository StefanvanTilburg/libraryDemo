package nl.miwgroningen.cohort4.stefanvantilburg.libraryDemo.controller;

import nl.miwgroningen.cohort4.stefanvantilburg.libraryDemo.model.Copy;
import nl.miwgroningen.cohort4.stefanvantilburg.libraryDemo.repository.BookRepository;
import nl.miwgroningen.cohort4.stefanvantilburg.libraryDemo.repository.CopyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author Stefan van Tilburg <s.g.van.tilburg@st.hanze.nl>
 */
@Controller
public class CopyController {

    @Autowired
    CopyRepository copyRepository;

    @Autowired
    BookRepository bookRepository;

    @GetMapping("/copies")
    protected String showCopies(Model model) {
        model.addAttribute("copy", new Copy());
        model.addAttribute("allCopies", copyRepository.findAll());
        model.addAttribute("allBooks", bookRepository.findAll());
        return "copyOverview";
    }

    @PostMapping("/copy/add")
    protected String saveOrUpdateCopy(@ModelAttribute("copy") Copy copy, BindingResult result) {
        if (result.hasErrors()) {
            return "copyOverview";
        } else {
            copyRepository.save(copy);
            return "redirect:/copies";
        }
    }

}
