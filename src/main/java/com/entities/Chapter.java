package com.entities;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "chapter")
public class Chapter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "chapter_id")
    private Long id;

    private String name;

    @OneToMany(mappedBy = "chapter", cascade = CascadeType.ALL, orphanRemoval = true)
    @Fetch(FetchMode.SUBSELECT)
    // private List<FieldModelSubjectChapter> fieldModelSubjectChapters = new ArrayList<>();
    private List<FieldModelSubjectChapter> fieldModelSubjectChapters = new ArrayList<FieldModelSubjectChapter>();

    public Chapter() {
    }

    public Chapter(Long id, String name, List<FieldModelSubjectChapter> fieldModelSubjectChapters) {
        this.id = id;
        this.name = name;
        this.fieldModelSubjectChapters = fieldModelSubjectChapters;
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

    public List<FieldModelSubjectChapter> getFieldModelSubjectChapters() {
        return fieldModelSubjectChapters;
    }

    public void setFieldModelSubjectChapters(List<FieldModelSubjectChapter> fieldModelSubjectChapters) {
        this.fieldModelSubjectChapters = fieldModelSubjectChapters;
    }

    @Override
    public String toString() {
        return "Chapter{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
