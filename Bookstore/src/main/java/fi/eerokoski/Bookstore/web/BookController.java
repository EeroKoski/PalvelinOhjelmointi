package fi.eerokoski.Bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fi.eerokoski.Bookstore.domain.Book;
import fi.eerokoski.Bookstore.domain.BookRepository;
import fi.eerokoski.Bookstore.domain.CategoryRepository;

@Controller
public class BookController {
	@Autowired
	private BookRepository brepository;
	
	@Autowired
	private CategoryRepository crepository;
	
	@RequestMapping(value="/login")
    public String login() {	
        return "login";
	}
	
    @RequestMapping(value= {"/", "/booklist"})
	public String bookList(Model model) {
		model.addAttribute("books", brepository.findAll());
		return "booklist";
	}
	
	@RequestMapping(value = "/add")
    public String addBook(Model model){
    	model.addAttribute("book", new Book());
    	model.addAttribute("categories", crepository.findAll());
    	return "addbook";
    }     
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(Book book){
        brepository.save(book);
        return "redirect:booklist";
    }    
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    @PreAuthorize("hasRole('ADMIN')")
    public String deleteBook(@PathVariable("id") Long bookId, Model model) {
    	brepository.deleteById(bookId);
        return "redirect:../booklist";
    }     
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String editBook(@PathVariable("id") Long bookId, Model model){
    	model.addAttribute("book", brepository.findById(bookId));
    	model.addAttribute("categories", crepository.findAll());
        return "editbook";
    }         
    
    
}