package com.Registration.System.StudentDBMS.Controller;

import java.util.List;

import org.hibernate.annotations.UpdateTimestamp;
import org.json.JSONObject;
import org.json.simple.JSONValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Registration.System.StudentDBMS.Model.Course;
import com.Registration.System.StudentDBMS.Service.CourseService;
import com.google.gson.Gson;

@RestController
@RequestMapping("/Course")
public class CourseController {

	@Autowired
	private CourseService courseService;
	
	@RequestMapping("")
	public String home() {
		return "Welcome";
	}
	
	@PostMapping("/addCourse")
	public String addCourse(@RequestBody Course course) {
		courseService.addCourse(course);
		return "Successfully added";
	}
	
	@GetMapping("/courseList")
	public List<Course> courseList() {
		List<Course> co = courseService.courseList();
		Gson gson = new Gson(); 
		String str = gson.toJson(co);
		System.out.println(str);
		String str2 = JSONValue.escape(str.substring(1, str.length()-1));
		System.out.println("Escapd Jsn2-->"+ str2);
		
		String jsonString = str.substring(1, str.length()-1);
		JSONObject jsonObject = new JSONObject(jsonString);
		String name = jsonObject.getString("name");
		int id = jsonObject.getInt("id");
		System.out.println(id);
		System.out.println(name);
		return co;
	}
	
//	@PutMapping("/editCourse")
//	public String editCourse(@RequestBody Course course) {
//		courseService.editCourse(course);
//		return "Successfully Updated";
//	}
}
