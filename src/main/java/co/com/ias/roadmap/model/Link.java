package co.com.ias.roadmap.model;


import java.sql.Timestamp;

public class Link {
    private int idLink;
    private String title;
    private String url;
    private Timestamp dateCreate;

    public Link() {}

    public Link(String title, String url) {
        this.title = title;
        this.url = url;
    }

    public int getIdLink() {
        return idLink;
    }
    public void setIdLink(int idLink) {
        this.idLink = idLink;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }

    public Timestamp getDateCreate() {
        return dateCreate;
    }
    public void setDateCreate(Timestamp dateCreate) {
        this.dateCreate = dateCreate;
    }
}
