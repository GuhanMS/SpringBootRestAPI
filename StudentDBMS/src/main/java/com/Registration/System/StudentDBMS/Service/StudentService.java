package com.Registration.System.StudentDBMS.Service;

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.hibernate.SessionFactory;
import org.json.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.JSONValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.provider.HibernateUtils;
import org.springframework.stereotype.Service;

import com.Registration.System.StudentDBMS.DTO.StudentDTO;
import com.Registration.System.StudentDBMS.Model.Student;
import com.Registration.System.StudentDBMS.Repo.StudentRepository;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonAnyFormatVisitor;


@Service
public class StudentService {
	
	@Autowired
	private StudentRepository studentRepository;
	
//	SessionFactory sessionFactory = HibernateUtils. 
	public Student addStudent(Student student) {
		Student st = studentRepository.save(student);
		return st;
	}

	public List<Student> allStudent() {
		List<Student> st = studentRepository.allStudent();
//		for (Student student : st) {
//			JSONObject jsonObj = new JSONObject(student);
//			System.out.println(jsonObj.toString());
//		}
		return st;
	}

	public Student studentById(int id) {
		Student st = studentRepository.findById(id);
		System.out.println(st);
		return st;
	}

	public Student editStudent(Student student, int id) {
		Student st = studentRepository.findById(id);
		System.out.println("recovered student details-->" + st);
		System.out.println("EnterId" + id);
		System.out.println("RecoveredId" + st.getId());
		if(st.getId() != id) {
			System.out.println("Please check the Id" + st);
		}else {
//		st.setName(student.getName());
//		st.setEmail(student.getEmail());
//		st.setDepartment(student.getDepartment());
//		studentRepository.save(st);
		studentRepository.editUpdate(student.getName(), student.getEmail(), student.getDepartment(), id);
		}
		return st;
	}

	public Student deleteStudent(int id) {
		Student std = studentRepository.findById(id);
		System.out.println("Deleted student details" + std);
//		studentRepository.delete(std);
		studentRepository.deleteStudent(id);
		return null;
	}
	
	public List<Student> UnionCourse() {
		List<Student> st = studentRepository.UnionCourse();
//		for (Student student : st) {
//			System.out.println(student);
//		}
		return st;	
	}

	public List<Student> callStored() {
		List<Student> st = studentRepository.callStored();
		System.out.println(st);
		return st;
	}

	public List<Student> queryCheck() {
		List<Student> st = studentRepository.queryCheck();
		return st;
	}
}