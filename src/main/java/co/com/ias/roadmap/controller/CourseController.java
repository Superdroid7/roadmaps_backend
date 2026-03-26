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

    @GetMapping("/{title}")
    public List<Course> getCourseById(@PathVariable String title) {
        return courseRepository.getCoursesBytitle(title);
    }

    @PutMapping("/update/{id}")
    public String updateCourses(@PathVariable int id, @RequestBody Course updatedCourse) {
        courseRepository.updateCourse(id, updatedCourse);
        return "se ha actualizado el curso con exito";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteCourse(@PathVariable int id) {
        courseRepository.deleteCourse(id);
        return "El curso ha sido eliminado del juego.";
    }
}