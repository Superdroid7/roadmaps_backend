package co.com.ias.roadmap.controller;

import co.com.ias.roadmap.model.CourseLink;
import co.com.ias.roadmap.repository.CourseLinkRepository;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api/course-links")
@CrossOrigin(origins = "*")
public class CourseLinkController {

    private final CourseLinkRepository courseLinkRepository = new CourseLinkRepository();

    @GetMapping
    public List<CourseLink> getAllCourseLinks() {
        return courseLinkRepository.getAllCourseLinks();
    }

    @PostMapping
    public CourseLink createCourseLink(@RequestBody CourseLink courseLink) {
        return courseLinkRepository.saveCourseLink(courseLink);
    }
}
