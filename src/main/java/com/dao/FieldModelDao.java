package com.dao;

import com.entities.FieldModel;
import com.entities.FieldModelSubject;

import java.util.List;

public interface FieldModelDao {
    FieldModel getFieldModelById(int id);
    FieldModel createFieldModel(FieldModel fieldModel);
    FieldModel updateFieldModel(FieldModel fieldModel, List<FieldModelSubject> fieldModelSubjects);
    String deleteFieldModel(int id);
    List<FieldModel> getAllFieldModel();
}
