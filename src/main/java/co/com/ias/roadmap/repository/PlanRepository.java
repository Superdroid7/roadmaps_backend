package co.com.ias.roadmap.repository;


import co.com.ias.roadmap.model.Plan;

import java.util.ArrayList;
import java.util.List;

public class PlanRepository {

    private List<Plan> planes;

    public PlanRepository() {
        planes = new ArrayList<>();

        planes.add(new Plan(1, "Build de Backend", "Aprende a dominar el backend creando APIs y conectando bases de datos"));
        planes.add(new Plan(2, "Ruta del Maestro Git", "Domina el control de versiones para no romper el juego"));
    }

    public List<Plan> findAll() {
        return planes;
    }

    public void save(Plan newPlan) {
        planes.add(newPlan);
    }

    public void delete(int id) {
        planes.removeIf(plan -> plan.getId() == id);
    }

    public Plan findById(int id) {
        for (Plan plan : planes) {
            if (plan.getId() == id) {
                return plan;
            }
        }
        return null;
    }

    public void update(int id, Plan updatedPlan) {
        for (int i = 0; i < planes.size(); i++) {
            if (planes.get(i).getId() == id) {
                planes.set(i, updatedPlan);
                return;
            }
        }
    }
}
