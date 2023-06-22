package THJava.Ngay3.Books.Services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import THJava.Ngay3.Books.Models.Book;
import THJava.Ngay3.Books.Repositories.BookRepository;

@Service
@Transactional
public class BookServices {
	@Autowired
	private BookRepository bookRepository;
	
	public List<Book> listAll() {
		return bookRepository.findAll();
	}
	
	public Book save(Book product) {
		bookRepository.save(product);
		return product;
	}
	
	public Book get(long id) {
		return bookRepository.findById(id).get();
	}
	
	public void delete(long id) {
		bookRepository.deleteById(id);
	}
}
