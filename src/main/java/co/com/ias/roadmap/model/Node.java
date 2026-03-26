package co.com.ias.roadmap.model;

import java.sql.Timestamp;

public class Node {
    private Integer idNode;
    private Integer idRoute;
    private Integer idNodeType;
    private String title;
    private String description;
    private Timestamp dateCreate;

    public Node(){}

    public Integer getIdNode() {
        return idNode;
    }
    public void setIdNode(Integer idNode) {
        this.idNode = idNode;
    }

    public Integer getIdRoute() {
        return idRoute;
    }
    public void setIdRoute(Integer idRoute) {
        this.idRoute = idRoute;
    }

    public Integer getIdNodeType() {
        return idNodeType;
    }
    public void setIdNodeType(Integer idNodeType) {
        this.idNodeType = idNodeType;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
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
