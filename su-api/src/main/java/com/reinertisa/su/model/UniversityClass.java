package com.reinertisa.su.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "universityClasses")
public class UniversityClass {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "courseId")
    private Integer courseId;

    @Column(name = "professor")
    private String professor;

    @Column(name = "description")
    private String description;

    @JsonBackReference
    @ManyToMany(mappedBy = "universityClasses", fetch = FetchType.LAZY)
    private Set<Student> students = new HashSet<>();

    public boolean addStudent(Student student) {
        return students.add(student);
    }

    public boolean removeStudent(Student student) {
        return students.remove(student);
    }

    public boolean addAllStudents(Set<Student> students) {
        return this.students.addAll(students);
    }

    public void removeAllStudents() {
        students.clear();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "UniversityClass{" +
                "description='" + description + '\'' +
                ", professor='" + professor + '\'' +
                ", courseId=" + courseId +
                ", name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
