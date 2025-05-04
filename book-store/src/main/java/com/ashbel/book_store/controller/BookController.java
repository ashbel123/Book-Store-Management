package com.ashbel.book_store.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ashbel.book_store.entity.Book;
import com.ashbel.book_store.entity.MyBook;
import com.ashbel.book_store.service.MyBookService;
import com.ashbel.book_store.service.bookService;

@Controller
public class BookController {
	
	@Autowired
	bookService bService;
	
	@Autowired
	MyBookService myBService;
	
	@GetMapping("/")
	public String home() {
		return "home";
	}
	
	@GetMapping("/book_register")
	public String bookRegister() {
		return "bookRegister";
	}
	

	@GetMapping("/mybooks")
	public String myBooks( Model model) {
		List<MyBook> list= myBService.getMyBooks();
		// spring automatically associates the model attributes to the view name.
		model.addAttribute("myBook", list);
		return "myBook";
		
	}
	
	
	/**
	 * @return
	 */
	@GetMapping("/books")
	// ModelAndView is used to send data from controller to view.
	public ModelAndView allBooks() {
		List<Book> list= bService.getAllBooks();
//		ModelAndView m= new ModelAndView();
//		m.setViewName("bookList");
//		m.addObject("book",list);
//		return m;
		
		return new ModelAndView("bookList", "book", list);
		
	}
	
	@PostMapping("/save")
	   // @Model Attribute gets data from view to controller.
	public String addBook( @ModelAttribute Book b) {
		bService.save(b);
		return "redirect:/books";
	}
	
	@RequestMapping("/mylist/{id}")
	public String getMyList(@PathVariable("id") int id) {
		Book b = bService.getBookById(id);
		MyBook mb= new MyBook(b.getId(),b.getName(), b.getAuthor(),b.getPrice());
		myBService.saveMyBooks(mb);
		return "redirect:/mybooks";
		
	}
	
	// delete the available books
	@RequestMapping("/delete/{id}")
	public String deleteBook(@PathVariable("id") int id) {
		bService.deleteById(id);
		return "redirect:/books";
	}
	
	// delete the My books
		@RequestMapping("/delete/mybook/{id}")
		public String deleteMyBook(@PathVariable("id") int id) {
			myBService.deleteById(id);
			return "redirect:/mybooks";
		}
		
	// edit the available books
		@RequestMapping("/edit/{id}")
		public String editBook(@PathVariable("id") int id, Model model) {
			Book b = bService.getBookById(id);
			model.addAttribute("book", b);
			return "editBook";
		}
		
//		@RequestMapping("/search")
//		public ModelAndView searchBooks(@RequestParam("keyword") String keyword) {
//		    List<Book> result = bService.searchByKeyword(keyword);
//		    return new ModelAndView("bookList", "book", result);
//		}
		
		@GetMapping("/search")
		public ModelAndView searchBooks(@RequestParam(value = "keyword", required = false) String keyword) {
		    List<Book> result;
		    
		    if (keyword == null || keyword.trim().isEmpty()) {
		        result = bService.getAllBooks(); // return all books if keyword is empty
		    } else {
		        result = bService.searchByKeyword(keyword);
		    }

		    ModelAndView mav = new ModelAndView("bookList");
		    mav.addObject("book", result);
		    mav.addObject("keyword", keyword); // for repopulating the search box
		    return mav;
		}

}
