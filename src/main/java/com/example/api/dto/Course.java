package com.example.api.dto;


public class Course {

    
    private int courseId;
    private String title;
    private String description;
    private String Link;


    public Course() {
    }


    public Course(int courseId, String title, String description, String link) {
        this.courseId = courseId;
        this.title = title;
        this.description = description;
        Link = link;
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseId=" + courseId +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", Link='" + Link + '\'' +
                '}';
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
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

    public String getLink() {
        return Link;
    }

    public void setLink(String link) {
        Link = link;
    }
}
