package com.example.spring.datajpa.springdatajpa.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.spring.datajpa.springdatajpa.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

	public List<Student> findByFirstName(String firstname);

	public List<Student> findByFirstNameContaining(String firstname);

	public List<Student> findByLastNameNotNull();

	public List<Student> findByGuardianName(String guardianName);

	public Student findByFirstNameAndLastName(String firstname, String lastname);

	// JPQL it is based on class
	@Query("select s from Student s where s.emailId =?1")
	public Student getStudentByEmail(String email);

	// Native query is based on Database like a normal process
	@Query(value = "select * from student_db where email_address =?1", nativeQuery = true)
	public Student getStudentByEmailNative(String email);

	// Named param
	@Query(value = "select * from student_db where email_address =:email", nativeQuery = true)
	public Student getStudentByEmailNativeNamedParam(@Param("email") String email);

	@Modifying
	@Transactional
	@Query(value = "update student_db set first_name=?1 where email_address=?2", nativeQuery = true)
	int updateFirstNameByEmail(String firstName, String email);
}
