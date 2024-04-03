package com.example.spring.datajpa.springdatajpa.repo;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.example.spring.datajpa.springdatajpa.entity.Course;
import com.example.spring.datajpa.springdatajpa.entity.Student;
import com.example.spring.datajpa.springdatajpa.entity.Teacher;

@SpringBootTest
class CourseRepositoryTest {

	@Autowired
	private CourseRepository courseRepository;

	@Test
	public void printCourses() {
		List<Course> courses = courseRepository.findAll();
		System.out.println("courses = " + courses);
	}

	@Test
	public void saveCourseWithTeacher() {

		Teacher teacher = Teacher.builder().firstName("Priyanka").lastName("Singh").build();

		Course course = Course.builder().title("Python").credit(6).teacher(teacher).build();

		courseRepository.save(course);

	}

	@Test
	public void findAllPagination() {

		Pageable firstPage = PageRequest.of(0, 2);
		Pageable secondPage = PageRequest.of(0, 4);

		long elementCount = courseRepository.findAll(firstPage).getTotalElements();

		long totalPages = courseRepository.findAll(secondPage).getTotalPages();

		List<Course> courses = courseRepository.findAll(secondPage).getContent();

		System.out.println("elementCount ------------->" + elementCount);
		System.out.println("totalPages ----------->" + totalPages);
		System.out.println("courses ---------------->" + courses);

	}

	@Test
	public void findBySortingAndPagination() {

		Pageable pageable = PageRequest.of(0, 2);

		List<Course> course = courseRepository.findByTitleContaining("J", pageable).getContent();
		System.out.println("course ------------->" + course);
	}

	@Test
	public void findBySorting() {

		Pageable sortByTitle = PageRequest.of(0, 3, Sort.by("title"));

		Pageable sortByCreditDesc = PageRequest.of(0, 2, Sort.by("credit").descending());

		Pageable sortByTitleAndCreditDesc = PageRequest.of(0, 2, Sort.by("title").descending().and(Sort.by("credit")));

		List<Course> courseTitle = courseRepository.findAll(sortByTitle).getContent();
		List<Course> courseCredit = courseRepository.findAll(sortByCreditDesc).getContent();
		List<Course> courseTitleAndCreditDesc = courseRepository.findAll(sortByTitleAndCreditDesc).getContent();

		System.out.println("courses --------------->" + courseTitle);
		System.out.println("courses --------------->" + courseCredit);
		System.out.println("courses --------------->" + courseTitleAndCreditDesc);
	}

	@Test
	public void saveCourseWithStudentAndTeacher() {

		Teacher teacher = Teacher.builder().firstName("Lizze").lastName("Morgan").build();

		Student student = Student.builder().firstName("Abhishek").lastName("Singh").emailId("abhishek@gmail.com")
				.build();

		Course course = Course.builder().title("AI").credit(12).teacher(teacher).build();

		course.addStudent(student);

		courseRepository.save(course);
	}
}
