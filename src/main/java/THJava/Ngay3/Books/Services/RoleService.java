package THJava.Ngay3.Books.Services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import THJava.Ngay3.Books.Models.Role;
import THJava.Ngay3.Books.Repositories.RoleRepository;

@Service
@Transactional
public class RoleService {
	@Autowired
	private RoleRepository roleRepository;

	public List<Role> listAll() {
		return roleRepository.findAll();
	}
	
	public void save( Role role ) {
		roleRepository.save(role);
	}

	public Role get(long id) {
		return roleRepository.findById(id).orElse(null);
	}

	public void delete(long id) {
		roleRepository.deleteById(id);
	}
	
	public Role getbyName(String roleName) {
	    return roleRepository.findRoleByName(roleName);
	  };
	  }

