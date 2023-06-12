package com.Registration.System.StudentDBMS.Service;

import java.util.List;

import org.json.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Registration.System.StudentDBMS.Model.Course;
import com.Registration.System.StudentDBMS.Repo.CourseRepository;

@Service
public class CourseService {

	@Autowired
	private CourseRepository courseRepository;

	public void addCourse(Course course) {
		courseRepository.save(course);
	}
	
	public List<Course> courseList() {
		List<Course> co = courseRepository.courseList();
//		for (Course course : co) {
//			JSONObject jsonObj = new JSONObject(course);
//			System.out.println(jsonObj.toString());
//		}
		return co;
	}

//	public void editCourse(Course course) {
//		courseRepository.updateCourse(course);
//	}
	
}
