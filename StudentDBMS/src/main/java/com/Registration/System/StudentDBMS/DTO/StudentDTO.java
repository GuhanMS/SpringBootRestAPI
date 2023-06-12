package com.Registration.System.StudentDBMS.DTO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;

import com.Registration.System.StudentDBMS.Model.Student;

public class StudentDTO {
	
//	EntityManagerFactory emf=Persistence.createEntityManagerFactory("student");  
//    EntityManager em=emf.createEntityManager();
//    
//    @Transactional
//    @Modifying
//    public List<Student> allStudent() {
//    	String sql = "select * from student";
//    	em.create
//    	
//    	List<Student> st = 
//		return null;
//	} 
//@Transactional
//@Modifying
//	public Student addStudent(Student student) {
//		em.createNativeQuery("INSERT into student(name,email,department) VALUES (?,?,?)")
//		.setParameter(1, student.getName())
//		.setParameter(2, student.getEmail())
//		.setParameter(3, student.getDepartment())
//		.executeUpdate();		
//		return student;
//	}
}