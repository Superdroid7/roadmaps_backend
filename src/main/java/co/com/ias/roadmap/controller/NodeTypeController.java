package co.com.ias.roadmap.controller;

import co.com.ias.roadmap.model.NodeType;
import co.com.ias.roadmap.repository.NodeTypeRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RestController
@RequestMapping("/api/node-types")
@CrossOrigin(origins = "*")
public class NodeTypeController {

    private final NodeTypeRepository nodeTypeRepository = new NodeTypeRepository();

    @GetMapping
    public List<NodeType> getAllNodeTypes() {
        return nodeTypeRepository.getAllNodeType();
    }
}