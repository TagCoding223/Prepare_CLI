package com.services;

import com.entities.FieldModel;
import com.entities.FieldModelSubject;

import java.util.List;

public interface FieldModelService {
    FieldModel getFieldModelById(int id);
    FieldModel createFieldModel(FieldModel fieldModel);
    FieldModel updateFieldModel(FieldModel fieldModel, List<FieldModelSubject> fieldModelSubjects);
    String deleteFieldModel(int id);
    List<FieldModel> getAllFieldModel();
}
