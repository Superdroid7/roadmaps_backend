package co.com.ias.roadmap.model;



import java.sql.Timestamp;

public class Route {
    private int idRoute;
    private String name;
    private String description;
    private Timestamp dateCreate;

    public  Route(){}

    public Route(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public int getIdRoute() {
        return idRoute;
    }
    public void setIdRoute(int idRoute) {
        this.idRoute = idRoute;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public Timestamp getDateCreate() {
        return dateCreate;
    }
    public void setDateCreate(Timestamp dateCreate) {
        this.dateCreate = dateCreate;
    }
}
