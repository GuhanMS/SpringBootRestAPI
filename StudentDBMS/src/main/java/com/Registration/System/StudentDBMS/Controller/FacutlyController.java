package com.Registration.System.StudentDBMS.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Registration.System.StudentDBMS.Model.Facutly;
import com.Registration.System.StudentDBMS.Service.FacutlyService;

@RestController
@RequestMapping("/Facutly")
public class FacutlyController {

	@Autowired
	private FacutlyService facutlyService;
	
	@RequestMapping("")
	public String Home() {
		return "Facutly Home";
	}
	
	@PostMapping("/addFaculty")
	public String addFacutly(@RequestBody Facutly facutly) {
		facutlyService.addFaculty(facutly);
		return "Successfully added";
	}
	
	@RequestMapping("/allFacutly")
	public List<Facutly> allFacutly(){
		List<Facutly> ft = facutlyService.allFacutly();
		return ft ;
	}
}
