package com.example.spring.datajpa.springdatajpa.repo;

import org.springframework.data.domain.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.spring.datajpa.springdatajpa.entity.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {

	Page<Course> findByTitleContaining(String title, Pageable pageable);
}
