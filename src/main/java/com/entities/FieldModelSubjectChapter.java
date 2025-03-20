package com.entities;


import javax.persistence.*;

@Entity
@Table(name = "field_model_subject_chapter")
public class FieldModelSubjectChapter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "field_model_subject_id", nullable = false)
    private FieldModelSubject fieldModelSubject;

    @ManyToOne
    @JoinColumn(name = "chapter_id",nullable = false)
    private Chapter chapter;

    public FieldModelSubjectChapter() {
    }

    public FieldModelSubjectChapter(Long id, FieldModelSubject fieldModelSubject, Chapter chapter) {
        this.id = id;
        this.fieldModelSubject = fieldModelSubject;
        this.chapter = chapter;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public FieldModelSubject getFieldModelSubject() {
        return fieldModelSubject;
    }

    public void setFieldModelSubject(FieldModelSubject fieldModelSubject) {
        this.fieldModelSubject = fieldModelSubject;
    }

    public Chapter getChapter() {
        return chapter;
    }

    public void setChapter(Chapter chapter) {
        this.chapter = chapter;
    }

    @Override
    public String toString() {
        // return "FieldModelSubjectChapter{" +
        //         "id=" + id +
        //         ", fieldModelSubject=" + fieldModelSubject +
        //         ", chapter=" + chapter +
        //         '}';

        return "FieldModelSubjectChapter{" +
        "id=" + id +
        ", chapter=" + (chapter != null ? chapter.getName() : null) +
        '}';
    }
}
