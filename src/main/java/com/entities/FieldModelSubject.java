package com.entities;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "field_model_subject")
public class FieldModelSubject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "field_model_id", nullable = false)
    private FieldModel fieldModel;

    @ManyToOne
    @JoinColumn(name = "subject_id", nullable = false)
    private Subject subject;

    @OneToMany(mappedBy = "fieldModelSubject", cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.LAZY)
    @Fetch(FetchMode.JOIN)
    private List<FieldModelSubjectChapter> fieldModelSubjectChapters = new ArrayList<>();

    public FieldModelSubject() {
    }

    public FieldModelSubject(Long id, FieldModel fieldModel, Subject subject, List<FieldModelSubjectChapter> fieldModelSubjectChapters) {
        this.id = id;
        this.fieldModel = fieldModel;
        this.subject = subject;
        this.fieldModelSubjectChapters = fieldModelSubjectChapters;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public FieldModel getFieldModel() {
        return fieldModel;
    }

    public void setFieldModel(FieldModel fieldModel) {
        this.fieldModel = fieldModel;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public List<FieldModelSubjectChapter> getFieldModelSubjectChapters() {
        return fieldModelSubjectChapters;
    }

    public void setFieldModelSubjectChapters(List<FieldModelSubjectChapter> fieldModelSubjectChapters) {
        this.fieldModelSubjectChapters = fieldModelSubjectChapters;
    }

    @Override
    public String toString() {
//        below return is a reason of stackoverflow error
        // return "FieldModelSubject{" +
        //         "id=" + id +
        //         ", fieldModel=" + fieldModel +
        //         ", subject=" + subject +
        //         ", fieldModelSubjectChapters=" + fieldModelSubjectChapters +
        //         '}';

        return "FieldModelSubject{" +
            "id=" + id +
            ", fieldModel=" + (fieldModel != null ? fieldModel.getId() : null) +
            ", subject=" + (subject != null ? subject.getName() : null) +
            '}';
    }
}
