package com.example.spring.datajpa.springdatajpa.repo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.spring.datajpa.springdatajpa.entity.Course;
import com.example.spring.datajpa.springdatajpa.entity.Teacher;

@SpringBootTest
class TeacherRepositoryTest {

	@Autowired
	private TeacherRepository teacherRepository;

	@Test
	public void saveTeacher() {

		Course courseDBA = Course.builder().title("DBA").credit(5).build();

		Course courseJava = Course.builder().title("Java").credit(6).build();

		Teacher teacher = Teacher.builder().firstName("Sabari").lastName("Nathan")
//				.course(List.of(courseDBA, courseJava))
				.build();

		teacherRepository.save(teacher);

	}
	
}
