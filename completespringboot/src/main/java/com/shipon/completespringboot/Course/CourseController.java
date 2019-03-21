package com.shipon.completespringboot.Course;

import com.shipon.completespringboot.topic.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CourseController {
    @Autowired
    private CourseService courseService;

    @GetMapping("/topics/{id}/courses")
    public List<Course> getAllCourse(@PathVariable int id){
        return courseService.getAllCourses(id);
    }

    @GetMapping("/topics/{topicId}/courses/{id}")
    public Optional<Course> getCourse(@PathVariable int id){
        return courseService.getCourse(id);
    }

    @PostMapping("/topics/{topicId}/courses")
    public Course addCourse(@RequestBody Course course,@PathVariable int topicId){
        course.setTopic(new Topic(topicId,"",""));
        courseService.addCourse(course);
        return course;
    }
    @PutMapping("/topics/{topicId}/courses/{id}")
    public Optional<Course> updateCourse(@RequestBody Course course,@PathVariable int topicId){
        course.setTopic(new Topic(topicId,"",""));
        Optional<Course> topic1= courseService.updateCourse(course);
        return topic1;
    }

    @DeleteMapping("/topics/course")
    public String deleteCourse(@RequestBody Course course){
        courseService.deleteCourse(course);
        return "removed";
    }
}
