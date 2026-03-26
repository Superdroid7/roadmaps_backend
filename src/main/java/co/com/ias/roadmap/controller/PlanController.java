package co.com.ias.roadmap.controller;

import co.com.ias.roadmap.model.Plan;
import co.com.ias.roadmap.repository.PlanRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/planes")
public class PlanController {

    private PlanRepository planRepository = new PlanRepository();

    @GetMapping
    public List<Plan> getAllPlanes() {
        return planRepository.findAll();
    }

    @PostMapping
    public String createPlan(@RequestBody Plan newPlan) {
        planRepository.save(newPlan);
        return "¡Nuevo plan de estudio forjado con éxito: " + newPlan.getTitle() + "!";
    }

    @DeleteMapping("/{id}")
    public String deletePlan(@PathVariable int id) {
        planRepository.delete(id);
        return "El plan ha sido eliminado de los registros.";
    }

    @GetMapping("/{id}")
    public Plan getPlanById(@PathVariable int id) {
        return planRepository.findById(id);
    }

    @PutMapping("/{id}")
    public String updatePlan(@PathVariable int id, @RequestBody Plan updatedPlan) {
        planRepository.update(id, updatedPlan);
        return "¡El plan de estudio ha subido de nivel y fue actualizado!";
    }
}
