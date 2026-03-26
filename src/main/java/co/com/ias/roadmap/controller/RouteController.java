package co.com.ias.roadmap.controller;

import co.com.ias.roadmap.model.Route;
import co.com.ias.roadmap.repository.RouteRepository;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api/routes")
@CrossOrigin(origins = "*")
public class RouteController {

    private final RouteRepository routeRepository = new RouteRepository();

    @GetMapping
    public List<Route> getRoutes() {
        return routeRepository.getAllRoutes();
    }

    @PostMapping
    public Route createRoute(@RequestBody Route route) {
        return routeRepository.saveRoute(route);
    }
}