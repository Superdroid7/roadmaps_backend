package co.com.ias.roadmap.controller;

import co.com.ias.roadmap.model.Course;
import co.com.ias.roadmap.repository.CourseRepository;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api/courses")
@CrossOrigin(origins = "*")
public class CourseController {

    private final CourseRepository courseRepository = new CourseRepository();

    @GetMapping
    public List<Course> getAllCourses() {
        return courseRepository.getAllCourses();
    }

    @PostMapping
    public Course createCourse(@RequestBody Course course) {
        return courseRepository.saveCourse(course);
    }
}