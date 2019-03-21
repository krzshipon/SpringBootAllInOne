package com.shipon.completespringboot.Course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CourseService {
    @Autowired
    private CourseRepo repo;

    public List<Course> getAllCourses(int id){
        List<Course> courses = new ArrayList<>();
        repo.findByTopicId(id).forEach(courses::add);

        return courses;
    }

    public Optional<Course> getCourse(int id) {
        return repo.findById(id);
    }


    public Course addCourse(Course course) {
        repo.save(course);
        return course;
    }
    public Optional<Course> updateCourse(Course course) {
        repo.save(course);
        return repo.findById(course.getId());
    }

    public void deleteCourse(Course course) {
        repo.delete(course);
    }
}
