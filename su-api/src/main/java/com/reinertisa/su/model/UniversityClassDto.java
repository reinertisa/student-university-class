package com.reinertisa.su.model;


public class UniversityClassDto {
    private Long universityClassId;
    private String universityClassName;
    private Integer courseId;
    private String professor;
    private String description;

    public Long getUniversityClassId() {
        return universityClassId;
    }

    public void setUniversityClassId(Long universityClassId) {
        this.universityClassId = universityClassId;
    }

    public String getUniversityClassName() {
        return universityClassName;
    }

    public void setUniversityClassName(String universityClassName) {
        this.universityClassName = universityClassName;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public String getProfessor() {
        return professor;
    }

    public void setProfessor(String professor) {
        this.professor = professor;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "UniversityClassDto{" +
                "universityClassId=" + universityClassId +
                ", universityClassName='" + universityClassName + '\'' +
                ", courseId=" + courseId +
                ", professor='" + professor + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
