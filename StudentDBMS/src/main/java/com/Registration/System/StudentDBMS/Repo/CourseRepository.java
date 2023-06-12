package com.Registration.System.StudentDBMS.Repo;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.Registration.System.StudentDBMS.Model.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {

//	@Query(value="select * from course inner join student on course.student_id=student.id;",nativeQuery = true)
	@Query(value="select * from student.course",nativeQuery = true)
	List<Course> courseList();

//	@Transactional
//	@Modifying
//	@Query(value="update course set name = :name, description = :description,")
//	void updateCourse(Course course);
	
	
}
