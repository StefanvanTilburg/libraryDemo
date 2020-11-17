package nl.miwgroningen.cohort4.stefanvantilburg.libraryDemo.repository;

import nl.miwgroningen.cohort4.stefanvantilburg.libraryDemo.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Integer> {
}
