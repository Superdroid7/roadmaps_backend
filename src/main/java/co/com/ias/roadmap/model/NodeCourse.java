package co.com.ias.roadmap.model;


public class NodeCourse {
    private int idNode;
    private int idCourse;

    public NodeCourse(){}

    public NodeCourse(int idNode, int idCourse) {
        this.idNode = idNode;
        this.idCourse = idCourse;
    }

    public int getIdNode() {
        return idNode;
    }
    public void setIdNode(int idNode) {
        this.idNode = idNode;
    }

    public int getIdCourse() {
        return idCourse;
    }
    public void setIdCourse(int idCourse) {
        this.idCourse = idCourse;
    }
}
