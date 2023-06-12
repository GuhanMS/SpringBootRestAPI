package com.Registration.System.StudentDBMS.Repo;

import java.util.List;

import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.Registration.System.StudentDBMS.Model.Student;

@Service
public interface StudentRepository extends JpaRepository<Student, Long> {

	@Query(value="SELECT * FROM student.student where id = ?1",nativeQuery=true)
	Student findById(@Param("id") int id);
	
	@Query(value="select * from student.student", nativeQuery = true)
	List<Student> allStudent();
	
	@Modifying
	@Transactional
	@Query(value="Update student set name = :name, email = :email, department = :department where id = :id",nativeQuery=true)
	Integer editUpdate(@Param("name")String name, @Param("email")String email, @Param("department")String department, @Param("id")int id);

	@Query(value="delete from student where id=?1", nativeQuery = true)
	Integer deleteStudent(@Param("id") int id);
	
	@Query(value="select * from student inner join course on student.id=course.student_id", nativeQuery = true)
	List<Student> UnionCourse();

	@Query(value="call student.studentList()", nativeQuery = true)
	List<Student> callStored();

	@Query(value="SELECT * FROM student where exists(select * from student where name is not null)", nativeQuery = true)
	List<Student> queryCheck();
	
}