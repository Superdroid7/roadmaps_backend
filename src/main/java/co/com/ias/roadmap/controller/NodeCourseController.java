package co.com.ias.roadmap.controller;

import co.com.ias.roadmap.model.NodeCourse;
import co.com.ias.roadmap.repository.NodeCourseRepository;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api/nodecourses")
@CrossOrigin(origins = "*")
public class NodeCourseController {

    private final NodeCourseRepository nodeCourseRepository = new NodeCourseRepository();

    @GetMapping
    public List<NodeCourse> getAllNodeCourses() {
        return nodeCourseRepository.getAllNodeCourses();
    }

    @PostMapping
    public NodeCourse createNodeCourse(@RequestBody NodeCourse nodeCourse) {
        return nodeCourseRepository.saveNodeCourse(nodeCourse);
    }
}
