package nl.miwgroningen.cohort4.stefanvantilburg.libraryDemo.repository;

import nl.miwgroningen.cohort4.stefanvantilburg.libraryDemo.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author Stefan van Tilburg <s.g.van.tilburg@st.hanze.nl>
 *
 * Haal boeken uit en schrijf boeken naar de database
 */
public interface BookRepository extends JpaRepository<Book, Integer> {
    Optional<Book> findByTitle(String title);
}
