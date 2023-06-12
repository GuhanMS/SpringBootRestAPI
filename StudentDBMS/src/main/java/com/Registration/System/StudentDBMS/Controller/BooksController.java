package com.Registration.System.StudentDBMS.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Registration.System.StudentDBMS.Model.Books;
import com.Registration.System.StudentDBMS.Service.BooksService;

@RestController
@RequestMapping("/Books")
public class BooksController {

	@Autowired
	private BooksService booksService;
	@RequestMapping("")
	public String Home() {
		return "Book Home";
	}
	
	@PostMapping("/addBooks")
	public String addBooks(@RequestBody Books books) {
		booksService.addBooks(books);
		return "Successfully added";
	}
}