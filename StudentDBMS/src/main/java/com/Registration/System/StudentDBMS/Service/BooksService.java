package com.Registration.System.StudentDBMS.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Registration.System.StudentDBMS.Model.Books;
import com.Registration.System.StudentDBMS.Repo.BooksRepository;

@Service
public class BooksService {

	@Autowired
	private BooksRepository booksRepository;
	
	public void addBooks(Books books) {
		booksRepository.save(books);
	}
}