import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.PostLoad;
import javax.persistence.Transient;



@Entity
public class Book implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "bookId")
	private Integer bookId;
	
	@ManyToOne
	@JoinColumn(name="publisherId" , nullable = false)
	private Publisher publisher;
	
	@Transient
    private transient Book savedState;

    public Book getSavedState() {
		return savedState;
	}

	@PostLoad
    private void saveState(){
    }
	
	
	@ManyToMany
	@JoinTable(
	  name = "authors", 
	  joinColumns = @JoinColumn(name = "authorId"), 
	  inverseJoinColumns = @JoinColumn(name = "bookId"))
	private Set<Author> authors;
	
	@Column(name = "bookname")
	private String bookname;
	
	@Column(name = "price")
	private BigDecimal price;
	
	@Column(name = "publishedDate")
	private BigDecimal publishedDate;

	public Integer getBookId() {
		return bookId;
	}

	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}

	public Publisher getPublisher() {
		return publisher;
	}

	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}

	public Set<Author> getAuthors() {
		return authors;
	}

	public void setAuthors(Set<Author> authors) {
		this.authors = authors;
	}

	public String getBookname() {
		return bookname;
	}

	public void setBookname(String bookname) {
		this.bookname = bookname;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public BigDecimal getPublishedDate() {
		return publishedDate;
	}

	public void setPublishedDate(BigDecimal publishedDate) {
		this.publishedDate = publishedDate;
	}

}
