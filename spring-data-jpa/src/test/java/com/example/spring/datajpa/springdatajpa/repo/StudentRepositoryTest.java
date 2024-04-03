package com.example.spring.datajpa.springdatajpa.repo;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.spring.datajpa.springdatajpa.entity.Guardian;
import com.example.spring.datajpa.springdatajpa.entity.Student;

@SpringBootTest
class StudentRepositoryTest {

	@Autowired
	private StudentRepository studentRepository;

	@Test
	public void saveStudent() {

		Student student = Student.builder().firstName("Sabarinathan").lastName("chandrasekar")
				.emailId("sabarisai2000@gmail.com")
//				.guardianName("Rama")
//				.guardianEmail("rama2000@gmail.com")
//				.guardianMobile(7867543290l)
				.build();
		studentRepository.save(student);
	}

	@Test
	public void printAllStudent() {

		List<Student> students = studentRepository.findAll();
	}

	@Test
	public void saveGuardian() {

		Guardian guardian = Guardian.builder().name("Rama").email("rama2000@gmail.com").mobile(7867543290l).build();

		Student student = Student.builder().firstName("BT").lastName("Baskaran").emailId("bt@gmail.com")
				.guardian(guardian).build();

		studentRepository.save(student);
	}

	@Test
	public void findByFirstName() {

		List<Student> student = studentRepository.findByFirstName("BT");
		System.out.println("student" + "------------->" + student);
	}

	@Test
	public void findByFirstNameContaining() {

		List<Student> student = studentRepository.findByFirstNameContaining("S");
		System.out.println("student" + "------------->" + student);
	}

	@Test
	public void findByLastNameNotnull() {

		List<Student> student = studentRepository.findByLastNameNotNull();
		System.out.println("student" + "------------->" + student);
	}

	@Test
	public void findByGuardianName() {

		List<Student> student = studentRepository.findByGuardianName("Rama");
		System.out.println("student" + "------------->" + student);
	}

	@Test
	public void findByFirstNameAndLastName() {

		Student student = studentRepository.findByFirstNameAndLastName("Sabarinathan", "chandrasekar");
		System.out.println("student" + "------------->" + student);
	}

	@Test
	public void getStudentByEmail() {

		Student student = studentRepository.getStudentByEmail("sabarisai2000@gmail.com");
		System.out.println("student" + "------------->" + student);
	}

	@Test
	public void getStudentByEmailNative() {

		Student student = studentRepository.getStudentByEmailNative("sabarisai2000@gmail.com");
		System.out.println("student" + "------------->" + student);
	}

	@Test
	public void getStudentByEmailNativeNamedParam() {

		Student student = studentRepository.getStudentByEmailNativeNamedParam("sabarisai2000@gmail.com");
		System.out.println("student" + "------------->" + student);
	}

	@Test
	public void updateFirstNameByEmail() {

		int student = studentRepository.updateFirstNameByEmail("Sabari", "sabarisai2000@gmail.com");
		System.out.println("student" + "------------->" + student);
	}
}
