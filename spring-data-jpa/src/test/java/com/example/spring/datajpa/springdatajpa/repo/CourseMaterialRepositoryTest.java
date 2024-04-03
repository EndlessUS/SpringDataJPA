package com.example.spring.datajpa.springdatajpa.repo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.spring.datajpa.springdatajpa.entity.Course;
import com.example.spring.datajpa.springdatajpa.entity.CourseMaterial;

@SpringBootTest
class CourseMaterialRepositoryTest {

	@Autowired
	private CourseMaterialRepository courseMaterialRepository;

	@Test
	public void saveCourseMaterial() {

		Course course = Course.builder().title("Java").credit(7).build();

		CourseMaterial courseMaterial = CourseMaterial.builder().url("www.google.com").course(course).build();

		courseMaterialRepository.save(courseMaterial);

		System.out.println("CourseMaterial ---------------->" + courseMaterial);
	}

}
