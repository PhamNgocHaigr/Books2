package THJava.Ngay3.Books.Controllers;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import THJava.Ngay3.Books.Models.Book;
import THJava.Ngay3.Books.Services.BookServices;
import THJava.Ngay3.Books.Services.CategoryService;
import THJava.Ngay3.Books.Utils.FileUploadUtil;

@Controller
@RequestMapping("/books")

public class BookController {
	@Autowired
	private BookServices services;
	@GetMapping
	public String viewAllBook(Model model) {
		List<Book> listBook = services.listAll();
		model.addAttribute("books",listBook);
		return "book/index";
	}
	
	@Autowired
	private  CategoryService categoryService;
	
	@GetMapping("/new")
	public String showNewBookPage(Model model) {
		Book book = new Book();
		model.addAttribute("book",book);
		model.addAttribute("categories", categoryService.listAll());
		return "book/create";
	}
	
	@PostMapping("/save")
	public String saveBook(@ModelAttribute("book") Book book,@RequestParam("image") MultipartFile multipartFile) throws IOException {
		String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
		book.setPhotourl(fileName);
		Book saveBook = services.save(book);
		if (!multipartFile.getOriginalFilename().isBlank())
        {
            String uploadDir = "photos/" + saveBook.getId();
            FileUploadUtil.saveFile(uploadDir,fileName,multipartFile);
        }
		return "redirect:/books";
	}
	
	@GetMapping("/edit/{id}")
	public String showEditBookPage(@PathVariable("id") Long id, Model model) {
		Book book = services.get(id);
		
		if(book==null) {
			return "not-found";
		}else {
			model.addAttribute("categories", categoryService.listAll());
			model.addAttribute("book",book);
			return "book/edit";
		}
	}
	
	@GetMapping("/delete/{id}")
	public String deleteBook(@PathVariable("id") Long id) {
		Book book = services.get(id);
		
		if(book==null) {
			return "not-found";
		}else {
			services.delete(id);
			return "redirect:/books";
		}
		
	}
	
	

}
