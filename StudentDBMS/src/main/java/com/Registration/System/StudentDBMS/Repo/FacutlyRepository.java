package com.Registration.System.StudentDBMS.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.Registration.System.StudentDBMS.Model.Facutly;
@Repository
public interface FacutlyRepository extends JpaRepository<Facutly, Long> {

	@Query(value="select * from facutly inner join books on facutly.id=books.id", nativeQuery = true)
	List<Facutly> allFacutly();

}
