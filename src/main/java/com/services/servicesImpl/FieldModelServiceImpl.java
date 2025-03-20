package com.services.servicesImpl;

import com.dao.FieldModelDao;
import com.dao.daoImpl.FieldModelDaoImpl;
import com.entities.FieldModel;
import com.entities.FieldModelSubject;
import com.services.FieldModelService;

import java.util.List;

public class FieldModelServiceImpl implements FieldModelService {

    private final FieldModelDao fieldModelDao;

    public FieldModelServiceImpl(){
        fieldModelDao = new FieldModelDaoImpl();
    }

    @Override
    public FieldModel getFieldModelById(int id) {
        return fieldModelDao.getFieldModelById(id);
    }

    @Override
    public FieldModel createFieldModel(FieldModel fieldModel) {
        return fieldModelDao.createFieldModel(fieldModel);
    }

    @Override
    public FieldModel updateFieldModel(FieldModel fieldModel, List<FieldModelSubject> fieldModelSubject) {
        return fieldModelDao.updateFieldModel(fieldModel,fieldModelSubject);
    }

    @Override
    public String deleteFieldModel(int id) {
        return fieldModelDao.deleteFieldModel(id);
    }

    @Override
    public List<FieldModel> getAllFieldModel() {
        return fieldModelDao.getAllFieldModel();
    }
}
