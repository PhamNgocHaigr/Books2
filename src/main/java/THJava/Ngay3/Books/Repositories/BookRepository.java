package THJava.Ngay3.Books.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import THJava.Ngay3.Books.Models.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
	
}
