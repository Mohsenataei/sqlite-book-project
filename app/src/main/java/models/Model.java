package models;

public class Model {

    private int ids;
    private String chapters;
    private String titles;
    private String details;

    public int getIds() {
        return ids;
    }

    public void setIds(int ids) {
        this.ids = ids;
    }

    public String getChapters() {
        return chapters;
    }

    public void setChapters(String chapters) {
        this.chapters = chapters;
    }

    public String getTitles() {
        return titles;
    }

    public void setTitles(String titles) {
        this.titles = titles;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public Model(int ids, String chapters, String titles, String details) {
        this.ids = ids;
        this.chapters = chapters;
        this.titles = titles;
        this.details = details;
    }



}
