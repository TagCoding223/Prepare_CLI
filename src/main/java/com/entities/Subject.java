package com.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "subject")
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "subject", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<FieldModelSubject> fieldModelSubjects = new ArrayList<>();

    public Subject() {
    }

    public Subject(Long id, String name, List<FieldModelSubject> fieldModelSubjects) {
        this.id = id;
        this.name = name;
        this.fieldModelSubjects = fieldModelSubjects;
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

    public List<FieldModelSubject> getFieldModelSubjects() {
        return fieldModelSubjects;
    }

    public void setFieldModelSubjects(List<FieldModelSubject> fieldModelSubjects) {
        this.fieldModelSubjects = fieldModelSubjects;
    }

    @Override
    public String toString() {
        // return "Subject{" +
        //         "id=" + id +
        //         ", name='" + name + '\'' +
        //         ", fieldModelSubjects=" + fieldModelSubjects +
        //         '}';

        return "Subject{" +
            "id=" + id +
            ", name='" + name + '\'' +
            '}';
    }
}
