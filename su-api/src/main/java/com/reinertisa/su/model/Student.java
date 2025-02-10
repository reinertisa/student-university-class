package com.reinertisa.su.model;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String studentId;

    @Column(nullable = false)
    private String email;

    @ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable(
            name = "studentUniversityClassAssoc",
            joinColumns = {@JoinColumn(name = "studentId")},
            inverseJoinColumns = {@JoinColumn(name = "universityClassId")}
    )
    private Set<UniversityClass> universityClasses = new HashSet<>();

    public boolean addUniversityClass(UniversityClass universityClass) {
        return universityClasses.add(universityClass);
    }

    public boolean removeUniversityClass(UniversityClass universityClass) {
        return universityClasses.remove(universityClass);
    }

    public boolean addUniversityClasses(Set<UniversityClass> universityClasses) {
        return this.universityClasses.addAll(universityClasses);
    }

    public void removeAllUniversityClasses() {
        universityClasses.clear();
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

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<UniversityClass> getUniversityClasses() {
        return universityClasses;
    }

    public void setUniversityClasses(Set<UniversityClass> universityClasses) {
        this.universityClasses = universityClasses;
    }

    @Override
    public String toString() {
        return "Student{" +
                "email='" + email + '\'' +
                ", studentId='" + studentId + '\'' +
                ", name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
