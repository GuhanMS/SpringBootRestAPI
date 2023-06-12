package com.Registration.System.StudentDBMS.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Registration.System.StudentDBMS.Model.Facutly;
import com.Registration.System.StudentDBMS.Repo.FacutlyRepository;

@Service
public class FacutlyService {
	
	@Autowired
	private FacutlyRepository facutlyRepository;

	public void addFaculty(Facutly facutly) {
		facutlyRepository.save(facutly);
	}

	public List<Facutly> allFacutly() {
		List<Facutly> ft = facutlyRepository.allFacutly();
		return ft;
	}

	
}
