package THJava.Ngay3.Books.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
@Entity
@Table(name = "book")
public class Book {
	@Id
	@Column(name = "book_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "title",nullable = false,length = 255)
	private String title;
	@Column(name = "author",nullable = false,length = 255)
	private String author;
	@Column(name = "price")
	private Long price;
	@ManyToOne
	@JoinColumn(name = "category_id",nullable = false)
	private Category category;
	@Column(nullable = true, length = 255)
	private String photourl;
	
	@Transient
	public String getPhotosImagePath() {
		if(photourl == null || id == null)
			return null;
		return "/photos/" + id + "/" + photourl;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public Long getPrice() {
		return price;
	}
	public void setPrice(Long price) {
		this.price = price;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Book(Long id, String title, String author, Long price, Category category) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
		this.price = price;
		this.category = category;
	}
	public String getPhotourl() {
		return photourl;
	}
	public void setPhotourl(String photourl) {
		this.photourl = photourl;
	}
	
	
	
	
}
