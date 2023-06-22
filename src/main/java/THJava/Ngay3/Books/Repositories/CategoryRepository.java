package THJava.Ngay3.Books.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import THJava.Ngay3.Books.Models.Category;
public interface CategoryRepository extends JpaRepository<Category, Long> {

}
