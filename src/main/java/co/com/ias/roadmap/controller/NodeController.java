package co.com.ias.roadmap.controller;

import co.com.ias.roadmap.model.Node;
import co.com.ias.roadmap.repository.NodeRepository;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api/nodes")
@CrossOrigin(origins = "*")
public class NodeController {

    private final NodeRepository nodeRepository = new NodeRepository();

    @GetMapping
    public List<Node> getAllNodes() {
        return nodeRepository.getNodes();
    }

    @PostMapping
    public Node createNode(@RequestBody Node node) {

        if (node.getIdNodeType() == 0) {
            node.setIdNodeType(1);
        }

        return nodeRepository.createNode(node);
    }
}