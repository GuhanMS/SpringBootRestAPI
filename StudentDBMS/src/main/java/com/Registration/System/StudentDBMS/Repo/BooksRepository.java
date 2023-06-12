package com.Registration.System.StudentDBMS.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Registration.System.StudentDBMS.Model.Books;

@Repository
public interface BooksRepository extends JpaRepository<Books, Long> {

}
