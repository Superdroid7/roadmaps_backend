package co.com.ias.roadmap.model;

public class NodeType {

    private int idNodeType;
    private String name;

    public NodeType() {
    }

    public NodeType(int idNodeType, String name) {
        this.idNodeType = idNodeType;
        this.name = name;
    }


    public int getIdNodeType() {
        return idNodeType;
    }
    public void setIdNodeType(int idNodeType) {
        this.idNodeType = idNodeType;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}