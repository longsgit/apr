package com.herbalife.springbootlab02jdbc.model;

public class Topic {
    private int id;
    private String title;
    private int duration;

    public Topic(int id, String title, int duration) {
        this.id = id;
        this.title = title;
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "Topic{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", duration=" + duration +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}
