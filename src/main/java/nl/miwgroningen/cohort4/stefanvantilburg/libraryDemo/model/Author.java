package nl.miwgroningen.cohort4.stefanvantilburg.libraryDemo.model;

import javax.persistence.*;
import java.util.List;

/**
 * @author Stefan van Tilburg <s.g.van.tilburg@st.hanze.nl>
 */
@Entity
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer AuthorId;

    private String name;

    @OneToMany(mappedBy = "author")
    private List<Book> myBooks;

    public Integer getAuthorId() {
        return AuthorId;
    }

    public void setAuthorId(Integer authorId) {
        AuthorId = authorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberOfBooks() {
        return myBooks.size();
    }
}
