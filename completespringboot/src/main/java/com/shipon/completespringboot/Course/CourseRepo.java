package com.shipon.completespringboot.Course;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRepo extends JpaRepository<Course,Integer> {
    public List<Course> findByTopicId(int id);

}
