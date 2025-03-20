package com.entities;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "field_model")
public class FieldModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "fieldModel", cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.EAGER)
    @Fetch(FetchMode.SUBSELECT)
    // private List<FieldModelSubject> fieldModelSubjects = new ArrayList<FieldModelSubject>(); //
    /*
     * Both fieldModelSubjects and fieldModelSubjectChapters are List collections, and Hibernate is trying to fetch them eagerly using JOIN. This results in the MultipleBagFetchException.
     * Hibernate does not have this limitation with Set. Change the List to Set in your entities:
     * If you want to keep List, you can use FetchMode.SUBSELECT instead of FetchMode.JOIN. This fetches the collections in separate queries, avoiding the issue:
     */
    private List<FieldModelSubject> fieldModelSubjects = new ArrayList<FieldModelSubject>();

    public FieldModel() {
    }

    public FieldModel(Long id, String name, List<FieldModelSubject> fieldModelSubjects) {
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
        return "FieldModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", fieldModelSubjects=" + fieldModelSubjects +
                '}';
    }
}
