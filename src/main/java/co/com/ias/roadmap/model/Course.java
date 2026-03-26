package co.com.ias.roadmap.model;

import java.sql.Timestamp;

public class Course {
    private int idCourse;
    private String title;
    private String description;
    private Timestamp dateCreate;

    public Course(){}

    public Course(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public int getIdCourse() {
        return idCourse;
    }
    public void setIdCourse(int idCourse) {
        this.idCourse = idCourse;
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
