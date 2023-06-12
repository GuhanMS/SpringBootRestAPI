package com.Registration.System.StudentDBMS.Controller;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Base64.Encoder;
import java.util.Iterator;
import java.util.List;

import org.json.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.JSONValue;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Registration.System.StudentDBMS.Model.Student;
import com.Registration.System.StudentDBMS.Service.StudentService;
import com.google.gson.Gson;
import com.google.gson.JsonArray;

@Controller
@RequestMapping("/Student")
public class StudentController {
		
		@Autowired
		private StudentService studentService;
		
	@RequestMapping("")
	public String Home() {
		return "Home";
	}
	
	@PostMapping("AddStudent")
	public String AddStudent(@RequestBody Student student) {
		Student st = studentService.addStudent(student);
		System.out.println(st);
		return "Successfully added";
	}
	
	@GetMapping("StudentList")
	public List<Student> AllStudent() throws UnsupportedEncodingException{
		List<Student> st = studentService.allStudent();
		Gson gson = new Gson(); 
		String str = gson.toJson(st);
		String str2 = JSONValue.escape(str.substring(1, str.length()-1));
		
//		String encodeStr = URLEncoder.encode(str, "UTF-8");
//		System.out.println(encodeStr);
//		String decodeStr = URLDecoder.decode(encodeStr, "UTF-8");
//		System.out.println(decodeStr);
		
		String jsonString = str.substring(1, str.length()-1);
		JSONObject jsonObject = new JSONObject(jsonString);
		
		org.json.JSONArray name = jsonObject.getJSONArray("course");
		System.out.println(name);
		
		return st;
	}
	
	@GetMapping("{id}")
	public Student findById(@PathVariable int id){
		Student st = studentService.studentById(id);
		try {
			if(st != null) {
				System.out.println("Successfully found the details");
				return st;
			}else {
				System.out.println("Please enter the valid ID");
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return st;
	}
		
	@PutMapping("/EditStudent/{id}")
	public String editStudent(@RequestBody Student student, @PathVariable int id){
		try {
			System.out.println("Entered student details-->" + student.toString());
			Student st = studentService.editStudent(student, id);
			return "Updated Successfully";
		} catch (Exception e) {
			System.out.println(e);
			return "Not Updated yet";
		}
	}
	
	@GetMapping("/UnionCourse")
	public List<Student> UnionCourse(){
		List<Student> st = studentService.UnionCourse();
		return st;
	}
	
	@DeleteMapping("/DeleteStudent/{id}")
	public String deleteStudent(@PathVariable int id) {
		Student st = studentService.deleteStudent(id);
		return "Successfully deleted";
	}
	
	@GetMapping("/callStored")
	public List<Student> callStored() {
		List<Student> st = studentService.callStored();
		return st;		
	}
	@RequestMapping("/")
	public List<Student> QueryCheck() {
		List<Student> st = studentService.queryCheck();
		for (Student student : st) {
			System.out.println(student);
		}
		return st;
	}

	@GetMapping("**")
	public String invalidUrl() {
		return "404 Page not Found!!!";
	}
}