package co.com.ias.roadmap.controller;

import co.com.ias.roadmap.model.Link;
import co.com.ias.roadmap.repository.LinkRepository;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api/links")
@CrossOrigin(origins = "*")
public class LinkController {

    private final LinkRepository linkRepository = new LinkRepository();

    @GetMapping
    public List<Link> getinks() {
        return linkRepository.getAllLinks();
    }

    @PostMapping
    public Link createLink(@RequestBody Link link) {
        return linkRepository.saveLink(link);
    }
}
