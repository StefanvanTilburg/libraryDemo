package nl.miwgroningen.cohort4.stefanvantilburg.libraryDemo.repository;

import nl.miwgroningen.cohort4.stefanvantilburg.libraryDemo.model.Copy;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CopyRepository extends JpaRepository<Copy, Integer> {
}
