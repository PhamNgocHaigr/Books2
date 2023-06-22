package THJava.Ngay3.Books.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import THJava.Ngay3.Books.Models.Role;


public interface RoleRepository extends JpaRepository<Role, Long>{
	Role findRoleByName(String name);
}
