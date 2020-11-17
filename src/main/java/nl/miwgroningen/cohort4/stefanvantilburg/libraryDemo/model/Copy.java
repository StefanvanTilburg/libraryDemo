package nl.miwgroningen.cohort4.stefanvantilburg.libraryDemo.model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

/**
 * @author Stefan van Tilburg <s.g.van.tilburg@st.hanze.nl>
 */
@Entity
public class Copy {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer copyId;

    private String version;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "bookID", referencedColumnName = "bookID", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Book book;

    public Integer getCopyId() {
        return copyId;
    }

    public void setCopyId(Integer copyId) {
        this.copyId = copyId;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book myBook) {
        this.book = myBook;
    }
}
